package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.Button;
import theInternet.foundation.Table;

public class ChallengingDOMPage extends PageObjectBase{
	private final String urlPath = "challenging_dom";
	
	public ChallengingDOMPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(tagName="table")
	WebElement table;
	
	// Note, can't group due to changing attributes
	// Class seems to be the only constant
	// Also, all buttons do refresh the page
	@FindBy(css="[class='button']")
	WebElement blueButton;
	@FindBy(css="[class='button alert']")
	WebElement redButton;
	@FindBy(css="[class='button success']")
	WebElement greenButton;
	
	@FindBy(id="canvas")
	WebElement canvas;
	
	public ChallengingDOMPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public ChallengingDOMPage clickBlueButton() {
		clickButton(blueButton);
		return this;
	}
	
	public ChallengingDOMPage clickRedButton() {
		clickButton(redButton);
		return this;
	}
	
	public ChallengingDOMPage clickGreenButton() {
		clickButton(greenButton);
		return this;
	}
	
	private void clickButton(WebElement buttonToClick) {
		new Button(buttonToClick).click();
	}

	public String getCellTextFromHeaderAndRowIndex(String headerText, int rowNumber) {
		return new Table(table).getCellTextFromHeaderAndRowIndex(headerText, rowNumber);
	}
}
