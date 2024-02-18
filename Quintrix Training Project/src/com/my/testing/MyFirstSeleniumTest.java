package com.my.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MyFirstSeleniumTest {
	private WebDriver driver;
	
  @Test
  public void canLaunchChromeDriver() {
	  //Arrange
	  String url = "https://www.google.com/";
	  
	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();
	  
	  //Assert
	  Assert.assertEquals(currentURL, url);
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\Josh\\Downloads\\chromedriver_win32\\chromedriver.exe");
	  driver = new ChromeDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

}
