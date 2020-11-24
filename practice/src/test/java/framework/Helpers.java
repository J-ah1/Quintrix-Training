package framework;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class Helpers {

	public static File getFileFromSystemResource(String fileName) {
		try {
			URL resourceURL = ClassLoader.getSystemResource(fileName);
			return new File(resourceURL.toURI());
		}catch(URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
