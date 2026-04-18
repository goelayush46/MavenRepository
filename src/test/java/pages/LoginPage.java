package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	WebDriver driver;
	
	@FindBy(name="email")
	private WebElement username;
	
	@FindBy(id="continue")
	private WebElement continuebutton;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signin;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void login(String user, String pass) {
		username.sendKeys(user);
		continuebutton.click();
		password.sendKeys(pass);
		signin.click();
	}


}
