package theInternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.Div;
import theInternet.foundation.DivGroup;

public class HoversPage extends PageObjectBase{
	private final String urlPath = "dropdown";
	
	public HoversPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(className="figure")
	List<WebElement> figures;
	
	public HoversPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public String getUserName(int profileIndex) {
		Div figure = new DivGroup(figures).getByIndex(profileIndex);
		// Create a DivGroup (a list of divs)
		// Will have a findByIndex()
		// Find corresponding Div (make webElementExtension) (store in var)
		// Will have a getByTag()
		// Find the img
		// Do a hover Action
		// Use Div to find the h5 and return
	}

}
