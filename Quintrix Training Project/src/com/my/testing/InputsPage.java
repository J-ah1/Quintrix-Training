package com.my.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InputsPage extends PageObjectBase{
	
	public InputsPage(WebDriver driver, String  url) {
		super(driver, url);
	}
	
	@FindBy(how = How.TAG_NAME, using = "input")
	WebElement inputNumber;
	
	public InputsPage navigate() {
		super.navigate("/inputs");
		return this;
	}
	
	public InputsPage typeText(String text) {
		inputNumber.sendKeys(text);
		return this;
	}
	
	public String getValue() {
		return inputNumber.getAttribute("value");
	}
	
}
