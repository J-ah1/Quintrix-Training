package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.WebElementGroup;

public class MenuGroup extends WebElementGroup{
	private WebElement menu;
	private WebDriver driver;
	
	public MenuGroup(WebDriver driver, WebElement menu) {
		super(menu.findElements(By.cssSelector("*")));
		this.driver = driver;
		this.menu = menu;
	}
	
	public MenuGroup traverseMenuByText(String[] menuTextTraversalPath) {
		for(String menuItemText : menuTextTraversalPath) {
			traverseMenuByText(menuItemText);
		}
		return this;
	}
	
	public MenuGroup traverseMenuByText(String menuItemText) {
		Actions actions = new Actions(driver);
		//Now how do we get the menu item via text?
		//Oh no...
		//Seems like this is similar situation to checkBoxGrouup
		//Have to use jsexecutor...
		//actions.moveToElement(webElements.get(index))
		return this;
	}

	public boolean isMenuItemPresentByText(String desiredMenuItem) {
		
		return false;
	}

	
	
}
