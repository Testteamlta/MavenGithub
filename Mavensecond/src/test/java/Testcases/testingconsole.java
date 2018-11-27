package Testcases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class testingconsole {
	WebDriver driver;
	public static void main(String[] args) throws IOException{

	    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	    BufferedWriter out = null;
		try {
			out = new BufferedWriter(new FileWriter("T:\\Test_Team\\Selenium Projects_1\\Website\\output.txt"));
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	    try {
	        String inputLine = null;
	        do {
	            inputLine=in.readLine();
	            out.write(inputLine);
	            out.newLine();
	        } while (!inputLine.equalsIgnoreCase("eof"));
	        System.out.print("Write Successful");
	    } catch(IOException e1) {
	        System.out.println("Error during reading/writing");
	    } finally {
	        try {
				out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        try {
				in.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
	    }
	//}}
	
public void clicklinks() throws InterruptedException {	
		
		//NEWCODE STARTS
		
		//private static String[] links = null;
		//private static int linksCount = 0;

	
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
	}
	}
	

	
	


