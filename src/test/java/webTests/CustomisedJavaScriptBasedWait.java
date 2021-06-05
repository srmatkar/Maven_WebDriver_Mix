package webTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CustomisedJavaScriptBasedWait {

	WebDriver driver;
	static JavascriptExecutor js;
	static String jsCommand = "return document.readyState";

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;

	}

	public static void waitForJStoLoad(int timeOutInSeconds) {

		// Validate readyState before doing any waits
		if (js.executeScript(jsCommand).toString().equals("complete")) {
			return;
		}

		for (int i = 0; i < timeOutInSeconds; i++) {
			if (js.executeScript(jsCommand).toString().equals("complete")) {
				break;
			}
		}

	}
}
