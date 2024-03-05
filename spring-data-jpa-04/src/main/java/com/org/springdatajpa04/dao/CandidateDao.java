package com.org.springdatajpa04.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.springdatajpa04.dto.Candidate;
import com.org.springdatajpa04.repository.CandidateRepository;

@Component
public class CandidateDao {
		@Autowired
	CandidateRepository repo;
	public Candidate saveAndUpdateCandidate(Candidate candidate) {
		return repo.save(candidate);
	}
	
	public List<Candidate> fetchAllCandidate(){
		return repo.findAll();
	}
	
	public Candidate fetchCandidateById(int id) {
		Optional<Candidate> optional = repo.findById(id);
		
		if(optional != null)
			return optional.get();
		
		return null;
	}
	
	public Candidate deleteCandidateById(int id) {
		Candidate candidate = fetchCandidateById(id);
		
		if(candidate != null) {
			repo.delete(candidate);
		return candidate;
		}
		return null;
	}
	
	public List<Candidate> verifyCandidate(String email , String password){
		return repo.findByEmailAndPassword(email, password);
	}
	
	public List<Candidate> fetchCandidateByAge(int age1 , int age2){
		return repo.findBetweenAge(age1, age2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
