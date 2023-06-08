package com.pageObjects;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class LoginPage extends BasePage {
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;
//	public WebDriver ldriver;

	// Constructor

	public LoginPage(WebDriver driver) {
		super(driver);
		// ldriver = rdriver;
		// PageFactory.initElements(ldriver, this);
	}

	// Capture email field
	@FindBy(xpath = "//a[normalize-space()='Make Appointment']")
	@CacheLookup
	public WebElement appointmentbtn;

	@FindBy(xpath = "//input[@name='username']")
	@CacheLookup
	public WebElement userTxt;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement pwdText;
	
	@FindBy(xpath = "//body[1]/section[1]/div[1]/div[1]/div[2]/form[1]/div[4]/div[1]/button[1]")
	public WebElement loginbtn;
	
	
	// ==================Action methods===========================//

	public void appointment() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(appointmentbtn));
		appointmentbtn.click();
	}

	// Send text to the email field
	public void userName(String user) {

		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(userTxt));
		userTxt.sendKeys(user);
	}

	// Send text to password field
	public void userpwd(String pwd) {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(pwdText));
		pwdText.sendKeys(pwd);
	}
	public void login() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(loginbtn));
		loginbtn.click();
	}
	


}
