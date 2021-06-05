package webTests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BootstrapDropDown {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// WebDriverManager.chromedriver().setup();
		// driver = new ChromeDriver();
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		//WebDriverManager.firefoxdriver().setup();
	//	driver = new FirefoxDriver();

		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
	}

	@AfterClass
	public void tearDown() {
	//	driver.close();
	//	if (driver != null) {
	//		driver.quit();
	//	}
	}

	@Test
	public void selectFromDropDown() {
		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
		driver.findElement(By.xpath("//button[@data-toggle='dropdown']")).click();
		List<WebElement> opts = driver
				.findElements(By.xpath("//ul[@class='multiselect-container dropdown-menu']/li/a/label"));
		for (WebElement opt : opts) {
			if (opt.getText().contains("Angular")) {
				opt.click();
				break;
			}

		}

	}

}
