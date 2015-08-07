package com.pramati.comparatorDemo;

import java.util.Comparator;

public class AgeComparatorOnEmployee implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// Comparing the ages
		return o1.getAge() - o2.getAge();
	}

}
