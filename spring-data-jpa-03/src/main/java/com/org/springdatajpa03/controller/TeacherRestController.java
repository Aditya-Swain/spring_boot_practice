package com.org.springdatajpa03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.springdatajpa03.dao.TeacherDao;
import com.org.springdatajpa03.dto.Teacher;

@RestController
@RequestMapping("/teacher")
public class TeacherRestController {
	@Autowired	
	TeacherDao dao;
	
	@PostMapping
	public Teacher saveTeacher(@RequestBody Teacher teacher) {
		
		return dao.saveTeacher(teacher);
	}
	
	@PutMapping("/{id}")
	public Teacher updateTeacher(@RequestBody Teacher teacher, @PathVariable int id) {
		Teacher teacher2 = dao.fetchById(id);
		
		if(teacher2 != null) {
			teacher.setId(teacher2.getId());
			dao.saveTeacher(teacher);
		}
		return teacher;
	}
	
	@GetMapping
	public List<Teacher> fetchAllTeachers(){
		
		return dao.fetchAllTeacher();
	}
	
	
	@GetMapping("/{id}")
	public Teacher fetchTeacherById(@PathVariable int id) {
		return dao.fetchById(id);
	}
	
	@DeleteMapping
	public String deleteTeacherById(@PathVariable int id) {
		dao.deleteTeacherById(id);
		return "Teacher deleted successfully";
	}
	
	@GetMapping("/byEmail/{email}/{password}")
	public boolean verifyTeacherByEmail(@PathVariable String email,@PathVariable String password) {
			
		return	dao.verifyTeacher(email, password);
	}
	
	@GetMapping("/byName/{name}/{password}")
	public boolean verifyTeacherByName(@PathVariable String name, @PathVariable String password) {
		
		
		return dao.verifyTeacherByName(name, password);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
