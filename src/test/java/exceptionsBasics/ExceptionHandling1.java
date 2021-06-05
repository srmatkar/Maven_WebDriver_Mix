package exceptionsBasics;

public class ExceptionHandling1 {
	public static void main(String[] args) {
		try {
			String s = null;

			System.out.println(s.length()); // This statement throws NullPointerException

			System.out.println("This statement will not be executed");
		} catch (Exception ex) {
			System.out.println(ex); // Output : java.lang.NullPointerException

			ex.printStackTrace(); // This prints stack trace of exception
		} finally {
			System.out.println("This block is always executed");
		}
	}
}