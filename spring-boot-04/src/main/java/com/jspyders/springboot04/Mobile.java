package com.jspyders.springboot04;

import org.springframework.stereotype.Component;

@Component
public class Mobile implements ElectronicGadget{
	
	private String brand;
	
	private int price;
	
	private String color;
	
	private String ram;

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}
	
	

}
