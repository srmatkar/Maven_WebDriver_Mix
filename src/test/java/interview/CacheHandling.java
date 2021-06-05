package interview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CacheHandling {
	
	WebDriver driver;
	JavascriptExecutor js ;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\Chromedriver89.exe");
		driver = new ChromeDriver();

		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

	}
	
	@Test
	public void clearCache() throws InterruptedException {
		driver.get("https://www.google.com");
		WebElement we = null;
		js.executeScript("window.localStorage.clear()",we);
		js.executeScript("window.sessionStorage.clear()",we);
		Thread.sleep(8000);
		
	}
	


}
