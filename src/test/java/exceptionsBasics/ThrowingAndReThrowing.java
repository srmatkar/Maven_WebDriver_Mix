package exceptionsBasics;

public class ThrowingAndReThrowing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			methodWithThrow();
		} catch (Exception e) {
			System.out.println("Exception caught in main");
			//e.printStackTrace();
		}
		
	}
	
	
	static void methodWithThrow(){
		
		String s = null;
		
		try {
			System.out.println(s.length());
		} catch (NullPointerException ne) {
			System.out.println("Null Pointer Exception Caught here");
			ne.printStackTrace();
			throw ne;
		}
		
	}

}
