package demoQA.foundation;

import java.util.List;

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
	@FindBy(id="gender-radio-1")
	WebElement genderRadio1;
	@FindBy(id="gender-radio-2")
	WebElement genderRadio2;
	@FindBy(id="gender-radio-3")
	WebElement genderRadio3;
	
	@FindBy(id="userNumber")
	WebElement userNumberInput;
	@FindBy(id="dateOfBirthInput")
	WebElement dateOfBirthInput;
	@FindBy(id="subjectsInput")
	WebElement subjectsInput;
	
	@FindBy(xpath="//div[@id=\"hobbiesWrapper\"]/div[position()=2]")
	WebElement hobbiesCheckboxesWrapper;
	@FindBy(id="hobbies-checkbox-1")
	WebElement hobbiesCheckbox1;
	@FindBy(id="hobbies-checkbox-2")
	WebElement hobbiesCheckbox2;
	@FindBy(id="hobbies-checkbox-3")
	WebElement hobbiesCheckbox3;
	
	
	@FindBy(id="uploadPicture")
	WebElement uploadPictureFileSelect;
	@FindBy(id="currentAddress")
	WebElement currentAddressInput;
	@FindBy(id="react-select-3-input")
	WebElement selectStateInput;
	@FindBy(id="react-select-4-input")
	WebElement selectCityInput;
	@FindBy(id="submit")
	WebElement submitButton;
	
	@FindBy(css="[role=\"dialog\"]")
	WebElement modalWindow;
	
	public PracticeFormPage navigate() {
		super.navigate();
		return this;
	}
	
	// Web Elemen extension?
	// Also, could gather all the inputs from a given div
	// Thus making a "checkbox Group" and "radio button group"
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
	
	// Gender radio button inputs
	public PracticeFormPage selectGenderWithText(String genderText) {
		String[] genderOptions = {"Male","Female", "Other"};
		for(String gender : genderOptions) {
			if(genderText.toUpperCase().charAt(0) == gender.toUpperCase().charAt(0)
					|| genderText.toUpperCase().equals(gender.toUpperCase()))
				genderText = gender;
		}
		WebElement checkboxToSelect = new CheckboxGroup(genderCheckboxesWrapper).getCheckboxWithLabel(genderText);
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
		dateOfBirthInput.sendKeys(textToSend);
		dateOfBirthInput.sendKeys(Keys.ENTER);
		return this;
	}
	
	// Subjects input
	
	// Hobbies checkboxes input
	// Hmmm, need to worry about multiple hobbies
	public PracticeFormPage selectHobbiesWithText(String hobbies) {
		//new CheckboxGroup().getCheckboxWithLabel().click();
		return this;
	}
	
	// Upload picture fileSelect Input
	
	public PracticeFormPage sendTextToCurrentAddressInput(String textToSend) {
		currentAddressInput.sendKeys(textToSend);
		return this;
	}
	
	// State dropdown input
	
	// City dropdown input

	public PracticeFormPage submitForm() {
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
