package Testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
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

public class Juniormembership extends Testbase {
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

	@Test(dataProvider="getdata")
	
	public  void testJuniormembership(String Title,String Name, String Lname,
			String Date,String Month,String year,
			String Email,String Mobile, String address1, String town, String county,String postcode,
			String username,String password, String Cardnumber, String ChFirstname, String ChLastname,
			String Cmonth, String Cyear, String CCV, String Cemail, String Caddress1, String Ctown,
			String Ccounty, String Cpostcode) throws InterruptedException {
		//driver.get(config.getProperty("testSiteURL"));
		Logger logger =Logger.getLogger("devpinoyLogger");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='ctaList']/li[3]/a[1]")).click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath(".//*[@id='HeaderPlaceHolder_ContentHeader_HeaderMiniCtaBoundProperty_ctl00_ctl02_ctl00_LoginContentAreaBoundProperty_ctl01_ctl03_ctl01_pnlLogin']/div[1]/h2[2]")).click();
		//driver.findElement(By.partialLinkText("Sign up today")).click();
		//logger.debug("signup clicked ");
		//Thread.sleep(4000);
		getobject("Cookies").click();
		//Thread.sleep(3000);
	getobject("Junior_JoinToday").click();
	//logger.debug("Junior Jointoday clicked ");
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
	getobject("password").sendKeys(password);
	Thread.sleep(2000);
	getobject("Retypepassword").sendKeys(password);
	getobject("Nothankyou").click();
	
	System.out.println("starting wait");
	Thread.sleep(9000);
	System.out.println("done sleeping");
	getobject("createaccount_allages").click();
	Thread.sleep(9000);
	logger.debug("Juinor Account created");
	getobject("Juniormembership_Ballot_Optout").click();
	getobject("Juniormembership_TermsandConditions").click();
	Thread.sleep(2000);
	getobject("Juniormembership_Checkout").click();
	Thread.sleep(3000);
	getobject("Paymentcard_MastercardOption").click();
	getobject("Cardnumber").sendKeys(Cardnumber);
	getobject("Cardholder_firstname").sendKeys(ChFirstname);
	getobject("Cardholder_lastname").sendKeys(ChLastname);
	getobject("Cardexpiry_month").sendKeys(Cmonth);
	getobject("Cardexpiry_year").sendKeys(Cyear);
	getobject("Ccv_Code").sendKeys(CCV);
	getobject("Cardholder_email").sendKeys(Cemail);
	getobject("Cardholder_addressmanually").click();
	getobject("Cardholder_address1").sendKeys(Caddress1);
	getobject("Cardholder_town").sendKeys(Ctown);
	getobject("Cardholder_county").sendKeys(Ccounty);
	getobject("Cardholder_postcode").sendKeys(Cpostcode);
	getobject("Payment_Completepurchase").click();
	Thread.sleep(5000);
	driver.close();
	}
	
	//private WebElement getobject(String string) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@DataProvider
	public Object[][] getdata() {
	  Xls_Reader xlreader = new Xls_Reader("T:\\Test_Team\\Selenium Projects_1\\Website\\src\\Config\\Controller.xlsx");
	       int rows = xlreader.getRowCount("Sheet2")-1;
	       int cols = xlreader.getColumnCount("Sheet2");
	 
	      Object[][] data = new Object[rows][cols];
	       for (int i = 0; i < rows; i++) {
	              for (int j = 0; j < cols; j++) {
	                     data[i][j] = xlreader.getCellData("Sheet2", j, i+2);
	                    
	                    
	              }
	       }
	              return data;
	 
	// excel sheet (check with the my own xls sheet)
		/*@DataProvider
		public Object[][] getData() {

		return TestUtil.getData("SignupAllAges");*/// sheet name//excel location is picking from Test.java class which is in runmode package

}
}


