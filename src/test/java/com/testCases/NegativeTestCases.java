package com.testCases;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.base.BaseClass;
import com.pageObjects.LoginPage;
import com.utilities.ExcelUtils;

public class NegativeTestCases extends BaseClass{
	    
	    @Test(priority = 1,dataProvider="Data",dataProviderClass=ExcelUtils.class)
	    public void InvalidLogin(String user, String pwd) throws TimeoutException {
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        LoginPage logPage = new LoginPage(driver);
	        
	        logPage.appointment();
	        logPage.userName(user);
	        logPage.userpwd(pwd);
	        logPage.login();

	        
	        
	    }

}
