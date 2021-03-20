package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commanFunctions.Common;
import pageFactory.Dashboard_Page_Objects;
import pageFactory.Login_Page;

public class Test_Pending_Leave  extends Common
{
	static Logger logger = Logger.getLogger( Test_Pending_Leave.class);
	
	public  void login()
	{
		
		PageFactory.initElements(driver,Login_Page.class );
		logger.info("ENTERING USERNAME");
		Login_Page.username.sendKeys( p.getProperty("username"));
		logger.info("ENTERING PASSWORD");
		Login_Page.password.sendKeys( p.getProperty("password"));
		logger.info("SUBMIT");
        Login_Page.submit.click();
	}
	
	@Test	
	public void getPendingText()
	{
		login();
		
		PageFactory.initElements(driver, Dashboard_Page_Objects.class);
		logger.info("GETTING INFO FROM PENDING LEAVE REQUEST");
		 String pendingtext = Dashboard_Page_Objects.pendingleaverequest.getText();
		 Assert.assertEquals(pendingtext, "No Records are Available");
		
	}
		
 
}
