package webTests;



import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {

WebDriver driver;

	@Test
	public void test_CloseAllWindowsExceptMainWindow() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		// It will open Naukri website with multiple windows
		driver.get("https://www.naukri.com/");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		// To get the main window handle
		String windowTitle= getCurrentWindowTitle(); // Current window title
		String mainWindow = getMainWindowHandle(driver); // Currwnt window handle
		Assert.assertTrue(closeAllOtherWindows(mainWindow));
		Assert.assertTrue(windowTitle.contains("Jobs - Recruitment"), "Main window title is not matching");
	}
		
	public String getMainWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public String getCurrentWindowTitle() {
		String windowTitle = driver.getTitle();
		return windowTitle;
	}
	
	//To close all the other windows except the main window.
	public boolean closeAllOtherWindows(String windowToBeOpened) {
		Set<String> allWindowHandles = driver.getWindowHandles(); // get all handles
		for (String winHandle : allWindowHandles) {
			if (!winHandle.equals(windowToBeOpened)) {
				driver.switchTo().window(winHandle);
				driver.close();
			}
		}
		
		driver.switchTo().window(windowToBeOpened);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}
}