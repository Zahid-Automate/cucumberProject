package pageRepositories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import rootClass.Rootclass;
import utility.ActionsClass;
import utility.Log;


public class PageRepository extends Rootclass {
	
	//========= OBJECTS INITIALIZATION =======//
	ActionsClass act = new ActionsClass();
	

	public PageRepository() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//========= WEB ELEMENTS ==========//

	@FindBy(xpath = "//a[normalize-space()='Signup / Login']")
	public WebElement signInButton;

	@FindBy(xpath = "//input[@data-qa='login-email']")
	public WebElement loginEmailField;

	@FindBy(id = "password")
	public WebElement signUpPassword;

	@FindBy(xpath = "//p[normalize-space()='Email Address already exist!']")
	public WebElement errorMessage;

	@FindBy(xpath = "//input[@data-qa='signup-email']")
	public WebElement signUpEmailField;
	
	@FindBy(xpath = "//input[@placeholder='Name']")
	public WebElement name;

	@FindBy(xpath = "//input[@placeholder='Password']")
	public WebElement passwordField;

	@FindBy(xpath = "//button[normalize-space()='Signup']")
	public WebElement signUpButton;
	
	@FindBy(xpath = "//button[normalize-space()='Login']")
	public WebElement loginButton;

	@FindBy(xpath = "//a[@title='View my customer account']/span")
	public WebElement customerName;
	
	@FindBy(xpath="//select[@id='days']")
	public WebElement DOBDay;
	
	@FindBy(xpath="//select[@id='months']")
	public WebElement DOBMonth;
	
	@FindBy(xpath="//select[@id='years']")
	public WebElement DOBYears;
	
	@FindBy(xpath="//a[normalize-space()='Stories']")
	public WebElement storiesLink;
	
	@FindBy(css=".module-curated-topic-dropdown__selector.ng-pristine.ng-untouched.ng-valid.ng-not-empty")
	public WebElement storiesDropDown;
	
	@FindBy(xpath="//div[@class='module-curated-topic-dropdown__curated-buttons-container']")
	public WebElement googleButtonText;
	
	//=====Reusable Methods======//
	/**
	* Method: "enterUserName" is used to enter userName and email id in NewUserSignUp textbox
	* @param: "text" is the String to be typed
	* @return      void
	*/
	public void enterCreateEmail(String name1, String text) {
		try {
			name.sendKeys(name1);
			signUpEmailField.sendKeys(text);
			act.clickOnElement(signUpButton);
			Log.info(text+" is entered successfully");
		} catch (Exception e) {
			Log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	* Method: "validateErrorMsg" is used validate the error msg
	* @param: "text" is the string to be compared for validation
	* @return      void
	*/
	public void validateErrorMsg(String text) {
		String ActualMessage = errorMessage.getText();
		try {
			if (ActualMessage.equals("Email Address already exist!")) {
				Log.info(text+" error msg is displayed");
			}else {
				Log.info("validateErrorMsg failed");
			}
		} catch (Exception e) {
			Log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	/**
	* Method: "login" is used to login the App
	* @param: "uname" is the user name for logging in the application
    * @param: "pwd" is the password for logging in the application
	* @return      void
	*/
	public void login(String uname ,String pwd) {
		try {
			loginEmailField.sendKeys(uname);
			passwordField.sendKeys(pwd);
			act.clickOnElement(loginButton);
			Log.info("Login is successful for user name "+uname+ " with Password = " +pwd);
		} catch (Exception e) {
			Log.info(e.getMessage());
			e.printStackTrace();
		}

	}
	
	public void signUp(String pwd) {
		try {
			signUpPassword.sendKeys(pwd);
		}
		catch(Exception e) {
			Log.info(e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void selectDropDown(WebElement dropDown,String howTo, String value) {
		Select dropDownElement = new Select(dropDown);
		
		switch (howTo) {
		case "index":
		      dropDownElement.deselectByIndex(Integer.parseInt(value));
		      Log.info("DropDown value choosen is "+value);
		      break;
		case "value":
			  dropDownElement.selectByVisibleText(value);
			  Log.info("DropDown value choosen is "+value);
			  break;
		case "text":
			  dropDownElement.selectByValue(value);
			  Log.info("DropDown value choosen is "+value);
			  break;
		default : 
			Log.info("Please provide a valid value from the feature file, valid values are index , value , text");
			break;
		}	
	}
	

	

}
