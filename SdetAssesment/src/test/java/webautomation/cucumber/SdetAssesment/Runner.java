package webautomation.cucumber.SdetAssesment;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class) 
@CucumberOptions(features="src/test/java/Features/",
glue= {"webautomation.cucumber.SdetAssesment"},
plugin= {"pretty","html:target/HtmlReports.html"},monochrome=true) 
public class Runner {

}
