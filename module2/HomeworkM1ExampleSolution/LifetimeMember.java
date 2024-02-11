import java.time.LocalDate;

public class LifetimeMember extends Member {

	public LifetimeMember(String name, String phone, String email, LocalDate joinDate) {
		super(name, phone, email, joinDate);
	}
	public LifetimeMember(String name, String phone, String email) {
		super(name, phone, email);
	}
	
	@Override
	public String toString() {
		return super.toString() + "\tLifetime Member";
	}
	

}

