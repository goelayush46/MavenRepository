package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class FluentWaitUtil {
	
	public static WebElement waitForElement(WebDriver driver,Function<WebDriver, WebElement> condition,int timeout,int pollingTime)
	{
		FluentWait<WebDriver> wait =new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeout))
		.pollingEvery(Duration.ofSeconds(pollingTime)).ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		
		return wait.until(condition);
	}
}
