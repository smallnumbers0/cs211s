import java.time.*;

public abstract class Member {
	
	private String name, phone, email;
	private LocalDate joinDate;
	
	public Member(String name, String phone, String email, LocalDate joinDate) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.joinDate = joinDate;
	}
	public Member(String name, String phone, String email) {
		this(name, phone, email, LocalDate.now());
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	@Override
	public String toString() {
		return name + "\tPhone: " + phone + "\temail: " + email + "\tJoined: " + joinDate; 
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member otherMember) {
		return this.name.equalsIgnoreCase(otherMember.name) &&
				this.phone.equalsIgnoreCase(otherMember.phone) &&
				this.email.equalsIgnoreCase(otherMember.email) &&
				this.joinDate.equals(otherMember.joinDate);
		} else {
			return false;
		}
	}
	
	public void checkIn() {
		System.out.println(name + " is entering the gym.");
	}
	public void checkOut() {
		System.out.println(name + " is exiting the gym.");
	}
	public void requestTraining() {
		System.out.println("Submitting request for training:\t" + name + "\t" + phone + "\t" + email);
	}
	
	
	// hw1: three child classes
	// three methods
	// driver
	
	// hw2: 
	// static var and method: number in the gym, number of members
	// comparable
	// factory
	
	// hw3: 
	// enum- how to pay  or class pref (yoga, spin, weight)
	// comparator
	// interactive

}
