package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.WaitUtil;

public class ProductPage {
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='a-color-state a-text-bold']")
	private WebElement productSearchedVerify;
	
	@FindBy(xpath="(//span[@class='a-size-base a-color-base a-text-bold'])[1]")
	private WebElement productFilteredVerify;
	
	private By brandCheckbox =By.xpath("//div[@id='brandsRefinements']//input[@type='checkbox']");
	
	@FindBy(xpath="(//div[@data-cy='title-recipe']/descendant::span)[1]")
	private WebElement searchedProductName;
	
	@FindBy(xpath="//input[@title='Add to Shopping Cart']")
	private WebElement AddToCartButton;
	
	@FindBy(xpath="//div[@id='nav-cart-count-container']/span[1]")
	private WebElement addToCartVerify;
	//input[@title='Add to Shopping Cart']
	
	@FindBy(xpath="//span[@data-a-selector='increment-icon']")
	private WebElement addMoreQuantities;
	
	@FindBy(xpath="//span[@data-a-selector='decrement-icon']")
	private WebElement removeExtraQuantities;
	
	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public String searchProductFor() {
		return WaitUtil.waitForElementVisible(driver, productSearchedVerify, 10).getText();
	}
	public String searchFilterFor() {
		return WaitUtil.waitForElementVisible(driver, productFilteredVerify, 10).getText();
	}
    public void selectCategory() {

    	WebElement checkbox =WaitUtil.waitForElementPresence(driver, brandCheckbox, 10);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
    }
	public String searchedProductAfterFilter() {
		return WaitUtil.waitForElementClickable(driver, searchedProductName, 10).getText();
	}
    public void clickOnAddToCartButton() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", AddToCartButton);
    	WaitUtil.waitForElementVisible(driver, AddToCartButton, 10).click();
    }
    public int productAddedToCartVerify() {
    	int i=Integer.parseInt(WaitUtil.waitForElementVisible(driver, addToCartVerify, 10).getText());
		return i;
    }
    public void clickToAddMoreQuantities() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addMoreQuantities);
    	WaitUtil.waitForElementVisible(driver, addMoreQuantities, 10).click();
    }
    public void clickToRemoveExtraQuantities() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", removeExtraQuantities);
    	WaitUtil.waitForElementVisible(driver, removeExtraQuantities, 10).click();
    }
}
