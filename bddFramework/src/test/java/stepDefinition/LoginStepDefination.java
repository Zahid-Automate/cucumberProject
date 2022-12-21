package stepDefinition;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageRepositories.PageRepository;
import rootClass.Rootclass;
import utility.ActionsClass;
import utility.Utility;

public class LoginStepDefination extends Rootclass {

	PageRepository homePage = new PageRepository();
	ActionsClass act = new ActionsClass();
	Utility ut=new Utility();
	
	@Given("^I launch the URL$")
	public void i_launch_the_URL() throws Throwable {
	  act.launchUrl(); 
	}

	@When("^I enter existing username \"([^\"]*)\" and existing Email \"([^\"]*)\"$")
	public void i_enter_existing_username_and_existing_email(String validUname, String existingEmail) {
	    // Write code here that turns the phrase above into concrete actions
		homePage.enterCreateEmail(validUname, existingEmail);
	}

	
	@Then("^I verify the error message$")
	public void i_verify_the_error_message() throws Throwable {
	    homePage.validateErrorMsg(ut.readProperty("errorMsg", "config"));
	}

	@And("^I login with valid credentials \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_login_with_valid_credentials_and(String existingEmail, String validPwd) throws Throwable {
		homePage.login(existingEmail, validPwd);
	}

}
