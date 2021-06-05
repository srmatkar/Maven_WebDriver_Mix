package interview;

import org.testng.annotations.Test;

public class TestNGAnnotationsMore {

	@Test
	public void WebStudentLogin() {
		System.out.println("Student login through web");
	}

	@Test
	public void MobileStudentLogin() {
		System.out.println("Student login through mobile");
	}
	
	@Test
	public void LSsoStudentLogin() {
		System.out.println("Student login through Single Sign-On");
	}
	
	

	@Test(dependsOnMethods = { "WebStudentLogin" })
	public void APIStudentLogin() {
		System.out.println("Student login through API");
	}

}
