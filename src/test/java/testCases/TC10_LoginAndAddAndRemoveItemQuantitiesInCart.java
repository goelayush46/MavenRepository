package testCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.junit.Assert;
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
import utilities.SpecialFunctionsAndActions;

@Listeners(ListenersLogic.class)
public class TC10_LoginAndAddAndRemoveItemQuantitiesInCart extends BaseClass
{
	
	@Test
	public void productAddAndRemoveQuannititiesInCartValidation() throws EncryptedDocumentException, IOException, InterruptedException{
		
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
		
		homepage.searchedProductClick();
		SpecialFunctionsAndActions.moveToChildPage();
		
		ProductPage productpage=new ProductPage(driver);
		int i1=productpage.productAddedToCartVerify();
		productpage.clickOnAddToCartButton();
		Reporter.log("Product added to cart");
		productpage.clickToAddMoreQuantities();
		Reporter.log("More Quantities added to cart");
		Thread.sleep(5000);
		productpage.clickToRemoveExtraQuantities();
		Reporter.log("Removed extra quantities from cart");
		int i2=productpage.productAddedToCartVerify();
		Assert.assertTrue("Quantities failed to add to cart", i1<i2);
	}
}
