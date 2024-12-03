package com_Luma_Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Luma_Readingdata {

	Properties pro;


	public Luma_Readingdata() {

		File file=new File("./Configuration/Data.properties");

		try {

			FileInputStream fis=new FileInputStream(file);

			pro= new Properties();
			pro.load(fis); // loading the properties file
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
	}

	//Registration

	public String getFirstName() {

		String FName=pro.getProperty("FirstName");	  
		return	FName;  

	}

	public String getLastName() {

		String LName=pro.getProperty("LastName");

		return LName;   
	}

	public String getEmail() {

		String Email=pro.getProperty("Email");
		return Email;
	}
	
	public String getPassword() {
		
		String Password=pro.getProperty("Password");
		
		return Password;
	}
	
	public String getConfirmPassword() {
		
		String ConfirmPassword=pro.getProperty("ConfirmPassword");
		return ConfirmPassword;
	}

}
