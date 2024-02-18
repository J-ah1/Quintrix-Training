package com.my.testing;

import org.openqa.selenium.WebElement;

public class CheckBox {
	WebElement checkboxElement;
	
	public CheckBox(WebElement checkboxElement) {
		this.checkboxElement = checkboxElement;
	}

	public CheckBox setState(boolean state) {
		String attrState = (state ? "true" : "");
		if(!attrState.equals(checkboxElement.getAttribute("checked")))
			checkboxElement.click();
		return this;
	}

	public Boolean getState() {
		if(checkboxElement.getAttribute("checked") != null)
			return true;
		return false;
	}
}
