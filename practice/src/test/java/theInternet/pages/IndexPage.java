package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.PageObjectBase;

public class IndexPage extends PageObjectBase{
	
	public IndexPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public IndexPage navigate() {
		super.navigate();
		return this;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}

	public void goToSlowResourcesPage() {
		clickLinkWithText("Slow Resources");
		// Should return slow resources page
	}
	
	private void clickLinkWithText(String text) {
		WebElement linkWithText = driver.findElement(By.linkText(text));
		
		// Still need to figure out IAction...
		//pageLoader.doPageTransition(() -> linkWithText.click());
		//...so I did the following instead...
		pageLoader.doPageTransition(linkWithText);
		
	}
}
