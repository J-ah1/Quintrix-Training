package theInternet.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import framework.WebElementGroup;
import theInternet.foundation.Link;

public class MultipleWindowsPage extends PageObjectBase{
	private final String urlPath = "windows";

	public MultipleWindowsPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	@FindBy(tagName="a")
	List<WebElement> links;
	
	public MultipleWindowsPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public MultipleWindowsPage clickNewWindowLink() {
		new Link(new WebElementGroup(links).getElementWithText("Click Here")).click();
		return this;
	}
	
	public String getNewWindowTitle() {
		Set<String> handles = driver.getWindowHandles();
		String currentWindowHandle = driver.getWindowHandle();
		String newWindowHandle = null;
		for(String handle: handles) {
			if(!handle.equals(currentWindowHandle))
				newWindowHandle = handle;
		}
		return driver.switchTo().window(newWindowHandle).getTitle();
	}
}
