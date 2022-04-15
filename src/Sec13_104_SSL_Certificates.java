import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Sec13_104_SSL_Certificates {

	public static void main(String[] args) {

		// Desired capabilities is a class which helps to customize chrome browser and
		// then pass object of this capability to chrome option.
		DesiredCapabilities ch = new DesiredCapabilities();
		ch.acceptInsecureCerts();

		// Another way to add capabilities
		ch.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		ch.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

		// SSL Certifications
		// Belongs to your local browser
		ChromeOptions c = new ChromeOptions();
		c.merge(ch); // Added capabilities to chrome browser So, Basically merging profile created
						// into local chrome browser options

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\PJain15\\OneDrive - Schlumberger\\DOWNLOAD\\SLB\\Software\\Selenium_RahulShetty\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(c);
		driver.get("http://www.qaclickacademy.com/practice.php");

	}

}
