package theInternet.foundation;

import java.util.List;

import org.openqa.selenium.WebElement;

import framework.WebElementControlExtension;

public class LinkGroup extends WebElementControlExtension{
	private List<WebElement> links;

	public LinkGroup(List<WebElement> links) {
		super(null);
		this.links = links;
	}
	
	public boolean isLinkPresentByText(String linkText) {
		for(WebElement link: links) {
			if(link.getText().equals(linkText))
				return true;
		}
		return false;
	}
}
