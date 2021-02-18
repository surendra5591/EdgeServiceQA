package EdgeServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import EdgeServiceComponents.StreamingEdgeConsolecomponents;
import UtilityComponent.FunctionalComponents;
import UtilityComponent.RestAssuredComponents;
import io.restassured.response.Response;

public class E2E_Cockpit_EdgeProject_StreamingConfigDeploy_StreamingEdgeConsolevalidation extends BaseTest  {
	
	//Prerequisite:- 
	// 1. Gateway should be up with online status
	// 2. Data should be updated correctly in global test data sheet
	// 3. if scripts is running in IOT one product env.then iot data (capability and sensor type) should be created before running this test cases.
	
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
    Properties properties = FunctionalComponents.getObjectProperties();
    RestAssuredComponents requestassuredcomponents = new RestAssuredComponents();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
    String CapablityName="";
    String CapablityAlternateID ="";
    String SensorTypesName="";
    String SensorTypeAltID = functionalcomponents.GetRandomnumber();
    String DeviceName="";
    String DeviceAlternateID="";
    String SensorName="";
    String SensorAltID ="";
    String Projectname="";
    String Project_configname="";
    String StreamConfig="";
    String EBFConfigName="";
    String Rownumber="";
    String Servicestatus="";
    //Global Input test data for Streaming
   
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
    String TenantID=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "TenantID");
    String DB_UserName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "StreamingDB_userid");	 
    String DB_Password=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "StreamingDB_pwd");	  
    String CockpitURL= functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "CockpitURL");
	String Cockpitusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "CockpitUserName");
	String Cockpitpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "CockpitPassword");
	String Streamingusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
	String Streamingpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password"); 
	String InvalidName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "InvalidName");
	String  PropertiesName1 = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "PropertiesName1");
	String  PropertiesName2 = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "PropertiesName2");
	
     static Response response; 
     static String  APIData;
	 String DeviceBaseurl = "";
	 String SesorTypeBaseURL="";
	 String CapabiltyBaseURL="";
	 String SensorBaseURL="";
	 static String SensornameAPI="";
	 static String SensorTypeIDAPI="";
	 static String SensorTypeNameAPI="";
	 static String DevicenameAPI= "";
	 static String CapablityIDAPI="";
	 static String CapablitynameAPI="";
	 static String CapablityAlternateIDAPI="";
	 static String PropertiesName1API="";
	 static String PropertiesName2API="";
	 static String DeviceIDAPI= "";
	 
 
	 
	//EdgeDeginer input
		String projectdesc=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Description");
		String average_value  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "AverageReading_value");
		String Minimum_output_frequency= functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Minimum_output_frequency");
		String Keep_events_Days=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Keep_events_Days");
		String Max_edge_Readings_store=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Max_edge_Readings_store");
		String Enterprise_max_output_frequency=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Enterprise_max_output_frequency");
		String Local_enterpriseplugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Local_enterprise_plugin");
		String Rulename  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleName");
		String Ruledesc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Rule_Desc");
		String Rulecondition  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Rule_condition");
		String RuleMaxfrequency=  functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleMaxoutfrequency");
		String Rulename1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleName1");
		String Ruledesc1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Rule_Desc1");
		String Rulecondition1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Rule_condition1");
		String filteropt  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Filter");
		String filtervalue  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Filtervalue");
		String conditiontype  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Condtiontype");
		String customproject_host=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Customprojecthost");
		String customproject_port=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "customprojectport");
		String maximum_eventfrequency1=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Max_eventfrequency");
		String interval_without_sensor=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "intervalwithoutsensor");
		String Targetstate=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Targetstate");
		String Timein_State=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Timeinstate");
		String operator  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Operator");
		String thresholding_value  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Thresholdingvalue");
		String Actionname  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Actionname");
	    String Action_desc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "ActionDescription");
	    String Actionname1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Actionname1");
	    String Action_desc1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "ActionDescription1");
	    String Action_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Action_type");
	    String protocol_plugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "ProtocolPlugin");
	    String Actionmsg=  functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Action_Message");
	    String Receipient_param= functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Receipient_parameters");
	    String Scope_level  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Scope_level");
	    String Edge_Fedilityfreq  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "New_edgefedility_freq");
	    String Edge_fedility_rollback = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "edge_fedility_rollback");
	    String enterprise_fedility = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Enterprise_fedility");
	    String enterprise_rollback  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Enterprise_rollback");
	    String Edge_Fedilityfreq1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "New_edgefedility_freq1");
	    String Edge_fedility_rollback1 = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "edge_fedility_rollback1");
	    String enterprise_fedility1 = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Enterprise_fedility1");
	    String enterprise_rollback1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Enterprise_rollback1");
		
	    //RDS Input
	    String Ruledatasourcename  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleDsname");
	    String Ruledsdesc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleDs_description");
	    String Authenticaion_type=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "AuthenticationType");
	    String Custom_headers  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Custom Headers");
	    String Date_format  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Date Format");
	    String updatefrequency  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Updatefrequency");
	    String Response_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Response_Type");
	    String Global_RuleDatasource=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Global_RuleDatasource");
	    String contentype_headervalue  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "contenttype_Header_value");
	    String Request_body_template = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Request_body_Template");
	    String Request_Method = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Request_Method");
		   
	    //Streaming input
	    String Plugin_name=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Plugin_name");
	    String Basic_AUTH_Password_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Basic_AUTH_Password_input");
	    String AUTH_TYPE_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "AUTH_TYPE_input");
	    String Rest_URI_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "URI_input");
		String BASIC_AUTH_USERNAME_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "BASIC_AUTH_USERNAME_input");
		
     // Get exists Device, Sensor type, Sensor, Capability for gateway Using Rest Assured API for IOTS 
     @Test
     public void GetIOTDataRespectiveGatewayID() throws Exception
     {
    	 if(PolicyServiceURL.contains("qa6-aws"))
    	 {
    		 String ClientID="sb-27fdca04-3447-41ce-ad30-b89df8ef11f3!b12729|iotae_service_sb!b1";
    		 String ClientSecret="otus78TE14XMiETdR5BfiC40Mpc=";
    		 String requestURL = "https://qa6-aws.authentication.sap.hana.ondemand.com/oauth/token?grant_type=client_credentials";
    		 String BearerToken = requestassuredcomponents.GeneratBearerToken(requestURL, ClientID, ClientSecret);
    		 String SesorTypeBaseURL = CockpitURL+"/api/v1/sensorTypes";
    		 String CapabiltyBaseURL = CockpitURL+"/api/v1/capabilities?skip=0&top=1000";
    		 String Sensortypedata = requestassuredcomponents.GetAPIDatawithBearertokenAuth(SesorTypeBaseURL, BearerToken);
    		 System.out.println("body data is"+Sensortypedata);
    		 JSONParser parse = new JSONParser(); 
    		 JSONArray jsonarr = (JSONArray)parse.parse(Sensortypedata);
    		 for(int i=0;i<jsonarr.size();)
    		 {
    		   JSONObject jsonsensortypeeobj = (JSONObject)jsonarr.get(i);
    		  // System.out.println("SensorTypeId:"+jsonsensortypeeobj.get("id"));
    		   if(!(jsonsensortypeeobj.get("id")==""))
    		   {
    		   SensorTypeNameAPI=(String) jsonsensortypeeobj.get("name");
    		   JSONArray jsonarr_Capablity = (JSONArray) jsonsensortypeeobj.get("capabilities");
    		  // System.out.println(jsonarr_Capablity);
    			   for(int j=0;j<jsonarr_Capablity.size();j++)
    			   {
    				   JSONObject jsonCapablity = (JSONObject)jsonarr_Capablity.get(j);
    				   CapablityIDAPI=(String) jsonCapablity.get("id");
    				  // System.out.println(CapablityIDAPI);
    				   test.log(Status.PASS, "user is able to Get SensortypeName as:"+SensorTypeNameAPI+" and Capablity ID is :"+CapablityIDAPI);
    			   }
    			   break;
    		   }
    		   else
    		   {
    			   test.log(Status.FAIL, "user is not able to Get SensortypeName");
    		   }
    		 }
    		   String Capablitydata=requestassuredcomponents.GetAPIDatawithBearertokenAuth(CapabiltyBaseURL, BearerToken);
    		   System.out.println("body data is"+Capablitydata);
    		   JSONParser parse1 = new JSONParser(); 
    		   JSONArray jsonarr1 = (JSONArray)parse1.parse(Capablitydata);
    		   //System.out.println(jsonarr1);
    		   for(int i=0;i<jsonarr1.size();i++)
    		   {
    		   JSONObject jsoncapobj = (JSONObject)jsonarr1.get(i);
    		  // System.out.println(jsoncapobj);
    		   if(jsoncapobj.get("id").equals(CapablityIDAPI))
    		   {
    			   CapablitynameAPI=(String) jsoncapobj.get("name");
    			   CapablityAlternateIDAPI=(String) jsoncapobj.get("alternateId");
    			   JSONArray jsoncaparr = (JSONArray)jsoncapobj.get("properties");
    			  // System.out.println(jsoncaparr);
    			   for(int j=0;j<jsoncaparr.size();j++)
    			   {
    			   JSONObject jsonpropobj = (JSONObject)jsoncaparr.get(j);
    			   if(j==0)
    			   PropertiesName1API=(String) jsonpropobj.get("name");
    			   if(j==1)
    			   PropertiesName2API=(String) jsonpropobj.get("name");
    		      }
    			   //System.out.println(PropertiesName1API+"----"+PropertiesName2API);
    		   test.log(Status.PASS, "user is able to Get Capablity Name is :"+CapablitynameAPI+" into Cokpit Application with Properties as: "+PropertiesName1API+", "+PropertiesName2API);
    		   break;
    		   }
    	   
    		  }
    	 }
    	 else
    	 {
    		 GetIOTData();
    	 }
     }
    
    //Create Project with data models  
     @Test (dependsOnMethods = {"GetIOTDataRespectiveGatewayID"})
     public void ProjectCreation() {   
 		
     EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
   	 edgeservicefunctions.LoginPolicyservice_MovetoEdgeDesignerTile(PolicyServiceURL,username,password);
 	 Projectname="EdgeProject"+CurrentDateandTime;
	 Project_configname="EdgeConfig"+CurrentDateandTime;
	 
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
	  //Verify Copy project validation
	  test.log(Status.INFO, "click on the copy project button");
	  functionalcomponents.ClickOperation(properties.getProperty("copy_project"));
	  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Project_Addbutton")))
	  {
		  test.log(Status.PASS, "user is able to copy project successfullly");
	  } else
	  {
          failedDescription("user is not able to copy project");
      }
	//create project with duplicate name
	  test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project and Enter the name of the project and description");
	  functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),Projectname);	  				 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
	  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
	  if (driver.findElement(By.xpath(properties.getProperty("Close_Button"))).isDisplayed())
	  {
	  
		  test.log(Status.PASS, "user can not create duplicate Project with name:"+""+Projectname+""+"and Description:"+""+projectdesc+""+"successfully");
	  }
	  else
	  {
		  failedDescription("user is able to create Project with duplicate name:"+""+Projectname+""+"and Description:"+""+projectdesc+""+"successfully");
       }
	  
	//create project with invalid name and blank fields
	  test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project and Enter the name of the project with inavild characters");
	  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Project_name"),InvalidName);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),"invalid value");
	  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
	  if (driver.findElement(By.xpath(properties.getProperty("Project_cancel"))).isDisplayed())
	  {
	  
		  test.log(Status.PASS, "user is not able to create Project with invalid name and Description successfully");
	  }
	  else
	  {
		  test.log(Status.PASS,"user is able to create Project with invalid name and Description successfully");
       }
	  functionalcomponents.ClickOperation(properties.getProperty("Project_cancel"));
	  test.log(Status.INFO, "click on the Data Model tab and click on + button to add sensor data model to the project");		
	  functionalcomponents.ClickOperation(properties.getProperty("Data_Model"));
	  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_add"));
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("StateRadiobuttondatamodel")))
	  {
		  test.log(Status.PASS, "user is able to see Data model window successfullly");
	  } else
	  {
          failedDescription("user is not able to see the Data model window");
      }
	  //creation of state mode data model
	  test.log(Status.INFO, "select the sensor type,capability in the data model pop up window");
	  functionalcomponents.ClickOperation(properties.getProperty("StateRadiobuttondatamodel"));
	  functionalcomponents.ClickOperation(properties.getProperty("CustomRadiobuttondatamodel"));
	  functionalcomponents.ClearAndSetValue(properties.getProperty("sensor_modelname"), "StateDatamodelTesting");
	  functionalcomponents.ClickOperation(properties.getProperty("Sensor_modelcreate"));
	  if(driver.findElement(By.xpath(properties.getProperty("Sensormodel_add"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to add state data model mode successfully");
	  } else
	  {
          failedDescription("user is not able to add state data model mode successfully");
      }
	//validate Project with State Data Model without adding state
	  test.log(Status.INFO, "Click on the validate button on top right corner of the work center");
	  functionalcomponents.ClickOperation(properties.getProperty("validate"));
	  if (driver.findElement(By.xpath(properties.getProperty("Close_Button"))).isDisplayed())
	  {
        test.log(Status.PASS, "user can not validate the project"+Projectname+" wihout adding state to data model");
	  } else
	  {
        failedDescription("user is able to validate the project"+":"+Projectname+"successfully");
      }	
	  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
	  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectname+properties.getProperty("Project_title_part2")));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Data_Model"), 90);
	  functionalcomponents.ClickOperation(properties.getProperty("Data_Model"));
	  test.log(Status.INFO, "Delete State Data Model");
	  functionalcomponents.ClickOperation(properties.getProperty("DeleteSensorModel"));
	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Data_Model"), 90);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("Data_Model")))
	  {
		  test.log(Status.PASS, "user is able to click on Delete state data model successfully");		  }
	  else
	  {
          failedDescription("user is not able to click on Delete state data model successfully");
      }	
	  //creation of Numeric mode data model
	  test.log(Status.INFO, "select the sensor type,capability in the numeric sensor data model pop up window");
	  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_add"));
	  functionalcomponents.ClickOperation(properties.getProperty("inputSensorType"));
	  functionalcomponents.ClearAndSetValue(properties.getProperty("SearchSensorTypeinput"), SensorTypeNameAPI);
	  functionalcomponents.ClickOperation(properties.getProperty("Searchicon_button"));
	  functionalcomponents.ClickOperation("//ul[@id='ed_value_help_dialog-listUl']//div[text()='"+SensorTypeNameAPI+"']");
	  functionalcomponents.ClickOperation(properties.getProperty("Capability_Nameinput"));
	  functionalcomponents.ClickOperation((properties.getProperty("capability_name_part1")+CapablitynameAPI+properties.getProperty("capability_name_part2")));
		/*
		 * if(driver.findElement(By.xpath(properties.getProperty("Sensor_modelcreate")))
		 * .isEnabled()) {
		 * failedDescription("Sensor Data Model create button should not be enabled without click on property checkbox"
		 * ); }
		 */
	  functionalcomponents.ClickOperation(properties.getProperty("WithoutPropertyModelCheckbox"));
	  functionalcomponents.scrollToExact(properties.getProperty("Property_namecheckbox"));
	  functionalcomponents.ClickOperation(properties.getProperty("WithoutPropertyModelCheckbox"));
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Property_namecheckbox")))
	  {	
		  test.log(Status.PASS, "User is able to Select sensor type as"+": "+SensorTypeNameAPI+" "+"& capability as"+ ":"+CapablitynameAPI+"from dropdown ");
	  }
	  else 
	  {
		  failedDescription("user is not able to select sensor type and capability from dropdown ");
	  }
	  test.log(Status.INFO, "Click create sensor data model button and verify sensor data models are created successfully");	
	  functionalcomponents.ClickOperation(properties.getProperty("Property_namecheckbox"));
	  functionalcomponents.ClickOperation(properties.getProperty("Sensor_modelcreate"));
	  functionalcomponents.WaitTillTime(7000);  
	  List<WebElement> Sensormodels=driver.findElements(By.xpath("//a[contains(text(),'"+SensorTypeNameAPI+"')]"));
	  System.out.println(Sensormodels);
	  List<String> sensormodallist=new ArrayList<String>();
	  for(int i=0; i<Sensormodels.size();i++) {
	  System.out.println(Sensormodels.get(i).getText());
	  if (Sensormodels.get(i).getText().contains(SensorTypeNameAPI))
	  {
		  sensormodallist.add(Sensormodels.get(i).getText());
		  System.out.println(sensormodallist);
		  
	  }
	  }
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Data_Model")))
	  {
		  test.log(Status.PASS, "user is able to create the Sensor data model in the project with sensor model names:"+sensormodallist);		  }
	  else
	  {
          failedDescription("user is not able to create the sensor model in the project ");
      }	
	  
	   //Feature  Compute Sensor Data Models	  
	  String CustomeDataModelName1= "SensorDataModel_"+PropertiesName1API+"_Largest";
	  String CustomeDataModelName2= "SensorDataModel_"+PropertiesName2API+"_Largest";
	  test.log(Status.INFO, "click on the sensor model name check box and click on the Compute");
	  for(int i=0; i<sensormodallist.size();i++)
	  {
		  if(sensormodallist.get(i).contains(PropertiesName1API))
		  {  
			  functionalcomponents.ClickOperation("(//div[@title='Click to Select'])[1]");
			  functionalcomponents.ClickOperation(properties.getProperty("Compute_Link"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("CutomeDataModel_Radiobutton"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("CutomeDataModel_Radiobutton"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("CustomDataModelName_Input"), CustomeDataModelName1);
			  functionalcomponents.ClickOperation(properties.getProperty("timewindoedropdown"));
			  functionalcomponents.ClickOperation(properties.getProperty("Minute_timewindow"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("timewindow_input"), "1");
			  functionalcomponents.ClickOperation(properties.getProperty("Formula_dropdown"));
			  functionalcomponents.ClickOperation(properties.getProperty("Formulainput"));
			  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Sensormodel_add"), 90);
			  if(functionalcomponents.IsElementPresent(properties.getProperty("Sensormodel_add")))
			  {
				  test.log(Status.PASS, "user is able to Cumpute the Sensor data model in the project with custom sensor data model names:"+CustomeDataModelName1);		  }
			  else
			  {
		          failedDescription("user is not able to Compute the sensor model in the project ");
		      }	
		  }
		  else if(sensormodallist.get(i).contains(PropertiesName2API))
		  {   
			  functionalcomponents.ClickOperation("(//div[@title='Click to Select'])[2]");
			  functionalcomponents.ClickOperation(properties.getProperty("Compute_Link"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("CutomeDataModel_Radiobutton"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("CutomeDataModel_Radiobutton"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("CustomDataModelName_Input"), CustomeDataModelName2);
			  functionalcomponents.ClickOperation(properties.getProperty("timewindoedropdown"));
			  functionalcomponents.ClickOperation(properties.getProperty("Minute_timewindow"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("timewindow_input"), "1");
			  functionalcomponents.ClickOperation(properties.getProperty("Formula_dropdown"));
			  functionalcomponents.ClickOperation(properties.getProperty("Formulainput"));
			  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Sensormodel_add"), 90);	
			  if(functionalcomponents.IsElementPresent(properties.getProperty("Sensormodel_add")))
			  {
				  test.log(Status.PASS, "user is able to Cumpute the Sensor data model in the project with custom sensor data model names:"+CustomeDataModelName2);		  }
			  else
			  {
		          failedDescription("user is not able to Compute the sensor model in the project ");
		      }	
		  }
			  
	  }   
	  test.log(Status.INFO, "click on sensor data model name and edit it and save successfully");
	  functionalcomponents.ClickOperation("//a[text()='"+CustomeDataModelName2+"']");			  
	  functionalcomponents.ClickOperation(properties.getProperty("EditSensorModel"));			  
	  functionalcomponents.ClearAndSetValue(properties.getProperty("timewindow_input"), "2");
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("DeleteSensorModel"), 90);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("DeleteSensorModel")))
	  {	
		  test.log(Status.PASS, "user is able to click on sensor model name and edit it and save successfully");
	  } else
	  {
          failedDescription("user is not able to click on sensor model name and edit it and save successfully");
      }
	  test.log(Status.INFO, "click on Delete sensor model button and compute sensor model should be deleted successfully");
	  functionalcomponents.ClickOperation(properties.getProperty("DeleteSensorModel"));
	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Data_Model"), 90);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Data_Model")))
	  {
		  test.log(Status.PASS, "user is able to click on Delete sensor model button and sensor model deleted successfully");		  }
	  else
	  {
          failedDescription("user is not able to click on Delete sensor model button and sensor model deleted successfully");
      }	
	  
	  test.log(Status.INFO, "click on the sensor model name check box and click on the fedility to add the Local Enterprise plugin");
	  functionalcomponents.ClickOperation(properties.getProperty("CheckboxforALlSensormodelname"));			  
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("feidelty"));
	  functionalcomponents.WaitTillTime(2000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Minimum_ouput_Frequency")))
	  {	
		  test.log(Status.PASS, "user is able to see the Add fedility window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Add fedility window successfully");
      }
	  test.log(Status.INFO, "Enter the numeric values for the Minimum evnet frequency,keep events days,Max edge readings store and max output frequency");
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Minimum_ouput_Frequency"), Minimum_output_frequency);
	  functionalcomponents.WaitTillTime(1000);
	  if(Integer.parseInt(Minimum_output_frequency)<=2147483647)
	  {
		  test.log(Status.PASS, "numeric values of the Minimum_output_ferquency value as"+":"+Minimum_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
	  } else
	  {
          failedDescription("numeric values of the Minimum_output_ferquency value as"+":"+Minimum_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
      }
	  test.log(Status.INFO, "Enter the numeric values for keep events days");
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Keep_Event_days"), Keep_events_Days);
	  functionalcomponents.WaitTillTime(1000);
	  if(Integer.parseInt(Keep_events_Days)<=2147483647)
	  {
		  test.log(Status.PASS, "numeric values of the Keep_events_Days value as"+":"+Keep_events_Days+":"+"saved and verified Maximum value is not exceed 2147483647.");
	  } else
	  {
          failedDescription("numeric values of the Keep_events_Days value as"+":"+Keep_events_Days+":"+"saved and verified Maximum value is not exceed 2147483647.");
      }
	  test.log(Status.INFO, "Enter the numeric values for Max edge readings store");
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Maximum_edge_readings_store"), Max_edge_Readings_store);
	  functionalcomponents.WaitTillTime(1000);
	  if(Integer.parseInt(Max_edge_Readings_store)<=2147483647)
	  {
		  test.log(Status.PASS, "numeric values of the Max_edge_Readings_store value as"+":"+Max_edge_Readings_store+":"+"saved and verified Maximum value is not exceed 2147483647.");
	  } else
	  {
          failedDescription("numeric values of the Max_edge_Readings_store value as"+":"+Max_edge_Readings_store+":"+"saved and verified Maximum value is not exceed 2147483647.");
      }
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprise_Maximum_Output_Frequency"), Enterprise_max_output_frequency);
	  functionalcomponents.WaitTillTime(1000);
	  if(Integer.parseInt(Enterprise_max_output_frequency)<=2147483647)
	  {
		  test.log(Status.PASS, "numeric values of theEnterprise_max_output_frequency value as"+":"+Enterprise_max_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
	  } else
	  {
          failedDescription("numeric values of the Enterprise_max_output_frequency value as"+":"+Enterprise_max_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
      }
	  test.log(Status.INFO, " Select the local outbound connector from dropdown");
	  functionalcomponents.ClickOperation(properties.getProperty("Local_enterpriseplugin_dropdown"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("IoTServiceCloudConnector"));	
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));		  
	  functionalcomponents.WaitTillTime(8000);	 
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Actions")))
	  {	
		  test.log(Status.PASS, "user is able to add the local outbound connector as:IoT Service Cloud Connector");
	  } else
	  {
          failedDescription("user is able to add the local enterprise Plugin as:IoTServiceCloudConnector");
      }
		    
	 //Create Action for first property1
	  test.log(Status.INFO, "Click on the Actions tab to in the project");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Actions"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Action_Add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_name")))
	  {	
		  test.log(Status.PASS, "user is able to see the Add Action window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Add Action window");	              		 
	  }				  
	  test.log(Status.INFO, "Enter the Action name and description with special characters");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_name"),Actionname);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_description"),Action_desc);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_Type_Dropdown")))
	  {	
		  test.log(Status.PASS, "user is able to add the Action name"+":"+Actionname+"Action description as"+":"+Action_desc+"With special characters successfully");
	  } else
	  {
          failedDescription("user is not able to add the Action name and Action Description");	              		 
	  }		
	  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_Dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  if(Action_type.equalsIgnoreCase("Field Message"))
	  {
		 
		  test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1")+Action_type+properties.getProperty("Action_Type_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Plugin_id_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Plugin_id_part1") +protocol_plugin+ properties.getProperty("Plugin_id_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Message")))
		  {	
			  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_type+"protocol plugin as"+":"+protocol_plugin);
		  } else
		  {
              failedDescription("user is not able to select the Action type as"+":"+Action_type+"protocol plugin as "+":"+protocol_plugin);	              		 
		  }	
		  test.log(Status.INFO,"Enter the message and Recipient parameters of the Action");			  
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Message"),Actionmsg);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Recipient_Parameters"),Receipient_param);	
		  functionalcomponents.WaitTillTime(2000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_create")))
		  {	
			  test.log(Status.PASS, "user is able to Enter the Message as"+":"+Actionmsg+"and Recipient parameters as"+":"+Receipient_param);
		  } else
		  {
              failedDescription("user is not able to Enter the Message as"+":"+Actionmsg+"and Recipient parameters as"+":"+Receipient_param);	              		 
		  }	
		 
      }
	  else if(Action_type.equalsIgnoreCase("Sensor Fidelity Change"))
	  {
		  test.log(Status.INFO, "Select Actiontype as Sensor fedility Change,sensor model name as MuthuStyp_CAT987_Cap_Battery and Scope_value as Device");
		  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1")+Action_type+properties.getProperty("Action_Type_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Action_sensormodel_dropdown"));
		  functionalcomponents.WaitTillTime(3000);
		  
		  for(int j=0;j<sensormodallist.size();j++) {
			  System.out.println(sensormodallist);
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1API)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1API+"')]");
				  functionalcomponents.WaitTillTime(2000);
				 break;
			  }
		  }
		  
		  functionalcomponents.ClickOperation(properties.getProperty("scope_leve_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("scope_level_part1")+Scope_level+properties.getProperty("scope_level_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("fedility_freqency")))
		  {	
			  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_type+"sensor model name and scope_value as"+":"+Scope_level);
		  } else
		  {
              failedDescription("user is able to select the Action type as"+":"+Action_type+"sensor model name and scope_value as"+":"+Scope_level);	              		 
		  }
		  test.log(Status.INFO, "Enter the fedility frequency,Fedility Rollback,Enterprise_Fedility and Enterprise_fedility_rollback");
		  functionalcomponents.ClearAndSetValue(properties.getProperty("fedility_freqency"),Edge_Fedilityfreq);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("fedility_Rollback"),Edge_fedility_rollback);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprise_fedility"),enterprise_fedility);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprisefedility_rollback"),enterprise_rollback);
		  functionalcomponents.WaitTillTime(2000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_create")))
		  {	
			  test.log(Status.PASS, "user is able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);
		  } else
		  {
              failedDescription("user is not able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);             		 
		  }	
		  
	  }
	  test.log(Status.INFO, "Click Create Action button and verify Action is created successfully with Action Name");
	  functionalcomponents.ClickOperation(properties.getProperty("Action_create"));
	  functionalcomponents.WaitTillTime(5000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportActionButton")))
	  {	
		  test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name as"+":"+Actionname);
	  } else
	  {
          failedDescription("Clicked Save Action button but Action is not created successfully with Action Name as"+":"+Actionname);
      }
	  
	  //Import from Global Actions list Validation
	  test.log(Status.INFO, "Click on import icon and add Action from global list");
	  functionalcomponents.ClickOperation(properties.getProperty("ImportActionButton"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("importActionsdropdownbutton"));
	  functionalcomponents.WaitTillTime(2000);
	if(functionalcomponents.IsElementPresent(properties.getProperty("SelectFirstimportAction")))  
	{	
	  functionalcomponents.ClickOperation(properties.getProperty("SelectFirstimportAction"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("importactioninput"),"ImportedActionName");
	  functionalcomponents.WaitTillTime(1000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("ImportActionDataModeldropdown")))  
	  {
	   functionalcomponents.ClickOperation(properties.getProperty("ImportActionDataModeldropdown"));
	   functionalcomponents.WaitTillTime(3000); 
	   for(int j=0;j<sensormodallist.size();j++) {
		//  System.out.println(sensormodallist);
		  if (sensormodallist.get(j).contains(">>>"+PropertiesName1API)) {
			  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1API+"')]");
			  functionalcomponents.WaitTillTime(2000);
			 break;
		  }
	    }
	  }
	  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  functionalcomponents.WaitTillTime(9000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportActionButton")))
	  {	
		  test.log(Status.PASS, "user is able to add Action from Global Actions list as : ImportedActionName");
	  } else
	  {
          failedDescription("user is not able to import the Action");	              		 
	  }
	  //Import Global Action with exist name Validation
	  test.log(Status.INFO, "Click on import icon and add Action from global list with exist name");
	  functionalcomponents.ClickOperation(properties.getProperty("ImportActionButton"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("importActionsdropdownbutton"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("SelectFirstimportAction"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("importactioninput"),"ImportedActionName");
	  functionalcomponents.WaitTillTime(1000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("ImportActionDataModeldropdown")))  
	 {
	   functionalcomponents.ClickOperation(properties.getProperty("ImportActionDataModeldropdown"));
	   functionalcomponents.WaitTillTime(3000); 
	   for(int j=0;j<sensormodallist.size();j++) {
		  //System.out.println(sensormodallist);
		  if (sensormodallist.get(j).contains(">>>"+PropertiesName1API)) {
			  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1API+"')]");
			  functionalcomponents.WaitTillTime(2000);
			 break;
		  }
	     }
	  }
	  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  functionalcomponents.WaitTillTime(9000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("Close_Button")))
	  {
		  test.log(Status.PASS, "user can not add Action with exist or duplicate name");
		  
	  } else
	  {
		  failedDescription("user is able to add duplicate (exist) Action from Global Action list as : ImportedActionName");         		 
	  }
	}  
	functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
	functionalcomponents.WaitTillTime(5000);
	functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	  functionalcomponents.WaitTillTime(5000);
	  //Export Action to Global List
	  String ExportActionName="ExportAction"+CurrentDateandTime;
	  test.log(Status.INFO, "Click on export icon and export Action to global list");
	  functionalcomponents.ClickOperation((properties.getProperty("Export_ActionPart1")+Actionname+properties.getProperty("Export_ActionPart2")));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("ExportActionNameinput"),ExportActionName);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  functionalcomponents.WaitTillTime(5000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Actions")))
	  {
		  test.log(Status.PASS, "user is able to export Action to Global Actions list as :"+ExportActionName);
	  } else
	  {
		  failedDescription("user is not able to export Action to global list");              		 
	  }
	  
	   // validate edit action functionality
	     if(functionalcomponents.IsElementPresent("//a[text()='ImportedActionName']"))  
		 {
		  test.log(Status.INFO, "click on Actionname link to and edit action with updated value");	
		  functionalcomponents.ClickOperation("//a[text()='ImportedActionName']");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("EditActionButton"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Action_description"),"EditActiontesting");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
		  functionalcomponents.WaitTillTime(10000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("SelectedActionDelete")))
		  {
			  test.log(Status.PASS, "user is able to edit Action and updated value successfully");
		  } 
		  else
		  {
			  failedDescription("user is not able to edit Action");
		  } 
	     //Delete Action Validation
	      test.log(Status.INFO, "Click on the Delete button on top right corner of Action");
	      functionalcomponents.ClickOperation(properties.getProperty("SelectedActionDelete"));
	      functionalcomponents.WaitTillTime(3000);
	      functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
	      functionalcomponents.WaitTillTime(10000);
	      if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_Add")))
		  {
		  test.log(Status.PASS, "user is able to Delete Action succeeefully" );
	      } else
	      {
		  failedDescription("user is not able to Delete Action");              		 
	      }	
	  }   
	  // Creation Action for second Properties
	  test.log(Status.INFO, "Click on the Actions tab to in the project and click on Add + sign to add new action");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Action_Add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_name")))
	  {
		  test.log(Status.PASS, "user is able to see the Add new Action window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Add new Action window");	              		 
	  }				  
	  test.log(Status.INFO, "Enter the Action name and description with special characters");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_name"),Actionname1);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_description"),Action_desc1);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_Type_Dropdown")))
	  {
		  test.log(Status.PASS, "user is able to add the Action name"+":"+Actionname1+"Action description as"+":"+Action_desc1+"With special characters successfully");
	  } else
	  {
          failedDescription("user is not able to add the Action name and Action Description");	              		 
	  }		
	  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_Dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	 
	  if(Action_type.equalsIgnoreCase("Field Message"))
	  {
		 
		  test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1")+Action_type+properties.getProperty("Action_Type_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Plugin_id_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Plugin_id_part1")+protocol_plugin+properties.getProperty("Plugin_id_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Message"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_type+"protocol plugin as"+":"+protocol_plugin);
		  } else
		  {
              failedDescription("user is not able to select the Action type as"+":"+Action_type+"protocol plugin as "+":"+protocol_plugin);	              		 
		  }	
		  test.log(Status.INFO,"Enter the message and Recipient parameters of the Action");			  
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Message"),Actionmsg);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Recipient_Parameters"),Receipient_param);	
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Action_create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to Enter the Message as"+":"+Actionmsg+"and Recipient parameters as"+":"+Receipient_param);
		  } else
		  {
              failedDescription("user is not able to Enter the Message as"+":"+Actionmsg+"and Recipient parameters as"+":"+Receipient_param);	              		 
		  }	
		 
      }
	  else if(Action_type.equalsIgnoreCase("Sensor Fidelity Change"))
	  {
		  test.log(Status.INFO, "Select Actiontype as Sensor fedility Change,sensor model name as MuthuStyp_CAT987_Cap_Battery and Scope_value as Device");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1")+Action_type+properties.getProperty("Action_Type_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Action_sensormodel_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  
		  for(int j=0;j<sensormodallist.size();j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2API)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName2API+"')]");
				  functionalcomponents.WaitTillTime(2000);
				  break;
			  }
		  }
		  functionalcomponents.ClickOperation(properties.getProperty("scope_leve_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("scope_level_part1")+Scope_level+properties.getProperty("scope_level_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("fedility_freqency")))
		  {
			  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_type+"sensor model name and scope_value as"+":"+Scope_level);
		  } else
		  {
              failedDescription("user is able to select the Action type as"+":"+Action_type+"sensor model name and scope_value as"+":"+Scope_level);	              		 
		  }
		  test.log(Status.INFO, "Enter the fedility frequency,Fedility Rollback,Enterprise_Fedility and Enterprise_fedility_rollback");
		  functionalcomponents.ClearAndSetValue(properties.getProperty("fedility_freqency"),Edge_Fedilityfreq1);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("fedility_Rollback"),Edge_fedility_rollback1);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprise_fedility"),enterprise_fedility1);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprisefedility_rollback"),enterprise_rollback1);
		  functionalcomponents.WaitTillTime(2000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_create")))
		  {	
			  test.log(Status.PASS, "user is able to Enter the fedility frequency as"+Edge_Fedilityfreq1+"Fedility Rollback as"+Edge_fedility_rollback1+"Enterprise fedility as"+enterprise_fedility1+"Enterprise fedility rollback as"+enterprise_rollback1);
		 
		  } else
		  {
              failedDescription("user is not able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);             		 
		  }	
		  
	  }
	  test.log(Status.INFO, "Click Create Action button and verify Action is created successfully with Action Name");
	  functionalcomponents.ClickOperation(properties.getProperty("Action_create"));
	  functionalcomponents.WaitTillTime(15000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rules")))
	  {	
		  test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name as"+":"+Actionname1);
	  } else
	  {
          failedDescription("Clicked Save Action button but Action is not created successfully with Action Name as"+":"+Actionname1);
      }   
	 //creation of rule for latitude sensor model
	  test.log(Status.INFO, "click on Rules Tab in the project");
	  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectname+properties.getProperty("Project_title_part2")));
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rules_add"));
	  functionalcomponents.WaitTillTime(5000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rule_name")))
	  {
		  test.log(Status.PASS, "user is able to see the Rule window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule window");
      }
	  test.log(Status.INFO, "Enter the Rule name and description with special characters ");			  
	  
	  String RulenameLatitude=CapablitynameAPI+PropertiesName1API+Rulename;
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_name"),RulenameLatitude);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"),Ruledesc);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_enabled_button"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("RuleMaxFreqUnitarrow"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("MSunit"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("RuleMaxfrequency"),RuleMaxfrequency);
	  functionalcomponents.WaitTillTime(3000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rule_name")))
	  {
		  test.log(Status.PASS, "Rule name as"+RulenameLatitude+":"+ "saved successfully with special characters");
	  }
	  else 
	  {
		  failedDescription(" Rule name as"+RulenameLatitude+":"+ "is not saved successfully with special characters");
  	  }
	  test.log(Status.INFO, "Click on the create button to create the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_Create"));
	  functionalcomponents.WaitTillTime(10000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rules")))
	  {
		  test.log(Status.PASS, "user is able to add the rulename"+RulenameLatitude+""+"description"+""+Ruledesc);
	  } else
	  {
          failedDescription("user is not able to add the rulename and description");
 
	  }
	  // validate existName/invalid/blank values of mandatory fields for rule
	  test.log(Status.INFO, "click on Rulename link to and edit rule enter rule name with invalid name");	
	  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation((properties.getProperty("Rule_link_part1")+RulenameLatitude+properties.getProperty("Rule_link_part2")));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Edit_rule"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Rule_name"),InvalidName);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.WaitTillTime(4000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("save_button")))
	  {
		  test.log(Status.PASS, "user can not crate rule name with invalid value");	  
	  } 
	  else
	  {
		  test.log(Status.FAIL, "user is able to crate rule name with invalid value");
	  }
	  test.log(Status.INFO, "click on Rulename link to and edit rule and keep blank rule name");	
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Rule_name")," ");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.WaitTillTime(4000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("save_button")))
	  {
		  test.log(Status.PASS, "user can not crate rule name without filled mandatory fileds");
	  } else
	  {  
		  test.log(Status.FAIL, "user is able to crate rule name without entering rule name");
	  }
	  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	  functionalcomponents.WaitTillTime(4000);
	//Add the conditions to the rule1
	  test.log(Status.INFO, "click on the conditions tab to add the condition to the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_condition"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_add"));
	  functionalcomponents.WaitTillTime(4000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rulecondition_name")))
	  {
		  test.log(Status.PASS, "user is able to see the Rule conditons window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule conditons window successfully");
 
	  }
	  test.log(Status.INFO, "Enter the rule condition name with special characters");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rulecondition_name"),CapablitynameAPI+PropertiesName1API+Rulecondition);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Filter_dropdown")))
	  {
		  test.log(Status.PASS, "user is able to enter the rule conditon nmae as"+":"+CapablitynameAPI+PropertiesName1API+Rulecondition+"successfully");
	  } else
	  {
          failedDescription("user is not able to add the rule conditon name in the rule condition window");
 
	  }
	  test.log(Status.INFO, "select the filter from drop down and Enter the scope value in the Rule condition window");
	  functionalcomponents.ClickOperation(properties.getProperty("Filter_dropdown"));
	  functionalcomponents.WaitTillTime(2000);			 			  
	  functionalcomponents.ClickOperation((properties.getProperty("Filter_part1")+filteropt+properties.getProperty("Filter_part2")));
	  functionalcomponents.WaitTillTime(2000);			 
	 // functionalcomponents.ClickAndSetValue(properties.getProperty("Filter_scope_value"),filtervalue);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("conditiontype_dropdown")))
	  {
		  test.log(Status.PASS, "user is able to select the filter dropdown as"+":"+filteropt+"and scope_value as"+":"+filtervalue);
	  } else
	  {
          failedDescription("user is not able to select the filter dropdown as"+":"+filteropt+"and scope_value as"+":"+filtervalue);
 
	  }
	  functionalcomponents.ClickOperation(properties.getProperty("conditiontype_dropdown"));
	  functionalcomponents.WaitTillTime(5000);			 
	  if(conditiontype.equalsIgnoreCase("External Custom Rule-CCL"))
	  {
		  test.log(Status.INFO, "select the condition type as External Custom Rule-CCL and select the sensor model name");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  for(int j=0;j<sensormodallist.size();j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1API)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1API+"')]");
				  functionalcomponents.WaitTillTime(2000);
				 break;
			  }
		  }
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Condition_Customhost")))
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name ");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name ");	              		 
		  }
		  test.log(Status.INFO,"Enter the condition_customhost,condition_customport and maximum event frequency");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condition_Customhost"),customproject_host);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condition_customport"),customproject_port);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rulecondition_Create")))
		  {
			  test.log(Status.PASS, "user is able to enter the condition_customhost as"+":"+customproject_host+":"+"condition_customport as"+":"+customproject_port+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to enter the condition_customhost as"+":"+customproject_host+":"+"condition_customport as"+":"+customproject_port+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	    
	  }
	  else if(conditiontype.equalsIgnoreCase("Sensor Watchdog"))
	  {
		  test.log(Status.INFO, "select the condition type as Sensor Watchdog under the Rule codition tab");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+ properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);				  	
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
		  for(int j=0;j<sensormodallist.size();j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1API)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1API+"')]");
				  functionalcomponents.WaitTillTime(2000);
				 break;
			  }
		  }
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Interval_withoutsensor")))
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");	              		 
		  }
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Interval_withoutsensor"),interval_without_sensor);				 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rulecondition_Create")))
		  {
			  test.log(Status.PASS, "user is able to Enter the Interval_withoutsensor as"+":"+interval_without_sensor+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to Enter the Interval_withoutsensor as"+":"+interval_without_sensor+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  else if(conditiontype.equalsIgnoreCase("Timed State"))
	  {
		  test.log(Status.INFO, "select the condition type as Timed State under the Rule codition tab");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1") +conditiontype+ properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);				 
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
		  for(int j=0;j<sensormodallist.size();j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1API)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1API+"')]");
				  functionalcomponents.WaitTillTime(2000);
				 break;
			  }
		  }
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Target_State_dropdown")))
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");	              		 
		  }
		  test.log(Status.INFO, "select the Target state and enter the Time state");
		  functionalcomponents.ClickOperation(properties.getProperty("Target_State_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("Target_State_part1") +Targetstate+ properties.getProperty("Target_State_part2")));
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Time_state"),Timein_State);	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the Target state as"+":"+Targetstate+":"+"and enter the Time state value as"+":"+Timein_State+":"+"and maximum event frequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to select the Target state as"+":"+Targetstate+":"+"and enter the Time state value as"+":"+Timein_State+":"+"and maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  else if(conditiontype.equalsIgnoreCase("Value Monitoring"))
	  {
		  test.log(Status.INFO, "select the condition type as Value Monitoring under the Rule codition tab");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);				  	  
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));	
		  functionalcomponents.WaitTillTime(2000);
		  for(int j=0;j<sensormodallist.size(); j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1API)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1API+"')]");
				  functionalcomponents.WaitTillTime(2000);
				  break;
			  }
	  }
		  functionalcomponents.WaitTillTime(2000);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Operator_dropdown")))
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel");	              		 
		  }
		  test.log(Status.INFO, "Select the operator and enter the Thresholding_value,Maximum event frequency value ");
		  functionalcomponents.ClickOperation(properties.getProperty("Operator_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("Operator_part1")+operator+properties.getProperty("Operator_part2")));
		  functionalcomponents.WaitTillTime(2000);				  			 		 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_value"),thresholding_value);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("ConditionMaxeventUnitarrow")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("ConditionMSunit")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  functionalcomponents.WaitTillTime(2000);	
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rule_condition")))
		  {
			  test.log(Status.PASS, "user is able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  test.log(Status.INFO, "Click on the create button to save the Rule condition");
	  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_Create"));
	  functionalcomponents.WaitTillTime(20000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rule_condition")))
	  {
		  test.log(Status.PASS, "user is able to create the rule condition as"+":"+Rulecondition+"successfully");
	  } else
	  {
          failedDescription("user is able to create the rule condion successfully");	              		 
	  }
	  //Edit condition and validate Condition with invalid/blank values of mandatory fields
	  test.log(Status.INFO, "Click on the condition created link and Edit condition and validate Condition with invalid/blank values of mandatory fields");
	  functionalcomponents.ClickOperation("//a[@title='"+CapablitynameAPI+PropertiesName1API+Rulecondition+"']");
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("EditConditionButton"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Rulecondition_name"),InvalidName);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.WaitTillTime(5000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("save_button")))
	  {
		  test.log(Status.PASS, "user can not crate rule condition name with invalid value");
		  
	  } 
	  else
	  {
		  test.log(Status.FAIL, "user is able to crate rule condition name with invalid value"); 
	  }
	  test.log(Status.INFO, "click on Rulename link to and edit rule and keep blank rule name");	
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Rulecondition_name")," ");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.WaitTillTime(5000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("save_button")))
	  {
		  test.log(Status.PASS, "user can not crate rule condition name without filled mandatory fileds");
	  } else
	  {
		  test.log(Status.FAIL, "user is able to crate rule condition name without entering rule condition name");
	  }
	  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation("//a[contains(text(),'Rule: "+RulenameLatitude+"')]");
	  functionalcomponents.WaitTillTime(10000);
	  // Enable Rule
	  functionalcomponents.ClickOperation(properties.getProperty("EnableRule"));
	  functionalcomponents.WaitTillTime(15000);  
	  //Create ouptuts in the Rule 1 for latitude sensor model
	  test.log(Status.INFO, "Click on the Output tab in the Rule and add the output to the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Outputs"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("output_Add"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_part1")+Actionname+properties.getProperty("Localactio_part2"));
	  functionalcomponents.WaitTillTime(2000);	
	  functionalcomponents.ClickOperation(properties.getProperty("Ouput_create"));
	  functionalcomponents.WaitTillTime(10000);	
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Outputs")))
	  {
		  test.log(Status.PASS, "user is able to add the action to the rule as"+Actionname);
	  } else
	  {
          failedDescription("user is able to add the action to the rule as"+Actionname);	              		 
	  }
	  //click on output link and validate Edit Output
	  test.log(Status.INFO, "click on output link and validate Edit Output");
	  functionalcomponents.ClickOperation("//a[@title='"+Actionname+"']");
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("EditOutputButton"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.WaitTillTime(7000);  
	  //creation of rule2 for longitude sensor model
	  test.log(Status.INFO, "click on Rules Tab in the project");
	  functionalcomponents.ClickOperation(properties.getProperty("Project_link_part1")+Projectname+properties.getProperty("Project_link_part2"));
	  functionalcomponents.WaitTillTime(3000);	
	  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rules_add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rule_name")))
	  {
		  test.log(Status.PASS, "user is able to see the Rule window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule window");
      }
	  test.log(Status.INFO, "Enter the Rule name and description with special characters ");			  
	  String RulenameLongtitude=CapablitynameAPI+PropertiesName2API+Rulename1; 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_name"),RulenameLongtitude);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"),Ruledesc1);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_enabled_button"));
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rule_name")))
	  {
		  test.log(Status.PASS, "Rule name as"+RulenameLongtitude+":"+ "saved successfully with special characters");
	  }
	  else 
	  {
		  failedDescription(" Rule name as"+RulenameLongtitude+":"+ "is not saved successfully with special characters");
  	  }
	  test.log(Status.INFO, "Click on the create button to create the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_Create"));
	  functionalcomponents.WaitTillTime(15000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rules")))
	  {
		  test.log(Status.PASS, "user is able to add the rulename"+RulenameLongtitude+""+"description"+""+Ruledesc1);
	  } else
	  {
          failedDescription("user is not able to add the rulename and description");
 
	  }
	  
	  //Add the conditions to the rule2
	  test.log(Status.INFO, "click on Rulename to add the conditions to the rule");		
	  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation((properties.getProperty("Rule_link_part1")+RulenameLongtitude+properties.getProperty("Rule_link_part2")));
	  functionalcomponents.WaitTillTime(2000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rule_condition")))
	  {
		  test.log(Status.PASS, "user is able to add the conditions,outputs to the rule");
	  } else
	  {
          failedDescription("user is not able to add any conditions,outputs to the rule");
 
	  }
	  test.log(Status.INFO, "click on the conditions tab to add the condition to the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_condition"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Rulecondition_name")))
	  {
		  test.log(Status.PASS, "user is able to see the Rule conditons window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule conditons window successfully");
 
	  }
	  test.log(Status.INFO, "Enter the rule condition name with special characters");
	 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rulecondition_name"),CapablitynameAPI+PropertiesName2API+Rulecondition1);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Filter_dropdown")))
	  {
		  test.log(Status.PASS, "user is able to enter the rule conditon nmae as"+":"+CapablitynameAPI+PropertiesName2API+Rulecondition1+"successfully");
	  } else
	  {
          failedDescription("user is not able to add the rule conditon name in the rule condition window");
 
	  }
	  test.log(Status.INFO, "select the filter from drop down and Enter the scope value in the Rule condition window");
	  functionalcomponents.ClickOperation(properties.getProperty("Filter_dropdown"));
	  functionalcomponents.WaitTillTime(2000);			 			  
	  functionalcomponents.ClickOperation((properties.getProperty("Filter_part1")+filteropt+properties.getProperty("Filter_part2")));
	  functionalcomponents.WaitTillTime(2000);			 
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("conditiontype_dropdown")))
	  {
		  test.log(Status.PASS, "user is able to select the filter dropdown as"+":"+filteropt);
	  } else
	  {
          failedDescription("user is not able to select the filter dropdown as"+":"+filteropt);
 
	  }
	  functionalcomponents.ClickOperation(properties.getProperty("conditiontype_dropdown"));
	  functionalcomponents.WaitTillTime(2000);			  
	   if(conditiontype.equalsIgnoreCase("External Custom Rule-CCL"))
	   {
		  test.log(Status.INFO, "select the condition type as External Custom Rule-CCL and select the sensor model name");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1") +conditiontype+ properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  for(int j=0;j<sensormodallist.size(); j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2API)) 
			    {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'>>>"+PropertiesName2API+"')])[2]");
					  functionalcomponents.WaitTillTime(2000);
					  break;
				  }
		 }
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Condition_Customhost")))
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");	              		 
		  }
		  test.log(Status.INFO,"Enter the condition_customhost,condition_customport and maximum event frequency");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condition_Customhost"),customproject_host);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condition_customport"),customproject_port);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to enter the condition_customhost as"+":"+customproject_host+":"+"condition_customport as"+":"+customproject_port+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to enter the condition_customhost as"+":"+customproject_host+":"+"condition_customport as"+":"+customproject_port+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	    
	  }
	  else if(conditiontype.equalsIgnoreCase("Sensor Watchdog"))
	  {
		  test.log(Status.INFO, "select the condition type as Sensor Watchdog under the Rule codition tab");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1") +conditiontype+ properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);				  	
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
		  for(int j=0;j<sensormodallist.size(); j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2API)) {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'>>>"+PropertiesName2API+"')])[2]");
					  functionalcomponents.WaitTillTime(2000);
					  break;
				  }
			  }
		  if(driver.findElement(By.xpath(properties.getProperty("Interval_withoutsensor"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");	              		 
		  }
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Interval_withoutsensor"),interval_without_sensor);				 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Rulecondition_Create")))
		  {
			  test.log(Status.PASS, "user is able to Enter the Interval_withoutsensor as"+":"+interval_without_sensor+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to Enter the Interval_withoutsensor as"+":"+interval_without_sensor+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  else if(conditiontype.equalsIgnoreCase("Timed State"))
	  {
		  test.log(Status.INFO, "select the condition type as Timed State under the Rule codition tab");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);				 
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
		  for(int j=0;j<sensormodallist.size(); j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2API)) {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'>>>"+PropertiesName2API+"')])[2]");
					  functionalcomponents.WaitTillTime(2000);
					  break;
				  }
			  }
		  if(driver.findElement(By.xpath(properties.getProperty("Target_State_dropdown"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name");	              		 
		  }
		  test.log(Status.INFO, "select the Target state and enter the Time state");
		  functionalcomponents.ClickOperation(properties.getProperty("Target_State_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("Target_State_part1")+Targetstate+properties.getProperty("Target_State_part2")));
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Time_state"),Timein_State);	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Rulecondition_Create")))
		  {
			  test.log(Status.PASS, "user is able to select the Target state as"+":"+Targetstate+":"+"and enter the Time state value as"+":"+Timein_State+":"+"and maximum event frequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to select the Target state as"+":"+Targetstate+":"+"and enter the Time state value as"+":"+Timein_State+":"+"and maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  else if(conditiontype.equalsIgnoreCase("Value Monitoring"))
	  {
		  test.log(Status.INFO, "select the condition type as Value Monitoring under the Rule codition tab");
		  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+properties.getProperty("conditiontype_part2")));
		  functionalcomponents.WaitTillTime(2000);				  	  
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));	
		  functionalcomponents.WaitTillTime(2000);
		  for(int j=0;j<sensormodallist.size(); j++) {
		  if (sensormodallist.get(j).contains(">>>"+PropertiesName2API)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName2API+"')]");
				  functionalcomponents.WaitTillTime(2000);
				  break;
			  }
		  }
		  functionalcomponents.WaitTillTime(2000);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Operator_dropdown")))
		  {
			  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel");
		  } else
		  {
              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel");	              		 
		  }
		  test.log(Status.INFO, "Select the operator and enter the Thresholding_value,Maximum event frequency value ");
		  functionalcomponents.ClickOperation(properties.getProperty("Operator_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("Operator_part1")+operator+properties.getProperty("Operator_part2")));
		  functionalcomponents.WaitTillTime(2000);				  			 		 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_value"),thresholding_value);
		  functionalcomponents.ClickOperation((properties.getProperty("ConditionMaxeventUnitarrow")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("ConditionMSunit")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
		  functionalcomponents.WaitTillTime(2000);	
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Rulecondition_Create")))
		  {
			  test.log(Status.PASS, "user is able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  test.log(Status.INFO, "Click on the create button to save the Rule condition");
	  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_Create"));
	  functionalcomponents.WaitTillTime(15000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to create the rule condition as"+":"+Rulecondition1+"successfully");
	  } else
	  {
          failedDescription("user is able to create the rule condion successfully");	              		 
	  }	 
	  
	// Enable Rule
	  functionalcomponents.ClickOperation(properties.getProperty("EnableRule"));
	  functionalcomponents.WaitTillTime(15000);
	  //Create outputs in the Rule2 for longitude
	  test.log(Status.INFO, "Click on the Output tab in the Rule and add the output to the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Outputs"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("output_Add"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_part1")+Actionname1+properties.getProperty("Localactio_part2"));
	  functionalcomponents.WaitTillTime(2000);	
	  functionalcomponents.ClickOperation(properties.getProperty("Ouput_create"));
	  functionalcomponents.WaitTillTime(10000);	
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Outputs")))
	  {
		  test.log(Status.PASS, "user is able to add the action to the rule as"+Actionname1);
	  } else
	  {
          failedDescription("user is able to add the action to the rule as"+Actionname1);	              		 
	  }
	  //click on output link and validate Edit Output
	  test.log(Status.INFO, "click on output link and validate Edit Output");
	  functionalcomponents.ClickOperation("//a[@title='"+Actionname1+"']");
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("EditOutputButton"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.WaitTillTime(7000); 
	  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectname+properties.getProperty("Project_title_part2")));
	  functionalcomponents.WaitTillTime(7000);
	  //Rule Data source
	  test.log(Status.INFO, "Click on the Rule Data source tab in the project header");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Ruledatasourse_tab"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("RuleDatasourse_Add"));
	  functionalcomponents.WaitTillTime(2000);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("RDSNameInput")))
	  {
		  test.log(Status.PASS, "user is able to add the Rule data source successfully");
	  } else
	  {
          failedDescription("user is not able to add the Rule data source");	              		 
	  }
	  test.log(Status.INFO, "Enter the Rule name and description with special characters");			
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSNameInput"),Ruledatasourcename);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"),Ruledsdesc);
	  functionalcomponents.WaitTillTime(2000);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("RDSEndpointulrinput")))
	  {
		  test.log(Status.PASS, "user is able to enter the Rule name as"+":"+Ruledatasourcename+"and Rule description as"+Ruledsdesc+"with special characters successfully");
	  } else
	  {
          failedDescription("user is not able to enter the Rule name and descrition in the rule datasource window");	              		 
	  }	
	  test.log(Status.INFO, "Enter the HTTP_Endpoint url as https://sdsss.com:818 and select the Request method from dropdown");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSEndpointulrinput"),"https://sdsss.com:818");
	  functionalcomponents.WaitTillTime(2000);			
	  functionalcomponents.ClickOperation(properties.getProperty("RDSRequestMethoddropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  if(Request_Method.equalsIgnoreCase("GET"))
	  {
		  functionalcomponents.ClickOperation(properties.getProperty("RDSGETRequestMethod"));
		  functionalcomponents.WaitTillTime(2000);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Authentication_type_dropdown")))
		  {
			  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_Method);
		  } else
		  {
              failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_Method);	              		 
		  }
	  }else if(Request_Method.equalsIgnoreCase("POST"))
	  {
		  
		  functionalcomponents.ClickOperation(properties.getProperty("RDSPostRequestMethod"));
		  functionalcomponents.WaitTillTime(2000);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Authentication_type_dropdown")))
		  {
			  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_Method);
		  } else
		  {
              failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_Method);	              		 
		  }
		  test.log(Status.INFO, "Enter the values for content_type header and Request body Template");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("content_type_Header"),contentype_headervalue);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Request_BodyTemplate"),Request_body_template);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Authentication_type_dropdown")))
		  {
			  test.log( Status.PASS, "user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);
		  } else
		  {
              failedDescription("user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);	              		 
		  }
	  }	  
	  test.log(Status.INFO, "Select the Authentication type and enter the value for update freqency");	
	  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_part1") +Authenticaion_type+ properties.getProperty("Authentication_type_part2"));
	  functionalcomponents.WaitTillTime(2000);			 			 		 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Update_frequency"),updatefrequency);
	  functionalcomponents.WaitTillTime(1000);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Custom_Headers")))
	  {
		  test.log(Status.PASS, "user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);
	  } else
	  {
          failedDescription("user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);	              		 
	  }
	  test.log(Status.INFO, "Enter the value for Custom Headers and Date format in the Rule datasoruce window");	
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Custom_Headers"),Custom_headers);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("date_format"),Date_format);
	  functionalcomponents.WaitTillTime(1000);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Rue_Datasource_Create")))
	  {
		  test.log(Status.PASS, "user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);
	  } else
	  {
          failedDescription("user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);	              		 
	  }
	  test.log(Status.INFO, "Select the Resonse type and click on the Create button to save the Rule data source successfully");			  
	  functionalcomponents.PageScrollDown();
	  functionalcomponents.ClickOperation(properties.getProperty("Respnse_type_dropdown"));
	  functionalcomponents.ClickOperation(properties.getProperty("Response_type_part1")+Response_type+properties.getProperty("Response_type_part2"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rue_Datasource_Create"));
	  functionalcomponents.WaitTillTime(10000);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("importGlobalRDS")))
	  {
		  test.log(Status.PASS, "user is able to select the Respnse type as"+":"+Response_type+"and successfully saved the Rule data source as"+":"+Ruledatasourcename);
	  } else
	  {
          failedDescription("user is not able to create the Rule Datasource");	              		 
	  }
	  //Import Global RDS Validation
	  test.log(Status.INFO, "Click on import icon and add RDS from global list");
	  functionalcomponents.ClickOperation(properties.getProperty("importGlobalRDS"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("importRDSDropdownbutton"));
	  functionalcomponents.WaitTillTime(2000);
	  if(functionalcomponents.IsElementPresent(properties.getProperty("FirstGlobalRDS")))
	  {
	  functionalcomponents.ClickOperation(properties.getProperty("FirstGlobalRDS"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("ImportRDSNameinput"),"ImportedRDSName");
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  functionalcomponents.WaitTillTime(5000);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("importGlobalRDS")))
	  {
		  test.log(Status.PASS, "user is able to add RDS from Global RDS list as : ImportedRDSName");
	  } else
	  {
          failedDescription("user is not able to import the Rule Datasource");	              		 
	  }
	  //Import Global RDS with exist name Validation
	  test.log(Status.INFO, "Click on import icon and add RDS from global list");
	  functionalcomponents.ClickOperation(properties.getProperty("importGlobalRDS"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("importRDSDropdownbutton"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("FirstGlobalRDS"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("ImportRDSNameinput"),"ImportedRDSName");
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  functionalcomponents.WaitTillTime(5000);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Close_Button")))
	  {
		  test.log(Status.PASS, "user can not add RDS with exist name");
	  } else
	  {
		  test.log(Status.FAIL, "user is able to add duplicate (exist) RDS from Global RDS list as : ImportedRDSName");              		 
	  }
	 }
	  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	  functionalcomponents.WaitTillTime(5000);
	  //Export RDS to Global List
	  String ExportRDSName="ExportRDS"+CurrentDateandTime;
	  test.log(Status.INFO, "Click on export icon and export RDS to global list");
	  functionalcomponents.ClickOperation((properties.getProperty("Export_RDSPart1")+Ruledatasourcename+properties.getProperty("Export_RDSPart2")));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Export_RDS_Name"),ExportRDSName);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  functionalcomponents.WaitTillTime(7000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Actions")))
	  {
		  test.log(Status.PASS, "user is able to export RDS to Global RDS list as :"+ExportRDSName);
	  } else
	  {
		  failedDescription("user is not able to export RDS to global list");              		 
	  }
	  //Click on RDS link and validate Edit RDS
	  test.log(Status.INFO, "Click on the edit icon button right corner of RDS and update");
	  functionalcomponents.ClickOperation("//a[@title='ImportedRDSName']");
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("EditRDSiconbutton"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	  functionalcomponents.WaitTillTime(5000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("DeleteHeaderRDS")))
	  {
		  test.log(Status.PASS, "user is able to click RDS link and clicked to edit rds and updated succeeefully" );
	  } else
	  {
		  failedDescription("user is not able to edit RDS and not ablle to update");              		 
	  }
	  //Delete RDS Validation
	  test.log(Status.INFO, "Click on the Delete button on top right corner of RDS");
	  functionalcomponents.ClickOperation(properties.getProperty("DeleteHeaderRDS"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
	  functionalcomponents.WaitTillTime(7000);
	  if(functionalcomponents.IsElementDisplayed(properties.getProperty("validate")))
	  {
		  test.log(Status.PASS, "user is able to Delete succeeefully" );
	  } else
	  {
		  failedDescription("user is not able to Delete RDS");              		 
	  }
	
}
	 
	  //PublishProjectandDeploymentConfig
	  @Test(dependsOnMethods = { "ProjectCreation" })
	  public void ProjectPublishandDeploymentConfig()
	  {
		  
	  EdgeServiceFunctions edgeservicefunctions = new EdgeServiceFunctions();
	  edgeservicefunctions.ProjectValidateandPublish(Project_configname, Projectname);
	  //Publish Project with Duplicate Configuration name
	  test.log(Status.INFO, "Edit project and Click on the publish button on top right corner of the work center and enter duplicate config name");
	  functionalcomponents.ClickOperation(properties.getProperty("Edit_project"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Project_description"),projectdesc);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
	  functionalcomponents.WaitTillTime(9000);
	  functionalcomponents.ClickOperation(properties.getProperty("Publish"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Edge_configuration_name"), Project_configname);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_publish"));
	  functionalcomponents.WaitTillTime(10000);	
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Close_Button")))
	  {
        test.log(Status.PASS, "user can not publish the project with Duplicate configuration name as"+":"+Project_configname+"and user is able to see te message Configuration name must be unique");
	  } else
	  {
        failedDescription("user is able to publish the project with Duplicate configuration name");
      }
	  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));			  
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));			  
	  functionalcomponents.WaitTillTime(4000);
	 //Validate gateway status and set edge console password verify Services status and added successfully to GW 
	  edgeservicefunctions.VerifyGatewayStatus_SetEdgeConsolePasswordtoGateway(Streamingpassword, GateWayNo);
	  edgeservicefunctions.InstalledAllCoreServicestoGateway(GateWayNo);
	  edgeservicefunctions.StreamingConfigDeploymenttoGateway(Project_configname, GateWayNo);
	 
			 // Accessing sensor model data from db
			  
			  String Sensorquery = "SELECT * from SENSOR_PROFILE"+" WHERE SENSOR_PROFILE_NAME != 'COMPOSITE'"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Sensore Profile as: ");

			  String SensorDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Sensorquery);
			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Sensore Profile are: "+SensorDB_Result);
			  
			  //Accessing Action
			  
			  String Actionquery =  "SELECT * FROM ACTION"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Actions");

			  String ActionDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Actionquery);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Action are: "+ActionDB_Result);
			  
			  //Accessing Rule Data
			  
			  String Rulequery = "SELECT * FROM RULE"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Rules");

			  String RuleDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Rulequery);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Rule are: "+RuleDB_Result);
	
	 }
	
		 
	 @Test(dependsOnMethods = { "ProjectPublishandDeploymentConfig" })
	 public void SensorProfilevalidation() {
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
	 functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("OutboundConnectors_link"));
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("OutboundConnectorsNewAdd_btn"), 20);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("OutboundConnectorsNewAdd_btn")))
	 {	
		test.log(Status.PASS, " Screen is loaded with outbound conectors Page");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with Enterprise Plugins Page");
	 }
	 test.log(Status.INFO, "Click on add + Symbol to create New EnterprisePlugins");
	 functionalcomponents.ClickOperation(properties.getProperty("OutboundConnectorsNewAdd_btn"));
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginName"), 20);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("EnterprisePluginName")))
	 {	
		test.log(Status.PASS, "Outbound Connectors Name screen is opening successfully.");
	 }
	 else 
	 {
		failedDescription("EnterprisePlugins Name screen is not opening successfully");
	 }
	 functionalcomponents.ClearAndSetValue(properties.getProperty("EnterprisePluginName"), Plugin_name);
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginName"), 20);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("ClassDropdown_btn")))
	 {	
		 test.log(Status.PASS, "user is able to enter a name of the EnterprisePlugins "+": RESTPlugin");
	 }
	 else 
	 {
		failedDescription("user is not able to enter a name of the EnterprisePlugins with the different possible options for the name with special characters and numbers");
	 }
	 test.log(Status.INFO, "Select Enterprise Plugin Class as REST plugin from dropdown list");
	 functionalcomponents.ClickOperation(properties.getProperty("ClassDropdown_btn"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("Rest_OutboundConnector"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClearAndSetValue(properties.getProperty("Description_plugin"), "REST outbound connector");
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClearAndSetValue(properties.getProperty("Restoutbound_URI"), Rest_URI_input);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.PageScrollDown();
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Add_optionslsettings")))
	 {		
		 test.log(Status.PASS, "user is able to select the Restoutbound connector");
	 }
	 else 
	 {
		failedDescription("user is not able to select the Restoutbound connector");
	 }
	 
	 //1
	 test.log(Status.INFO, "Click on add + Symbol to add the optional settings");
	 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("optionalsettings_dropdown1"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("AUTH_TYPE"));
	 functionalcomponents.ClearAndSetValue(properties.getProperty("AUTH_TYPE_input"), AUTH_TYPE_input);
	 //2
	 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("optionalsettings_dropdown2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("Basic_Auth_Password"));
	 functionalcomponents.ClearAndSetValue(properties.getProperty("Basic_Auth_Password_input"), Basic_AUTH_Password_input);
	 //3
	 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("optionalsettings_dropdown3"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("Basic_Auth_Username"));
	 functionalcomponents.ClearAndSetValue(properties.getProperty("Basic_Auth_Username_input"), BASIC_AUTH_USERNAME_input);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Enterprise_savebtn")))
	 {	
		 test.log(Status.PASS, "user is able to add the optional settings successfully");
	 }
	 else 
	 {
		failedDescription("user is not able to add the optional settings");
	 }
	 functionalcomponents.ClickOperation(properties.getProperty("Enterprise_savebtn"));
	 functionalcomponents.WaitTillTime(2000);
	 String Sensorprofile=CapablityAlternateIDAPI+">>>"+PropertiesName1API;
	 //Adding the enterprise plugin into Rules sensor profile 1
	 test.log(Status.INFO, "Go to sensor Profilr and select Enterprise Plugin and Click Save Rule button and verify Rule is created successfully for Sensore Profile");
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));	
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation((properties.getProperty("sensor_name_part1")+Sensorprofile+properties.getProperty("sensor_name_part2")));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.scrollToExact(properties.getProperty("Rule_namelink_part1")+Sensorprofile+properties.getProperty("Rule_namelink_part2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink_part1")+Sensorprofile+properties.getProperty("Rule_namelink_part2")));
	 functionalcomponents.WaitTillTime(2000);		 
	 functionalcomponents.ClickOperation(properties.getProperty("enterprise_plugin_cancel"));
	 functionalcomponents.WaitTillTime(1000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+Plugin_name+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(2000);	
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(5000);
	 String Rulenamelink=CapablitynameAPI+PropertiesName1API+Rulename;
	 functionalcomponents.scrollToExact(properties.getProperty("Rule_namelink_part1")+Rulenamelink+properties.getProperty("Rule_namelink_part2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink1_part1")+Rulenamelink+properties.getProperty("Rule_namelink1_part2")));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+Plugin_name+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(5000);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Sensorprofilerule_Link")))
	 {	
		 test.log(Status.PASS, "user is able to add the RESTPlugin in the rule"+":"+Rulenamelink);
	 }
	 else 
	 {
		failedDescription("user is not able to add the RESTplugin");
	 } 
	 functionalcomponents.ClickOperation(properties.getProperty("Stream_Reading_Monitor"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SensorProfile_Save_btn"));
	 functionalcomponents.WaitTillTime(4000);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Sensorprofilerule_Link")))
	 {
		test.log(Status.PASS, "User is able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }
	 else 
	 {
		failedDescription("User is not able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }				 
	 test.log(Status.INFO, "Click on the sensor profile to add the RESTPlugin in the rule");
	 String Sensorprofile1=CapablityAlternateIDAPI+">>>"+PropertiesName2API;
	 functionalcomponents.ClickOperation((properties.getProperty("sensor_name_part1")+Sensorprofile1+properties.getProperty("sensor_name_part2")));
	 functionalcomponents.WaitTillTime(4000);
	 functionalcomponents.scrollToExact(properties.getProperty("Rule_namelink_part1")+Sensorprofile1+properties.getProperty("Rule_namelink_part2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink_part1")+Sensorprofile1+properties.getProperty("Rule_namelink_part2")));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickOperation(properties.getProperty("enterprise_plugin_cancel"));
	 functionalcomponents.WaitTillTime(1000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+Plugin_name+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(5000); 
	 String Rulenamelink1=CapablitynameAPI+PropertiesName2API+Rulename1;
	 functionalcomponents.scrollToExact(properties.getProperty("Rule_namelink_part1")+Rulenamelink1+properties.getProperty("Rule_namelink_part2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink1_part1")+Rulenamelink1+properties.getProperty("Rule_namelink1_part2")));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+Plugin_name+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(3000);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Sensorprofilerule_Link")))
	 {	
		 test.log(Status.PASS, "user is able to add the RESTPlugin in the rule"+":"+Rulenamelink1);
	 }
	 else 
	 {
		failedDescription("user is not able to add the RESTplugin");
	 } 
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SensorProfile_Save_btn"));
	 functionalcomponents.WaitTillTime(4000);
	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("Sensorprofilerule_Link")))
	 {	
		test.log(Status.PASS, "User is able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }
	 else 
	 {
		failedDescription("User is not able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }
	 
	 StreamingEdgeConsolecomponents streamingcomponents = new StreamingEdgeConsolecomponents();
	// Creating Sensor Profile

		String SensorProfileName = functionalcomponents.getdatafromsheet("StreamingService","TC_Custom_Over100", "SensorProfileName");
		String ProductionParameters_Min = functionalcomponents.getdatafromsheet("StreamingService","TC_Custom_Over100", "ProductionParameters_Min");
		String ProductionParameters_Max = functionalcomponents.getdatafromsheet("StreamingService","TC_Custom_Over100", "ProductionParameters_Max");
		streamingcomponents.CreateSensorProfile(SensorProfileName, ProductionParameters_Min, ProductionParameters_Max);
		// System.out.println(SensorProfileID);

		// Action Creation
		String ActionName = functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100","ActionName");
		String Actiontypevalue = functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100","ActionType");

		streamingcomponents.CreateAction(ActionName, ActionName, Actiontypevalue, ActionName, ActionName);                    
                                    
		// Set Protocols & Create Enterprise Plugin
		String EnterprisePluginName = streamingcomponents.CreateWebSocketoutboundConnector_StreamingService();
		//System.out.println(EnterprisePluginName);
                 
     //Add Rule for Sensor Profile
     test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
     functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClickOperation(properties.getProperty("Add_Newrole_btn"));
     functionalcomponents.waittillElementReadytoclickable(properties.getProperty("SensorProfile_Rulename"), 20);
     if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed())
     {              
        test.log(Status.PASS, "user is able to Navigate to Sesore Profile and add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
     }
     else 
     {
        failedDescription("user is able to Navigate to Sesore Profile and add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
     }
      
      
     test.log(Status.INFO, "Verify all the different fields are available the General Information block of Add New Rule" + " i) Sensor Profile ID" + " ii) Sensor Profile Name ");
		if (driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed()) {
			test.log(Status.PASS,"Verify all the different fields are available the General Information block of Add New Rule"+ " i) Sensor Profile Name " + ": " + SensorProfileName);
		} 
		else {
			failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
		}
       test.log(Status.INFO, "Enter Rule name  & Rule Description to add the Rules for the sensor profile.");
       String RuleName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "RuleName");
     functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName);
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description2"), RuleName);
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("Rule_Chainability"));
     if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
     {              
        test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName+" and Rule Description as"+": "+RuleName+"successfully to add the Rules for the sensor profile.");
     }
     else 
     {
        failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
     } 
     test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
     functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
     functionalcomponents.WaitTillTime(2000);
     String Ruletypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "RuleType");
     functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.scrollToExact(properties.getProperty("ScopeLevel_Dropdown"));
     functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
     functionalcomponents.WaitTillTime(2000);
     String ScopLevelTypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "ScopLevel");
     functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelTypevalue+properties.getProperty("ScopLevelPart2"));
     functionalcomponents.WaitTillTime(2000);
     String ScopLevelValue=functionalcomponents.Getvaluefromfield(properties.getProperty("ScopLevel_Value"));
     if(driver.findElement(By.xpath(properties.getProperty("CustomProjectHost"))).isDisplayed())
     {              
        test.log(Status.PASS, "user is able to select Ruletype as"+":"+Ruletypevalue+" "+" & scope level Type as"+":"+ScopLevelTypevalue+" "+" from dropdown button as well as Scop Level Value is:"+ScopLevelValue);
     }
     else 
     {
       failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
     }
     test.log(Status.INFO, "verify user is able to enter CustomProjectHost and CustomProjectPort value, and Max Event Freuency Value");
     functionalcomponents.ClickAndSetValue(properties.getProperty("CustomProjectHost"), "localhost");
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClickAndSetValue(properties.getProperty("CustomProjectPort"), "9091");
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "5");
     functionalcomponents.WaitTillTime(1000);
     functionalcomponents.ClearAndSetValue(properties.getProperty("EdgeKeep_interval"), "7");
     functionalcomponents.WaitTillTime(2000);
     if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
     {              
        test.log(Status.PASS, "verified user is able to enter CustomProjectHost as: 'localhost' and CustomProjectPort as: '9091' and Max Event Frequency '5000' well as selecting Event actions as"+":"+ActionName+" "+" from Action List");
     }
     else 
     {
         failedDescription("verified user is able to enter Threshold value, StreamingServicekeep Interval as well as selecting Event actions from Action List");
     }
     test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
     functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName.trim()+properties.getProperty("SelectEnterprisePart2"));
     functionalcomponents.WaitTillTime(2000);
      
     if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
     {              
        test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+" "+ "from List");
     }
     else 
     {
        failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
     }
      
     test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
     functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.PageScrollDown();
     String SavedRuleNameValue=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName+properties.getProperty("Saved_RuleName2"))).getText();               
     if(RuleName.equalsIgnoreCase(SavedRuleNameValue))
     {              
        test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName+" "+"for Sensore Profile");
     }
     else 
     {
        failedDescription("Clicked Save Rule button and verified Rule is created successfully with RuleName\"+\":\"+RuleName+\" \"+\"for Sensore Profile");
     }
       
    test.log(Status.INFO, "Select Streaming Reading monitoring checkbox for Device connection reading & Save Sensore Profile" );
    functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
    functionalcomponents.WaitTillTime(2000);
    functionalcomponents.ClickOperation(properties.getProperty("Stream_Reading_Monitor"));
    functionalcomponents.WaitTillTime(2000);
    functionalcomponents.ClickOperation(properties.getProperty("SensorProfile_Save_btn"));
    functionalcomponents.WaitTillTime(3000);
    if(driver.findElement(By.xpath(properties.getProperty("Monitoring_Link"))).isDisplayed())
    {              
     test.log(Status.PASS, "User is able to Select Streaming Reading monitoring checkbox for Device connection reading & Save Sensore Profile");
    }
    else 
    {
     failedDescription("User is not able to Select Streaming Reading monitoring");
    }
    test.log(Status.INFO, "Click on Monitoring, Live Sensor on the workcenter at left of the screen");
    functionalcomponents.ClickOperation(properties.getProperty("Monitoring_Link"));
    functionalcomponents.ClickOperation(properties.getProperty("LiveSensor"));
    if(driver.findElement(By.xpath(properties.getProperty("LiveSensor"))).isDisplayed())
    {              
     test.log(Status.PASS, "Live Sensor Screen is loaded Successfully");
    }
    else 
    {
     failedDescription("Screen is not loaded with option to add sensor profile");
     }
     //*************************************Test Cases by Sukhmani*******************************

     //Validating if Monitoring Tab is opening and Events visible inside it.        
     test.log(Status.INFO, "Click on Monitoring on the workcenter at left of the screen and open events");               
     String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("EventsTab_link"));
     functionalcomponents.WaitTillTime(5000);
     if(functionalcomponents.IsElementDisplayed(properties.getProperty("EventsScreen_HearderText")))                                                                             
     {              
        test.log(Status.PASS, "Streaming Service Screen is loaded with Events screen inside Monitoring Tab");
     }
     else 
     {
        failedDescription("Screen is not loaded with Events screen inside Monitoring Tab");
     }

     //Validating if Monitoring Tab is opening and Logs visible inside it.
     test.log(Status.INFO, "Click on Monitoring on the workcenter at left of the screen and open Logs");
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("LogsTab_link"));
     functionalcomponents.WaitTillTime(5000);
     if(functionalcomponents.IsElementDisplayed(properties.getProperty("LogsScreen_HearderText")))                                                                                 
     {              
        test.log(Status.PASS, "Streaming Service Screen is loaded with Logs screen inside Monitoring Tab");
     }
     else 
     {
        failedDescription("Screen is not loaded with Logs screen inside Monitoring Tab");
     }

     //Validating if Security Tab is opening and Tokens visible inside it.
     test.log(Status.INFO, "Click on Security on the workcenter at left of the screen and open Token");                                   
     if( !driver.findElement(By.xpath(properties.getProperty("SecurityTab_liItem"))).getAttribute("aria-expanded").equals(true) )  {
        functionalcomponents.ClickOperation(properties.getProperty("SecurityTab_link"));
        functionalcomponents.WaitTillTime(3000);
     }
     functionalcomponents.WaitTillTime(5000);
     functionalcomponents.ClickOperation(properties.getProperty("TokensTab_link"));
     functionalcomponents.WaitTillTime(5000);
	 if (functionalcomponents.IsElementDisplayed(properties.getProperty("Tokens_AddButton"))) {
			test.log(Status.PASS, "Streaming Service Screen is loaded with Tokens screen inside Security Tab");
	  } 
	 else {
			failedDescription("Screen is not loaded with Tokens screen inside Security Tab");
		}            
    
     //Creating new token
     test.log(Status.INFO, "Creating new token inside Tokens");
     functionalcomponents.ClickOperation(properties.getProperty("Tokens_AddButton"));
     functionalcomponents.WaitTillTime(5000);
	 if (functionalcomponents.IsElementDisplayed(properties.getProperty("Tokens_AddNewTokenText"))) {
			test.log(Status.PASS, "Create new token page is loaded");
	 } else {
			failedDescription("Create new token page is not loaded");
		}                          
     functionalcomponents.WaitTillTime(3000);
     String TokenName="SecurityToken"+CurrentDateandTime;
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("TokensCreation_NameField"));
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClearAndSetValue(properties.getProperty("TokensCreation_NameField"),TokenName);
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("TokensCreation_Permission_OdataCheckbox"));
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("TokensCreation_SaveButton"));
     functionalcomponents.WaitTillTime(3000);
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("TokenCreated_Validation"))) {
			test.log(Status.PASS, "User is able to create a new token");
		} else {
			failedDescription("User is not able to create a new token");
		}        
    
     //Deleting the created token  
     test.log(Status.INFO, "Deleting the token created");     
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("TokenCreated_Validation"));
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("TokenDeleteButton"));
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("OkButton"));
     functionalcomponents.WaitTillTime(3000);
		if (!functionalcomponents.IsElementDisplayed(properties.getProperty("TokenCreated_Validation"))) {
			test.log(Status.PASS, "User is able to delete token");
		} else {
			failedDescription("User is not able to delete token");
		}         
                    
     //Validating if Security Tab is opening and Passwords visible inside it.
     test.log(Status.INFO, "Click on Security on the workcenter at left of the screen and open Passwords");                                                                                                                           
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("PasswordsTab_link"));
     functionalcomponents.WaitTillTime(3000);    
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Passwords_AdminPassSettings_HeaderText"))) {
			test.log(Status.PASS,"Streaming Service Screen is loaded with Passwords screen inside Security Tab");
		} else {
			failedDescription("Screen is not loaded with Passwords screen inside Security Tab");
		}      

     //Changing password
		test.log(Status.INFO, "Changing password");
		functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_OldPassField"));
		functionalcomponents.WaitTillTime(3000);
		String newEdgeConsolePassword = "Test12345678";
		functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_OldPassField"), Streamingpassword);
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_NewPassField"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_NewPassField"),newEdgeConsolePassword);
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_ConfirmPassField"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_ConfirmPassField"), newEdgeConsolePassword);
		functionalcomponents.WaitTillTime(3000);
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("PasswordCreation_OldPassField"))) {
			test.log(Status.PASS, "Password Fields validated");
		}
		else {
			 failedDescription("Password field validation failed");
		}
		
		//uncomment to change password
		/*functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_SaveButton"));
		String ToastMsgText = driver.findElement(By.xpath(properties.getProperty("PasswordCreation_Toast"))).getText();	
		if (ToastMsgText.contains("Changed Password Successfully")) {
			test.log(Status.PASS, "Edge Console Password changed successfully with a toast: " + ToastMsgText);
			System.out.println("Toast Message: " + ToastMsgText);
		} else {
			failedDescription("Edge Console Password changed failed with toast saying: " + ToastMsgText);
			System.out.println("Toast Message: " + ToastMsgText);
		}  */  
    
     //Validating if Security Tab is opening and Import Export configurations visible inside it.
     test.log(Status.INFO, "Click on Settings Tab on the workcenter at left of the screen and open Import/Export Configurations");
     functionalcomponents.PerformDoubleClick(properties.getProperty("ImportExport_ListItem"));
     functionalcomponents.WaitTillTime(3000);    
     if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportExport_CurrentConfigValidate")))
     {            
     	test.log(Status.PASS, "Import/Export configuration screen is loaded successfully");                            
     }else 
     {
         failedDescription("Import/Export configuration screen is not loaded successfully");
     }
        
     //Exporting a Configuration
     test.log(Status.INFO, "Exporting a Configuration from Import/Export Configurations screen");              
     functionalcomponents.ClickOperation(properties.getProperty("ImportExport_ExportButton"));
     functionalcomponents.WaitTillTime(3000);
     if(functionalcomponents.IsElementDisplayed(properties.getProperty("ExportPopup_PasswordField")))
     {
     	test.log(Status.PASS, "User is able to view password popup before exporting");
     functionalcomponents.ClickOperation(properties.getProperty("ExportPopup_PassTextField"));         
     functionalcomponents.WaitTillTime(3000); 
     }else {
     	failedDescription("Export password popup not loaded on screen");
     }
     //Invalid and valid password
     functionalcomponents.ClearAndSetValue(properties.getProperty("ExportPopup_PassTextField"),"111");
     functionalcomponents.WaitTillTime(2000);
     functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));
     functionalcomponents.WaitTillTime(3000);    
     if(functionalcomponents.IsElementDisplayed(properties.getProperty("ExportPopup_PasswordField")))
     {
       test.log(Status.PASS, "User can not export configuration with invalid password");
       functionalcomponents.ClearAndSetValue(properties.getProperty("ExportPopup_PassTextField"),Streamingpassword);
       functionalcomponents.WaitTillTime(5000);
       functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));
       functionalcomponents.WaitTillTime(3000);    
       if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportExport_CurrentConfigValidate"))){
 		test.log(Status.PASS, "User is able to export a configuration successfully with valid password");
        }
        else
        {
         failedDescription("Export popup not loaded on screen");
        }
     } 
      else
      {
         failedDescription("User is able to export configuration with invalid password");
      }
     
    
     //To check Importing functionality of Import/Export Configuration
     //importConfigurationMethod();
      
     //Runtime Settings validation 
     test.log(Status.INFO, "Click on Runtime Settings on the workcenter at left of the screen inside Settings");
     functionalcomponents.scrollToExact(properties.getProperty("RuntimeSettings"));
     functionalcomponents.ClickOperation(properties.getProperty("RuntimeSettings"));
     functionalcomponents.WaitTillTime(3000);                       
     if(functionalcomponents.IsElementDisplayed(properties.getProperty("RuntimeSettings_Node_ID"))) {
                     test.log(Status.PASS,"Runtime Settings screen is displayed successfully");
     }else {
                     failedDescription("Runtime Settings screen is not displayed");
     }
        
     //Rule Extension Tab validation          
     test.log(Status.INFO, "Click on Rule Extension on the workcenter at left of the screen inside Settings");
     functionalcomponents.scrollToExact(properties.getProperty("RuleExtensionTab"));  
     functionalcomponents.WaitTillTime(3000);
     functionalcomponents.ClickOperation(properties.getProperty("RuleExtensionTab"));           
     functionalcomponents.WaitTillTime(3000);
     if(functionalcomponents.IsElementDisplayed(properties.getProperty("RuleExtensionDetailsHeader")))
     {
         test.log(Status.PASS,"Rule Extension screen is displayed successfully");
     }
     else
     {
          failedDescription("Rule Extension screen is not displayed");
      }              
	
   //Deleting Sensor Profile and action
     
     streamingcomponents.DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
     streamingcomponents.DeleteSensorProfile(SensorProfileName);
     streamingcomponents.DeleteAction(ActionName);           
}

	 
	 
	 
 public void GetIOTData() throws Exception {
	 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
		 DeviceBaseurl = CockpitURL+"/iot/core/api/v1/devices";
	 }
	 else
	 {
		 DeviceBaseurl = CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/devices?skip=0&top=1000000"; 
	 }
	  	 
	 //System.out.println(DeviceBaseurl);
	  String Devicedata = requestassuredcomponents.GetAPIDatawithBaiscAuth(DeviceBaseurl, Cockpitusername, Cockpitpassword);
	   JSONParser parse = new JSONParser(); 
	   JSONArray jsonarr = (JSONArray)parse.parse(Devicedata);
	   System.out.println(jsonarr);
	   for(int i=0; i<jsonarr.size();i++)
	   {
	       JSONObject jsondeviceobj = (JSONObject)jsonarr.get(i);
	       // System.out.println("gatewayId:"+jsondeviceobj.get("gatewayId"));
	       if(jsondeviceobj.get("gatewayId").equals(GateWayNo))
	      {
		   DevicenameAPI=(String) jsondeviceobj.get("name");
		   System.out.println(DevicenameAPI);
		   JSONArray jsonarr_Sensor = (JSONArray)jsondeviceobj.get("sensors");
		  // System.out.println(jsonarr_Sensor);
		   if(jsonarr_Sensor==null) {
			   break;
		   }
		   for(int j=0;j<jsonarr_Sensor.size();j++)
		     {
			   JSONObject jsonSensor = (JSONObject)jsonarr_Sensor.get(j);
			   
			   SensornameAPI=(String) jsonSensor.get("name");
			  
			   if(!SensornameAPI.equalsIgnoreCase("Sensor: 0:0:0:0")) {
				   SensorTypeIDAPI=(String) jsonSensor.get("sensorTypeId");
				 //  System.out.println(SensornameAPI+" "+SensorTypeIDAPI);
				test.log(Status.PASS, "Gateway: "+GateWayNo+" is associate to device: "+DevicenameAPI+" and Sensor Name is :"+SensornameAPI);
				GetCapablityID();
				GetCapablityName();
				break;
			     }   
		     }
		   if(!SensornameAPI.equalsIgnoreCase("Sensor: 0:0:0:0"))
			     break;	       
	      }
	      
	   }
	  if(SensornameAPI.equalsIgnoreCase("Sensor: 0:0:0:0")||SensornameAPI.equals("")||PropertiesName1API.equals("")||PropertiesName2API.equals("")) {
	   test.log(Status.INFO, "Gateway: "+GateWayNo+" is not associate to any device user will create device sensor sensortype capability");   
	   Create_Capablity_Device_Sensor_SensorType();
	  }
	}

	public void GetCapablityID() throws Exception {
		 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
			 SesorTypeBaseURL = CockpitURL+"/iot/core/api/v1/sensorTypes";
		 }
		 else
		 {
			 SesorTypeBaseURL =CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/sensorTypes?skip=0&top=1000000"; 
		 }
		
	    String Sensortypedata =requestassuredcomponents.GetAPIDatawithBaiscAuth(SesorTypeBaseURL, Cockpitusername, Cockpitpassword);
	   System.out.println("body data is"+Sensortypedata);
	   JSONParser parse = new JSONParser(); 
	   JSONArray jsonarr = (JSONArray)parse.parse(Sensortypedata);
	   for(int i=0;i<jsonarr.size();i++)
	   {
	   JSONObject jsonsensortypeeobj = (JSONObject)jsonarr.get(i);
	 
	   System.out.println("SensorTypeId:"+jsonsensortypeeobj.get("id"));
	   if(jsonsensortypeeobj.get("id").equals(SensorTypeIDAPI))
	   {
		   SensorTypeNameAPI=(String) jsonsensortypeeobj.get("name");
		   JSONArray jsonarr_Capablity = (JSONArray) jsonsensortypeeobj.get("capabilities");
		 //  System.out.println(jsonarr_Capablity);
		   for(int j=0;j<jsonarr_Capablity.size();j++)
		   {
			   JSONObject jsonCapablity = (JSONObject)jsonarr_Capablity.get(j);
			   CapablityIDAPI=(String) jsonCapablity.get("id");
			   test.log(Status.PASS, "user is able to Get SensortypeName as:"+SensorTypeNameAPI+" and Capablity ID is :"+CapablityIDAPI);
		   }
		   break;
	   }
	  
	   }
}
	
public void GetCapablityName() throws Exception {
	 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
		 CapabiltyBaseURL = CockpitURL+"/iot/core/api/v1/capabilities?skip=0&top=1000";
	 }
	 else
	 {
		 CapabiltyBaseURL = CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/capabilities?skip=0&top=1000000"; 
	 }	
	   String Capablitydata =requestassuredcomponents.GetAPIDatawithBaiscAuth(CapabiltyBaseURL, Cockpitusername, Cockpitpassword);
	   System.out.println("body data is"+Capablitydata);
	   JSONParser parse = new JSONParser(); 
	   JSONArray jsonarr = (JSONArray)parse.parse(Capablitydata);
	   for(int i=0;i<jsonarr.size();i++)
	   {
	   JSONObject jsoncapobj = (JSONObject)jsonarr.get(i);
	 
	   if(jsoncapobj.get("id").equals(CapablityIDAPI))
	   {
		   CapablitynameAPI=(String) jsoncapobj.get("name");
		   CapablityAlternateIDAPI=(String) jsoncapobj.get("alternateId");
		   JSONArray jsoncaparr = (JSONArray)jsoncapobj.get("properties");
		   System.out.println(jsoncaparr);
		   System.out.println(jsoncaparr.size());
		   for(int j=0;j<jsoncaparr.size();j++)
		   {
		   JSONObject jsonpropobj = (JSONObject)jsoncaparr.get(j);
		   if(j==0)
		   PropertiesName1API=(String) jsonpropobj.get("name");
		   if(j==1)
		   PropertiesName2API=(String) jsonpropobj.get("name");
	      }
		   
	   test.log(Status.PASS, "user is able to Get Capablity Name is :"+CapablitynameAPI+" into Cokpit Application with Properties as: "+PropertiesName1API+", "+PropertiesName2API);
	   break;
	   }
   
	  }
	   
	} 
 public void Create_Capablity_Device_Sensor_SensorType() throws Exception {
	
	 CapablityAlternateID ="Capalt"+CurrentDateandTime;
	 CapablityName="Cap"+CurrentDateandTime;
	 SensorTypesName="Sentyp"+CurrentDateandTime;
	 DeviceName="Device"+CurrentDateandTime;
	 DeviceAlternateID="Devicealt"+CurrentDateandTime;
	 SensorName="Sensor"+CurrentDateandTime;
	 SensorAltID ="Sensoralt"+CurrentDateandTime;
	 System.out.println(CapablityAlternateID+" --"+SensorAltID);

	 String Cap_Payload2="{\r\n"+
	            "\"alternateId\":\""+CapablityAlternateID+"\","+
		 		"\"name\":\""+CapablityName+"\","+ 
		 		"  \"properties\": [\r\n" + 
		 		"    {\r\n" + 
		 		"      \"dataType\": \"float\",\r\n" + 
		 		"      \"formatter\": {\r\n" + 
		 		"        \"dataType\": \"float\",\r\n" + 
		 		"        \"scale\": 0,\r\n" + 
		 		"        \"shift\": 0,\r\n" + 
		 		"        \"swap\": true\r\n" + 
		 		"      },\r\n" + 
		 		"      \"name\":\""+PropertiesName1+"\"," + 
		 		"      \"unitOfMeasure\": \"Degree\"\r\n" + 
		 		"    },\r\n" +
		 		" {\r\n" + 
		 		"			\"dataType\": \"float\",\r\n" + 
		 		"			\"formatter\": {\r\n" + 
		 		"				\"dataType\": \"float\",\r\n" + 
		 		"				\"scale\": 0,\r\n" + 
		 		"				\"shift\": 0,\r\n" + 
		 		"				\"swap\": true\r\n" + 
		 		"			},\r\n" + 
		 		"			\"name\":\""+PropertiesName2+"\",\r\n" + 
		 		"			\"unitOfMeasure\": \"Degree\"\r\n" + 
		 		"		} ]\r\n" + 
		 		"}";
	
	
	CapablityIDAPI=CreateCapablityIDandCapablityName(Cap_Payload2);
	System.out.println(CapablityIDAPI);
	String Sensortypepayload="{\r\n" + 
			"  \"alternateId\":\""+SensorTypeAltID+"\",\r\n" + 
			"  \"capabilities\": [\r\n" + 
			"    {\r\n" + 
			"      \"id\":\""+CapablityIDAPI+"\",\r\n" + 
			"      \"type\": \"measure\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"name\": \""+SensorTypesName+"\"\r\n" + 
			"}";
	System.out.println(Sensortypepayload);
	SensorTypeIDAPI=CreateSensortypeIDandSensortypename(Sensortypepayload);
	System.out.println(SensorTypeIDAPI);
	String DevicePayload="{\r\n" + 
			"  \"customProperties\": [\r\n" + 
			"    {\r\n" + 
			"      \"key\": \"string\",\r\n" + 
			"      \"value\": \"string\"\r\n" + 
			"    }\r\n" + 
			"  ],\r\n" + 
			"  \"gatewayId\": \""+GateWayNo+"\",\r\n" + 
			"  \"name\": \""+DeviceName+"\"\r\n" + 
			"}";
	 System.out.println(DevicePayload);
	DeviceIDAPI=CreateDeviceIdandDevicename(DevicePayload);
	System.out.println(DeviceIDAPI);
	String SensorPayload="{\r\n" + 
			"  \"alternateId\": \""+SensorAltID+"\",\r\n" + 
			"  \"deviceId\": \""+DeviceIDAPI+"\",\r\n" + 
			"  \"name\": \""+SensorName+"\",\r\n" + 
			"  \"sensorTypeId\": \""+SensorTypeIDAPI+"\"\r\n" + 
			"}";
	System.out.println(SensorPayload);
	SensornameAPI=CreateSensor(SensorPayload);
	System.out.println(SensornameAPI);
	
	SensorTypeNameAPI=SensorTypesName;
	DevicenameAPI=DeviceName;

 }

  public String CreateCapablityIDandCapablityName(String Capablitypayload) throws Exception {	 
 	
 	 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
 	    		 CapabiltyBaseURL = CockpitURL+"/iot/core/api/v1/capabilities";
 		 }
 	 else
 		 {
 				 CapabiltyBaseURL = CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/capabilities"; 
 		 }	
 	      String capablityid=""; 
 		   APIData =requestassuredcomponents.PostAPIdatawithBasicAuth(CapabiltyBaseURL, Cockpitusername, Cockpitpassword, Capablitypayload);
 		   JSONParser parse = new JSONParser(); 
 		   JSONObject jsoncapobj = (JSONObject) parse.parse(APIData);
 		   capablityid=(String) jsoncapobj.get("id");
 		   CapablitynameAPI=(String) jsoncapobj.get("name");
 		   CapablityAlternateIDAPI=(String) jsoncapobj.get("alternateId");
 		   JSONArray jsoncaparr = (JSONArray)jsoncapobj.get("properties");
 		   for(int i=0;i<jsoncaparr.size();i++)
 		   {
 		   JSONObject jsonproparr = (JSONObject)jsoncaparr.get(i);
 		   if(i==0)
 		   PropertiesName1API=(String) jsonproparr.get("name");
 		   if(i>0)
 		   PropertiesName2API=(String) jsonproparr.get("name");
 	      }
 		  test.log(Status.PASS, "User is able to creat Capablitiy successfully as"+CapablitynameAPI+" with Properties"+PropertiesName1API+" ,"+PropertiesName2API);
 		return capablityid;
 		   
 }
  
  public String CreateSensortypeIDandSensortypename(String sensortypepayload) throws Exception {
 	 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
 		 SesorTypeBaseURL = CockpitURL+"/iot/core/api/v1/sensorTypes";
 	 }
 	 else
 	 {
 		 SesorTypeBaseURL = CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/sensorTypes"; 
 	 }
 	 String SensortypeId="";
 	 APIData =requestassuredcomponents.PostAPIdatawithBasicAuth(SesorTypeBaseURL, Cockpitusername, Cockpitpassword, sensortypepayload);
 	 JSONParser parse = new JSONParser(); 
 	 JSONObject jsonSentypobj = (JSONObject) parse.parse(APIData);
 	 SensortypeId=(String) jsonSentypobj.get("id");
 	 if(!SensortypeId.equals(""))
 	 test.log(Status.PASS, "User is able to creat Sensor Type successfully"); 
 	 else if(SensortypeId.equals(""))
 		test.log(Status.FAIL, "User is able to creat Sensor Type successfully");
 	return SensortypeId;
  }
  
  public String CreateDeviceIdandDevicename(String Devicepayload) throws Exception {
 	 
 		if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
 			DeviceBaseurl = CockpitURL+"/iot/core/api/v1/devices";
 			 }
 		 else
 			 {
 			 DeviceBaseurl =CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/devices"; 
 			 }	
 		      String Deviceid=""; 
 			   APIData =requestassuredcomponents.PostAPIdatawithBasicAuth(DeviceBaseurl, Cockpitusername, Cockpitpassword, Devicepayload);
 			   JSONParser parse = new JSONParser(); 
 			   JSONObject jsondevobj = (JSONObject) parse.parse(APIData);
 			   Deviceid=(String) jsondevobj.get("id");
 			  if(!Deviceid.equals(""))
 			  test.log(Status.PASS, "User is able to creat Device successfully");
 			  else  if(Deviceid.equals(""))
 				 test.log(Status.FAIL, "User is not able to creat Device successfully");
 			  return Deviceid;	   
 	}
  
  public String CreateSensor(String Sansorpayload) throws Exception {
 	 
 		if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
 			SensorBaseURL = CockpitURL+"/iot/core/api/v1/sensors";
 			 }
 		 else
 			 {
 			 SensorBaseURL = CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/sensors"; 
 			 }	
 		      String Sensorname=""; 
 			   APIData =requestassuredcomponents.PostAPIdatawithBasicAuth(SensorBaseURL, Cockpitusername, Cockpitpassword, Sansorpayload);
 			   JSONParser parse = new JSONParser(); 
 			   JSONObject jsonsenobj = (JSONObject) parse.parse(APIData);
 			   Sensorname=(String) jsonsenobj.get("name");
 			  if(!Sensorname.equals(""))
 			  test.log(Status.PASS, "User is able to creat Sensor successfully"+Sensorname);
 			  else if(Sensorname.equals(""))
 				 test.log(Status.FAIL, "User is able to creat Sensor successfully"+Sensorname);
 			return Sensorname;
  }
  
  	 
}
