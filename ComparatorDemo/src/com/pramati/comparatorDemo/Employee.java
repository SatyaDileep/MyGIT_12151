package com.pramati.comparatorDemo;

import java.math.BigDecimal;
import java.util.Comparator;

public class Employee implements Comparator<Employee> {
	
	private String name;
	private BigDecimal salary;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getSalary() {
		return salary;
	}
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public Employee(String name, BigDecimal salary, int age){
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int compare(Employee o1, Employee o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());
	}
	
	
	
}
