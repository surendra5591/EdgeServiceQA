package EdgeServices;

import java.io.File;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class EBFServiceConfigCreationwithFSMandPSM_PlantActivation_ConfigDeploytoGatewaywithPlantID extends BaseTest  {
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
	Properties properties = FunctionalComponents.getObjectProperties();
	
	//Prerequisites 1. Gateway should up and online status.
	// 3. EBF cloud sync service should be connected successfully 
	// 4. LDAP properties should not be added to gateway level
	
	
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
    String EBFConfigName="";
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
    String InvalidName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "InvalidName");
    
    String EBFPlantID=functionalcomponents.getdatafromsheet("Cockpit", "EBFServiceTestData", "Plant_ID");
    String PlantDefaultStorageLocation =functionalcomponents.getdatafromsheet("Cockpit", "EBFServiceTestData", "PlantDefaultStorageLocation");
    String PlantDefaultMainWorkCenter =functionalcomponents.getdatafromsheet("Cockpit", "EBFServiceTestData", "PlantDefaultMainWorkCenter");
    String PlantFreightStorageLocation =functionalcomponents.getdatafromsheet("Cockpit", "EBFServiceTestData", "PlantFreightStorageLocation");
    String PlantMainWorkCenterForWorkOrder =functionalcomponents.getdatafromsheet("Cockpit", "EBFServiceTestData", "PlantMainWorkCenterForWorkOrder");
    String EBFPlantstatus="";
    String Rownum="";
    
    @Test
  	 public void CreateEBFConfigurationwithFieldsmaintenceBuisnessModule()
  	 {
    	  edgeservicefunctions.LoginPolicyservice_MovetoEdgeServicemanagmentTile(PolicyServiceURL,username,password);
    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("services_button"), 70);
    	  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70); 
  		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration_Tab"), 50);
  		  if (driver.findElement(By.xpath(properties.getProperty("ServiceConfiguration_Tab"))).isDisplayed()) 
  		  {
  	        test.log(Status.PASS, "user is able to see the EBF services window opened in the work center");
  		  } else
  		  {
  	        failedDescription("user is able to see the EBFservices window opened in the work center ");
  	      } 
  		  
  		  test.log(Status.INFO, "click on the configuration add the configuration to the group by clicking on the + button");
  		  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
  		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
  		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Name_text")))
  	      {
  	        test.log(Status.PASS, "user is able to see the window opened with the options of name and content file from content file");
  		  } else
  		  {
  	        failedDescription("user is not able to see the configuration window");
  	      }
  		  //Add configuration to EBF service by entering Blank fields
  		  test.log(Status.INFO, "Check wheather Without configuration name user is able to create config");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), "");
		  functionalcomponents.ClearAndSetValue(properties.getProperty("EBF_EdgeServerPort"), "123");
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Add_button")))
  	      {
			  test.log(Status.PASS, "user can not add config without entering config name to the EBF service");
			  
		  }
		  else
		  {
			  test.log(Status.FAIL, "user is able to add config without entering config name to the EBF service");
		  }	
		  //Creating EBF(FSM) Config by by entering invalid fields
  		  test.log(Status.INFO, "Enter the invalid configuration name and validate to create config");
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), InvalidName);
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("EBF_EdgeServerPort"), "123");
  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
 		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Add_button")))
 	      {
 			  test.log(Status.PASS, "user can not add config with invalide name to the EBF service");
 			  
 		  }
 		  else
 		  {
 			  test.log(Status.FAIL, "user is able to add config with invalide name to the EBF service");
 		  }	
 		 // validating to create configuration to EBF service by uploading different format/invalid file.
  		  test.log(Status.INFO, "Enter the configuration name and upload the json file");
  		  EBFConfigName="FSMConfig"+CurrentDateandTime;
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), EBFConfigName);
  		  functionalcomponents.ClickOperation(properties.getProperty("uploadEBFconfigfileradiobuttopn"));
  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+File.separator+"Documents"+File.separator+"CSVEnterprisePlugin-3.1909.0-SNAPSHOT.jar");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Add_button")))
  		  {
  			  test.log(Status.PASS, "user can not create the configruation with invalid file format to the EBF service");  
  		  }
  		  else
  		  {
  			  test.log(Status.FAIL, "user is not able to create the configruation with invalid file format to the EBF service");
  		  }	
		  //Creating EBF(FSM) Config by uploading  valid file
  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+File.separator+"Documents"+File.separator+"FSMconfig.json");
  		  functionalcomponents.WaitTillTime(2000);
  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("add_configuration_button"), 50);
  		  functionalcomponents.WaitTillTime(7000);
  		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("add_configuration_button")))
	      {
  			  test.log(Status.PASS, "user is successfully added the configruation as:"+EBFConfigName+" to the EBF service");
  			  
  		  }
  		  else
  		  {
  			  test.log(Status.FAIL, "user is not able to  added the configruation as:"+EBFConfigName+" to the EBF service");
  		  }	
  		 //Creating Duplicate EBF(FSM) Config by copying  exist configuration
  		  test.log(Status.INFO, "verify EBF configuration can not be created with same name");
  		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
		  functionalcomponents.ClickOperation(properties.getProperty("Copyfromconfigradiobutton"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), EBFConfigName);
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Copycontentcontentdropdownvalue"), EBFConfigName);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
  		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Close_Button")))
	      {
			  test.log(Status.PASS, "user can not create config with already exist config name");
			   
		  } else
		  {
			  failedDescription("user is able to create config with already exist config name");
	      }
		  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
		  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
		  //Checking Business Partner ID for EBF service while creating a configuration with field service management business module name
		  test.log(Status.INFO, "Search EBF Config and move to bussince module tab by clicking on EBF Config");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("ConfigurationsearchInput"), EBFConfigName);
		  functionalcomponents.ClickOperation(properties.getProperty("ConfigurationSearchbtn"));
		  functionalcomponents.ClickOperation(properties.getProperty("configurationname_part1")+EBFConfigName+properties.getProperty("configurationname_part2"));
		  functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EBF_BussinessmoduleTab"), 90);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("EBF_FieldServiceManagment")))
	      {
			  test.log(Status.PASS, "user is able to Search EBF Config and move to bussince module tab by clicking on EBF Config");  
		  } else
		  {
			  failedDescription("user is not able to Search EBF Config and move to bussince module tab by clicking on EBF Config");
	      }
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_FieldServiceManagment"));
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_EditBusinessModule"));
		  //validate business id step
		  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
		  //deployment of EBF configuration of field service business module
		  test.log(Status.INFO, "Click on the SAP logo>>Gageway management to add the configuration");
		  functionalcomponents.waittillElementReadytoclickable(properties.getProperty("SAP_logo"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("searchbutton"), 90);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Search_Gateway")))
	      {
			  test.log(Status.PASS, "user should able to click on the Gateway management successully");
		  } else
		  {
              failedDescription("user is not able to click on the Gateway Management successully");
          }
		  test.log(Status.INFO, "Search for the Gageway number  to Click Gateway Configuration tab and  add the configuration to gateway");
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
	      functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
	      functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));	
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("services_dropdown"), 90);
	      functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_servicesvalue"), 90);
	      functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_servicesvalue"));
	      functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_config_save"), 90);
	      functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+EBFConfigName+properties.getProperty("config_value_part2")));
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_config_save"), 30);
	      functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_search_button"), 300);
	      if(functionalcomponents.IsElementDisplayed(properties.getProperty("config_search_button")))
	      {
		  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+EBFConfigName+" "+"successfully");
	      } else
	      {
           failedDescription("user should able to add the configuration with name as"+" "+EBFConfigName+" "+"not successfully");
          }
	      test.log(Status.INFO, "Click on the Refresh button untill status becomes Applied");
	      //functionalcomponents.WaitTillTime(10000);	
	      functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),EBFConfigName);
	      functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
	      for(int i=0; i<=20; i++) {
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
		  functionalcomponents.WaitTillTime(10000);
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+EBFConfigName+properties.getProperty("Activated_msgpart2")));
		  if(ele1.getText().equalsIgnoreCase("Applied"))
			{
			  break;
		  }
		  else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
			{
			  break;
		  }
	  }	
	  
	  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+EBFConfigName+properties.getProperty("Activated_msgpart2")));
	  String text2= ele1.getText();
	  System.out.println(text2); 
		if(text2.equalsIgnoreCase("Applied"))
		{
			 test.log(Status.PASS, "configuration Applied successfully");
		}
		else
		{
			 failedDescription("Config is not Applied successfully");
		}
		   
  	}
		 
        //Prerequisite: Sync Service should be connected successfully  
	    @Test (dependsOnMethods = {"CreateEBFConfigurationwithFieldsmaintenceBuisnessModule"})
	    public void AddPlantstoEBFCloudSyncService()
	    {
	    	test.log(Status.INFO, "Verify EBF Sync Service is intialized as cloud based Synchronization service");
	    	functionalcomponents.ClickOperation(properties.getProperty("services_button"));
			functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EBF_Service_services"), 70); 
			//functionalcomponents.WaitTillTime(7000);
			if(functionalcomponents.IsElementPresent(properties.getProperty("EBFCloudBasedSyncServicelink")))
			{
				 test.log(Status.PASS, "EBF Sync Service is intialized as cloud based Synchronization service");
				 functionalcomponents.ClickOperation(properties.getProperty("EBFCloudBasedSyncServicelink"));
				 functionalcomponents.WaitTillTime(10000);
				 test.log(Status.INFO, "Verify the  EBF Cloud SYnc Service Deploymnet status and  backend connection");
				 if(functionalcomponents.IsElementPresent("//span[text()='Deployed']")&&functionalcomponents.IsElementPresent("//span[text()='Connected']"))
				 {
					 test.log(Status.PASS, "EBF Cloud SYnc Service Deployment status is deployed  and  backend connection is connected sucessfully");
				 }
				 else
				 {
					 failedDescription("EBF Cloud SYnc Service Deploymnet status is not deployed  and  backend connection is not connected");
				 }
				 test.log(Status.INFO, "move to Plants tab of synchronization service and add plants to cloud based sync service");
				 functionalcomponents.ClickOperation(properties.getProperty("EBFSyncServicePlantsTab"));
				 if(functionalcomponents.IsElementPresent("//bdi[text()='"+EBFPlantID+"']")&&functionalcomponents.IsElementPresent("//bdi[text()='Activation Completed']"))
			    {
					 test.log(Status.PASS, EBFPlantID+"-Plant is already added and staus is Activated to EBF Cloud Sync Service");
			    }
				 else
			    {
				 functionalcomponents.ClickOperation(properties.getProperty("AddPlantButton"));
				 String PlantIDRownum =driver.findElement(By.xpath("//bdi[text()='"+EBFPlantID+"']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
				 driver.findElement(By.xpath("//div[@data-sap-ui-rowindex='"+PlantIDRownum+"']//div[@title='Click to Select']")).click();
				 functionalcomponents.WaitTillTime(2000);
				 functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
				 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Plants_refresh_btn"), 200);
		  		 for(int i=1; i<30; i++)
		  		  {
		  		     functionalcomponents.ClickOperation(properties.getProperty("Plants_refresh_btn"));
		  		     functionalcomponents.WaitTillTime(30000);  
		  		     EBFPlantstatus=driver.findElement(By.xpath("//span[@title='"+EBFPlantID+"']//ancestor::tr//td[contains(@id,'col1')]//bdi")).getText();
		  		     functionalcomponents.WaitTillTime(2000);
		  		     System.out.println(EBFPlantstatus);
		  		     if(EBFPlantstatus.equalsIgnoreCase("Activation Completed"))
		  			  break;
		  		   }
		  		      if(EBFPlantstatus.equalsIgnoreCase("Activation Completed"))
		  			  {
		  				  test.log(Status.PASS, EBFPlantID+"-Plant Activated successfully to EBF Cloud Sync Service");
		  				  
		  			  }
		  		      else if(EBFPlantstatus.equalsIgnoreCase("Error"))
		  		      {
		  			     failedDescription(EBFPlantID+"-Plant is not Activated to EBF Cloud Sync Service and plant status is Error");
		  			  }
		  		      else if(EBFPlantstatus.equalsIgnoreCase("Activation Failed"))
		  		      {
		  			     failedDescription(EBFPlantID+"-Plant is not Activated to EBF Cloud Sync Service and plant status is Activation failed");
		  			  }
		  			  else
		  			  {
		  				  failedDescription(EBFPlantID+"-Plant status is unknown to EBF Cloud Sync Service");
		  			  }
			   }
				 // validate conflicts resolution rules 
		  }		  
	       else
			    {
				  failedDescription("EBF Sync Service is not intialized as cloud based Synchronization service please initilize cloud based sync service to proceed EBF plant testing");
		        }   
	    }

    
    
	    //Checking Plant ID for  EBF Sync service and deploy plant maintenance config to gateway
	      @Test (dependsOnMethods = {"AddPlantstoEBFCloudSyncService"})
		  public void CreateEBFConfigurationwithPlantmaintenceBuisnessModule_DeplyedtoGW()
		  {
	     	functionalcomponents.ClickOperation(properties.getProperty("services_button"));
	    	  //Creating EBF(FSM) Configuration by copy exist configurations
		  String EBFPlantConfigName = "PMSConfig"+CurrentDateandTime;
		  test.log(Status.INFO, "verify EBF configuration can be created by copy exist configuration");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70); 
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
		  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
		  //verify delete to deployed configuration
		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Name_text")))
		  {
		     test.log(Status.PASS, "user is able to see the window opened with the options of name and content file from content file");
		  }
		  else
			{
		      failedDescription("user is not able to see the configuration window");
		    }
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), EBFPlantConfigName);
		  functionalcomponents.ClickOperation(properties.getProperty("uploadEBFconfigfileradiobuttopn"));
		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+File.separator+"Documents"+File.separator+"EBFconfigwithPlantmaintence.json");
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("add_configuration_button"), 70);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("add_configuration_button")))
		  {
			  test.log(Status.PASS, "user is able to create config by uploading EBF config with plant maintence business module json file");
			 
		  } else
		  {
			  failedDescription("user is not able to create config by uploading EBF config with plant maintence business module json file");
	      }
		  
		  // Edit EBF service configuration with Plant maintenance business module of Configuration
		  test.log(Status.INFO, "Adding Plant maintenance business module to Configuration");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("ConfigurationsearchInput"), EBFPlantConfigName);
		 
		  functionalcomponents.ClickOperation(properties.getProperty("ConfigurationSearchbtn"));
		
		  functionalcomponents.ClickOperation(properties.getProperty("configurationname_part1")+EBFPlantConfigName+properties.getProperty("configurationname_part2"));
		  
		  functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EBF_BussinessmoduleTab"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_AddBusinessModule_Btn"));
		  functionalcomponents.ClickOperation(properties.getProperty("ChooseBuisnessModuleDropdown"));
		  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("EBF_PlantMaintenanacemodule")))
		  {
			test.log(Status.PASS, "user is able move to bussince module tab and clicked on add new buisness module");   
		  } else
		  {
			  failedDescription("user is not able move to bussince module tab and clicked on add new buisness module");
	      }
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_PlantMaintenanacemodule"));
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_EditBusinessModule"));
		  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("EBF_Service_services")))
		  {
			  test.log(Status.PASS, "user is able to edit EBF service plant maintence buisness module and save successfully");  
		  }
			  else
		  {
			  failedDescription("user is not able to edit EBF service plant maintence buisness module and save successfully");
	      }
		  
		  //Validate to switch between tabs of EBF services
		  test.log(Status.INFO, "switch between tabs of EBF Service and verify the groups and gateways of EBF service");
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
		  functionalcomponents.ClickOperation(properties.getProperty("Services_GroupsTab"));
		  if(functionalcomponents.IsElementPresent(properties.getProperty("SelectFirstRowvalue")))
		  {
			  String Searchinput = driver.findElement(By.xpath(properties.getProperty("SelectFirstRowvalue"))).getText();
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("ServiceTabSearchInputfield"), Searchinput);
	  		  functionalcomponents.ClickOperation(properties.getProperty("TabSearchinputbutton"));
	  		  functionalcomponents.ClickOperation(properties.getProperty("SelectFirstRowvalue"));
	  		 if (driver.findElement(By.xpath(properties.getProperty("Group_Add_button"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to switch to Groups tabs of EBF service and move to first group details page ");
				 
		        
			  } else
			  {
				  failedDescription("user is not able to switch to Groups tabs of EBF service and move to first group details page ");
		      }
		  
	       }
		  test.log(Status.INFO, "switch between tabs of EBF Service and gateways of EBF service");
		  functionalcomponents.ClickOperation(properties.getProperty("policy_Services"));
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
		  functionalcomponents.ClickOperation(properties.getProperty("Services_GatewaysTab"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("ServiceTabSearchInputfield"), GateWayNo);
		  functionalcomponents.ClickOperation(properties.getProperty("TabSearchinputbutton"));
		  functionalcomponents.ClickOperation(properties.getProperty("SelectFirstRowvalue"));
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Gateway_GeneralSettingsTab")))
		  {
			  test.log(Status.PASS, "user is able to switch to Gateways tabs of persistence service and move to first gateway details page ");
		   } else
		   {
			  failedDescription("user is not able to switch to Gateways tabs of persistence service and move to first gateways details page ");
	       }
		   functionalcomponents.ClickOperation(properties.getProperty("Gateway_GeneralSettingsTab"));			   
		   //Removing Plant ID Configuration Property from Gateway if its already added
			 if (functionalcomponents.IsElementPresent("//span[@title='Plant_ID']"))
			 {  
				   test.log(Status.PASS, "Delete Plant ID system Properties from gateway for Deploy EBF Configuration without adding Plant maintenance business module");
				   functionalcomponents.ClickOperation(properties.getProperty("EditPropertytoGateway"));
				   functionalcomponents.ClickOperation(properties.getProperty("DeletePlantIDbutton"));
				   functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
				   functionalcomponents.WaitTillTime(10000);
					  if (!functionalcomponents.IsElementPresent("//span[@title='Plant_ID']"))
					  {
							test.log(Status.PASS, "user is able to Remove Plant ID system Properties from gateway:"+GateWayNo);
					  } else
						  
					  {
					       failedDescription("user is not able to Remove Plant ID system Properties from gateway:"+GateWayNo);
					  }
			  }
		   
		 //Apply Plant maintains EBF Config to gateway without adding Plant ID Configuration Properties to Gateway
		   if (!functionalcomponents.IsElementPresent("//span[@title='Plant_ID']"))
			{  
			    functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
			    functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
				functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
				functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_servicesvalue"));
				functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
				functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+EBFPlantConfigName+properties.getProperty("config_value_part2")));
				functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
				if(functionalcomponents.IsElementDisplayed(properties.getProperty("cancel_button")))
				  {
					test.log(Status.PASS, "user can not add the configuration with name as"+" "+EBFPlantConfigName+" "+"without adding plant id configuration property");
				  }
				 else
				   {
			            failedDescription("user is able to add the configuration with name as"+" "+EBFPlantConfigName+" "+"not successfully");
			        }
				functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
			   
			}
		  // Add All Plant configuration properties to gateway for Activated plant
		   functionalcomponents.ClickOperation(properties.getProperty("Gateway_GeneralSettingsTab"));	
		   functionalcomponents.ClickOperation(properties.getProperty("AddPropertytoGWButton"));
		   Rownum =driver.findElement(By.xpath("//bdi[text()='Plant_ID']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
		   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
		   functionalcomponents.ClickOperation("//td[contains(@id,'row"+Rownum+"-col1')]//span[@class='sapMSltArrow']");
		   functionalcomponents.ClickOperation(properties.getProperty("PlantIDinput"));	
		   functionalcomponents.waittill_WebElement_getVisible("//bdi[text()='Plant_Default_Storage_Location']", 50);
		  //Add Plant default storage location property
		   if (functionalcomponents.IsElementPresent("//bdi[text()='Plant_Default_Storage_Location']"))
			{
			   Rownum =driver.findElement(By.xpath("//bdi[text()='Plant_Default_Storage_Location']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
			   functionalcomponents.ClickOperation("//td[contains(@id,'row"+Rownum+"-col1')]//span[@class='sapMSltArrow']");
			   if (functionalcomponents.IsElementPresent("//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantDefaultStorageLocation+"']"))
				{
				   functionalcomponents.ClickOperation("//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantDefaultStorageLocation+"']");
				   test.log(Status.PASS, "user is able to select value for plant default storage location property");
				}
			   else {
				   failedDescription(" There is no value available for plant default storage location property value in drop down");
			       }
			   
			}
		   else {
			   failedDescription("plant default storage location property is not available to table list");
		       }
		
		   //Add Plant_Default_Main_Work_Center property
		   if (functionalcomponents.IsElementPresent("//bdi[text()='Plant_Default_Main_Work_Center']"))
			{
			   Rownum =driver.findElement(By.xpath("//bdi[text()='Plant_Default_Main_Work_Center']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
			   functionalcomponents.ClickOperation("//td[contains(@id,'row"+Rownum+"-col1')]//span[@class='sapMSltArrow']");
			   if (functionalcomponents.IsElementPresent("//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantDefaultMainWorkCenter+"']"))
				{
				   functionalcomponents.ClickOperation("//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantDefaultMainWorkCenter+"']");
				   test.log(Status.PASS, "user is able to select value for Plant_Default_Main_Work_Center property");
				}
			   else {
				   failedDescription(" There is no value available for Plant_Default_Main_Work_Center property value in drop down");
			       }
			   
			}
		   else {
			   failedDescription("Plant_Default_Main_Work_Center property is not available to table list");
		       }
		   
		   //Add Plant_Freight_Storage_Location property
		   if (functionalcomponents.IsElementPresent("//bdi[text()='Plant_Freight_Storage_Location']"))
			{
			    Rownum =driver.findElement(By.xpath("//bdi[text()='Plant_Freight_Storage_Location']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			    functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
			   functionalcomponents.ClickOperation("//td[contains(@id,'row"+Rownum+"-col1')]//span[@class='sapMSltArrow']");
			   if (functionalcomponents.IsElementPresent("(//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantFreightStorageLocation+"'])[2]"))
				{
				   functionalcomponents.ClickOperation("(//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantFreightStorageLocation+"'])[2]");
				   test.log(Status.PASS, "user is able to select value for Plant_Freight_Storage_Location property");
				}
			   else {
				   failedDescription(" There is no value available for Plant_Freight_Storage_Location property value in drop down");
			       }
			   
			}
		   else {
			   failedDescription("Plant_Freight_Storage_Location property is not available to table list");
		       }
		   
		   //Add Plant_Main_Work_Center_For_Work_Order property
		   if (functionalcomponents.IsElementPresent("//bdi[text()='Plant_Main_Work_Center_For_Work_Order']"))
			{
			   Rownum =driver.findElement(By.xpath("//bdi[text()='Plant_Main_Work_Center_For_Work_Order']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to')]");
			   functionalcomponents.ClickOperation("//td[contains(@id,'row"+Rownum+"-col1')]//span[@class='sapMSltArrow']");
			   if (functionalcomponents.IsElementPresent("(//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantMainWorkCenterForWorkOrder+"'])[2]"))
				{
				   functionalcomponents.ClickOperation("(//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantMainWorkCenterForWorkOrder+"'])[2]");
				   test.log(Status.PASS, "user is able to select value for Plant_Main_Work_Center_For_Work_Order property");
				}
			   else {
				   failedDescription(" There is no value available for Plant_Main_Work_Center_For_Work_Order property value in drop down");
			       }
			   
			}
		   else {
			   failedDescription("plant default storage location property is not available to table list");
		       }
		   //Adding LDPA configuration Property to apply PMS module for EBF configuration
		   // 1. Add LDPA HOST Configuration property to gateway
		   if (functionalcomponents.IsElementPresent("//bdi[text()='LDAP_Host']"))
			{
			   Rownum =driver.findElement(By.xpath("//bdi[text()='LDAP_Host']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
			   functionalcomponents.ClickAndSetValue(properties.getProperty("LDPA_Host_inputvalue"),"AnyvalueByUser");
			   test.log(Status.PASS, "user is able to enter the value for LDPA Host Configuration property");
			}
		   else {
			   failedDescription("LDPA Host property is not available to table list");
		       }
		 // 2. Add LDAP_Match_Attribute Configuration property to gateway
		   if (functionalcomponents.IsElementPresent("//bdi[text()='LDAP_Match_Attribute']"))
			{
			   Rownum =driver.findElement(By.xpath("//bdi[text()='LDAP_Match_Attribute']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
			   functionalcomponents.ClickAndSetValue(properties.getProperty("LDAP_Match_Attribute_InputValue"),"AnyvalueByUser");
			   test.log(Status.PASS, "user is able to enter the value for LDAP_Match_Attribute Configuration property");
			}
		   else {
			   failedDescription("LDAP_Match_Attribute property is not available to table list");
		       }
		   // 3. Add LDAP_Organizational_Unit Configuration property to gateway
		   if (functionalcomponents.IsElementPresent("//bdi[text()='LDAP_Organizational_Unit']"))
			{
			   Rownum =driver.findElement(By.xpath("//bdi[text()='LDAP_Organizational_Unit']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			   functionalcomponents.ClickOperation("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[contains(@title,'Click to ')]");
			   functionalcomponents.ClickAndSetValue(properties.getProperty("LDAP_Organizational_Unit_InputValue"),"AnyvalueByUser");
			   test.log(Status.PASS, "user is able to enter the value for LDAP_Organizational_Unit Configuration property");
			}
		   else {
			   failedDescription("LDAP_Organizational_Unit property is not available to table list");
		       } 
			  functionalcomponents.ClickOperation(properties.getProperty("AddConfigpropertybutton"));
			  functionalcomponents.WaitTillTime(15000); 
			// Add Backend_Timezone_Offset_Minutes Configuration property to gateway
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
				    else {
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
		//Deploy EBF Configuration with Plant maintenance business to Gateway after adding all plant properties
		 test.log(Status.INFO, "Deploy EBF Configuration with Plant maintenance business to Gateway after adding all plant properties");
		functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
	    functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
		functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_servicesvalue"));
		functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+EBFPlantConfigName+properties.getProperty("config_value_part2")));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_config_save"), 90);
		functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);
		if(functionalcomponents.IsElementDisplayed(properties.getProperty("config_search_button")))
		  {
			test.log(Status.PASS, "user is able to add the configuration with name as"+" "+EBFPlantConfigName+" "+"successfully");
		  } else
		   {
	            failedDescription("user is not able to add the configuration with name as"+" "+EBFPlantConfigName+" "+"successfully");
	        }
		 test.log(Status.INFO, "Click on the Refresh button untill status becomes Applied");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),EBFPlantConfigName);
		 functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);	  
		 for(int i=0; i<=20; i++) 
		 {
				  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
				  functionalcomponents.WaitTillTime(10000);
				  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+EBFPlantConfigName+properties.getProperty("Activated_msgpart2")));
				  if(ele1.getText().equalsIgnoreCase("Applied"))
					{
					  break;
				    }
				  else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
					{
					  break;
				    }
		 }	
			  
		 WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+EBFPlantConfigName+properties.getProperty("Activated_msgpart2")));
		 String text2= ele1.getText();
		 System.out.println(text2); 
		 if(text2.equalsIgnoreCase("Applied"))
			{
			 test.log(Status.PASS,EBFPlantConfigName+"Configuration is Applied successfully to Gateway with all Plant ID properties");
			}
		 else if(text2.equalsIgnoreCase("Failed to Apply"))
			{
			 failedDescription( EBFPlantConfigName+"Configuration is not Applied successfully to Gateway with all Plant ID properties");			
			 }
		 
		 //Validate to Delete deployed EBF Configuration file.
		  edgeservicefunctions.MovetoServicepage();
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70); 
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
		  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("//a[text()='"+EBFPlantConfigName+"']//ancestor::tr//button")))
	  	  {
			  failedDescription("user is able to see delete icon button for deployed EBF Configuration file");    
		  } else
		  {
              test.log(Status.PASS, "user is not able to see delete icon button for deployed EBF Configuration file");
          } 
		  
		  // validate to download EBF Configuration
		  functionalcomponents.ClickOperation(properties.getProperty("configurationname_part1")+EBFPlantConfigName+properties.getProperty("configurationname_part2"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_config_download"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("Security_config_download"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("EncryptPassword"), password);
		  functionalcomponents.ClickOperation(properties.getProperty("Downloadbutton"));
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Security_config_download")))
	  	  {
              test.log(Status.PASS, "user is able to see the config json file as well as able to download successfully in the UI");
		  } else
		  {
              failedDescription("user is not able to see the Config json file as well as able to download successfully in the UI");
          } 
		    
		  //Removing Plant ID Configuration Property from Gateway if its already added
		     edgeservicefunctions.MovetoEdgeServiceManagment_SearchGateway(GateWayNo);
			 if (functionalcomponents.IsElementPresent("//span[@title='Plant_ID']"))
			 {  
				   test.log(Status.PASS, "Delete Plant ID system Properties from gateway for Deploy EBF Configuration without adding Plant maintenance business module");
				   functionalcomponents.ClickOperation(properties.getProperty("EditPropertytoGateway"));
				   functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("DeletePlantIDbutton"), 70);
				   functionalcomponents.ClickOperation(properties.getProperty("DeletePlantIDbutton"));
				   functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("savebutton"), 70);
				   functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
				   functionalcomponents.WaitTillTime(10000);
					  if (!functionalcomponents.IsElementPresent("//span[@title='Plant_ID']"))
					  {
							test.log(Status.PASS, "user is able to Delete Plant ID system Properties from gateway:"+GateWayNo);
					  } else
						  
					  {
					       failedDescription("user is not able to Delete Plant ID system Properties from gateway:"+GateWayNo);
					  }
			  } 
	  }


	}
