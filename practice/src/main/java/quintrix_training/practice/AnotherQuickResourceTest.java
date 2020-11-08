package quintrix_training.practice;

import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnotherQuickResourceTest {
  protected ChromeDriver webDriver;
  protected String baseUrl;

@Test
  public void f() {
	  URL url = ClassLoader.getSystemResource("chromedriver.exe");
	  System.setProperty("webdriver.chrome.driver", url.getFile());
	  webDriver = new ChromeDriver();
	  
	  baseUrl = "http://the-internet.herokuapp.com/";
	  //Act
	  webDriver.navigate().to(baseUrl);
	  String currentURL = webDriver.getCurrentUrl();
	  
	  //Assert
	  Assert.assertEquals(currentURL, baseUrl);
	  this.webDriver.quit();
		
  }
}

