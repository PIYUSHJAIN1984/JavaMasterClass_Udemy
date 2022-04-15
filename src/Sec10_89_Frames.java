import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sec10_89_Frames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://jqueryui.com/droppable/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		
		//To find frames in a webpage
		driver.findElements(By.tagName("iframe")).size();
		
		//Using frames via webElement
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement dest = driver.findElement(By.id("droppable"));
				
		Actions a = new Actions(driver);
		a.dragAndDrop(source, dest).build().perform();
		
		//Switch to default window from frame
		driver.switchTo().defaultContent();
		
	}

}
