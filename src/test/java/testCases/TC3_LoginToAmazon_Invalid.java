package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.LoginPage;
import utilities.BaseClass;
import utilities.DataFetching;
import utilities.FetchData;
import utilities.ListenersLogic;

@Listeners(ListenersLogic.class)
public class TC3_LoginToAmazon_Invalid extends BaseClass
{	
	@Test()
	public void withValidCredentials() throws EncryptedDocumentException, IOException, InterruptedException {
	
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
		Reporter.log("Naviagted to Login Page");
	
		LoginPage loginpage = new LoginPage(driver);
	    loginpage.login(data[2], data[3]);
	    Reporter.log("Login is NOT done as Incorrect Credentials");
	    Assert.assertEquals(homepage.loginVerification(),FetchData.getData("login", 1, 3),"login successful");
	}
}
