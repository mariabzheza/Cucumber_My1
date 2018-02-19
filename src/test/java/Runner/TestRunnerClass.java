package Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by Masha on 19.02.2018.
 */

//This file was added to run test from Maven cmd by mvn test command!!!

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/java/Features"}, glue = "Steps")
public class TestRunnerClass {

}
