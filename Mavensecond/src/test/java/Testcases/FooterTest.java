package Testcases;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class FooterTest extends Testbase{
	
	
	@Test
	
	public void testFooter() throws InterruptedException {	
	
		if(driver.findElement(By.xpath(".//*[@id='AngularAppDiv']/cookie-message/div/div/a[1]")).isDisplayed())
	     {
	   	getobject("Cookies").click();
		System.out.println("Cookies tab found");
	     }
	   else 
	       {
		System.out.println("Cookies tab not found");
	       }
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;   //window to scroll down
		jse.executeScript("window.scrollBy(0,550)", "550");    //Window to scroll down
		Thread.sleep(3000);
		
	WebElement footer= driver.findElement(By.xpath(".//*[@id='globalFooterNew']/div[1]/div[1]/div"));
		// Get Footer element which contains all footer links
		
	System.out.println(footer.findElements(By.tagName("a")).size()) ; 
		
	java.util.List<WebElement>footerlinks = footer.findElements(By.tagName("a"));
		
	 int i = footer.findElements(By.tagName("a")).size(); //Get number of links		 
		 	 
	 for(int j = 0;j<i;j++){  //create loop based upon number of links to traverse all links 
			 
	 footer= driver.findElement(By.xpath(".//*[@id='globalFooterNew']/div[1]/div[1]/div"));  // We are re-creating "footer" webelement as DOM changes after navigate.back()
		  
	 footer.findElements(By.tagName("a")).get(j).getText();
		   
	 footer.findElements(By.tagName("a")).get(j).click();
		   
	 Thread.sleep(3000);
		   
	 System.out.println(driver.getTitle());
		   
	  if(driver.getTitle().contains("404")||
		 driver.getPageSource().contains("Page not found!")||
		  driver.getPageSource().contains("Server Error")||
		   driver.getPageSource().contains("Forbidden"))
		  
	  {
	    	System.out.println("FAIL PLEASE CHECK");
	    	    	
	    	 File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    	 	String screenshotFileName = "T:\\Test_Team\\Selenium Projects_1\\TestMavenProject\\Mavensecond\\Footers\\screenshots"+timestamp()+".png";
	    	 	
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
	    	
	  driver.navigate().back();
	    
	    Thread.sleep(3000); 	
	    	
		}   
	}	
				

		
	private String timestamp() {
		// TODO Auto-generated method stub
		 return new SimpleDateFormat("dd-MM-yyyy HH-mm-ss").format(new Date());
	}
}	//}

		  
		  
	 /* {
		    	  
	  System.out.println("404 Found");
		       
	   }
		      
		driver.navigate().back();
		    
		Thread.sleep(4000);
		   
		  }
		 
		 }
}*/

