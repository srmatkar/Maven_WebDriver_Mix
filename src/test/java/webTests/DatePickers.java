// https://www.techbeamers.com/handle-date-time-picker-control-using-webdriver/
package webTests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DatePickers {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Test (description = "calendar not within frame")
	public void pickDate() {
		driver.get("https://jqueryui.com/resources/demos/datepicker/other-months.html");
		WebElement calElement = driver.findElement(By.id("datepicker"));
		calElement.click();
		
		String dayToBeSelected = "5";
		
		// Create custom xpath
			
		By calendarXpath = By
				.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
						+ dayToBeSelected + "']");
		driver.findElement(calendarXpath).click();

	}
	
	@Test(description = "calendar within the iframe")
	public void selectDateInIframe() {
		String dayToSelect = "18";
		WebDriverWait wait= new WebDriverWait(driver,15);
		driver.get("https://jqueryui.com/datepicker/");
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		By dtp = By.xpath(".//*[@id='datepicker']");
		wait.until(ExpectedConditions.presenceOfElementLocated(dtp));
		driver.findElement(dtp).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("ui-datepicker-div")));
		WebElement table = driver.findElement(By
				.className("ui-datepicker-calendar"));
		System.out.println("JQuery Calendar Dates");

		List<WebElement> tableRows = table.findElements(By.xpath("//tr"));
		for (WebElement row : tableRows) {
			List<WebElement> cells = row.findElements(By.xpath("td"));

			for (WebElement cell : cells) {
				if (cell.getText().equals(dayToSelect)) {
					driver.findElement(By.linkText(dayToSelect)).click();
				}
			}
		}
		
		driver.switchTo().defaultContent();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0, -250);");
		
	
 		
	}
	
	@Test(description = "Select future date from bootstrap datePicker")
	public void pickDateBootstrap() {
		
		String dayToSelect = "28-12-1978";
		
		WebDriverWait wait= new WebDriverWait(driver,15);
		driver.get("https://www.seleniumeasy.com/test/bootstrap-date-picker-demo.html");
		driver.findElement(By.xpath("//div [@id='sandbox-container1']/div[@class='input-group date']")).click();
		driver.findElement(By.cssSelector("th.datepicker-switch")).click();
		driver.findElement(By.cssSelector("th.datepicker-switch")).click();
		
		
		
	}
	

}
