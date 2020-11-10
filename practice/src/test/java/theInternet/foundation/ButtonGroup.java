package theInternet.foundation;

import java.util.List;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class ButtonGroup extends WebElementControlExtension{
	private List<WebElement> buttons;

	public ButtonGroup(List<WebElement> buttons) {
		// Ughh there isn't a single element being extended?
		// Maybe this shouldn't be a subclass
		// Also whats the deal w this vs checkboxGroup?
		// Also, is it necessary to have a checkbox and button extension ._.
		super(null);
		this.buttons = buttons;
	}
	
	public void clickButtonWithText(String buttonText) {
		for(WebElement button: buttons) {
			if(button.getText().equals(buttonText)) {
				new Button(button).click();
			}
		}
	}
}
