package theInternet.foundation;

import org.testng.Assert;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.TestBase;
import theInternet.pages.CheckboxPage;
import theInternet.pages.DropdownPage;
import theInternet.pages.FormAuthenticationPage;

public class StepDefinitions extends TestBase{
	private DropdownPage dropdownPage;
	private CheckboxPage checkboxPage;
	private FormAuthenticationPage formAuthenticationPage;
	
	@Given("user launches a web browser")
	public void user_launches_a_web_browser() throws Throwable {
	    super.beforeTest();
	}
	
	@Given("user is on the dropdown page")
	public void user_is_on_the_dropdown_page() throws Throwable {
		dropdownPage = new DropdownPage(webDriver, baseUrl).navigate();
	}
	
	@Given("user is on the checkbox page")
	public void user_is_on_the_checkbox_page() throws Throwable {
		checkboxPage = new CheckboxPage(webDriver, baseUrl).navigate();
	}

	@Given("user is on the form authentication page")
	public void user_is_on_the_form_authentication_page() throws Throwable {
		formAuthenticationPage = new FormAuthenticationPage(webDriver, baseUrl).navigate();
	}
	
	
	@When("user selects {string}")
	public void user_selects(String option) throws Throwable {
		dropdownPage.select(option);
	}
	
	@When("user clicks the {string} box")
	public void user_clicks_the_box(String label) throws Throwable {
		checkboxPage.clickCheckboxWithLabel(label);
	}
	
	@When("user types {string} into the username field")
	public void user_types_into_the_username_field(String username) throws Throwable {
		formAuthenticationPage.typeUser(username);
	}

	@When("user types {string} into the password field")
	public void user_types_into_the_password_field(String password) throws Throwable {
		formAuthenticationPage.typePassword(password);
	}

	@When("user presses the submit button")
	public void user_presses_the_submit_button() throws Throwable {
	    formAuthenticationPage.enterCredentials();
	}
	

	@Then("{string} is selected")
	public void is_selected(String option) throws Throwable {
		String selectedString = dropdownPage.getOption();
		Assert.assertEquals(option, selectedString);
	}
	
	@Then("the {string} box is {string}")
	public void the_box_is(String label, String desiredState) throws Throwable {
		Boolean boxState = checkboxPage.getBoxStateByLabel(label);
		Assert.assertEquals(desiredState, (boxState ? "checked" : "unchecked"));
	}
	
	@Then("the user is on the secure page")
	public void the_user_is_on_the_secure_page() throws Throwable {
	    Assert.assertTrue(formAuthenticationPage.isAuthorized());
	}
	
	@Then("the user is on the login page")
	public void the_user_is_on_the_login_page() throws Throwable {
	    Assert.assertFalse(formAuthenticationPage.isAuthorized());
	}
	
	@After
	public void afterScenario() throws Throwable {
		super.afterTest();
	}
	
	
	
	
	
	

	

	



	
	
}
