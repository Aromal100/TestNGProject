package TestRunnerTestNFG;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.CucumberOptions.SnippetType;

@CucumberOptions(features = {"/TestNGTest/src/test/resources/features/DigitalLibrary.feature"},
glue= {"StepDefinitionDL"},
dryRun = false, snippets=SnippetType.CAMELCASE,
plugin = {"pretty",
"html:Reports/Cucumber.html",
"json:Reports/result.json",
"junit:Reports/result.xml",
"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
public class DigitalL {
	

}
