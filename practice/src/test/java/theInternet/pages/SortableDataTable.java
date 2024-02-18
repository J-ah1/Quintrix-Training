package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.Table;

public class SortableDataTable extends PageObjectBase{
	private final String urlPath = "tables";
	
	public SortableDataTable(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="table1")
	WebElement table1;
	
	
	public SortableDataTable navigate() {
		super.navigate(urlPath);
		return this;
	}

	public SortableDataTable clickHeader(String headerText) {
		new Table(table1).clickHeader(headerText);
		return this;
	}


	public String getCellTextFromHeaderAndRowIndex(String headerText, int rowNumber) {
		return new Table(table1).getCellTextFromHeaderAndRowIndex(headerText, rowNumber);
	}
	
	
}
