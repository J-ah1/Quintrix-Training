package theInternet.foundation;

import org.openqa.selenium.WebElement;

public class Checkbox {
	WebElement checkboxElement;
	
	public Checkbox(WebElement checkboxElement) {
		this.checkboxElement = checkboxElement;
	}

	public Checkbox setState(boolean state) {
		if(getState() != state)
			checkboxElement.click();
		return this;
	}

	public Boolean getState() {
		if(checkboxElement.getAttribute("checked") != null)
			return true;
		return false;
	}
}
