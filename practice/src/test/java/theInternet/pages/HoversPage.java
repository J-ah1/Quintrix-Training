package theInternet.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import framework.WebElementGroup;
import theInternet.foundation.Div;

public class HoversPage extends PageObjectBase{
	private final String urlPath = "hovers";
	
	public HoversPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(className="figure")
	List<WebElement> figures;
	
	public HoversPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public String getFigureCaptionByIndex(int profileIndex) {		
		Div figure = new Div(new WebElementGroup(figures).getElementByIndex(profileIndex));
		
		WebElement imgToHover = figure.getElementByTag("img");
		Actions actions = new Actions(driver);
		actions.moveToElement(imgToHover).perform();
		
		return figure.getElementByTag("h5").getText();
	}

}
