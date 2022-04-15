import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sec10_84_Actions {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector(".a-button-input")).click();

		// Mousehover on a element and then do right click
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));
		a.moveToElement(move).contextClick().build().perform();
	
		Thread.sleep(2000);

		// Search in capital letter and Double click to highlight a element
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.doubleClick().build().perform();

		// 

	}

}
