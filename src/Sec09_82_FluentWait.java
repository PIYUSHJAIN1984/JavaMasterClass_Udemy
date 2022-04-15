import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Sec09_82_FluentWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); // Implicit wait

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.findElement(By.cssSelector("div[id='start'] button")).click();

// Fluent Wait is class implementing Wait interface

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(5)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed())
					return driver.findElement(By.cssSelector("div[id='finish'] h4"));
				else
					return null;
			}

		});
		System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("div[id='finish'] h4")).getText());

	}

}
