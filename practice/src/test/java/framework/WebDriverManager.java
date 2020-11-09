package framework;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

	public static void loadWebDrivers() {
		URL urlChrome = ClassLoader.getSystemResource("chromedriver.exe");
		URL urlGecko = ClassLoader.getSystemResource("geckodriver.exe");
		try {
			System.setProperty("webdriver.chrome.driver", Paths.get(urlChrome.toURI()).toString());
			System.setProperty("webdriver.gecko.driver", Paths.get(urlGecko.toURI()).toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}	
	}
	
	public static WebDriver getWebDriver(String webDriverType) {
		if(webDriverType == "chrome")
			return new ChromeDriver();
		if(webDriverType == "firefox")
			return new FirefoxDriver();
		return new ChromeDriver();
	}

	
}
