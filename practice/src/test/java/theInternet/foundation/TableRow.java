package theInternet.foundation;

import java.util.List;

import org.openqa.selenium.WebElement;

import framework.WebElementGroup;

public class TableRow extends WebElementGroup{

	public TableRow(List<WebElement> webElements) {
		super(webElements);
	}
	
	public WebElement getCellByText(String headerText) {
		return super.getElementWithText(headerText);
	}

	public int getColumnIndexByText(String headerText) {
		return super.getElementIndexByText(headerText);
	}

	public WebElement getCellByIndex(int columnIndex) {
		return super.getElementByIndex(columnIndex);
	}

}
