package com.ashish.cactus.school.admin.services;

import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.Address;
import com.ashish.cactus.school.admin.db.model.LicenseDetail;
import com.ashish.cactus.school.admin.db.model.AdminRoleMaster;
import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.model.SchoolUser;
import com.ashish.cactus.school.admin.db.model.User;
import com.ashish.cactus.school.admin.db.model.AdminUserRole;
import com.ashish.cactus.school.admin.db.repositories.AddressRepository;
import com.ashish.cactus.school.admin.db.repositories.LicenseDetailRepository;
import com.ashish.cactus.school.admin.db.repositories.ModuleMasterRepository;
import com.ashish.cactus.school.admin.db.repositories.ModulePermissionRepository;
import com.ashish.cactus.school.admin.db.repositories.RoleRepository;
import com.ashish.cactus.school.admin.db.repositories.SchoolMasterRepository;
import com.ashish.cactus.school.admin.db.repositories.SchoolUserRepository;
import com.ashish.cactus.school.admin.db.repositories.UserRepository;
import com.ashish.cactus.school.admin.db.repositories.UserRoleRepository;
import com.ashish.cactus.school.admin.dozer.mappers.AddressDetailsMappers;
import com.ashish.cactus.school.admin.dozer.mappers.UserDetailsMappers;
import com.ashish.cactus.school.admin.input.AddressDetails;
import com.ashish.cactus.school.admin.input.AdminInput;
import com.ashish.cactus.school.admin.input.LicenseDetails;
import com.ashish.cactus.school.admin.input.RoleDetails;
import com.ashish.cactus.school.admin.input.SchoolDetails;
import com.ashish.cactus.school.admin.input.UserDetails;
import com.ashish.cactus.school.admin.output.AdminOutput;
import com.ashish.cactus.school.admin.utils.AdminUtils;

@Service
public class UserService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private UserDetailsMappers userDetailsMapper;
	
	@Autowired
	private AddressDetailsMappers addressDetailsMapper;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModulePermissionRepository modulesPermissionRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private LicenseDetailRepository licenseDetailRepo;
	
	@Autowired
	private ModuleMasterRepository moduleMaserRepo;
	
	@Autowired
	private AdminUtils adminUtils;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private UserRoleRepository userRoleRepo;
	
	@Autowired
	private SchoolMasterRepository schoolMasterRepo;
	
	@Autowired
	private SchoolUserRepository schoolUserRepo;
	
	@Transactional(rollbackOn=Exception.class)
	public AdminOutput createStaff(AdminInput adminInput, AdminOutput adminOutput, String transactionId) throws Exception {
		if(adminOutput == null) {
			adminOutput = new AdminOutput();
		}
		adminOutput.setUsers(new ArrayList<>());
		adminOutput.getUsers().add(new UserDetails());
		
		User userEntity = new User();
		Address address = null;
		LicenseDetail licenseEntity = null;
		try {
			validateUserInput(adminInput);
			
			// Save address (if address details is passed)
			if(adminInput.getUserDetails() != null && adminInput.getUserDetails().getAddressDetails() != null) {
				logger.debug("Address needs to be saved");
				AddressDetails addressBean = adminInput.getUserDetails().getAddressDetails();
				if(addressBean != null) {
					if(adminInput.getUserDetails().getUserId() > 0 ) {
						// Delete other addresses
						if(addressBean.getAddressId() == 0) {
							Optional<User> u = userRepo.findById(adminInput.getUserDetails().getUserId());
							if(u.isPresent()) {
								List<Address> addresses = u.get().getAddresses();
								if(addresses != null) {
									for(Address a: addresses) {
										a.setDeleteInd("Y");
										a.setDeleteReason("Updated user address with a new address");
										if(adminInput.getAuditDetails() != null) {
											a.setUpdateUser(adminInput.getAuditDetails().getUpdateUser());
											if(adminInput.getAuditDetails().getUpdateDate() != null) {
												a.setUpdateDate(new Timestamp(adminInput.getAuditDetails().getUpdateDate().getTime()));
											}
										}
									}
								}
								addressRepo.saveAll(addresses);
								logger.debug("Deleted all previous address for the school: ");
							}
						}
					}
					address = new Address();
					addressDetailsMapper.mapAddressDetails(addressBean, address);
					addressRepo.save(address);
				}
			}
			
			// Update license details ========================================================
			if(adminInput.getUserDetails() != null && adminInput.getUserDetails().getLicenseDetails() != null) {
				logger.debug("License needs to be saved");
				LicenseDetails licenseBean = adminInput.getUserDetails().getLicenseDetails();
				if(licenseBean != null) {
					if(adminInput.getUserDetails().getUserId() > 0 ) {
						// Delete other licenses
						if(licenseBean.getLicenseId() == 0) {
							Optional<User> s = userRepo.findById(adminInput.getUserDetails().getUserId());
							if(s.isPresent()) {
								List<LicenseDetail> licenses = s.get().getLicenseDetails();
								if(licenses != null) {
									for(LicenseDetail l: licenses) {
										l.setDeleteInd("Y");
										l.setDeleteReason("Updated user license with a new contract");
										if(adminInput.getAuditDetails() != null) {
											l.setUpdateUser(adminInput.getAuditDetails().getUpdateUser());
											if(adminInput.getAuditDetails().getUpdateDate() != null) {
												l.setUpdateDate(new Timestamp(adminInput.getAuditDetails().getUpdateDate().getTime()));
											}
										}
									}
								}
								licenseDetailRepo.saveAll(licenses);
								logger.debug("Deactivated all previous licenses for the user: ");
							}
						}
					}
					licenseEntity = new LicenseDetail();
					BeanUtils.copyProperties(licenseEntity, licenseBean);
					adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, licenseEntity);
					licenseDetailRepo.save(licenseEntity);
				}
			}
			
			// If new user then set the password else retrieve the password and store
			String password = adminInput.getUserDetails().getPassword();
			if(adminInput.getUserDetails().isPasswordUpdate()) {
				if(adminInput.getUserDetails().getUserId() > 0) {
					Optional<User> u = userRepo.findById(adminInput.getUserDetails().getUserId());
					if(!u.isPresent()) {
						throw new Exception("You are trying to update password for the user which does not exists");
					}
					password = u.get().getPassword();
				}
			}
			if(adminInput.getUserDetails().getUserId() == 0) {
				BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
				password = encoder.encode(password);
				userEntity.setUserApprovedInd("Y");
				userEntity.setUserApprovalComment("Staff creation is auto approved");
			}
			userDetailsMapper.mapUserDetails(adminInput.getUserDetails(), userEntity);
			userEntity.setPassword(password);
			
			
			adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, userEntity);
			userRepo.save(userEntity);
			
			// update user_id in the address table
			if(address != null && userEntity != null) {
				address.setUser(userEntity);
				adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, address);
				addressRepo.save(address);
			}
			
			// Update user_id in license details table =====================================
			if(licenseEntity != null && userEntity != null) {
				licenseEntity.setUser(userEntity);
				adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, licenseEntity);
				licenseDetailRepo.save(licenseEntity);
			}
						
			UserDetails userDetailsResponseBean = adminOutput.getUsers().get(0);
			userDetailsMapper.mapUserDetails(userEntity, userDetailsResponseBean);
			
			if(address != null) {
				AddressDetails addressDetails = new AddressDetails();
				addressDetailsMapper.mapAddressDetails(address, addressDetails);
				if(userDetailsResponseBean != null) {
					userDetailsResponseBean.setAddressDetails(addressDetails);
					logger.debug("Address updated into the response for the school: " + userDetailsResponseBean);
				}
			}
			
			if(licenseEntity != null) {
				LicenseDetails licenseBean = new LicenseDetails();
				BeanUtils.copyProperties(licenseBean, licenseEntity);
				if(userDetailsResponseBean != null) {
					userDetailsResponseBean.setLicenseDetails(licenseBean);
					logger.debug("License details updated into the response for the user: " + userDetailsResponseBean);
				}
			}
			
			// Update user role =================================
			List<RoleDetails> roles = adminInput.getUserDetails().getRoles();
			List<AdminUserRole> userRoles = new ArrayList<>();
			if(roles != null) {
				boolean isPrevRolesDeleted = false;
				for(RoleDetails roleBean : roles) {
					if(roleBean.getRoleId() != 0) {
						if(!isPrevRolesDeleted) {
							userRoles = userEntity.getUserRoles();
							if(userRoles != null) {
								for(AdminUserRole userRole: userRoles) {
									adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, userRole);
									userRole.setDeleteInd("Y");
									userRole.setDeleteReason("Deleting existing roles");
								}
								userRoleRepo.deleteAll(userRoles);
								logger.debug("Existing user roles are deleted");
								userRoles = new ArrayList<>();
							}
							isPrevRolesDeleted = true;
						}
						Optional<AdminRoleMaster> roleEntity = roleRepo.findById(roleBean.getRoleId());
						if(roleEntity.isPresent()) {
							AdminUserRole userRole = new AdminUserRole();
							if(userRoles == null) {
								userRoles = new ArrayList<>();
							}
							userRoles.add(userRole);
							userRole.setRoleMaster(roleEntity.get());
							userRole.setUser(userEntity);
							adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, userRole);
						}
					}
				}
				
				if(userRoles != null && userRoles.size() > 0) {
					userRoleRepo.saveAll(userRoles);
					logger.debug("Updated all user roles for the user: " + userEntity.getUserName());
				}
			}
			
			// Update school details
			if(adminInput.getUserDetails().getSchools() != null && adminInput.getUserDetails().getSchools().size() > 0) {
				SchoolDetails schoolBean = adminInput.getUserDetails().getSchools().get(0);
				Optional<SchoolMaster> school = schoolMasterRepo.findById(schoolBean.getSchoolId());
				if(school.isPresent()) {
					List<SchoolUser> schoolUsers = new ArrayList<>();
					schoolUsers.add(new SchoolUser());
					SchoolUser schoolUserEntity = new SchoolUser();
					schoolUserEntity.setUser(userEntity);
					schoolUserEntity.setSchoolMaster(school.get());
					adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, schoolUserEntity);
					schoolUserRepo.save(schoolUserEntity);
				}
			}
			
			// Do not send password back
			userDetailsResponseBean.setPassword("");
		} catch (Exception e) {
			logger.error("Error while Saving/Updating school data", e);
			adminUtils.mapError(adminOutput, "407", e);
			throw e;
		}
		return adminOutput;
	}
	
	public void validateUserInput(AdminInput adminInput) throws Exception {
		if(adminInput == null || adminInput.getUserDetails() == null) {
			throw new Exception("Input cannot be null to create an user");
		}
		
		if(adminInput.getUserDetails().isPasswordUpdate() && 
				(adminInput.getUserDetails().getPassword() == null || adminInput.getUserDetails().getPassword().trim().equals(""))) {
			throw new Exception("When updating password, the password text must be provided");
		}
	}
	
	
	@Transactional(rollbackOn=Exception.class)
	public AdminOutput getStaff(AdminInput adminInput, AdminOutput adminOutput, String transactionId) throws Exception {
		if(adminOutput == null) {
			adminOutput = new AdminOutput();
		}
		
		adminOutput.setUsers(new ArrayList<>());
		
		// Get all staffs by school id
		UserDetails userDetailsResponseBean = new UserDetails();
		if(adminInput.getSchoolDetails() != null) {
			int schoolId = adminInput.getSchoolDetails().getSchoolId();
			if(schoolId > 0) {
				Optional<SchoolMaster> schoolMasterEntity = schoolMasterRepo.findById(schoolId);
				if(schoolMasterEntity.isPresent()) {
					List<SchoolUser> schoolUsers = schoolMasterEntity.get().getSchoolUsers();
					
					for(SchoolUser su: schoolUsers) {
						User u = su.getUser();
						userDetailsResponseBean = new UserDetails();
						adminOutput.getUsers().add(userDetailsResponseBean);
						getUserDetailsByUserId(userDetailsResponseBean, u.getUserName());
					}
				}
			}
		}
		
		// Get Staff by user ID
		UserDetails userDetails = adminInput.getUserDetails();
		if(userDetails != null) {
			
			int userId = userDetails.getUserId();
			String userName = userDetails.getUserName();
			
			// Retrieve the user details ======================
			adminOutput.getUsers().add(userDetailsResponseBean);
			userId = getUserDetailsByUserId(userDetailsResponseBean, userName);
			
			
			// Retrieve the child user details ======================
			List<User> users = userRepo.findByParentId(userId);
			if(users != null && users.size() > 0) {
				for(User u: users) {
					userDetailsResponseBean = new UserDetails();
					adminOutput.getUsers().add(userDetailsResponseBean);
					getUserDetailsByUserId(userDetailsResponseBean, u.getUserName());
				}
			}
				
		}
		return adminOutput;
	}

	private int getUserDetailsByUserId(UserDetails userDetailsResponseBean, String userName)
			throws IllegalAccessException, InvocationTargetException {
		int userId = 0;
		Optional<User> userEntity = userRepo.findByUserName(userName);
		if(userEntity.isPresent()) {
			userId = userEntity.get().getUserId();
			userDetailsMapper.mapUserDetails(userEntity.get(), userDetailsResponseBean);
			// Reset password to null
			userDetailsResponseBean.setPassword("");
			
			// Find address details =====================
			logger.debug("Find the address detals for the user: " + userName);
			for(Address addressEntity: userEntity.get().getAddresses()) {
				AddressDetails addressDetails = new AddressDetails();
				userDetailsResponseBean.setAddressDetails(addressDetails);
				addressDetailsMapper.mapAddressDetails(addressEntity, addressDetails);
			}
			
			// Find contract details =====================
			logger.debug("Find the license detals for the user: " + userName);
			for(LicenseDetail licenseEntity: userEntity.get().getLicenseDetails()) {
				LicenseDetails licenseDetailsBean = new LicenseDetails();
				userDetailsResponseBean.setLicenseDetails(licenseDetailsBean);
				BeanUtils.copyProperties(licenseDetailsBean, licenseEntity);
			}
		}
		return userId;
	}
}
