package singletons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumSingleton {
	

	// instance of singleton class
	private static SeleniumSingleton instanceOfSingletonBrowserClass=null;

	private WebDriver driver;
	
	private SeleniumSingleton() {
		
		System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	//public method which checks and returns instance only once
	
	public static SeleniumSingleton getInstance() {
		
		 if(instanceOfSingletonBrowserClass==null){
	        	instanceOfSingletonBrowserClass = new SeleniumSingleton();
	        }
		
		
		return instanceOfSingletonBrowserClass;
	}
	  
	// To get driver
    public WebDriver getDriver()
    {
    	System.out.println("returning driver");
    	return driver;
    }


}
