package theInternet.foundation;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class Slider extends WebElementControlExtension{

	public Slider(WebElement extendedElement) {
		super(extendedElement);
	}

	public Slider sendRightToSlider(int numberTimesPressRight) {
		while(numberTimesPressRight > 0) {
			extendedElement.sendKeys(Keys.ARROW_RIGHT);
			numberTimesPressRight--;
		}
		return this;
		
	}
	
	public Slider sendLeftToSlider(int numberTimesPressLeft) {
		while(numberTimesPressLeft > 0) {
			extendedElement.sendKeys(Keys.ARROW_LEFT);
			numberTimesPressLeft--;
		}
		return this;
	}

	public Double getSliderValue() {
		return Double.parseDouble(extendedElement.getAttribute("value"));
	}
}
