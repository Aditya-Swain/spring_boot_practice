package com.org.springdatajpa02.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.org.springdatajpa02.dto.Employee;
import com.org.springdatajpa02.repository.EmployeeRepository;

@Component
public class EmployeeDao {
		@Autowired
	EmployeeRepository repo;
		
		
		public Employee saveEmployee(Employee employee) {
			
			return repo.save(employee);
		}
		
		public Employee fetchById(int id) {
			
			 Optional<Employee> optional = repo.findById(id);
			 if(optional.isPresent()) {
				 return optional.get();
			 }
			 
			 return null;
		}
		
		public Employee deleteEmpById(int id) {
			Employee employee = fetchById(id);
			
			if(employee != null) {
				repo.delete(employee);
			}
			return employee;
		}
		
		public List<Employee> fetchAllEmp(){
				
			return repo.findAll();
			
		}
		
		public List<Employee> fetchEmpByExp(){
			return repo.findByExp();
		}
		
		public List<Employee> verifyEmp(String email, String password){
			return repo.findByEmailAndPassword(email, password);
		}
		
		public List<Employee> fetchBySal(){
			return repo.findEmpBySal();
		}
		
		
		public List<Employee> verifyByNameAndPassword(String name, String password){
		return 	repo.findByNameAndPassword(name, password);
		}
		
		
		
		
		
		
		
		
		
		
		
		
}
