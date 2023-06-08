package com.testCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.MakeAppointmentPage;
import com.pageObjects.ReaddmissionPage;

public class ReadmissionTest extends BaseClass{
	@BeforeClass
	public void verifyLoginAndPageDetails() throws Exception {
		LoginTest test=new LoginTest();	
		test.verifyLoginAndPageDetails();
	
	}
	
	@Test(priority=1)
	
	public void ReAppointment() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ReaddmissionPage page= new ReaddmissionPage(driver);
		String actualText=page.facility_ReAdd();
		String expectedText="Seoul CURA Healthcare Center";
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualText, expectedText);
		System.out.println("Selected option: " + actualText);
	//	page.ReAddmission_Ch();
		Thread.sleep(1000);
	//	page.health_program_ReAdd();
		
	/*	page.date("07/06/2023");
		Thread.sleep(1000);
		
	   page.bookAppointment();
	   Thread.sleep(1000);
	    String expectedUrl = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch");

        logger.info("successfully Appointment: " + expectedUrl );
		*/
		
	}
	
	@Test(priority=2)
	public void reAddmissionSelected()throws Exception  {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ReaddmissionPage page= new ReaddmissionPage(driver);
		SoftAssert softAssert=new SoftAssert();
		if(!page.ReAddmission_Ch().isSelected()) {
			softAssert.assertTrue(true);
			page.ReAddmission_Ch().click();
	}else {
		softAssert.assertTrue(false);
	}
		
		}
	
	@Test(priority=3)
	public void rehealthcare() throws Exception {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    ReaddmissionPage page = new ReaddmissionPage(driver);
	    page.ReAddmission_Ch();
	    List<WebElement> radiobtn = page.health_program_ReAdd();
	    SoftAssert softAssert = new SoftAssert();
	    int index = 0; 
	    if (index >= 0 && index < radiobtn.size()) {
	        WebElement radio = radiobtn.get(index);
	        if (!radio.isSelected()) {
	            radio.click();
	            System.out.println("Selected Program is: " + radio.getAttribute("value"));
	            softAssert.assertTrue(true);
	        } else {
	            softAssert.assertTrue(false);
	        
	            /*
	            try {
	                captureScreen(driver, "test");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            */
	        }
	    } 
	    
	    logger.info("Completed Test");
	}
	
	@Test(priority=4)
	public void DateSelect() throws Exception {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    ReaddmissionPage page = new ReaddmissionPage(driver);
	    page.ReAddmission_Ch();
	    page.health_program_ReAdd();
	    SoftAssert softAssert=new SoftAssert();
	    try
	    {
	    	WebElement actualDate=page.date_pick();
	    	String expectedDate="18/08/2023";
	    	softAssert.assertEquals(actualDate, expectedDate);
	    }catch(Exception e) {
	    	
	    	 e.printStackTrace();
	    }
	    		
	    		
	    		Thread.sleep(1000);
	    // Validate the button's text
	    String expectedButtonText = "Book Appointment";
	    String actualButtonText = page.book_appointment.getText();
	    Assert.assertEquals(actualButtonText, expectedButtonText, "Button text is not matching.");

	    // Validate the button's visibility
	    Assert.assertTrue(page.book_appointment.isDisplayed(), "Button is not displayed.");

	    // Validate the button's enabled state
	    Assert.assertTrue(page.book_appointment.isEnabled(), "Button is not enabled.");
	    logger.info("successfully Booked: " + expectedButtonText );
		
	   page.bookAppointment();
	   Thread.sleep(1000);
	    String expectedUrl = "https://katalon-demo-cura.herokuapp.com/appointment.php#summary";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch");

        logger.info("successfully Appointment: " + expectedUrl );
	    
}

}