import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec07_66_Alert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		String text = "Piyush";
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(text);
		driver.findElement(By.id("alertbtn")).click();
		
		String alertText= driver.switchTo().alert().getText();
		if (alertText.contains("Piyush"))
		driver.switchTo().alert().accept();

	}

}
