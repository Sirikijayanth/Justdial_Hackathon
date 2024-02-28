package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features=".//featurefiles",
		glue="stepDefinitions",
		plugin={"pretty","html:reports/cucumberreports.html",
				 "rerun:target/rerun.txt",
				 "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				 },
		dryRun=false,
		monochrome=true,
		publish=false
		)

public class Testrun {

}
