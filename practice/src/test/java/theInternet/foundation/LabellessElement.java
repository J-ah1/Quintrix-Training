package theInternet.foundation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class LabellessElement extends WebElementControlExtension{
	private WebDriver driver;

	public LabellessElement(WebDriver driver, WebElement extendedElement) {
		super(extendedElement);
		this.driver = driver;
	}
	
	public String getLabelFromNextSibling() {
		String script = "var childNode = arguments[0].nextSibling;"
				+ "return childNode === undefined? null : childNode.textContent;";
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String elementText = (String)js.executeScript(script, extendedElement);	

		if(elementText != null) {
			elementText = elementText.trim();
		}

		return elementText;
	}
	
	public String getLabelFromPrevSibling() {
		String script = "var childNode = arguments[0].previousSibling;"
				+ "return childNode === undefined? null : childNode.textContent;";
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		String elementText = (String)js.executeScript(script, extendedElement);	

		if(elementText != null) {
			elementText = elementText.trim();
		}

		return elementText;
	}
	
	public String getLabelFromVisibleChildren() {
		return extendedElement.getText();
	}
}
