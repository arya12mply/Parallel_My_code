package Runner_file;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/Features/Login Positive.feature",
        tags = "@Search",
        glue = "StepDefinitions",
        plugin = {"timeline:target/TimelineReports"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {

    //To enable parallel tests
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
