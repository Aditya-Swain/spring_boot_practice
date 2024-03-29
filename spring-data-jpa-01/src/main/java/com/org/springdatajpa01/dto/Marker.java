package com.org.springdatajpa01.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Marker {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String brand;
	
	private String color;
	
	private int price;
	
}
