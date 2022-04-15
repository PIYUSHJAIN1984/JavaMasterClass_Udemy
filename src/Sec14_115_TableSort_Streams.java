import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sec14_115_TableSort_Streams {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// ****Scenario1 : Sort the list and sort using stream and compare list
		// Click on column
		driver.findElement(By.xpath("//tr/th[1]")).click();

		// capture elements into list
		List<WebElement> fruits = driver.findElements(By.xpath("//tbody/tr/td[1]"));

		// Capture text of elements into new list
		List<String> originalList = fruits.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Sort original list using streams and then store text in a List
		List<String> sortedList = fruits.stream().map(s -> s.getText()).sorted().collect(Collectors.toList());

		//Compare 2 list to identify if list in UI is sorted 
		Assert.assertTrue(originalList.equals(sortedList));

		// ****Scenario2 : Grab element 'Banana' from list and print its price from column B 
		//Include pagination also using do while loop.

		List<String> price;
		// Scan name column with getText equals 'Banana' then print price from columnB
		do {
			
			List<WebElement> fruits1 = driver.findElements(By.xpath("//tbody/tr/td[1]"));
			
			price = fruits1.stream().filter(s -> s.getText().contains("Cherry")).map(s -> getPriceVeggie(s))
					.collect(Collectors.toList());

			// Print each element in a list has method forEach
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.xpath("//a[@aria-label='Next']")).click();
			}
		} while (price.size() < 1);

	}

	//Method to get price of element
	public static String getPriceVeggie(WebElement s) {
		String priceValue = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		return priceValue;
	}

}
