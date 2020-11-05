package com.my.testing;

import org.openqa.selenium.WebElement;

public class Input {
	WebElement inputElement;
	
	public Input(WebElement inputElement) {
		this.inputElement = inputElement;
	}
	
	public Input setText(String text) {
		inputElement.sendKeys(text);
		return this;
	}
	
	public String getValue() {
		return inputElement.getAttribute("value");
	}
	
}
