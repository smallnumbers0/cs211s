import java.time.*;
import java.util.*;

public class MemberDriver {
	public static void main(String[] args) {
		List<Member> memberList = new ArrayList<>();
		memberList.add(new LifetimeMember("Alec Tricity", "111-111-1111", "atricity@mail.mail"));
		memberList.add(new BilledMember("Cory Ander", "111-111-1111", "cander@mail.mail", 1, 15));
		memberList.add(new LifetimeMember("Barry Cuwder", "111-111-1111", "barry@mail.mail", LocalDate.of(2020, 1, 1)));
		memberList.add(new BilledMember("Al. K Seltzer", "111-111-1111", "alkseltz@mail.mail"));
		memberList.add(new TrialMember("Guy Dinlite", "111-111-1111", "guyd@mail.mail"));
		memberList.add(new TrialMember("Hugh Dunit", "111-111-1111", "dunith@mail.mail", 14));
		memberList.add(new BilledMember("Dan Geruss", "111-111-1111", "danger@mail.mail", MonthDay.of(11,15)));
		memberList.add(new TrialMember("Ima B. Leever", "111-111-1111", "imab@mail.mail", LocalDate.of(2023,  7, 31)));
		memberList.add(new BilledMember("Faye Derway", "111-111-1111", "fayed@mail.mail"));
		memberList.add(new BilledMember("Eve O'Lution", "111-111-1111", "eve@mail.mail", LocalDate.of(2019,  5, 10), 12, 31));
		
		Random generator = new Random();
		int numberDays = 10;
		
		System.out.println("--------------------Members--------------------");
		for(Member member : memberList) {
			System.out.println(member);
		}
		
		for (int i = 0; i < numberDays; i++) {
			System.out.println("\n--------------------Simulating Day " + (i+1) + "--------------------");
			for (Member member : memberList) {
				if (generator.nextBoolean()) {	
					System.out.println();
					member.checkIn();
					
					if (generator.nextBoolean()) {
						member.requestTraining();
					}
					if(member instanceof TrialMember) {
						( (TrialMember) member).contactToJoin();
					}
					
					if(member instanceof BilledMember) {
						boolean billed = ( (BilledMember) member).hasBeenBilled();
						if(!billed) {
							System.out.println("Note: " + member.getName() + " has not yet been billed.");
						}
					}
					
					member.checkOut();
					System.out.println();
				}
			}
		}
	}
}
