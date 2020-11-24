package framework;


import org.openqa.selenium.WebDriver;

public interface WebDriverManager {

	public WebDriverManager loadWebDriver();
	
	public WebDriver getWebDriver();

	
}
