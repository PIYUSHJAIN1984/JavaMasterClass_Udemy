import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Sec14_119_Filter_Streams {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		driver.findElement(By.id("search-field")).sendKeys("Rice");

		// Result from table after filter applied
		List<WebElement> item = driver.findElements(By.xpath("//tr/td[1]"));

		// Result using stream to get elements having 'Rice'
		List<WebElement> filteredList = item.stream().filter(s -> s.getText().contains("Rice"))
				.collect(Collectors.toList());
		
		Assert.assertEquals(item.size(), filteredList.size());

	}

}
