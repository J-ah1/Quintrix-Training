package framework;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	
	public WebDriverFactory() {
		// Load web drivers
		URL urlChrome = ClassLoader.getSystemResource("chromedriver.exe");
		URL urlFirefox = ClassLoader.getSystemResource("geckodriver.exe");
		
		try {
			System.setProperty("webdriver.chrome.driver", Paths.get(urlChrome.toURI()).toString());
			System.setProperty("webdriver.gecko.driver", Paths.get(urlFirefox.toURI()).toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver getWebDriver(String webDriverType) {
		// Return a webdriver based on parameter
		if(webDriverType == "CHROME")
			return new ChromeDriver();
		if(webDriverType == "FIREFOX")
			return new FirefoxDriver();
		return new ChromeDriver();
	}
}
