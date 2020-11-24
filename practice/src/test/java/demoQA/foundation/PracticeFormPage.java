package demoQA.foundation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	public PracticeFormPage navigate() {
		super.navigate();
		return this;
	}

}
