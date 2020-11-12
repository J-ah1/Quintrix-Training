package theInternet.foundation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class LabellessElement extends WebElementControlExtension{

	public LabellessElement(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public String getLabelFromChildren() {
		String label = null;
		
		for(WebElement childElement : extendedElement.findElements(By.xpath("*"))) {
			if(childElement.getText() == null)
				continue;
			label = childElement.getText();
			break;
		}
		
		return label;
	}
}
