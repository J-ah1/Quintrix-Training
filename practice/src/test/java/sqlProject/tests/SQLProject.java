package sqlProject.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.sql.Types;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// Will probably need a test base for SQL tests
// Although, doesn't line up with "TestBase" class, so will probably need to...
// ...refactor "TestBase" class.
// (Similar situation to Regress)

public class SQLProject{
	Connection connToDB;
	String dbAddress;
	String dbUsername;
	String dbPassword;
	
  @Test
  public void query2() {
	  Statement statement = null;
	  ResultSet results = null;

	  try {
		  String querySelect = "SELECT title "
			  		+ "FROM film "
			  		+ "WHERE title LIKE \"%airplane%\";";
		  statement = connToDB.createStatement();

		  if (statement.execute(querySelect)) {
			  results = statement.getResultSet();
		  }

		  while (results.next()) {
			  System.out.println(results.getString(1));
		  }
		  
	  }catch (Exception exc) {
		  exc.printStackTrace();
	  }finally {
		  if (results != null) {
			  try {
				  results.close();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
			  results = null;
		  }

		  if (statement != null) {
			  try {
				  statement.close();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
			  statement = null;
		  }
	  }
  }

  @Test
  public void query7() {
	  Statement statement = null;
	  ResultSet results = null;

	  try {
		  String querySelect = "SELECT inventory_id "
			  		+ "FROM inventory "
			  		+ "INNER JOIN film "
			  		+ "USING (film_id) "
			  		+ "WHERE film.title = \"Alien Center\" "
			  		+ "AND store_id = 2;";
		  statement = connToDB.createStatement();

		  if (statement.execute(querySelect)) {
			  results = statement.getResultSet();
		  }

		  while (results.next()) {
			  System.out.println(results.getString(1));
		  }
		  
	  }catch (Exception exc) {
		  exc.printStackTrace();
	  }finally {
		  if (results != null) {
			  try {
				  results.close();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
			  results = null;
		  }

		  if (statement != null) {
			  try {
				  statement.close();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
			  statement = null;
		  }
	  }
  }
  
  @Test
  public void query8() {

	  try {
		  connToDB.setAutoCommit(false);
		  
	      String queryInsertStaff = "INSERT INTO staff VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
	      String queryInsertStore = "INSERT INTO store VALUES (?, ?, ?, ?);";

	      PreparedStatement prepStatement1 = connToDB.prepareStatement(queryInsertStaff);
	      prepStatement1.setInt(1, 3);
	      prepStatement1.setString(2, "TestFirst");
	      prepStatement1.setString(3, "TestLast");
	      prepStatement1.setInt(4, 5);
	      prepStatement1.setNull(5, Types.NULL);
	      prepStatement1.setString(6, "Test@Test.com");
	      prepStatement1.setInt(7, 1);
	      prepStatement1.setInt(8, 1);
	      prepStatement1.setString(9, "TestUser");
	      prepStatement1.setNull(10, Types.NULL);
	      prepStatement1.setTimestamp(11, new Timestamp(System.currentTimeMillis()));
	      
	      prepStatement1.executeUpdate();
	      
	      PreparedStatement prepStatement2 = connToDB.prepareStatement(queryInsertStore);
	      
	      prepStatement2.setInt(1, 3);
	      prepStatement2.setInt(2, 3);
	      prepStatement2.setInt(3, 6);
	      prepStatement2.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
	      
	      prepStatement2.executeUpdate();
	      
	      connToDB.commit();
		  
	      prepStatement1.close();
	      prepStatement2.close();
	      
	  }catch (Exception exc) {
		  exc.printStackTrace();
		  if (connToDB != null) {
			  try {
				  System.err.print("Transaction is being rolled back");
				  connToDB.rollback();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
	      }
	  }
  }
  
  @Test
  public void query9() {
	  PreparedStatement prepStatement = null;
	  
	  try {
		  connToDB.setAutoCommit(false);
		  
	      String queryUpdateStore = "UPDATE store"
	      		+ "	  SET last_update = ?"
	      		+ "	  WHERE store_id = ?;";

	      prepStatement = connToDB.prepareStatement(queryUpdateStore);
	      prepStatement.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
	      prepStatement.setInt(2, 3);
	      prepStatement.executeUpdate();
		  
	      connToDB.commit();
	  }catch (Exception exc) {
		  exc.printStackTrace();
		  if (connToDB != null) {
			  try {
				  System.err.print("Transaction is being rolled back");
				  connToDB.rollback();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
	      }
	  }finally {
		if (prepStatement != null) {
			  try {
				  prepStatement.close();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
			  prepStatement = null;
		  }
	  }
	  
  }
  
  @Test
  public void query10() {
	  PreparedStatement prepStatement = null;
	  
	  try {
		  connToDB.setAutoCommit(false);
		  
	      String queryDeleteStore = "DELETE "
	      		+ "FROM store "
	      		+ "WHERE store_id = ?;";

	      prepStatement = connToDB.prepareStatement(queryDeleteStore);
	      prepStatement.setInt(1, 3);
	      prepStatement.executeUpdate();
	      
	      connToDB.commit();
	      
	  }catch (Exception exc) {
		  exc.printStackTrace();
		  if (connToDB != null) {
			  try {
				  System.err.print("Transaction is being rolled back");
				  connToDB.rollback();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
	      }
	  }finally {
		if (prepStatement != null) {
			  try {
				  prepStatement.close();
			  } catch (SQLException e) {
				  e.printStackTrace();
			  }
			  prepStatement = null;
		  }
	  }
	  
  }
  
  @BeforeTest
  public void beforeTest() throws Exception {
	  // Uncomment and set the db adress, username, and password...
	  //dbAddress = "jdbc:mysql://localhost:3306/sakila";
	  //dbUsername = "root";
	  //dbPassword = "";
	  if(dbAddress == null || dbUsername == null || dbPassword == null) {
		  throw new Exception("Must set address, username, and password");
	  }
	  // Will need to add the root, username, and password to test context
	  try {
		  connToDB = DriverManager.getConnection(dbAddress , dbUsername , dbPassword);
	  } catch (SQLException e) {
		  e.printStackTrace();
	  }
  }
  
  @AfterTest
  public void afterTest() {
	  if (connToDB != null) {
		  try {
			  connToDB.close();
		  } catch (SQLException e) {
			  e.printStackTrace();
		  }
		  connToDB = null;
	  }
  }
  
}
