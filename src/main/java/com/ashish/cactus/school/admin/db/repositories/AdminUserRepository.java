package com.ashish.cactus.school.admin.db.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.User;

@Component
public interface AdminUserRepository extends CrudRepository <User, Long>{

	User findByUserName(String username);
}
