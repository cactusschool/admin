package com.ashish.cactus.school.admin.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.User;
import com.ashish.cactus.school.admin.db.repositories.AdminUserRepository;

@Service("AdminApplicationUserService")
public class AdminApplicationUserService {
	
	@Autowired
	private AdminUserRepository userRepo;
	
	public User findByUsername(String username) {
	
		return userRepo.findByUserName(username);
	}

}
