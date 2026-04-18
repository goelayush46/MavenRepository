package utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {

	public static WebElement waitForElementVisible(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static WebElement waitForElementClickable(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static WebElement waitForElementPresence(WebDriver driver, By locator, int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	public static boolean waitForUrlContains(WebDriver driver, String value, int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.urlContains(value));
	}
	public static boolean waitForTitleContains(WebDriver driver, String title, int time) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		return wait.until(ExpectedConditions.titleContains(title));
	}
}
