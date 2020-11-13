package theInternet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.PageObjectBase;

public class InfiniteScrollPage extends PageObjectBase{
	private final String urlPath = "infinite_scroll";
	
	public InfiniteScrollPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	public InfiniteScrollPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	public boolean canReachBottomOverSeconds(int secondsOfScrolling) {
		long start = System.currentTimeMillis();
	    long end = start + (secondsOfScrolling * 100);
	    
	    // Make better names...
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        String script = "window.scrollTo(0, document.body.scrollHeight);";
        String script2 = "setTimeout(function(){"
        		+ "return window.innerHeight + window.scrollY >= document.body.offsetHeight"
        		+ "}, 1000);";
        
        while(System.currentTimeMillis()<end) {
            jse.executeScript(script, "");
            try {
	            WebDriverWait wait = new WebDriverWait(driver, 2);
				if((boolean) wait.until(ExpectedConditions.jsReturnsValue(script2)))
					return true;
            }catch(Throwable e) {
            	System.err.println("Error came while waiting for javascript return: "+e.getMessage());
            	return true;
            }
        }
        
		return false;
	}
}
