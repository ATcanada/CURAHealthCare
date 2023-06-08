package com.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
//import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.base.BaseClass;
import com.pageObjects.LoginPage;


	public class LoginTest extends BaseClass {

	    @Test(priority = 1)
	    public void verifyLoginAndPageDetails() throws TimeoutException {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        LoginPage logPage = new LoginPage(driver);
	        String expectedTitle = "CURA Healthcare Service";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(actualTitle, expectedTitle, "Page title mismatch");

	        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
	        String actualUrl = driver.getCurrentUrl();
	        Assert.assertEquals(actualUrl, expectedUrl, "URL mismatch");

	        logger.info("Website launched successfully with the URL: " + expectedUrl + " and title: " + expectedTitle);

	        logPage.appointment();
	        logPage.userName("John Doe");
	        logPage.userpwd("ThisIsNotAPassword");
	        logPage.login();

	        
	        
	    }
	    
	 
	}

	

