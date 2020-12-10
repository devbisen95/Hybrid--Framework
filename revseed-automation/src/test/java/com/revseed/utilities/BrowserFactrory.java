package com.revseed.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactrory {
	
	
	

	public static WebDriver startApllication(WebDriver driver, String BrowserName, String URL) {

		if (BrowserName.equals("Chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}

		else if (BrowserName.equals("Firefox")) {

			System.setProperty("webdriver.gecko.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else if (BrowserName.equals("IE")) {

			System.setProperty("webdriver.ie.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();

		}
		else {
			System.out.println("We do not support this Browser");
		}
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

     public static void quitBrowser(WebDriver driver) {  
	
	    driver.quit();
	
	
}
}
