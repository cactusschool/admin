package com.ashish.cactus.school.admin.dozer.mappers;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.config.AdminDozerConfig;

@Component
public class SchoolDetailsMappers {
	
	@Autowired
	private AdminDozerConfig adminDozerConfig;
	
	public void mapSchoolDetails(Object src, Object dest) {
		Mapper dozerMapper = adminDozerConfig.dozerBean();
		dozerMapper.map(src, dest, "schoolDetailsMap");
	}
}
