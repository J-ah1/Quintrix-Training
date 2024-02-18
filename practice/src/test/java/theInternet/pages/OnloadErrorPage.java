package theInternet.pages;

import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import framework.PageObjectBase;

public class OnloadErrorPage extends PageObjectBase{
	private final String urlPath = "javascript_error";
	
	public OnloadErrorPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public OnloadErrorPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	// There's got to be a way to detect specific errors?
	public boolean isSevereErrorPresent() {
		LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
		for(LogEntry logEntry: logEntries) {
			if(logEntry.getLevel().equals(Level.SEVERE))
				return true;
		}
		return false;
	}
	
	
}
