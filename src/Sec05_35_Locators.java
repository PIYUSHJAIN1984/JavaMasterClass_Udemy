import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec05_35_Locators {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit wait

		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("eff@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("eff");
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		driver.findElement(By.linkText("Forgot your password?")).click();

		// Indexing in xpath and css selector
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("ddd");
		driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("dd@gmail.com");

		driver.findElement(By.xpath("//form/input[@placeholder='Phone Number']")).sendKeys("243424242");

		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();

		Thread.sleep(1000);
		// Login to application
		driver.findElement(By.cssSelector("input#inputUsername")).sendKeys("eff@gmail.com");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.xpath("//button[contains(@class ,'submit')]")).click();

		driver.quit();

	}

}
