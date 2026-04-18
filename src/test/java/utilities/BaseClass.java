package utilities;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseClass extends ListenersLogic{

	public static String getTimeStamp() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	}
	
	@Parameters("Browser")
	@BeforeMethod
	public void launch(@Optional ("chrome") String nameOfBrowser)
	{
		if(nameOfBrowser.equals("chrome")) {
			driver=new ChromeDriver();
		}
		if(nameOfBrowser.equals("edge")) {
			driver=new EdgeDriver();
		}
		if(nameOfBrowser.equals("firefox")) {
			driver=new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in");
	}
	
	@AfterMethod
	public void quit() {
		//driver.quit();
	}
}
