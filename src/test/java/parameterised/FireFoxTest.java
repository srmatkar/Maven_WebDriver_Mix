package parameterised;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FireFoxTest {
	WebDriver driver;
	
	
	@BeforeClass
	public void setUp() {
		
	WebDriverManager.firefoxdriver().setup();
	driver = new FirefoxDriver();
		
	}
	
	
	@Test
	public void openEasyHrWorld() {
		driver.get("https://arrkgroup.easyhrworld.com/");
	}

	@Test
	public void openSeleniumDev() {
		driver.get("https://www.selenium.dev/");
	}
	

	@Test
	public void openTOI() {
		driver.get("https://timesofindia.indiatimes.com/");
	}
	
	 
	
	@AfterClass
	public void tearDown() {
	if(driver!=null) {
		driver.quit();
	}
		
	}

}
