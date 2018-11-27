package Testcases;
import java.util.List;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.thoughtworks.selenium.Selenium;
import UsingFunction.*;
import Utility.TestUtil;
import datatable.Xls_Reader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;
public class java_Script_Error {
	 
	WebDriver webDriver;
	WebDriver driver;
	   LogEntries logEntries;


	   public static void logConsoleEntries (LogEntries logEntries) {
	       for (LogEntry logEntry : logEntries) {
	           System.out.println(String.valueOf(" Time Stamp: " + logEntry.getTimestamp()));
	           System.out.println(String.valueOf(" Log Level: " + logEntry.getLevel()));
	           System.out.println(String.valueOf(" Log Message: " + logEntry.getMessage()));
	       }
	   }

	   @Test
	   public void catchJavaScriptError() throws Exception
	   {
	       String url = "https://lta-test75.lta.org.uk";
	       System.setProperty("webdriver.chrome.driver", "T:\\Test_Team\\Selenium Projects_1\\Website\\New folder\\chromedriver.exe");
	       webDriver = new ChromeDriver();
	       webDriver.get(url);
	   
	       List<WebElement> linksize = driver.findElements(By.tagName("a")); 
	     	int linksCount = linksize.size();
			System.out.println("Total no of links Available: "+linksCount);
			String[] links = new String[linksCount];
			System.out.println("List of links Available: ");
			
			// print all the links from webpage 
			for(int i=0;i<linksCount;i++)
			{
			links[i] = linksize.get(i).getAttribute("href");
			WebDriver all_links_webpage;
			//System.out.println(all_links_webpage.get(i).getAttribute("href"));
			} 
			// navigate to each Link on the webpage
			for(int i=0;i<linksCount;i++)
			{
			driver.navigate().to(links[i]);
			System.out.println(driver.getTitle());
			System.out.println(driver.getCurrentUrl());
			System.out.println("No of Links Clicked :"+i);
			if(driver.getPageSource().contains("Page not found!")||
			   driver.getPageSource().contains("Server Error")||
			   driver.getPageSource().contains("Forbidden"))  
			{
		    	
		    	System.out.println("FAIL PLEASE CHECK");
		    		    	
		    	 File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		    	 	String screenshotFileName = "T:\\Test_Team\\Selenium Projects_1\\TestMavenProject\\ClickingAllLinks\\screenshots"+timestamp()+".png";
		    	 	
				    File dest= new File(screenshotFileName);
				    
				    try {
						FileUtils.copyFile(scr,dest);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				    
				    System.out.println(screenshotFileName);
				    //Logger log  = Logger.getLogger("devpinoyLogger");
				    //log.debug(screenshotFileName);
			}
			
			else
		    	
		    {
		    	
		     System.out.println("Pass");
		     
		    }
		    	
		driver.navigate().to(links[i]);
		    
		    Thread.sleep(3000); 	
		    	
		    	   
		    		
			}
		}
	       
	   private String timestamp() {
			// TODO Auto-generated method stub
			 return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date()); 
	       //logEntries = webDriver.manage().logs().get(LogType.BROWSER);
	       //logConsoleEntries(logEntries);
	       //webDriver.quit();
	   }
}
	
	
	


