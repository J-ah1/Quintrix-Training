package theInternet.foundation;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class ChooseFile extends WebElementControlExtension{

	public ChooseFile(WebElement extendedElement) {
		super(extendedElement);
	}
	
	public void chooseFile(String fileName) {
		URL file = ClassLoader.getSystemResource(fileName);
		try {
			String filePath = Paths.get(file.toURI()).toString();
			extendedElement.sendKeys(filePath);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

}
