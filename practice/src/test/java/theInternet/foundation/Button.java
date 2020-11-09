package theInternet.foundation;

import java.util.List;

import org.openqa.selenium.WebElement;

public class Button {
	WebElement buttonElement;
	
	public Button(WebElement buttonElement) {
		this.buttonElement = buttonElement;
	}
	
	public Button(List<WebElement> buttons, String buttonText) {
		for(WebElement button: buttons) {
			if(button.getText().equals(buttonText)) {
				this.buttonElement = button;
			}
		}
	}
	
	public void click() {
		this.buttonElement.click();
	}
	
}
