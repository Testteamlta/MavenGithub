package Testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.firefox.MarionetteDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.javascript.host.Console;
import com.thoughtworks.selenium.Selenium;

import Utility.TestUtil;
import datatable.Xls_Reader;

public class SignupAllAges extends Testbase {
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

 //static Logger log = Logger.getLogger(SignupAllAges.class);
	@Test(dataProvider="getdata")
	
	public  void testSignupAllAges(String Title,String Name, String Lname,
			String Date,String Month,String year,
			String Email,String Mobile, String address1, String town, String county,String postcode,
			String username,String password, String Primaryvenue ) throws InterruptedException {
		Logger log  = Logger.getLogger("devpinoyLogger");
		
		driver.get(config.getProperty("testSiteURL"));
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='ctaList']/li[3]/a[1]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='HeaderPlaceHolder_ContentHeader_HeaderMiniCtaBoundProperty_ctl00_ctl02_ctl00_LoginContentAreaBoundProperty_ctl01_ctl03_ctl01_pnlLogin']/div[1]/h2[2]")).click();
		//driver.findElement(By.partialLinkText("Sign up today")).click();
		log.debug("Signup clicked");
		
		//selenium.getEval("scrollBy(0, 250)");
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,250)", "250");
		
		if(driver.findElement(By.xpath("//*[@id='AngularAppDiv']/div[2]/div/a[1]")).isDisplayed())
		     {
		   	getobject("Cookies").click();
			System.out.println("Cookies tab found");
		     }
		   else 
		       {
			System.out.println("Cookies tab not found");
		       }
			
	Thread.sleep(4000);
	getobject("JoinTodayAllAges").click();
	Thread.sleep(5000);
	log.debug("Clubmembership jointoday clicked");
	getobject("SelectTitle_allages").sendKeys(Title);
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
	log.debug("Username entered");
	getobject("password").sendKeys(password);
	getobject("Retypepassword").sendKeys(password);
	getobject("Nothankyou").click();
	
	//getobject("createaccount_allages").submit();
	//Alert alert = driver.switchTo().alert();
	//alert.dismiss();
	//getobject("createaccount_allages").click();
	//getobject("createaccount_allages").sendKeys("\t\n");
	//driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
	
	System.out.println("starting wait");
	Thread.sleep(5000);
	System.out.println("done sleeping");
	getobject("createaccount_allages").click();
	
	getobject("Primary_venue").sendKeys(Primaryvenue);
	Thread.sleep(10000);
	driver.findElement(By.xpath(".//*[@id='ui-id-4']")).click();
	/*"202|National Tennis Centre"
	getobject("[@id='ui-id-" + Primaryvenue.split("|")[0] + "']").sendKeys(Primaryvenue.split("|")[1]);
	"".//*[@id='ui-id-204'].click()
	
	getobject("Ballot_Optout").click();
	getobject("").click();*/
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
	  Xls_Reader xlreader = new Xls_Reader("T:\\Test_Team\\Selenium Projects_1\\Website\\src\\Config\\Controller.xlsx");
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

		return TestUtil.getData("SignupAllAges");*/// sheet name//excel location is picking from Test.java class which is in runmode package

}
}


