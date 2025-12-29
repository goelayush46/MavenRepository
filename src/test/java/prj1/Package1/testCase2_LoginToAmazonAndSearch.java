package prj1.Package1;

import org.testng.annotations.Test;

import Project1.Package1.HomePage;
import Project1.Package1.LoginPage;
import utility.BaseClass;

public class testCase2_LoginToAmazonAndSearch extends BaseClass
{
	@Test
	public void withValidCredentials() throws InterruptedException {
		HomePage homepage=new HomePage(driver);
		try {
		homepage.clickOnContinueShoppingButton();
		homepage.hoverOverOnAccountList(driver);
		}
		catch(Exception e){
			homepage.hoverOverOnAccountList(driver);
		}
		homepage.clickToSignIn();
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUsername();
		loginpage.clickOnContinute();
		loginpage.enterPassword();
		loginpage.clickOnSignIn();
		Thread.sleep(3000);
		homepage.searchProduct();
		Thread.sleep(3000);
	}
}
