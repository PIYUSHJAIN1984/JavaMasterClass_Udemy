import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sec12_100_WindowandTable_Scroll {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/#");

		// Casting driver as JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// To scroll to window
		js.executeScript("window.scrollBy(0,500)");

		Thread.sleep(5000);

		// Table Scrolling
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

		// Get values of all amount in table and sum them
		List<WebElement> values = driver.findElements(By.xpath("//div[@class='tableFixHead'] //tr/td[4]"));
		int total = 0;

		for (int i = 0; i < values.size(); i++) {
			String amount = values.get(i).getText();
			int amt = Integer.parseInt(amount);
			total = total + amt;

		}
		System.out.println("Total amount: " + total);

		// Compare total from table with UI total shown
		String amount = driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim();
		int expectedAmt = Integer.parseInt(amount);

		Assert.assertEquals(total, expectedAmt);
	}
}