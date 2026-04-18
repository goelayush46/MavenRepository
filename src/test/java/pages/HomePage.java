package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.FluentWaitUtil;
import utilities.WaitUtil;

public class HomePage{
	
	WebDriver driver;
	
	@FindBy(xpath="//*[text()='Continue shopping']")
	private WebElement continueShopping;
	
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	private WebElement accountslist;
	
	@FindBy(xpath="//span[@class='nav-action-inner']")
	private WebElement signin;
	
	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	
	@FindBy(xpath="//button[.='Manage Profiles']")
	private WebElement manageProfiles;
	
	@FindBy(xpath="//a[.='View']")
	private WebElement viewPopupButton;
	
	@FindBy(id="nav-link-accountList-nav-line-1")
	private WebElement verifyUserName;
	
	@FindBy(xpath="//div[@data-cel-widget='search_result_2']")
	private WebElement searchProductHomePage;
	
	@FindBy(xpath="//select[@data-action='a-dropdown-select']")
	private WebElement searchProductSorting;
	
	private By productOnePrice =By.xpath("(//span[@class='a-price-whole'])[6]");
	private By productTwoPrice =By.xpath("(//span[@class='a-price-whole'])[9]");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnContinueShoppingButton() {
		WaitUtil.waitForElementClickable(driver, continueShopping, 10).click();
	}
	public void hoverOverOnAccountList()
	{
		WebElement element= FluentWaitUtil.waitForElement(driver,d -> accountslist,10,2); //fluent wait application
		Actions a1=new Actions(driver);
		a1.moveToElement(element).perform();
	}
	public void clickToSignIn()
	{
		WaitUtil.waitForElementClickable(driver, signin, 10).click();
	}
	public void searchProduct(String product)
	{
		 WaitUtil.waitForElementVisible(driver, search, 10).sendKeys(product + Keys.ENTER); //Explicit wait application
	}
	public void manageProfileOfUser(){
		WaitUtil.waitForElementVisible(driver, manageProfiles, 10).click();
	}
	public void clickViewOnPopup(){
		WaitUtil.waitForElementVisible(driver, viewPopupButton, 10).click();
	}
	public String loginVerification(){
		return WaitUtil.waitForElementVisible(driver, verifyUserName, 10).getText();
	}
	public void searchedProductClick(){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchProductHomePage);
		WaitUtil.waitForElementClickable(driver, searchProductHomePage, 10).click();
	}
	public void searchedProductSorting(){
		
		WebElement e1=WaitUtil.waitForElementVisible(driver, searchProductSorting, 10);
		Select s1=new Select(e1);
		s1.selectByValue("price-asc-rank");
		
	}
	public boolean compareProductPrice() {

	    WebElement product1 =WaitUtil.waitForElementPresence(driver, productOnePrice, 10);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product1);
	    WebElement product2 =WaitUtil.waitForElementPresence(driver, productTwoPrice, 10);
	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product2);

	    int p1 = Integer.parseInt(product1.getText());
	    int p2 = Integer.parseInt(product2.getText());

	    return p1 <= p2;
	}
}
