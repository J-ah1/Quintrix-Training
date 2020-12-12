package theInternet.foundation;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class Checkbox extends WebElementControlExtension{
	
	public Checkbox(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public Checkbox click() {
		extendedElement.click();
		return this;
	}

	public Checkbox setState(boolean state) {
		if(getState() != state)
			extendedElement.click();
		return this;
	}

	public Boolean getState() {
		if(extendedElement.getAttribute("checked") != null)
			return true;
		return false;
	}
}
