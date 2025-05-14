package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)// You are telling junit to run the TestRunner class as a cucumber Test
@CucumberOptions(features = "src/test/resources/features/User_Access.feature",
                glue = {"stepdefinitions"} ,
                plugin = {"pretty" , "html:target/primetech-report-2025.html",
                "json:target/primetech-report-2025.json"},
                tags = "@smoke"
        // or and
        // @A and not @B  → Run all with @A but exclude those with @B.
        // @A or @B and not @C → Run @A or @B scenarios, but not those that are @C.


)
public class TestRunner {
}


/**
 * This class will allow us to execute and run our feature files/step definitions
 */