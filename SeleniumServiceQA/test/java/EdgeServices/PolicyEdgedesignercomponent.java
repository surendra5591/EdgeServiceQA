package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class PolicyEdgedesignercomponent extends BaseTest {
	
	Properties properties = functionalcomponents.getObjectProperties();
	public void ProjectValidatePublish_ConfigDeployment(String configname,String Project_name, String Gatewayno)
	{
		  test.log(Status.INFO, "Click on the validate button on top right corner of the work center");
		  functionalcomponents.ClickOperation(properties.getProperty("validate"));
		  functionalcomponents.WaitTillTime(500);
		  String validate_msg=driver.findElement(By.xpath(properties.getProperty("Validate_msg"))).getText();
		  System.out.println(validate_msg);
		  if (validate_msg.equalsIgnoreCase("Project Validation Successful"))
		  {
            test.log(Status.PASS, "user is able to validate the project"+":"+Project_name+"successfully");
		  } else
		  {
            failedDescription("user is not able to validate the project"+":"+Project_name+"successfully");
        }
		   
		  //Publish
		  test.log(Status.INFO, "Click on the publish button on top right corner of the work center");
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("Publish"));
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Edge_configuration_name"), configname);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_publish"));
		  functionalcomponents.WaitTillTime(30000);	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SAP_logo"), 90); 
		  if (driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
		  {
	        test.log(Status.PASS, "user is able to publish the project with configuration name as"+":"+configname+"successfully");
		  } else
		  {
	        failedDescription("user is able to see te message Configuration name must be unique");
	    }
		  
		 // deployment of configuration
		  test.log(Status.INFO, "Click on the SAP logo>>Gageway management to add the configuration");
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.WaitTillTime(9000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		  functionalcomponents.WaitTillTime(15000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("searchbutton"), 70);
		  if(driver.findElement(By.xpath(properties.getProperty("searchbutton"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user should able to click on the Gateway management successully");
		  } else
		  {
              failedDescription("user is not able to click on the Gateway Management successully");
          }
		  test.log(Status.INFO, "Search for the Gageway number  to add Streaming Service and Configuration");
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),Gatewayno);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+Gatewayno+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configname+properties.getProperty("config_value_part2")));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		  functionalcomponents.WaitTillTime(90000);	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);
		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+configname+" "+"successfully");
		  } 
		  else
		  {
              failedDescription("user should able to add the configuration with name as"+" "+configname+" "+"not successfully");
          }
		  test.log(Status.INFO, "Click on the Refresh button untill status becomes Applied");
		  functionalcomponents.WaitTillTime(10000);	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900); 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),configname);
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
		  for(int i=0; i<=40; i++) {
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(10000);
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
			  if(ele1.getText().equalsIgnoreCase("Applied"))
				{
				  break;
			  }
			  else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
				{
				  break;
			  }
		  }	
		  
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
		  String text2= ele1.getText();
		  System.out.println(text2); 
			if(text2.equalsIgnoreCase("Applied"))
			{
				 test.log(Status.PASS, "configuration Applied successfully");
			}
			else
			{
				 failedDescription("Applied failed message will be displyed");
			}
		  
		  test.log(Status.INFO, "Click on the SAP logo>>Edge designer tile and search for the project");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile")); 	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 90);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("ProjectSearchinput"),Project_name);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(15000);
		  //String Projectname1=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "project_name");
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Project_name+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(5000);
		  if(driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
		  {
				 test.log(Status.PASS, "user should able to search the project successfully with name as"+" "+Project_name);
			}
			else
			{
				 failedDescription("user is not able to search the project successfully with name as"+" "+Project_name);
			}
		  
	}
	
	public void ProjectValidateandPublish(String configname,String Project_name) {
		 
		//Project Validate
		   test.log(Status.INFO, "Click on the validate button on top right corner of the work center");
		  functionalcomponents.WaitTillTime(2000);
          functionalcomponents.ClickOperation(properties.getProperty("validate"));
		  functionalcomponents.WaitTillTime(1000);
		  String validate_msg=driver.findElement(By.xpath(properties.getProperty("Validate_msg"))).getText();
		  System.out.println(validate_msg);
		  if (validate_msg.equalsIgnoreCase("Project Validation Successful"))
		  {
          test.log(Status.PASS, "user is able to validate the project"+":"+Project_name+"successfully");
		  } else
		  {
          failedDescription("user is not able to validate the project"+":"+Project_name+"successfully");
          }
		   
		  //Publish
		  test.log(Status.INFO, "Click on the publish button on top right corner of the work center");
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("Publish"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edge_configuration_name"), 70);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Edge_configuration_name"), configname);
		  functionalcomponents.WaitTillTime(4000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_publish"));
		  functionalcomponents.WaitTillTime(500);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("publish_msg"), 70);
		  String publish_msg=driver.findElement(By.xpath(properties.getProperty("publish_msg"))).getText();
		  System.out.println(publish_msg);
		  functionalcomponents.WaitTillTime(10000);
		  if (publish_msg.equalsIgnoreCase("Project published successfully"))
		  {
          test.log(Status.PASS, "user is able to publish the project with configuration name as"+":"+configname+"successfully");
		  } else
		  {
          failedDescription("user is able to see te message Configuration name must be unique");
      }
		
	}

	// Creating persistence config by data retention query
	public void CreatePersistenceConfigbydataretetionQuery(String persistenceConfigName, String JsonQuery) throws Exception {
		test.log(Status.INFO, "Select services and navigate to persistence Services");
		functionalcomponents.WaitTillTime(5000);				
		functionalcomponents.ClickOperation(properties.getProperty("policy_Services"));
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("Policy_PersistenceServices"));
		functionalcomponents.WaitTillTime(5000);
		if (driver.findElement(By.xpath(properties.getProperty("ServiceConfiguration"))).isDisplayed())
		{
              test.log(Status.PASS, "persistence service screen is opened successfully");
		} else 
		{
              failedDescription("Persistence service screen not opend");
        } 
	  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceADDConfiguration"), 50); 
	  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), persistenceConfigName);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery);
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Configsearchfromlist"),persistenceConfigName);
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("SearchConfigbutton"));
	  functionalcomponents.WaitTillTime(10000);
	  
	  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
	  {
			 test.log(Status.PASS, "user is able to creat persistence configuration successfully"+persistenceConfigName);
	  }
	  else
		{
			 failedDescription("user is able to add persistence configuration successfully");
		}
	
	} 
	
	public void PersistenceConfigDeployment(String configname,String Gatewayno) {
		  test.log(Status.INFO, "Click on the SAP logo>>Gageway management to add the configuration");
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("searchbutton"), 70);
		  if(driver.findElement(By.xpath(properties.getProperty("searchbutton"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user should able to click on the Gateway management successully");
		  } else
		  {
            failedDescription("user is not able to click on the Gateway Management successully");
        }
		  test.log(Status.INFO, "Search for the Gageway number  to add Streaming Service and Configuration");
		 
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),Gatewayno);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(20000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+Gatewayno+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.WaitTillTime(20000);
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("persistenceservicecore"));
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
		  } else
		  {
            failedDescription("user should able to add the configuration with name as"+" "+configname+" "+"not successfully");
        }
		  test.log(Status.INFO, "Click on the Refresh button untill status becomes Applied");
		  functionalcomponents.WaitTillTime(10000);	
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),configname);
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
		  for(int i=0; i<=50; i++) {
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(10000);
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
			  if(ele1.getText().equalsIgnoreCase("Applied"))
				{
				  break;
			  }
			  else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
				{
				  break;
			  }
		  }	
		  
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
		  String text2= ele1.getText();
		  System.out.println(text2); 
			if(text2.equalsIgnoreCase("Applied"))
			{
				 test.log(Status.PASS, "configuration Applied successfully");
			}
			else
			{
				 failedDescription("Applied failed message will be displyed");
			}
		  
	}
	
	public void DeleteProject(String Project_name )
	{
		test.log(Status.INFO, "Search  the project and delete sucessfully");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile")); 	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_search_input"), 90);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Project_name);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(12000);
		  //String Projectname1=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "project_name");
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Project_name+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.ClickOperation(properties.getProperty("Delete_project"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Delet_project_popup"));
		  functionalcomponents.WaitTillTime(20000);
		  if(driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
		  {
				 test.log(Status.PASS, "project successfully deleted with name was"+" "+Project_name);
			}
			else
			{
				 failedDescription("project is not deleted successfully");
			}
		  
		
	}
	

}
