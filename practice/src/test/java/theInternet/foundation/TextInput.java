package theInternet.foundation;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class TextInput extends WebElementControlExtension{

	public TextInput(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public TextInput sendKeys(String keysToSend) {
		extendedElement.sendKeys(keysToSend);
		return this;
	}
	
}
