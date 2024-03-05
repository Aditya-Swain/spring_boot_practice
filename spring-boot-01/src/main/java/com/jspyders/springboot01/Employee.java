package com.jspyders.springboot01;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Employee {
	{
		System.out.println("Employee object created");
	}
}
