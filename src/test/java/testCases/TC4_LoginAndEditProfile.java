package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.BaseClass;
import utilities.DataFetching;
import utilities.FetchData;

public class TC4_LoginAndEditProfile extends BaseClass{
	@Test
	public void EditProfileInformationOfUser() throws EncryptedDocumentException, IOException, InterruptedException {
	DataFetching df = new DataFetching();
    String[] data = df.methodA();
	
	HomePage homepage=new HomePage(driver);
	try {
	homepage.clickOnContinueShoppingButton();
	homepage.hoverOverOnAccountList();
	}
	catch(Exception e) {
		homepage.hoverOverOnAccountList();
	}
	homepage.clickToSignIn();
	Reporter.log("Navigated to Login Page");

	LoginPage loginpage = new LoginPage(driver);
    loginpage.login(data[0], data[1]);
    Reporter.log("Login is Done");
    
    homepage.hoverOverOnAccountList();
    homepage.manageProfileOfUser();
    homepage.clickViewOnPopup();
    
    ProfilePage profilepage = new ProfilePage(driver);
    String nameBeforeUpdate=profilepage.userProfileName();
    profilepage.editUserDetails(FetchData.getData("login", 1, 2));
    Assert.assertNotEquals(nameBeforeUpdate,FetchData.getData("login", 1, 2),"Profile not updated");
    Reporter.log("Profile details updated");
    }
}
