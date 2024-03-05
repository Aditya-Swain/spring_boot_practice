package com.org.springdatajpa01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.springdatajpa01.dto.Marker;

public interface MarkerRepository extends JpaRepository<Marker, Integer>{

}
