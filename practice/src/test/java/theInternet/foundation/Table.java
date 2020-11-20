package theInternet.foundation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.WebElementControlExtension;

public class Table extends WebElementControlExtension{

	private List<WebElement> headerRow;
	private List<WebElement> bodyRows;

	public Table(WebElement extendedElement) {
		super(extendedElement);
		this.headerRow = extendedElement.findElements(By.xpath("./thead/tr/*"));
		this.bodyRows = extendedElement.findElements(By.xpath("./tbody/*"));
	}
	
	public Table clickHeader(String headerText) {
		WebElement desiredCell = new TableRow(headerRow).getCellByText(headerText);
		new TableCell(desiredCell).click();
		return this;
	}
	
	public String getCellTextFromHeaderAndRowIndex(String headerText, int rowIndex) {
		WebElement desiredRowParent = new TableRows(bodyRows).getElementByIndex(rowIndex);
		List<WebElement> desiredRow = desiredRowParent.findElements(By.xpath("./*"));
		int desiredColumnIndex = new TableRow(headerRow).getColumnIndexByText(headerText);
		WebElement desiredCell = new TableRow(desiredRow).getCellByIndex(desiredColumnIndex);
		return new TableCell(desiredCell).getText();
		
	}
	
	
}
