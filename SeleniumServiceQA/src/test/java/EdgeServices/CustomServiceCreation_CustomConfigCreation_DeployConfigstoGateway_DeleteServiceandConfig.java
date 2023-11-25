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

public class CustomServiceCreation_CustomConfigCreation_DeployConfigstoGateway_DeleteServiceandConfig extends BaseTest {
	   
	    //Prerequisite:- 1. Gateway should be up with online status
	               //    2. Custom service should be available in application with same jar file.
	
	    FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	    Properties properties = FunctionalComponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String CustomServiceName="";
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
	    String InvalidName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "InvalidName");
	    String Servicestatus="";
	    @Test
	    public void CreateCustomServicewithConfigsandDeployed()
	    {
	    	  EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
	    	  edgeservicefunctions.LoginPolicyservice_MovetoEdgeServicemanagmentTile(PolicyServiceURL,username,password);
	 		  test.log(Status.INFO, "Click on the  Services from left side bar and Add Cutoma service");
	 		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("services_button"), 90); 
	  		  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddCutomServicebutton"), 90); 
	  		  functionalcomponents.ClickOperation(properties.getProperty("AddCutomServicebutton"));
	  		  CustomServiceName="CustomServiceName"+CurrentDateandTime;
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("CustomServiceNameInput"), CustomServiceName);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("CustomServiceConfigtopicinput"), "CUSTOM");
	  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+File.separator+"Documents"+File.separator+"SampleCustomService-3.2006.0.jar");
	  		  functionalcomponents.ClickOperation(properties.getProperty("CustomServiceCreateButton"));
	  		  functionalcomponents.WaitTillTime(15000);
	  		  String Servicename=driver.findElement(By.xpath("//bdi[text()='"+CustomServiceName+"']")).getText();
	  		 if(Servicename.equals(CustomServiceName))
	  		 {
				 test.log(Status.PASS, "user is able to Create CustomService successfully with Name:-"+CustomServiceName);
			 }
			 else 
			 {
				failedDescription("user is not able to create custom service");
			 }
	  		  test.log(Status.INFO, "Click on the  Service Configuration tab and Create Streaming Custom Config for custom service");
	  		  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
	  		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
	  		 if(functionalcomponents.IsElementDisplayed(properties.getProperty("services_button")))
	  		 {
	  	        test.log(Status.PASS, "user is able to see the window opened with the options of name and content file from content file");
	  		  } else
	  		  {
	  	        failedDescription("user is not able to see the configuration window");
	  	      }
	  		  test.log(Status.INFO, "Enter the Custom service configuration name and upload the json file");
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
	  		  String CustomConfig="CustomServiceConfig"+CurrentDateandTime;
	  		  test.log(Status.INFO, "create Custom Service config with invalid/Blank config name");
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), "");
	  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), InvalidName);
	  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Add_button")))
	  		 {
				  test.log(Status.PASS, "user can not create Custom Service config with invalid/Blank config name");  
			  } else
			  {
				  failedDescription("user is able to create Custom service config with invalid/Blank config name");
		      }
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), CustomConfig);
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("CustomConfig_ContentInput"), "{\"success\" : true}");
	  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Services_GatewaysTab"), 90);
	  		if(functionalcomponents.IsElementDisplayed(properties.getProperty("Services_GatewaysTab")))
	  		 {
	  			  test.log(Status.PASS, "user is successfully added the configruation as:"+CustomConfig+" to the Custom service");  
	  		  }
	  		  else
	  		  {
	  			  test.log(Status.FAIL, "user is not able to  added the configruation as:"+CustomConfig+" to the Custom service");
	  		  }	  
	  		  test.log(Status.INFO, "switch between Group tab and Gateways tab verify the group and gateways of custom service");
	  		  functionalcomponents.ClickOperation(properties.getProperty("Services_GatewaysTab"));
	  		  functionalcomponents.ClickOperation(properties.getProperty("Services_GroupsTab"));
	  		 if(functionalcomponents.IsElementDisplayed(properties.getProperty("SAP_logo")))
	  		 {
					  test.log(Status.PASS, "user is able to switch to Groups tabs and gateway tabs of Custom Service service");      
			  } 
		  	  else
			  {
				 failedDescription("user is not able to switch to Groups tabs of persistence service and move to first group details page ");
			   }  
	  		  test.log(Status.INFO, "Install the Custom Service to the gateway and do the deployement");
	  		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
	  		  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
	  		  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
	  		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
	  		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateway_Services_tab"), 90);
	  		  test.log(Status.INFO, "Add the  Custom service to the gateway by clicking the + button and installed");
	  		  functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
			  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
			  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
			  functionalcomponents.ClickOperation("//ul[@class='sapMSelectList sapMSltList-CTX']//li[contains(text(),'"+CustomServiceName+"')]");
			  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
			  for(int i=1; i<20; i++)
			  {
			    functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
			    functionalcomponents.WaitTillTime(10000);  
			    String Rownumber=driver.findElement(By.xpath("//bdi[text()='"+CustomServiceName+"']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
			    Servicestatus=driver.findElement(By.xpath("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col2']//span[@class='sapMLabelTextWrapper']//bdi")).getText();
			     if(Servicestatus.equalsIgnoreCase("Installed"))
				  break;
			   }
			   if(Servicestatus.equalsIgnoreCase("Installed"))
				  {
					  test.log(Status.PASS, "Custom service installed successfully to gateway:"+GateWayNo+"as name"+CustomServiceName);
					  
				  }
			   else if(Servicestatus.equalsIgnoreCase("Error")){
				     failedDescription("Custom service status is Error");
				   }
				  else
				  {
					  failedDescription("Custom service is not installled");
				  }
	  		  test.log(Status.INFO, "Add the  Custom configuration to the gateway and do the deployement");
	  		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
	  		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
	  		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
	  		  functionalcomponents.ClickOperation("//ul[@class='sapMSelectList sapMSltList-CTX']//li[contains(text(),'"+CustomServiceName+"')]");
	  		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
	  		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+CustomConfig+properties.getProperty("config_value_part2")));
	  		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);	
	  		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("config_refresh_btn")))
	  		  {
	  			  test.log(Status.PASS, "user is able to add the configuration with name as"+" "+CustomConfig+" "+"successfully");
	  		  } else
	  		  {
	  	          failedDescription("user is not able to add the configuration with name as"+" "+CustomConfig+" "+"not successfully");
	  	      }
	  		  test.log(Status.INFO, "Click on the Refresh button until status becomes Applied");
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90); 
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("search_configname"),CustomConfig);
	  		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
	  		  functionalcomponents.WaitTillTime(3000);
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);
	  		  for(int i=0; i<=15; i++) {
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);
	  		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
	  		  functionalcomponents.WaitTillTime(10000);
	  		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+CustomConfig+properties.getProperty("Activated_msgpart2")));
	  		  if(ele1.getText().equalsIgnoreCase("Applied"))
	  		   {
	  				  break;
	  		    }
	  			else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
				{
				  break;
			  }
	  			  
	  		  }	
	  		  
	  		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+CustomConfig+properties.getProperty("Activated_msgpart2")));
	  		  String text1= ele1.getText();
	  		  System.out.println(text1); 
	  			if(text1.equalsIgnoreCase("Applied"))
	  			{
	  				 test.log(Status.PASS, CustomConfig+" configuration Applied successfully");
	  			}
	  			else if(text1.equalsIgnoreCase("Requested to Apply"))
	  			{
	  				 test.log(Status.FAIL, CustomConfig+" configuration is not Applied successfully");
	  			}
	  			else
	  			{
	  				 failedDescription("Applied failed message will be displyed");
	  			}
	  			
	  			 test.log(Status.INFO, "switch between tabs of Custom Service and gateways of service");
	  			 functionalcomponents.ClickOperation(properties.getProperty("services_button"));
		  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceSearchTextboxinput"), 90);
		  		  functionalcomponents.ClearAndSetValue(properties.getProperty("ServiceSearchTextboxinput"),CustomServiceName);
		  		  functionalcomponents.ClickOperation(properties.getProperty("ServiceSearchbutton"));
		  		  functionalcomponents.ClickOperation("//span[@title='"+CustomServiceName+"']");
	  			  functionalcomponents.ClickOperation(properties.getProperty("Services_GatewaysTab"));
	  			  functionalcomponents.ClearAndSetValue(properties.getProperty("ServiceTabSearchInputfield"), GateWayNo);
	  	  		  functionalcomponents.ClickOperation(properties.getProperty("TabSearchinputbutton"));
	  			  functionalcomponents.ClickOperation(properties.getProperty("SelectFirstRowvalue"));
	  			  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Gateway_Services_tab")))
		  		  {
	  				  test.log(Status.PASS, "user is able to switch to Gateways tabs of Custom service and move to first gateway details page ");
	  			   } else
	  			   {
	  				  failedDescription("user is not able to switch to Gateways tabs of persistence service and move to first gateways details page ");
	  		       }
	  		    //unInstall custom service from gateway
	  			  test.log(Status.PASS, "UnInstalling  custom service from gateway");
	  			  functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
	  			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 90);
	  			  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
	  			  functionalcomponents.WaitTillTime(20000);
	  			  String Rownumber=driver.findElement(By.xpath("//bdi[text()='"+CustomServiceName+"']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
				  System.out.println(Rownumber);
	  			  functionalcomponents.ClickOperation("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col4']//div[contains(@class, 'sapMTB-Auto-CTX')]//a");
	  			  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
				  functionalcomponents.WaitTillTime(50000);
				  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
				  functionalcomponents.WaitTillTime(20000);
				  if(!functionalcomponents.IsElementPresent("//bdi[text()='"+CustomServiceName+"']//ancestor::tr"))
		  		  {
		  			  test.log(Status.PASS, "user is able to UnInstalle custom service sucessfully with name as"+" "+CustomServiceName);
		  		  } else
		  		  {
		  	          failedDescription("user is not able to UnInstalle custom service sucessfully with name as"+" "+CustomServiceName);
		  	      }
				  //Deleting Custom config from custom service
				  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
		  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceSearchTextboxinput"), 90);
		  		  functionalcomponents.ClearAndSetValue(properties.getProperty("ServiceSearchTextboxinput"),CustomServiceName);
		  		  functionalcomponents.ClickOperation(properties.getProperty("ServiceSearchbutton"));
		  		  functionalcomponents.ClickOperation("//span[@title='"+CustomServiceName+"']");
		  		  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
		  		  functionalcomponents.ClickOperation(properties.getProperty("DeleteFirstConfig"));
		  		  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("DeleteCustomServiceButton"), 90);
				  if(functionalcomponents.IsElementDisplayed(properties.getProperty("DeleteCustomServiceButton")))
		  		  {
		  			  test.log(Status.PASS, "user is able to delete the configuration with name as"+" "+CustomConfig+" "+"successfully");
		  		  } else
		  		  {
		  	          failedDescription("user is able to delete the configuration with name as"+" "+CustomConfig+" "+"not successfully");
		  	      }
				  functionalcomponents.ClickOperation(properties.getProperty("DeleteCustomServiceButton"));
				  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
				  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SAP_logo"), 90);
				  if(functionalcomponents.IsElementDisplayed(properties.getProperty("SAP_logo")))
		  		  {
		  			  test.log(Status.PASS, "user is able to delete the configuration with name as"+" "+CustomConfig+" "+"successfully");
		  		  } else
		  		  {
		  	          failedDescription("user is able to delete the configuration with name as"+" "+CustomConfig+" "+"not successfully");
		  	      }
				  
	    }
	    
	   

}
