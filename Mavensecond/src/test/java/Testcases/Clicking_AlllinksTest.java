package Testcases;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.thoughtworks.selenium.Selenium;


import UsingFunction.*;
import Utility.TestUtil;
import datatable.Xls_Reader;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;



public class Clicking_AlllinksTest {
	//WebDriver webDriver;
	WebDriver driver;
	   LogEntries logEntries;


	   public static void logConsoleEntries (LogEntries logEntries)  {
	       for (LogEntry logEntry : logEntries) {
	           System.out.println(String.valueOf(" Time Stamp: " + logEntry.getTimestamp()));
	           System.out.println(String.valueOf(" Log Level: " + logEntry.getLevel()));
	           System.out.println(String.valueOf(" Log Message: " + logEntry.getMessage()));
         		          	           	           
	   }      
	       }
	   
	
	@Test
	public void clicklinks() throws InterruptedException {	
		
		//NEWCODE STARTS
		
		//private static String[] links = null;
		//private static int linksCount = 0;

		String url = "https://lta-test75.lta.org.uk";
	       System.setProperty("webdriver.chrome.driver", "T:\\Test_Team\\Selenium Projects_1\\Mavensecond\\New folder old\\chromedriver.exe");
	       
	       driver = new ChromeDriver();
	       
	       driver.get(url);
	      
	       logEntries = driver.manage().logs().get(LogType.BROWSER);
	       logConsoleEntries(logEntries);
	      driver.manage().window().maximize();//Maximize the window 
	
	
	
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
		
		} 
				
		// navigate to each Link on the webpage
		for(int i=0;i<linksCount;i++)
		{
		driver.navigate().to(links[i]);
		logEntries = driver.manage().logs().get(LogType.BROWSER);
	       logConsoleEntries(logEntries);
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
	}
}	//}

	
	
	
	
	

	
	
	







