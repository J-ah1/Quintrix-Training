package theInternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.AlertExtension;
import theInternet.foundation.Button;

public class JavaScriptAlertPage extends PageObjectBase{
	private final static String URL_PATH = "javascript_alerts";
	
	public JavaScriptAlertPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl, URL_PATH);
	}
	
	@FindBy(id="result")
	WebElement result;
	
	@FindBy(tagName="button")
	List<WebElement> buttons;
	
	public JavaScriptAlertPage navigate() {
		super.navigate();
		return this;
	}

	public JavaScriptAlertPage clickButton(String buttonText) {
		new Button(buttons, buttonText).click();
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
