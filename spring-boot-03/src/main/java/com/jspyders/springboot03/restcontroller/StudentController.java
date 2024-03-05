package com.jspyders.springboot03.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jspyders.springboot03.dto.Student;

@Controller
public class StudentController {
	
	
	@GetMapping("/msg")
	@ResponseBody
	public String send() {
		
		return "hello welcome to spring boot";
	}
	
	@GetMapping("/send")
	@ResponseBody
	public Student sendStudent() {
		
		Student student = new Student();
		
		student.setName("aditya");
		student.setAge(20);
		student.setMobile(796986986969l);
		student.setEmail("aditya@gmail.com");
		student.setPassword("7878");
		
		return student;
		
		
		
		
	}

}
