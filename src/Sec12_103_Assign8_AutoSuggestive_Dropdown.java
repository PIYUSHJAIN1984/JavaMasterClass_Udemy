import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec12_103_Assign8_AutoSuggestive_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		driver.manage().window().maximize();

		driver.findElement(By.id("autocomplete")).sendKeys("uni");

		String text = "";

		/*** First way using Java script executor ****************************/
		while (!text.contains("United Kingdom")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);

			// If elements are hidden like in auto-suggestive dropdown use java script DOM
			// because Selenium cannot identify hidden elements which is Ajax implementation
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String script = "return document.getElementById(\"autocomplete\").value;";
			text = (String) js.executeScript(script);

			Thread.sleep(2000);
		}
		System.out.println(text);

		/*** Second way using get attribute ************************************/
		// If don't want to use java script use below code to get the value in text box
		// where send keys is not working

		while (!text.contains("United Kingdom")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			text = driver.findElement(By.id("autocomplete")).getAttribute("value");

			Thread.sleep(2000);
		}
		System.out.println(text);

	}
}
