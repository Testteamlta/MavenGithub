package Testcases;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;
public class Primary_HeeaderLinks extends Testbase{
	
	
	@Test 
	public void publicheader() throws InterruptedException {	
	
		
		//driver.get(config.getProperty("Play_Header"));
		driver.get(config.getProperty("Competitions_Header"));
		/*driver.get(config.getProperty("Majorevents_Header"));
		driver.get(config.getProperty("Venue_Management_Header"));
		driver.get(config.getProperty("New_Header"));
		driver.get(config.getProperty("CoachandTeach_Header"));
		driver.get(config.getProperty(""));*/
		
		
/* CHECKING SUBMENUS AND LINKS */
	    
	    
	    int size = driver.findElements(By.tagName("a")).size();
	    	  
	     System.out.println(size);
	    	  
	     List<String> Linkarray = new ArrayList<String>();
	    	     
	     List<WebElement> Linklist = driver.findElements(By.tagName("a"));
	    	     
	     for (WebElement link : Linklist) {
	    	        
	      String links = link.getText();
	      
	      Linkarray.add(links );
	    	       
	      }
	    	 for (String linkToTest : Linkarray){
	    	    	  
	    	 driver.findElement(By.linkText(linkToTest)).click();
	    	 
	    	 System.out.println(driver.getTitle());
			    
	 		System.out.println(driver.getCurrentUrl());
	    	       
	    	       
	    	Thread.sleep(3000);
	    	       
	    	if(driver.getTitle().contains("Problem")) {
	    	    	
	    	System.out.println("Fail");
	    	     
	    	 }
	    	    
	    	    else
	    	    	
	    	    {
	    	    	
	    	     System.out.println("pass");
	    	     
	    	    }
	    	    
	    	    driver.navigate().back();
	    	    
	    	    Thread.sleep(3000);
	    	    
	    	   } 
	    	      
	    	  driver.close();  
				         
	    	
	    	}  
	    	
	    	
	    }
