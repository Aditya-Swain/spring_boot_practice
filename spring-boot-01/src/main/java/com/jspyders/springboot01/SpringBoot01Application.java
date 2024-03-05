package com.jspyders.springboot01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot01Application {

	public static void main(String[] args) {
		 ApplicationContext context =  SpringApplication.run(SpringBoot01Application.class, args);
		 
		 Person person = (Person) context.getBean("person");
		 
//		 Employee employee = (Employee) context.getBean("employee");
		 
//		 User user = (User) context.getBean("user");
		 
		 Student student = (Student) context.getBean("student");
		 
		 System.out.println(person);
//		 System.out.println(employee);
//		 System.out.println(user);
		 System.out.println(student);
	}

}
