import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.commons.io.FileSystemUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Sec13_108_BrokenUrls {

	public static void main(String[] args) throws MalformedURLException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php");

		// Step1 to get all URLS
		List<WebElement> links = driver.findElements(By.xpath("//div[@id='gf-BIG'] //a"));

		SoftAssert a = new SoftAssert();

		for (WebElement link : links) {
			String url = link.getAttribute("href");

			// Java methods will call URLs and get status code
			// Openconnection method is in url class. And data type for this method is
			// HttpURLConnection
			// Advantage is without opening the links it tells if link is broken or not .
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("HEAD"); // Default method is "GET". HEAD method is like GET method but without
											// response.
			conn.connect(); // Response is retrieved here

			int resCode = conn.getResponseCode(); // Gives response code
			System.out.println(resCode);

			// Soft assertion
			a.assertTrue(resCode < 400, link.getText() + " is broken with respcode: " + resCode);

			// Hard assertion
			/*
			 * if (resCode > 400) { System.out.println(link.getText() +
			 * " is broken with respcode: " + resCode); Assert.assertTrue(false);
			 * 
			 * }
			 */

		}
		a.assertAll();
	}
}