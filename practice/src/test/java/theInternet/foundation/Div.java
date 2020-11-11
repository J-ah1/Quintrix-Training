package theInternet.foundation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class Div extends WebElementControlExtension{

	public Div(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public WebElement getElementByTag(String tagName) {
		return extendedElement.findElement(By.tagName(tagName));
	}

}
