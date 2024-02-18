package theInternet.foundation;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.ILoadPages;

public class TheInternetPageLoader implements ILoadPages{
	
	private WebDriver driver;
	private int pageLoadTimeoutMilliseconds;
	
	public TheInternetPageLoader(WebDriver driver, int pageLoadTimeoutMilliseconds) {
		this.driver = driver;
		this.pageLoadTimeoutMilliseconds = pageLoadTimeoutMilliseconds;
	}
	
	public void doPageTransition(WebElement clickThisElement) {
		long beforePageSignature = getCurrentPageSignature();
	
		clickThisElement.click();
		
		Instant startTime = Instant.now();
		
		do {
			
			Duration elapsedTime = Duration.between(startTime, Instant.now());
			
			if(elapsedTime.getSeconds() * 1000 > pageLoadTimeoutMilliseconds) {
				throw new RuntimeException("Page transition did not occur within timeout of " + pageLoadTimeoutMilliseconds);
			}
			
		}while(beforePageSignature == getCurrentPageSignature()
				|| getCurrentPageSignature() == 0
				|| !isPageLoaded());
	}

	private boolean isPageLoaded() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (boolean) js.executeScript("return $ !== undefined && $.active === 0");
	}
	
	private long getCurrentPageSignature() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return (long) js.executeScript("return performance.timing.loadEventEnd");
	}
	
	
}
