package abi;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbiAlert {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
//		 if (driver != null) {
//		 driver.quit();
//		 }
	}

	@Test
	public void testalert() throws InterruptedException {
		driver.get("https://beta.barbour-abi.com/");
		driver.findElement(By.cssSelector("button.btn-block.primary-btn")).click();
		System.out.println("Text is> " + driver.findElement(By.cssSelector("span.message span")).getText());

	}


}
