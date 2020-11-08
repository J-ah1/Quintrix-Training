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
	protected WebDriverFactory webDriverFactory;
	
	@BeforeTest
	protected void beforeTest() {
		LoadConfigurations();
	}
	
	@AfterTest
	protected void afterTest() {
		this.webDriver.quit();
	}
	
	
	private void LoadConfigurations() {
		// Set factory system params
		webDriverFactory = new WebDriverFactory();
		// Get a webdriver
		this.webDriver = webDriverFactory.getWebDriver("CHROME");

		HashMap<String, String> configs = null;

		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}

		this.baseUrl = configs.get(ConfigurationParameters.Url);
	}
	
	
}
