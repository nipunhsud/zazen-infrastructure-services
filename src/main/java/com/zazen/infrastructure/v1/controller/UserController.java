package com.zazen.infrastructure.v1.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zazen.infrastructure.v1.pojos.User;
import com.zazen.infrastructure.v1.repository.UserRepository;

@RestController
@Transactional
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	
	@RequestMapping(value ="/user", method = RequestMethod.PUT, headers = "Accept=application/json" )
	public User saveUser(@RequestBody User userRequest){
		User user = userRepository.save(userRequest);
		return user;
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
