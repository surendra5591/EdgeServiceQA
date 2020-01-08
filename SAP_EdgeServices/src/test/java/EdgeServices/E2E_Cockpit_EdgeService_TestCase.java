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

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class E2E_Cockpit_EdgeService_TestCase extends BaseTest  {
	
    Properties properties = functionalcomponents.getObjectProperties();
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
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "PolicyServiceURL");
    String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "username");
    String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "password");
    String Tenantname=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Tenantname");
    String TenantID=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "TenantID");
    String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "GateWayNo");
    String DB_UserName=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "DB_userid");	 
    String DB_Password=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "DB_pwd");	  
    String CockpitURL= functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "CockpitURL");
	String Cockpitusername = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "CockpitUserName");
	String Cockpitpassword = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "CockpitPassword");
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
		//Streaming input
	    String Streamingusername = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Stream_username");
		String Streamingpassword = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Stream_password"); 
	    String Plugin_name=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Plugin_name");
	    String Basic_AUTH_Password_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Basic_AUTH_Password_input");
	    String AUTH_TYPE_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "AUTH_TYPE_input");
	    String Rest_URI_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "URI_input");
		String BASIC_AUTH_USERNAME_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "BASIC_AUTH_USERNAME_input");
		
     // Get exists Device, Sensor type, Sensor, Capability for gateway Using Rest Assured API for IOTS 
     @Test (priority=1)
     public void CreateDevicewithgatewayID() throws Exception
     {
      GetDeviceMethod();
     }
    
    //Create Project with Sensor Profile
  	//Prerequisite-added service to gateway  with tile EdgeDesigner   
     @Test (priority=2, dependsOnMethods = {"CreateDevicewithgatewayID"})
     public void ProjectCreation() {   
 		test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
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
 		  
	 Projectname="EdgeProject"+CurrentDateandTime;
	 Project_configname="EdgeConfig"+CurrentDateandTime;
	 test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
	 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
	 functionalcomponents.WaitTillTime(30000);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90); 
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Create_project"), 90); 
	 functionalcomponents.WaitTillTime(7000);
	 if (driver.findElement(By.xpath(properties.getProperty("Create_project"))).isDisplayed())
	  {
         test.log(Status.PASS, "user is able to see Add Prject window successfully");
	  } else
	  {
         failedDescription("user is not able to see the Add Project window ");
     } 
	 			 
	  test.log(Status.INFO, "Enter the name of the project with special characters");			 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),Projectname);	  
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Project_name"))).isDisplayed())
	  {	
			test.log(Status.PASS, "project name as"+":"+Projectname+" "+" is saved successfully with special characters");
	  }
	  else 
	  {
			failedDescription(" project name is not saved successfully with special characters");
	  }
	  test.log(Status.INFO, "Enter description of the project and click on the create button");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"),200); 
	  functionalcomponents.ClearAndSetValue(properties.getProperty("ProjectSearchinput"),Projectname);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectname+properties.getProperty("Project_title_part2")));
	  functionalcomponents.WaitTillTime(3000);
	
	  //creation of sensor model
	  test.log(Status.INFO, "click on the Sensor Model tab and click on + button to add sensormodel to the project");	
	  functionalcomponents.WaitTillTime(2000);	
	  functionalcomponents.ClickOperation(properties.getProperty("Data_Model"));
	  functionalcomponents.WaitTillTime(2000);				  
	  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_add"));
	  functionalcomponents.WaitTillTime(10000);
	  if(driver.findElement(By.xpath(properties.getProperty("Sensor_Typedropdown"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see sensor model window successfullly");
	  } else
	  {
          failedDescription("user is not able to see the sensor model window");
      }
	  test.log(Status.INFO, "select the sensor type,capability in the sensor model window");
	  /*
	  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Typedropdown"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.scrollToExact(properties.getProperty("SensorType_part1")+SensorTypeNameAPI+properties.getProperty("SensorType_part2"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("SensorType_part1")+SensorTypeNameAPI+properties.getProperty("SensorType_part2"));
	  functionalcomponents.WaitTillTime(2000);
	  */
	  functionalcomponents.ClearAndSetValue(properties.getProperty("inputSensorType"), SensorTypeNameAPI);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Typedropdown"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("Capability_Namedropdown"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation((properties.getProperty("capability_name_part1")+CapablitynameAPI+properties.getProperty("capability_name_part2")));
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Property_namecheckbox"))).isDisplayed())
	  {	
		  test.log(Status.PASS, "User is able to Select sensor type as"+": "+SensorTypeNameAPI+" "+"& capability as"+ ":"+CapablitynameAPI+"from dropdown ");
	  }
	  else 
	  {
		  failedDescription("user is not able to select sensor type and capability from dropdown ");
	  }
	  
	  test.log(Status.INFO, "Click create sensor model button and verify sensor model is created successfully");	
	  functionalcomponents.ClickOperation(properties.getProperty("Property_namecheckbox"));
	  functionalcomponents.WaitTillTime(2000);
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
	  if(functionalcomponents.IsElementPresent(properties.getProperty("Data_Model")))
	  {
		  test.log(Status.PASS, "user is able to create the Sensor data model in the project with sensor model names:"+sensormodallist);		  }
	  else
	  {
          failedDescription("user is not able to create the sensor model in the project ");
      }	
	  
	   //Feature  Compute Sensor Data Models	  
	  String CustomeDataModelName1= "SensorDataModel_"+PropertiesName1API+"_Largest";
	  String CustomeDataModelName2= "SensorDataModel_"+PropertiesName2API+"_Largest";
	  String CustomDataModel="";
	  test.log(Status.INFO, "click on the sensor model name check box and click on the Compute");
	  for(int i=0; i<sensormodallist.size();i++) {
		  if(sensormodallist.get(i).contains(PropertiesName1))
		  {  CustomDataModel=CustomeDataModelName1;
			  functionalcomponents.ClickOperation("(//div[@title='Click to Select'])[1]");
			  functionalcomponents.WaitTillTime(2000);
		  }
		  else if(sensormodallist.get(i).contains(PropertiesName2))
		  {   CustomDataModel=CustomeDataModelName2;
			  functionalcomponents.ClickOperation("(//div[@title='Click to Select'])[2]");
			  functionalcomponents.WaitTillTime(2000);
		  }
			  functionalcomponents.ClickOperation(properties.getProperty("Compute_Link"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickOperation(properties.getProperty("CutomeDataModel_Radiobutton"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("CustomDataModelName_Input"), CustomDataModel);
			  functionalcomponents.WaitTillTime(2000); 
			  functionalcomponents.ClickOperation(properties.getProperty("timewindoedropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Minute_timewindow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("timewindow_input"), "1");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Formula_dropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Formulainput"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
			  functionalcomponents.WaitTillTime(7000);	
			  if(functionalcomponents.IsElementPresent(properties.getProperty("Data_Model")))
			  {
				  test.log(Status.PASS, "user is able to Cumpute the Sensor data model in the project with custom sensor data model names:"+CustomDataModel);		  }
			  else
			  {
		          failedDescription("user is not able to Compute the sensor model in the project ");
		      }	
	  }   
	  test.log(Status.INFO, "click on the sensor model name check box and click on the fedility to add the Local Enterprise plugin");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Data_Model"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_name"));			  
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("feidelty"));
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Minimum_ouput_Frequency"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see the Add fedility window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Add fedility window successfully");
      }
	  functionalcomponents.WaitTillTime(1000);
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
	  test.log(Status.INFO, " Select the local Enterprise plugin from dropdown");
	  functionalcomponents.ClickOperation(properties.getProperty("Local_enterpriseplugin_dropdown"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Local_enteprise_plugin_part1")+Local_enterpriseplugin+properties.getProperty("Local_enteprise_plugin_part2"));	
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("save_button"));			  
	  functionalcomponents.WaitTillTime(7000);	 
	  if(driver.findElement(By.xpath(properties.getProperty("Actions"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to add the local enterprise Plugin as:"+":"+Local_enterpriseplugin);
	  } else
	  {
          failedDescription("user is able to add the local enterprise Plugin as:"+":"+Local_enterpriseplugin);
      }
		    
	 //Create Action first for Latitude
	  test.log(Status.INFO, "Click on the Actions tab to in the project");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Actions"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Action_Add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Action_name"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see the Add Action window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Add Action window");	              		 
	  }				  
	  test.log(Status.INFO, "Enter the Action name and description with special characters");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_name"),Actionname);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_description"),Action_desc);
	  if(driver.findElement(By.xpath(properties.getProperty("Action_Type_Dropdown"))).isDisplayed())
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
		  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1")+Action_type+properties.getProperty("Action_Type_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Action_sensormodel_dropdown"));
		  functionalcomponents.WaitTillTime(3000);
		  
		  for(int j=0;j<sensormodallist.size();j++) {
			  System.out.println(sensormodallist);
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1+"')]");
				  functionalcomponents.WaitTillTime(2000);
				 break;
			  }
		  }
		  
		  functionalcomponents.ClickOperation(properties.getProperty("scope_leve_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("scope_level_part1")+Scope_level+properties.getProperty("scope_level_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("fedility_freqency"))).isDisplayed())
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
		  if(driver.findElement(By.xpath(properties.getProperty("Action_create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);
		  } else
		  {
              failedDescription("user is not able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);             		 
		  }	
		  
	  }
	  test.log(Status.INFO, "Click Create Action button and verify Action is created successfully with Action Name");
	  functionalcomponents.ClickOperation(properties.getProperty("Action_create"));
	  functionalcomponents.WaitTillTime(4000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rules"))).isDisplayed())
	  {
		  test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name as"+":"+Actionname);
	  } else
	  {
          failedDescription("Clicked Save Action button but Action is not created successfully with Action Name as"+":"+Actionname);
      }
	  
	  // Creation Action for second Properties
	  test.log(Status.INFO, "Click on the Actions tab to in the project");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Actions"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Action_Add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Action_name"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see the Add Action window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Add Action window");	              		 
	  }				  
	  test.log(Status.INFO, "Enter the Action name and description with special characters");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_name"),Actionname1);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_description"),Action_desc1);
	  if(driver.findElement(By.xpath(properties.getProperty("Action_Type_Dropdown"))).isDisplayed())
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
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName2+"')]");
				  functionalcomponents.WaitTillTime(2000);
				  break;
			  }
		  }
		  
		  
		  functionalcomponents.ClickOperation(properties.getProperty("scope_leve_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("scope_level_part1")+Scope_level+properties.getProperty("scope_level_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("fedility_freqency"))).isDisplayed())
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
		  if(driver.findElement(By.xpath(properties.getProperty("Action_create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to Enter the fedility frequency as"+Edge_Fedilityfreq1+"Fedility Rollback as"+Edge_fedility_rollback1+"Enterprise fedility as"+enterprise_fedility1+"Enterprise fedility rollback as"+enterprise_rollback1);
		  } else
		  {
              failedDescription("user is not able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);             		 
		  }	
		  
	  }
	  test.log(Status.INFO, "Click Create Action button and verify Action is created successfully with Action Name");
	  functionalcomponents.ClickOperation(properties.getProperty("Action_create"));
	  functionalcomponents.WaitTillTime(7000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rules"))).isDisplayed())
	  {
		  test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name as"+":"+Actionname1);
	  } else
	  {
          failedDescription("Clicked Save Action button but Action is not created successfully with Action Name as"+":"+Actionname1);
      }
	      
	//creation of rule for latitude sensor model
	  test.log(Status.INFO, "click on Rules Tab in the project");
	  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rules_add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_name"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see the Rule window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule window");
      }
	  test.log(Status.INFO, "Enter the Rule name and description with special characters ");			  
	  
	  String RulenameLatitude=CapablitynameAPI+PropertiesName1+Rulename;
	  
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
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_name"))).isDisplayed())
	  {	
		  test.log(Status.PASS, "Rule name as"+RulenameLatitude+":"+ "saved successfully with special characters");
	  }
	  else 
	  {
		  failedDescription(" Rule name as"+RulenameLatitude+":"+ "is not saved successfully with special characters");
  	  }
	  test.log(Status.INFO, "Click on the create button to create the rule");
	  
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_Create"));
	  functionalcomponents.WaitTillTime(15000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rules"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to add the rulename"+RulenameLatitude+""+"description"+""+Ruledesc);
	  } else
	  {
          failedDescription("user is not able to add the rulename and description");
 
	  }
	   
	  
	//Add the conditions to the rule1
	  test.log(Status.INFO, "click on Rulename to add the conditions to the rule");		
	  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation((properties.getProperty("Rule_link_part1")+RulenameLatitude+properties.getProperty("Rule_link_part2")));
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
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
	  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_name"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see the Rule conditons window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule conditons window successfully");
 
	  }
	  test.log(Status.INFO, "Enter the rule condition name with special characters");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rulecondition_name"),CapablitynameAPI+PropertiesName1+Rulecondition);
	  if(driver.findElement(By.xpath(properties.getProperty("Filter_dropdown"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to enter the rule conditon nmae as"+":"+CapablitynameAPI+PropertiesName1+Rulecondition+"successfully");
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
	  if(driver.findElement(By.xpath(properties.getProperty("conditiontype_dropdown"))).isDisplayed())
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
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1+"')]");
				  functionalcomponents.WaitTillTime(2000);
				 break;
			  }
		  }
		  if(driver.findElement(By.xpath(properties.getProperty("Condition_Customhost"))).isDisplayed())
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
		  for(int j=0;j<sensormodallist.size();j++) {
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1+"')]");
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
		  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
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
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1+"')]");
				  functionalcomponents.WaitTillTime(2000);
				 break;
			  }
		  }
		  if(driver.findElement(By.xpath(properties.getProperty("Target_State_dropdown"))).isDisplayed())
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
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName1)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName1+"')]");
				  functionalcomponents.WaitTillTime(2000);
				  break;
			  }
	  }
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Operator_dropdown"))).isDisplayed())
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
		  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  test.log(Status.INFO, "Click on the create button to save the Rule condition");
	  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_Create"));
	  functionalcomponents.WaitTillTime(9000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to create the rule condition as"+":"+Rulecondition+"successfully");
	  } else
	  {
          failedDescription("user is able to create the rule condion successfully");	              		 
	  }
	// Enable Rule
	  functionalcomponents.ClickOperation(properties.getProperty("EnableRule"));
	  functionalcomponents.WaitTillTime(15000);  
	  //Create ouptuts in the Rule 1 for latitude sensor model
	  test.log(Status.INFO, "Click on the Output tab in the Rule and add the action to the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Outputs"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("output_Add"));
	  functionalcomponents.WaitTillTime(1000);
	 // functionalcomponents.ClickOperation(properties.getProperty("output_Action"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_part1")+Actionname+properties.getProperty("Localactio_part2"));
	  functionalcomponents.WaitTillTime(2000);	
	  functionalcomponents.ClickOperation(properties.getProperty("Ouput_create"));
	  functionalcomponents.WaitTillTime(10000);	
	  if(driver.findElement(By.xpath(properties.getProperty("Outputs"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to add the action to the rule as"+Actionname);
	  } else
	  {
          failedDescription("user is able to add the action to the rule as"+Actionname);	              		 
	  }
	    
	//creation of rule2 for longitude sensor model
	  test.log(Status.INFO, "click on Rules Tab in the project");
	  functionalcomponents.ClickOperation(properties.getProperty("Project_link_part1")+Projectname+ properties.getProperty("Project_link_part2"));
	  functionalcomponents.WaitTillTime(3000);	
	  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rules_add"));
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_name"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see the Rule window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule window");
      }
	  test.log(Status.INFO, "Enter the Rule name and description with special characters ");			  
	  String RulenameLongtitude=CapablitynameAPI+PropertiesName2+Rulename1; 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_name"),RulenameLongtitude);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"),Ruledesc1);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rule_enabled_button"));
	  
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_name"))).isDisplayed())
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
	  if(driver.findElement(By.xpath(properties.getProperty("Rules"))).isDisplayed())
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
	  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
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
	  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_name"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to see the Rule conditons window successfully");
	  } else
	  {
          failedDescription("user is not able to see the Rule conditons window successfully");
 
	  }
	  test.log(Status.INFO, "Enter the rule condition name with special characters");
	 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Rulecondition_name"),CapablitynameAPI+PropertiesName2+Rulecondition1);
	  if(driver.findElement(By.xpath(properties.getProperty("Filter_dropdown"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to enter the rule conditon nmae as"+":"+CapablitynameAPI+PropertiesName2+Rulecondition1+"successfully");
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
	  if(driver.findElement(By.xpath(properties.getProperty("conditiontype_dropdown"))).isDisplayed())
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
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2)) {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'>>>"+PropertiesName2+"')])[2]");
					  functionalcomponents.WaitTillTime(2000);
					  break;
				  }
			  }
		  if(driver.findElement(By.xpath(properties.getProperty("Condition_Customhost"))).isDisplayed())
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
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2)) {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'>>>"+PropertiesName2+"')])[2]");
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
		  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
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
			  if (sensormodallist.get(j).contains(">>>"+PropertiesName2)) {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'>>>"+PropertiesName2+"')])[2]");
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
		  if (sensormodallist.get(j).contains(">>>"+PropertiesName2)) {
				  functionalcomponents.ClickOperation("//div[contains(text(),'>>>"+PropertiesName2+"')]");
				  functionalcomponents.WaitTillTime(2000);
				  break;
			  }
		  }
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Operator_dropdown"))).isDisplayed())
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
		  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);
		  } else
		  {
              failedDescription("user is not able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
		  }
	  }
	  test.log(Status.INFO, "Click on the create button to save the Rule condition");
	  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_Create"));
	  functionalcomponents.WaitTillTime(10000);
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
	  test.log(Status.INFO, "Click on the Output tab in the Rule and add the action to the rule");
	  functionalcomponents.ClickOperation(properties.getProperty("Outputs"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("output_Add"));
	  functionalcomponents.WaitTillTime(1000);
	//  functionalcomponents.ClickOperation(properties.getProperty("output_Action"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Localaction_part1")+Actionname1+properties.getProperty("Localactio_part2"));
	  functionalcomponents.WaitTillTime(2000);	
	  functionalcomponents.ClickOperation(properties.getProperty("Ouput_create"));
	  functionalcomponents.WaitTillTime(10000);	
	  if(driver.findElement(By.xpath(properties.getProperty("Outputs"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to add the action to the rule as"+Actionname1);
	  } else
	  {
          failedDescription("user is able to add the action to the rule as"+Actionname1);	              		 
	  }
	  functionalcomponents.ClickOperation(properties.getProperty("Project_link_part1")+Projectname+properties.getProperty("Project_link_part2"));
	  functionalcomponents.WaitTillTime(7000);	
	  
	  //validate project & publish
	  test.log(Status.INFO, "Click on the validate button on top right corner of the work center");
	  functionalcomponents.ClickOperation(properties.getProperty("validate"));
	  functionalcomponents.WaitTillTime(9000);
	 if (driver.findElement(By.xpath(properties.getProperty("Publish"))).isDisplayed())
	  {
        test.log(Status.PASS, "user is able to validate the project"+":"+Projectname+"successfully");
	  } else
	  {
        failedDescription("user is not able to validate the project"+":"+Projectname+"successfully");
    }
	 
	 
}
	 
	  //PublishProjectandDeploymentConfig
	  @Test(priority=3, dependsOnMethods = { "ProjectCreation" })
	 public void ProjectPublishandDeploymentConfig() {
	  test.log(Status.INFO, "Click on the publish button on top right corner of the work center");
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.ClickOperation(properties.getProperty("Publish"));
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.ClearAndSetValue(properties.getProperty("Edge_configuration_name"), Project_configname);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_publish"));
	  functionalcomponents.WaitTillTime(30000);	
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SAP_logo"), 90); 
	  if (driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
	  {
        test.log(Status.PASS, "user is able to publish the project with configuration name as"+":"+Project_configname+"successfully");
	  } else
	  {
        failedDescription("user is able to see te message Configuration name must be unique");
    }
	  
	 // deployment of configuration & validate operating system for gateway
	  test.log(Status.INFO, "Add the configuration to the gateway and do the deployement");
	//  functionalcomponents.WaitTillTime(7000);	
	  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
	  functionalcomponents.WaitTillTime(30000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
	  functionalcomponents.WaitTillTime(9000);
	  String OperatingSystemvalue = driver.findElement(By.xpath("(//span[@class='sapMText sapUiSelectable sapMTextMaxWidth'])[2]")).getText();
		System.out.println(OperatingSystemvalue);
		if (driver.findElement(By.xpath(properties.getProperty("operting_system"))).isDisplayed())
		{
			test.log(Status.PASS, "operationg system is displaying as :"+OperatingSystemvalue);
			
		}
		else
		  {
			  failedDescription("Operating system is not displaying");
		  }
		test.log(Status.INFO, "Verify Gateway is online");
		if (driver.findElement(By.xpath(properties.getProperty("GatewayStatusonline"))).isDisplayed())
		{
			test.log(Status.PASS, "Gateway Status is Online");
			
		}
		else
		  {
			  failedDescription("Gateway is offline we can not work on this gateway");
		  }
		//Validate Services added successfully to GW
	  functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
	  functionalcomponents.WaitTillTime(30000); 
	  //Adding Streaming service
	  if (!functionalcomponents.IsElementPresent(driver, properties.getProperty("StreamingServiceinstalledRow") ))
		  {	 
	  test.log(Status.INFO, "Add the services to the group by clicking the + button");
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
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
	  
	  //Adding Persistence service to gateway
	  if (!functionalcomponents.IsElementPresent(driver, properties.getProperty("PersistenceServiceinstalledRow") ))
		  {	 
	  test.log(Status.INFO, "Add the services to the group by clicking the + button");
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
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
	   
	  
	  //Adding EBF service to gateway
	  if (!functionalcomponents.IsElementPresent(driver, properties.getProperty("EBFServiceinstaledRow") ))
		  {	 
	  test.log(Status.INFO, "Add the services to the group by clicking the + button");
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
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
	  
	  //Deploy configuration
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
	  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+Project_configname+properties.getProperty("config_value_part2")));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
	  functionalcomponents.WaitTillTime(130000);		
	  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+Project_configname+" "+"successfully");
	  } else
	  {
          failedDescription("user should able to add the configuration with name as"+" "+Project_configname+" "+"not successfully");
      }
	  
	  test.log(Status.INFO, "Click on the Refresh button untill status becomes Applied");
	  functionalcomponents.WaitTillTime(10000);	
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900); 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),Project_configname);
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
	  for(int i=0; i<=40; i++) {
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
		  functionalcomponents.WaitTillTime(10000);
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+Project_configname+properties.getProperty("Activated_msgpart2")));
		  if(ele1.getText().equalsIgnoreCase("Applied"))
			{
			  break;
		  }
		  else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
			{
			  break;
		  }
	  }	
	  
	  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+Project_configname+properties.getProperty("Activated_msgpart2")));
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
	
	 @Test(priority=4, dependsOnMethods = { "ProjectPublishandDeploymentConfig" })
	 public void SensorProfilevalidation() {
	 //Prerequisite- Start the StreamingService Gateway service ( Could version )
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(2000);
	 String pagetitle1=driver.getTitle();
	 System.out.println(pagetitle1);
	 functionalcomponents.WaitTillTime(2000);
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
	 functionalcomponents.WaitTillTime(5000);
	 if(functionalcomponents.IsElementPresent(properties.getProperty("Streaming_Login_Btn")))
	 {	 
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	 functionalcomponents.WaitTillTime(5000);
	 }
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Settings_link"), 90);
	 functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("OutboundConnectors_link"));
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("OutboundConnectorsNewAdd_btn"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("OutboundConnectorsNewAdd_btn"))).isDisplayed())
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
	 if(driver.findElement(By.xpath(properties.getProperty("EnterprisePluginName"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Outbound Connectors Name screen is opening successfully.");
	 }
	 else 
	 {
		failedDescription("EnterprisePlugins Name screen is not opening successfully");
	 }
	 functionalcomponents.ClearAndSetValue(properties.getProperty("EnterprisePluginName"), Plugin_name);
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginName"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("ClassDropdown_btn"))).isDisplayed())
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
	 if(driver.findElement(By.xpath(properties.getProperty("Add_optionslsettings"))).isDisplayed())
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
	 
	 if(driver.findElement(By.xpath(properties.getProperty("Enterprise_savebtn"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to add the optional settings successfully");
	 }
	 else 
	 {
		failedDescription("user is not able to add the optional settings");
	 }
	 functionalcomponents.ClickOperation(properties.getProperty("Enterprise_savebtn"));
	 functionalcomponents.WaitTillTime(2000);
	 String Sensorprofile=CapablityAlternateIDAPI+">>>"+PropertiesName1;
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
	 String Rulenamelink=CapablitynameAPI+PropertiesName1+Rulename;
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
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofilerule_Link"))).isDisplayed())
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
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofilerule_Link"))).isDisplayed())
	 {	
		test.log(Status.PASS, "User is able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }
	 else 
	 {
		failedDescription("User is not able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }				 
 	 
	 test.log(Status.INFO, "Click on the sensor profile to add the RESTPlugin in the rule");
	 String Sensorprofile1=CapablityAlternateIDAPI+">>>"+PropertiesName2;
	 functionalcomponents.ClickOperation((properties.getProperty("sensor_name_part1")+Sensorprofile1+properties.getProperty("sensor_name_part2")));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.scrollToExact(properties.getProperty("Rule_namelink_part1")+Sensorprofile1+properties.getProperty("Rule_namelink_part2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink_part1")+Sensorprofile1+properties.getProperty("Rule_namelink_part2")));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickOperation(properties.getProperty("enterprise_plugin_cancel"));
	 functionalcomponents.WaitTillTime(1000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+Plugin_name+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(5000); 
	 String Rulenamelink1=CapablitynameAPI+PropertiesName2+Rulename1;
	 functionalcomponents.scrollToExact(properties.getProperty("Rule_namelink_part1")+Rulenamelink1+properties.getProperty("Rule_namelink_part2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink1_part1")+Rulenamelink1+properties.getProperty("Rule_namelink1_part2")));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+Plugin_name+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(5000);
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofilerule_Link"))).isDisplayed())
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
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofilerule_Link"))).isDisplayed())
	 {	
		test.log(Status.PASS, "User is able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }
	 else 
	 {
		failedDescription("User is not able to select sensor Profile and check Stream Reading Monitor checbox and saved profile successfully");
	 }		
	
 }
	
 
 public String GetAPIData(String BaseURL, String username, String password) {
	 
		Response response=RestAssured.given().auth().basic(username, password).when().get(BaseURL);
	    System.out.println(response);
	   int code =response.getStatusCode();
	   if(code==200)
	   {
		   test.log(Status.PASS, "Status Code :"+code+" User successfully GET an entity corresponding to the requested");
	   }
	   else if (code==505)
	   {
		   test.log(Status.FAIL, "Status Code :"+code+" Service Unavailable");
	   }
	   else if (code==404)
	   {
		   test.log(Status.FAIL, "Status Code :"+code+" requested resource has not been found.Please check the requested URL.");
	   }
	   
	   else if (code==504)
	   {
		   test.log(Status.FAIL, "Status Code :"+code+" The server didn't respond in time due to timeout requests.Please try again later");
	   } 
	   else {
		   test.log(Status.FAIL, "API URL is incorrect Unknow host Error Please check url");
	   }
	    APIData =response.asString();
	    System.out.println(APIData);
	    return APIData;
	 
 }
 public void GetDeviceMethod() throws Exception {
	 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
		 DeviceBaseurl = CockpitURL+"/iot/core/api/v1/devices";
	 }
	 else
	 {
		 DeviceBaseurl = CockpitURL+"/iot/core/api/v1/tenant/"+TenantID+"/devices?skip=0&top=1000000"; 
	 }
	  //System.out.println(DeviceBaseurl);
	  String Devicedata = GetAPIData(DeviceBaseurl, Cockpitusername, Cockpitpassword);
	   JSONParser parse = new JSONParser(); 
	   JSONArray jsonarr = (JSONArray)parse.parse(Devicedata);
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
		
	    String Sensortypedata =GetAPIData(SesorTypeBaseURL, Cockpitusername, Cockpitpassword);
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
	    String Capablitydata =GetAPIData(CapabiltyBaseURL, Cockpitusername, Cockpitpassword);
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

	
 public String postdata(String BaseURL, String username, String password, String Payload) {
 		 RequestSpecification request = RestAssured.given().auth().basic(username, password);
 		 request.header("Content-Type", "application/json");
 		 request.body(Payload);
 		 Response response =request.post(BaseURL);
 		 int statusCode = response.getStatusCode();
 		 System.out.println(statusCode);
 		 String Responsedata =response.asString();
 		  System.out.println("body data is"+Responsedata);
 		 String statusdescription= response.getStatusLine();
 		 System.out.println(statusdescription);
 		 if(statusCode==200 || statusdescription.contains("OK") ) 
 		 {
 		 test.log(Status.PASS, "User is able to post Successfully in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode+" response for successful HTTP requests"+Responsedata);
 		 }
 		 else if (statusCode==504)
 		   {
 			   test.log(Status.FAIL, "Status Code :"+statusCode+"Bad Request"+Responsedata);
 		   } 
 		 else if (statusCode==400)
 		   {
 			   test.log(Status.FAIL, "Status Code :"+statusCode+" The server didn't respond in time due to requests time.Please check jeson payload format"+Responsedata);
 		   } 
 		 
 		 else if (statusCode==409)
 		   {
 			   test.log(Status.FAIL, "Status Code :"+statusCode+" Response :"+Responsedata);
 		   } 
 		else if (statusCode==500)
 		   {
 			   test.log(Status.FAIL, "Status Code :"+statusCode+"Internal Server Error and Response :"+Responsedata);
 		   } 	 
 		 
 		 else {
 			 test.log(Status.FAIL, "User is not able to post in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode);
 		 }
 		 return Responsedata;
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
 		   APIData =postdata(CapabiltyBaseURL, Cockpitusername, Cockpitpassword, Capablitypayload);
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
 	 APIData =postdata(SesorTypeBaseURL, Cockpitusername, Cockpitpassword, sensortypepayload);
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
 			   APIData =postdata(DeviceBaseurl, Cockpitusername, Cockpitpassword, Devicepayload);
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
 			   APIData =postdata(SensorBaseURL, Cockpitusername, Cockpitpassword, Sansorpayload);
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
