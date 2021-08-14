package com.springboot.demo.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.userservice.dto.RestResponseSO;
import com.springboot.demo.userservice.entity.User;
import com.springboot.demo.userservice.services.Userservice;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private Userservice userservice;
	
	@PostMapping("/")
	private User saveUser(@RequestBody User user) {
		
		return userservice.saveUser(user);
		
	}
	
	@GetMapping("/{id}")
	private RestResponseSO getUserWithDepartment(@PathVariable("id") Long userId) {
		
		RestResponseSO respone =  userservice.getUserWithDepartment(userId);
		return respone;
		
	}
	
	
	

}
