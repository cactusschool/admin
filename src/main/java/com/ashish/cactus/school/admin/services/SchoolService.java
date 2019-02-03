package com.ashish.cactus.school.admin.services;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.repositories.SchoolMasterRepository;
import com.ashish.cactus.school.admin.dozer.mappers.SchoolDetailsMappers;
import com.ashish.cactus.school.admin.input.AdminInput;
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
	
	public AdminOutput createSchool(AdminInput adminInput, String transactionId) {
		AdminOutput adminOutput = new AdminOutput();
		
		SchoolMaster schoolMaster = new SchoolMaster();
		try {
			schoolDetailsMapper.mapSchoolDetails(adminInput.getSchoolDetails(), schoolMaster);
			schoolMasterRepo.save(schoolMaster);
		} catch (Exception e) {
			logger.error("Error while Saving/Updating school data", e);
			adminUtils.mapError(adminOutput, "407", e);
		}
		return adminOutput;
	}
}
