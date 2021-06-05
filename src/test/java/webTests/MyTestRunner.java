package webTests;

import org.testng.TestNG;

public class MyTestRunner {
	


	public static void main(String[] args) {
		
		TestNG testNg = new TestNG();
	    testNg.setTestClasses(new Class[]{NoImagesChrome.class});
	    testNg.run();
	
	}

}
