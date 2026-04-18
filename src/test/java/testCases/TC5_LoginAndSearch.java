package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utilities.BaseClass;
import utilities.DataFetching;
import utilities.FetchData;
import utilities.ListenersLogic;

@Listeners(ListenersLogic.class)
public class TC5_LoginAndSearch extends BaseClass
{
	
	@Test(retryAnalyzer = utilities.RetryLogic.class)
	public void productSearch() throws EncryptedDocumentException, IOException{
		
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
		Reporter.log("Navigated to SignIn Page");
		
		LoginPage loginpage = new LoginPage(driver);
	    loginpage.login(data[0], data[1]);
		Reporter.log("Login is Done");
		
		homepage.searchProduct(FetchData.getData("login", 1, 4));
		ProductPage searchpage=new ProductPage(driver);
		String productname=(searchpage.searchProductFor()).substring(1, 6);
		Assert.assertEquals(productname, FetchData.getData("login", 1, 4),"Product search Failed");
		Reporter.log("Product search is Successful");
	}
}
