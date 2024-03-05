package com.org.springdatajpa02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.springdatajpa02.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	@Query("SELECT e from Employee e WHERE e.experience>=2")
	List<Employee> findByExp();
	
	List<Employee> findByEmailAndPassword(String email, String password);
	
	@Query("SELECT e from Employee e WHERE e.salary>=20000 AND e.salary<=30000")
	List<Employee> findEmpBySal();
	
	List<Employee> findByNameAndPassword(String name, String password);

}
