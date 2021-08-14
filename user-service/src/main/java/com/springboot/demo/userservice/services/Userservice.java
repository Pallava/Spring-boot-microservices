package com.springboot.demo.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springboot.demo.userservice.dto.Department;
import com.springboot.demo.userservice.dto.RestResponseSO;
import com.springboot.demo.userservice.entity.User;
import com.springboot.demo.userservice.repository.UserRepository;

@Service
public class Userservice {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate resttemplate;

	public User saveUser(User user) {
		
		return userRepository.save(user);
	}

	public RestResponseSO getUserWithDepartment(Long userId) {
		RestResponseSO responseSO=new RestResponseSO();
		User user =  userRepository.findByUserId(userId);
		
		Department dept = resttemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDeptId(), Department.class);
		responseSO.setUser(user);
		responseSO.setDepartment(dept);
		return responseSO;
		
		
	}

}
