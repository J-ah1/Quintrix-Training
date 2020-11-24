package framework;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirefoxDriverManager implements WebDriverManager{

	@Override
	public FirefoxDriverManager loadWebDriver() {
		URL urlGecko = ClassLoader.getSystemResource("geckodriver.exe");
		try {
			System.setProperty("webdriver.gecko.driver", Paths.get(urlGecko.toURI()).toString());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return this;
	}

	@Override
	public WebDriver getWebDriver() {
		return new ChromeDriver();
	}
	
}
