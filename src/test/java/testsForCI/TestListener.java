package testsForCI;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class TestListener implements ITestListener {
	WebDriver driver = null;

	@Override
	public void onTestFailure(ITestResult result) {

		if (!result.isSuccess()) {
			Calendar calendar = Calendar.getInstance();
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
			String methodName = result.getName().toString().trim();
			ITestContext context = result.getTestContext();
			driver = (WebDriver) context.getAttribute("driver");
			// DELIBERATELY STORING IN TARGET
			String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath()
					+ "\\target\\surefire-reports";
			File destFile = new File((String) reportDirectory + "\\failure_screenshots\\" + methodName + "_"
					+ formater.format(calendar.getTime()) + ".pdf");
			// Calling screenshot method to store screenshot at designated place
			takeScreenShot(driver, destFile);

			// Logging
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'> <img src='" + destFile.getAbsolutePath()
					+ "' height='100' width='100'/> </a>");
			System.out.println("***** Attention, Error " + result.getName() + " test has failed *****");

		}
	}

	public void onFinish(ITestContext context) {
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

	/**
	 * Uses TakesScreenShot interface to capture screen at the time of error
	 * 
	 * @param driver
	 * @param file
	 */
	public void takeScreenShot(WebDriver driver, File file) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			// FileUtils.copyFile(scrFile, file); // java solution - apache fileUtils
			FileHandler.copy(scrFile, file); // selenium solution
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
