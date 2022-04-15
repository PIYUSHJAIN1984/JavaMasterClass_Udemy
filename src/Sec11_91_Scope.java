import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec11_91_Scope {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//		driver.manage().window().maximize();

		// Get all links in web page
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Get Count of links in footer section
		WebElement footer = driver.findElement(By.xpath("//div[@id='gf-BIG']")); // limiting webdriver scope
		System.out.println(footer.findElements(By.tagName("a")).size());

		// Get Count of links in first column in footer
		WebElement columnFooter = driver.findElement(By.xpath("//div[@id='gf-BIG'] //td[1]/ul"));
		int size = columnFooter.findElements(By.tagName("a")).size();
		System.out.println(size);

		// Click on each link in in first column in footer and open them in new tab
		for (int i = 1; i < size; i++) {

			// Select Ctrl and hit enter to open link in new tab.
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			columnFooter.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(5000);
		}

		// Print title of each child window
		Set<String> window = driver.getWindowHandles();
		Iterator<String> a = window.iterator();

		while (a.hasNext()) {
			driver.switchTo().window(a.next());
			System.out.println(driver.getTitle());
		}
	}
}