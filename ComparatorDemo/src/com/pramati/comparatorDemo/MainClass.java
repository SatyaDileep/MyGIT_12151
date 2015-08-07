package com.pramati.comparatorDemo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainClass {
	
	public static void main(String args[]){
		
		List<Employee> listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(new Employee("Kumar", new BigDecimal(45000), 40));
		listOfEmployees.add(new Employee("Satish", new BigDecimal(35000), 30));
		listOfEmployees.add(new Employee("Raghav", new BigDecimal(55000), 45));
		listOfEmployees.add(new Employee("Anoop", new BigDecimal(15000), 20));
		
		listOfEmployees.forEach(employee -> System.out.println(employee.getAge() + "\t" + employee.getName() +"\t" + employee.getSalary()));
		
		// Sorting by age .. here we are passing the new instance of the class where the comparator logic is implemented.
		Collections.sort(listOfEmployees, new AgeComparatorOnEmployee());
		System.out.println("-----Sorting by age------");
		printEmployeeDetails(listOfEmployees);
		
		// sorting by name.. here we are initializing default constructor of employee class which has implemented the comparator logic for name comparisions.
		Collections.sort(listOfEmployees, new Employee());
		System.out.println("-----Sorting by name------");
		printEmployeeDetails(listOfEmployees);
		
		// in both these cases we have to pass the class instance which is implementing the comparator logic. But if I need to sort using salary, 
		//again I have to write logic in separate class or I must be modifying the ageComparator class which is mutation.
		// Hence Java 8 made it much easy find that example in  file.
	}
	
	public static void printEmployeeDetails(List<Employee> listOfEmployees){
		listOfEmployees.forEach(employee -> System.out.println(employee.getAge() + "\t" + employee.getName() +"\t" + employee.getSalary()));
	}
	
}
