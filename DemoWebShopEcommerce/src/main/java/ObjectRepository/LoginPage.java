package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import Generic_Library.FileUtility;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver dr) {
		super(dr);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "Email" )
	private WebElement emailTextField;
	
	@FindBy(id = "Password" )
	private WebElement passwordTextField;
	
	@FindBy(id = "Email" )
	private WebElement EmailTextField;
	
	@FindBy(id = "RememberMe" )
	private WebElement rememberMeCheckBox;
	
	@FindBy(linkText  = "Forgot Password" )
	private WebElement forgotPasswordLink;
	
	@FindBy(css  = "[value='Log in']" )
	private WebElement loginButton;

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getRememberMeCheckBox() {
		return rememberMeCheckBox;
	}

	public WebElement getForgotPasswordLink() {
		return forgotPasswordLink;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}
	
	/**
	 * Used to login into the application by giving valid email and password
	 */
	
	public void login(WebDriver dr) {
		
		HomePage hp = new HomePage(dr);
		LoginPage lp = new LoginPage(dr);
		
		//Click on Login link in homePage
		hp.getLoginLink().click();
		
		//Enter email 
		lp.getEmailTextField().sendKeys(FileUtility.getProperty("email"));
		
		//Enter Password 
		lp.getPasswordTextField().sendKeys(FileUtility.getProperty("password"));
		
		//Click on Remember Me CheckBox
		lp.getRememberMeCheckBox().click();
		
		//Click on login Button
		lp.getLoginButton().click();
	}
	
	/**
	 * Used to logout from the application
	 */
	
	public void logout(WebDriver dr) {
		
		HomePage hp = new HomePage(dr);
		
		//click on logout link
		hp.getLogoutLink().click();
	}
}
