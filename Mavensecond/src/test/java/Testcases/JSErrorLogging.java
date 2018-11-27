package Testcases;
import java.util.Date;
import java.util.logging.Level;
import org.apache.log4j.*;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Test
public class JSErrorLogging {
	 WebDriver driver;
    //@BeforeMethod
	 @Test
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "T:\\Test_Team\\Selenium Projects_1\\Website\\New folder\\chromedriver.exe");        
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        LoggingPreferences pref = new LoggingPreferences();
     
        pref.enable(LogType.BROWSER, Level.ALL);
        capabilities.setCapability(CapabilityType.LOGGING_PREFS, pref);
        driver = new ChromeDriver(capabilities);
    }
 
    @Test
    //@AfterMethod
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void ExtractJSLogs() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
    }
    @Test
    public void testMethod() {
        driver.get("https://lta-test75.lta.org.uk/ghi-1");
        ExtractJSLogs();
    }

	//public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


