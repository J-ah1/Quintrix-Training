package demoQA.tests;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import demoQA.foundation.CSVReader;
import demoQA.foundation.DemoQATestBase;
import demoQA.foundation.PracticeFormPage;
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
		List<Map<String, String>> studentData = Helpers.convert2DListToKeyValueMaps(returnList);
		new PracticeFormPage(webDriver, baseUrl)
			.navigate();
	}
	
	@Test
	public void getDataFromDPO() {
		
	}
	
	@Test
	public void getDataFromXML() {
		
	}
	
	@Test
	public void getDataFromDB() {
		String dbAddress = "jdbc:mysql://localhost:3306/sakila";
		String dbUsername = "root";
		String dbPassword = "fillThisIn";
		Connection connToDB = null;
		PreparedStatement prepStatement = null;
		ResultSet results = null;
		try {
			connToDB = DriverManager.getConnection(dbAddress , dbUsername , dbPassword);
			String sqlQuery = "";
			prepStatement = connToDB.prepareStatement(sqlQuery);
			prepStatement.execute();
			results = prepStatement.getResultSet();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
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
	}
}
