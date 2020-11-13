package regres.tests;

import org.testng.annotations.Test;

import com.google.gson.Gson;

import framework.TestBase;
import io.restassured.http.ContentType;
import regres.objects.User;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

//As of now, we're a different Url than defined in the configs
//Also, want to make a RegresTestBase
//In general, this will get refactored; just want to create necessary tests

public class Regres extends TestBase{
  @Test
  public void firstTest() {
	  given().get("/api/users/2").then()
      .statusCode(200)
      .body("data.email", equalTo("janet.weaver@reqres.in"));
  }
  
  @Test
  public void secondTest() {
	  String messageString = "{"
	  		+ "\"email\":\"eve.holt@reqres.in\","
	  		+ "\"password\":\"cityslicka\""
	  		+ "}";
	  given()
	  .contentType(ContentType.JSON)
	  .body(messageString)
	  .post("/api/login")
	  .then()
	  .statusCode(200)
	  .body("token", equalTo("QpwL5tke4Pnpja7X4"));  
  }
  
  @Test
  public void thirdTest() {
	  given()
	  .delete("/api/users/2")
	  .then()
	  .statusCode(204);
	  // Response Code 204: No Content
	  // A successful request, with server responding no content
  }
  
  @Test
  public void fourthTest() {
	  String messageString = "{"
		  		+ "\"name\":\"Morpheus 2\""
		  		+ "}";

	  String oldTimeStamp = given()
              .patch("/api/users/2")
              .then()
              .extract()
              .path("updatedAt");

      given()
      .header("Content-Type","application/json")
      .body(messageString)
      .patch("/api/users/2")
      .then()
      .statusCode(200)
      .body("name", equalTo("Morpheus 2"))
      .body("updatedAt", not(equalTo(oldTimeStamp)));
  }
  
  @Test
  public void fifthTest() {
	  String messageString = "{"
		  		+ "\"name\":\"Morpheus 2\""
		  		+ "}";

	  String oldTimeStamp = given()
              .put("/api/users/2")
              .then()
              .extract()
              .path("updatedAt");

      given()
      .header("Content-Type","application/json")
      .body(messageString)
      .put("/api/users/2")
      .then()
      .statusCode(200)
      .body("name", equalTo("Morpheus 2"))
      .body("updatedAt", not(equalTo(oldTimeStamp)));
  }
  
  @Test
  public void sixthTest() {
	  User user2 = new Gson().fromJson(given().get("/api/users/2").then()
		      .statusCode(200)
		      .extract().asString(), User.class);
	  Assert.assertEquals(user2.data.id, 2);
  }
  
	/*
	 * @Test public void seventhTest() { List<User> users = new ArrayList<User>();
	 * String responseBodyData = given().get("/api/users").then() .statusCode(200);
	 * 
	 * new Gson.fromJson(responseBodyData, User.class); }
	 */
  
  @BeforeTest
  public void beforeTest() {
	  super.beforeTest();
	  baseUrl = "https://reqres.in/";
	  baseURI = baseUrl;
  }
  
  @AfterTest
  public void afterTest() {
	  super.afterTest();
	  reset();
  }
}
