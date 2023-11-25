package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import EdgeServices.PolicyEdgedesignercomponent;

public class PersistenceServiceDataRetension extends PolicyEdgedesignercomponent {
	Properties properties = functionalcomponents.getObjectProperties();
	String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	
	@Test
	public void PersistenceService_DataRetension_flow() throws Exception {
		String EdgeURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL"); 
		String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
		String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
		String gatewayno=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");		
		
		//Prerequisite- Start the EdgeServices  ( Cloud version )
		 driver.get(EdgeURL);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policyservice_name"), 70);
		 functionalcomponents.WaitTillTime(2000);
		test.log(Status.INFO, "open URL: "+EdgeURL+" Login successfully into the policyservice and click on the  GatewayManagement");
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 70);
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		functionalcomponents.WaitTillTime(30000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 70);
		functionalcomponents.WaitTillTime(7000);
		if (driver.findElement(By.xpath(properties.getProperty("Search_Gateway"))).isDisplayed()) {
			test.log(Status.PASS, "Gateway manaagement window is opened successfully");
		} else {
			failedDescription("gatewaymanagement is not opened");
		}
			
	//Select Persistence Service and deploy data retention 1
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
			CreatePersistenceConfigbydataretetionQuery(Configname1, JsonQuery1);
			PersistenceConfigDeployment(Configname1, gatewayno);
			
			  
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
			
			  

			//Select Persistence Service and deploy data retention 2
					  
			 String JsonQuery2="{\"RetentionConfig\":{\"status\":\"update\"}}";
			 String Configname2="secondConfigpersitence"+CurrentDateandTime;
			 CreatePersistenceConfigbydataretetionQuery(Configname2, JsonQuery2);
			 PersistenceConfigDeployment(Configname2, gatewayno);
					  
				  
			//validate data in db
			 /*    		
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
	/*			 
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
						  
		
		
		

		
		
		
		
/*		
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
