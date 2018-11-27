package Testcases;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CompetionBookingTest extends Testbase{
	@Test
    public void testCompetionBooking()throws InterruptedException{
          
                 // WebDriver driver = new FirefoxDriver();
                  //driver.get("http://www.lta.org.uk/");
                  driver.manage().window().maximize();
                  driver.findElement(By.xpath(".//*[@id='HeaderPlaceHolder_ContentHeader_TopLevelNavigation_NavigationRepeater_NavigationLink_1']")).click();
                  driver.findElement(By.xpath(".//*[@id='SecondaryNavigationPlaceHolder_MainSecondaryLevelNavigation_NavigationRepeater_NavigationLink_1']")).click();
                  driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[2]/div[1]/ul/li[1]")).click(); 
                  driver.findElement(By.xpath("html/body/div[4]/div/div/div/div/span")).click();
                  
                  
                  
                 int locations= driver.findElements(By.className("lta-competition-results")).size();
                                  System.out.println(locations);
                                  //driver.findElement(By.partialLinkText("Add to basket")).click();
                  
                     if(driver.findElements(By.partialLinkText("Add to basket")).size()>0)  
                      {
                   	  Random r = new java.util.Random();
                   	   java.util.List<WebElement> links = driver.findElements(By.partialLinkText("Add to basket"));
                   	   System.out.println("numer of locations found" +links.size() );
                   	   int randomValue = r.nextInt(links.size()); //Getting a random value that is between 0 and (list's size)-1
                   	   links.get(randomValue).click(); //Clicking on the random item in the list.
                      }
                            
                      else
                    	 //System.out.println("fail");
                  	   driver.findElement(By.xpath(".//*[@id='2']")).click();
                   driver.findElement(By.partialLinkText("Add to basket")).click();
                  
}
}


