package com.ashish.cactus.school.admin.db.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.SchoolMaster;
import com.ashish.cactus.school.admin.db.model.User;

@Component
public interface SchoolMasterRepository extends CrudRepository <SchoolMaster, Long>{
	public List<SchoolMaster> findBySchoolCode(String schoolCode);
}
