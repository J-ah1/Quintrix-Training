package demoQA.foundation;

import framework.TestBase;

import org.testng.annotations.BeforeTest;


// Hmm, still need to refactor TestBase?
public class DemoQATestBase extends TestBase{
	
	// Inherently, this would require a new config file?
	@BeforeTest
	protected void beforeTest() {
		super.beforeTest();
		this.baseUrl = "https://demoqa.com/automation-practice-form";
	}
	
}
