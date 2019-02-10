package com.ashish.cactus.school.admin.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.cactus.school.admin.db.model.User;
import com.ashish.cactus.school.admin.db.repositories.UserRepository;

@Service("AdminApplicationUserService")
public class AdminApplicationUserService {
	
	@Autowired
	private UserRepository userRepo;
	
	public User findByUsername(String username) {
	
		Optional<User> user = userRepo.findByUserName(username);
		if(user.isPresent()) {
			return user.get();
		}
		return null;
	}

}
