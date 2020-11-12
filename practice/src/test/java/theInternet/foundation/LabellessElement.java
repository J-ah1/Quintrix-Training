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
	
	public String getLabelFromChildren() {
		String label = null;
		//Hmm
		//This actually only works because one of the elements <A> is surrounding the
		//#text, so we'll need to replace this with js executor
		//On top of that, look deeper
		//Just need to find "some" label
		for(WebElement childElement : extendedElement.findElements(By.xpath("*"))) {
			if(childElement.getText() == null)
				continue;
			label = childElement.getText();
			break;
		}
		
		return label;
	}
}
