package webTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

// https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/JavascriptExecutor.html

// The best way is to use dev tools console when we are not sure of javascript code
public class JavaScriptExecutor {
	WebDriver driver;
	JavascriptExecutor js ;
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
	}
	@Test
	public void jsWait() {
		
		 long start = System.currentTimeMillis();
		 js.executeAsyncScript("window.setTimeout(arguments[arguments.length-1], 1000);");
		 long end = System.currentTimeMillis();
		 System.out.println(end-start);
		
	}
	
	
	@Test
	public void clickWe() {
		WebElement we = null;
		js.executeScript("arguments[0].click();", we);		
		
	}
	
	@Test
	public void javaScriptSendkeys() {
		js.executeScript("document.getElementByName('emailId')[0].value('srmatkar')");
	}
	//document.getElementById()
	//document.getElementByClassName()
	//document.getElementByName()
	//document.getElementByTagName()
	
	
	@Test(description="Highlight webelement")
	public void highlight() {
		WebElement we = null;
		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", we);
	}
	
	@Test(description = "Highlight input elements on screen")
	public void hl_inputs() {
		driver.get("https://www.saucedemo.com/");
		List<WebElement> inputs = driver.findElements(By.cssSelector(".form_input"));
		for (WebElement input: inputs ) {
			
			js.executeScript("arguments[0].setAttribute('style', 'background:yellow; border:5px solid red');", input);
		}
	}
	
	@Test(description = "Alert")
	
	public void induceAlert() {
		driver.get("https://www.saucedemo.com/");
		js.executeScript("alert('WelCome Shailendra');");
	}

	
	// JavaScript Page Properties
	
	@Test
	public void javaScriptNavigation() {
		driver.get("https://www.saucedemo.com/");
		String domainName = js.executeScript("return document.domain;").toString();
		String url = js.executeScript("return document.URL;").toString();
		String pageTitle = js.executeScript("return document.title;").toString();
		
		System.out.println("The Domain is : " + domainName + "\nAnd URL is " +url + "\nAnd page has Title " + pageTitle);
		
	}
	
	// JavaScript get new url 
	@Test
	public void javaScriptNavigateToUrl() {
		js.executeScript("window.location = 'https://www.google.com';");
		
	}
	
	//JavaScript scroll element into view
	 @Test
	 public void scrollIntoView() {
		 WebElement element = null;
		 js.executeScript("window.scrollBy(0,600);");
		 js.executeScript("arguments[0].scrollIntoView(true);",element);
				 
	 }
	 
	 //JavaScript refresh
	 @Test
	 public void jsRefreshwebPage() {
		 js.executeScript("window.location = 'https://www.google.com';");
		 js.executeScript("history.go(0);");
		 
	 }
	
	
	
}
