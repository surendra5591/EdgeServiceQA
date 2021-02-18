package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GlobalOutboundConnectorCreationUpdationandDelete extends BaseTest {
	
	    Properties properties = functionalcomponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String OutboundConnectorTypeName="";
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");

	    String ConnectorName = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Plugin_name");
		String Class  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Class");
		String LoggerLevel  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "LoggerLevel");
		String URI  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "URI");
		String BasicAuthUsername  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "BasicAuthUsername");
		String BasicAuthPassword  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "BasicAuthPassword");
		String Workspace  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Workspace");
		String Project  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Project");
		String InputStream  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "InputStream");
	    String MaximumQueueSize=functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "MaximumQueueSize");
		
	    @Test
	    public void CreateOutboundConnector()
	    {
	    	 ConnectorName="Global"+ConnectorName+CurrentDateandTime;
	    	 test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the EdgeDesigner Tile");
	 		 driver.get(PolicyServiceURL);
	 		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
			 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
			 functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
			 functionalcomponents.WaitTillTime(7000);
	 		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 200); 
	 		 functionalcomponents.WaitTillTime(2000);
	 		 if(driver.findElement(By.xpath(properties.getProperty("Edgedesigner_tile"))).isDisplayed())
			 {
				 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
			 }
			 else 
			 {
				failedDescription("user is able to enter into the HOME page ");
			 }
	 		 test.log(Status.INFO, "Click on outbound connectors link and click the + Symbol to add the new outbound connector");
	 		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
	 		 functionalcomponents.WaitTillTime(30000);
	 		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GlobalOutBoundConnectorlink"), 90); 
	 		 functionalcomponents.WaitTillTime(2000);
	 		 functionalcomponents.ClickOperation(properties.getProperty("GlobalOutBoundConnectorlink"));
	 		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddGlobalOutBoundConnector"), 90); 
	 		 functionalcomponents.WaitTillTime(7000);
	 		 if (driver.findElement(By.xpath(properties.getProperty("AddGlobalOutBoundConnector"))).isDisplayed())
	 		  {
	 	         test.log(Status.PASS, "user is able to see Add Global Outbound Connector window successfully");
	 		  } else
	 		  {
	 	         failedDescription("user is not able to see the  Add Global Outbound Connector window ");
	 	      }
	 		 functionalcomponents.ClickOperation(properties.getProperty("AddGlobalOutBoundConnector"));
	 		 functionalcomponents.WaitTillTime(5000);
	 		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 70);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"), ConnectorName); 
			  functionalcomponents.WaitTillTime(2000);			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class+properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.WaitTillTime(5000);
			  int MaximumQueueSizevalue=Integer.parseInt(MaximumQueueSize);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), MaximumQueueSize); 
			  functionalcomponents.WaitTillTime(2000); 
			//validate Reliable messaging: Enterprise plugins creation
			  if(MaximumQueueSizevalue<128) {
				  
				 failedDescription("user is able to edit Maximum Queue size but appropriate error message is displayed like enter a number greater than or equal to 128 and user can not create SDS Enterprise Plugin");  
			  }
			  else if(MaximumQueueSizevalue>=128)
			  {
				  test.log(Status.PASS, "user is able to edit Maximum Queue size and enter new vlue"+MaximumQueueSizevalue+" By default it should be in MB");
			  } else
			  {
	              failedDescription("user is not able to edit Maximum Queue size");
		 
			  }
			  test.log(Status.INFO, "Enter all Outbound Connector parameters field and click create button");
			  functionalcomponents.ClearAndSetValue(properties.getProperty("WebSocketURI"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthUsername"), BasicAuthUsername); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthPassword"), BasicAuthPassword); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSWorkSpace"), Workspace); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSProject"), Project); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSInputStream"), InputStream); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.WaitTillTime(10000);
			  String Outboundconnectorname=driver.findElement(By.xpath("//div[@class='sapUiRGLContainer sapUiFormContainerTitle']//span[contains(text(),'"+ConnectorName+"')]")).getText();
			  if(Outboundconnectorname.equalsIgnoreCase(ConnectorName))
			  {
				  test.log(Status.PASS, "user is able to create the Global Outbound connector name as:"+ConnectorName);		  }
			  else
			  {
	              failedDescription("user is not able to create the Global Outbound connector ");
	          }	
	    }
	   
	    @Test (priority=2, dependsOnMethods = {"CreateOutboundConnector"})
	    public void Edit_Update_Save_OutboundConnector() {
	    	  test.log(Status.INFO, "Edit any Outbound Connector parameters field and click save button");
	    	  functionalcomponents.ClickOperation(properties.getProperty("EditOutBoundConnectorbutton"));
			  functionalcomponents.WaitTillTime(6000);
	    	  functionalcomponents.ClearAndSetValue(properties.getProperty("OutboundConnectorDescription"), "UpdatedOutboundConnector"); 
			  functionalcomponents.WaitTillTime(2000);	
			  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
			  functionalcomponents.WaitTillTime(7000);
			  String Outboundconnectorname=driver.findElement(By.xpath("//div[@class='sapUiRGLContainer sapUiFormContainerTitle']//span[contains(text(),'"+ConnectorName+"')]")).getText();
			  if(Outboundconnectorname.equalsIgnoreCase(ConnectorName))
			  {
				  test.log(Status.PASS, "user is able to Update the Global Outbound connector name as:"+ConnectorName);		  }
			  else
			  {
	              failedDescription("user is not able to Update the Global Outbound connector ");
	          }	
			  
	    	
	    }
	    @Test (priority=3)
	  public void DeleteOutboundConnector()
	  {
	    	  test.log(Status.INFO, "Select Created Outbound Connector and click Delete button");
	    	  functionalcomponents.ClickOperation(properties.getProperty("GlobalOutboundRefreshButton"));
			  functionalcomponents.WaitTillTime(7000);
	    	  functionalcomponents.ClearAndSetValue(properties.getProperty("GlobalOutboundSearchinput"), ConnectorName); 
			  functionalcomponents.WaitTillTime(2000);	
			  functionalcomponents.ClickOperation(properties.getProperty("GlobalOutboundSearchbutton"));
			  functionalcomponents.WaitTillTime(7000);
	    	  functionalcomponents.ClickOperation("//span[@title='"+ConnectorName+"']//span[@class='sapMLabelTextWrapper']");
			  functionalcomponents.WaitTillTime(6000);
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteGlobalOutboundconnectorbutton"));
			  functionalcomponents.WaitTillTime(3000);
		   	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		 	  functionalcomponents.WaitTillTime(7000);
		 	 if (driver.findElement(By.xpath(properties.getProperty("AddGlobalOutBoundConnector"))).isDisplayed())
			  {
		 		test.log(Status.PASS, "user is able to Delete Global Outbound Connector:"+ConnectorName);
			  } else
			  {
		        failedDescription("user is not able to Delete Global Outbound Connector");
		      }
	  }
}
