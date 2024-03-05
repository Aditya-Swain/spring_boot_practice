package com.org.springdatajpa04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.springdatajpa04.dao.CandidateDao;
import com.org.springdatajpa04.dto.Candidate;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
	
	@Autowired
	CandidateDao dao;
	
	
	@PostMapping
	public Candidate saveCandidate(@RequestBody Candidate candidate) {
		return dao.saveAndUpdateCandidate(candidate);
	}
	
	@PutMapping("/{id}")
	public Candidate updateCandidate(@RequestBody Candidate candidate ,@PathVariable int id) {
		Candidate candidate2 = dao.fetchCandidateById(id);
		
		if(candidate2 != null) {
			candidate.setId(candidate2.getId());
			return dao.saveAndUpdateCandidate(candidate);
		}
		
		return null;
	}
	
	@GetMapping
	public List<Candidate> fetchAllCandidate(){
		return dao.fetchAllCandidate();
	}
	
	@GetMapping("/{id}")
	public Candidate fetchById(@PathVariable int id) {
	return	dao.fetchCandidateById(id);
	}
	
	
	@PostMapping("/verify/{email}/{password}")
	public List<Candidate> verifyCanidate(@PathVariable String email ,@PathVariable String password){
		return dao.verifyCandidate(email, password);
	}
	
	@GetMapping("/{age1}/{age2}")
	public List<Candidate> fetchByAge(@PathVariable int age1,@PathVariable int age2){
		return dao.fetchCandidateByAge(age1, age2);
	}
	
	@DeleteMapping("/{id}")
	public String deleteCandidate(@PathVariable int id) {
		Candidate candidate = dao.deleteCandidateById(id);
		
		if(candidate != null)
			return "candidate data deleted";
		else
		return "candidate not found";
	}

	
	
	
	
	
	
	
	
	
	
}
