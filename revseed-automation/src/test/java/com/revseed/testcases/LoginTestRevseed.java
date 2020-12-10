package com.revseed.testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.revseed.pages.BaseClass;
import com.revseed.pages.LoginPage;

public class LoginTestRevseed extends BaseClass {

	
	@Test
	public void loginApp() {

	
         logger = report.createTest("Login to Revseed");
		
		System.out.println(driver.getTitle());

		LoginPage pageOfLogin = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Starting Application");

		pageOfLogin.loginToApplicaton(excel.getData("Login", 0, 0), excel.getData("Login", 0, 1));
		
		logger.pass("Login Sucess"); 

	}

}