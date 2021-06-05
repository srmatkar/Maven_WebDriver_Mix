package parameterised;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ParameterisedTest extends TestBaseForParameterisedTest {

	@Test(priority = -2)
	public void loginTest() {

		System.out.println("The thread ID for loginTest is " + Thread.currentThread().getId());
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("shailendra.matkar@arrkgroup.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Advait@3011");
		driver.findElement(By.id("btnSignin")).click();

	}

	@Test(priority = 2)
	public void pageTitleTest() {
		System.out.println("The thread ID for pagetitleTest  is " + Thread.currentThread().getId());
		String pageTitle = driver.getTitle();
		Assert.assertTrue(pageTitle.equals("Employee - Sign in | EasyHR"), "Incorrect page tirle");
	}

	@Test(priority = 0)
	public void pageHeaderTest() {
		System.out.println("The thread ID for page header test  is " + Thread.currentThread().getId());
		String pageheader = driver.findElement(By.cssSelector("h2.text-center")).getText();
		Assert.assertTrue(pageheader.equals("Welcome to EasyHR Employee"), "Incorrect Page Header");
	}

}
