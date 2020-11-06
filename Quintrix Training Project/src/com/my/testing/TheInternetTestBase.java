package com.my.testing;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TheInternetTestBase {
	protected ChromeDriver webDriver;
	protected String baseUrl;
	
	@BeforeTest
	protected void beforeTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Josh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.webDriver = new ChromeDriver();
		this.baseUrl = "http://the-internet.herokuapp.com/";
	}
	
	@AfterTest
	protected void afterTest() {
		this.webDriver.quit();
	}
}
