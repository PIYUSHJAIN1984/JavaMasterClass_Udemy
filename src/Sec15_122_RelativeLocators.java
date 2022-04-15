import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//Manually need to enter this package in java class as its static
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class Sec15_122_RelativeLocators {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/angularpractice/");

		// ********************Above relative locator : Identify the label above ‘name’ textbox
		WebElement namedEditBox = driver.findElement(By.cssSelector("input[name='name']:nth-child(2)"));

		// using with within find Element and used above relative locator to identify 'Name' label
		System.out.println(driver.findElement(with(By.tagName("label")).above(namedEditBox)).getText());

		
		
		// ********************Left relative locator : Click on checkbox left of text
		// 'Check me out if you Love IceCreams!'
		WebElement checkBoxTxt = driver.findElement(By.cssSelector("label[for='exampleCheck1']"));

		driver.findElement(with(By.tagName("input")).toLeftOf(checkBoxTxt)).click();
		
		
		
		
		// ********************Right relative locator : Get label 'Stdent' right of radiobutton
		WebElement radioBtn = driver.findElement(By.cssSelector("input#inlineRadio1"));

		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(radioBtn)).getText());


		
		
		// ********************Below relative locator : identify the inputbox below
		// ‘Date of Birth’ label
		WebElement dOB = driver.findElement(By.cssSelector("label[for='dateofBirth']"));

		// using with within find Element and used below relative locator to identify textbox below Date label
		// Since textbox below date label is flex element so it will not be identified 
		//and next element with input tagname will be identified
		driver.findElement(with(By.tagName("input")).below(dOB)).click();
	}

}
