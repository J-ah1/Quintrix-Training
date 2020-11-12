package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.WebElementGroup;
import theInternet.foundation.LabellessElement;

public class MenuGroup extends WebElementGroup{
	private WebElement menu;
	private WebDriver driver;
	
	public MenuGroup(WebDriver driver, WebElement menu) {
		super(menu.findElements(By.xpath("*")));
		this.driver = driver;
		this.menu = menu;
	}
	
	public MenuGroup traverseMenuByText(String[] menuTextTraversalPath) {
		MenuGroup currentMenu = this;
		for(String menuItemText : menuTextTraversalPath) {
			currentMenu = currentMenu.traverseMenuByText(menuItemText);
		}
		return currentMenu;
	}
	
	public MenuGroup traverseMenuByText(String menuItemText) {
		Actions actions = new Actions(driver);
		
		for(WebElement menuItem: this.webElements) {
			String menuItemLabel = new LabellessElement(driver, menuItem).getLabelFromChildren();
			if(menuItemLabel.equals(menuItemText)) {
				actions.moveToElement(menuItem).click().perform();
				return findSubMenu(menuItem);
			}
		}
		
		return this;
	}

	public boolean isMenuItemPresentByText(String desiredMenuItem) {
		for(WebElement menuItem: this.webElements) {
			String menuItemLabel = new LabellessElement(driver, menuItem).getLabelFromChildren();
			if(menuItemLabel.equals(desiredMenuItem))
				return true;
		}
		return false;
	}

	private MenuGroup findSubMenu(WebElement parentMenuItem) {
		return new MenuGroup(driver, parentMenuItem.findElement(By.xpath(".//ul")));
	}
	
	
}
