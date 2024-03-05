package com.org.springdatajpa02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.org.springdatajpa02.dao.EmployeeDao;
import com.org.springdatajpa02.dto.Employee;

@RestController
public class EmployeeRestController {
		@Autowired
	EmployeeDao dao;
		
		@PostMapping("/saveEmployee")
		public Employee saveEmployee(@RequestBody Employee employee) {
			return dao.saveEmployee(employee);
		}
		
		@PutMapping("/updateEmployee/{id}")
		public Employee updateEmployee(@RequestBody Employee employee, @PathVariable int id) {
			Employee employee2 = dao.fetchById(id);
			
			if(employee2 != null) {
				employee.setId(employee2.getId());
				return dao.saveEmployee(employee);
			}
			return null;
		}
		
		@DeleteMapping("/deleteEmp/{id}")
		public String deleteEmployeeById(@PathVariable int id) {
			dao.deleteEmpById(id);
			return "employee data deleted";
		}
		
		@GetMapping("/fetchAllEmp")
		public List<Employee> fetchAllEmp(){
			return dao.fetchAllEmp();
		}
		
		@GetMapping("/fetchEmpById/{id}")
		public Employee fetchById(@PathVariable int id) {
			
		return 	dao.fetchById(id);
		}
		
		@GetMapping("/fetchByExp")
		public List<Employee> fetchByExp(){
			return dao.fetchEmpByExp();
		
		}
		@GetMapping("/fetchBySal")
		public List<Employee> fetchBySal(){
			return dao.fetchBySal();
		}
		@GetMapping("/fetchByName/{name}/{password}")
		public boolean fetchByNameAndPwd(@PathVariable String name, @PathVariable  String password){
			return !dao.verifyByNameAndPassword(name, password).isEmpty();
		}
		
		
		@GetMapping("/verifyEmp/{email}/{password}")
		public  boolean verifyEmp(@PathVariable String email, @PathVariable String password) {
			return !dao.verifyEmp(email, password).isEmpty();
		}
		
		
		
		
		
		
		
		
}
