package interview;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgAnnotationSequence {
	
	
	@BeforeSuite
	public void a() {
		System.out.println("Before Suite - executed");
	}
	@AfterSuite
	public void b() {
		System.out.println("After Suite - executed");
	}
	@AfterTest
	public void c() {
		System.out.println("After Test");
	}
	
	@AfterClass
	public void d() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void e() {
		System.out.println("B4 Method");
	}
	@BeforeTest
	public void f() {
		System.out.println("B4 Test");
	}
	@AfterMethod
	public void g() {
		System.out.println("After Method");
	}
	@BeforeClass
	public void h() {
		System.out.println("Before Class");
	}
	
	@Test
	public void i() {
		System.out.println("Test Case");
	}
}
