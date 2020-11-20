package theInternet.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;

public class WYSIWYGEditorPage extends PageObjectBase{
	private final String urlPath = "tinymce";
	
	public WYSIWYGEditorPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="tinymce")
	WebElement tinymce;
	
	public WYSIWYGEditorPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public WYSIWYGEditorPage appendToEditorText(String textToAppend) {
		setEditorText(getEditorText() + textToAppend);
		return this;
	}
	
	public WYSIWYGEditorPage setEditorText(String textToSetTo) {
		String script = "tinymce.activeEditor.setContent(arguments[0])";
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		js.executeScript(script, textToSetTo);
		return this;
	}
	
	public String getEditorText() {
		String script = "return tinymce.activeEditor.getContent()";
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		String editorText = (String)js.executeScript(script);
		editorText = editorText.replace("<p>", "");
		editorText = editorText.replace("</p>", "");
		return editorText;
	}
	
	public String getEditorTextWithSurroundingTags() {
		String script = "return tinymce.activeEditor.getContent()";
		JavascriptExecutor  js = (JavascriptExecutor) driver;
		return (String)js.executeScript(script);
	}
}
