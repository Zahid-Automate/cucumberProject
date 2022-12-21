package stepDefinition;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageRepositories.PageRepository;
import rootClass.Rootclass;
import utility.ActionsClass;
import utility.Utility;

public class SignUpStepDefination extends Rootclass {
	
	PageRepository signUp = new PageRepository();
	ActionsClass act = new ActionsClass();
	Utility ut=new Utility();

	@Given("^I want to enter the username (.+) and email (.+)$")
    public void i_want_to_enter_the_username_and_email(String name, String signUpEmailAddress) throws Throwable {
		act.launchUrl(); 
		signUp.enterCreateEmail(name, signUpEmailAddress);	
    }

    @Then("^I choose the dropdown values (.+) and (.+) and (.+)$")
    public void i_choose_the_dropdown_values_and_and(String day, String month, String year) throws Throwable {
        signUp.selectDropDown(signUp.DOBDay,"value", day);
        signUp.selectDropDown(signUp.DOBMonth, "value", month );
        signUp.selectDropDown(signUp.DOBYears, "value", year);
        Thread.sleep(2000);
    }

    @And("^I verify the page title$")
    public void i_verify_the_page_title() throws Throwable {
    	String pageTitle="Automation Exercise - Signup";
        assertTrue(driver.getTitle().contains(pageTitle));
    }

    @Then("^I enter the (.+)$")
    public void i_enter_the(String pwd) throws Throwable {
    	 signUp.signUp(pwd);
    }
}
