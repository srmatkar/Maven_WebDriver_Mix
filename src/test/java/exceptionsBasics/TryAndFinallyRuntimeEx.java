package exceptionsBasics;

public class TryAndFinallyRuntimeEx {

	public static void main(String[] args) {

		TryAndFinallyRuntimeEx tna = new TryAndFinallyRuntimeEx();
		tna.noCatch();

	}

	public void noCatch() {
		
		int x = 0;
		try {
			 x = 100/0;
			 System.out.println("I am x: " + x);
		}
	
		
		finally{
		
			System.out.println("I am finally x : " + x);
		}

	

	}

}
