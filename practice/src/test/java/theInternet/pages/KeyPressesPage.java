package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class KeyPressesPage extends PageObjectBase{
	private final String urlPath = "key_presses";
	
	public KeyPressesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@FindBy(id="target")
	WebElement textField;
	
	@FindBy(id="result")
	WebElement resultText;
	
	public KeyPressesPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	//NTS
	//Surround and create textInput class
	public String getCorrespondingKeyPress(char key) {
		textField.sendKeys(Character.toString(key));
		String fullResultText = resultText.getText();
		int colonIndex = fullResultText.indexOf(":");
		String keyPressText = fullResultText
				.substring(colonIndex+1,fullResultText.length())
				.trim();
		return keyPressText;
	}
}
