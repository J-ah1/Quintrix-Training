package com.my.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectBase {
	protected WebDriver driver;
	protected String baseUrl;

	protected PageObjectBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		PageFactory.initElements(driver, this);
	}
	
	protected void navigate(String urlPath) {
		driver.navigate().to(baseUrl + urlPath);
	}
	
	
	
}
