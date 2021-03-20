package pageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Dashboard_Page_Objects 
{

//div[@id='task-list-group-panel-menu_holder']/table/tbody/tr/td[1]
	@FindBy(xpath=" //div[@id='task-list-group-panel-menu_holder']/table/tbody/tr/td[1]")
	public static WebElement pendingleaverequest;
}




