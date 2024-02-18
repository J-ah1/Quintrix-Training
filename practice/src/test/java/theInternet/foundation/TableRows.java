package theInternet.foundation;

import java.util.List;

import org.openqa.selenium.WebElement;

import framework.WebElementGroup;

public class TableRows extends WebElementGroup{

	public TableRows(List<WebElement> webElements) {
		super(webElements);
	}

	public WebElement getElementByIndex(int rowIndex) {
		return super.getElementByIndex(rowIndex);
	}

}
