package com.hcl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hcl.model.User;
import com.hcl.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String viewHomePage() {
		return "index";
	}
	@RequestMapping("/users")
	public String viewListOfUserHomePage(Model model) {
		List<User> listOfAllUser = userService.listAll();
		model.addAttribute("listOfUsers, listofAllUser");
		
		return "users";
	}
	@RequestMapping("/register-user")
	public String registerUser(Model model) {
		User newUser = new User();
		model.addAttribute("newUser", newUser);
		
		return "register_user";
	}
	@PostMapping("/save-user")
	public String saveUser(@ModelAttribute("newUser") User newUser) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		newUser.setPassword(encoder.encode(newUser.getPassword()));
		userService.saveUser(newUser);
		
		return "register_success";
	}
}
