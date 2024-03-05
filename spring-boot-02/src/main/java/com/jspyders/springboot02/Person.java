package com.jspyders.springboot02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Person {
		@Autowired
		@Qualifier("milkyBar")
	Chocolate chocolate;

		public Chocolate getChocolate() {
			return chocolate;
		}

		public void setChocolate(Chocolate chocolate) {
			this.chocolate = chocolate;
		}
		
			
		
}
