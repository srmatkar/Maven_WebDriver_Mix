package webTests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownSortingUsingArrayList {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void dropDown() {
		
		driver.get("http://seleniumpractise.blogspot.com/2019/01/dropdown-demo-for-selenium.html");
		WebElement toolsdropDown = driver.findElement(By.id("tools1"));
		Select select = new Select(toolsdropDown);
		
		List<String> defaultList = new ArrayList<String>();
		
		List<WebElement> allOptions = select.getOptions();
		allOptions.forEach(option -> defaultList.add(option.getText()));
		
		List<String> tempList = new ArrayList<String>();
		tempList.addAll(defaultList);
		Collections.sort(tempList);
		
		Assert.assertTrue(defaultList.equals(tempList), "The options are not sorted alphabatically  by default");
		
		
	}

}
