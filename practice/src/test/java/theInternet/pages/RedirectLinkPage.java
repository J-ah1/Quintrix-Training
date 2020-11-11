package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.Link;

public class RedirectLinkPage extends PageObjectBase{
	private final String urlPath = "redirector";

	public RedirectLinkPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@FindBy(id="redirect")
	WebElement redirectLink;
	
	public RedirectLinkPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public RedirectLinkPage clickRedirectLink() {
		// Another control extension here?
		new Link(redirectLink).click();
		return this;
	}
	
	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
}
