package theInternet.pages;

import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;
import theInternet.foundation.NotAtBottomOfPage;

public class InfiniteScrollPage extends PageObjectBase{
	private final String urlPath = "infinite_scroll";
	
	public InfiniteScrollPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public InfiniteScrollPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	public boolean canReachBottomOverSeconds(int secondsOfScrolling, int checkIntervalInSeconds) {
		long start = System.currentTimeMillis();
	    long end = start + (secondsOfScrolling * 1000);
	    
        JavascriptExecutor js = (JavascriptExecutor) driver;
        String scrollScript = "window.scrollTo(0, document.body.scrollHeight);";

        while(System.currentTimeMillis()<end) {
            js.executeScript(scrollScript, "");
            try {
            	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(checkIntervalInSeconds));
            	wait.until(NotAtBottomOfPage.customCondition());
            }catch(Throwable e) {
            	System.err.println("Error came while waiting for javascript return: "+e.getMessage());
            	return true;
            }
        }
        
		return false;
	}
}
