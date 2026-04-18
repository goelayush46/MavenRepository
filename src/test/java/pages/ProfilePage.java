package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.SpecialFunctionsAndActions;
import utilities.WaitUtil;

public class ProfilePage{
	
	WebDriver driver;
	
	@FindBy(xpath="//button[@class='edit-pencil-icon-button']")
	private WebElement editDetails;
	
	@FindBy(id="editProfileNameInputId")
	private WebElement changeNameDetails;
	
	@FindBy(className="a-button-input")
	private WebElement continueButtonOnEditProfile;
	
	@FindBy(xpath="//div[@class='profile-name desktop']")
	private WebElement fetchProfileName;
	
	public ProfilePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void editUserDetails(String name){
		WaitUtil.waitForElementClickable(driver, editDetails, 5).click();
		WebElement e1=WaitUtil.waitForElementVisible(driver, changeNameDetails, 10);
		SpecialFunctionsAndActions.selectandClear(e1);
		e1.sendKeys(name);
		continueButtonOnEditProfile.click();
	}
	public String userProfileName() {
		return WaitUtil.waitForElementClickable(driver, fetchProfileName, 5).getText();
	}
}
