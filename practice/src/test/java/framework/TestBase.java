package framework;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	protected WebDriver webDriver;
	protected String baseUrl;
	
	@BeforeTest
	protected void beforeTest() {
		loadConfigurations();
		//Is there a better place for this?
		loadWebDrivers();
		// Will change to enum?
		setWebDriver("CHROME");
	}
	
	@AfterTest
	protected void afterTest() {
		this.webDriver.quit();
	}
	
	protected void setWebDriver(String webBrowserType) {
		this.webDriver = WebDriverFactory.getWebDriver(webBrowserType);
	}
	
	private void loadWebDrivers() {
		WebDriverFactory.loadWebDrivers();
	}
	
	private void loadConfigurations() {
		HashMap<String, String> configs = null;

		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}

		this.baseUrl = configs.get(ConfigurationParameters.Url);
	}
	
	
}
