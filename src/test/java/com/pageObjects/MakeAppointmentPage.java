package com.pageObjects;

import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.base.BasePage;

public class MakeAppointmentPage extends BasePage{
	
	public WebDriverWait wait;
	public JavascriptExecutor js;
	public Actions action;
	public MakeAppointmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//select[@name='facility']")
	public WebElement dropdownElement; 
	
	@FindBy(id="radio_program_medicare")
	public WebElement healthcare; 
	
	
	@FindBy(xpath="//input[@placeholder='dd/mm/yyyy']")
	public WebElement datepick ; 
	
	
	@FindBy(id="btn-book-appointment")
	public WebElement book_appointment; 
	
	
	public String facility() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(dropdownElement));
		Select dropdown = new Select(dropdownElement);

        // Select an option by visible text
        dropdown.selectByIndex(2);;
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
		return selectedText;
        }
	/*public void health_program() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(healthcare));
		boolean isSelected = healthcare.isSelected();
        System.out.println("Is radio button selected? " + isSelected);
         healthcare.click();
    }*/
	public List<WebElement> health_program() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(healthcare));
	//	boolean isSelected = healthcare.isSelected();
		List<WebElement> option=driver.findElements(By.tagName("input"));
		return option ;
	}

	
	public void bookAppointment() throws TimeoutException {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(book_appointment));
		book_appointment.click();
	}

	public WebElement date_pick() {
		wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(datepick));
		datepick.sendKeys("12/09/2023");
		String date=datepick.getAttribute("value");
		return datepick;
	}
}
