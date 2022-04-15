import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec10_86_WindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/loginpagePractise/#");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector(".blinkingText")).click();
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> id = windows.iterator();
		String parentID=id.next();
		String childID = id.next();
		
		driver.switchTo().window(childID);
		
		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		driver.findElement(By.cssSelector(".im-para.red")).getText();
		String emailID=driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0];

		driver.switchTo().window(parentID);
		driver.findElement(By.id("username")).sendKeys(emailID);
				
	}

}
