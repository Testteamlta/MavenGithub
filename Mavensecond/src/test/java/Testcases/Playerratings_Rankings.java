package Testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.thoughtworks.selenium.Selenium;

import Utility.TestUtil;
import datatable.Xls_Reader;

public class Playerratings_Rankings extends Testbase {
	/*//  private static final //these steps have to given when you are using runmode 

		@BeforeTest  
		public void isskipped() {
			if (TestUtil.isskip("SignupAllAges"))//Excel sheet name
			throw new SkipException("Runmode set No");

		}

		@AfterTest
		public void quitBrowser() {
			driver.close();
		}*/

 
	@Test
	
	public  void testSignupAllAges() throws InterruptedException {
		Logger log  = Logger.getLogger("devpinoyLogger");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		getobject("competitions_link").click();
		log.debug("Competitions Link Clicked");
		Thread.sleep(1000);
		//getobject("Cookies").click();
		getobject("PlayerRatingsandRankings").click();
		log.debug("PlayerRatingsandRankings clicked");
		getobject("SeniorRankings").click();
		log.debug("Senior Rankings Link Clicked");
		//Thread.sleep(3000);
		//driver.findElement(By.xpath("//*[@id='feature']/div[1]/div/ul/li[2]/span/a")).click();
	    Thread.sleep(5000);
	    getobject("SeniorRankings_Gender").sendKeys("Male");
	    getobject("SeniorRankings_Agegroup").sendKeys("75+");
	    getobject("SeniorRankings_Area").sendKeys("Great Britain");
	    getobject("SeniorRankings_Filter").click();
	    Thread.sleep(9000);
		/*String e = driver.findElement(By.className("paginationJump left gutterLeft")).getText();
		
      if (e.equals("Results:"))
    	  
       	System.out.println(" Page Pass");
      else
         System.out.println(" Page Failed");*/

	    boolean present;
	    try {
	       driver.findElement(By.className("paginationJump left gutterLeft"));
	       present = true;
	    } catch (NoSuchElementException e) {
	       present = false;
	    }
		
		
	}
	

	
}

