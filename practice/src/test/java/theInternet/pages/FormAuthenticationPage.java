package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.Button;
import theInternet.foundation.TextInput;

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

	public FormAuthenticationPage typeUser(String user) {
		 new TextInput(inputUsernameElement).sendKeys(user);
		return this;
	}

	public FormAuthenticationPage typePassword(String password) {
		new TextInput(inputPasswordElement).sendKeys(password);
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
