package com.my.testing;

import org.openqa.selenium.WebDriver;

public class IndexPage extends PageObjectBase{
	
	public IndexPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public IndexPage navigate() {
		super.navigate("");
		return this;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
