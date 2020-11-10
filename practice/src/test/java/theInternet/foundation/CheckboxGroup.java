package theInternet.foundation;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxGroup {
	WebElement checkboxGroupElement;
	WebDriver driver;
	
	public CheckboxGroup(WebElement checkboxGroupElement, WebDriver driver) {
		this.checkboxGroupElement = checkboxGroupElement;
		this.driver = driver;
	}
	
	public CheckboxGroup checkBoxesByLabels(String[] labelsForBoxesToCheck) {
		setBoxesByLabels(labelsForBoxesToCheck, true);
		return this;
	}
	
	private void setBoxesByLabels(String[] labelsForBoxesToCheck, boolean isDesiredChecked) {
		for(String labelForBoxToCheck : labelsForBoxesToCheck) {
			List<WebElement> childElements = checkboxGroupElement.findElements(By.cssSelector("*"));
			
			for(WebElement childElement : childElements) {
				String lookAheadElementText = getFollowingSiblingTextContent(childElement);
				
				if(lookAheadElementText == null)
					continue;
				if(!lookAheadElementText.equals(labelForBoxToCheck))
					continue;
				//
				new Checkbox(childElement).setState(isDesiredChecked);
			}
			
		}
	}

	public String[] getLabelsForChecked() {
		List<String> checkedElementsTexts = new ArrayList<String>();
		List<WebElement> childElements = checkboxGroupElement.findElements(By.cssSelector("*"));

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
