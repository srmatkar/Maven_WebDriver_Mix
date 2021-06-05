package webTests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RobotUse1 {

	WebDriver driver;

	
	@Test
	public void robotUse() throws AWTException, InterruptedException {
		//https://www.guru99.com/using-robot-api-selenium.html#:~:text=Robot%20Class%20is%20used%20in,like%20notepad%2C%20calculator%2C%20etc.
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	       driver.manage().window().maximize();	
	        driver.get("http://spreadsheetpage.com/index.php/file/C35/P10/"); // sample url	
	        Robot robotObj = new Robot();
	        robotObj.mouseMove(630, 420); // move mouse point to specific location	
	        robotObj.delay(1500);        // delay is to make code wait for mentioned milliseconds before executing next step	
	        robotObj.mousePress(InputEvent.BUTTON1_DOWN_MASK); // press left click	
	        robotObj.mouseRelease(InputEvent.BUTTON1_DOWN_MASK); // release left click	
	        robotObj.delay(1500);	
	        robotObj.keyPress(KeyEvent.VK_DOWN); // press keyboard arrow key to select Save radio button	
	        Thread.sleep(2000);	
	        robotObj.keyPress(KeyEvent.VK_ENTER);
	        // press enter key of keyboard to perform above selected action	
	        
		
	}
}
