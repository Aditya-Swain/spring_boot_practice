package com.org.springdatajpa01.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.springdatajpa01.dto.Marker;
import com.org.springdatajpa01.repository.MarkerRepository;
@Component
public class MarkerDao {
		@Autowired
		MarkerRepository repo;
	public Marker saveMarker(Marker marker) {
		
	return	repo.save(marker);
		
	}
	
	public List<Marker> fetchAllMarkers(){
		
		return repo.findAll();
	}
	
	public Marker fetchById(int id) {
		
		Optional<Marker> optional = repo.findById(id);
		
		if(optional.isPresent()) {
		return	optional.get();
		}
		return null;
	}
	
	
	public Marker deleteById(int id) {
		
		Marker marker = fetchById(id);
		
		if(marker != null) {
			repo.delete(marker);
		}
		return marker;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
