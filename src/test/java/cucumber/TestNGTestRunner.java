package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="C:\\Users\\hp\\eclipse-workspace\\SelniumFramework\\src\\test\\java\\cucumber\\",glue="rahulshettyacademy.stepDefinitions",
monochrome=true, plugin={"html:target/cucumber.html"})
public class TestNGTestRunner extends AbstractTestNGCucumberTests {

	
}
