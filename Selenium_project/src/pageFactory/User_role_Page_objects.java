package pageFactory;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class User_role_Page_objects 
{
	   @FindBy(linkText="Admin")
	   public static WebElement admin;
	   
	   @FindBy(id="menu_admin_UserManagement")
	   public static WebElement usermanagement;
	   
	   @FindBy(id="menu_admin_viewSystemUsers")
	   public static WebElement user;
	   
	   @FindBy(id="searchSystemUser_userType")
	   public static WebElement userrole;
	   
	   @FindBy(id="searchSystemUser_status")
	   public static WebElement status;
	   
	   @FindBy(id="searchBtn")
	   public static WebElement search;
	   
	  
	   @FindBy(xpath="//table[@id='resultTable']/tbody/tr")
	  public static List<WebElement> rows;
	   
	   @FindBy(xpath="//table[@id='resultTable']/tbody/tr[1]/td")
		  public static List<WebElement> cols;
	   
}
