package listeners;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWithScreenShotOnFailure {

	WebDriver driver;

@BeforeClass
public void setUp() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
}

@AfterClass
public void tearDown() {
	if ((driver != null)) {
		driver.quit();
	}
}

@Test
public void login() {
	System.out.println("This is a login test");
	driver.get("https://www.google.com/");
	Assert.assertTrue(true);
}

@Test
public void loginFailed() {
	System.out.println("This is a login deliberate fail  test");
	driver.get("https://www.google.com/");
	Assert.assertTrue(false);
}

@Test
public void easyHrWorld() {
	System.out.println("This is Arrkgroup EasyHr  test");
	driver.get("https://arrkgroup.easyhrworld.com/");
	Assert.assertEquals(driver.getTitle(), "FakeTitle", "Incorrect Page Opened");
	
}


@AfterMethod
public void tearDown(ITestResult result)
{

    if(ITestResult.FAILURE==result.getStatus()) {
        CaptureScreenShot.capturescreen(driver,result.getName(),"FAILURE");
    }
    else {
        CaptureScreenShot.capturescreen(driver,result.getName(),"SUCCESS");
    }
}


	
}
