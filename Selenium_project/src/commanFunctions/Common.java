package commanFunctions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Common 
{
	public static Properties p;
	public static WebDriver driver ;
	static Logger logger = Logger.getLogger(Common.class);
	
	public void loadProperties() throws IOException
	{
		FileInputStream fis= new FileInputStream("config.properties");
		 p= new Properties();
		p.load(fis);
		
	}
	
	
	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void launchBrowser() throws IOException
	{
		PropertyConfigurator.configure("log4j.properties");
		logger.info("LOADING PROPERTIES");
		loadProperties();
		String url = p.getProperty("url");
		String username = p.getProperty("username");
		String password = p.getProperty("password");
		String driverlocation = p.getProperty("driverlocation");
		String browser = p.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverlocation);
			logger.info("OPENING CHROME BROWSER");
			 driver=new ChromeDriver();
			 
		}
		else if(browser.equalsIgnoreCase("internetexplorer"))
		{
			System.setProperty("webdriver.internetexplorer.driver", driverlocation);
			 driver=new InternetExplorerDriver();
		}
		
		logger.info("NAVIGATING TO ORANGE HM WEBAPPLICATION");
		driver.navigate().to(url);
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	


    @AfterSuite
	public void closeBrowser()
	
	{
    	logger.info("TEST CASES DONE ! QUITTING BROWSER");
		driver.quit();
	}

}
