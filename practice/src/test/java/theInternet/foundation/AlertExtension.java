package theInternet.foundation;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertExtension {
	private WebDriver driver;
	Alert alert;
	
	public AlertExtension(WebDriver driver) {
		this.driver = driver;
		findAlert();
	}
	
	private void findAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.alertIsPresent());
			alert = driver.switchTo().alert();
		}catch(Throwable e){
			System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}
	}
	
	public AlertExtension typeTextToPrompt(String text) {
		alert.sendKeys(text);
		return this;
	}
	
	public void accept() {
		alert.accept();
	}

}
