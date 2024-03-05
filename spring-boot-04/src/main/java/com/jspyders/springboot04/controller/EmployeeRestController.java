package com.jspyders.springboot04.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspyders.springboot04.dao.EmployeeDao;
import com.jspyders.springboot04.dto.Employee;

@RestController
public class EmployeeRestController {
	
	@Autowired
	EmployeeDao dao;
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@RequestBody Employee employee) {
		
		dao.saveEmployee(employee);
		
		return "Employee Added Successfully";
		
	}
	
	@GetMapping("/fetchAllEmp")
	public List<Employee> fetchAllEmp(){
		
		List<Employee> employees = dao.fetchAllEmployee();
		
		return employees;
		
	}
	
	@GetMapping("/fetchById/{id}")
	public Employee fetchEmpById(@PathVariable int id) {
		Employee employee = dao.fetchEmpById(id);
		if(employee != null)
			return employee;
		return null;
	}
	
	@GetMapping("/deleteEmpById/{id}")
	public void deleteEmpById(@PathVariable int id) {
		 dao.deleteEmpById(id);
			
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
