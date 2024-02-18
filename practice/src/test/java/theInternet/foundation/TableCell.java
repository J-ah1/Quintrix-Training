package theInternet.foundation;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class TableCell extends WebElementControlExtension{

	public TableCell(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public TableCell click() {
		extendedElement.click();
		return this;
	}

	public String getText() {
		return extendedElement.getText();
	}

}
