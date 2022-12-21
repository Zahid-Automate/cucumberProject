package stepDefinition;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageRepositories.PageRepository;
import rootClass.Rootclass;
import utility.ActionsClass;

public class AboutGooglePage extends Rootclass {

		PageRepository googlePage = new PageRepository();
		ActionsClass act = new ActionsClass();
		
	  	@Given("^website about google$")
	    public void website_about_google() throws Throwable {
	  	 act.launchUrl();
	    }

	    @When("^user clicks on stories$")
	    public void user_clicks_on_stories() throws Throwable {
	      googlePage.storiesLink.click();
	    }

	    @And("^user selects (.+) from Stories about dropdown$")
	    public void user_selects_from_stories_about_dropdown(String value) throws Throwable {
	      googlePage.selectDropDown(googlePage.storiesDropDown, "value", value);
	      Thread.sleep(3000);
	    }
	    
	    @Then("^I validate the text on the button$")
	    public void i_validate_the_text_on_the_button() throws Throwable {
	      String Text = googlePage.googleButtonText.getText();
	      assertTrue(Text.contains("See more crisis response stories"));
	    }

}
