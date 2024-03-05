package com.org.springdatajpa01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.springdatajpa01.dao.MobileDao;
import com.org.springdatajpa01.dto.Mobile;

@RestController
public class MobileRestController {
	@Autowired
	MobileDao dao;
	
	@PostMapping("/saveMobile")
	public Mobile saveMobile(@RequestBody Mobile mobile) {
		return dao.saveMobile(mobile);
	}
	
	@PutMapping("/updateMobileById/{id}")
	public Mobile updateMobileById(@RequestBody Mobile mobile, @PathVariable int id) {
		Mobile mobile2 = dao.fetchMobileById(id);
		
		if(mobile2 != null) {
			mobile.setId(mobile2.getId());
			return dao.saveMobile(mobile);
		}
		return null;
	}
	
	@GetMapping("/fetchAllMobile")
	public List<Mobile> fetchAllMobiles(){
		
		return dao.fetchAllMobiles();
	}
	
	@GetMapping("fetchMobileById/{id}")
	public Mobile fetchMobileById(@PathVariable int id) {
		return dao.fetchMobileById(id);
	}
	
	@DeleteMapping("deleteMobileById/{id}")
	public String deleteMobileById(@PathVariable int id) {
		dao.deleteMobileById(id);
		
		return "Mobile Data Deleted";
	}
}
