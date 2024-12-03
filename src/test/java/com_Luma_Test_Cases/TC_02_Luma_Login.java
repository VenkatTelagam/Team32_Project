package com_Luma_Test_Cases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com_Luma_Page_Objects.Luma_Login_Page;
import com_Luma_Utilities.XLUtils;

public class TC_02_Luma_Login extends Luma_Base_Class 
{

    @Test(dataProvider="LumaLoginSheet")
	public void logintest(String Email, String Password) throws InterruptedException {
    	
    	Luma_Login_Page LP=new Luma_Login_Page(driver);
    	
    	LP.setEmail(Email);
    	Thread.sleep(2000);
    	
    	LP.setPassword(Password);
    	Thread.sleep(2000);
    	
    	LP.clickButtonSignIn();
    	
    	LP.clearEmail();
    	LP.clearPassword();
    	
    }
    
    @DataProvider(name="LumaLoginSheet")
    
    String [][] getdata() throws IOException{
    	
    	
    	String path="F:\\Eclipse work space\\Hybrid_Framework_Team32\\src\\test\\java\\com_Luma_Testdata\\LumaLoginSheet.xlsx";
    	
    	
    	//identify row count
    	int rownum= XLUtils.getRowCount(path, "Sheet1");
    	
    	//identify column count
    	
    	int colcount=XLUtils.getCellcount(path, "Sheet1", 1);
    	
    	//Two sets of data(Username,Password)
    	String logindata[][]=new String [rownum][colcount];
    	
    	for(int i=1; i<=rownum; i++) { // it represents rows
    		
    	for(int j=0; j<colcount; j++) { // It represent the colums
    		
    		logindata[i-1][j]= XLUtils.getcelldata(path, "Sheet1", i, j);	
    	}
    	}
    	
		return logindata;
    	
    }
	
}
