package Testcases;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class Login extends Testbase  {

	 @Test
	    public void Clickalllinks() throws InterruptedException   {
		//WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		//driver.get("http://www.lta.org.uk/");
		//driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[@id='ctaList']/li[2]/div/a")).click();
		
		driver.findElement(By.xpath("//*[@id='HeaderPlaceHolder_ContentHeader_HeaderMiniCtaBoundProperty_ctl00_ctl02_ctl00_LoginContentAreaBoundProperty_ctl01_ctl03_ctl01_pnlLogin']/div[1]/h2[2]")).click();
		//driver.findElement(By.partialLinkText("Create a login")).click();
		driver.findElement(By.partialLinkText("Create a login")).click();
		driver.get("https://www2.lta.org.uk/Membership/WebsiteRegistration/");
		
		//driver.findElement(By.className("")).click();
		//driver.findElement(By.id("username")).sendKeys("testing");
		//driver.findElement(By.id("password")).sendKeys("password");
		Select sel =new Select(driver.findElement(By.id("ContentPlaceHolder1_PersonalDetails1_ddlTitle")));
		sel.selectByValue("Master.");
		//driver.findElement(By.id("Master")).click();
		driver.findElement(By.id("ContentPlaceHolder1_PersonalDetails1_txtFirstName")).sendKeys("Hello");
		//String Tello; 
		getobject("LastName").sendKeys("Tello");
		getobject("Date").sendKeys("10");
		getobject("Month").sendKeys("June");
		getobject("Year").sendKeys("2016");
		getobject("GenderM").click();
		getobject("Postcode").sendKeys("CR76AZ");
		getobject("Login_next").click();
		
		
	
	}

}
 