import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sec06_40_Locators2 {

	public static void main(String[] args) throws InterruptedException {
		String name = "Rahul";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit wait
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		driver.manage().window().maximize();

		String password = getPassword(driver);

		driver.findElement(By.xpath("//button[text()='Go to Login']")).click();
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys(name);
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(password);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button[type='submit']")).click();

		Thread.sleep(1000);
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		Assert.assertEquals(driver.findElement(By.tagName("h2")).getText(), "Hello " + name + ",");
		driver.findElement(By.xpath("//button[text()='Log Out']")).click();
		driver.quit();
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(1000);

		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordTxt = driver.findElement(By.cssSelector("form p")).getText();

		String[] passwordArray = passwordTxt.split("'");
		String password = passwordArray[1].split("'")[0];

		return password;

	}

}
