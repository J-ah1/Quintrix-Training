package framework;


public class WebDriverFactory {
	
	public static WebDriverManager getManager(String webDriverType) {
		if(webDriverType == "chrome")
			return new ChromeDriverManager();
		if(webDriverType == "firefox")
			return new FirefoxDriverManager();
		return new ChromeDriverManager();
	}

}
