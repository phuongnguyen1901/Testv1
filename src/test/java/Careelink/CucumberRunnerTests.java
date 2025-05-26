package Careelink;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
// dùng để chạy file cần test
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:target/cucumber-reports/cucummber.html", "json:target/cucumber-reports/cucumber.json"},
        features = "src/test/resources/Careelink/CoverLetter",
        glue = "stepDefinitions",
        monochrome = true
)
public class  CucumberRunnerTests {

}