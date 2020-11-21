package theInternet.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class ShadowDOMPage extends PageObjectBase{
	private final String urlPath = "shadowdom";
	
	public ShadowDOMPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(tagName="my-paragraph")
	List<WebElement> shadowRoots;
	
	public ShadowDOMPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public String getTopParagraphText() {
		WebElement topShadowRoot = expandRootElement(shadowRoots.get(0));
		return topShadowRoot.findElement(By.tagName("p")).getText();
	}
	
	public WebElement expandRootElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (WebElement)js.executeScript("return arguments[0].shadowRoot", element);
	}
	
}
