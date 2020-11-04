package com.my.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends PageObjectBase{

	public DropdownPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(id="dropdown")
	WebElement dropDownList;
	
	public DropdownPage navigate() {
		super.navigate("/dropdown");
		return this;
	}

	public DropdownPage select(String selection) {
		new Select(dropDownList).selectByVisibleText(selection);
		return this;
	}
	
	public String getOption() {
		return new Select(dropDownList).getFirstSelectedOption().getText();
	}
}
