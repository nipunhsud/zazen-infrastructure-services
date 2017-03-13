package com.zazen.infrastructure.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.UserRepository;


public class UserController {
	
	@Autowired
	UserRepository userRepository;

	
	@RequestMapping(value ="/user", method = RequestMethod.POST, headers = "Accept=application/json" )
	public String saveUser(@RequestBody User user){
		String userUUID = userRepository.save(user);
		return userUUID;
	}
	
	@RequestMapping(value= "/user/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUserById(@RequestParam String userUUID){
		User user = userRepository.findOne(userUUID);
		return user;
	}
	
	@RequestMapping(value="/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUsers(){
		return userRepository.findAll();
	} 
	
	public List<User> getUsersById(@RequestParam List<String> userUUIDs){
		return userRepository.findAll(userUUIDs);
	}

}