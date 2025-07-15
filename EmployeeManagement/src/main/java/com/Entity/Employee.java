package com.Entity;

public class Employee {
	private int id;
	private String name;
	private int age;
	private int sal;
	private String address;	
	
	
	public Employee(int id) {
		this.id=id;
	}

	public Employee(int id, String name, int age, int sal, String address) {
		this.id = id;
		this.name = name;
		this.age=age;
		this.sal = sal;
		this.address = address;
	}
	
	public Employee() {
		
	}
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id=id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal=sal;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address=address;
	}
}
