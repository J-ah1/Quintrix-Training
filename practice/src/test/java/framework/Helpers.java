package framework;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static List<Map<String, String>> convert2DListToKeyValueMaps(List<List<String>> list) {
		List<Map<String, String>> returnList = new ArrayList<Map<String, String>>();
		List<String> keys = new ArrayList<String>();
		for(String key : list.get(0)) {
			keys.add(key);
		}
		Map<String, String> currMap = new HashMap<String, String>();
		for(int i = 1; i < list.size(); i++) {
			for(int kvIndex = 0; kvIndex < list.get(i).size(); kvIndex++) {
				currMap.put(keys.get(kvIndex), list.get(i).get(kvIndex));
			}
			returnList.add(currMap);
			currMap = new HashMap<String, String>();
		}
		return returnList;
	}
	
}
