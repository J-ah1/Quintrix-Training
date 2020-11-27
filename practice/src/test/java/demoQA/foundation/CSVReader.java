package demoQA.foundation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import framework.Helpers;

public class CSVReader {

	private File csvFile;

	public CSVReader(String fileName) {
		this.csvFile = Helpers.getFileFromSystemResource(fileName);
	}
	
	public List<List<String>> readFileAs2DList() {
		List<List<String>> returnList = new ArrayList<List<String>>();
		try {
			FileReader fr = new FileReader(csvFile);
			BufferedReader br = new BufferedReader(fr);
			List<String> currList = new ArrayList<String>();
			String currString = "";
			boolean isInQuotes = false;
			int r;
			while((r = br.read()) != -1) {
				char ch = (char) r;
				if(ch == '"') {
					isInQuotes = !isInQuotes;
					continue;
				}
				if(!isInQuotes && ch == ',') {
					currList.add(currString);
					currString = "";
				}else{
					currString += ch;
				}
				
				if(ch == '\n') {
					currList.add(currString);
					currString = "";
					returnList.add(currList);
					currList = new ArrayList<String>();
					isInQuotes = false;
				}
			}
			if(currList.size() != 0)
				returnList.add(currList);
			
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return returnList;
	}
	
}
