package framework;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;
public class TestBase {
	protected WebDriver webDriver;
	protected String urlProtocol;
	protected String urlDomain;
	protected String baseUrl;
	protected WebDriverManager webDriverManager;
	
	@BeforeTest
	protected void beforeTest() {
		loadConfigurations();
		
	}
	
	@AfterTest
	protected void afterTest() {
		this.webDriver.quit();
	}
	
	protected void setupWebDriver() {
		// 11/2/23 BELOW, seems to cause a "json/cant determine type from: i" error?
		//this.webDriver = webDriverManager.loadWebDriver().getWebDriver();
		this.webDriver = new ChromeDriver();
	}
	
	private WebDriverManager getWebDriverManager(String webDriverType) {
		return WebDriverFactory.getManager(webDriverType);
	}
	
	private void loadConfigurations() {
		HashMap<String, String> configs = null;

		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}

		this.urlProtocol = configs.get(ConfigurationParameters.UrlProtocol);
		this.urlDomain = configs.get(ConfigurationParameters.UrlDomain);
		this.baseUrl = urlProtocol + "://" + urlDomain + "/";
		//Is there a better place for this?
		this.webDriverManager = getWebDriverManager(configs.get(ConfigurationParameters.BrowserType));
		setupWebDriver();
	}
	
	
}
