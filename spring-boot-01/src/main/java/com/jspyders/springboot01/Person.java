package com.jspyders.springboot01;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Person {
		
	{
		System.out.println("Person object created");
	}
}
