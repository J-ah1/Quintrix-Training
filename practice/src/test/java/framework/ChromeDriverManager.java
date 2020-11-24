package framework;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements WebDriverManager{

	@Override
	public ChromeDriverManager loadWebDriver() {
		URL urlChrome = ClassLoader.getSystemResource("chromedriver.exe");
		try {
			System.setProperty("webdriver.chrome.driver", Paths.get(urlChrome.toURI()).toString());
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
