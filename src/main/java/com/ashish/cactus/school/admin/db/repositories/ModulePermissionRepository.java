package com.ashish.cactus.school.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.ModulesPermission;

@Component
public interface ModulePermissionRepository extends CrudRepository <ModulesPermission, Integer>{
}
