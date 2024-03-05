package com.org.springdatajpa01.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.springdatajpa01.dto.User;
import com.org.springdatajpa01.repository.UserRepository;
@Component
public class UserDao {
	@Autowired
	UserRepository repo;
	
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public List<User> fetchAllUsers(){
		return repo.findAll();
	}
	
	
	public User fetchUserById(int id) {
		
		Optional<User> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public User deleteUserById(int id) {
		
		User user = fetchUserById(id);
		
		if(user != null) {
			repo.delete(user);
		}
		return user;
		
		}
	
	public List<User> verifyUser(String email ,String password){
		
		return repo.findByEmailAndPassword(email, password);
	}
	
	public List<User> verifyUserByName(String name){
		
		return repo.findByName(name);
	}
	
	public List<User> fetchUserByGreaterAge(int age){
		return repo.findByAge(age);
	}
	
	
	
	
	
	
	
	
}
