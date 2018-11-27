package Testcases;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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
import UsingFunction.*;
import Utility.TestUtil;
import datatable.Xls_Reader;

public class BookingCourseTest extends Testbase {
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

 //static Logger log = Logger.getLogger(BookingCourse.class);
	@Test
	
	public  void testBookingCourse() throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.findElement(By.xpath("//*[@id='ctaList']/li[3]/a[1]")).click();
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(2000);
		getobject("Homepage_username").sendKeys("rackspace3");
		getobject("Homepage_Password").sendKeys("Testing123");
		getobject("Login_Button").click();
		Thread.sleep(20000);
		//driver.findElement(By.xpath(".//*[@id='username']")).sendKeys("childmember1");
		//driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("Testing123");
		//driver.findElement(By.xpath(".//*[@id='BtnLogin']")).click();
		//Thread.sleep(9000);
		driver.findElement(By.xpath("//*[@id='HeaderPlaceHolder_ContentHeader_TopLevelNavigation_NavigationRepeater_NavigationLink_5']")).click();
		driver.findElement(By.xpath(".//*[@id='HeaderPlaceHolder_ContentHeader_TopLevelNavigation_NavigationRepeater_ctl00_5_NavigationLink_2']")).click();
		Thread.sleep(4000);
		getobject("Cookies").click();
	getobject("Category").click();
	Thread.sleep(5000);
	getobject("TeacherTraining").click();
	Thread.sleep(3000);
	getobject("Updatedetails").click();
	Thread.sleep(7000);
	//if(driver.findElements(By.partialLinkText("Full Details")).size()>0)
	//{
		Random r= new java.util.Random();
		java.util.List<WebElement> links = driver.findElements(By.partialLinkText("Full Details"));
    	//System.out.println("numer of Full details" +links.size() );
		int randomValue = r.nextInt(links.size()); //Getting a random value that is between 0 and (list's size)-1
        links.get(randomValue).click(); //Clicking on the random item in the list.*/
        
        
       // getobject("Login_Book").click();// Below codes used after the course is selected and login
       // Thread.sleep(7000);
      //  driver.findElement(By.cssSelector("#MainContentPlaceHolder_FullWidthContentAreaBoundProperty_ctl00_ctl01_ctl00_pnlLogin > div.form.left > div.formRow > #username")).sendKeys("CHILDMEMBER1");
      //  driver.findElement(By.cssSelector("#MainContentPlaceHolder_FullWidthContentAreaBoundProperty_ctl00_ctl01_ctl00_pnlLogin > div.form.left > div.formRow > #password")).sendKeys("Testing123");
       // Thread.sleep(7000);
      //  driver.findElement(By.cssSelector("#MainContentPlaceHolder_FullWidthContentAreaBoundProperty_ctl00_ctl01_ctl00_pnlLogin > div.form.left > div.formRow > #BtnLogin")).click();
     //   Thread.sleep(10000);
        //getobject("Continue_to_Purchase").click();
        
        driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_HlBook")).click();
       
        if(driver.getPageSource().contains("Name of Attendee's School"))//Name of Attendee's School

			{
        	    System.out.println("Pre-Enrolment form found!");
        		TeacherTrainingEnrolmentForm.RunTeacherTrainingPreEnrolmentForm();
			}
        
        	else
        		{
        		
        		System.out.println("Pre-Enrolment form not found : ");
        		        
        		}
       
        if(driver.getPageSource().contains("Ace! Booking Confirmed!"))
        	
        {
        	System.out.println("Booking course is confirmed and its booked the course succesfully");
        }
        
        else
        {
        	System.out.println("Booking course is not confirmed and its fails");
        	driver.close();
        }
        
        
		}
	
	} 
        
        
        
        
		/*getobject("SelectTitle_allages").sendKeys(Title);
	getobject("FirstName").sendKeys(Name);
	getobject("LastName").sendKeys(Lname);
	getobject("Date").sendKeys(Date);
	getobject("Month").sendKeys(Month);
	getobject("Year").sendKeys(year);
	getobject("GenderM").click();
	getobject("Email").sendKeys(Email);
	getobject("Mobile").sendKeys(Mobile);
	getobject("addressmanually").click();
	getobject("Address1_manually").sendKeys(address1);
	getobject("Town_manually").sendKeys(town);
	getobject("County_manually").sendKeys(county);
	getobject("Postcode_manually").sendKeys(postcode);
	getobject("username").sendKeys(username);
	Thread.sleep(3000);
	getobject("password").sendKeys(password);
	getobject("Retypepassword").sendKeys(password);
	getobject("Nothankyou").click();*/
	
	//getobject("createaccount_allages").submit();
	//Alert alert = driver.switchTo().alert();
	//alert.dismiss();
	//getobject("createaccount_allages").click();
	//getobject("createaccount_allages").sendKeys("\t\n");
	//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	
	/*System.out.println("starting wait");
	Thread.sleep(5000);
	System.out.println("done sleeping");
	getobject("createaccount_allages").click();
	
	getobject("Primary_venue").sendKeys(Primaryvenue);
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[@id='ui-id-5']")).click();
	//"202|National Tennis Centre"
	//getobject("[@id='ui-id-" + Primaryvenue.split("|")[0] + "']").sendKeys(Primaryvenue.split("|")[1]);
	//"".//*[@id='ui-id-204'].click()
	
	getobject("Ballot_Optout").click();
	//getobject("").click();
	getobject("Membership_TermsandConditions").click();
	Thread.sleep(2000);
	getobject("JoinBritishTennis").click();
	Thread.sleep(3000);
	}
	
	//private WebElement getobject(String string) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@DataProvider
	public Object[][] getdata() {
	  Xls_Reader xlreader = new Xls_Reader("T:\\Test_Team\\Selenium Projects\\LTAProject\\src\\Config\\Controller.xlsx");
	       int rows = xlreader.getRowCount("Sheet1")-1;
	       int cols = xlreader.getColumnCount("Sheet1");
	 
	      Object[][] data = new Object[rows][cols];
	       for (int i = 0; i < rows; i++) {
	              for (int j = 0; j < cols; j++) {
	                     data[i][j] = xlreader.getCellData("Sheet1", j, i+2);
	                    
	                    
	              }
	       }
	              return data;
	 
	// excel sheet (check with the my own xls sheet)
		/*@DataProvider
		public Object[][] getData() {

		return TestUtil.getData("SignupAllAges");*/// sheet name//excel location is picking from Test.java class which is in runmode package*/



