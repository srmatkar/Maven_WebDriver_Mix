package listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//This is setting up Listener at Class level
//@Listeners(listeners.ListenerTest.class)

public class SampleTest {

	WebDriver driver;

	@BeforeClass
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tesrDown() {
		if ((driver != null)) {
			driver.quit();
		}
	}

	@Test
	public void login() {
		System.out.println("This is a login test");
		driver.get("https://www.google.com/");
		Assert.assertTrue(true);
	}

	@Test
	public void loginFailed() {
		System.out.println("This is a login deliberate fail  test");
		driver.get("https://www.google.com/");
		Assert.assertTrue(false);
	}
}
