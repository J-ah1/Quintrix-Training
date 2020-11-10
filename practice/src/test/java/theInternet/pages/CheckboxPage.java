package theInternet.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import theInternet.foundation.Checkbox;
import theInternet.foundation.CheckboxGroup;
import framework.PageObjectBase;

public class CheckboxPage extends PageObjectBase {
	private final String urlPath = "checkboxes";
	
	public CheckboxPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(tagName="input")
	List<WebElement> checkboxes;
	
	@FindBy(id="checkboxes")
	WebElement checkboxGroup;
	
	public CheckboxPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	
	public CheckboxPage checkBoxesByLabels(String[] labelsForBoxesToCheck) {
		new CheckboxGroup(checkboxGroup, driver).checkBoxesByLabels(labelsForBoxesToCheck);
		return this;
	}
	
	// Change these to remove the List<WebElement> checkboxes
	public CheckboxPage checkAllBoxes() {
		for(WebElement checkbox: checkboxes) {
			new Checkbox(checkbox).setState(true);
		}
		return this;
	}

	public List<Boolean> getAllBoxStates() {
		List<Boolean> boxStates = new ArrayList<Boolean>();
		for(WebElement checkBox: checkboxes) {
			boxStates.add(new Checkbox(checkBox).getState());
		}
		return boxStates;
	}
	
}
