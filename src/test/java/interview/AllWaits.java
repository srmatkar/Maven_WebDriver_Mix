package interview;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AllWaits {
	WebDriver driver;
	
	@BeforeTest
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void search() {
		driver.get("https://google.com");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement search = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		search.sendKeys("shailendra");
		
	}
	
	@Test
	public void fluentWaitSample() {
		driver.get("https://google.com");
		Wait<WebDriver> wa = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(5, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		
	}
	
	@Test(description = "Stale element reference")
	public void stale() {
		driver.get("https://google.com");
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table")));
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(driver.findElement(By.name("q")))));
		
	}
	

}
