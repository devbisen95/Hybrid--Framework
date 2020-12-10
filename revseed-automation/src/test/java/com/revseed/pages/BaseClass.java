package com.revseed.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.revseed.utilities.BrowserFactrory;
import com.revseed.utilities.ConfigDataProvider;
import com.revseed.utilities.ExcelDataProvider;
import com.revseed.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	public ExtentHtmlReporter extent;

	@BeforeSuite
	public void setUpSuite() throws IOException {
		excel = new ExcelDataProvider();
		config = new ConfigDataProvider();
		extent = new ExtentHtmlReporter(new File(
				System.getProperty("user.dir") + "./Reports/hotelwiki" + Helper.getCurrentDateTime() + ".html"));
		report = new ExtentReports();
		report.attachReporter(extent);

	}

	@BeforeClass
	public void setup() {

		driver = BrowserFactrory.startApllication(driver, config.getBrowser(), config.stagingURL());

	}

	@AfterClass
	public void tearDown() {

		BrowserFactrory.quitBrowser(driver);

	}

	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenShot(driver);

//			logger.fail("Test Failed",
//					MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
//		}
//		else if(result.getStatus()==ITestResult.SUCCESS)
//		{
//			logger.pass("Test Pass",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
//		}
//		else if(result.getStatus()==ITestResult.SKIP)
//		{
//			logger.skip("Test Skip",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
//		}
//		
			
		}
		report.flush();
	}

}
