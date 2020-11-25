package demoQA.foundation;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import framework.Helpers;

public class XMLReader {

	private File xmlFile;
	private Document fileAsDoc;
	
	public XMLReader(String fileName) {
		this.xmlFile = Helpers.getFileFromSystemResource(fileName);
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();  
			DocumentBuilder db = dbf.newDocumentBuilder();  
			this.fileAsDoc = db.parse(this.xmlFile);  
			this.fileAsDoc.getDocumentElement().normalize();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		NodeList nodeList = this.fileAsDoc.getElementsByTagName("fall");  
		for (int itr = 0; itr < nodeList.getLength(); itr++){  
		Node node = nodeList.item(itr);  
		System.out.println("\nNode Name :" + node.getNodeName());
		}
		
	}

}
