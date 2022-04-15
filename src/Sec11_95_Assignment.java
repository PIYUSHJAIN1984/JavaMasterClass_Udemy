import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Sec11_95_Assignment {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.findElement(By.id("checkBoxOption2")).click();
		String optionSelected = driver.findElement((By.xpath("//label[@for='benz']"))).getText();
		System.out.println(optionSelected);

		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(optionSelected);

		driver.findElement(By.cssSelector("#name")).sendKeys(optionSelected);
		driver.findElement(By.cssSelector("#alertbtn")).click();

		String alertmsg = driver.switchTo().alert().getText();
		System.out.println(alertmsg);

		if (alertmsg.contains(optionSelected)) {
			System.out.println("Alert message contains :" + optionSelected);
			driver.switchTo().alert().accept();
		} else {
			System.out.println("Alert message does not contain correct text");
		}
	}
}
