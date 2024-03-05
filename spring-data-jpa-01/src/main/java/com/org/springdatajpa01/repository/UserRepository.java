package com.org.springdatajpa01.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.springdatajpa01.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	List<User> findByEmailAndPassword(String email , String password);
	
	List<User> findByName(String name);
	
	@Query("SELECT u FROM User u WHERE u.age>?1")
	List<User> findByAge(int age);

}
