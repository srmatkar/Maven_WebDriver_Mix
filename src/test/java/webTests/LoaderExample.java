package webTests;

import java.time.Duration;
// http://avinashpandeblogsonseleniumautomation.blogspot.com/2018/06/blog-post.html
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoaderExample {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(
				"http://avinashpandeblogsonseleniumautomation.blogspot.com/2018/06/spinner-to-handle-in-selenium.html");

	}

	@Test
	public void test() {

		// Click on show Spinner button it will spin for 15 sec and then load the data in Tabular form
		driver.findElement(By.id("showspinner")).click();

		// If spinner disappear then it return true and next check for data gets loaded
		// in tabular format
		if (waitForLoaderTodisappear(driver, By.id("myDiv"))) {
			List<WebElement> tableElements = driver.findElements(By.xpath("//table//td[contains(text(),'" + "Jill"
					+ "')]//following-sibling::td[contains(text(),'" + "Smith" + "')]//following-sibling::td/input"));
			tableElements.get(0).click();
		}
	}

	public static boolean waitForLoaderTodisappear(WebDriver driver, By by) {

		FluentWait<WebDriver> fWait = new FluentWait<WebDriver>(driver);
		fWait.withTimeout(10, TimeUnit.SECONDS);
		fWait.pollingEvery(250, TimeUnit.MILLISECONDS);
		fWait.ignoring(NoSuchElementException.class);

		Function<WebDriver, Boolean> func = new Function<WebDriver, Boolean>() {

			@Override
			public Boolean apply(WebDriver driver) {
				WebElement element = driver.findElement(by);

				System.out.println(element.getCssValue("display"));

				if (element.getCssValue("display").equalsIgnoreCase("none")) {
					return true;
				}

				return false;
			}
		};

		return fWait.until(func);

	}

	// My trial to have function using FluentWait
	
	@Test
	public void test2() {
		
		FluentWait<WebDriver> wait = new FluentWait(driver)
				.withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofMillis(250))
				.ignoring(NoSuchElementException.class);
		
		// Click on show Spinner button it will spin for 15 sec and then load the data in Tabular form
				driver.findElement(By.id("showspinner")).click();
				
				wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("myDiv"))));
				
				List<WebElement> tableElements = driver.findElements(By.xpath("//table//td[contains(text(),'" + "Jill"
						+ "')]//following-sibling::td[contains(text(),'" + "Smith" + "')]//following-sibling::td/input"));
				tableElements.get(0).click();
			
	}
	

	

}
