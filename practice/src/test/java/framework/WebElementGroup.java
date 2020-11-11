package framework;

import java.util.List;

import org.openqa.selenium.WebElement;

public class WebElementGroup {
	private List<WebElement> webElements;
	
	public WebElementGroup(List<WebElement> webElements) {
		this.webElements = webElements;
	}
	
	public WebElement getElementWithText(String elementText) {
		for(WebElement webElement: webElements) {
			if(webElement.getText() == null)
				continue;
			if(webElement.getText().equals(elementText))
				return webElement;
		}
		return null;
	}
	
	public boolean isThereElementWithText(String elementText) {
		for(WebElement webElement: webElements) {
			if(webElement.getText() == null)
				continue;
			if(webElement.getText().equals(elementText))
				return true;
		}
		return false;
	}
	
	public void clickElementWithText(String elementText) {
		WebElement elementToClick = getElementWithText(elementText);
		if(elementToClick == null)
			throw new RuntimeException("Could not find element with text: '" + elementText + "' to click.");
		elementToClick.click();
	}
	
}
