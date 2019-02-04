package com.ashish.cactus.school.admin.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.Address;
import com.ashish.cactus.school.admin.db.model.LicenseDetail;
import com.ashish.cactus.school.admin.db.model.ModuleMaster;
import com.ashish.cactus.school.admin.db.model.ModulesPermission;
import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.repositories.AddressRepository;
import com.ashish.cactus.school.admin.db.repositories.LicenseDetailRepository;
import com.ashish.cactus.school.admin.db.repositories.ModuleMasterRepository;
import com.ashish.cactus.school.admin.db.repositories.ModulePermissionRepository;
import com.ashish.cactus.school.admin.db.repositories.SchoolMasterRepository;
import com.ashish.cactus.school.admin.dozer.mappers.AddressDetailsMappers;
import com.ashish.cactus.school.admin.dozer.mappers.SchoolDetailsMappers;
import com.ashish.cactus.school.admin.input.AddressDetails;
import com.ashish.cactus.school.admin.input.AdminInput;
import com.ashish.cactus.school.admin.input.LicenseDetails;
import com.ashish.cactus.school.admin.input.ModuleDetails;
import com.ashish.cactus.school.admin.input.SchoolDetails;
import com.ashish.cactus.school.admin.output.AdminOutput;
import com.ashish.cactus.school.admin.utils.AdminUtils;

@Service
public class SchoolService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SchoolDetailsMappers schoolDetailsMapper;
	
	@Autowired
	private AddressDetailsMappers addressDetailsMapper;
	
	@Autowired
	private SchoolMasterRepository schoolMasterRepo;
	
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
	
	@Transactional(rollbackOn=Exception.class)
	public AdminOutput createSchool(AdminInput adminInput, AdminOutput adminOutput, String transactionId) throws Exception {
		if(adminOutput == null) {
			adminOutput = new AdminOutput();
		}
		SchoolMaster schoolMaster = new SchoolMaster();
		Address address = null;
		LicenseDetail licenseEntity = null;
		List<ModuleDetails> modules = new ArrayList<>();
		try {
			validateSchoolInput(adminInput);
			
			// Save address (if address details is passed)
			if(adminInput.getSchoolDetails() != null && adminInput.getSchoolDetails().getAddressDetails() != null) {
				logger.debug("Address needs to be saved");
				AddressDetails addressBean = adminInput.getSchoolDetails().getAddressDetails();
				if(addressBean != null) {
					if(adminInput.getSchoolDetails().getSchoolId() > 0 ) {
						// Delete other addresses
						if(addressBean.getAddressId() == 0) {
							Optional<SchoolMaster> s = schoolMasterRepo.findById(adminInput.getSchoolDetails().getSchoolId());
							if(s.isPresent()) {
								List<Address> addresses = s.get().getAddresses();
								if(addresses != null) {
									for(Address a: addresses) {
										a.setDeleteInd("Y");
										a.setDeleteReason("Updated school address with a new address");
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
			
			// Add school modules
			if(adminInput.getSchoolDetails() != null && adminInput.getSchoolDetails().getModules() != null) {
				List<ModulesPermission> modulePermissions = new ArrayList<>();
				
				// Delete old modules
				if(adminInput.getSchoolDetails().getSchoolId() > 0) {
					Optional<SchoolMaster> s = schoolMasterRepo.findById(adminInput.getSchoolDetails().getSchoolId());
					if(s.isPresent()) {
						List<ModulesPermission> mpList = s.get().getModulesPermissions();
						for(ModulesPermission mp : mpList) {
							adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, mp);
							mp.setDeleteInd("Y");
							mp.setDeleteReason("Other modules are updated. So deleting old modules");
						}
						modulesPermissionRepo.saveAll(mpList);
						logger.debug("Old modules are deleted for school: ");
					}
				}
				
				// Adding new modules
				for(ModuleDetails moduleBean: adminInput.getSchoolDetails().getModules()) {
					ModulesPermission modulePermission = new ModulesPermission();
					Optional<ModuleMaster> moduleMaster = moduleMaserRepo.findById(moduleBean.getModuleId());
					if(moduleMaster.isPresent()) {
						modules.add(moduleBean);
						modulePermission.setModuleMaster(moduleMaster.get());
						modulePermission.setSchoolMaster(schoolMaster);
						modulePermissions.add(modulePermission);
						adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, modulePermission);
					}
				}
				
				modulesPermissionRepo.saveAll(modulePermissions);
				logger.debug("Module permossions added for school: " + schoolMaster);
			}
			
			
			// Update license details ========================================================
			if(adminInput.getSchoolDetails() != null && adminInput.getSchoolDetails().getLicenseDetails() != null) {
				logger.debug("License needs to be saved");
				LicenseDetails licenseBean = adminInput.getSchoolDetails().getLicenseDetails();
				if(licenseBean != null) {
					if(adminInput.getSchoolDetails().getSchoolId() > 0 ) {
						// Delete other licenses
						if(licenseBean.getLicenseId() == 0) {
							Optional<SchoolMaster> s = schoolMasterRepo.findById(adminInput.getSchoolDetails().getSchoolId());
							if(s.isPresent()) {
								List<LicenseDetail> licenses = s.get().getLicenseDetails();
								if(licenses != null) {
									for(LicenseDetail l: licenses) {
										l.setDeleteInd("Y");
										l.setDeleteReason("Updated school license with a new contract");
										if(adminInput.getAuditDetails() != null) {
											l.setUpdateUser(adminInput.getAuditDetails().getUpdateUser());
											if(adminInput.getAuditDetails().getUpdateDate() != null) {
												l.setUpdateDate(new Timestamp(adminInput.getAuditDetails().getUpdateDate().getTime()));
											}
										}
									}
								}
								licenseDetailRepo.saveAll(licenses);
								logger.debug("Deactivated all previous licenses for the school: ");
							}
						}
						licenseEntity = new LicenseDetail();
						BeanUtils.copyProperties(licenseEntity, licenseBean);
						adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, licenseEntity);
						licenseDetailRepo.save(licenseEntity);
					}
				}
			}
			
			schoolDetailsMapper.mapSchoolDetails(adminInput.getSchoolDetails(), schoolMaster);
			
			// update address of the school
			if(address != null && schoolMaster != null) {
				logger.debug("Address entity is attached with school record. " + address + "\n" + schoolMaster);
				schoolMaster.setAddressId(address.getAddressId());
			}
			
			adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, schoolMaster);
			schoolMasterRepo.save(schoolMaster);
			
			// update school_id in address table
			if(address != null && schoolMaster != null) {
				address.setSchoolMaster(schoolMaster);
				adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, address);
				addressRepo.save(address);
			}
			
			// Update school_id in license details table =====================================
			if(licenseEntity != null && schoolMaster != null) {
				licenseEntity.setSchoolMaster(schoolMaster);
				adminUtils.mapAuditFieldsAndDeleteDetails(adminInput, licenseEntity);
				licenseDetailRepo.save(licenseEntity);
			}
						
			adminOutput.setSchoolDetails(new SchoolDetails());
			schoolDetailsMapper.mapSchoolDetails(schoolMaster, adminOutput.getSchoolDetails());
			
			if(address != null) {
				AddressDetails addressDetails = new AddressDetails();
				addressDetailsMapper.mapAddressDetails(address, addressDetails);
				if(adminOutput.getSchoolDetails() != null) {
					adminOutput.getSchoolDetails().setAddressDetails(addressDetails);
					logger.debug("Address updated into the response for the school: " + adminOutput.getSchoolDetails());
				}
			}
			
			if(licenseEntity != null) {
				LicenseDetails licenseBean = new LicenseDetails();
				BeanUtils.copyProperties(licenseBean, licenseEntity);
				if(adminOutput.getSchoolDetails() != null) {
					adminOutput.getSchoolDetails().setLicenseDetails(licenseBean);
					logger.debug("License details updated into the response for the school: " + adminOutput.getSchoolDetails());
				}
			}
			
			adminOutput.getSchoolDetails().setModules(modules);
		} catch (Exception e) {
			logger.error("Error while Saving/Updating school data", e);
			adminUtils.mapError(adminOutput, "407", e);
			throw e;
		}
		return adminOutput;
	}
	
	public void validateSchoolInput(AdminInput adminInput) throws Exception {
		if(adminInput == null || adminInput.getSchoolDetails() == null) {
			throw new Exception("Input cannot be null to create a school");
		}
		
		// RULE2: School code must be unique
		SchoolDetails schoolDetails = adminInput.getSchoolDetails();
		if(schoolDetails != null) {
			String schoolCode = schoolDetails.getSchoolCode();
			List<SchoolMaster> schoolMasters = schoolMasterRepo.findBySchoolCode(schoolCode);
			if(schoolDetails.getSchoolId() == 0 && schoolMasters != null && schoolMasters.size() > 0 ) {
				throw new Exception("School: " + schoolDetails.getSchoolName() + " has duplicate school code: " + schoolDetails.getSchoolCode());
			}
		}
	}
	
	
	@Transactional(rollbackOn=Exception.class)
	public AdminOutput getSchool(AdminInput adminInput, AdminOutput adminOutput, String transactionId) throws Exception {
		if(adminOutput == null) adminOutput = new AdminOutput();
		adminOutput.setSchoolDetails(new SchoolDetails());
		
		SchoolDetails schoolDetails = adminInput.getSchoolDetails();
		if(schoolDetails != null) {
			
			Optional<SchoolMaster> schoolEntity = schoolMasterRepo.findById(schoolDetails.getSchoolId());
			if(schoolEntity.isPresent()) {
				schoolDetailsMapper.mapSchoolDetails(schoolEntity.get(), adminOutput.getSchoolDetails());
				
				// Find address details =====================
				logger.debug("Find the address detals for the school: " + adminInput.getSchoolDetails().getSchoolId());
				for(Address addressEntity: schoolEntity.get().getAddresses()) {
					AddressDetails addressDetails = new AddressDetails();
					adminOutput.getSchoolDetails().setAddressDetails(addressDetails);
					addressDetailsMapper.mapAddressDetails(addressEntity, addressDetails);
				}
				
				// Find module details ======================================
				logger.debug("Find the module detals for the school: " + adminInput.getSchoolDetails().getSchoolId());
				List<ModuleDetails> modules = new ArrayList<>();
				for(ModulesPermission modulesPermissionEntity: schoolEntity.get().getModulesPermissions()) {
					ModuleDetails moduleDetails = new ModuleDetails();
					modules.add(moduleDetails);
					BeanUtils.copyProperties(moduleDetails, modulesPermissionEntity.getModuleMaster());
					adminOutput.getSchoolDetails().setModules(modules);
				}
				
				// Find contract details =====================
				logger.debug("Find the license detals for the school: " + adminInput.getSchoolDetails().getSchoolId());
				for(LicenseDetail licenseEntity: schoolEntity.get().getLicenseDetails()) {
					LicenseDetails licenseDetailsBean = new LicenseDetails();
					adminOutput.getSchoolDetails().setLicenseDetails(licenseDetailsBean);
					BeanUtils.copyProperties(licenseDetailsBean, licenseEntity);
				}
			}
			
			
		}
		return adminOutput;
	}
}
