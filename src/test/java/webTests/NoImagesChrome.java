package webTests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class NoImagesChrome {
	
	@Test
	public void chromeImagesDisabling() {
		
		System.setProperty("webdriver.chrome.driver",
				".\\Drivers\\chromedriver83.exe");
		
		ChromeOptions options = new ChromeOptions();
		disableImages(options);
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		
		List<String> urls =  new ArrayList<String>();
		urls.add("https://www.amazon.in/");
		urls.add("https://www.flipkart.com/");
		urls.add("https://www.myntra.com/");
		
		Iterator<String> itr = urls.iterator();
		while (itr.hasNext()){
		
		driver.get(itr.next());
		System.out.println("PageTitle>>>>> " + driver.getTitle());
	
		}
		driver.quit();
	}

	public static void disableImages(ChromeOptions options){
		HashMap<String,Object> images = new HashMap<String,Object>();
		images.put("images", 2);
		HashMap<String,Object> preferences = new HashMap<String,Object>();
		preferences.put("profile.default_content_setting_values", images);
		options.setExperimentalOption("prefs", preferences);
		
	}
}
