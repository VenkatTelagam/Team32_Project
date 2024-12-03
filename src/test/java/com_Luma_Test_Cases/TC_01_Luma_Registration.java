package com_Luma_Test_Cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com_Luma_Page_Objects.Luma_Registration_Page;

public class TC_01_Luma_Registration extends Luma_Base_Class{
	
	public Luma_Registration_Page LRP;
	
	@Test
	public void LumaRegistration() throws InterruptedException {
		
		LRP=new Luma_Registration_Page(driver);
		
		//LRP.setFirstName(null);
		//LRP.setLastName(null);
		
		LRP.setFirstName(FName);
		log.info("First Name Entered");
		
		LRP.setLastName(LName);
		log.info("Last Name Entered");
		
		LRP.setEmailAddress(Email);
		log.info("Email Address Entered");
		
		LRP.setPassword(Password);
		log.info("Password Entered");
		
		LRP.setConfirmPassword(CPassword);
		log.info("Confirm Password Entered");
		
		Thread.sleep(5000);
		LRP.clickCreateAnAccountButton();
		log.info("Create an Account button is clicked");
		
		//Hard-Assertion
		String Act_title=driver.getTitle();
		String Exp_title="My Account";
		
		if(Act_title.equals(Exp_title)) {
			
			Assert.assertTrue(true);
			System.out.println("Test case passed");
		}
		
		else {
			System.out.println("Testcase is failed");
			Assert.assertTrue(false); // execution stops here
		}
}
}