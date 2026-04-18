package utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class SpecialFunctionsAndActions extends BaseClass{
	public static void selectandClear(WebElement element) {
		element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
        element.sendKeys(Keys.DELETE);
	}
	public static void moveToChildPage() {
		Set<String> s1=driver.getWindowHandles();
		Iterator<String> i1=s1.iterator();
		i1.next();
		String s=i1.next();
		driver.switchTo().window(s);
	}
	
}
