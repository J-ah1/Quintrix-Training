package theInternet.pages;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import framework.PageObjectBase;
import theInternet.foundation.Button;
import theInternet.foundation.ChooseFile;

public class FileUploadPage extends PageObjectBase{
	private final String urlPath = "upload";
	
	public FileUploadPage(WebDriver driver, String baseUrl) {
		super(driver, baseUrl);
	}
	
	@FindBy(id="file-upload")
	WebElement chooseFileButton;
	
	@FindBy(id="file-submit")
	WebElement submitFileButton;
	
	@FindBy(id="uploaded-files")
	WebElement uploadedFiles;
	
	public FileUploadPage navigate() {
		super.navigate(urlPath);
		return this;
	}
	
	public FileUploadPage uploadFile(String fileName) {
		new ChooseFile(chooseFileButton).chooseFile(fileName);
		new Button(submitFileButton).click();
		return this;
	}
	
	public String getUploadedFile() {
		return uploadedFiles.getText();
	}
}
