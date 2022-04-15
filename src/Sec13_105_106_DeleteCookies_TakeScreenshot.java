import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec13_105_106_DeleteCookies_TakeScreenshot {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// To maximize browser
		driver.manage().window().maximize();

		// To delete cookies
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("sessionKey");

		driver.get("http://www.qaclickacademy.com/practice.php");
		
		//First casting driver object to TakesScreenshot
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
		
		FileUtils.copyFile(src,new File("C:\\Users\\PJain15\\Downloads\\screenshot.png"));
	}
}