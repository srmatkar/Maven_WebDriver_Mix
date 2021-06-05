 package webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class ChromeOptionsRelated {

	@Test
	public void chromeMessaageDisabling() {
		System.setProperty(
				ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,
				"true");
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://techbeacon.com/");
		driver.quit();
	}

	@Test
	public void studyChromeOptions() {
		System.setProperty(
				ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,
				"true");
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");

		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
		
		//options.addArguments("disable-infobars");
		options.addArguments("--headless");
		options.addArguments("--disable-gpu");
	/*	DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability(ChromeOptions.CAPABILITY, options);*/

		WebDriver driver = new ChromeDriver(options);
		System.out.println("Headless browser launched");
		driver.get("https://www.google.com/");

		System.out.println(driver.getTitle());
		driver.quit();

	}
	@Test
	public void noChromeNotification() {
		
		ChromeOptions options = new ChromeOptions(); 
		options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"}); 
	
		System.setProperty(
				ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,
				"true");
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.arrkgroup.com");
		
	}
	
}
