package com.revseed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver;
	

	
	public LoginPage(WebDriver localDriver) {
		
	    this .driver = localDriver;
		
	}
  @FindBy(name = "usernameOrEmail") WebElement username;
  
  @FindBy(id = "password") WebElement password;
  
  @FindBy(xpath = "//*[text()='Login']") WebElement loginButon;
	
	
  
  public void loginToApplicaton(String Username ,String Password) {
	  
	  username.sendKeys(Username);
	  password.sendKeys(Password);
	  loginButon.click();
	  
	  
  }
	
}
