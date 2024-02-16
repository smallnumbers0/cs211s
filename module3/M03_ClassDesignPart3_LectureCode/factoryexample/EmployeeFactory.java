package factoryexample;

public class EmployeeFactory {
	
	public static enum EmployeeType{
		FULL, PART;
		
		public static EmployeeType getEmployeeType(String typeString) {
			for(EmployeeType type : EmployeeType.values()) {
				if(typeString.equalsIgnoreCase(type.toString())) {
					return type;
				}
			}
    		throw new IllegalArgumentException(typeString + " is an invalid Employee type.");
    		// or return null
		}
	}
	
	public static Employee newEmployee(EmployeeType type, int id) {    	
    	if(type.equals(EmployeeType.FULL)) {
    		return new FullTimeEmployee(id);
    	} else if(type.equals(EmployeeType.PART)) {
    		return new PartTimeEmployee(id);
    	} else {
    		throw new IllegalArgumentException(type + " is an invalid Employee type.");
    		// or return null
    	}
	} 
	public static Employee newEmployee(String type, int id) {
		return EmployeeFactory.newEmployee(EmployeeType.getEmployeeType(type), id);
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
