import java.time.LocalDate;

public class TrialMember extends Member {
	
	private int numberTrialVisits;
	
	public static final int DEFAULT_TRIAL_VISITS = 7;
	
	public TrialMember(String name, String phone, String email, LocalDate joinDate, int numberTrialVisits) {
		super(name, phone, email, joinDate);
		this.numberTrialVisits = numberTrialVisits;
	}
	public TrialMember(String name, String phone, String email, LocalDate joinDate) {
		super(name, phone, email, joinDate);
		this.numberTrialVisits = DEFAULT_TRIAL_VISITS;
	}
	public TrialMember(String name, String phone, String email, int numberTrialVisits) {
		super(name, phone, email);
		this.numberTrialVisits = numberTrialVisits;
	}
	public TrialMember(String name, String phone, String email) {
		super(name, phone, email);
		this.numberTrialVisits = DEFAULT_TRIAL_VISITS;
	}

	public int getNumberTrialVisits() {
		return numberTrialVisits;
	}

	public void setNumberTrialVisits(int numberTrialVisits) {
		if(numberTrialVisits>=0) {
			this.numberTrialVisits = numberTrialVisits;
		}
	}
	
	@Override
	public void checkIn() {
		if(numberTrialVisits>0) {
			super.checkIn();
			numberTrialVisits--;
		} else {
			System.out.println("Error: " + super.getName() + " cannot check in. Trial visits have all been used.");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\t(Trial Membership)";
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof TrialMember otherMember) {
		return super.equals(otherMember)  &&
				this.numberTrialVisits==otherMember.numberTrialVisits;
		} else {
			return false;
		}
	}
	
	public void contactToJoin() {
		if(numberTrialVisits<3) {
			System.out.println("Staff should contact " + super.getName() + " to discuss a membership.");
		}
	}
	
	
}
