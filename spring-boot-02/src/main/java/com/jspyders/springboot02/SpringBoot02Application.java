package com.jspyders.springboot02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBoot02Application {

	public static void main(String[] args) {
	ApplicationContext context =	SpringApplication.run(SpringBoot02Application.class, args);
		
		Person person = (Person) context.getBean("person");
		
		Employee employee = (Employee) context.getBean("employee");
		
		System.out.println(person.getChocolate());
		System.out.println(employee.getChocolate());
		
	}

}
