package theInternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class FramesPage extends PageObjectBase{
	
	private final String urlPath = "nested_frames";
	
	public FramesPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public FramesPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public String getTopMiddleFrameText() {
		WebElement topFrame = driver.findElement(By.cssSelector("[src=\"/frame_top\"]"));
		WebDriver topFramesDriver = driver.switchTo().frame(topFrame);
		WebElement topMiddleFrame = driver.findElement(By.cssSelector("[src=\"/frame_middle\"]"));
		WebDriver topMiddleFrameDriver = topFramesDriver.switchTo().frame(topMiddleFrame);
		return topMiddleFrameDriver.findElement(By.tagName("body")).getText();
	}

}
