package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObjectBase {
	protected WebDriver driver;
	protected String baseUrl;
	// Every pageobject has a urlPath
	// Some may require "special navigation"
	// This means the following format...
	// http://username:password@the-site.com
	// This is only applicable to basic_auth?
	// Because of this, just override navigate

	protected PageObjectBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		PageFactory.initElements(driver, this);
	}
	
	protected void navigate(String urlPath) {
		driver.navigate().to(baseUrl + urlPath);
	}
	
	
	
}
