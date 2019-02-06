package com.ashish.cactus.school.admin.db.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.ashish.cactus.school.admin.db.model.User;

@Component
public interface UserRepository extends CrudRepository <User, Integer>{
	public List<User> findByParentId(int parentId);
}
