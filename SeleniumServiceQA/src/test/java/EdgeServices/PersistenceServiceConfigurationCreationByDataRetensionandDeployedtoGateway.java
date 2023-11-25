package EdgeServices;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class PersistenceServiceConfigurationCreationByDataRetensionandDeployedtoGateway extends BaseTest {
	
	    //Prerequisites 1. Gateway should up and online status.
		// 2. Persistence service should be installed to online gateway.
	
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	EdgeServiceFunctions edgeservicefunction = new EdgeServiceFunctions();
	Properties properties = FunctionalComponents.getObjectProperties();
	String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	
	@Test
	public void PersistenceService_DataRetension_flow() throws Exception {
		String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL"); 
		String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
		String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
		String gatewayno=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");		
	    String InvalidName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "InvalidName");

	    EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
  	    edgeservicefunctions.LoginPolicyservice_MovetoEdgeServicemanagmentTile(PolicyServiceURL,username,password);
			
	     //Select Persistence Service and deploy data retention 1 configuration
	    //Creating configuration1  to the persistence Service
			 String JsonQuery1="{\"RetentionConfig\":{\r\n" + 
				  		"    \"defaultSettings\": { \r\n" + 
				  		"        \"size\": 10000, \r\n" + 
				  		"        \"age\": 10,\r\n" + 
				  		"        \"persist\" : true\r\n" + 
				  		"    },\r\n" + 
				  		"    \"status\":\"update\"\r\n" + 
				  		"}} ";
			 String Configname1="firstConfigpersitence"+CurrentDateandTime;
			 edgeservicefunction.CreatePersistenceConfigbydataretetionQuery(Configname1, JsonQuery1);
			 //Edit Config and save
			  test.log(Status.INFO, "click on creted Persistence configuration link and edit save succeffully");
	  		  functionalcomponents.ClickOperation("//a[@title='"+Configname1+"']");
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EditConfiguration"), 50); 
	  		  functionalcomponents.ClickOperation(properties.getProperty("EditConfiguration"));
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("PersistenceSchemaUserName"), "Anyuservalue");
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("PersistenceSchemaPassword"), "Anyvalue123");
	  		  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Policy_PersistenceServices"), 90); 
	  		  functionalcomponents.ClickOperation(properties.getProperty("Policy_PersistenceServices"));
			  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceADDConfiguration"), 50); 
			  if (functionalcomponents.IsElementDisplayed(properties.getProperty("persistenceADDConfiguration")))
			  {
				  test.log(Status.PASS, "user is able to click on created persistence config and edit save successfully");
				 
		        
			  } else
			  {
				  failedDescription("user is not able to click on created persistence config and edit save successfully");
		      }
			  test.log(Status.INFO, "verify Persistence configuration can not be created with same name from copy content exit config");
	  		  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceconfigurationName"), 50); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("persistenceconfigurationName"), Configname1);
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("PersistenceSchemaUserName"), "Anyuservalue");
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("PersistenceSchemaPassword"), "Anyvalue123");
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Copycontentcontentdropdownvalue"), Configname1);
			  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Close_Button")))
			  {
				  test.log(Status.PASS, "user can not create persistence config with already exist config name");  
			  } else
			  {
				  failedDescription("user is able to create persistence config with already exist config name");
		      }
			  test.log(Status.INFO, "verify Persistence configuration can not be created with invalid name");
			  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("persistenceconfigurationName"), InvalidName);
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("PersistenceSchemaUserName"), "Anyuservalue");
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("PersistenceSchemaPassword"), "Anyvalue123");
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Copycontentcontentdropdownvalue"), Configname1);
			  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceconfigurationName"), 50);
			  if (functionalcomponents.IsElementDisplayed(properties.getProperty("persistenceconfigurationName")))
			  {
				  test.log(Status.PASS, "user can not create persistence config with invalid config name");
			  } else
			  {
				  failedDescription("user is able to create persistence config with invalid config name");
		      }
			  test.log(Status.INFO, "verify Persistence configuration can not be created without entering mandatory fields");
			  functionalcomponents.ClearAndSetValue(properties.getProperty("persistenceconfigurationName"), "");
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Copycontentcontentdropdownvalue"), Configname1);
			  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("cancel_button")))
	  		  {
				  test.log(Status.PASS, "user can not create persistence config without entering mandatory fields");
			  } else
			  {
				  failedDescription("user is able to create persistence config without entering mandatory fields");
		      }
			  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	  
	  		  //Deploy Persistence configuration to Gateway
	  		  edgeservicefunction.MovetoEdgeServiceManagment_SearchGateway(gatewayno);
	  		  edgeservicefunction.PersistenceConfigDeploymenttoGateway(Configname1);
	  
			 //Validate to create configuration by uploading json file
	  		  test.log(Status.INFO, "Enter the configuration name and upload the json file to create persistence config");
			  functionalcomponents.ClickOperation(properties.getProperty("policy_Services"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Policy_PersistenceServices"), 50);
			  functionalcomponents.ClickOperation(properties.getProperty("Policy_PersistenceServices"));
			  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
			  functionalcomponents.ClickOperation(properties.getProperty("persistenceADDConfiguration"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceconfigurationName"), 50);
	  		  String PersistenceConfigName="PersistenceConfig"+CurrentDateandTime;
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), PersistenceConfigName);
	  		  functionalcomponents.scrollToExact(properties.getProperty("ConfigFileuploadpath"));
	  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+File.separator+"Documents"+File.separator+"PersistenceConfig.json"); 		 
	  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("persistenceADDConfiguration"), 90);
	  		  functionalcomponents.WaitTillTime(7000);
	  		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("persistenceADDConfiguration")))
	  		  {
	  			  test.log(Status.PASS, "user is successfully added the configruation as:"+PersistenceConfigName+" to the Persistence service");  
	  		  }
	  		  else
	  		  {
	  			  test.log(Status.FAIL, "user is not able to  added the configruation as:"+PersistenceConfigName+" to the Persistence service");
	  		  }	
	  		  test.log(Status.INFO, "switch between tabs of persistence Service and verify the group and gateways of persistence service");
	  		  functionalcomponents.ClickOperation(properties.getProperty("Services_GroupsTab"));
	  		  if(functionalcomponents.IsElementPresent(properties.getProperty("SelectFirstRowvalue")))
	  		  {
	  			  String Searchinput = driver.findElement(By.xpath(properties.getProperty("SelectFirstRowvalue"))).getText();
	  			  functionalcomponents.ClearAndSetValue(properties.getProperty("ServiceTabSearchInputfield"), Searchinput);
		  		  functionalcomponents.ClickOperation(properties.getProperty("TabSearchinputbutton"));
		  		  functionalcomponents.ClickOperation(properties.getProperty("SelectFirstRowvalue"));
		  		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("policy_Services")))
		  		  {
					  test.log(Status.PASS, "user is able to switch to Groups tabs of persistence service and move to first group details page ");
					  
				  } else
				  {
					  failedDescription("user is not able to switch to Groups tabs of persistence service and move to first group details page ");
			      }
	  		  
	  		  } 
	  		test.log(Status.PASS, "switch to Gateways tabs of persistence service and move to first gateway details page "); 
	  		functionalcomponents.ClickOperation(properties.getProperty("policy_Services"));
			functionalcomponents.ClickOperation(properties.getProperty("Policy_PersistenceServices"));
	  		functionalcomponents.ClickOperation(properties.getProperty("Services_GatewaysTab"));
	  		functionalcomponents.ClickOperation(properties.getProperty("SelectFirstRowvalue"));
	  		 if (functionalcomponents.IsElementDisplayed(properties.getProperty("Group_Add_button")))
	  		  {
				  test.log(Status.PASS, "user is able to switch to Gateways tabs of persistence service and move to first gateway details page ");
				  
			  } else
			  {
				  failedDescription("user is not able to switch to Gateways tabs of persistence service and move to first gateways details page ");
		      }
			  //Deploy persistence config created by uploading file
	  		  edgeservicefunction.MovetoEdgeServiceManagment_SearchGateway(gatewayno);
	  		  edgeservicefunction.PersistenceConfigDeploymenttoGateway(PersistenceConfigName);
	  		 //Create Persistence Service configuration with data retention 2		  
			 String JsonQuery2="{\"RetentionConfig\":{\"status\":\"update\"}}";
			 String Configname2="secondConfigpersitence"+CurrentDateandTime;
			 edgeservicefunction.CreatePersistenceConfigbydataretetionQuery(Configname2, JsonQuery2);
			 //Delete Configuration validation
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteFirstConfig"));
	  		  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
	  		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Policy_PersistenceServices")))
	  		  {
				  test.log(Status.PASS, "user is able to switch to Gateways tabs of persistence service and move to first gateway details page ");  
			 
	  		  } else
			  {
				  failedDescription("user is not able to switch to Gateways tabs of persistence service and move to first gateways details page ");
		      }
					  
			
	  		 
	  		 //validate data in db
			   /*  		
				  String Query1="SELECT PROP_VALUE FROM EFPS.CONFIG_MEASURE WHERE PROP_VALUE ='10000'";
				  String DBusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "PersistenceDB_Username");
				  String DBpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "PersistenceDB_Password");
				  String Servername= functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "ServerName");

				  test.log(Status.INFO, "Login successfully into the database and validate data retention property updated successfully");
				  String DB_Result1=functionalcomponents.GetDatafromPersistenceDataBase(Query1, DBusername, DBpassword, Servername);
				 System.out.println(DB_Result1);
				  if(DB_Result1 !=null && !DB_Result1.isEmpty() )
				  {
						 
						 test.log(Status.PASS, "System Property updated in db with: "+DB_Result1);
				  }
				  else 
					 {
						failedDescription("System Property is not updated in db with"+DB_Result1);
					 }
				
	  		 
	  		 //validate data in db   		
			String Query2="SELECT PROP_VALUE FROM EFPS.CONFIG_MEASURE WHERE PROP_VALUE ='10000'";
			test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
			String DB_Result2=functionalcomponents.GetDatafromPersistenceDataBase(Query2, DBusername, DBpassword, Servername);
			if(DB_Result2!= null )
			{
						 
			test.log(Status.PASS, "System Property updated in db with: "+DB_Result2);
			}
			else 
			{
			 failedDescription("System Property is not updated in db with"+DB_Result2);
			}
				  
          //Select Persistence Service and deploy data retention 3
					
		 String JsonQuery3="{\"RetentionConfig\":{ \"settings\" : [\r\n" + 
					  		"        { \"profileId\": \"117\", \"objectId\": \"Edgealt12\", \"size\": 10000, \"age\": 1, \"persist\": true },\r\n" + 
					  		"        { \"profileId\": \"103\", \"objectId\": \"edgal02\", \"size\": 20000, \"age\": 2, \"persist\": false }\r\n" + 
					  		"    ],\r\n" + 
					  		"    \"status\":\"update\"\r\n" + 
					  		"} }";
			
		 String Configname3="threeConfigpersitence"+CurrentDateandTime;
		CreatePersistenceConfigbydataretetionQuery(Configname3, JsonQuery3);
		PersistenceConfigDeployment(Configname3, gatewayno);		 
	//validate data in db		
		String Query3="SELECT * FROM EFPS.CONFIG_MEASURE where PROP_VALUE='10000'";
		test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
		String DB_Result3=functionalcomponents.GetDatafromPersistenceDataBase(Query3, DBusername, DBpassword, Servername);
		if(DB_Result3 !=null && !DB_Result3.isEmpty() )
		{
							 
		test.log(Status.PASS, "System Property updated in db with: "+DB_Result3);
		}
		else 
		{
			failedDescription("System Property is not updated in db with"+DB_Result3);
		}
						  	
		//Select Persistence Service and deploy data retention 4
						
		String JsonQuery4 = "{\"RetentionConfig\":{\r\n" + "    \"defaultSettings\": { \r\n"
				+ "        \"size\": 10000, \r\n" + "        \"age\": 10,\r\n" + "        \"persist\" : true\r\n"
				+ "    },\r\n" + "    \"settings\" : [\r\n"
				+ "        { \"profileId\": \"111\", \"objectId\": \"Edgealt6\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n"
				+ "        { \"profileId\": \"115\", \"objectId\": \"Edgealt10\", \"size\": 20000, \"age\": 2, \"persist\": false}\r\n"
				+ "    ],\r\n" + "    \"status\":\"update\"\r\n" + "}}";

		String Configname4 = "fourthConfigpersitence" + CurrentDateandTime;
		CreatePersistenceConfigbydataretetionQuery(Configname4, JsonQuery4);
		PersistenceConfigDeployment(Configname4, gatewayno);

		// validate data in db
		String Query4 = "SELECT * FROM EFPS.CONFIG_MEASURE WHERE PROP_VALUE ='10000'";
		test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
		String DB_Result4 = functionalcomponents.GetDatafromPersistenceDataBase(Query4, DBusername, DBpassword,
				Servername);
		if (DB_Result4 != null && !DB_Result4.isEmpty()) {

			test.log(Status.PASS, "System Property updated in db with: " + DB_Result4);
		} else {
			failedDescription("System Property is not updated in db with" + DB_Result4);
		}
	  
//Select Persistence Service and deploy data retention 5
							
							  
		String JsonQuery5 = "{\"RetentionConfig\":{\r\n" + "    \"defaultSettings\": { \r\n"
				+ "        \"size\": 10000, \r\n" + "        \"age\": 10,\r\n" + "        \"persist\" : false\r\n"
				+ "    },\r\n" + "    \"settings\" : [\r\n"
				+ "        { \"profileId\": \"111\", \"objectId\": \"Edgealt6\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n"
				+ "        { \"profileId\": \"115\", \"objectId\": \"Edgealt10\", \"size\": 20000, \"age\": 2, \"persist\": false}\r\n"
				+ "    ],\r\n" + "    \"status\":\"update\"\r\n" + "}}";

		String Configname5 = "fifthConfigpersitence" + CurrentDateandTime;
		CreatePersistenceConfigbydataretetionQuery(Configname5, JsonQuery5);
		PersistenceConfigDeployment(Configname5, gatewayno);

		// validate data in db
		String Query5 = "SELECT * FROM EFPS.CONFIG_MEASURE WHERE PROP_VALUE ='10000'";
		test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
		String DB_Result5 = functionalcomponents.GetDatafromPersistenceDataBase(Query5, DBusername, DBpassword,
				Servername);
		if (DB_Result5 != null && !DB_Result5.isEmpty()) {

			test.log(Status.PASS, "System Property updated in db with: " + DB_Result5);
		} else {
			failedDescription("System Property is not updated in db with" + DB_Result5);
		}
			  
		// Select Persistence Service and deploy data retention 6

		String JsonQuery6 = "{\"RetentionConfig\":{\r\n" + "    \"defaultSettings\": { \r\n"
				+ "        \"size\": 10000, \r\n" + "        \"age\": 10\r\n" + "    },\r\n"
				+ "    \"settings\" : [\r\n"
				+ "        { \"profileId\": \"109\", \"objectId\": \"Edgealt5\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n"
				+ "        { \"profileId\": \"117\", \"objectId\": \"Edgealt12\", \"size\": 20000, \"age\": 2, \"persist\": false}\r\n"
				+ "    ],\r\n" + "    \"status\":\"update\"\r\n" + "}}";

		String Configname6 = "SixthConfigpersitence" + CurrentDateandTime;
		CreatePersistenceConfigbydataretetionQuery(Configname6, JsonQuery6);
		PersistenceConfigDeployment(Configname6, gatewayno);

		// validate data in db
		String Query6 = "SELECT * FROM EFPS.CONFIG_MEASURE WHERE PROP_VALUE ='10000'";
		test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
		String DB_Result6 = functionalcomponents.GetDatafromPersistenceDataBase(Query6, DBusername, DBpassword,
				Servername);
		if (DB_Result6 != null && !DB_Result6.isEmpty()) {

			test.log(Status.PASS, "System Property updated in db with: " + DB_Result6);
		} else {
			failedDescription("System Property is not updated in db with" + DB_Result6);
		}

		// Select Persistence Service and deploy data retention 7

		String JsonQuery7 = "{\"RetentionConfig\":{\r\n" + "    \"defaultSettings\": { \r\n"
				+ "        \"size\": 10000, \r\n" + "        \"age\": 10,\r\n" + "        \"persist\" : false\r\n"
				+ "    },\r\n" + "    \"settings\" : [\r\n"
				+ "        { \"profileId\": \"125\", \"objectId\": \"Edgal18\", \"size\": 10000, \"age\": 1, \"persist\": true},\r\n"
				+ "        { \"profileId\": \"120\", \"objectId\": \"Edgealt14\", \"size\": 20000, \"age\": 2}\r\n"
				+ "    ],\r\n" + "    \"status\":\"update\"\r\n" + "}}";

		String Configname7 = "SevenConfigpersitence" + CurrentDateandTime;
		CreatePersistenceConfigbydataretetionQuery(Configname7, JsonQuery7);
		PersistenceConfigDeployment(Configname7, gatewayno);

	//validate data in db		
	String Query7="SELECT * FROM EFPS.CONFIG_MEASURE WHERE PROP_VALUE ='10000'";
   test.log(Status.INFO, "Login successfully into the database and validate property updated successfully");
  String DB_Result7 = functionalcomponents.GetDatafromPersistenceDataBase(Query7, DBusername, DBpassword,Servername);
  if (DB_Result7 != null && !DB_Result7.isEmpty())
  {

	test.log(Status.PASS, "System Property updated in db with: " + DB_Result7);
  } 
  else
  {
	failedDescription("System Property is not updated in db with" + DB_Result7);
  }
	
 */
		
		
							  
	}
	

}
