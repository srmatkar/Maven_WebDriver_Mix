package webTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HighLightElements {

	WebDriver driver;
	JavascriptExecutor js;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;

	}

	@Test(enabled=false)
	public void highlight() {
		driver.get("https://arrkgroup.easyhrworld.com/");
		WebElement uName = driver.findElement(By.id("username"));
		findElement(driver, uName, js);

	}
	
	
	@Test(enabled=true)
	public void loginWithHighlight() {
		driver.get("https://arrkgroup.easyhrworld.com/");
		highlightedElement(driver, js, By.id("username")).sendKeys("shailendra.matkar@arrkgroup.com");
		highlightedElement(driver, js, By.id("password")).sendKeys("Advait@3011");
		highlightedElement(driver, js, By.id("btnSignin")).click();
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();

		}

	}

	private void findElement(WebDriver driver, WebElement we, JavascriptExecutor jse) {

		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style','background:yellow; border: 3px solid red');", we);
		we.sendKeys("Shailendra");
	}
	
	private WebElement highlightedElement(WebDriver driver,JavascriptExecutor jse, By by ) {
		WebElement we = driver.findElement(by);
		jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style','background:yellow; border: 3px solid red');", we);
		return we;
	}
}
