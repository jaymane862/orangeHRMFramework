package Common.Runner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.runner.RunWith;

import Common.utils.WebDriverConfig;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/resources/Features" }, glue = { "StepDefinitions"},
        plugin = { "pretty",
		"json:target/cucumber/reports.json", "junit:target/cucumber/reports.xml",
		"html:target/cucumber/report.html",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        monochrome = true,

		tags = "@jay",

		dryRun = false)
public class TestRunner extends WebDriverConfig{

	  private static final Logger logger = LogManager.getLogger(TestRunner.class);

	  
	  }
