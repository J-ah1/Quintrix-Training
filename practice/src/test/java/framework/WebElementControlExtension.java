package framework;

import org.openqa.selenium.WebElement;

public abstract class WebElementControlExtension {
	protected WebElement extendedElement;
	
	protected WebElementControlExtension(WebElement extendedElement) {
		this.extendedElement = extendedElement;
	}
}
