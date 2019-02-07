package com.ashish.cactus.school.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.AdminUserRole;

@Component
public interface UserRoleRepository extends CrudRepository <AdminUserRole, Integer>{
}
