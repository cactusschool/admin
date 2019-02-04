package com.ashish.cactus.school.admin.db.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.SchoolMaster;

@Component
public interface SchoolMasterRepository extends CrudRepository <SchoolMaster, Integer>{
	public List<SchoolMaster> findBySchoolCode(String schoolCode);
}
