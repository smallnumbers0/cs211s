import java.util.Comparator;

public abstract class Employee implements Comparable<Employee> {
	
	private int id;
	private String name;
	
	private static int numEmployees = 0;
	
	public static final int DEFAULT_ID = 0;

	
	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
		
		Employee.numEmployees++;
	}
	
	public static final Comparator<Employee> NAME_ID_COMPARATOR = new NameIDComparator();
	private static class NameIDComparator implements Comparator<Employee> {
		public int compare(Employee emp1, Employee emp2) {
			if(!emp1.name.equalsIgnoreCase(emp2.name)) {
				return emp1.name.compareToIgnoreCase(emp2.name);
			} else {
				return Integer.compare(emp1.id, emp2.id);
			}
		}
	}
	
	public static final Comparator<Employee> NAME_COMPARATOR = new NameComparator();
	// public static final NameComparator NAME_COMPARATOR = new NameComparator();

	private static class NameComparator implements Comparator<Employee> {
		
		public int compare(Employee emp1, Employee emp2) {
			return emp1.name.compareToIgnoreCase(emp2.name);
		}
		
	}

	public Employee(String name) {
		this(DEFAULT_ID, name);
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setId(int id) {
		if(id >= 0) {
			this.id = id;
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public static int getNumberOfEmployees() {
		return Employee.numEmployees;
	}

	@Override
	public String toString() {
		return name + " (ID: " + id + ")";
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee) {
			Employee otherEmployee = (Employee) obj;
			
			int otherEmployeeId = otherEmployee.id;
			String otherEmployeeName = otherEmployee.name;
			
			if(id==otherEmployeeId && name.equalsIgnoreCase(otherEmployeeName)) {
				return true;
			} else {
				return false;
			}
			
		} else {
			return false;
		}
		
	}
	
	@Override
	public int compareTo(Employee emp) {
			return Integer.compare(id,  emp.id); 
	}

	
	public void pay() {
		System.out.println("Paying " + name);
	}
	public void review() {
		System.out.println(name + " is undergoing annual review.");
	}
	public abstract void benefits();
	public abstract void timeOff();
	
	
	
}
