package demoQA.foundation;

import org.openqa.selenium.WebDriver;

import framework.PageObjectBase;

public class PracticeFormPage extends PageObjectBase{

	public PracticeFormPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	public PracticeFormPage navigate() {
		super.navigate();
		return this;
	}

}
