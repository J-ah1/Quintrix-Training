package theInternet.tests;

import org.testng.annotations.Test;

import theInternet.foundation.TheInternetTestBase;
import theInternet.pages.AddRemoveElementsPage;
import theInternet.pages.BasicAuthPage;
import theInternet.pages.CheckboxPage;
import theInternet.pages.ContextMenuPage;
import theInternet.pages.DisappearingElementsPage;
import theInternet.pages.DropdownPage;
import theInternet.pages.FormAuthenticationPage;
import theInternet.pages.HoversPage;
import theInternet.pages.IndexPage;
import theInternet.pages.InputsPage;
import theInternet.pages.JQueryUIMenusPage;
import theInternet.pages.JavaScriptAlertPage;
import theInternet.pages.KeyPressesPage;
import theInternet.pages.MultipleWindowsPage;
import theInternet.pages.OnloadErrorPage;
import theInternet.pages.RedirectLinkPage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
  
  @Test
  public void tc8CanRedirectWithLink() {
	  //Arrange
	  String expectedPageUrl = "http://the-internet.herokuapp.com/status_codes";
	  
	  //Act
	  String currentPageUrl = new RedirectLinkPage(webDriver, baseUrl)
			  .navigate()
			  .clickRedirectLink()
			  .getCurrentUrl();
	  
	  //Assert
	  Assert.assertEquals(currentPageUrl, expectedPageUrl);
  }
 
  @Test
  public void tc52DoesGalleryInconsistentlyAppear() {
	  //Arrange
	  boolean expectedDoesGalleryAppear = true;
	  boolean expectedDoesGalleryNotAppear = true;
	  
	  //Act
	  boolean doesGalleryAppear = new DisappearingElementsPage(webDriver, baseUrl)
			  .navigate()
			  .gallerySometimesAppears();
	  boolean doesGalleryNotAppear = new DisappearingElementsPage(webDriver, baseUrl)
			  .navigate()
			  .gallerySometimesDoesNotAppear();
	  
	  
	  //Assert
	  Assert.assertEquals(doesGalleryAppear, expectedDoesGalleryAppear);
	  Assert.assertEquals(doesGalleryNotAppear, expectedDoesGalleryNotAppear);
  }
  
  @Test
  public void tc22AllHoverablesDisplayValidCaptions() {
	  // Arrange
	  String expectedHover1Caption = "name: user1";
	  String expectedHover2Caption = "name: user2";
	  String expectedHover3Caption = "name: user3";
	  
	  // Act
	  HoversPage hoversPage = new HoversPage(webDriver, baseUrl)
			  .navigate();
	  String hover1Caption = hoversPage.getFigureCaptionByIndex(0);
	  String hover2Caption = hoversPage.getFigureCaptionByIndex(1);
	  String hover3Caption = hoversPage.getFigureCaptionByIndex(2);
	  
	  // Assert
	  Assert.assertEquals(hover1Caption, expectedHover1Caption);
	  Assert.assertEquals(hover2Caption, expectedHover2Caption);
	  Assert.assertEquals(hover3Caption, expectedHover3Caption);
  }
  
  @Test
  public void tc64CanOpenNewValidWindowWithLink() {
	  //Arrange
	  String expectedNewWindowTitle = "New Window";
	  
	  //Act
	  String newWindowTitle = new MultipleWindowsPage(webDriver, baseUrl)
			  .navigate()
			  .clickNewWindowLink()
			  .getNewWindowTitle();
	  
	  //Assert
	  Assert.assertEquals(newWindowTitle, expectedNewWindowTitle);
  }
  
  @Test
  public void tc22DoesContextMenuBoxWork() {
	  // Arrange
	  boolean expectedDoesContextMenuBoxWork = true;
	  
	  // Act
	  ContextMenuPage contextMenuPage = new ContextMenuPage(webDriver, baseUrl);
	  boolean doesContextMenuBoxWork = contextMenuPage
			  .navigate()
			  .rightClickContextMenuBox()
			  .isAlertPresent();
	  contextMenuPage.acceptAlert();
	  
	  // Assert
	  Assert.assertEquals(doesContextMenuBoxWork, expectedDoesContextMenuBoxWork);

  }
  
  @Test
  public void tc51ValidateCSVMenuItemPath() {
	  // Arrange
	  boolean expectedCSVMenuItemPath = true;
	  
	  // Act
	  boolean actualCSVmenuItemPath = new JQueryUIMenusPage(webDriver, baseUrl)
			  .navigate()
			  .isMenuItemPresent("CSV", new String[]{"Enabled", "Downloads"});
	  
	  // Assert
	  Assert.assertEquals(actualCSVmenuItemPath, expectedCSVMenuItemPath);

  }
  
  @Test
  public void tc50CanValidUserValidPassword() {
	  //Arrange
	  String validUser = "tomsmith";
	  String validPassword = "SuperSecretPassword!";
	  boolean canValidUserValidPassword = false;
	  boolean expectedCanValidUserValidPassword = true;
	  
	  //Act
	  canValidUserValidPassword = new FormAuthenticationPage(webDriver, baseUrl)
			  .navigate()
			  .typeUser(validUser)
			  .typePassword(validPassword)
			  .enterCredentials()
			  .isAuthorized();
	  
	  //Assert
	  Assert.assertEquals(canValidUserValidPassword, expectedCanValidUserValidPassword);
  }
  
  @Test
  public void tc103CanDetectAlphabet() {
	  //Arrange
	  String lowerCaseAlphabet = "abcdefghijklmnopqrstuvwxyz";
	  String[] expectedCorrespondingKeyPress = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
	  String[] correspondingKeyPress = new String[26];
	  
	  //Act
	  KeyPressesPage keyPressesPage = new KeyPressesPage(webDriver, baseUrl)
			  .navigate();
	  for(int i = 0; i < lowerCaseAlphabet.length(); i++) {
		  correspondingKeyPress[i] = keyPressesPage
				  .getCorrespondingKeyPress(lowerCaseAlphabet.charAt(i));
	  }
	  
	  //Assert
	  Assert.assertEquals(correspondingKeyPress, expectedCorrespondingKeyPress);
  }
  
  @Test
  public void tc6IsSevereErrorPresent() {
	  //Arrange
	  boolean isSevereErrorPresent = false;
	  boolean expectedIsSevereErrorPresent = true;
	  //Act
	  isSevereErrorPresent = new OnloadErrorPage(webDriver, baseUrl)
			  .navigate()
			  .isSevereErrorPresent();
	  
	  //Assert
	  Assert.assertEquals(isSevereErrorPresent, expectedIsSevereErrorPresent);
  }

  @Test
  public void tc12CanDeleteButtonDelete() {
	  //Arrange
	  int numDeleteButtonsToAdd = 3;
	  int numDeleteButtonsToDelete = 2;
	  int expectedNumDeleteButtons = 1;
	  //Act
	  int numDeleteButtons = new AddRemoveElementsPage(webDriver, baseUrl)
			  .navigate()
			  .addButton(numDeleteButtonsToAdd)
			  .pressDeleteButton(numDeleteButtonsToDelete)
			  .getNumOfDeleteButtons();
	  //Assert
	  Assert.assertEquals(numDeleteButtons, expectedNumDeleteButtons);
  }
  
}
