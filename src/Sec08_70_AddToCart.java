import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sec08_70_AddToCart {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		// Implicit Wait commented to check explicit wait
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Define webdriver wait - Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		String[] vegetables = { "Cauliflower", "Cucumber", "Carrot" };
		Thread.sleep(2000);

		addItems(driver, vegetables);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// Explicit Wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='promoCode']")));
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("rahulshettyacademy");

		driver.findElement(By.xpath("//button[text()='Apply']")).click();

		// Explicit Wait
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addItems(WebDriver driver, String[] vegetables) {
		int j = 0;

		// Get list of all products in webpage
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < products.size(); i++) {
			// Truncate Brocolli - 1 Kg to Brocolli and remove space from it.
			String[] name = products.get(i).getText().split("-");
			String formatName = name[0].trim();

			// Convert array into arrayList
			List itemsNeededList = Arrays.asList(vegetables);

			// If vegetable name from UI is in arraylist and then click on add to cart for
			// that element
			if (itemsNeededList.contains(formatName)) {
				j++;
				// xpath using text is avoided here as it click on 'Add to cart' for some other
				// vegetable since text get changed from 'Add to cart'to 'Added'
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == itemsNeededList.size())
					break;
			}
		}

	}
}