package webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class FirefoxHeadless {

	@Test
	public void ffHeadless() {

		FirefoxOptions op = new FirefoxOptions();
		op.setHeadless(true);
	
		System.setProperty("webdriver.gecko.driver",
				".\\Drivers\\geckodriver.exe");
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE,"true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE,".\\WebDriverLogs\\firefox.txt");

		WebDriver driver = new FirefoxDriver(op);
		driver.get("https://techbeacon.com/");
		System.out.println("PageTitle:::: "+ driver.getTitle());
		driver.quit();

	}

}
