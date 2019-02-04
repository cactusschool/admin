package com.ashish.cactus.school.admin.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.Address;
import com.ashish.cactus.school.admin.db.model.ModuleMaster;
import com.ashish.cactus.school.admin.db.model.ModulesPermission;
import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.repositories.AddressRepository;
import com.ashish.cactus.school.admin.db.repositories.ModuleMasterRepository;
import com.ashish.cactus.school.admin.db.repositories.ModulePermissionRepository;
import com.ashish.cactus.school.admin.db.repositories.SchoolMasterRepository;
import com.ashish.cactus.school.admin.dozer.mappers.AddressDetailsMappers;
import com.ashish.cactus.school.admin.dozer.mappers.SchoolDetailsMappers;
import com.ashish.cactus.school.admin.input.AddressDetails;
import com.ashish.cactus.school.admin.input.AdminInput;
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
	private ModulePermissionRepository modulePermissionRepo;
	
	@Autowired
	private AddressRepository addressRepo;
	
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
						modulePermissionRepo.saveAll(mpList);
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
				
				modulePermissionRepo.saveAll(modulePermissions);
				logger.debug("Module permossions added for school: " + schoolMaster);
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
}
