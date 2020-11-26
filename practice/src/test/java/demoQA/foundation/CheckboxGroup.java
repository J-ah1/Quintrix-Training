package demoQA.foundation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class CheckboxGroup {
	
	private WebElement checkboxDiv;
	private List<WebElement> checkboxes;
	private List<WebElement> checkboxLabels;

	public CheckboxGroup(WebElement checkboxDiv) {
		this.checkboxDiv = checkboxDiv;
		this.checkboxes = this.checkboxDiv.findElements(By.tagName("input"));
		this.checkboxLabels = this.checkboxDiv.findElements(By.tagName("label"));
	}

	// Was planning to use a hashmap, but not a definite solution as checkboxes
	// may have the same text.
	public WebElement getCheckboxWithLabel(String checkboxLabelText) {
		for(WebElement checkboxLabel : checkboxLabels) {
			if(checkboxLabel.getText() != null
					&& checkboxLabel.getText().equals(checkboxLabelText))
				return this.checkboxDiv.findElement(By.id(checkboxLabel.getAttribute("for")));
		}
		return null;
	}
	
}
