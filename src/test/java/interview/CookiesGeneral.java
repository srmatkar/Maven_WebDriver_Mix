package interview;

import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CookiesGeneral {
WebDriver driver;
	
	@Test
	public void allCookiesMethods() {
		
		Cookie cookie1 = new Cookie("myCookie", "MyValue");
		driver.manage().addCookie(cookie1);
		
		Set<Cookie> all_cookies = new HashSet<Cookie>();
		all_cookies.addAll( driver.manage().getCookies());
		
		
		driver.manage().getCookieNamed("cookie1");
		
		
	}
}
