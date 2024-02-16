package factoryexample;

public class FullTimeEmployee extends Employee {
		
	public FullTimeEmployee(int id) {
		super(id); 
	}
	

	@Override
	public void process() {
		System.out.println(super.getId() + " has been full-time processed.");
	}
	
	@Override
	public void benefits() {
		System.out.println("Issuing benefits to " + super.getId());
	}
	
	public void bonus() {
		System.out.println(super.getId() + " is being paid a bonus.");
	}
	
	
	
}
