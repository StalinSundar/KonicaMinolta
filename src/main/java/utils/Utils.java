package utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Utils {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public static String getPropertyValue(String Key) throws IOException
	{
		FileReader reader=new FileReader("configure.properties");	      
	    Properties p=new Properties();  
	    p.load(reader);
	    return p.getProperty(Key);   
	}
	public static void browserInialization() throws IOException
	{
		String browserName = Utils.getPropertyValue("browserName");
		String browserVersion = Utils.getPropertyValue("browserVersion");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().browserVersion(browserVersion).setup();
			ChromeOptions options = new ChromeOptions();
			driver = new ChromeDriver(options);
			driver.manage().window().maximize();
		}
		else if(browserName.equals("ie"))
		{
			WebDriverManager.iedriver().browserVersion(browserVersion).setup();
			InternetExplorerOptions options = new InternetExplorerOptions();
			driver = new InternetExplorerDriver(options);
			driver.manage().window().maximize();
		}
	}

	public static void closeBrowsers() {
		driver.quit();
	}
}
