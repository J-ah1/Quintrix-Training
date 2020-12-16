package theInternet.tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:theInternet/features" },
plugin = { "pretty", "json:target/cucumber/cucumber.json" },
glue = { "classpath:theInternet/foundation" })

//theInternet.features?
public class RunCucumberTest {

}
