package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.BasicAuthPage;
import theInternet.pages.CheckboxPage;
import theInternet.pages.DropdownPage;
import theInternet.pages.IndexPage;
import theInternet.pages.InputsPage;
import theInternet.pages.JavaScriptAlertPage;

import java.util.List;

import org.testng.Assert;

public class TheInternet extends TheInternetTestBase {
	
  @Test
  public void canLaunchChromeDriver() {
	  //Arrange
	  
	  //Act
	  webDriver.navigate().to(baseUrl);
	  String currentURL = webDriver.getCurrentUrl();
	  
	  //Assert
	  Assert.assertEquals(currentURL, baseUrl);
  }
  
  @Test
  public void canNavigateToIndexPage() {
	  //Arrange
	  String expectedPageTitle = "The Internet";
	  
	  //Act
	  String actualPageTitle = new IndexPage(webDriver, baseUrl)
			  .navigate()
			  .getTitle();
	  
	  //Assert
	  Assert.assertEquals(actualPageTitle, expectedPageTitle);
  }

  @Test
  public void tc4CanSelectDropdownListItem() {
	  //Arrange
	  String expectedSelection = "Option 2";
	  
	  //Act
	  String selectedOption = new DropdownPage(webDriver, baseUrl)
			  .navigate()
			  .select(expectedSelection)
			  .getOption();
	  
	  //Assert
	  Assert.assertEquals(selectedOption, expectedSelection);
  }
  
  @Test
  public void tc7CanTypeTextIntoInput() {
	  //Arrange
	  String expectedText = "7";
	  
	  //Act
	  String currentText = new InputsPage(webDriver, baseUrl)
			  .navigate()
			  .typeText(expectedText)
			  .getValue();
	  
	  //Assert
	  Assert.assertEquals(currentText, expectedText);
  }
  
  @Test
  public void tc9CanIncrementNumericValue() {
	  //Arrange
	  String startingText = "3";
	  int amountToChangeValue = 4;
	  String expectedText = "7";
	  
	  //Act
	  String currentText = new InputsPage(webDriver, baseUrl)
			  .navigate()
			  .typeText(startingText)
			  .changeNumericValue(amountToChangeValue)
			  .getValue();
	  
	  //Assert
	  Assert.assertEquals(currentText, expectedText);
  }
   
  @Test
  public void tc28CanCheckBoxByLabel() {
	  //Arrange
	  String[] labelsForBoxesToCheck = {"checkbox 1"};
	  
	  //Act
	  List<Boolean> boxStates = new CheckboxPage(webDriver, baseUrl)
			  .navigate()
			  .checkBoxesByLabels(labelsForBoxesToCheck)
			  .getAllBoxStates();
	  
	  //Assert
	  for(Boolean boxState: boxStates) {
		  Assert.assertEquals(boxState.booleanValue(), true);
	  }
  }
  
  @Test
  public void tc37CanCheckAllCheckboxes() {
	  //Arrange
	  
	  //Act
	  List<Boolean> boxStates = new CheckboxPage(webDriver, baseUrl)
			  .navigate()
			  .checkAllBoxes()
			  .getAllBoxStates();
	  
	  //Assert
	  for(Boolean boxState: boxStates) {
		  Assert.assertEquals(boxState.booleanValue(), true);
	  }
  }
  
  @Test
  public void tc38CanUncheckAllCheckboxes() {
	  //Arrange
	  
	  //Act
	  List<Boolean> boxStates = new CheckboxPage(webDriver, baseUrl)
			  .navigate()
			  .uncheckAllBoxes()
			  .getAllBoxStates();
	  
	  //Assert
	  for(Boolean boxState: boxStates) {
		  Assert.assertEquals(boxState.booleanValue(), false);
	  }
  }
  
  @Test
  public void tc54CanSendValidBasicAuth() {
	  //Arrange
	  String validUser = "admin";
	  String validPass = "admin";
	  String expectedPageContent = "Congratulations! You must have the proper credentials.";
	  
	  //Act
	  String pageContent = new BasicAuthPage(webDriver, baseUrl)
	  	.navigateWithCredentials(validUser, validPass)
	  	.getPageContent();
	  	
	  //Assert
	  Assert.assertEquals(pageContent, expectedPageContent);
  }

  @Test
  public void tc17CanSendInputToJSPrompt() {
	  //Arrange
	  String testInput = "test";
	  String expectedResultText = "You entered: " + testInput;
	  
	  //Act
	  String currentResultText = new JavaScriptAlertPage(webDriver, baseUrl)
	  	.navigate()
	  	.clickButton("Click for JS Prompt")
	  	.typeTextToPrompt(testInput)
	  	.getResultText();
	  	
	  //Assert
	  Assert.assertEquals(expectedResultText, currentResultText);
  }
  
}
