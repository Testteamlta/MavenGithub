package UsingFunction;

import org.openqa.selenium.By;

import Testcases.Testbase;

public class TeacherTrainingEnrolmentForm extends Testbase {
	public static void RunTeacherTrainingPreEnrolmentForm() 
	
		//public  void RunTeacherTrainingPreEnrolmentForm() throws Exception 
		{
			
		//driver.get(baseUrl + "/yhs/search?p=youtube&intl=uk&type=default&hspart=mozilla&hsimp=yhs-008");
	    //driver.findElement(By.id("yui_3_10_0_1_1457011916697_129")).click();
	    //driver.findElement(By.id("masthead-search-term")).clear();
	   // driver.findElement(By.id("masthead-search-term")).sendKeys("selenium IDE");
	    //driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_HlBook")).click();
	   // driver.findElement(By.id("search-btn")).click();
	   // driver.findElement(By.xpath("//input[@type='text']")).click();
	   // driver.findElement(By.id("ui-id-2")).click();
	   // driver.findElement(By.xpath("//input[@type='text']")).clear();
	   // driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bousfield Primary School - SW5 0DJ");
		driver.findElement(By.xpath("//*[@id='preEnrolment']/div/input[1]")).sendKeys("abc");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath(".//*[@id='ui-id-6']")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_LblConsentNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_RBConsentNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_LblAccessNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_RBAccessNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_LblNeedsNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_RBNeedsNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyFirstName")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyFirstName")).clear();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyFirstName")).sendKeys("ac");
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyLastName")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyLastName")).clear();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyLastName")).sendKeys("vb");
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyTelephone")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyTelephone")).clear();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_TxtEmergencyTelephone")).sendKeys("012236654789");
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_LblhotographyNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_RBPhotographyNo")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_CBTerms")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_PreEnrolmentBooking_BtnSubmit")).click();
	    driver.findElement(By.id("MainContentPlaceHolder_SecondaryContentAreaBoundProperty_ctl00_ctl01_ctl00_BtnSubmit")).click();
	    try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
