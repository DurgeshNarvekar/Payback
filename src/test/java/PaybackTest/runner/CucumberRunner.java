package PaybackTest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



public class CucumberRunner {

	@CucumberOptions(tags = "", features = "src/test/resources/Features/Login.feature", glue = "PaybackTest.definations",
			plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},monochrome = true,publish = true)

	public class CucumberRunnerTest extends AbstractTestNGCucumberTests {

	}

}
