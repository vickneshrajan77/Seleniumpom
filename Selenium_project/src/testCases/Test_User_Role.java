package testCases;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commanFunctions.Common;
import pageFactory.User_role_Page_objects;



public class Test_User_Role extends Common
{
	static Logger logger = Logger.getLogger( Test_User_Role.class);	
	public void moveToUserPage()
	{
		
		logger.info("CONTROLING  MOUSE EVENTS");
		   Actions a=new Actions(driver);
		   a.moveToElement(User_role_Page_objects.admin);
		   a.moveToElement(User_role_Page_objects.usermanagement);
		   a.moveToElement(User_role_Page_objects.user);
		   a.click().build().perform();
	}
	public void userRole()
	{
		Select userrole= new Select(User_role_Page_objects.userrole);
		userrole.selectByIndex(1);
	}
	public void userStatus()
	{
		Select selectstatus= new Select(User_role_Page_objects.status);
		selectstatus.selectByIndex(1);	
	}
	@Test
   public void checkuserManagement()
   {
		logger.info("USER MANAGEMENT");
	 PageFactory.initElements(driver, User_role_Page_objects.class);
	  moveToUserPage();
	  userRole();
	  userStatus();
	  User_role_Page_objects.search.click();
	  checkData();
   }
	public void checkData()
	{
		logger.info("CHECKING DATA ");
		List<WebElement> rows1 = User_role_Page_objects.rows;
		List<WebElement> column1 = User_role_Page_objects.cols;
		
		int rsize=rows1.size();
		@SuppressWarnings("unused")
		int csize=column1.size();
		
		
		 for(int i=1 ; i<=rsize;i++) 
		 { 
			 WebElement aname=driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[3]"));
		  String aname1 = aname.getText();
		  
		  Assert.assertEquals(aname1, "Admin"); }
		 
		for(int i=1 ; i<=rsize;i++)
		{
			WebElement ename= driver.findElement(By.xpath("//table[@id='resultTable']/tbody/tr["+i+"]/td[5]"));
			
			String ename1 = ename.getText();
			
		      Assert.assertEquals(ename1, "Enabled");
		}
		
		
		
		
		
	}
   
   
}
