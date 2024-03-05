package com.org.springdatajpa01.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.springdatajpa01.dto.Mobile;
import com.org.springdatajpa01.repository.MobileRepository;

@Component
public class MobileDao {
	@Autowired	
	MobileRepository repo;
	
	
	public Mobile saveMobile(Mobile mobile) {
		
		return repo.save(mobile);
	}
	
	public List<Mobile> fetchAllMobiles(){
		
		return repo.findAll();
	}
	
	public Mobile fetchMobileById(int id) {
		
		Optional<Mobile> optional = repo.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}
	
	public Mobile deleteMobileById(int id) {
		
		Mobile mobile = fetchMobileById(id);
		
		if(mobile != null)
			repo.delete(mobile);
		return mobile;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
