package theInternet.foundation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class NotAtBottomOfPage{
	public static ExpectedCondition<Boolean> customCondition() {
	    return new ExpectedCondition<Boolean>() {
	      @Override
	      public Boolean apply(WebDriver driver) {
	        return (Boolean) ((JavascriptExecutor) driver)
	          .executeScript("return (window.innerHeight + window.scrollY) < document.body.offsetHeight;");
	      }
	    };
	  }
}
