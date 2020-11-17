package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class DragAndDropPage extends PageObjectBase{
	private final String urlPath = "drag_and_drop";
	
	public DragAndDropPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="column-a")
	WebElement leftBox;
	
	@FindBy(id="column-b")
	WebElement rightBox;
	
	public DragAndDropPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	public DragAndDropPage dragLeftBoxOntoRightBox() {
		// Insert JS workaround here
		return this;
	}

	public String getLeftBoxHeader() {
		return leftBox.findElement(By.cssSelector("header")).getText();
	}
}
