package theInternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import framework.WebElementGroup;
import theInternet.foundation.Button;

public class AddRemoveElementsPage extends PageObjectBase{
	private final String urlPath = "add_remove_elements/";
	
	public AddRemoveElementsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@class=\"example\"]//button")
	WebElement addButton;
	
	@FindBy(id="elements")
	List<WebElement> deleteButtons;

	public AddRemoveElementsPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public AddRemoveElementsPage addButton(int numButtonsToAdd) {
		while(numButtonsToAdd > 0) {
			new Button(addButton).click();
			numButtonsToAdd--;
		}
		return this;
	}
	
	public AddRemoveElementsPage pressDeleteButton(int deleteButtonIndex, int numTimesToPress) {
		while(numTimesToPress > 0) {
			new Button(
					new WebElementGroup(deleteButtons).getElementByIndex(deleteButtonIndex)
					).click();
			numTimesToPress--;
		}
		return this;
	}
	
	public AddRemoveElementsPage pressDeleteButton(int numTimesToPress) {
		pressDeleteButton(0, numTimesToPress);
		return this;
	}

	public int getNumOfDeleteButtons() {
		return deleteButtons.size();
	}
	
	
}
