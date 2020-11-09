package framework;

import org.openqa.selenium.WebDriver;

public class WebDriverFactory {
	
	public static void loadWebDrivers() {
		WebDriverManager.loadWebDrivers();
	}
	
	public static WebDriver getWebDriver(String webDriverType) {
		return WebDriverManager.getWebDriver(webDriverType);
	}
}
