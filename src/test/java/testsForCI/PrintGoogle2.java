package testsForCI;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PrintGoogle2 {
	WebDriver driver;

	@BeforeClass
	public void setUp() throws MalformedURLException {

		String remote_url_chrome = "http://localhost:4445/wd/hub";
		ChromeOptions co = new ChromeOptions();
		co.addArguments("--headless");
		// System.setProperty("webdriver.chrome.driver", "");
		// WebDriverManager.chromedriver().setup();
		driver = new RemoteWebDriver(new URL(remote_url_chrome), co);
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	}

	@Test
	public void printPageTitle() {
		driver.get("https://www.google.com/");
		System.out.println("Page Title Is For docker>>>> : " + driver.getTitle());
	}

}
