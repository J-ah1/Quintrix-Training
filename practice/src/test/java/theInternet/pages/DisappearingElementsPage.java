package theInternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import framework.WebElementGroup;

public class DisappearingElementsPage extends PageObjectBase{
	private final String urlPath = "disappearing_elements";
	
	public DisappearingElementsPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(tagName="a")
	List<WebElement> links;

	public DisappearingElementsPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	private boolean isLinkPresentByText(String linkText) {
		return new WebElementGroup(links).isThereElementWithText(linkText);
	}

	public boolean gallerySometimesAppears() {
		int attempts = 30;
		while(attempts > 0) {
			if(isLinkPresentByText("Gallery"))
				return true;
			driver.navigate().refresh();
			attempts--;
		}
		return false;
	}

	public boolean gallerySometimesDoesNotAppear() {
		int attempts = 30;
		while(attempts > 0) {
			if(!isLinkPresentByText("Gallery"))
				return true;
			driver.navigate().refresh();
			attempts--;
		}
		return false;
	}
	
}
