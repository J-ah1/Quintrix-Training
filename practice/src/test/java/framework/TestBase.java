package framework;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
	protected ChromeDriver webDriver;
	protected String baseUrl;
	
	@BeforeTest
	protected void beforeTest() {
		LoadConfigurations();
	}
	
	@AfterTest
	protected void afterTest() {
		this.webDriver.quit();
	}
	
	
	private void LoadConfigurations() {
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Josh\\Downloads\\chromedriver_win32\\chromedriver.exe");
		URL url = ClassLoader.getSystemResource("chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", url.getFile());
		this.webDriver = new ChromeDriver();
		this.baseUrl = "http://the-internet.herokuapp.com/";
/*
		this.webDriver = new ChromeDriver();

		HashMap<String, String> configs = null;

		try {
			configs = new ConfigurationReader().getPropertiesFromResourceFile("config.properties");
		} catch (IOException e) {
			throw new RuntimeException("Config file does not exist.");
		}

		this.baseUrl = configs.get(ConfigurationParameters.Url);
*/	
	}
}
