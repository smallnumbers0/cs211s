import java.time.*;

// currently, this class only represents members billed once a year
// in a future extension, I will consider supporting more frequent billing
public class BilledMember extends Member {
	
	private MonthDay billingDate;


	public BilledMember(String name, String phone, String email, LocalDate joinDate, MonthDay billingDate) {
		super(name, phone, email, joinDate);
		this.billingDate = billingDate;
	}
	public BilledMember(String name, String phone, String email, LocalDate joinDate, int month, int day) {
		super(name, phone, email, joinDate);
		this.billingDate = MonthDay.of(month,  day);
	}
	public BilledMember(String name, String phone, String email, MonthDay billingDate) {
		super(name, phone, email);
		this.billingDate = billingDate;
	}
	public BilledMember(String name, String phone, String email, int month, int day) {
		super(name, phone, email);
		this.billingDate = MonthDay.of(month,  day);
	}
	public BilledMember(String name, String phone, String email) {
		super(name, phone, email);
		this.billingDate = MonthDay.of(LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
	}


	public MonthDay getBillingDate() {
		return billingDate;
	}
	public int getBillingDateMonth() {
		return billingDate.getMonthValue();
	}
	public int getBillingDateDay() {
		return billingDate.getDayOfMonth();
	}
	
	public void setBillingDate(MonthDay billingDate) {
		this.billingDate = billingDate;
	}
	
	public boolean hasBeenBilled() {
		int currentYear = LocalDate.now().getYear();
		LocalDate currentYearBillingDate = LocalDate.of(currentYear, billingDate.getMonth(), billingDate.getDayOfMonth());
		return LocalDate.now().compareTo(currentYearBillingDate) >= 0;		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof BilledMember otherMember) {
		return super.equals(otherMember)  &&
				this.billingDate.equals(otherMember.billingDate);
		} else {
			return false;
		}
	}

}