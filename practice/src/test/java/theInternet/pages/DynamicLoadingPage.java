package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;
import theInternet.foundation.Button;

public class DynamicLoadingPage extends PageObjectBase{
	private final String urlPath = "dynamic_loading/1";
	
	public DynamicLoadingPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(xpath="//*[@id='start']/button")
	WebElement startButton;
	
	@FindBy(id="finish")
	WebElement finishDiv;
	
	public DynamicLoadingPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public DynamicLoadingPage clickButton() {
		new Button(startButton).click();
		return this;
	}
	
	public String getLoadedText() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(finishDiv));
		return finishDiv.getText();
	}
	

}
