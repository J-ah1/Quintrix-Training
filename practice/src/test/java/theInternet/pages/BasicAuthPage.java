package theInternet.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class BasicAuthPage extends PageObjectBase{
	private final String urlPath = "basic_auth";
	private Alert alert;
	
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
	
	public BasicAuthPage findPromopt() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
		}catch(Throwable e){
			System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}
		return this;
	}
	
	public BasicAuthPage typeUsername(String username) {
		alert.sendKeys(username);
		return this;
	}
	public BasicAuthPage typePassword(String password) {
		return this;
	}
	public BasicAuthPage confirmPrompt() {
		return this;
	}

}
