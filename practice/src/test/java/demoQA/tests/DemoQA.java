package demoQA.tests;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;

import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import demoQA.foundation.CSVReader;
import demoQA.foundation.DemoQATestBase;
import demoQA.foundation.PracticeFormPage;
import demoQA.foundation.XMLReader;
import framework.Helpers;

public class DemoQA extends DemoQATestBase{

	/*
	 * Test 1 (3 students) - Get the data from a CSV file. Ideally you will read the data into value objects (POJOs). src/test/java/dataDriven/CsvDriven.java
Test 2 (3 students) - Take a collection of Data Provider Objects passed into the test. src/test/java/dataDriven/ParameterDriven.java
Test 3 (3 students) - Get the data from a XML file. Ideally you will read the data into value objects (POJOs). src/test/java/dataDriven/XmlDriven.java
Test 4 (3 students) - Get the data from a database. Use the DB Query to insert the data. src/test/java/dataDriven/DbDriven.java
	 */
	
	@Test
	public void getDataFromCSV() {
		List<List<String>> returnList = new CSVReader("Students.csv").readFileAs2DList();
		List<Map<String, String>> studentsData = Helpers.convert2DListToKeyValueMaps(returnList);
		boolean successfulSubmits = true;
		for(Map<String, String> studentData : studentsData) {
			if(!(new PracticeFormPage(webDriver, baseUrl)
					.navigate()
					.sendTextToFirstNameInput(studentData.get("lastFirst").split(",")[1])
					.sendTextToLastNameInput(studentData.get("lastFirst").split(",")[0])
					.selectGenderWithText(studentData.get("gender"))
					.sendTextToUserNumberInput(studentData.get("mobile"))
					.submitForm()
					.isModalActive()))
				successfulSubmits = false;
		}
		
		Assert.assertTrue(successfulSubmits);
	}
	
	
	@DataProvider(name = "studentData")
    public Object[][] dataProviderMethod() {
		Object[][] returnObject = new Object[1][13];
		returnObject[0][0] = "Brian";
		returnObject[0][1] = "Johnson";
		returnObject[0][2] = "04/04/1970";
		returnObject[0][3] = "brianjohnson@test.com";
		returnObject[0][4] = "114";
		returnObject[0][5] = "First Ave";
		returnObject[0][6] = "Uttar Pradesh";
		returnObject[0][7] = "Lucknow";
		returnObject[0][8] = "10005";
		returnObject[0][9] = "281-253-7321";
		returnObject[0][10] = "Male";
		returnObject[0][11] = "Maths;Economics;Arts";
		returnObject[0][12] = "";
        return returnObject;
    }
	
	@Test(dataProvider = "studentData")
	public void getDataFromDPO(
			String firstName,
			String lastName,
			String dob,
			String email,
			String houseNumber,
			String street,
			String state,
			String city,
			String postalCode,
			String phoneNumber,
			String gender,
			String subjects,
			String hobby) {
		
		boolean successfulSubmit = new PracticeFormPage(webDriver, baseUrl)
			.navigate()
			.sendTextToFirstNameInput(firstName)
			.sendTextToLastNameInput(lastName)
			.sendTextToUserEmailInput(email)
			.selectGenderWithText(gender)
			.sendTextToUserNumberInput(phoneNumber)
			.sendTextToDateOfBirthInput(dob)
			.sendTextToCurrentAddressInput(houseNumber + " " + street)
			.submitForm()
			.isModalActive();
		
		Assert.assertTrue(successfulSubmit);
		
	}
	
	@Test
	public void getDataFromXML() {
		XMLReader studentXML = new XMLReader("Students.xml");
		boolean successfulSubmits = true;
		NodeList studentNodes = studentXML.getElementsInFileWithTag("person");
		for(int i = 0; i < studentNodes.getLength(); i++) {
			Node studentNode = studentNodes.item(i);
			Element studentNodeAsElement  = (Element) studentNode;
			if(!(new PracticeFormPage(webDriver, baseUrl)
					.navigate()
					.sendTextToFirstNameInput(studentNodeAsElement.getElementsByTagName("f_name").item(0).getTextContent())
					.sendTextToLastNameInput(studentNodeAsElement.getElementsByTagName("l_name").item(0).getTextContent())
					.selectGenderWithText(studentNodeAsElement.getElementsByTagName("gender").item(0).getTextContent())
					.sendTextToUserNumberInput(studentNodeAsElement.getElementsByTagName("contact").item(0).getTextContent())
					.submitForm()
					.isModalActive()))
				successfulSubmits = false;			
		}
		Assert.assertTrue(successfulSubmits);
	}
	
	@Test
	public void getDataFromDB() {
		String dbAddress = "jdbc:mysql://localhost:3306/world_x";
		String dbUsername = "root";
		String dbPassword = "";
		Connection connToDB = null;
		PreparedStatement prepStatement = null;
		ResultSet results = null;
		boolean successfulSubmits = true;
		try {
			connToDB = DriverManager.getConnection(dbAddress , dbUsername , dbPassword);
			String sqlQuery = "SELECT * FROM students;";
			prepStatement = connToDB.prepareStatement(sqlQuery);
			prepStatement.execute();
			results = prepStatement.getResultSet();
			
			while(results.next()) {
				if(!(new PracticeFormPage(webDriver, baseUrl)
						.navigate()
						.sendTextToFirstNameInput(results.getString("first_name"))
						.sendTextToLastNameInput(results.getString("last_name"))
						.selectGenderWithText(results.getInt("isMale") == 1 ? "Male" : "Female")
						.sendTextToUserNumberInput(results.getString("phone"))
						.submitForm()
						.isModalActive()))
					successfulSubmits = false;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			successfulSubmits = false;
		}finally {
			if(connToDB != null) {
				try {
					connToDB.close();
				  } catch (SQLException e) {
					  e.printStackTrace();
				  }
				connToDB = null;
			}
			if(prepStatement != null) {
				try {
					prepStatement.close();
				  } catch (SQLException e) {
					  e.printStackTrace();
				  }
				prepStatement = null;
			}
			if(results != null) {
				try {
					  results.close();
				  } catch (SQLException e) {
					  e.printStackTrace();
				  }
				  results = null;
			}
		}
		
		Assert.assertTrue(successfulSubmits);
		
	}
}
