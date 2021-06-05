package webTests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {
	WebDriver driver;
	


	
	@Test
	public void scnsht() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("id")).sendKeys("JustForFail");
	}
	
	@AfterTest
	public void terdown(ITestResult itr) {
		
		String testName = itr.getName();
		
		System.out.println(testName + " "+ itr.getStatus());
		
		if (ITestResult.FAILURE ==itr.getStatus()) {
			takeScreenshot(testName);
		}
		
		driver.quit();
		
	}
	
	private void takeScreenshot(String screenshotName) {
		
		try {
			TakesScreenshot ts=(TakesScreenshot)driver;
			 
			File source=ts.getScreenshotAs(OutputType.FILE);
			 
			FileUtils.copyFile(source, new File(".\\target\\"+screenshotName+".png"));
			 
			System.out.println("Screenshot taken");
			
		} catch (Exception exp){
			System.out.println("Exception while taking screenshot "+exp.getMessage());			
		}
	}

}
