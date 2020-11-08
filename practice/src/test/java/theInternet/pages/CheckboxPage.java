package theInternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import theInternet.foundation.CheckBox;
import theInternet.foundation.PageObjectBase;

public class CheckboxPage extends PageObjectBase {
	private final String urlPath = "/checkboxes";
	
	public CheckboxPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(tagName="input")
	List<WebElement> checkBoxes;
	
	public CheckboxPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public CheckboxPage checkAllBoxes() {
		for(WebElement checkBox: checkBoxes) {
			new CheckBox(checkBox).setState(true);
		}
		return this;
	}

	public List<Boolean> getAllBoxStates() {
		List<Boolean> boxStates = new ArrayList<Boolean>();
		for(WebElement checkBox: checkBoxes) {
			boxStates.add(new CheckBox(checkBox).getState());
		}
		return boxStates;
	}
	
}
