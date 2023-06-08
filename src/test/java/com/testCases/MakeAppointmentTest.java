package com.testCases;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.pageObjects.MakeAppointmentPage;
import com.pageObjects.ReaddmissionPage;

public class MakeAppointmentTest extends BaseClass{
	
	@BeforeClass

	public void verifyLoginAndPageDetails() throws Exception {
		LoginTest test=new LoginTest();	
		test.verifyLoginAndPageDetails();
	
	}
	
	@Test(priority=1)
	
	public void makeAppointment() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MakeAppointmentPage page= new MakeAppointmentPage(driver);
		String actualText=page.facility();
		String expectedText="Seoul CURA Healthcare Center";
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertEquals(actualText, expectedText);
		System.out.println("Selected option: " + actualText);
		}
	
	@Test(priority=2)
	public void healthProgram() throws Exception {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    MakeAppointmentPage page= new MakeAppointmentPage(driver);
	    
	    List<WebElement> radiobtn = page.health_program();
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
	        
	            
	            try {
	                captureScreen(driver, "test");
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	            
	        }
	    } 
	    
	    logger.info("Completed Test");
	}
	
	@Test(priority=3)
	public void Select_Date() throws Exception {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    MakeAppointmentPage page= new MakeAppointmentPage(driver);
	    
	    page.health_program();
	    
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

