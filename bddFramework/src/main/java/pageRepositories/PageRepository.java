package pageRepositories;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rootClass.Rootclass;
import utility.ActionsClass;
import utility.Log;


public class SinceraPageRepository_homePage extends Rootclass {
	
	//========= OBJECTS INITIALIZATION =======//
	ActionsClass act = new ActionsClass();
	

	public SinceraPageRepository_homePage() {
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}
	
	//========= WEB ELEMENTS ==========//

	@FindBy(xpath = "//a[@title='Log in to your customer account']")
	public WebElement signInButton;

	@FindBy(id = "email_create")
	public WebElement userNameCreateField;

	@FindBy(id = "SubmitCreate")
	public WebElement createSubmitButton;

	@FindBy(xpath = "//div[@id='create_account_error']//li")
	public WebElement errorMessage;

	@FindBy(id = "email")
	public WebElement emailField;

	@FindBy(id = "passwd")
	public WebElement passwordField;

	@FindBy(id = "SubmitLogin")
	public WebElement loginButton;

	@FindBy(xpath = "//a[@title='View my customer account']/span")
	public WebElement customerName;
	
	
	
	//=====Reusable Methods======//
	/**
	* Method: "enterCreateEmail" is used to enter mail id in create email textbox
	* @param: "text" is the String to be typed
	* @return      void
	*/
	public void enterCreateEmail(String text) {
		try {
			act.clickOnElement(signInButton);
			userNameCreateField.sendKeys(text);
			act.clickOnElement(createSubmitButton);
			Log.info(text+" is entered sucessfully");
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
		try {
			if (errorMessage.getText().equals(text)) {
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
			emailField.sendKeys(uname);
			passwordField.sendKeys(pwd);
			act.clickOnElement(loginButton);
			Log.info("Login sucessful");
		} catch (Exception e) {
			Log.info(e.getMessage());
			e.printStackTrace();
		}

	}
	

	

}
