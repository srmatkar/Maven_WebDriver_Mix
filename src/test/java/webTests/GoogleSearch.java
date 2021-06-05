package webTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleSearch {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		if (driver!=null) {
			driver.quit();
		}
		
	}

	@Test
	public void getGoogleSearchItemByName() {
		driver.get("http://google.com");
		driver.findElement(By.name("q")).sendKeys("indraneel");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> allRes = driver.findElements(By.xpath("//ul[@role = 'listbox']/li"));
		System.out.println("ResultSize>>> " + allRes.size());
		for (WebElement res : allRes) {

			WebElement candidateRes = res.findElement(By.cssSelector("span"));
			  if(candidateRes.getText().contains("indraneel meaning")) {
			  
			  candidateRes.click();
			  break;
			  }
			 
		}

	}

}
