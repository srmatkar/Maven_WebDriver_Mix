package testsForCI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EasyHrWorld {
	WebDriver driver;
	WebDriverWait wait;
	private WebElement we;
	
	@BeforeClass
	public void setUp(ITestContext context) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 90);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		context.setAttribute("driver", driver);
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void validLogin() {
		driver.get("https://arrkgroup.easyhrworld.com/");
		driver.findElement(By.id("username")).sendKeys("shailendra.matkar@arrkgroup.com");
		driver.findElement(By.id("password")).sendKeys("Advait@3011");
		driver.findElement(By.id("btnSignin")).click();
		waitForElement(By.cssSelector("h3.media-heading"));
		Assert.assertTrue(getText(By.cssSelector("small strong")).contains("Shailendra"), "Not Logged In");

	}
	
	@Test
	public void inValidLogin() {
		driver.get("https://arrkgroup.easyhrworld.com/");
		driver.findElement(By.id("username")).sendKeys("shailendra.matkar@arrkgroup.com");
		driver.findElement(By.id("password")).sendKeys("Advait@3011");
		driver.findElement(By.id("btnSignin")).click();
		waitForElement(By.cssSelector("h3.media-heading"));
		Assert.assertTrue(getText(By.cssSelector("small strong")).contains("DeliberateFail"), "Not Logged In");

	}

	private String getText(By by) {
		return driver.findElement(by).getText();
	}

	public void waitForElement(By by) {
		we = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

}
