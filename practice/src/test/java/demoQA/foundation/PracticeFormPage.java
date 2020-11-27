package demoQA.foundation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class PracticeFormPage extends PageObjectBase{

	public PracticeFormPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="firstName")
	WebElement firstNameInput;
	@FindBy(id="lastName")
	WebElement lastNameInput;
	@FindBy(id="userEmail")
	WebElement userEmailInput;
	@FindBy(xpath="//div[@id=\"genterWrapper\"]/div[position()=2]")
	WebElement genderCheckboxesWrapper;
	@FindBy(id="userNumber")
	WebElement userNumberInput;
	@FindBy(id="dateOfBirthInput")
	WebElement dateOfBirthInput;
	@FindBy(id="subjectsInput")
	WebElement subjectsInput;
	@FindBy(xpath="//div[@id=\"hobbiesWrapper\"]/div[position()=2]")
	WebElement hobbiesCheckboxesWrapper;
	@FindBy(id="uploadPicture")
	WebElement uploadPictureFileSelect;
	@FindBy(id="currentAddress")
	WebElement currentAddressInput;
	@FindBy(xpath="//div[@id=\"stateCity-wrapper\"]/div[position()=2]")
	WebElement selectStateInputDiv;
	@FindBy(xpath="//div[@id=\"stateCity-wrapper\"]/div[position()=3]")
	WebElement selectCityInputDiv;
	@FindBy(id="submit")
	WebElement submitButton;
	
	@FindBy(css="[role=\"dialog\"]")
	WebElement modalWindow;
	
	public PracticeFormPage navigate() {
		super.navigate();
		return this;
	}
	
	public PracticeFormPage sendTextToFirstNameInput(String textToSend) {
		firstNameInput.sendKeys(textToSend);
		return this;
	}
	
	public PracticeFormPage sendTextToLastNameInput(String textToSend) {
		lastNameInput.sendKeys(textToSend);
		return this;
	}
	
	public PracticeFormPage sendTextToUserEmailInput(String textToSend) {
		userEmailInput.sendKeys(textToSend);
		return this;
	}
	
	public PracticeFormPage selectGenderWithText(String genderText) {
		String[] genderOptions = {"Male","Female", "Other"};
		for(String gender : genderOptions) {
			if(genderText.toUpperCase().charAt(0) == gender.toUpperCase().charAt(0)
					|| genderText.toUpperCase().equals(gender.toUpperCase()))
				genderText = gender;
		}
		WebElement checkboxToSelect = new CheckboxGroup(genderCheckboxesWrapper).getCheckboxWithLabel(genderText);
		if(checkboxToSelect == null) {
			System.out.println("Checkbox with text: '" + genderText + "' does not exist");
			return this;
		}
		// Doing the below to bypass "click intercepted by label"
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", checkboxToSelect);
		return this;
	}
	
	public PracticeFormPage sendTextToUserNumberInput(String textToSend) {
		textToSend = textToSend.replace("-", "");
		textToSend = textToSend.replace("(", "");
		textToSend = textToSend.replace(")", "");
		userNumberInput.sendKeys(textToSend);
		return this;
	}
	
	public PracticeFormPage sendTextToDateOfBirthInput(String textToSend) {
		dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
		dateOfBirthInput.sendKeys(textToSend);
		dateOfBirthInput.sendKeys(Keys.ENTER);
		return this;
	}
	
	
	public PracticeFormPage sendSubjectsToSubjectInput(String subjects) {
		subjects = subjects.trim();
		if(subjects == null || subjects.equals(""))
			return this;
		for(String subject : subjects.split(";")) {
			subjectsInput.sendKeys(subject);
			subjectsInput.sendKeys(Keys.TAB);
		}
		return this;
	}
	
	public PracticeFormPage selectHobbiesWithText(String hobbies) {
		if(hobbies == null || hobbies.equals(""))
			return this;
		for(String hobby : hobbies.split(";")) {
			WebElement checkboxToSelect = new CheckboxGroup(hobbiesCheckboxesWrapper).getCheckboxWithLabel(hobby);
			if(checkboxToSelect == null) {
				System.out.println("Checkbox with text: '" + hobby + "' does not exist");
				continue;
			}
			// Doing the below to bypass "click intercepted by label"
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", checkboxToSelect);
		}
		return this;
	}
	
	// Upload picture fileSelect Input
	
	public PracticeFormPage sendTextToCurrentAddressInput(String textToSend) {
		currentAddressInput.sendKeys(textToSend);
		return this;
	}
	
	public PracticeFormPage selectStateFromDropdown(String stateToSelect) {
		// Had to include driver to include "scrolling past the footer"
		// to allow clicking of the element.
		new ReactDropdown(selectStateInputDiv, driver).selectByText(stateToSelect);;
		return this;
	}
	
	public PracticeFormPage selectCityFromDropdown(String cityToSelect) {
		// Had to include driver to include "scrolling past the footer"
		// to allow clicking of the element.
		new ReactDropdown(selectCityInputDiv, driver).selectByText(cityToSelect);;
		return this;
	}

	public PracticeFormPage submitForm() {
		// Do the following to scroll past the footer
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", submitButton);
		submitButton.click();
		return this;
	}
	
	public boolean isModalActive() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(modalWindow));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
