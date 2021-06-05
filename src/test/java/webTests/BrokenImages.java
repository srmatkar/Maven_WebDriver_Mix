package webTests;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenImages {

	WebDriver driver;
	private int invalidImgCount;

	@BeforeClass
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/broken_images");

	}

	@Test
	public void identifyBrokenImages() {

		invalidImgCount = 0;

		List<WebElement> imgList = driver.findElements(By.tagName("img"));
		for (WebElement img : imgList) {
			if (img != null) {
				try {
					verifyimageActive(img);
				} catch (ClientProtocolException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		System.out.println("Total no. of invalid images are " + invalidImgCount);
	}

	// Use Apache HttpClient
	private void verifyimageActive(WebElement image) throws ClientProtocolException, IOException {
		CloseableHttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(image.getAttribute("src"));
		CloseableHttpResponse response = client.execute(request);
		if (response.getStatusLine().getStatusCode() != 200)
			invalidImgCount++;

	}

}
