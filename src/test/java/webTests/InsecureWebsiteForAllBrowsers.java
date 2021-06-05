package webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

public class InsecureWebsiteForAllBrowsers {
	
	WebDriver driver;
	
	

	@Test
	public void openInsecureWebsiteInChrome() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true);
		options.addArguments("--start-maximized");
		options.addArguments("--disable-infobars");
		options.addArguments("--silent");
//		options.addArguments("test-type");
//		options.addArguments("--window-size=1920,1080");
//		options.addArguments("--enable-precise-memory-info");
//		options.addArguments("--disable-popup-blocking");
//		options.addArguments("--disable-default-apps");
//		options.addArguments("test-type=browser");
		driver = new ChromeDriver(options);
		driver.get("https://pbn.arrkgroup.co.uk/whizibleSEM");
	}
	
	@Test
	public void openInsecureWebsiteInFF() {
		System.setProperty("webdriver.gecko.driver", ".\\Drivers\\geckodriver.exe");
		
		FirefoxOptions ffo = new FirefoxOptions();
		//The default is true for firefox this trial is to show how it behaves when setAcceptInsecureCerts is false
		ffo.setAcceptInsecureCerts(false);
		driver = new FirefoxDriver(ffo);
		driver.get("https://pbn.arrkgroup.co.uk/whizibleSEM");
	}
	
	/*
	 * @Test public void openInsecureWebsiteinIE() { DesiredCapabilities
	 * capabilities = new DesiredCapabilities();
	 * capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	 * capabilities.setCapability(InternetExplorerDriver.
	 * INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	 * InternetExplorerOptions ieo = new InternetExplorerOptions(capabilities);
	 * System.setProperty("webdriver.ie.driver",".\\Drivers\\IEDriverServer.exe");
	 * driver = new InternetExplorerDriver(ieo);
	 * driver.get("https://pbn.arrkgroup.co.uk/whizibleSEM"); }
	 */
	
	
	@Test
	public void openInsecureWebsiteinEdge() {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		EdgeOptions opt =  new EdgeOptions();
		opt.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, false);
		System.setProperty("webdriver.edge.driver",".\\Drivers\\msedgedriver.exe");
		driver = new EdgeDriver(opt);
		driver.get("https://pbn.arrkgroup.co.uk/whizibleSEM");
	}
	
	
	
}
