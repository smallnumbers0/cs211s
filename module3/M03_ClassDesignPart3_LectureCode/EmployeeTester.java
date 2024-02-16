import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class EmployeeTester {

	public static void main(String[] args) {
		
		ArrayList<Employee> employeeList = new ArrayList<>();
		employeeList.add(new FullTimeEmployee(956, "Frankie FullTime", Status.ACTIVE));
		employeeList.add(new PartTimeEmployee(492, "Pat PartTime"));
		employeeList.add(new FullTimeEmployee(145, "Ralphy Retired", Status.INACTIVE_PERM));
		employeeList.add(new PartTimeEmployee(673, "Lynn LowHours", 5));
		employeeList.add(new PartTimeEmployee(241, "Nancy NearlyFull", 38));
		employeeList.add(new PartTimeEmployee(397, "Pat PartTime"));
				
		System.out.println("\nList:");
		for(Employee emp : employeeList) {
			System.out.println(emp);
		}

//		Collections.sort(employeeList);
//		System.out.println("\nSorted List (By ID):");
//		for(Employee emp : employeeList) {
//			System.out.println(emp);
//		}
		
		Collections.sort(employeeList, Employee.NAME_ID_COMPARATOR);
		System.out.println("\nSorted List (By Name):");
		for(Employee emp : employeeList) {
			System.out.println(emp);
		}
				
		
		ArrayList<PartTimeEmployee> partTimeEmployee = new ArrayList<>();
		partTimeEmployee.add(new PartTimeEmployee(492, "Pat PartTime"));
		partTimeEmployee.add(new PartTimeEmployee(673, "Lynn LowHours", 5));
		partTimeEmployee.add(new PartTimeEmployee(241, "Nancy NearlyFull", 38));
		partTimeEmployee.add(new PartTimeEmployee(397, "Pat PartTime"));
		
		Collections.sort(partTimeEmployee);
		System.out.println("\nSorted List (By ID):");
		for(PartTimeEmployee emp : partTimeEmployee) {
			System.out.println(emp);
		}
		
		Collections.sort(partTimeEmployee, new PartTimeEmployee.HourComparator());
		System.out.println("\nSorted List (By Number of Hours):");
		for(PartTimeEmployee emp : partTimeEmployee) {
			System.out.println(emp);
		}		
		
		
		System.out.println("All possible status values for full time employees:");
		Status[] possibleStatusValues = Status.values();
		for(Status s : possibleStatusValues) {
			System.out.println("\t" + s + " (" + s.getStatusCode() + ")");
		}
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the employee name:");
		String name = scan.nextLine();
		
		System.out.println("Enter the id:");
		int id = Integer.parseInt(scan.nextLine());
		
		System.out.println("Enter the status:");
		String statusString = scan.nextLine();
		Status status = Enum.valueOf(Status.class, statusString);
		
		FullTimeEmployee f = new FullTimeEmployee(id, name, status);
		System.out.println(f);
		scan.close();
	}



}
