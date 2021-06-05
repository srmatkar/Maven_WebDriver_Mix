package interview;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class FileDownloadBrowserOptions {

	@Test
	public void downloadFiles() {
		System.setProperty(
				ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY,
				"true");
		System.setProperty("webdriver.chrome.driver",
				"src//test//resources//Drivers//chromedriver87.exe");

		String fileDownloadPath = "src//test//java//interview//Downloaded_Files";

		Map<String, Object> preferenceMap = new HashMap<String, Object>();
		preferenceMap.put("profile.default_content_settings.popups", 0);
		preferenceMap.put("download.default_directory", fileDownloadPath);

		ChromeOptions co = new ChromeOptions();
		co.setExperimentalOption("prefs", preferenceMap);
		co.addArguments("--test-type");
		co.addArguments("--disable-extensions");
		co.addArguments("--start-maximized");
		//co.addArguments("headless");
		co.addArguments("--disable-gpu");
		co.addArguments("disable-infobars");

		WebDriver driver = new ChromeDriver(co);

		driver.get("https://arrkgroup.easyhrworld.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(
				"shailendra.matkar@arrkgroup.com");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("Advait@3011");
		driver.findElement(By.id("btnSignin")).click();

		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("https://arrkgroup.easyhrworld.com/quick_links");
		driver.findElement(By.linkText("Arrk Holiday List 2020"));
		System.out.println("Downloaded");
	}

}
