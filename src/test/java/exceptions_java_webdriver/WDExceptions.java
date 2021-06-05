package exceptions_java_webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class WDExceptions {

	WebDriver driver;

	@Test
	public void nullPointerException() {

		driver.get("https://google.com"); // will give NullPointerexception
	}

	@Test
	public void illegalStateExcp() {

		driver = new ChromeDriver();
		driver.get("https://google.com"); // FAILED: webdriverException ; java.lang.IllegalStateException:
	}

	@Test
	public void webdriverException() {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.close();
		driver.getCurrentUrl(); // webdriverException: org.openqa.selenium.NoSuchSessionException:
	}
	
	@Test
	public void invalidSelector() {
		
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https:\\google.com");
		WebElement search = driver.findElement(By.xpath("//div[]")); // InvalidSelectorException
	}
	
	@Test
	public void invalidArgumentException() {
		Dimension dim  = new Dimension(-30, -30);
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(dim); // org.openqa.selenium.InvalidArgumentException:
		driver.get("https:\\google.com");
	}
	
	/*
	 * 1. ConnectionClosedException: This exception takes place when there is a
	 * disconnection in the driver.
	 * 
	 * 2. ElementClickInterceptedException: The command could not be completed as
	 * the element receiving the events is concealing the element which was
	 * requested clicked.
	 * 
	 * 3. ElementNotInteractableException: This Selenium exception is thrown when an
	 * element is presented in the DOM but it is impossible to interact with such
	 * element.
	 * 
	 * 4. ElementNotSelectableException: This Selenium exception is thrown when an
	 * element is presented in the DOM but you can be able to select. Hence, it is
	 * impossible to interact with.
	 * 
	 * 5. ElementNotVisibleException: This type of Selenium exception takes place
	 * when existing element in DOM has a feature set as hidden. In this situation,
	 * elements are there, but you can not see and interact with the WebDriver.
	 * 
	 * 6. ErrorHandler.UnknownServerException: Exception is used as a placeholder if
	 * the server returns an error without a stack trace.
	 * 
	 * 7. ErrorInResponseException: This exception is thrown when a fault has
	 * occurred on the server side. You can see it happens when interacting with the
	 * Firefox extension or the remote driver server.
	 * 
	 * 8. ImeActivationFailedException: This exception occurs when IME engine
	 * activation has failed.
	 * 
	 * 9. ImeNotAvailableException: This exception takes place when IME support is
	 * unavailable.
	 * 
	 * 10. InsecureCertificateException: Navigation made the user agent to hit a
	 * certificate warning, which is caused by an invalid or expired TLS
	 * certificate.
	 * 
	 * 11. InvalidArgumentException: This Selenium exception is thrown if an
	 * argument does not belong to the expected type.
	 * 
	 * 12. InvalidCookieDomainException: This happens when you try to add a cookie
	 * under a different domain rather than the current URL.
	 * 
	 * 13. InvalidCoordinatesException: This happens if the coordinates offered to
	 * an interacting operation are not valid.
	 * 
	 * 14. InvalidElementStateException: This Selenium exception occurs if a command
	 * cannot be finished as the element is invalid.
	 * 
	 * 15. InvalidSessionIdException: Takes place when the given session ID is not
	 * included in the list of active sessions, which means the session does not
	 * exist or is inactive either.
	 * 
	 * 16. InvalidSwitchToTargetException: Happens if frame or window target to be
	 * switched does not exist.
	 * 
	 * 17. JavascriptException: This problem happens when executing JavaScript
	 * supplied by the user.
	 * 
	 * 18. JsonException: Happens when you afford to get the session capabilities
	 * where the session is not created.
	 * 
	 * 19. MoveTargetOutOfBoundsException: Takes place if the target provided to the
	 * ActionChains move() methodology is not valid. For example: out of document.
	 * 
	 * 20. NoAlertPresentException: Happens when you switch to no presented alert.
	 * 
	 * 21. NoSuchAttributeException: Occurs when the attribute of element could not
	 * be found.
	 * 
	 * 22. NoSuchContextException: Happens in mobile device testing and is thrown by
	 * ContextAware.
	 * 
	 * 23. NoSuchCookieException: This exception is thrown if there is no cookie
	 * matching with the given path name found amongst the associated cookies of the
	 * current browsing context’s active document.
	 * 
	 * 24. NoSuchElementException: Happens if an element could not be found.
	 * 
	 * 25. NoSuchFrameException: Takes place if frame target to be switch does not
	 * exist.
	 * 
	 * 26. NoSuchWindowException: Occurs if window target to be switch does not
	 * exist.
	 * 
	 * 27. NotFoundException: This exception is subclass of WebDriverException. It
	 * happens when an element on the DOM does not exist.
	 * 
	 * 28. RemoteDriverServerException: This Selenium exception is thrown when
	 * server do not respond due to the problem that the capabilities described are
	 * not proper.
	 * 
	 * 29. ScreenshotException: It is impossible to capture a screen.
	 * 
	 * 30. ScriptTimeoutException: Thrown when executeAsyncScript takes more time
	 * than the given time limit to return the value.
	 * 
	 * 31. SessionNotCreatedException: A new session could not be successfully
	 * created.
	 * 
	 * 32. SessionNotFoundException: The WebDriver is performing the action right
	 * after you quit the browser.
	 * 
	 * 33. StaleElementReferenceException: This Selenium exception happens if the
	 * web element is detached from the current DOM.
	 * 
	 * 34. TimeoutException: Thrown when there is not enough time for a command to
	 * be completed.
	 * 
	 * 35. UnableToCreateProfileException: You can open a browser with certain
	 * options using profiles, but sometimes a new version of Selenium driverserver
	 * or browser may not support the profiles.
	 * 
	 * 36. UnableToSetCookieException: Occurs if a driver is unable to set a cookie.
	 * 
	 * 37. UnexpectedAlertPresentException: This Selenium exception happens when
	 * there is the appearance of an unexpected alert.
	 * 
	 * 38. UnexpectedTagNameException: Happens if a support class did not get a web
	 * element as expected.
	 * 
	 * 39. UnhandledAlertException: It happens when there is an alert, but WebDriver
	 * is unable to perform Alert operation.
	 * 
	 * 40. UnknownMethodException: Thrown when the requested command matching with a
	 * known URL but not matching with a methodology for that URL.
	 * 
	 * 41. UnreachableBrowserException: This Selenium exception happens if the
	 * browser is unable to be opened or have crashed because of some reasons.
	 * 
	 * 42. UnsupportedCommandException: Occurs when remote WebDriver does not send
	 * valid command as expected.
	 * 
	 * 43. WebDriverException: This takes place when the WebDriver is performing the
	 * action right after you close the browser.
	 */
	

}
