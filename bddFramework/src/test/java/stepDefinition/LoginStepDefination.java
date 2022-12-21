package stepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageRepositories.SinceraPageRepository_homePage;
import rootClass.Rootclass;
import utility.ActionsClass;
import utility.Utility;

public class SinceraStepDefinition extends Rootclass {

	SinceraPageRepository_homePage homePage = new SinceraPageRepository_homePage();
	ActionsClass act = new ActionsClass();
	Utility ut=new Utility();
	


	@Given("^I launch the URL$")
	public void i_launch_the_URL() throws Throwable {
	  act.launchUrl();
	 
	}

	@When("^I enter existing mail \"([^\"]*)\"$")
	public void i_enter_existing_mail(String email) throws Throwable {
		homePage.enterCreateEmail(email);
	}

	@Then("^I verify the error message$")
	public void i_verify_the_error_message() throws Throwable {
	    homePage.validateErrorMsg(ut.readProperty("errorMsg", "config"));
	}

	@Then("^I login with valid credintials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_valid_credintials_and(String uname, String pwd) throws Throwable {
		homePage.login(uname, pwd);
	}

	
	

}
