package com.hcl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.model.User;
import com.hcl.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> listAll(){
		return userRepo.findAll();
	}
	public void saveUser(User newUser) {
		userRepo.save(newUser);
	}
	public User findUserByName(String userName ) {
		return userRepo.findByUsername(userName);
	}
}
