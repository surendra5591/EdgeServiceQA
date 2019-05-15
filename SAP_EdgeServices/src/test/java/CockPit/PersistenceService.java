package CockPit;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class PersistenceService extends BaseTest {
	Properties properties = functionalcomponents.getObjectProperties();
	@Test
	public void PersistenceService_DataRetension_flow() throws InterruptedException {
		
		String username = functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "username");
		String password = functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "password");
		String gatewayno=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Gatewayno");		
		String configName=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Name_config");
		String configName2=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Name_config2");
		String configName3=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Name_config3");
		String configName4=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Name_config4");
		String configName5=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Name_config5");
		String configName6=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Name_config6");
		String configName7=functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "Name_config7");
		
		
		
		//Prerequisite- Start the Policyservice  ( Cloud version )
		 test.log(Status.INFO, "Open  https://sesqa-les-admin-qa.cfapps.sap.hana.ondemand.com/");
		 driver.get(properties.getProperty("Policyservice_url"));
		 functionalcomponents.WaitTillTime(2000);
		 String pagetitle=driver.getTitle();
		
		 if(pagetitle.equalsIgnoreCase("AWS-Canary-sesqa: Log On"))
		 {	
			test.log(Status.PASS, "URL" +" "+"https://sesdemo.edge-qa.cfapps.sap.hana.ondemand.com"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
		 }
		 else 
		 {
			failedDescription("URL" +" "+"https://sesqa-les-admin-qa.cfapps.sap.hana.ondemand.com/"+" "+" is not loaded in Chrome browser");
		 }
		test.log(Status.INFO, "Login successfully into the policyservice and click on the  Settings options");
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 50);
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 70);

		if (driver.findElement(By.xpath(properties.getProperty("Search_Gateway"))).isDisplayed()) {
			test.log(Status.PASS, "Gateway manaagement window is opened successfully");
		} else {
			failedDescription("gatewaymanagement is not opened");
		}
			
	//Select Persistence Service and deploy data retention 1
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
			//Creating configuration  to the persistence Service
			  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceADDConfiguration"), 50); 
			  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), configName);
			  functionalcomponents.WaitTillTime(3000);
			  
			  String JsonQuery1="{\"RetentionConfig\":{\r\n" + 
			  		"    \"defaultSettings\": { \r\n" + 
			  		"        \"size\": 10000, \r\n" + 
			  		"        \"age\": 10,\r\n" + 
			  		"        \"persist\" : true\r\n" + 
			  		"    },\r\n" + 
			  		"    \"status\":\"update\"\r\n" + 
			  		"}} ";
			  
			  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery1);
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.moveToElement(properties.getProperty("configuration_name"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.PerformRightClick(properties.getProperty("configuration_name"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("sort_descending"));
			  functionalcomponents.WaitTillTime(1000);
			  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
			  {
					 test.log(Status.PASS, "user is able to add persistence configuration successfully");
			  }
			  else
				{
					 failedDescription("user is able to add persistence configuration successfully");
				}
			  
			  
			//search for the particular gateway
				test.log(Status.INFO, "Search for the particular gateway and add the configuration");
				functionalcomponents.ClickOperation(properties.getProperty("GroupsandGateway")); 
				functionalcomponents.WaitTillTime(5000);				
				functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
				functionalcomponents.WaitTillTime(5000);
				functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
				functionalcomponents.WaitTillTime(5000);
				functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
				functionalcomponents.WaitTillTime(7000);
				if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
				{
		              test.log(Status.PASS, "concerned gateway screen is opened successfully");
				} else 
				{
		              failedDescription("concerned gateway screen not opend");
		        } 
			//Creating configuration to the gateway
			  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_button"), 50); 
			  functionalcomponents.ClickOperation(properties.getProperty("Add_config_button"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_msg"), 50); 
			  if( driver.findElement(By.xpath(properties.getProperty("services_dropdown"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the service and configuration to be depolyed");
			  }
			  else
			  {
				  failedDescription("user can not select the service and configuration to be depolyed");
			  }
			  test.log(Status.INFO, "select the steraming service and configuration to be deployed");
			  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("persistenceservice"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
			  functionalcomponents.WaitTillTime(5000);
			 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
			  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configName+ properties.getProperty("config_value_part2")));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
			  functionalcomponents.WaitTillTime(5000);
			  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
			  {
					 test.log(Status.PASS, "user is able to select Streaming service "+configName+"as configuration successfully");
			  }
			  else
				{
					 failedDescription("user is not able to select Streaming service "+configName+"as configuration successfully");
				}
			  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
			  functionalcomponents.ClickAndSetValue(properties.getProperty("config_Searchtext"), configName);
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(30000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
			  functionalcomponents.WaitTillTime(20000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(20000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(15000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(15000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(15000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
			  functionalcomponents.WaitTillTime(1000);
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName+properties.getProperty("Activated_msgpart2")));
			  String text= ele1.getText();   
				if(text.equalsIgnoreCase("Activated"))
				{
					 test.log(Status.PASS, "configuration activated successfully");
				}
				else
				{
					 failedDescription("configuration is not activated");
				}
			  
			//validate data in db
		     		
			  String Query1="SELECT PROP_VALUE FROM EFPS.CONFIG_MEASURE";
			  String DBusername = functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "DB_Username");
			  String DBpassword = functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "DB_Password");
			  String Servername= functionalcomponents.getdatafromsheet("Policyservice", "PersistenceService_DataRetension_flow", "ServerName");

			  test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
			  String DB_Result1=functionalcomponents.GetDatafromPersistenceDataBase(Query1, DBusername, DBpassword, Servername);
			  if(DB_Result1 !=null && !DB_Result1.isEmpty() ) {
					 
					 test.log(Status.PASS, "System Property updated in db with: "+DB_Result1);
				 }
				 else 
				 {
					failedDescription("System Property is not updated in db with"+DB_Result1);
				 }
			
			  

			//Select Persistence Service and deploy data retention 2
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
				//Creating configuration  to the persistence Service
				  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
				  functionalcomponents.WaitTillTime(5000);
				  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
				  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceADDConfiguration"), 50); 
				  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
				  functionalcomponents.WaitTillTime(3000);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), configName2);
				  functionalcomponents.WaitTillTime(3000);
				  
				  String JsonQuery2="{\"RetentionConfig\":{\"status\":\"update\"}}";
				  
				  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery2);
				  functionalcomponents.WaitTillTime(5000);
				  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
				  functionalcomponents.WaitTillTime(5000);	  
				  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
				  {
						 test.log(Status.PASS, "user is able to add persistence configuration successfully");
				  }
				  else
					{
						 failedDescription("user is able to add persistence configuration successfully");
					}
				  
				  
				//search for the particular gateway
					test.log(Status.INFO, "Search for the particular gateway and add the configuration");
					functionalcomponents.ClickOperation(properties.getProperty("GroupsandGateway")); 
					functionalcomponents.WaitTillTime(5000);				
					functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
					functionalcomponents.WaitTillTime(5000);
					functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
					functionalcomponents.WaitTillTime(5000);
					functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
					functionalcomponents.WaitTillTime(5000);
					if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
					{
			              test.log(Status.PASS, "concerned gateway screen is opened successfully");
					} else 
					{
			              failedDescription("concerned gateway screen not opend");
			        } 
				//Creating configuration to the gateway
				  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
				  functionalcomponents.WaitTillTime(5000);
				  functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
				  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayConfiguration"), 50); 
				  functionalcomponents.ClickOperation(properties.getProperty("Add_config_button"));
				  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_msg"), 50); 
				  if( driver.findElement(By.xpath(properties.getProperty("services_dropdown"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the service and configuration to be depolyed");
				  }
				  else
				  {
					  failedDescription("user can not select the service and configuration to be depolyed");
				  }
				  test.log(Status.INFO, "select the steraming service and configuration to be deployed");
				  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
				  functionalcomponents.WaitTillTime(5000);
				  functionalcomponents.ClickOperation(properties.getProperty("persistenceservice"));
				  functionalcomponents.WaitTillTime(5000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
				  functionalcomponents.WaitTillTime(5000);
				 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
				  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configName2+properties.getProperty("config_value_part2")));
				  functionalcomponents.WaitTillTime(5000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
				  functionalcomponents.WaitTillTime(5000);
				  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
				  {
						 test.log(Status.PASS, "user is able to select Streaming service "+configName2+"as configuration successfully");
				  }
				  else
					{
						 failedDescription("user is not able to select Streaming service "+configName2+"as configuration successfully");
					}
				  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
				  functionalcomponents.ClearAndSetValue(properties.getProperty("config_Searchtext"), configName2);
				  functionalcomponents.WaitTillTime(1000);
				  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
				  functionalcomponents.WaitTillTime(3000);
				  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
				  functionalcomponents.WaitTillTime(30000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
				  functionalcomponents.WaitTillTime(1000);
				  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
				  functionalcomponents.WaitTillTime(5000);
				  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
				  functionalcomponents.WaitTillTime(20000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
				  functionalcomponents.WaitTillTime(20000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
				  functionalcomponents.WaitTillTime(15000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
				  functionalcomponents.WaitTillTime(15000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
				  functionalcomponents.WaitTillTime(15000);
				  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
				  functionalcomponents.WaitTillTime(1000);
				  WebElement ele2=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName2+properties.getProperty("Activated_msgpart2")));
				  String text2= ele2.getText();
				    
					if(text2.equalsIgnoreCase("Activated"))
					{
						 test.log(Status.PASS, "configuration activated successfully");
					}
					else
					{
						 failedDescription("configuration is not activated");
					}
				  
				//validate data in db
			     		
				  String Query2="SELECT PROP_VALUE FROM EFPS.CONFIG_MEASURE";
				  test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
				  String DB_Result2=functionalcomponents.GetDatafromPersistenceDataBase(Query2, DBusername, DBpassword, Servername);
				  if(DB_Result2!= null ) {
						 
						 test.log(Status.PASS, "System Property updated in db with: "+DB_Result2);
					 }
					 else 
					 {
						failedDescription("System Property is not updated in db with"+DB_Result2);
					 }
				  
     //Select Persistence Service and deploy data retention 3
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
					//Creating configuration  to the persistence Service
					  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
					  functionalcomponents.WaitTillTime(5000);
					  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
					  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration"), 50); 
					  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
					  functionalcomponents.WaitTillTime(3000);
					  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), configName3);
					  functionalcomponents.WaitTillTime(3000);
					  
					  String JsonQuery3="{\"RetentionConfig\":{ \"settings\" : [\r\n" + 
					  		"        { \"profileId\": \"117\", \"objectId\": \"Edgealt12\", \"size\": 10000, \"age\": 1, \"persist\": true },\r\n" + 
					  		"        { \"profileId\": \"103\", \"objectId\": \"edgal02\", \"size\": 20000, \"age\": 2, \"persist\": false }\r\n" + 
					  		"    ],\r\n" + 
					  		"    \"status\":\"update\"\r\n" + 
					  		"} }";
					  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery3);
					  functionalcomponents.WaitTillTime(5000);
					  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
					  functionalcomponents.WaitTillTime(5000);
					 
					  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
					  {
							 test.log(Status.PASS, "user is able to add persistence configuration successfully");
					  }
					  else
						{
							 failedDescription("user is able to add persistence configuration successfully");
						}
					  
					  
					//search for the particular gateway
						test.log(Status.INFO, "Search for the particular gateway and add the configuration");
						functionalcomponents.ClickOperation(properties.getProperty("GroupsandGateway")); 
						functionalcomponents.WaitTillTime(5000);				
						functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
						functionalcomponents.WaitTillTime(5000);
						functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
						functionalcomponents.WaitTillTime(5000);
						functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
						functionalcomponents.WaitTillTime(5000);
						if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
						{
				              test.log(Status.PASS, "concerned gateway screen is opened successfully");
						} else 
						{
				              failedDescription("concerned gateway screen not opend");
				        } 
					//Creating configuration to the gateway
					  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
					  functionalcomponents.WaitTillTime(5000);
					  functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
					  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayConfiguration"), 50); 
					  functionalcomponents.ClickOperation(properties.getProperty("Add_config_button"));
					  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_msg"), 50); 
					  if( driver.findElement(By.xpath(properties.getProperty("services_dropdown"))).isDisplayed())
					  {
						  test.log(Status.PASS, "user is able to select the service and configuration to be depolyed");
					  }
					  else
					  {
						  failedDescription("user can not select the service and configuration to be depolyed");
					  }
					  test.log(Status.INFO, "select the steraming service and configuration to be deployed");
					  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
					  functionalcomponents.WaitTillTime(5000);
					  functionalcomponents.ClickOperation(properties.getProperty("persistenceservice"));
					  functionalcomponents.WaitTillTime(5000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
					  functionalcomponents.WaitTillTime(5000);
					 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
					  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configName3+properties.getProperty("config_value_part2")));
					  functionalcomponents.WaitTillTime(5000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
					  functionalcomponents.WaitTillTime(5000);
					  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
					  {
							 test.log(Status.PASS, "user is able to select Streaming service "+configName3+"as configuration successfully");
					  }
					  else
						{
							 failedDescription("user is not able to select Streaming service "+configName3+"as configuration successfully");
						}
					  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
					  functionalcomponents.ClearAndSetValue(properties.getProperty("config_Searchtext"), configName3);
					  functionalcomponents.WaitTillTime(1000);
					  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
					  functionalcomponents.WaitTillTime(3000);
					  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
					  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
					  functionalcomponents.WaitTillTime(30000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
					  functionalcomponents.WaitTillTime(1000);
					  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
					  functionalcomponents.WaitTillTime(5000);
					  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
					  functionalcomponents.WaitTillTime(20000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
					  functionalcomponents.WaitTillTime(20000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
					  functionalcomponents.WaitTillTime(15000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
					  functionalcomponents.WaitTillTime(15000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
					  functionalcomponents.WaitTillTime(15000);
					  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
					  functionalcomponents.WaitTillTime(1000);
					  WebElement ele3=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName3+properties.getProperty("Activated_msgpart2")));
					  String text3= ele3.getText();
					    
						if(text3.equalsIgnoreCase("Activated"))
						{
							 test.log(Status.PASS, "configuration activated successfully");
						}
						else
						{
							 failedDescription("configuration is not activated");
						}
					  
					//validate data in db		
					  String Query3="SELECT * FROM EFPS.CONFIG_MEASURE";
					  test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
					  String DB_Result3=functionalcomponents.GetDatafromPersistenceDataBase(Query3, DBusername, DBpassword, Servername);
					  if(DB_Result3 !=null && !DB_Result3.isEmpty() ) {
							 
							 test.log(Status.PASS, "System Property updated in db with: "+DB_Result3);
						 }
						 else 
						 {
							failedDescription("System Property is not updated in db with"+DB_Result3);
						 }
						  
					//Select Persistence Service and deploy data retention 4
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
						//Creating configuration  to the persistence Service
						  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
						  functionalcomponents.WaitTillTime(5000);
						  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
						  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration"), 50); 
						  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
						  functionalcomponents.WaitTillTime(3000);
						  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), configName4);
						  functionalcomponents.WaitTillTime(3000);
						  
						  String JsonQuery4="{\"RetentionConfig\":{\r\n" + 
						  		"    \"defaultSettings\": { \r\n" + 
						  		"        \"size\": 10000, \r\n" + 
						  		"        \"age\": 10,\r\n" + 
						  		"        \"persist\" : true\r\n" + 
						  		"    },\r\n" + 
						  		"    \"settings\" : [\r\n" + 
						  		"        { \"profileId\": \"111\", \"objectId\": \"Edgealt6\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n" + 
						  		"        { \"profileId\": \"115\", \"objectId\": \"Edgealt10\", \"size\": 20000, \"age\": 2, \"persist\": false}\r\n" + 
						  		"    ],\r\n" + 
						  		"    \"status\":\"update\"\r\n" + 
						  		"}}";
						  
						  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery4);
						  functionalcomponents.WaitTillTime(5000);
						  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
						  functionalcomponents.WaitTillTime(5000);
						 
						  functionalcomponents.WaitTillTime(1000);
						  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
						  {
								 test.log(Status.PASS, "user is able to add persistence configuration successfully");
						  }
						  else
							{
								 failedDescription("user is able to add persistence configuration successfully");
							}
						  
						  
						//search for the particular gateway
							test.log(Status.INFO, "Search for the particular gateway and add the configuration");
							functionalcomponents.ClickOperation(properties.getProperty("GroupsandGateway")); 
							functionalcomponents.WaitTillTime(5000);				
							functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
							functionalcomponents.WaitTillTime(5000);
							functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
							functionalcomponents.WaitTillTime(5000);
							functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
							functionalcomponents.WaitTillTime(5000);
							if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
							{
					              test.log(Status.PASS, "concerned gateway screen is opened successfully");
							} else 
							{
					              failedDescription("concerned gateway screen not opend");
					        } 
						//Creating configuration to the gateway
						  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
						  functionalcomponents.WaitTillTime(5000);
						  functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
						  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayConfiguration"), 50); 
						  functionalcomponents.ClickOperation(properties.getProperty("Add_config_button"));
						  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_msg"), 50); 
						  if( driver.findElement(By.xpath(properties.getProperty("services_dropdown"))).isDisplayed())
						  {
							  test.log(Status.PASS, "user is able to select the service and configuration to be depolyed");
						  }
						  else
						  {
							  failedDescription("user can not select the service and configuration to be depolyed");
						  }
						  test.log(Status.INFO, "select the steraming service and configuration to be deployed");
						  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
						  functionalcomponents.WaitTillTime(5000);
						  functionalcomponents.ClickOperation(properties.getProperty("persistenceservice"));
						  functionalcomponents.WaitTillTime(5000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
						  functionalcomponents.WaitTillTime(5000);
						 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
						  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1") +configName4+ properties.getProperty("config_value_part2")));
						  functionalcomponents.WaitTillTime(5000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
						  functionalcomponents.WaitTillTime(5000);
						  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
						  {
								 test.log(Status.PASS, "user is able to select Streaming service "+configName4+"as configuration successfully");
						  }
						  else
							{
								 failedDescription("user is not able to select Streaming service "+configName4+"as configuration successfully");
							}
						  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
						  functionalcomponents.ClearAndSetValue(properties.getProperty("config_Searchtext"), configName4);
						  functionalcomponents.WaitTillTime(1000);
						  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
						  functionalcomponents.WaitTillTime(3000);
						  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
						  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
						  functionalcomponents.WaitTillTime(30000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
						  functionalcomponents.WaitTillTime(1000);
						  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
						  functionalcomponents.WaitTillTime(5000);
						  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
						  functionalcomponents.WaitTillTime(20000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
						  functionalcomponents.WaitTillTime(20000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
						  functionalcomponents.WaitTillTime(15000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
						  functionalcomponents.WaitTillTime(15000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
						  functionalcomponents.WaitTillTime(15000);
						  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
						  functionalcomponents.WaitTillTime(1000);
						  WebElement ele4=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName4+properties.getProperty("Activated_msgpart2")));
						  String text4= ele4.getText();
						    
							if(text4.equalsIgnoreCase("Activated"))
							{
								 test.log(Status.PASS, "configuration activated successfully");
							}
							else
							{
								 failedDescription("configuration is not activated");
							}
						  
						//validate data in db		
						  String Query4="SELECT * FROM EFPS.CONFIG_MEASURE";
						  test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
						  String DB_Result4=functionalcomponents.GetDatafromPersistenceDataBase(Query4, DBusername, DBpassword, Servername);
						  if(DB_Result4!=null && !DB_Result4.isEmpty() ) {
								 
								 test.log(Status.PASS, "System Property updated in db with: "+DB_Result4);
							 }
							 else 
							 {
								failedDescription("System Property is not updated in db with"+DB_Result4);
							 }
						  
						//Select Persistence Service and deploy data retention 5
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
							//Creating configuration  to the persistence Service
							  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
							  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration"), 50); 
							  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
							  functionalcomponents.WaitTillTime(3000);
							  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), configName5);
							  functionalcomponents.WaitTillTime(3000);
							  
							  String JsonQuery5="{\"RetentionConfig\":{\r\n" + 
							  		"    \"defaultSettings\": { \r\n" + 
							  		"        \"size\": 10000, \r\n" + 
							  		"        \"age\": 10,\r\n" + 
							  		"        \"persist\" : false\r\n" + 
							  		"    },\r\n" + 
							  		"    \"settings\" : [\r\n" + 
							  		"        { \"profileId\": \"111\", \"objectId\": \"Edgealt6\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n" + 
							  		"        { \"profileId\": \"115\", \"objectId\": \"Edgealt10\", \"size\": 20000, \"age\": 2, \"persist\": false}\r\n" + 
							  		"    ],\r\n" + 
							  		"    \"status\":\"update\"\r\n" + 
							  		"}}";
							  
							  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery5);
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.WaitTillTime(1000);
							  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
							  {
									 test.log(Status.PASS, "user is able to add persistence configuration successfully");
							  }
							  else
								{
									 failedDescription("user is able to add persistence configuration successfully");
								}
							  
							  
							//search for the particular gateway
								test.log(Status.INFO, "Search for the particular gateway and add the configuration");
								functionalcomponents.ClickOperation(properties.getProperty("GroupsandGateway")); 
								functionalcomponents.WaitTillTime(5000);				
								functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
								functionalcomponents.WaitTillTime(5000);
								functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
								functionalcomponents.WaitTillTime(5000);
								functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
								functionalcomponents.WaitTillTime(5000);
								if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
								{
						              test.log(Status.PASS, "concerned gateway screen is opened successfully");
								} else 
								{
						              failedDescription("concerned gateway screen not opend");
						        } 
							//Creating configuration to the gateway
							  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
							  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayConfiguration"), 50); 
							  functionalcomponents.ClickOperation(properties.getProperty("Add_config_button"));
							  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_msg"), 50); 
							  if( driver.findElement(By.xpath(properties.getProperty("services_dropdown"))).isDisplayed())
							  {
								  test.log(Status.PASS, "user is able to select the service and configuration to be depolyed");
							  }
							  else
							  {
								  failedDescription("user can not select the service and configuration to be depolyed");
							  }
							  test.log(Status.INFO, "select the steraming service and configuration to be deployed");
							  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.ClickOperation(properties.getProperty("persistenceservice"));
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
							  functionalcomponents.WaitTillTime(5000);
							 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
							  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configName5+ properties.getProperty("config_value_part2")));
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
							  functionalcomponents.WaitTillTime(5000);
							  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
							  {
									 test.log(Status.PASS, "user is able to select Streaming service "+configName5+"as configuration successfully");
							  }
							  else
								{
									 failedDescription("user is not able to select Streaming service "+configName5+"as configuration successfully");
								}
							  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
							  functionalcomponents.ClearAndSetValue(properties.getProperty("config_Searchtext"), configName5);
							  functionalcomponents.WaitTillTime(1000);
							  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
							  functionalcomponents.WaitTillTime(3000);
							  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
							  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
							  functionalcomponents.WaitTillTime(30000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
							  functionalcomponents.WaitTillTime(1000);
							  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
							  functionalcomponents.WaitTillTime(5000);
							  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
							  functionalcomponents.WaitTillTime(20000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
							  functionalcomponents.WaitTillTime(20000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
							  functionalcomponents.WaitTillTime(15000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
							  functionalcomponents.WaitTillTime(15000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
							  functionalcomponents.WaitTillTime(15000);
							  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
							  functionalcomponents.WaitTillTime(1000);
							  WebElement ele5=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName5+properties.getProperty("Activated_msgpart2")));
							  String text5= ele5.getText();
							    
								if(text5.equalsIgnoreCase("Activated"))
								{
									 test.log(Status.PASS, "configuration activated successfully");
								}
								else
								{
									 failedDescription("configuration is not activated");
								}
							  
							//validate data in db		
							  String Query5="SELECT * FROM EFPS.CONFIG_MEASURE";
							  test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
							  String DB_Result5=functionalcomponents.GetDatafromPersistenceDataBase(Query5, DBusername, DBpassword, Servername);
							  if(DB_Result5!=null && !DB_Result5.isEmpty() ) {
									 
									 test.log(Status.PASS, "System Property updated in db with: "+DB_Result5);
								 }
								 else 
								 {
									failedDescription("System Property is not updated in db with"+DB_Result5);
								 }
							  
							  
							//Select Persistence Service and deploy data retention 6
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
								//Creating configuration  to the persistence Service
								  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
								  functionalcomponents.WaitTillTime(5000);
								  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
								  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration"), 50); 
								  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
								  functionalcomponents.WaitTillTime(3000);
								  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), configName6);
								  functionalcomponents.WaitTillTime(3000);
								  
								  String JsonQuery6="{\"RetentionConfig\":{\r\n" + 
								  		"    \"defaultSettings\": { \r\n" + 
								  		"        \"size\": 10000, \r\n" + 
								  		"        \"age\": 10\r\n" + 
								  		"    },\r\n" + 
								  		"    \"settings\" : [\r\n" + 
								  		"        { \"profileId\": \"109\", \"objectId\": \"Edgealt5\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n" + 
								  		"        { \"profileId\": \"117\", \"objectId\": \"Edgealt12\", \"size\": 20000, \"age\": 2, \"persist\": false}\r\n" + 
								  		"    ],\r\n" + 
								  		"    \"status\":\"update\"\r\n" + 
								  		"}}";
								  
								  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery6);
								  functionalcomponents.WaitTillTime(5000);
								  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
								  functionalcomponents.WaitTillTime(5000);
								  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
								  {
										 test.log(Status.PASS, "user is able to add persistence configuration successfully");
								  }
								  else
									{
										 failedDescription("user is able to add persistence configuration successfully");
									}
								  
								  
								//search for the particular gateway
									test.log(Status.INFO, "Search for the particular gateway and add the configuration");
									functionalcomponents.ClickOperation(properties.getProperty("GroupsandGateway")); 
									functionalcomponents.WaitTillTime(5000);				
									functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
									functionalcomponents.WaitTillTime(5000);
									functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
									functionalcomponents.WaitTillTime(5000);
									functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
									functionalcomponents.WaitTillTime(5000);
									if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
									{
							              test.log(Status.PASS, "concerned gateway screen is opened successfully");
									} else 
									{
							              failedDescription("concerned gateway screen not opend");
							        } 
								//Creating configuration to the gateway
								  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
								  functionalcomponents.WaitTillTime(5000);
								  functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
								  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayConfiguration"), 50); 
								  functionalcomponents.ClickOperation(properties.getProperty("Add_config_button"));
								  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_msg"), 50); 
								  if( driver.findElement(By.xpath(properties.getProperty("services_dropdown"))).isDisplayed())
								  {
									  test.log(Status.PASS, "user is able to select the service and configuration to be depolyed");
								  }
								  else
								  {
									  failedDescription("user can not select the service and configuration to be depolyed");
								  }
								  test.log(Status.INFO, "select the steraming service and configuration to be deployed");
								  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
								  functionalcomponents.WaitTillTime(5000);
								  functionalcomponents.ClickOperation(properties.getProperty("persistenceservice"));
								  functionalcomponents.WaitTillTime(5000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
								  functionalcomponents.WaitTillTime(5000);
								 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
								  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configName6+properties.getProperty("config_value_part2")));
								  functionalcomponents.WaitTillTime(5000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
								  functionalcomponents.WaitTillTime(5000);
								  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
								  {
										 test.log(Status.PASS, "user is able to select Streaming service "+configName6+"as configuration successfully");
								  }
								  else
									{
										 failedDescription("user is not able to select Streaming service "+configName6+"as configuration successfully");
									}
								  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
								  functionalcomponents.ClearAndSetValue(properties.getProperty("config_Searchtext"), configName6);
								  functionalcomponents.WaitTillTime(1000);
								  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
								  functionalcomponents.WaitTillTime(3000);
								  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
								  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
								  functionalcomponents.WaitTillTime(30000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
								  functionalcomponents.WaitTillTime(1000);
								  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
								  functionalcomponents.WaitTillTime(5000);
								  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
								  functionalcomponents.WaitTillTime(20000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
								  functionalcomponents.WaitTillTime(20000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
								  functionalcomponents.WaitTillTime(15000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
								  functionalcomponents.WaitTillTime(15000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
								  functionalcomponents.WaitTillTime(15000);
								  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
								  functionalcomponents.WaitTillTime(1000);
								  WebElement ele6=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName6+properties.getProperty("Activated_msgpart2")));
								  String text6= ele6.getText();
								    
									if(text6.equalsIgnoreCase("Activated"))
									{
										 test.log(Status.PASS, "configuration activated successfully");
									}
									else
									{
										 failedDescription("configuration is not activated");
									}
								  
								//validate data in db		
								  String Query6="SELECT * FROM EFPS.CONFIG_MEASURE";
								  test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
								  String DB_Result6=functionalcomponents.GetDatafromPersistenceDataBase(Query6, DBusername, DBpassword, Servername);
								  if(DB_Result6!=null && !DB_Result6.isEmpty() ) {
										 
										 test.log(Status.PASS, "System Property updated in db with: "+DB_Result6);
									 }
									 else 
									 {
										failedDescription("System Property is not updated in db with"+DB_Result6);
									 }
								  
								  
								  
								//Select Persistence Service and deploy data retention 7
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
									//Creating configuration  to the persistence Service
									  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
									  functionalcomponents.WaitTillTime(5000);
									  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
									  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration"), 50); 
									  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
									  functionalcomponents.WaitTillTime(3000);
									  functionalcomponents.ClickAndSetValue(properties.getProperty("persistenceconfigurationName"), configName7);
									  functionalcomponents.WaitTillTime(3000);
									  
									  String JsonQuery7="{\"RetentionConfig\":{\r\n" + 
									  		"    \"defaultSettings\": { \r\n" + 
									  		"        \"size\": 10000, \r\n" + 
									  		"        \"age\": 10,\r\n" + 
									  		"        \"persist\" : false\r\n" + 
									  		"    },\r\n" + 
									  		"    \"settings\" : [\r\n" + 
									  		"        { \"profileId\": \"125\", \"objectId\": \"Edgal18\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n" + 
									  		"        { \"profileId\": \"120\", \"objectId\": \"Edgealt14\", \"size\": 20000, \"age\": 2}\r\n" + 
									  		"    ],\r\n" + 
									  		"    \"status\":\"update\"\r\n" + 
									  		"}}";
									  
									  functionalcomponents.ClickAndSetValue(properties.getProperty("DataRetention"), JsonQuery7);
									  functionalcomponents.WaitTillTime(5000);
									  functionalcomponents.ClickOperation(properties.getProperty("PersistenceConfigAdd_Button"));
									  functionalcomponents.WaitTillTime(5000);
				
									  if(driver.findElement(By.xpath(properties.getProperty("GroupsandGateway"))).isDisplayed())
									  {
											 test.log(Status.PASS, "user is able to add persistence configuration successfully");
									  }
									  else
										{
											 failedDescription("user is able to add persistence configuration successfully");
										}
									  
									  
									//search for the particular gateway
										test.log(Status.INFO, "Search for the particular gateway and add the configuration");
										functionalcomponents.ClickOperation(properties.getProperty("GroupsandGateway")); 
										functionalcomponents.WaitTillTime(5000);				
										functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
										functionalcomponents.WaitTillTime(5000);
										functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
										functionalcomponents.WaitTillTime(5000);
										functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
										functionalcomponents.WaitTillTime(5000);
										if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
										{
								              test.log(Status.PASS, "concerned gateway screen is opened successfully");
										} else 
										{
								              failedDescription("concerned gateway screen not opend");
								        } 
									//Creating configuration to the gateway
									  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
									  functionalcomponents.WaitTillTime(5000);
									  functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
									  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayConfiguration"), 50); 
									  functionalcomponents.ClickOperation(properties.getProperty("Add_config_button"));
									  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_config_msg"), 50); 
									  if( driver.findElement(By.xpath(properties.getProperty("services_dropdown"))).isDisplayed())
									  {
										  test.log(Status.PASS, "user is able to select the service and configuration to be depolyed");
									  }
									  else
									  {
										  failedDescription("user can not select the service and configuration to be depolyed");
									  }
									  test.log(Status.INFO, "select the steraming service and configuration to be deployed");
									  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
									  functionalcomponents.WaitTillTime(5000);
									  functionalcomponents.ClickOperation(properties.getProperty("persistenceservice"));
									  functionalcomponents.WaitTillTime(5000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
									  functionalcomponents.WaitTillTime(5000);
									 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
									  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configName7+properties.getProperty("config_value_part2")));
									  functionalcomponents.WaitTillTime(5000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
									  functionalcomponents.WaitTillTime(5000);
									  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
									  {
											 test.log(Status.PASS, "user is able to select Streaming service "+configName7+"as configuration successfully");
									  }
									  else
										{
											 failedDescription("user is not able to select Streaming service "+configName7+"as configuration successfully");
										}
									  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
									  functionalcomponents.ClearAndSetValue(properties.getProperty("config_Searchtext"), configName7);
									  functionalcomponents.WaitTillTime(1000);
									  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
									  functionalcomponents.WaitTillTime(3000);
									  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(30000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(1000);
									  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
									  functionalcomponents.WaitTillTime(5000);
									  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
									  functionalcomponents.WaitTillTime(20000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(20000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(15000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(15000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(15000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(15000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(15000);
									  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
									  functionalcomponents.WaitTillTime(1000);
									  WebElement ele7=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName7+properties.getProperty("Activated_msgpart2")));
									  String text7= ele7.getText();
									    
										if(text7.equalsIgnoreCase("Activated"))
										{
											 test.log(Status.PASS, "configuration activated successfully");
										}
										else
										{
											 failedDescription("configuration is not activated");
										}
									  
									//validate data in db		
									  String Query7="SELECT * FROM EFPS.CONFIG_MEASURE";
									  test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
									  String DB_Result7=functionalcomponents.GetDatafromPersistenceDataBase(Query7, DBusername, DBpassword, Servername);
									  if(DB_Result7!=null && !DB_Result7.isEmpty() ) {
											 
											 test.log(Status.PASS, "System Property updated in db with: "+DB_Result7);
										 }
										 else 
										 {
											failedDescription("System Property is not updated in db with"+DB_Result7);
										 }
									  
							  
	}
	
	
	

}
