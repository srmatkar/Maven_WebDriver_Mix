package interview;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RandomInterviewQuestions {
	
	
	WebDriver driver;
	JavascriptExecutor js;
	
	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver =  new ChromeDriver();
	}

	
	@Test(description = "Enter Text without using driver.sendkeys")
	public void enterTextUsingActions() {
		Actions act = new Actions(driver);
		WebElement we= null;
		act.sendKeys(we, "Hi");		
	}
	
	@Test(description = "Pressing enter in a text box")
	public void enterInTextBox() {
		WebElement we = null;
		we.sendKeys(Keys.ENTER);
	}
	
	@Test(description = "Different ways of openeing url")
	public void openUrls() {
		URL url = null;
		try {
			url = new URL("abc");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.get("StringURL");
		driver.navigate().to("String url");
		driver.navigate().to(url);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.location = 'https://www.google.com';");
	}
}
