package Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Play {

	public static void main(String[] args) {
		System.setProperty("webdriver.gecko.driver", "T:\\Test_Team\\Selenium Projects_1\\Website\\geckodriver-v0.10.0-win64//geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability("marionette", true);
		WebDriver driver = new FirefoxDriver(capabilities);
		 driver.get("http://www.lta.org.uk/");
	        driver.manage().window().maximize();
	}

}
