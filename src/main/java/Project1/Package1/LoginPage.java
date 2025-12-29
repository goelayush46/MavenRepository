package Project1.Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="email")
	private WebElement username;
	
	@FindBy(id="continue")
	private WebElement continuebutton;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(id="signInSubmit")
	private WebElement signin;
	
	public void enterUsername() {
		username.sendKeys("ayushgoel93@outlook.com");
	}
	public void clickOnContinute() {
		continuebutton.click();
	}
	public void clickOnSignIn() {
		signin.click();
	}
	public void enterPassword() {
		password.sendKeys																													("Ayush@789");
	}
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
