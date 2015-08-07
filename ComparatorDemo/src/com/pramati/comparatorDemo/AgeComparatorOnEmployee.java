//This class implements comparator interface to provide the logic for the comparison on age, if needed on name or other attribute
//you may have to write another class for that which is painful. Java 8 provides a solution for it.
package com.pramati.comparatorDemo;
import java.util.Comparator;

public class AgeComparatorOnEmployee implements Comparator<Employee>{

	@Override
	public int compare(Employee o1, Employee o2) {
		// Comparing the ages
		return o1.getAge() - o2.getAge();
	}

}
