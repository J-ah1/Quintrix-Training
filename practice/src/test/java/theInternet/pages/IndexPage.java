package theInternet.pages;

import org.openqa.selenium.WebDriver;

import theInternet.foundation.PageObjectBase;

public class IndexPage extends PageObjectBase{
	
	public IndexPage(WebDriver driver, String url) {
		super(driver, url);
	}
	
	public IndexPage navigate() {
		super.navigate("");
		return this;
	}
	
	public String getTitle() {
		return driver.getTitle();
	}
}
