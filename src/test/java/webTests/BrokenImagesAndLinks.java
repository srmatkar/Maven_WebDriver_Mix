package webTests;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenImagesAndLinks {
	WebDriver driver;
	String homePage = "";
	String url = "";
	int respCode;
	Scanner scan;
//	String brokenImageUrlSample = "https://the-internet.herokuapp.com/broken_images";
	String brokenImageUrlSample = "https://sandbox.arrkgroup.com/";

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".//Drivers/chromedriver88.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		scan = new Scanner(System.in);

	}

	@Test
	public void verifyBrokenLinks() throws MalformedURLException, IOException {
		System.out.println("Please enter homePage to test for broken links");
		String homaPageLink = scan.next();
		driver.get(homaPageLink);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		Iterator<WebElement> itr = allLinks.iterator();
		while (itr.hasNext()) {
			url = itr.next().getAttribute("href");
			if (url == null || url.isEmpty()) {
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			if (!(url.contains(homaPageLink))) {
				System.out.println("This url: " + url +

						" is taking to external domain, No need to test");
				continue;
			}
			System.out.println("This link " + url + " :is broken is " + isLinkBroken(homaPageLink));

		}
	}

	@Test
	public void identifyBrokenImages() throws MalformedURLException, IOException {
		int brokenImageCount = 0;
		driver.get(brokenImageUrlSample);
		List<WebElement> images = driver.findElements(By.tagName("img"));

		Iterator<WebElement> itr = images.iterator();
		while (itr.hasNext()) {
			WebElement image = itr.next();
			if (image != null) {
				brokenImageCount = brokenImageCount + getBrokenImageCount(image);
			}

		}
		System.out.println("This page has " + brokenImageCount + " images broken.");

	}

	public boolean isLinkBroken(String url) throws MalformedURLException, IOException {
		boolean isbroken = false;
		HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
		huc.setRequestMethod("HEAD");
		huc.connect();
		respCode = huc.getResponseCode();

		if (respCode >= 400) {
			isbroken = true;
		}

		return isbroken;
	}

	public int getBrokenImageCount(WebElement image) throws ClientProtocolException, IOException {
		int brokenImageCount = 0;
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(image.getAttribute("src"));
		CloseableHttpResponse response  = client.execute(request);
		StatusLine statusLine = response.getStatusLine();

		if (statusLine.getStatusCode() != 200){
			brokenImageCount ++;
		}

		return brokenImageCount;
	}
}
