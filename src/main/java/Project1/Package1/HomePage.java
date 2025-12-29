package Project1.Package1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	@FindBy(xpath="//*[text()='Continue shopping']")
	private WebElement continueShopping;
	@FindBy(xpath="//span[@class='nav-line-2 ']")
	private WebElement accountslist;
	@FindBy(xpath="//span[@class='nav-action-inner']")
	private WebElement signin;
	@FindBy(id="twotabsearchtextbox")
	private WebElement search;
	
	public void clickOnContinueShoppingButton() {
		continueShopping.click();
	}
	public void hoverOverOnAccountList(WebDriver driver)
	{
		Actions a1=new Actions(driver);
		a1.moveToElement(accountslist).perform();
	}
	public void clickToSignIn()
	{
		signin.click();
	}
	public void searchProduct()
	{
		search.sendKeys("shoes"+Keys.ENTER);
	}
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
