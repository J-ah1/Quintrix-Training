package theInternet.foundation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

// Could definitely refactor this...
// Make CheckboxGroup an extension of WebElementGroup?
public class CheckboxGroup extends WebElementControlExtension{
	List<WebElement> checkboxes;
	WebDriver driver;
	
	public CheckboxGroup(WebElement extendedElement, WebDriver driver) {
		super(extendedElement);
		this.checkboxes = this.extendedElement.findElements(By.tagName("input"));
		this.driver = driver;
	}
	
	public CheckboxGroup checkAllBoxes() {
		setAllBoxStates(true);
		return this;
	}
	
	public CheckboxGroup uncheckAllBoxes() {
		setAllBoxStates(false);
		return this;
	}
	
	private void setAllBoxStates(boolean desiredState) {
		for(WebElement checkbox: checkboxes) {
			new Checkbox(checkbox).setState(desiredState);
		}
	}
	
	public CheckboxGroup checkBoxesByLabels(String[] labelsForBoxesToCheck) {
		for(String labelForBoxToCheck: labelsForBoxesToCheck) {
			for(WebElement checkbox: checkboxes) {
				String checkboxLabel = new LabellessElement(driver, checkbox).getLabelFromNextSibling();
				if(checkboxLabel == null)
					continue;
				if(checkboxLabel.equals(labelForBoxToCheck))
					new Checkbox(checkbox).setState(true);
			}
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

	public String[] getLabelsForChecked() {
		List<String> checkedElementsTexts = new ArrayList<String>();
		List<WebElement> childElements = extendedElement.findElements(By.cssSelector("*"));

		for(WebElement childElement : childElements) {
			boolean isCheckboxCurrentlyChecked = new Checkbox(childElement).getState();

			if(!isCheckboxCurrentlyChecked) {
				continue;
			}
			String lookAheadElementText = new LabellessElement(driver, childElement).getLabelFromNextSibling();			
			if(lookAheadElementText == null) {
				throw new RuntimeException("Could not get label for checked box");
			}
			checkedElementsTexts.add(lookAheadElementText);
		}
		
		return ToArray(checkedElementsTexts);
	}

	private String[] ToArray(List<String> list) {
		String[] array = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}

		return array; 
	}	

}
