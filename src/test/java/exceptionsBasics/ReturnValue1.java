package exceptionsBasics;

public class ReturnValue1

{
	public static void main(String[] args) {

		/*
		 * 1) If finally block returns a value then try and catch blocks may or may not
		 * return a value.
		 * 
		 * 2) If finally block does not return a value then both try and catch blocks
		 * must return a value.
		 */
		System.out.println(methodReturningValue());
		System.out.println(methodReturningValue1());
	}

	static String methodReturningValue() {
		String s = null;
		try {
			s = "return value from try block";
			return s;
		} catch (Exception e) {
			s = s + "return value from catch block";
			return s;
		} finally {
			s = s + "return value from finally block";
		}
	}

	static int methodReturningValue1() {
		int i = 0;

		try {
			i = 1;
			return i;
		} catch (Exception e) {
			i = 2;
			return i;
		} finally {
			i = 3;
			// return i;
		}
	}
}