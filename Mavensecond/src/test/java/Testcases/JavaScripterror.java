package Testcases;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JavaScripterror {
	 WebDriver driver;
	 WebDriver webDriver;
	 @BeforeTest
	 public void setup() throws Exception {
		
		 		 //String url = "https://lta-test75.lta.org.uk";
		 //System.setProperty("webdriver.gecko.driver", "T:\\Test_Team\\Selenium Projects_1\\Website\\New folder old\\geckodriver.exe");
			//DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			//capabilities.setCapability("marionette", true);
			//webDriver = new FirefoxDriver();
	      // webDriver.get(url);
			 FirefoxProfile profile = new FirefoxProfile();
			System.setProperty("webdriver.gecko.driver", "T:\\Test_Team\\Selenium Projects_1\\Website\\New folder\\geckodriver.exe");
			  JavaScriptError.addExtension(profile);
			//  driver = new FirefoxDriver(profile);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.get("https://lta-test75.lta.org.uk");
	 }

	 @Test
	 public void printPageErrors() throws Exception {
	  //Capture all errors and store them In array.
	  List<JavaScriptError> Errors = JavaScriptError.readErrors(driver);
	  System.out.println("Total No Of JavaScript Errors : " + Errors.size());
	  //Print Javascript Errors one by one from array.
	  for (int i = 0; i < Errors.size(); i++) {
	   System.out.println("Error Message : "
	     + Errors.get(i).getErrorMessage());
	   System.out.println("Error Line No : "
	     + Errors.get(i).getLineNumber());
	   System.out.println(Errors.get(i).getSourceName());
	   System.out.println();
	  }
	 }
	}

