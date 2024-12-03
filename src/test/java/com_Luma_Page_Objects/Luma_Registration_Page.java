package com_Luma_Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Registration_Page {
	
	public WebDriver driver;
	
	//this page devided into 3 parts
	//1.Constructor
	
	public Luma_Registration_Page(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
	
	//2.identify webelements
	
	@FindBy(id="firstname")
	WebElement txtFirstName;
	
	@FindBy(id="lastname")
	WebElement txtLastName;
	
	
	@FindBy(id="email_address")
	WebElement txtEmailAdd;
	
	@FindBy(id="password")
	WebElement txtPassword;
	
	@FindBy(id="password-confirmation")
	WebElement txtConfirmPassword;
	
	@FindBy(xpath="(//button[@type='submit']/span)[2]")
	WebElement btnCreateAnAccount;
	
	//3.Create actions
	
	public void setFirstName(String FName) {
		
		txtFirstName.sendKeys(FName);
	}
	
	public void setLastName(String LName) {
		
		txtLastName.sendKeys(LName);
	}
	
	public void setEmailAddress(String Email) {
		
		txtEmailAdd.sendKeys(Email);
	}
	
	public void setPassword(String Password) {
		
		txtPassword.sendKeys(Password);
	}
	
	public void setConfirmPassword(String CPassword) {
		
		txtConfirmPassword.sendKeys(CPassword);
	}
	
	public void clickCreateAnAccountButton() {
		
		btnCreateAnAccount.click();
	}

}
