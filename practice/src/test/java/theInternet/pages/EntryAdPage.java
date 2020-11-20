package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class EntryAdPage extends PageObjectBase{
	private final String urlPath = "entry_ad";
	
	public EntryAdPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="modal")
	WebElement ad;
	
	public EntryAdPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public EntryAdPage closeAd() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(ad));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// This could probably broken down into
		// A modal window component?
		ad.findElement(By.className("modal"))
			.findElement(By.className("modal-footer"))
			.findElement(By.tagName("p"))
			.click();
		return this;
	}
	
	
	
}
