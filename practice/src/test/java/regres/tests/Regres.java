package regres.tests;

import org.testng.annotations.Test;

import framework.TestBase;
import io.restassured.http.ContentType;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

//As of now, we're a different Url than defined in the configs
//Also, want to make a RegresTestBase
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
