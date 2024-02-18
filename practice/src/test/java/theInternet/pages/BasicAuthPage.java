package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class BasicAuthPage extends PageObjectBase{
	private final String urlPath = "basic_auth";
	
	// Change constructor to take "protocol" and "domain"
	// Ugh, can't use urlPath in constructor
	// "Cannot refer to an instance field urlPath while explicitly invoking a constructor"
	
	public BasicAuthPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public BasicAuthPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public BasicAuthPage navigateWithCredentials(String username, String password) {
		int indexForCredentials = baseUrl.indexOf("://") + 3;
		String baseUrlWithCredentials = 
				baseUrl.substring(0,indexForCredentials) +
				username + ":" + password + "@" +
				baseUrl.substring(indexForCredentials, baseUrl.length()) +
				urlPath;
		driver.navigate().to(baseUrlWithCredentials);
		return this;
	}
	
	public String getPageContent() {
		return driver.findElement(By.tagName("p")).getText();
	}
	

}
