package EdgeServiceComponents;

import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import UtilityComponent.FunctionalComponents;
import UtilityComponent.RestAssuredComponents;

public class EdgeServiceFunctions extends BaseTest {
	
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	Properties properties = FunctionalComponents.getObjectProperties();
	
	public void LoginPolicyservice_MovetoEdgeServicemanagmentTile(String PolicyServiceURL, String username, String password)
	{
		 test.log(Status.INFO, "open URL:"+PolicyServiceURL+"Login successfully into the policyservice and click on the  Edge Service Management Tile");
		 driver.get(PolicyServiceURL);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policyservice_name"), 50);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policyservice_pwd"), 20);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Policyservice_login"), 20);
		 functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
	   	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("EdgeServiceManagementTile")))
	   	 {
	   		test.log(Status.PASS, "user is able to enter into the HOME page successfully");
	   	 }
	   	 else 
	   	{
	   		failedDescription("user is able to enter into the HOME page ");
	   	} 
		     
		test.log(Status.INFO, "click on the Edge Service management Tile");
		functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Group_Add_button"), 200); 
		 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Group_Add_button")))
		{
           test.log(Status.PASS, "Edge Service manaagement Tile is opened successfully");
		} 
		else 
		{
           failedDescription("Edge Service manaagement Tile is not opened");
		} 
	}
	public void LoginPolicyservice_MovetoEdgeDesignerTile(String PolicyServiceURL, String username, String password)
	{
		 test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  Edge Designer Tile");
		 driver.get(PolicyServiceURL);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policyservice_name"), 50);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		 functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 90);
		 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Edgedesigner_tile")))
		 {
			 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
		 }
		 else 
		 {
			failedDescription("user is able to enter into the HOME page ");
		 }
		     
		test.log(Status.INFO, "click on the edge designer tile window");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 90);
		functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90);
		functionalcomponents.WaitTillTime(10000);
		 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Project_Addbutton")))
		 {
           test.log(Status.PASS, "EdgeDesigner tile is opened successfully");
		} 
		else 
		{
           failedDescription("EdgeDesigner tile is not opened");
		} 
	}
	
	public void StreamingConfigDeploymenttoGateway(String configname, String Gatewayno)
	{
		 //Deploy configuration
		  test.log(Status.INFO, "Add the configuration to the gateway and do the deployement"); 
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configname+properties.getProperty("config_value_part2")));
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		  functionalcomponents.WaitTillTime(10000);	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("config_refresh_btn")))
		  {
			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+configname+" "+"successfully");
		  } else
		  {
	          failedDescription("user should able to add the configuration with name as"+" "+configname+" "+"not successfully");
	      }
		  
		  test.log(Status.INFO, "Click on the Refresh button untill status becomes Applied");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900); 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),configname);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
		  for(int i=0; i<=15; i++) {
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(15000);
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
				 test.log(Status.PASS, configname+"configuration Applied successfully");
			}
			else
			{
				 failedDescription(configname+"is failed to applied, message is displyed");
			}
		 
		  
	}
	
	
	   // Creating persistence config by data retention query
	    public void CreatePersistenceConfigbydataretetionQuery(String persistenceConfigName, String JsonQuery) throws Exception {
		test.log(Status.INFO, "Select services and navigate to persistence Services page");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policy_Services"), 50); 
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("policy_Services"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Policy_PersistenceServices"), 50);
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("Policy_PersistenceServices"));
		//functionalcomponents.WaitTillTime(5000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration_Tab"), 50);
		if (driver.findElement(By.xpath(properties.getProperty("ServiceConfiguration_Tab"))).isDisplayed())
		{
              test.log(Status.PASS, "persistence service screen is opened successfully");
		} else 
		{
              failedDescription("Persistence service screen not opend");
        } 
	  test.log(Status.INFO, "Click on the Add configuration button i.e, + button in the work center");
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration_Tab"), 50);
	  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceADDConfiguration"), 50); 
	  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceconfigurationName"), 50);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), persistenceConfigName);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("DataRetention"), 50);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("PersistenceConfigAdd_Button"), 50);
	  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Configsearchfromlist"), 50);
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Configsearchfromlist"),persistenceConfigName);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SearchConfigbutton"), 50);
	  functionalcomponents.ClickOperation(properties.getProperty("SearchConfigbutton"));
	  functionalcomponents.WaitTillTime(5000);
	  if(driver.findElement(By.xpath("//a[@title='"+persistenceConfigName+"']")).isDisplayed())
	  {
			 test.log(Status.PASS, "user is able to creat persistence configuration successfully"+persistenceConfigName);
	  }
	  else
		{
			 failedDescription("user is able to add persistence configuration successfully");
		}
	
	} 
	
	      public void PersistenceConfigDeploymenttoGateway(String configname) {
		  test.log(Status.INFO, "Click on Gateway configuration tab and  add the configuration to gateway");
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Config_Addbutton"), 50);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("services_dropdown"), 50);
		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceservicecore"), 50);
		  functionalcomponents.ClickOperation(properties.getProperty("persistenceservicecore"));
		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configname+properties.getProperty("config_value_part2")));
		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
		  functionalcomponents.WaitTillTime(50000);	
		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to add the configuration with name as"+" "+configname+" "+"successfully");
		  } else
		  {
            failedDescription("user is not able to add the configuration with name as"+" "+configname+" "+"not successfully");
          }
		  test.log(Status.INFO, "Click on the Refresh button untill status becomes Applied");	
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),configname);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_search_button"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
		  for(int i=0; i<=20; i++) {
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
	      
	      public void ProjectValidateandPublish(String configname,String Project_name)
	    	{
	    	  //validate project
	    	  test.log(Status.INFO, "Click on the validate button on top right corner of the work center");
	    	  functionalcomponents.ClickOperation(properties.getProperty("validate"));
	    	  functionalcomponents.WaitTillTime(9000);
	    	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Publish")))
	    	  {
	            test.log(Status.PASS, "user is able to validate the project"+":"+Project_name+"successfully");
	    	  } else
	    	  {
	            failedDescription("user is not able to validate the project"+":"+Project_name+"successfully");
	          }	
	    	  //Publish project
	    	  test.log(Status.INFO, "Click on the publish button on top right corner of the work center");
	    	  functionalcomponents.WaitTillTime(7000);
	    	  functionalcomponents.ClickOperation(properties.getProperty("Publish"));
	    	  functionalcomponents.WaitTillTime(7000);
	    	  functionalcomponents.ClearAndSetValue(properties.getProperty("Edge_configuration_name"), configname);
	    	  functionalcomponents.WaitTillTime(3000);
	    	  functionalcomponents.ClickOperation(properties.getProperty("config_publish"));
	    	  functionalcomponents.WaitTillTime(20000);	
	    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SAP_logo"), 90); 
	    	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("SAP_logo")))
	    	  {
	            test.log(Status.PASS, "user is able to publish the project with configuration name as"+":"+configname+"successfully");
	    	  } else
	    	  {
	            failedDescription("user is not able to publish project");
	          }
	   }      
	
	public void DeleteProject(String Projectname )
	{
		  test.log(Status.INFO, "Search  the project and delete selected project from list");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile")); 	
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 90);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("ProjectSearchinput"),Projectname);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectname+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(20000);
		  functionalcomponents.ClickOperation(properties.getProperty("Delete_project"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		  functionalcomponents.WaitTillTime(15000);
		  if(driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
		  {
				 test.log(Status.PASS, "project successfully deleted from list with name was"+" "+Projectname);
		  }
			else
			{
				 failedDescription("project is not deleted successfully");
			}
		  
	}
	
	 public void MovetoHomePageSearchProject(String ProjectName)
     {
	  test.log(Status.INFO, "Click on the SAP logo>>Edge designer tile and search for the project");
	  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 90);
	  functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile")); 	
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 90);
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("ProjectSearchinput"),ProjectName);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
	  functionalcomponents.WaitTillTime(15000);
	  //String Projectname1=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "project_name");
	  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
	  functionalcomponents.WaitTillTime(5000);
	  if(driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
	  {
			 test.log(Status.PASS, "user should able to search the project successfully with name as"+" "+ProjectName);
		}
		else
		{
			 failedDescription("user is not able to search the project successfully with name as"+" "+ProjectName);
		}
    }
  
     public void MovetoEdgeServiceManagment_SearchGateway(String GateWayNo)
      {
  	  test.log(Status.INFO, "Click on the SAP logo>>Edge managment tile and search for the gateway");
  	  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
  	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
	  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("searchbutton"), 200);
	  if(driver.findElement(By.xpath(properties.getProperty("searchbutton"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user should able to click on the Gateway management successully");
	  } else
	  {
      failedDescription("user is not able to click on the Gateway Management successully");
      }
	  test.log(Status.INFO, "Search for the Gageway number  to add Service and Configuration");
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
	  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SAP_logo"), 200);
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateway_GeneralSettingsTab"), 90);
	  functionalcomponents.ClickOperation(properties.getProperty("Gateway_GeneralSettingsTab"));	
  	  if(driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
  	  {
  			 test.log(Status.PASS, "user should able to search the gateway successfully as"+" "+GateWayNo);
  	   }
  		else
  		{
  			 failedDescription("user is not able to search the gateway successfully as"+" "+GateWayNo);
  		}
    }      

      public void MovetoServicepage()
      {  
      test.log(Status.INFO, "Click on the SAP logo>> and move to home page and click on edge service managment tile");
   	  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));	
   	  functionalcomponents.WaitTillTime(5000);
   	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
 	  functionalcomponents.WaitTillTime(5000);
 	  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
 	  functionalcomponents.WaitTillTime(30000);
 	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("services_button"), 70);
 	  if(driver.findElement(By.xpath(properties.getProperty("services_button"))).isDisplayed())
 	  {
 		  test.log(Status.PASS, "user is able to click on the Gateway management tile successully");
 	  } 
 	  else
 	   {
       failedDescription("user is not able to click on the Gateway Management successully");
       }
 	  test.log(Status.INFO, "Move to Service page");
 	  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
	  functionalcomponents.WaitTillTime(10000);
   	  if(driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
   	   {
   			 test.log(Status.PASS, "user is able to move service page successfully");
   	   }
   	  else
   		{
   			 failedDescription("user is not able to move service page successfully");
   		}
     } 
      
      public void FreshPageandselectProject(String ProjectName)
      {
    	  driver.navigate().refresh();			
		  functionalcomponents.WaitTillTime(15000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 700);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("ProjectSearchinput"),ProjectName);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(10000);	
     }
      
      public void StreamingServiceInstallationtoGateway(String GateWayNo){
    	  String Rownumber="";
    	  String Servicestatus=""; 
    	  functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
    	  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
    	  functionalcomponents.WaitTillTime(10000); 
    	//Adding Streaming service if not installed to gateway
    	  if (!functionalcomponents.IsElementPresent(properties.getProperty("StreamingServiceinstalledRow") ))
    		  {	 
    	  test.log(Status.INFO, "Add the services to the group by clicking the + button");
    	  functionalcomponents.WaitTillTime(1000);
    	  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
    	  functionalcomponents.WaitTillTime(2000);
    	  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);		  
    	  functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
    	  functionalcomponents.WaitTillTime(2000);			  
    	  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
    	  functionalcomponents.WaitTillTime(25000);
    	  for(int i=1; i<40; i++)
    	  {
    	  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
    	  functionalcomponents.WaitTillTime(30000);  
    	  Rownumber=driver.findElement(By.xpath(properties.getProperty("StreamingServiceinstalledRow"))).getAttribute("data-sap-ui-rowindex");
    	  Servicestatus=driver.findElement(By.xpath("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col2']//span[@class='sapMLabelTextWrapper']//bdi")).getText();
    	  if(Servicestatus.equalsIgnoreCase("Installed"))
    		  break;
    	  }
    	   if(Servicestatus.equalsIgnoreCase("Installed"))
    		  {
    			  test.log(Status.PASS, "Streaming service installed successfully to gateway:"+GateWayNo);
    			  
    		  }
    	   else if(Servicestatus.equalsIgnoreCase("Error")){
    		     failedDescription("Streaming service status is Error");
    		   }
    		  else
    		  {
    			  failedDescription("Streaming service is not installled");
    		  }
    	 }
    	  else
		  {
    	   test.log(Status.PASS, "Streaming service is already installed to gateway:"+GateWayNo);
		  }
    	  
    	  
      }
      
      public void PersistenceServiceInstallationtoGateway(String GateWayNo){
    	  String Rownumber="";
    	  String Servicestatus=""; 
    	  functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
    	  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
    	  functionalcomponents.WaitTillTime(10000); 
    	  //Adding Persistence service to gateway if not installed to gateway
    	  if (!functionalcomponents.IsElementPresent(properties.getProperty("PersistenceServiceinstalledRow") ))
    		  {	 
    	  test.log(Status.INFO, "Add the services to the group by clicking the + button");
    	  functionalcomponents.WaitTillTime(1000);
    	  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
    	  functionalcomponents.WaitTillTime(2000);
    	  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Persistance_service"), 50);		  
    	  functionalcomponents.ClickOperation(properties.getProperty("Persistance_service"));
    	  functionalcomponents.WaitTillTime(2000);			  
    	  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
    	  functionalcomponents.WaitTillTime(25000);
    	  for(int i=1; i<40; i++)
    	  {
    	  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
    	  functionalcomponents.WaitTillTime(30000);  
    	  Rownumber=driver.findElement(By.xpath(properties.getProperty("PersistenceServiceinstalledRow"))).getAttribute("data-sap-ui-rowindex");
    	  Servicestatus=driver.findElement(By.xpath("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col2']//span[@class='sapMLabelTextWrapper']//bdi")).getText();
    	  if(Servicestatus.equalsIgnoreCase("Installed"))
    		  break;
    	  }
    	   if(Servicestatus.equalsIgnoreCase("Installed"))
    		  {
    			  test.log(Status.PASS, "Persistence service installed successfully to gateway:"+GateWayNo);
    			  
    		  }
    	   else if(Servicestatus.equalsIgnoreCase("Error")){
    		     failedDescription("Persistence service status is Error");
    		   }
    		  else
    		  {
    			  failedDescription("Persistence service is not installled");
    		  }
      }
      else
		  {
    	   test.log(Status.PASS, "Persistence service is already installed to gateway:"+GateWayNo);
		  }
    	   
      }
      
  public void EBFServiceInstallationtoGateway(String GateWayNo){
	  String Rownumber="";
	  String Servicestatus=""; 
	  functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
	  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
	  functionalcomponents.WaitTillTime(10000); 
	  //Adding EBF service to gateway if not installed
	  if (!functionalcomponents.IsElementPresent(properties.getProperty("EBFServiceinstaledRow") ))
	 {	 
	  test.log(Status.INFO, "Add the services to the group by clicking the + button");
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service"), 50);		  
	  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service"));
	  functionalcomponents.WaitTillTime(2000);			  
	  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
	  functionalcomponents.WaitTillTime(25000);
	  for(int i=1; i<40; i++)
	  {
	  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
	  functionalcomponents.WaitTillTime(30000);  
	  Rownumber=driver.findElement(By.xpath(properties.getProperty("EBFServiceinstaledRow"))).getAttribute("data-sap-ui-rowindex");
	  Servicestatus=driver.findElement(By.xpath("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col2']//span[@class='sapMLabelTextWrapper']//bdi")).getText();
	  if(Servicestatus.equalsIgnoreCase("Installed"))
		  break;
	  }
	   if(Servicestatus.equalsIgnoreCase("Installed"))
		  {
			  test.log(Status.PASS, "EBF service installed successfully to gateway:"+GateWayNo);
			  
		  }
	   else if(Servicestatus.equalsIgnoreCase("Error")){
		     failedDescription("EBF service status is Error");
		   }
		  else
		  {
			  failedDescription("EBF service is not installled");
		  }
	}
   else
	  {
	   test.log(Status.PASS, "EBF service is already installed to gateway:"+GateWayNo);
	  } 
  }
      
  public void VerifyGatewayStatus_SetEdgeConsolePasswordtoGateway(String EdgeConsolePassword, String GateWayNo)
      {
	  test.log(Status.INFO, "Click on Gateway managment tile and serach gateway verify status of gateway");	
	  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
	  functionalcomponents.WaitTillTime(15000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 200);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
	  functionalcomponents.WaitTillTime(15000);
		test.log(Status.INFO, "Verify Gateway is online");
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("GatewayStatusonline")))
		{
			test.log(Status.PASS, "Gateway Status is Online");	
		}
		else
		  {
			  failedDescription("Gateway is offline we can not work on this gateway");
		  }	
		 //Add Edge Console Password Property
		  test.log(Status.INFO, "add the Edge Console Password configuration Property to Gateway");
		  if (!functionalcomponents.IsElementPresent("//span[@title='Edge_Console_Password']"))
		 {	  
		  functionalcomponents.ClickOperation(properties.getProperty("AddPropertytoGWButton"));
		  functionalcomponents.WaitTillTime(3000);
		  String Rownum =driver.findElement(By.xpath("//bdi[text()='Edge_Console_Password']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
		  driver.findElement(By.xpath("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[@title='Click to Select']")).click();
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("EdgeConsolePassword_Input"), EdgeConsolePassword);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("AddConfigpropertybutton"));
		  functionalcomponents.WaitTillTime(10000);
		  if(functionalcomponents.IsElementPresent(properties.getProperty("SAP_logo")))
		  {
			  test.log(Status.PASS, "user is able to add the Edge Console Password configuration Property to Gateway as:"+" "+EdgeConsolePassword+" "+"successfully");
		  } else
		  {
	          failedDescription("user is not able to add the Edge Console Password configuration Property to Gateway");
	      }
		 } 
		  else {
			  functionalcomponents.ClickOperation(properties.getProperty("EditPropertytoGateway"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClearAndSetValue("//span[@title='Edge_Console_Password']//ancestor::tr//td//input", EdgeConsolePassword);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
			  functionalcomponents.WaitTillTime(10000);
		    }
		  
      }
  public void Adding_BackendtimezonepropertytoGateway(String GateWayNo)
  {
	// Add Backend_Timezone_Offset_Minutes Configuration property to gateway
	  test.log(Status.INFO, "Serach gateway and add the Backend_Timezone_Offset_Minutes Configuration property to gateway");	
	  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
	  functionalcomponents.WaitTillTime(15000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 200);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
	  functionalcomponents.WaitTillTime(15000);
	  if (!functionalcomponents.IsElementPresent("//span[@title='Backend_Timezone_Offset_Minutes']"))
	  {	  
		  functionalcomponents.ClickOperation(properties.getProperty("AddPropertytoGWButton"));
		  functionalcomponents.WaitTillTime(3000);
		   if (functionalcomponents.IsElementPresent("//bdi[text()='Backend_Timezone_Offset_Minutes']"))
			{
			  String Rownum =driver.findElement(By.xpath("//bdi[text()='Backend_Timezone_Offset_Minutes']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
			   functionalcomponents.ClearAndSetValue(properties.getProperty("Backend_Timezone_Offset_Minutes_InputValue"),"5");
			   test.log(Status.PASS, "user is able to enter the value for Backend_Timezone_Offset_Minutes Configuration property");
			}
		    else
		      {
			   failedDescription("Backend_Timezone_Offset_Minutes property is not available to table list");
		      }
		      functionalcomponents.ClickOperation(properties.getProperty("AddConfigpropertybutton"));
			  functionalcomponents.WaitTillTime(10000);
			  if(functionalcomponents.IsElementPresent(properties.getProperty("SAP_logo")))
			  {
				  test.log(Status.PASS, "user is able to add the Backend_Timezone_Offset_Minutes configuration Property to Gateway successfully");
			  } else
			  {
		          failedDescription("user is not able to add the Backend_Timezone_Offset_Minutes configuration Property to Gateway successfully");
		      }
	}
	  else
	  {
		  test.log(Status.PASS, "Backend_Timezone_Offset_Minutes Configuration property already added to gateway level");
	  }
  }
  
}

