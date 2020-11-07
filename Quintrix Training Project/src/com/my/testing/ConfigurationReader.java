package com.my.testing;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class ConfigurationReader {

	public HashMap<String, String> getPropertiesFromResourceFile(String fileName) throws IOException {

		InputStream inputStream = null;
		Properties properties = new Properties();

		try {
			inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

			if(inputStream == null) {
				throw new FileNotFoundException(fileName + " was not found in the Resources folder.");
			}

			properties.load(inputStream);
		}
		finally {
			inputStream.close();
		}

		HashMap<String, String> propertyValuesByKey = new HashMap<String, String>();

		for (String key : properties.stringPropertyNames()) {
			String value = properties.getProperty(key);
			propertyValuesByKey.put(key, value);
		}

		return propertyValuesByKey;
	}
}
