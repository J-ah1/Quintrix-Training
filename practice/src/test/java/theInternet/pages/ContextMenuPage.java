package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.AlertExtension;

public class ContextMenuPage extends PageObjectBase{
	private final String urlPath = "context_menu";
	
	public ContextMenuPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@FindBy(id="hot-spot")
	WebElement contextMenuBox;
	
	public ContextMenuPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public ContextMenuPage rightClickContextMenuBox() {
		Actions actions = new Actions(driver);
		actions.contextClick(contextMenuBox).perform();
		return this;
	}
	
	public boolean isAlertPresent() {
		return new AlertExtension(driver).isAlertPresent();
	}
}
