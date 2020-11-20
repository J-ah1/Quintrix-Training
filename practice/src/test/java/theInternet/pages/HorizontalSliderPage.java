package theInternet.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.Slider;

public class HorizontalSliderPage extends PageObjectBase{
	private final String urlPath = "horizontal_slider";
	
	public HorizontalSliderPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}

	@FindBy(tagName="input")
	WebElement slider;
	
	public HorizontalSliderPage navigate() {
		super.navigate(urlPath);
		return this;
	}

	public HorizontalSliderPage sendRightToSlider(int numberTimesPressRight) {
		new Slider(slider).sendRightToSlider(numberTimesPressRight);
		return this;
	}
	
	public HorizontalSliderPage sendLeftToSlider(int numberTimesPressLeft) {
		new Slider(slider).sendLeftToSlider(numberTimesPressLeft);
		return this;
	}

	public Double getSliderValue() {
		return new Slider(slider).getSliderValue();
	}
}
