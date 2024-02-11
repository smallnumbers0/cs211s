package factoryexample;

public class HRDepartment extends Department {

	public HRDepartment() {
		super();
	}

	public void hire(Employee emp) {
		// code to hire
	}
	
	public void hire(String type, int id) {
    	Employee emp = EmployeeFactory.newEmployee(type, id);
    	hire(emp);
	}

}
