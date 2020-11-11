package theInternet.foundation;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class Link extends WebElementControlExtension{

	public Link(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public void click() {
		this.extendedElement.click();
	}
}
