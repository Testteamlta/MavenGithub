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
import Utility.TestUtil;
import datatable.Xls_Reader;

public class Childmembership extends Testbase {
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
	
	public  void testChildmembership(String Title,String Name, String Lname,
			String Date,String Month,String year,
			String Email,String Mobile, String address1, String town, String county,String postcode,
			String username,String password ) throws InterruptedException {
		//driver.get(config.getProperty("testSiteURL"));
		Logger logger =Logger.getLogger("devpinoyLogger");
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[@id='ctaList']/li[2]/div/a")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath(".//*[@id='HeaderPlaceHolder_ContentHeader_HeaderMiniCtaBoundProperty_ctl00_ctl02_ctl00_LoginContentAreaBoundProperty_ctl01_ctl03_ctl01_pnlLogin']/div[1]/h2[2]")).click();
		driver.findElement(By.partialLinkText("Sign up today")).click();
		logger.debug("signup clicked childmemebership");
		getobject("Cookies").click();
		Thread.sleep(3000);
	getobject("Child_JoinToday").click();
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
	logger.info("nothankyou clicked");
	System.out.println("starting wait");
	Thread.sleep(5000);
	System.out.println("done sleeping");
	getobject("createaccount_allages").click();
	logger.debug("Child membership account created");
	getobject("Childmembership_TermsandConditions").click();
	Thread.sleep(2000);
	getobject("JoinBritishTennis").click();
		Thread.sleep(3000);
		logger.debug("Child membership whole process completed");
		String e = driver.findElement(By.className(".//*[@id='MainContentPlaceHolder_PnlConfirm']/div/div[2]/div[1]")).getText();
		System.out.println(e);
	driver.close();
	}
	
	//private WebElement getobject(String string) {
		// TODO Auto-generated method stub
		//return null;
	//}

	@DataProvider
	public Object[][] getdata() {
	  Xls_Reader xlreader = new Xls_Reader("T:\\Test_Team\\Selenium Projects_1\\Website\\src\\Config\\Controller.xlsx");
	       int rows = xlreader.getRowCount("Sheet3")-1;
	       int cols = xlreader.getColumnCount("Sheet3");
	 
	      Object[][] data = new Object[rows][cols];
	       for (int i = 0; i < rows; i++) {
	              for (int j = 0; j < cols; j++) {
	                     data[i][j] = xlreader.getCellData("Sheet3", j, i+2);
	                    
	                    
	              }
	       }
	              return data;
	 
	// excel sheet (check with the my own xls sheet)
		/*@DataProvider
		public Object[][] getData() {

		return TestUtil.getData("SignupAllAges");*/// sheet name//excel location is picking from Test.java class which is in runmode package

}
}

