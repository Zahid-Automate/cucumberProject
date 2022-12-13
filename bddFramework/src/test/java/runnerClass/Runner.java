package runnerClass;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources",
glue = {"stepDefinition","baseClass"},
plugin = {"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
)

public class Runner {
	
	/**
	* Method: ExtentReportsetup() is used to manage the Extent report attributes
	* @return  Void
	*/
	@AfterClass
	public static void setup()
	{
	Reporter.loadXMLConfig("src/test/resources/extent-config.xml");
	Reporter.assignAuthor("ASHWIN PT");
	Reporter.setSystemInfo("User Name", "ASHWIN PT");
	Reporter.setSystemInfo("Application Name", "http://automationpractice.com/index.php");
	Reporter.setSystemInfo("Operating System Type", System.getProperty("os.name").toString());
	Reporter.setSystemInfo("Environment", "Test Environment");
	Reporter.setTestRunnerOutput("Test Execution Cucumber Report");
	
	}

	}
