package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;
import UtilityComponent.RestAssuredComponents;

public class UDFScenarioBatchCount_Execution_AnySensorValueChanged extends BaseTest{
	
	/* Truststore must be created successfully 
	 * Https server must be started
	 * Check x,y,z parameter values from boiler.properties file-these should be used in UDF configuration
	 */
	
	
	/*
	 * Scenario: Batch-Count 
	 * 			 Execution: Any Sensor Value Changed
	 */
		FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
		RestAssuredComponents requestassuredcomponents = new RestAssuredComponents();
	    Properties properties = FunctionalComponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();	
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	    String UDFConfigName=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_UDF_Testcases", "UDF_Name");
	    String Projectname="";
	    String Project_configname="";
	    
	    String projectdesc=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_UDF_Testcases", "Description");
	    String Actionname  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Actionname");
	    String Action_desc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "ActionDescription");
	    String Actionname1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Actionname1");
	    String Action_desc1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "ActionDescription1");
	    String Action_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_UDF_Testcases", "Action_type");
	    String protocol_plugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "ProtocolPlugin");
	    String Actionmsg=  functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Action_Message");
	    String Receipient_param= functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Receipient_parameters");
	    String Ruledesc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Rule_Desc");
	    String RuleMaxfrequency=  functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleMaxoutfrequency");
	    String UDF_Name = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_UDF_Testcases", "UDF_Name");
	    String UDFAPIUrl = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_UDF_Testcases", "UDFAPIUrl");
	    String UDFTrust_Store_Path = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "UDFTrust_Store_Path");
	    String UDFTrustStorePassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "UDFTrustStorePassword");
	    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
	    String Streamingusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
		String Streamingpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password"); 
	    
	@Test 
	public void CreateUDF()
	{
		
		  UDFConfigName= UDFConfigName+CurrentDateandTime;
		  EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
	   	  edgeservicefunctions.LoginPolicyservice_MovetoEdgeDesignerTile(PolicyServiceURL,username,password);
	   	  
	   	  //Project creation
	   	  
	   	 Projectname="UDFEdgeProject"+CurrentDateandTime;
		 Project_configname="UDFEdgeConfig"+CurrentDateandTime;
	   	 
		 test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90); 
		 functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Create_project"), 90); 
		 if (functionalcomponents.IsElementDisplayed(properties.getProperty("Create_project")))
		  {
	         test.log(Status.PASS, "user is able to see Add Prject window successfully");
		  } else
		  {
	         failedDescription("user is not able to see the Add Project window ");
	      } 
		 			 
		  test.log(Status.INFO, "Enter the name of the project and Enter description of the project and click on the create button");			 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),Projectname);	  
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Refresh_button"), 90);
		  functionalcomponents.WaitTillTime(10000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Refresh_button")))
		  {	
				test.log(Status.PASS, "project name as"+":"+Projectname+" "+" is saved successfully");
		  }
		  else 
		  {
				failedDescription(" project name is not saved successfully");
		  }
		  //search project
		  test.log(Status.INFO, "search created project");
		  functionalcomponents.ClickOperation(properties.getProperty("Refresh_button"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 90);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("ProjectSearchinput"),Projectname);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectname+properties.getProperty("Project_title_part2")));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("copy_project"), 90);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("copy_project")))
		  {
			  test.log(Status.PASS, "user is able to search project successfullly"+Projectname);
		  } else
		  {
	          failedDescription("user is not able to search project");
	      }
		 
		  //Navigating to data model
		  test.log(Status.INFO, "click on the Data Model tab and click on + button to add sensor data model to the project");		
		  functionalcomponents.ClickOperation(properties.getProperty("Data_Model"));
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_add"));
		  functionalcomponents.ClickOperation(properties.getProperty("inputSensorType"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("SearchSensorTypeinput"), "SumOfSquares");
		  functionalcomponents.ClickOperation(properties.getProperty("Searchicon_button"));
		  functionalcomponents.ClickOperation("//div[text()='SumOfSquares']");
		  functionalcomponents.ClickOperation(properties.getProperty("Capability_Nameinput"));
		  
		  functionalcomponents.ClickOperation("//div[text()='SumOfSquares']");
		  functionalcomponents.ClickOperation(properties.getProperty("Property_namecheckbox"));
		  if(driver.findElement(By.xpath(properties.getProperty("Sensor_modelcreate"))).isDisplayed())
		  {
			  functionalcomponents.ClickOperation(properties.getProperty("Sensor_modelcreate"));
			  functionalcomponents.WaitTillTime(7000);  
			  test.log(Status.PASS, "user is able to add state data model mode successfully");
		  } else
		  {
	          failedDescription("user is not able to add state data model mode successfully");
	      }

		  //Create UDF 
		  functionalcomponents.WaitTillTime(4000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Tab"));
		  
		  functionalcomponents.WaitTillTime(4000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_AddButton"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Name"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_Name"),UDF_Name);
		  functionalcomponents.WaitTillTime(2000);
		 
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_apiUrl"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_apiUrl"),UDFAPIUrl);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_TrustStorePath"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_TrustStorePath"), UDFTrust_Store_Path);
		  functionalcomponents.WaitTillTime(2000);
		  
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_TrustStorePassword"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_TrustStorePassword"),"Test1234");
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_TrustStorePassword"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_TrustStorePassword"),"Test1234");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_AuthType"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_AuthType_None")); 
		  functionalcomponents.WaitTillTime(2000);
		  
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_BatchChbx"));
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_BatchModeDropdown"));
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_BatchModeDropdown_Count"));
		   
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_BatchMode_CountField"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_BatchMode_CountField"),"1s");
		  functionalcomponents.WaitTillTime(2000);
		  
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_RetryCountField"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_RetryCountField"),"2");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_RetryCountDelayField"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_RetryCountDelayField"),"5"); 
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_RetryCountDelayDropdown"));
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_RetryCountDelayDropdownUnitSec"));
		  functionalcomponents.WaitTillTime(2000);
		  
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_ExecutionMode"));
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_ExecutionModeDropdown_AnySensoreValueChanged"));
		 
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_CreateBtn"));
		  functionalcomponents.WaitTillTime(4000);
		  
		
		  //Create parameters
		  //Click on the created UDF config
		 
		  functionalcomponents.PerformDoubleClick("//a[text()='UDF_E2E_Test']");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mappings"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mappings_AddBtn"));
		  //X_val Addition-Input Parameter Mappings
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterName_Xval"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterName_Xval"),"x_val"); 
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterType_Xval_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterType_dropdownInteger"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_DataModelDropdwnXval"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_DataModel_Xval"));
		  functionalcomponents.WaitTillTime(4000);
		  //Y_val Addition-Input Parameter Mappings
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mappings_AddNewParameter"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterName_Yval"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterName_Yval"),"y_val"); 
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterType_Yval_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_DataModel_Yval_IntegerInput"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_Input_Parameter_Mapping_DataModel_Yval_IntegerInput"),"Integer"); 
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_DataModelDropdwnYval"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_DataModel_YvalInput"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_Input_Parameter_Mapping_DataModel_YvalInput"),"SumOfSquares>>>SumOfSquares>>>Y_Value"); 
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_CreateBtn"));
		  functionalcomponents.WaitTillTime(2000);
		  
		  //z_val addition-Output Parameter Mappings
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Output_Parameter_Mappings"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Output_Parameter_Mappings_AddBtn"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterName_Xval"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_Input_Parameter_Mapping_ParameterName_Xval"),"z_val"); 
		  functionalcomponents.WaitTillTime(2000);
		  
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_ParamType_IntegerInput"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("UDF_Input_Parameter_Mapping_ParamType_IntegerInput"),"Integer"); 
		  
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_DataModelDropdwnXval"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_Input_Parameter_Mapping_DataModel_Zval"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_CreateBtn"));
		  functionalcomponents.WaitTillTime(2000);
		   
		  functionalcomponents.ClickOperation(properties.getProperty("UDF_UDFProjectClickBreadCrum"));
		  functionalcomponents.WaitTillTime(2000);
		}
	
	
	
	 @Test(dependsOnMethods = { "CreateUDF" })
	  public void DeployUDFToGateway()
	  { 
		  EdgeServiceFunctions edgeservicefunctions = new EdgeServiceFunctions();
		  edgeservicefunctions.ProjectValidateandPublish(Project_configname, Projectname);
		  
		//Validate gateway status and set edge console password verify Services status and added successfully to GW 
		  edgeservicefunctions.VerifyGatewayStatus_SetEdgeConsolePasswordtoGateway(Streamingpassword, GateWayNo);
		  
		  //Adding Streaming service if not installed to gateway
		  edgeservicefunctions.StreamingServiceInstallationtoGateway(GateWayNo);
		  edgeservicefunctions.StreamingConfigDeploymenttoGateway(Project_configname, GateWayNo);
		 
	  }
	 
	 
	 @Test(dependsOnMethods = { "DeployUDFToGateway" })
	 public void StreamingConsole() {
	 //Prerequisite- Start the StreamingService Gateway service ( Could version )
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(2000);
	 String pagetitle1=driver.getTitle();
	 System.out.println(pagetitle1);
	 if(pagetitle1.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
	 {	
		test.log(Status.PASS, "URL is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle1);
	 }
	 else 
	 {
		failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
	 }
	 test.log(Status.INFO, "Click on EnterprisePlugins on the workcenter at left of the screen Settings>>EnterprisePlugin");
	 functionalcomponents.ClearAndSetValue(properties.getProperty("Streaming_username"), Streamingusername);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClearAndSetValue(properties.getProperty("Streaming_password"), Streamingpassword);
	 functionalcomponents.WaitTillTime(2000);	 
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Settings_link"), 90);

	 }	
	
}


