package com.org.springdatajpa04.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.springdatajpa04.dto.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Integer>{

		
	List<Candidate> findByEmailAndPassword(String email , String password);
	
	@Query("SELECT c FROM Candidate c WHERE c.age>=?1 AND c.age<?2")
	List<Candidate> findBetweenAge(int age1 ,int age2);
	
	
			
}
