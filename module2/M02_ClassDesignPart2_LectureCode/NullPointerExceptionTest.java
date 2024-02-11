
public class NullPointerExceptionTest {
	
	public static void main(String[] args) {
		String first = "Jessica";
		String middle = "Lynn";
		String last = "Masters";
		
		System.out.println(findTotalLength(first, middle, last));
		
		middle = null;
		System.out.println(findTotalLength(first, middle, last));

	}
	
	public static int findTotalLength(String s1, String s2, String s3) {
		return s1.length() + s2.length() + s3.length();
	}

}
