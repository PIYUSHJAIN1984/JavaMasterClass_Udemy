import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec15_125_126_127_MultipleTabs_Screenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		//******************************** Open new tab
		driver.switchTo().newWindow(WindowType.TAB);

		// Get new tab window ID
		Set<String> handles = driver.getWindowHandles();
		Iterator<String> iterate = handles.iterator();
		String parentWindowID = iterate.next();
		String childWindowID = iterate.next();

		// Selenium driver move to childWindow
		driver.switchTo().window(childWindowID);
		driver.get("https://rahulshettyacademy.com/");

		String courseName = driver.findElements(By.cssSelector("h2 a[href*='https://courses.rahulshettyacademy.com']"))
				.get(0).getText();

		//// Selenium driver move to parentWindow
		driver.switchTo().window(parentWindowID);
		WebElement name = driver.findElement(By.cssSelector("input[name='name']:nth-child(2)"));
		name.sendKeys(courseName);

		
		// *************Capture screenshot for a webElement where name is webElement
		File file = name.getScreenshotAs(OutputType.FILE);

		// To take screenshot in particular folder
		FileUtils.copyFile(file, new File("C:\\Users\\PJain15\\Downloads\\screenshot.png"));

		// To take screenshot in eclipse project folder
		FileUtils.copyFile(file, new File("screenshot.png"));
		
		
		//*********** Get Height and width
		System.out.println(name.getRect().getDimension().getHeight());
		System.out.println(name.getRect().getDimension().getWidth());
		

	}

}
