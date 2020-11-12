package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.AlertExtension;

public class JQueryUIMenusPage extends PageObjectBase{
	private final String urlPath = "jqueryui/menu";
	
	public JQueryUIMenusPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@FindBy(id="menu")
	WebElement menu;
	
	public JQueryUIMenusPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public boolean isMenuItemPresent(String desiredMenuItemText, String[] menuTextTraversalPath) {
		return new MenuGroup(driver, menu)
				.traverseMenuByText(menuTextTraversalPath)
				.isMenuItemPresentByText(desiredMenuItemText);
	}
	
	
	
	public boolean isMenuItemPresent(String desiredMenuItemText) {
		// How do we validate that the menu item is there?
		return false;
	}
}
