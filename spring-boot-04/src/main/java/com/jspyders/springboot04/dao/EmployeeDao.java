package com.jspyders.springboot04.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.jspyders.springboot04.dto.Employee;
@Component
public class EmployeeDao {
		
	static List<Employee> list = new ArrayList<>();
	static {
		
		list.add(new Employee(1,"sukuna",33,"sukuna@gmail.com","1234"));
		list.add(new Employee(2,"kiyotaka",12,"kiyotaka@gmail.com","2323"));
		list.add(new Employee(3,"itadori",17,"itadori@gmail.com","9090"));
		list.add(new Employee(4,"saturo",25,"satoru@gmail.com","6767"));
		list.add(new Employee(5,"kakashi",35,"kakashi@gmail.com","4321"));
	}
	
	
	public void saveEmployee(Employee employee) {
		
		
		list.add(employee);
		
	}
	
	public List<Employee> fetchAllEmployee(){
		return list;
	}
	
	public Employee fetchEmpById(int id) {
		
		for(Employee e : list) {
			if(e.getId() == id)
				return e;
			
			}
		return null;
	}
	
	
	public void deleteEmpById(int id) {
		
		for(int i=0;i<list.size();i++) {
			if(list.get(i).getId() == id)
				list.remove(i);
			
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
