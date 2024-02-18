package theInternet.pages;

import java.time.Duration;
import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class ExitIntentPage extends PageObjectBase{
	private final String urlPath = "exit_intent";
	
	public ExitIntentPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(tagName="h3")
	WebElement welcomeTitle;

	@FindBy(id="ouibounce-modal")
	WebElement modalWindow;
	
	public ExitIntentPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	public ExitIntentPage moveMouseOutsideViewPort() {
		try {
			Actions actions = new Actions(driver);
			actions.click().moveToElement(welcomeTitle).perform();
			Robot robot = new Robot();
			robot.mouseMove(0,0);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		return this;
	}

	public ExitIntentPage checkVisibilityOfModalWindow() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(modalWindow));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}
}
