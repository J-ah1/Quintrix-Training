package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import theInternet.foundation.TheInternetPageLoader;

public abstract class PageObjectBase {
	protected WebDriver driver;
	protected String baseUrl;
	// Every pageobject has a urlPath
	// Some may require "special navigation"
	// This means the following format...
	// http://username:password@the-site.com
	// This is only applicable to basic_auth?
	// Because of this, just override navigate

	protected ILoadPages pageLoader;
	
	
	// Different constructors for creating base url
	protected PageObjectBase(WebDriver driver, String urlProtocol, String urlDomain, String urlPath) {
		this(driver, urlProtocol + "://" + urlDomain + "/", urlPath);
	}
	
	protected PageObjectBase(WebDriver driver, String baseUrl, String urlPath) {
		this(driver, baseUrl + urlPath);
	}
	
	protected PageObjectBase(WebDriver driver, String baseUrl) {
		this.driver = driver;
		this.baseUrl = baseUrl;
		//urlProtocol + "://" + urlDomain + "/";
		
		//Again, something to be defined in a test context...
		int pageLoadTimeoutMilliseconds = 35000;
		this.pageLoader = new TheInternetPageLoader(driver, pageLoadTimeoutMilliseconds);
		
		PageFactory.initElements(driver, this);
	}
	
	protected PageObjectBase navigate(String urlPath) {
		driver.navigate().to(baseUrl + urlPath);
		return this;
	}
	
	protected PageObjectBase navigate() {
		driver.navigate().to(baseUrl);
		return this;
	}
	
	
}
