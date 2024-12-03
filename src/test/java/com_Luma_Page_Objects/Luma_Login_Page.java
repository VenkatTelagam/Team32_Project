package com_Luma_Page_Objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Luma_Login_Page {
	
	
	public WebDriver driver;
	
	//this page devided into 3 parts
	
	//1.constructor
	
	public Luma_Login_Page(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		
	}
	
	//2.idenrify web elements
	
	//Login
	
	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(id="pass")
	WebElement txtpassword;
	
	@FindBy(id="send2")
	WebElement btnSignIn;
	
	//3.Create actions
	
	public void setEmail(String Email) {
		
		txtEmail.sendKeys(Email);
	}
	
	public void setPassword(String Password) {
		
		txtpassword.sendKeys(Password);
	}
	
	public void clickButtonSignIn() {
		
		btnSignIn.click();
	}
	
	public void clearEmail() {
		
		txtEmail.clear();
	}
	
	public void clearPassword() {
		
		txtpassword.clear();
	}

}
