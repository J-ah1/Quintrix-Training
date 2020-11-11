package theInternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import framework.WebElementGroup;
import theInternet.foundation.AlertExtension;
import theInternet.foundation.Button;

public class JavaScriptAlertPage extends PageObjectBase{
	private final String urlPath = "javascript_alerts";
	
	public JavaScriptAlertPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="result")
	WebElement result;
	
	@FindBy(tagName="button")
	List<WebElement> buttons;
	
	public JavaScriptAlertPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	public JavaScriptAlertPage clickButton(String buttonText) {
		new Button(new WebElementGroup(buttons).getElementWithText(buttonText)).click();
		return this;
	}
	
	public JavaScriptAlertPage typeTextToPrompt(String text) {
		new AlertExtension(driver).typeTextToPrompt(text).accept();
		return this;
	}
	
	public String getResultText() {
		return result.getText();
	}
	
}
