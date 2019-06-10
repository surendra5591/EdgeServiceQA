package PolicyService;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class PolicyEdgedesignercomponent extends BaseTest {
	Properties properties = functionalcomponents.getObjectProperties();
	//Policy_Edgedesignercomponent edgecomponent=new Policy_Edgedesignercomponent();
	public void ProjectValidatePublish_ConfigDeployment(String configname,String Project_name, String Gatewayno)
	{
			test.log(Status.INFO, "Click on the validate button on top right corner of the work center");
		  //functionalcomponents.WaitTillTime(2000);
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
		 // System.out.println(publish_msg);
		  if (publish_msg.equalsIgnoreCase("Project published successfully"))
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
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateway_management"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
		  functionalcomponents.WaitTillTime(5000);
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
		  functionalcomponents.WaitTillTime(3000);
		  //functionalcomponents.scrollToExact(properties.getProperty("Request_deploy"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
		  functionalcomponents.WaitTillTime(70000);
		  
		  for(int i=0; i<=10; i++) {
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(15000);
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
			  if(ele1.getText().equalsIgnoreCase("Activated"))
				{
				  break;
			  }
		  }
		  
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
		  String text2= ele1.getText();
		  System.out.println(text2);
		    
			if(text2.equalsIgnoreCase("Activated"))
			{
				 test.log(Status.PASS, "configuration activated successfully");
			}
			else
			{
				 failedDescription("configuration is not activated");
			}
		  
		  test.log(Status.INFO, "Click on the SAP logo>>Edge designer tile and search for the project");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile")); 	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_search_input"), 90);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Project_name);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(15000);
		  //String Projectname1=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "project_name");
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Project_name+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(5000);
		  if(driver.findElement(By.xpath(properties.getProperty("Sensor_Model"))).isDisplayed())
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
		  if (publish_msg.equalsIgnoreCase("Project published successfully"))
		  {
          test.log(Status.PASS, "user is able to publish the project with configuration name as"+":"+configname+"successfully");
		  } else
		  {
          failedDescription("user is able to see te message Configuration name must be unique");
      }
		
	}
	
	public void ConfigDeployment(String configname,String Project_name, String Gatewayno) {
		  test.log(Status.INFO, "Click on the SAP logo>>Gageway management to add the configuration");
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateway_management"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
		  functionalcomponents.WaitTillTime(5000);
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
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configname+properties.getProperty("config_value_part2")));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		  functionalcomponents.WaitTillTime(50000);	
		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+configname+" "+"successfully");
		  } else
		  {
            failedDescription("user should able to add the configuration with name as"+" "+configname+" "+"not successfully");
        }
		  test.log(Status.INFO, "Click on the Refresh button untill status becomes Activated");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),configname);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		  functionalcomponents.WaitTillTime(5000);  
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
		  functionalcomponents.WaitTillTime(3000);
		  //functionalcomponents.scrollToExact(properties.getProperty("Request_deploy"));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
		  functionalcomponents.WaitTillTime(20000);
		  
		  for(int i=0; i<=10; i++) {
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(15000);
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
			  if(ele1.getText().equalsIgnoreCase("Activated"))
				{
				  break;
			  }
		  }
		  
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configname+properties.getProperty("Activated_msgpart2")));
		  String text2= ele1.getText();
		  System.out.println(text2);
		    
			if(text2.equalsIgnoreCase("Activated"))
			{
				 test.log(Status.PASS, "configuration activated successfully");
			}
			else
			{
				 failedDescription("configuration is not activated");
			}
		  
		  test.log(Status.INFO, "Click on the SAP logo>>Edge designer tile and search for the project");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
		  functionalcomponents.WaitTillTime(5000); 	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_search_input"), 70);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Project_name);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  //String Projectname1=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "project_name");
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Project_name+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(3000);
		  if(driver.findElement(By.xpath(properties.getProperty("Sensor_Model"))).isDisplayed())
		  {
				 test.log(Status.PASS, "user should able to search the project successfully with name as"+" "+Project_name);
			}
			else
			{
				 failedDescription("user is not able to search the project successfully with name as"+" "+Project_name);
			}
	}

}
