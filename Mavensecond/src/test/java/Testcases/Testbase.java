// MAVEN TESTBASE //


package Testcases;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.BeforeSuite;
import org.openqa.selenium.htmlunit.*;
import datatable.Xls_Reader;
import org.openqa.selenium.firefox.MarionetteDriver;
import Utility.TestUtil;

public class Testbase {
	
	// Testbase is the parentclass where all commonly used methods are created
	public static Properties config = null;
	public static Properties OR = null;
	public static WebDriver wbDv = null;
	public static EventFiringWebDriver driver=null;
	public static Logger APPLICATION_LOGS = Logger.getLogger("devpinoyLogger");
	public static Xls_Reader datatable=null;
	
	
	@BeforeSuite 
	public void  initialize() throws IOException{
		//Loading all the configuration from config file
		APPLICATION_LOGS.debug("Starting the test suite");
		APPLICATION_LOGS.debug("Loading config files");
		 
		 config =new Properties();
		FileInputStream fp= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\config.properties");
         config.load(fp);
         
         //loadXpaths
         APPLICATION_LOGS.debug("Loading Object XPATHS");
         
          OR = new Properties();
		 fp = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\config\\OR.properties");
		OR.load(fp);
		
		//initialize datatable
		datatable=new Xls_Reader(System.getProperty("user.dir")+"\\src\\test\\java\\config\\Controller.xlsx");
		
		
		if(config.getProperty("browserType").equals("Firefox")){			//browser types 
			System.setProperty("webdriver.gecko.driver", "T:\\Test_Team\\Selenium Projects_1\\Mavensecond\\New folder\\geckodriver.exe");
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			//wbDv driver = new FirefoxDriver(capabilities);
						 wbDv = new FirefoxDriver();
		}else if(config.getProperty("browserType").equals("IE")){
			  wbDv = new InternetExplorerDriver();
		}
		else if(config.getProperty("browserType").equals("Chrome"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("test-type");
			options.addArguments("start-maximized");
			options.addArguments("--js-flags=--expose-gc");  
			options.addArguments("--enable-precise-memory-info"); 
			options.addArguments("--disable-popup-blocking");
			options.addArguments("--disable-default-apps");
			options.addArguments("test-type=browser");
			options.addArguments("disable-infobars");
			System.setProperty("webdriver.chrome.driver", "T:\\Test_Team\\Selenium Projects_1\\Mavensecond\\New folder\\chromedriver.exe");
			  wbDv = new ChromeDriver(options);
		}
		
				APPLICATION_LOGS.debug("Starting the driver");  
				driver = new EventFiringWebDriver(wbDv); // intilaizing the webdriver
			  	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS );//Timeouts
			    driver.get(config.getProperty("testSiteURL"));// testsiteurl
			    driver.manage().window().maximize();//Maximize the window 
		}	


   public WebElement getobject(String xpathKey) {
		
    	try{
    	return driver.findElement(By.xpath(OR.getProperty(xpathKey)));
    	}catch(Throwable t){
    		//report error
    		TestUtil.takeScreenShot(xpathKey); // Screenshots
    		Assert.assertTrue(t.getMessage(), false);
    		APPLICATION_LOGS.debug("Error came "+ t.getLocalizedMessage());;
		return null;
}
}
 
   // web element //
public WebElement getElementByText(String text ) {
	List<WebElement> elements = driver.findElements(By.cssSelector("div#courseFinder > ol > li > a"));
	for(WebElement element:elements) {
		if(element.getText().contains(text)){
			return element;
		}
	}
	return null;
}
/*if(driver.findElement(By.cssSelector("ol > li")).isDisplayed()){
	List<WebElement> elements = driver.findElements(By.cssSelector("div#courseFinder > ol > li > a"));
	for(WebElement element : elements)
		if(element.getText().toLowerCase().contains(location)){
			System.out.println("inside if");
			System.out.println("text" +element.getText());
			element.click();
		}
	
}

    	*/
}




