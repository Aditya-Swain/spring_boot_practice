package com.org.springdatajpa01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.org.springdatajpa01.dao.UserDao;
import com.org.springdatajpa01.dto.User;

@RestController
@RequestMapping("/user")
public class UserRestController {
		@Autowired
		UserDao dao;
	@PostMapping
	public User saveUser(@RequestBody User user) {
		
		
		return dao.saveUser(user);
		
	}
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user , @PathVariable int id) {
		
		User user2 = dao.fetchUserById(id);
		
		if(user2 != null) {
			user.setId(user2.getId());
			return dao.saveUser(user);
		}
		return null;
		
		
	}
	
	@GetMapping
	public List<User> fetchAllUsers(){
		
		return dao.fetchAllUsers();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> fetchUserById(@PathVariable  int id) {
		
		User user = dao.fetchUserById(id);
		
		if(user != null) {
			return ResponseEntity.of(Optional.of(user));
		}
		else
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
	}
	
	
	@DeleteExchange("/{id}")
	public String deleteUser(@PathVariable int id) {
		
		dao.deleteUserById(id);
		return "User deleted";
	}
	
	@GetMapping("/{email}/{password}")
	public boolean verifyUser(@PathVariable String email, @PathVariable String password) {
		
		return !dao.verifyUser(email, password).isEmpty();
		
	}
	
	@GetMapping("/byName{name}")
	public boolean verifyUserByName(@PathVariable String name) {
		return !dao.verifyUserByName(name).isEmpty();
	}
	
	@GetMapping("/byAge/{age}")
	public List<User> fetchByGreaterAge(@PathVariable int age){
		return dao.fetchUserByGreaterAge(age);
	}
	
	
	
	
	
	
}
