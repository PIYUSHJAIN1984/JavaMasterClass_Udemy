import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Sec07_50_Dropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.manage().window().maximize();

		// ********Click radio button for round trip************88
		// driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();

		// *******************Dynamic dropdown ****************************
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_ddl_originStation1_CTXT']")).click();
		driver.findElement(By.xpath("//a[text()=' Bengaluru (BLR)']")).click();
		Thread.sleep(2000);

		// Way to use parent-child traverse xpath instead of using index.
		// driver.findElement(By.xpath("(//a[@text='Chennai (MAA)'])[2]")).click();
		driver.findElement(
				By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@text='Chennai (MAA)']"))
				.click();

		// ****************************Selecting date*********************************8
		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		// ****************Checking if to date is enabled or not*******************
		// Never use is enabled function
		// System.out.println("After round trip clicked: "+
		// driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled());

		System.out.println(driver.findElement(By.id("Div1")).getAttribute("style"));

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {

			System.out.println("It dis enabled");
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

		// *******************Passengers dropdown with '+' and '-'
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000);

		int i = 1;
		while (i < 5) {
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}

		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println("Passenger selected " + driver.findElement(By.id("divpaxinfo")).getText());
		Thread.sleep(5000);

		// *******************Dropdown with select tag****************************
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropdown = new Select(staticDropdown);

		dropdown.selectByIndex(3);
		System.out.println(dropdown.getFirstSelectedOption().getText()); // this will give selected option

		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		// *******************Auto-suggestive dropdownn****************************
		driver.findElement(By.id("autosuggest")).sendKeys("IND");
		Thread.sleep(3000);
		List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

		for (WebElement option : options) {
			if (option.getText().equalsIgnoreCase("India")) {
				option.click();
				break;
			}
		}

		// *******************Count of checkboxes****************************
		System.out.println(
				"Count of checkboxes: " + driver.findElements(By.cssSelector("input[type='checkbox']")).size());

		
		//***********************Click on Search button****************************
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		
		
		driver.quit();
	}

}
