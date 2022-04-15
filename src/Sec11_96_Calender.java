import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec11_96_Calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("travel_date")).click();

		// provide month and date for calender
		// Step1 : Select the month
		boolean flag = false;

		while (!flag) {
			driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='next']")).click();
			flag = driver.findElement(By.xpath("//div[@class='datepicker-days'] //th[@class='datepicker-switch']"))
					.getText().contains("March");
		}

		// Step2 : Find the date to be clicked
		// Take all date elements in a list and iterate
		List<WebElement> dates = driver.findElements(By.xpath("//td[@class='day']"));
		int countOfDates = driver.findElements(By.xpath("//td[@class='day']")).size();

		for (int i = 0; i < countOfDates; i++) {
			if (dates.get(i).getText().equals("19")) {
				dates.get(i).click();
				break;
			}
		}
	}

}
