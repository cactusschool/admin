package com.ashish.cactus.school.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.AdminUser;

@Component
public interface AdminUserRepository extends CrudRepository <AdminUser, Long>{

	AdminUser findByUserName(String username);
}
