package com.jspyders.springboot04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person {
		@Autowired
		@Qualifier("mobile")
	ElectronicGadget eGadget;

		public ElectronicGadget geteGadget() {
			return eGadget;
		}

		public void seteGadget(ElectronicGadget eGadget) {
			this.eGadget = eGadget;
		}
		
		
	
}
