package POC_Test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class AzureTestCase extends BaseTest {
	Properties properties = functionalcomponents.getObjectProperties();
	String username = functionalcomponents.getdatafromsheet("EdgeServices", "AzureTestCase_Flow", "username");
	String password = functionalcomponents.getdatafromsheet("EdgeServices", "AzureTestCase_Flow", "password");	
	String AzureStagingURL=functionalcomponents.getdatafromsheet("EdgeServices", "AzureTestCase_Flow", "URL");
	String EdgeDevice= functionalcomponents.getdatafromsheet("EdgeServices", "AzureTestCase_Flow", "EdgeDevice");
	String Module = functionalcomponents.getdatafromsheet("EdgeServices", "AzureTestCase_Flow", "Module");
	String configname=functionalcomponents.getdatafromsheet("EdgeServices", "AzureTestCase_Flow", "ExistConfigName");
	 
	
	@Test
	public void AzureTestCase_Flow() {
		
		 test.log(Status.INFO, "Launch URL and Login into the policy service in stage environment with the valid credentilas and navigate to Edge service managment tile ");
		 driver.get(AzureStagingURL);
		 functionalcomponents.WaitTillTime(2000);			 
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesiger_UserName"), 90);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesiger_UserName"), username);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesigner_PassWord"), password);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_Logon"));
		 functionalcomponents.WaitTillTime(7000);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateway_management"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
		  functionalcomponents.WaitTillTime(20000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("searchbutton"), 90);
		  functionalcomponents.WaitTillTime(7000);
		  if(driver.findElement(By.xpath(properties.getProperty("searchbutton"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to see edge service management tile is successully");
		  } else
		  {
             failedDescription("user is not able to click on the edge Management successully");
          }
		  
		  test.log(Status.INFO, "Search for the Edge Device to add EBF Service");
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Search_EdgeDevice"),EdgeDevice);
		  System.out.println(EdgeDevice);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+EdgeDevice+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edge_Modules"), 90);
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_Modules"));	
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("modules_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  if(functionalcomponents.IsElementPresent(properties.getProperty("ModuleRemoveLink")))
		  {
			  functionalcomponents.ClickOperation(properties.getProperty("ModuleRemoveLink"));	
			  functionalcomponents.WaitTillTime(7000);
			  functionalcomponents.ClickOperation(properties.getProperty("RemoveModuleconfirmOK"));
			  functionalcomponents.WaitTillTime(10000);
			  functionalcomponents.ClickOperation(properties.getProperty("modules_refresh_btn"));
			  functionalcomponents.WaitTillTime(10000);
			  if(functionalcomponents.IsElementPresent(properties.getProperty("ModuleRemoveLink")))
			  {
				  functionalcomponents.ClickOperation(properties.getProperty("ModuleRemoveLink"));	
				  functionalcomponents.WaitTillTime(7000);
				  functionalcomponents.ClickOperation(properties.getProperty("RemoveModuleconfirmOK"));
				  functionalcomponents.WaitTillTime(10000);
				  functionalcomponents.ClickOperation(properties.getProperty("modules_refresh_btn"));
				  functionalcomponents.WaitTillTime(10000);
			  }
		  }
		  functionalcomponents.ClickOperation(properties.getProperty("Modules_Addbutton"));		
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Module_EssentialBusinessService"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		  functionalcomponents.WaitTillTime(10000);	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("modules_refresh_btn"), 90); 
		  if(driver.findElement(By.xpath(properties.getProperty("modules_refresh_btn"))).isDisplayed())
		  {
				 test.log(Status.PASS, "user is able to select EBF service as Module successfully");
		  }
		  else
			{
				 failedDescription("user is not able to select EBF service as module successfully");
			}
		  test.log(Status.INFO, "verify EBF Service module status is displaying Update Available successfully");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("modules_refresh_btn"), 50); 
		  for(int i=0; i<=30; i++) {
			  functionalcomponents.ClickOperation(properties.getProperty("modules_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(15000);
			  WebElement ele2=driver.findElement(By.xpath(properties.getProperty("Module_Statuspart1")+Module+properties.getProperty("Module_Statuspart2")));
			  if(ele2.getText().equalsIgnoreCase("Update Available"))
				{
				  break;
			  }
		  } 
		  WebElement ele2=driver.findElement(By.xpath(properties.getProperty("Module_Statuspart1")+Module+properties.getProperty("Module_Statuspart2")));
		  String text2= ele2.getText();   
			if(text2.equalsIgnoreCase("Update Available"))
			{
				 test.log(Status.PASS, "EBF Service module status is displayed Update Available successfully");
			}
			else
			{
				 failedDescription("EBF Service module status is not displayed Update Available successfully");
			}	
			
			 test.log(Status.INFO, "Capture Version for EBF Service");
			  System.out.println(Module);
			  WebElement Element =driver.findElement(By.xpath(properties.getProperty("Moduleversionpart1")+Module+properties.getProperty("Moduleversionpart2")));
			  String Versionvalue = Element.getText();
			  System.out.println(Versionvalue);
			  if(driver.findElement(By.xpath(properties.getProperty("modules_refresh_btn"))).isDisplayed())
			  {
					 test.log(Status.PASS, "EBF Service Module version is displayed as :"+Versionvalue);
			  }
			  else
				{
					 failedDescription("EBF Service Module version is not displayed");
				}
			
			  test.log(Status.INFO, "validate EBF Service is not available in dropdown if user again added it");
			  functionalcomponents.ClickOperation(properties.getProperty("Modules_Addbutton"));		
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
			  functionalcomponents.WaitTillTime(2000);
			  if(functionalcomponents.IsElementPresent(properties.getProperty("Module_EssentialBusinessService")))
			  {
					 test.log(Status.FAIL, "EBF Service Module is displayed in dropdown");
			  }
			  else
				{
				  test.log(Status.PASS, "EBF Service Module is not displayed in dropdown if user is adding again it");
				}
			  functionalcomponents.ClickOperation(properties.getProperty("Module_cancelbutton"));	
			  functionalcomponents.WaitTillTime(3000);
	    
			  //adding config and deployed
			  test.log(Status.INFO, "add EBF Service and Configuration");
			  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
			  functionalcomponents.WaitTillTime(10000);
			  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("EssentialBusinessService"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configname+properties.getProperty("config_value_part2")));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
			  functionalcomponents.WaitTillTime(30000);	
			  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+configname+" "+"successfully");
			  } 
			  else
			  {
	              failedDescription("user should able to add the configuration with name as"+" "+configname+" "+"not successfully");
	          }
			  test.log(Status.INFO, "Click on the Refresh button untill status becomes Activated");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("search_configname"),configname);
			  functionalcomponents.WaitTillTime(15000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
			  functionalcomponents.WaitTillTime(5000);  
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(10000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(10000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
			  functionalcomponents.WaitTillTime(70000);
			  for(int i=0; i<=7; i++) {
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
				  functionalcomponents.WaitTillTime(15000);
				  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
				  if(ele1.getText().equalsIgnoreCase("Activated"))
					{
					  break;
				  }
			  }
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
			  String text3= ele1.getText();
			  System.out.println(text3);
			    
				if(text3.equalsIgnoreCase("Activated"))
				{
					 test.log(Status.PASS, "configuration activated successfully");
				}
				else if(text3.equalsIgnoreCase("Activation Failed"))
				{
					failedDescription( "configuration Activation Failed status");
				}
				else
				{
					 failedDescription("configuration is not activated");
				}
	
}
	
	
	
}
