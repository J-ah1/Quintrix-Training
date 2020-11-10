package theInternet.foundation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class NumericInput extends WebElementControlExtension{
	
	public NumericInput(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public NumericInput setText(String text) {
		extendedElement.sendKeys(text);
		return this;
	}
	
	public String getValue() {
		return extendedElement.getAttribute("value");
	}

	public void changeNumericValue(int value) {
		// Changes the numeric value utilizing the keyboard
		while(value != 0) {
			if(value > 0) {
				extendedElement.sendKeys(Keys.UP);
				value--;
			}else {
				extendedElement.sendKeys(Keys.DOWN);
				value++;
			}
		}
	}
	
}
