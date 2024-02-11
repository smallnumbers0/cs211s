import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeTester {

	public static void main(String[] args) {
		Employee e01 = new FullTimeEmployee(956, "Frankie FullTime");
		Employee e02 = new PartTimeEmployee(372, "Pat PartTime");
		
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(e01);
		employeeList.add(e02);
		employeeList.add(new FullTimeEmployee(145, "Ralphy Retired"));
		employeeList.add(new PartTimeEmployee(673, "Lynn LowHours", 5));
		employeeList.add(new PartTimeEmployee(241, "Nancy NearlyFull", 38));
		employeeList.add(new PartTimeEmployee(492, "Pat PartTime"));
		
		System.out.println("How many employees created? " + Employee.getNumberOfEmployees());
		System.out.println("How many hours worked accross ALL part time employees? " + PartTimeEmployee.getTotalNumberHoursWorked());

		if(e02 instanceof PartTimeEmployee) {
			( (PartTimeEmployee) e02).setNumHours(25);	
		}
		
		System.out.println("How many hours worked accross ALL part time employees? " + PartTimeEmployee.getTotalNumberHoursWorked());

		
		String s1 = "apple";
		String s2 = "zebra";
		
		System.out.println(s2.compareTo(s1));
		
		ArrayList<String> wordList = new ArrayList<>();
		wordList.add(s1);
		wordList.add(s2);
		wordList.add("hello");
		wordList.add("goodbye");
		System.out.println(wordList.toString());
		Collections.sort(wordList); // this sorting method relies on compareTo method
		// this only works because String implements Comparable
		System.out.println(wordList.toString());
		
		System.out.println(employeeList);
		Collections.sort(employeeList);
		System.out.println(employeeList);
		
		for(Employee e : employeeList) {
			e.benefits();
		}
		
		for(Employee e : employeeList) {
			System.out.println(e);
		}
		
		
	}

}
