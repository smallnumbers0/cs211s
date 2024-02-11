package factoryexample;

public class EmployeeFactory {
	
	public static Employee newEmployee(String type, int id) {    	
    	if(type.equalsIgnoreCase("FULL")) {
    		return new FullTimeEmployee(id);
    	} else if(type.equalsIgnoreCase("PART")) {
    		return new PartTimeEmployee(id);
    	} else {
    		throw new IllegalArgumentException(type + " is an invalid Employee type.");
    		// or return null
    	}
	} 
	public static Employee newEmployee(String type) {
		return EmployeeFactory.newEmployee(type, Employee.DEFAULT_ID);
	}
	
	public static Employee newDefaultEmployee(String type) {
		return EmployeeFactory.newEmployee(type);
	}
	

	public static FullTimeEmployee newFullTimeEmployee(int id) {
		// return of Employee: return EmployeeFactory.newEmployee("FULL", id);
		return new FullTimeEmployee(id);
		
	}
}
