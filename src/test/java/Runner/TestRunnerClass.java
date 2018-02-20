package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;

/**
 * Created by Masha on 19.02.2018.
 */

// To Run Cucumber tests from cmd with Maven using JUnit by mvn test command!!!
/*@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features"}, glue = "Steps")
public class TestRunnerClass {
}*/

// To Run Cucumber tests using TestNG from IntelijIdea and from cmd using mvn test command
@CucumberOptions(features = {"src/test/java/Features"}, glue = "Steps")
public class TestRunnerClass extends AbstractTestNGCucumberTests {

}
