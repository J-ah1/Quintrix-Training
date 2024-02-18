package theInternet.foundation;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class Button extends WebElementControlExtension{
	
	public Button(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public void click() {
		this.extendedElement.click();
	}
	
}
