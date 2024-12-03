package com_Luma_Utilities;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import com_Luma_Test_Cases.Luma_Base_Class;

public class Reports implements ITestListener {

	public ExtentSparkReporter reporter; //it is provide the basic information about the document 
	//document title,report name,theme of the report
	public ExtentReports extent; //it is provide the basic information about the user
	
	public ExtentTest test; //it is provide the basic infomation about testcases status
	//pass,fail,skip
	
	//pre-defined methods(onStart,onTestSuccess,onTestFailure,onTestSkipped,onFinish
	
	
	public void onStart(ITestContext context) {
		
		String timestamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String repname="Luma_Test-Report_"+timestamp+".html";
		reporter=new ExtentSparkReporter("F:\\Eclipse work space\\Hybrid_Framework_Team32\\TestResults\\"+repname);
		
		//provide the basic information about the document
		
		reporter.config().setDocumentTitle("Luma Automation Testing");
		reporter.config().setReportName("Luma Registration and Login Functionality");
		reporter.config().setTheme(Theme.DARK);
		
		//provide the basic information about the user
		
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("user", "T Venkatarao");
		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("OS", "Windows,Macos,Linux");
		extent.setSystemInfo("Browser", "chrome,firefox,edge");
		
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		test=extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	
		try {
			String imgPath=new Luma_Base_Class().captureScreen(tr.getName());
			test.addScreenCaptureFromPath(imgPath);//add screenshot into extent report
			} 
		catch (Exception e) 
				{
				e.printStackTrace();
				}
		}
	
	public void onTestSkipped(ITestResult tr) {
		
		test=extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
}
