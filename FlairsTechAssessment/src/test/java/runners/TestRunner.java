package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests",
		glue= {"stepDefinitions"},
		plugin = { "pretty", "html:target/cucumber-reports" },
		monochrome = true,
		stepNotifications = true
		
		)

public class TestRunner {


}





