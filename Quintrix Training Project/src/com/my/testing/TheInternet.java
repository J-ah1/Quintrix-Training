package com.my.testing;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class TheInternet {
	
	private WebDriver driver;
	
  @Test
  public void canLaunchChromeDriver() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  
	  //Act
	  driver.navigate().to(url);
	  String currentURL = driver.getCurrentUrl();
	  
	  //Assert
	  Assert.assertEquals(currentURL, url);
  }
  
  @Test
  public void canNavigateToIndexPage() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  String expectedPageTitle = "The Internet";
	  
	  //Act
	  String actualPageTitle = new IndexPage(driver, url)
			  .navigate()
			  .getTitle();
	  
	  //Assert
	  Assert.assertEquals(actualPageTitle, expectedPageTitle);
  }

  @Test
  public void tc4CanSelectDropdownListItem() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  String expectedSelection = "Option 2";
	  
	  //Act
	  String selectedOption = new DropdownPage(driver, url)
			  .navigate()
			  .select(expectedSelection)
			  .getOption();
	  
	  //Assert
	  Assert.assertEquals(selectedOption, expectedSelection);
  }
  
  @Test
  public void tc7CanTypeTextIntoInput() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  String expectedText = "7";
	  
	  //Act
	  String currentText = new InputsPage(driver, url)
			  .navigate()
			  .typeText(expectedText)
			  .getValue();
	  
	  //Assert
	  Assert.assertEquals(currentText, expectedText);
  }
  
  @Test
  public void tc37CanCheckCheckboxes() {
	  //Arrange
	  String url = "http://the-internet.herokuapp.com/";
	  
	  //Act
	  List<Boolean> boxStates = new CheckboxPage(driver, url)
			  .navigate()
			  .checkAllBoxes()
			  .getAllBoxStates();
	  
	  //Assert
	  for(Boolean boxState: boxStates) {
		  Assert.assertEquals(boxState.booleanValue(), true);
	  }
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
