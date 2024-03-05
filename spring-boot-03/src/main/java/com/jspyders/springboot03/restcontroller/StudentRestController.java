package com.jspyders.springboot03.restcontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspyders.springboot03.dto.Student;

@RestController
public class StudentRestController {
		@GetMapping("/fetchStudent")
	public Student receiveStudent() {
		
		Student student = new Student();
		
		student.setName("aditya");
		student.setAge(20);
		student.setMobile(796986986969l);
		student.setEmail("aditya@gmail.com");
		student.setPassword("7878");
		
		return student;
	}
	
	@GetMapping("/fetchAllStudent")
	public List<Student> fetchAllStudent(){
		
		List<Student> list = new ArrayList<>();
		
		list.add(new Student("aditya",20,8979866969l,"aditya@gmail.com","1234"));
		list.add(new Student("karthik",21,8979866969l,"karthik@gmail.com","1234"));
		list.add(new Student("prabhat",22,8979866969l,"prabhat@gmail.com","1234"));
		list.add(new Student("ashis",23,8979866969l,"ashis@gmail.com","1234"));
		list.add(new Student("silu",24,8979866969l,"silu@gmail.com","1234"));
		
		return list;
	}
	
	
	@PostMapping("/receiveData")
	public String getStudent(@RequestBody Student student) {
		
		System.out.println(student.getName());
		System.out.println(student.getAge());
		System.out.println(student.getMobile());
		System.out.println(student.getEmail());
		System.out.println(student.getPassword());
		
		return "data received successfully";
		
	}
	
	//passing value through url
	
	@GetMapping("/get/{id}")
	public String getId(@PathVariable("id") int studentId) {
		
		System.out.println(studentId);
		return "received";
	}
	
	@GetMapping("/verify/{email}/{password}")
	public String verifyEmailAndPassword(@PathVariable String email , @PathVariable String password) {
		System.out.println(email);
		System.out.println(password);
		
		return "verified";
		
		
	}
	
	@GetMapping("/verifyName/{name}")
	public String verifyName(@PathVariable String name) {
		System.out.println(name);
		return "name verified";
		
	}
	
	@GetMapping("/verifyEmail/{email}")
	public String vefifyEmail(@PathVariable String email) {
		return "email verified";
	}
	
	@GetMapping("/fetch/{uname}/{password}")
	public String verifyUnameAndPassword(@PathVariable String uname , @PathVariable String password) {
		System.out.println(uname);
		System.out.println(password);
		return "user name verified";
		
	}
	
	
}
