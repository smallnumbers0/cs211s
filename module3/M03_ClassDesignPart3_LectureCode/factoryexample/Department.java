package factoryexample;

import java.util.*;

public class Department {

    private List<Employee> employeeList;
    
    public Department() {
        employeeList = new ArrayList<>();
    }
    
    public boolean addEmployee(Employee e) {
        return employeeList.add(e);
    }
    public boolean addEmployee(String type, int id) {
    	Employee emp = EmployeeFactory.newEmployee(type, id);
    	return addEmployee(emp);
    	
    }
 
    public void conductReview(Employee employee) {
    	employee.review();
    }  
    public void conductReview(String type, int id) {
    	Employee emp = EmployeeFactory.newEmployee(type, id);

    	conductReview(emp);
    }
    public void reviewAllEmployees() {
    	for(Employee employee: employeeList) {
    		conductReview(employee);
    	}
    }
    public void processAllEmployees() {
    	for(Employee employee : employeeList) {
    		employee.process();
    	}
    }

    
}
