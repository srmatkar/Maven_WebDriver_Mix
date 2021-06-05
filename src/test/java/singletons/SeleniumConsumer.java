package singletons;

import org.openqa.selenium.WebDriver;

public class SeleniumConsumer {

	
	public static void main (String args[]) {
		
		SeleniumSingleton sel1 = SeleniumSingleton.getInstance();
		WebDriver driver1 = sel1.getDriver();
		driver1.get("http://www.arrkgroup.com");
		
		
		SeleniumSingleton sel2 = SeleniumSingleton.getInstance();
		WebDriver driver2 = sel2.getDriver();
		driver2.get("https://www.google.com");
	}
}
