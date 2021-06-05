package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DynamicDataLoading {
	WebDriver driver;

	@BeforeClass
	public void setup() {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void dynamicAjax() {
		
		driver.get("https://www.seleniumeasy.com/test/dynamic-data-loading-demo.html");
		driver.findElement(By.id("save")).click();
		WebDriverWait wait = new WebDriverWait(driver, 18);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div/img")));
		System.out.println(driver.findElement(By.cssSelector("#loading")).getText().contains("First"));
	
		
	}

}
