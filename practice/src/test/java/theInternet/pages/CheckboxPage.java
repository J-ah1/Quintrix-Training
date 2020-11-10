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
	
	public CheckboxPage checkAllBoxes() {
		new CheckboxGroup(checkboxGroup, driver).checkAllBoxes();
		return this;
	}
	
	public CheckboxPage uncheckAllBoxes() {
		new CheckboxGroup(checkboxGroup, driver).uncheckAllBoxes();
		return this;
	}

	public List<Boolean> getAllBoxStates() {
		return new CheckboxGroup(checkboxGroup, driver).getAllBoxStates();
	}
	
}
