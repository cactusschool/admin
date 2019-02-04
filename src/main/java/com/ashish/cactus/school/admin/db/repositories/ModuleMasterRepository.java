package com.ashish.cactus.school.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.ModuleMaster;
import com.ashish.cactus.school.admin.db.model.ModulesPermission;

@Component
public interface ModuleMasterRepository extends CrudRepository <ModuleMaster, Integer>{
}
