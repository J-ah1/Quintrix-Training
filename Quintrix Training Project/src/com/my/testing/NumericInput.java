package com.my.testing;

import org.openqa.selenium.Keys;
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

	public void changeNumericValue(int value) {
		// Changes the numeric value utilizing the keyboard
		while(value != 0) {
			if(value > 0) {
				inputElement.sendKeys(Keys.UP);
				value--;
			}else {
				inputElement.sendKeys(Keys.DOWN);
				value++;
			}
		}
	}
	
}
