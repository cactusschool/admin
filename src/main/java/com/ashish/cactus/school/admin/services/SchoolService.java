package com.ashish.cactus.school.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.repositories.SchoolMasterRepository;
import com.ashish.cactus.school.admin.dozer.mappers.SchoolDetailsMappers;
import com.ashish.cactus.school.admin.input.AdminInput;
import com.ashish.cactus.school.admin.output.AdminOutput;

@Service
public class SchoolService {
	
	@Autowired
	private SchoolDetailsMappers schoolDetailsMapper;
	
	@Autowired
	private SchoolMasterRepository schoolMasterRepo;
	
	public AdminOutput createSchool(AdminInput adminInput, String transactionId) {
		AdminOutput adminOutput = new AdminOutput();
		
		SchoolMaster schoolMaster = new SchoolMaster();
		schoolDetailsMapper.mapSchoolDetails(adminInput.getSchoolDetails(), schoolMaster);
		schoolMasterRepo.save(schoolMaster);
		return adminOutput;
	}
}
