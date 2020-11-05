package com.my.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class InputsPage extends PageObjectBase{
	private final String urlPath = "/inputs";
	
	public InputsPage(WebDriver driver, String  url) {
		super(driver, url);
	}
	
	@FindBy(how = How.TAG_NAME, using = "input")
	WebElement inputElement;
	
	public InputsPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public InputsPage typeText(String text) {
		new Input(inputElement).setText(text);
		return this;
	}
	
	public String getValue() {
		return new Input(inputElement).getValue();
	}
	
}
