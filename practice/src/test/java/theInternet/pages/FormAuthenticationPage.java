package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import framework.PageObjectBase;
import theInternet.foundation.Button;

public class FormAuthenticationPage extends PageObjectBase{
	private final String urlPath = "login";

	public FormAuthenticationPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="username")
	WebElement inputUsernameElement;
	
	@FindBy(id="password")
	WebElement inputPasswordElement;
	
	@FindBy(tagName="button")
	WebElement loginButton;

	public FormAuthenticationPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	//NTS
	//Surround and create textInput class
	public FormAuthenticationPage typeUser(String user) {
		inputUsernameElement.sendKeys(user);
		return this;
	}

	public FormAuthenticationPage typePassword(String password) {
		inputPasswordElement.sendKeys(password);
		return this;
	}
	
	public FormAuthenticationPage enterCredentials() {
		new Button(loginButton).click();
		return this;
	}

	public boolean isAuthorized() {
		if(driver.getCurrentUrl().equals(baseUrl + "secure"))
			return true;
		return false;
	}
	
}
