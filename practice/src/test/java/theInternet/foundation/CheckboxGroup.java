package theInternet.foundation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;


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
		setBoxesByLabels(labelsForBoxesToCheck, true);
		return this;
	}
	
	private void setBoxesByLabels(String[] labelsForBoxesToCheck, boolean isDesiredChecked) {
		for(String labelForBoxToCheck : labelsForBoxesToCheck) {
			List<WebElement> childElements = extendedElement.findElements(By.cssSelector("*"));
			
			for(WebElement childElement : childElements) {
				String lookAheadElementText = getFollowingSiblingTextContent(childElement);
				
				if(lookAheadElementText == null)
					continue;
				if(!lookAheadElementText.equals(labelForBoxToCheck))
					continue;
				
				new Checkbox(childElement).setState(isDesiredChecked);
			}
			
		}
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
			String lookAheadElementText = getFollowingSiblingTextContent(childElement);			
			if(lookAheadElementText == null) {
				throw new RuntimeException("Could not get label for checked box");
			}
			checkedElementsTexts.add(lookAheadElementText);
		}
		
		return ToArray(checkedElementsTexts);
	}

	private String getFollowingSiblingTextContent(WebElement element) {
		String script = "var childNode = arguments[0].nextSibling;"
				+ "return childNode === undefined? null : childNode.textContent;";
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String elementText = (String)js.executeScript(script, element);	

		if(elementText != null) {
			elementText = elementText.trim();
		}

		return elementText;
	}

	private String[] ToArray(List<String> list) {
		String[] array = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			array[i] = list.get(i);
		}

		return array; 
	}	

}
