package com.ashish.cactus.school.admin.services;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.repositories.SchoolMasterRepository;
import com.ashish.cactus.school.admin.dozer.mappers.SchoolDetailsMappers;
import com.ashish.cactus.school.admin.input.AdminInput;
import com.ashish.cactus.school.admin.input.SchoolDetails;
import com.ashish.cactus.school.admin.output.AdminOutput;
import com.ashish.cactus.school.admin.utils.AdminUtils;

@Service
public class SchoolService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SchoolDetailsMappers schoolDetailsMapper;
	
	@Autowired
	private SchoolMasterRepository schoolMasterRepo;
	
	@Autowired
	private AdminUtils adminUtils;
	
	@Transactional(rollbackOn=Exception.class)
	public AdminOutput createSchool(AdminInput adminInput, AdminOutput adminOutput, String transactionId) throws Exception {
		if(adminOutput == null) {
			adminOutput = new AdminOutput();
		}
		SchoolMaster schoolMaster = new SchoolMaster();
		try {
			validateSchoolInput(adminInput);
			schoolDetailsMapper.mapSchoolDetails(adminInput.getSchoolDetails(), schoolMaster);
			schoolMasterRepo.save(schoolMaster);
			adminOutput.setSchoolDetails(new SchoolDetails());
			schoolDetailsMapper.mapSchoolDetails(schoolMaster, adminOutput.getSchoolDetails());
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
			if(schoolMasters != null && schoolMasters.size() > 0) {
				throw new Exception("School: " + schoolDetails.getSchoolName() + " has duplicate school code: " + schoolDetails.getSchoolCode());
			}
		}
	}
}
