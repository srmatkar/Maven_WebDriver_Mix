package testsForCI;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintGoogle {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		ChromeOptions co = new ChromeOptions();
		
co.setBinary("/opt/google/chrome/google-chrome");
	//	co.addArguments("--headless");
	//	System.setProperty("webdriver.chrome.driver", "");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(co);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void printPageTitle() {
		driver.get("https://www.google.com/");
		System.out.println("Page Title Is >>>> : " + driver.getTitle());
	}

}
