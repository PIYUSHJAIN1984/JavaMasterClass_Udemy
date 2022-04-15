import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sec02_10_Introduction {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/#/index");
		System.out.println("Testing committing of code from one branch to another ");
		
		//Code added by git1
		System.out.println("a");
		System.out.println("b");
		System.out.println("c");
		System.out.println("d");
		
		//Code added by developBr branch
		System.out.println("e");
		System.out.println("f");
		
		
		driver.quit();
	}

}
