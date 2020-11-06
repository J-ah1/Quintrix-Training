package com.my.testing;

import org.openqa.selenium.WebElement;

public class NumericInput {
	WebElement inputElement;
	
	public NumericInput(WebElement inputElement) {
		this.inputElement = inputElement;
	}
	
	public NumericInput setText(String text) {
		inputElement.sendKeys(text);
		return this;
	}
	
	public String getValue() {
		return inputElement.getAttribute("value");
	}
	
}
