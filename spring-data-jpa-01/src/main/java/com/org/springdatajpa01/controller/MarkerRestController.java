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

import com.org.springdatajpa01.dao.MarkerDao;
import com.org.springdatajpa01.dto.Marker;
@RestController
public class MarkerRestController {
	@Autowired	
	MarkerDao dao;
	
	
	@PostMapping("/saveMarker")
	public Marker saveMarker(@RequestBody Marker marker) {
		
		return dao.saveMarker(marker);
		
	}
	
	@PutMapping("/updateMarker/{id}")
	public Marker updateMarker(@RequestBody Marker marker,@PathVariable int id) {
		
		Marker marker2 = dao.fetchById(id);
		
		if(marker2 != null) {
			marker.setId(marker2.getId());
			return dao.saveMarker(marker);
		}
		return null;
		
	}
	
	
	@GetMapping("/fetchAllMarkers")
	public List<Marker> fetchAllMarkers(){
		
		return dao.fetchAllMarkers();
		
	}
	@GetMapping("/fetchMarkerById/{id}")
	public Marker fetchMarkerById(@PathVariable int id) {
		
	return	dao.fetchById(id);
	}
	
	@DeleteMapping("deleteMarkerById/{id}")
	public String deleteMarkerById(@PathVariable int id) {
				
			dao.deleteById(id);
		return " marker data deleted"; 
	}
	
}
