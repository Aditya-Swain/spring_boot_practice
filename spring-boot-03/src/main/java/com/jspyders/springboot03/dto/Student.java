package com.jspyders.springboot03.dto;

public class Student {
		private String name;
		
		private int age;
		
		private long mobile;
		
		private String email;
		
		private String password;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public long getMobile() {
			return mobile;
		}

		public void setMobile(long mobile) {
			this.mobile = mobile;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Student(String name, int age, long mobile, String email, String password) {
			super();
			this.name = name;
			this.age = age;
			this.mobile = mobile;
			this.email = email;
			this.password = password;
		}

		public Student() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
}
