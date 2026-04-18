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
public class TC8_LoginAndValidateSorting extends BaseClass
{
	
	@Test
	public void productsSortingValidation() throws EncryptedDocumentException, IOException{
		
		DataFetching df = new DataFetching();
	    String[] data = df.methodA();
	    
		HomePage homepage=new HomePage(driver);
		try {
		homepage.clickOnContinueShoppingButton();
		homepage.hoverOverOnAccountList();
		}
		catch(Exception e){
			homepage.hoverOverOnAccountList();
		}
		
		homepage.clickToSignIn();
		Reporter.log("Naviagted to Login Page");
		
		LoginPage loginpage = new LoginPage(driver);
	    loginpage.login(data[0], data[1]);
		Reporter.log("Login is done");
		
		homepage.searchProduct(FetchData.getData("login", 1, 4));
		Reporter.log("Product search is done");
		
		homepage.searchedProductSorting();
		Reporter.log("Products sorting is done from low to high price");
		homepage.compareProductPrice();
		Assert.assertTrue(homepage.compareProductPrice(),"Prices are not sorted in ascending order");
	}
}
