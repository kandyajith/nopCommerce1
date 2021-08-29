package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//Features/Login.feature",
                glue = "stepDefinitions",
                //dryRun = true,//without real excecution
                dryRun = true,
                monochrome = true, //remove unnessearyy characters
                plugin = {"pretty","html:test-output"}
        )
public class TestRunner {
}
