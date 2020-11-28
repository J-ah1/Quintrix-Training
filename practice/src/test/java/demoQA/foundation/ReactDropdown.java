package demoQA.foundation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ReactDropdown {
	private WebElement mappedElement;
	private WebDriver driver;

	public ReactDropdown(WebElement mappedElement, WebDriver driver) {
		this.mappedElement = mappedElement;
		this.driver = driver;
	}

	//use this one
	public void selectByText(String value) {
		expand();
		WebElement inputElement = mappedElement.findElement(By.tagName("input"));
		inputElement.sendKeys(value);
		inputElement.sendKeys(Keys.TAB);
	}
	
	//not working reliably
	public void select(String value) {	
		expand();
		List<WebElement> options = getOptions();
		
		for(WebElement option : options) {
			if(option.getText().equals(value)) {
				option.click();
				
				waitForCollapsed();
			}
		}	
		
		throw new RuntimeException(value + " is not a valid selection.");
	}

	private void waitForCollapsed() {
		// not implemented		
	}

	private List<WebElement> getOptions() {
		WebElement menuElement = mappedElement.findElement(By.cssSelector("div[class$='css-2613qy-menu']"));
		List<WebElement> options = menuElement.findElements(By.cssSelector("div[class$='-option']"));
		
		return options;
	}

	private void expand() {
		WebElement expandIcon = mappedElement.findElement(By.cssSelector("div[class$='css-tlfecz-indicatorContainer']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", expandIcon);
		expandIcon.click();
		waitForExpanded();
	}

	private void waitForExpanded() {
		// not implemented
	}	
}