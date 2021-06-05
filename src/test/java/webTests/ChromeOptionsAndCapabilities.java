package webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOptionsAndCapabilities {

	static WebDriver driver;
	public static void main (String[] args) {
		
		WebDriverManager.chromiumdriver().setup();
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setAcceptInsecureCerts(true);
		ChromeOptions co = new ChromeOptions();
		co.merge(dc);
		driver = new ChromeDriver(co);
	}
}
