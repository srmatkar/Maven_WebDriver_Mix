package webTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleGeolocationPopUp {
	WebDriver driver;

	@SuppressWarnings("deprecation")
	@BeforeClass
	public void setUp() {
		
		FirefoxProfile geoDisabled = new FirefoxProfile();
		geoDisabled.setPreference("geo.enabled", false);
		geoDisabled.setPreference("geo.provider.use_corelocation", false);
		geoDisabled.setPreference("geo.prompt.testing", false);
		geoDisabled.setPreference("geo.prompt.testing.allow", false);
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, geoDisabled);
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver(capabilities);
	}

	@Test
	public void disableGeoLocation() {
		driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_geolocation");
		driver.findElement(By.xpath("//p/button")).click();
		System.out.println(driver.findElement(By.xpath("//body/p")).getText());

	} 

}
