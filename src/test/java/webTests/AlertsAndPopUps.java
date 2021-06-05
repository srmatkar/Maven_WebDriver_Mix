package webTests;

//References
//https://www.toolsqa.com/selenium-webdriver/alerts-in-selenium/

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsAndPopUps {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test(enabled = false)
	public void informationalAlert() {
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("alertButton")).click();
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println("AlertText: >> " + simpleAlert.getText());
		simpleAlert.accept();

	}

	@Test(enabled = false)
	public void promptAlert() {

		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("promtButton")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println("Prompt Alert Text : >> " + promptAlert.getText());
		promptAlert.sendKeys("Shailendra");
		promptAlert.accept();
	}

	@Test(enabled = true)
	public void timerAlert() {
		try {
			driver.get("https://demoqa.com/alerts");
			driver.findElement(By.id("timerAlertButton")).click();
			WebDriverWait expwait = new WebDriverWait(driver, 20);
			expwait.until(ExpectedConditions.alertIsPresent());
			Alert delayedAlert = driver.switchTo().alert();
			delayedAlert.accept();
			System.out.println("Unexpected alert accepted");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No alert encountered");
			e.printStackTrace();
		}

	}

	@Test
	public void confirmationAlert() {
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmationAlert = driver.switchTo().alert();
		confirmationAlert.accept();
	}
}
