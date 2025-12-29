package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;
	
	@Parameters("Browser")
	@BeforeMethod
	public void launch(String nameOfBrowser)
	{
		if(nameOfBrowser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(nameOfBrowser.equals("edge")) {
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
	}
	@AfterMethod
	public void quit() {
		driver.quit();
	}
}
