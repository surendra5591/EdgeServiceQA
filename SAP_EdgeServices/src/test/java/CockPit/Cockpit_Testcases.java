package CockPit;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;
import org.eclipse.paho.client.mqttv3.MqttTopic;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

class Cockpit_Testcases extends BaseTest  {
	 
	Properties properties = functionalcomponents.getObjectProperties();
	String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "PolicyServiceURL");
	String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "username");
	String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "password");
	String Tenant=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "Tenant");
	String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "GateWayNo");
	String Project_configname=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Project_configname");
	String DB_UserName=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "DB_userid");	 
	String DB_Password=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "DB_pwd");	  

	@Test(priority =0)
	 public void TC01_Cockpit_Flow() throws InterruptedException, MqttPersistenceException, MqttException
	 {
		String CockpitURL= functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "CockpitURL");
		String user = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "UserName");
		String cockpitpassword = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "Password");
		String CapablityName = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "CapablityName");
		String CapablityAlternateID = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "CapablityAlternateID");
		String  PropertiesName1 = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "PropertiesName1");
		String  PropertiesName2 = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "PropertiesName2");
		String SensorTypesName = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "SensorTypesName");
		String DeviceName = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "DeviceName");
		String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "GateWayNo");
		String DeviceAlternateID = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "DeviceAlternateID");

		String SensorName = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "SensorName");
		String SensorAltID = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "SensorAltID");
		
		//EdgeDeginer input
		String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "username");
		String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "password");
		String Projectpname = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "project_name");
		String projectdesc=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Description");
		String Project_configname=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Project_configname"); 
		String average_value  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "AverageReading_value");
		String Minimum_output_frequency= functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Minimum_output_frequency");
		String Keep_events_Days=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Keep_events_Days");
		String Max_edge_Readings_store=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Max_edge_Readings_store");
		String Enterprise_max_output_frequency=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Enterprise_max_output_frequency");
		String Local_enterpriseplugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Local_enterprise_plugin");
		String Rulename  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "RuleName");
		String Ruledesc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Rule_Desc");
		String Rulecondition  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Rule_condition");
		String RuleMaxfrequency=  functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "RuleMaxoutfrequency");
		String Rulename1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "RuleName1");
		String Ruledesc1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Rule_Desc1");
		String Rulecondition1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Rule_condition1");
		
		String filteropt  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Filter");
		String filtervalue  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Filtervalue");
		String conditiontype  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Condtiontype");
		String sensor_modelname  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Sensormodelname");
		String customproject_host=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Customprojecthost");
		String customproject_port=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "customprojectport");
		String maximum_eventfrequency1=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Max_eventfrequency");
		String interval_without_sensor=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "intervalwithoutsensor");
		String Targetstate=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Targetstate");
		String Timein_State=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Timeinstate");
		String operator  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Operator");
		String thresholding_value  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Thresholdingvalue");
		String Actionname  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Actionname");
	    String Action_desc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "ActionDescription");
	    String Actionname1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Actionname1");
	    String Action_desc1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "ActionDescription1");
	    String Action_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Action_type");
	    String protocol_plugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "ProtocolPlugin");
	    String Actionmsg=  functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Action_Message");
	    String Receipient_param= functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Receipient_parameters");
	    String Scope_level  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Scope_level");
	    String Edge_Fedilityfreq  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "New_edgefedility_freq");
	    String Edge_fedility_rollback = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "edge_fedility_rollback");
	    String enterprise_fedility = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Enterprise_fedility");
	    String enterprise_rollback  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Enterprise_rollback");
	    
	    String Edge_Fedilityfreq1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "New_edgefedility_freq1");
	    String Edge_fedility_rollback1 = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "edge_fedility_rollback1");
	    String enterprise_fedility1 = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Enterprise_fedility1");
	    String enterprise_rollback1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "Enterprise_rollback1");
	    
	    
	    String DB_UserName=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "DB_userid");	 
	    String DB_Password=functionalcomponents.getdatafromsheet("EdgeDesigner", "TC01_Cockpit_Flow", "DB_pwd");	  

		//Streaming input
	    String Plugin_name=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "Plugin_name");
	    String FIDELITY_AUTHENTICATION_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "FIDELITY_AUTHENTICATION_input");
	    String FIDELITY_AUTH_TYPE_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "FIDELITY_AUTH_TYPE_input");
	    String FIDELITY_URI_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "FIDELITY_URI_input");
		String FIDELITY_USERNAME_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "FIDELITY_USERNAME_input");
		String ENTERPRISE_EVENT_AUTH_TYPE_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "ENTERPRISE_EVENT_AUTH_TYPE_input");
		String ENTERPRISE_EVENT_AUTHENTICATION_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "ENTERPRISE_EVENT_AUTHENTICATION_input");
		String ENTERPRISE_EVENT_URI_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "ENTERPRISE_EVENT_URI_input");
		String ENTERPRISE_EVENT_USERNAME_input=functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "ENTERPRISE_EVENT_USERNAME_input");
		
		
		
		test.log(Status.INFO, "Enter cockpit url & User Name, Password and login cockpit application ");
		driver.get(CockpitURL);
		driver.navigate().refresh();
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("cockpit_UserName"), 70);
		functionalcomponents.ClickAndSetValue(properties.getProperty("cockpit_UserName"), user);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickAndSetValue(properties.getProperty("cockpit_Password"), cockpitpassword);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("Cockpit_Login_Button"));
		functionalcomponents.WaitTillTime(3000);
		if(functionalcomponents.IsElementPresent(properties.getProperty("Cockpitversion"))){	
			test.log(Status.PASS, "user name & Password entered successfully");
		    }
			else {
				failedDescription("user name & Password is not entered successfully");

			}
		 test.log(Status.INFO, "Capture Version of the IOTS Cockpit");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Cockpitversion"), 50); 
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Cockpitversion"));
		 functionalcomponents.WaitTillTime(2000);
		 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Cockpitversionvalue"))).getText();
		 System.out.println(Versionvalue);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("VersionPopupClose"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Cockpitversion"), 50); 			 
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Cockpitversion"))).isDisplayed())
		 {	
			test.log(Status.PASS, "Cockpit Login successfully and version of the cockpit is"+Versionvalue);
		 }
		 else 
		 {
			failedDescription("Cockpit is not Login successfully");
		 }
		
		test.log(Status.INFO, "Creating capablity");
		functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceLinkpart1")+Tenant+properties.getProperty("EdgeServiceLinkpart2"));
		functionalcomponents.WaitTillTime(5000);
		//functionalcomponents.ClickOperation(properties.getProperty("DeviceManagmentLink"));
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("DeviceCapablitiesLink"));
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("CapablitiesAddButton"));
		functionalcomponents.WaitTillTime(4000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("CapablityName"), CapablityName);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("CapablityAlternateID"), CapablityAlternateID);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("PropertiesName1"), PropertiesName1);
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("CapablityDatatypedropdown1"));
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("SelectFloat"));
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("UnitofMeasure1"), "Degree");
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("AddPropertybutton"));
		functionalcomponents.WaitTillTime(4000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("PropertiesName2"), PropertiesName2);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("CapablityDatatypedropdown2"));
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("Selectefloatsecond"));
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("UnitofMeasure2"), "Degree");
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("CapablityCreatebutton"));
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("ConfirmPopupButton"));
		functionalcomponents.WaitTillTime(5000);
		WebElement Capablity_name = driver.findElement(By.xpath("//div[contains(@id,'expand-heading-wrapper')]//child::span[text()='"+CapablityName+"']"));
		if(Capablity_name.getText().equalsIgnoreCase(CapablityName)){	
			test.log(Status.PASS, "user is able to Create Capablity successfully with capablity Name is :"+CapablityName);
		 }
		else {
				failedDescription("user is not able to create Capablity");

		}
		//CreateSensor Types
		test.log(Status.INFO, "Creating Sensor Types");
		functionalcomponents.ClickOperation(properties.getProperty("DeviceSensortypesLink"));
		functionalcomponents.WaitTillTime(3000); 
		functionalcomponents.ClickOperation(properties.getProperty("AddSensorTypesButton"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("SensorTypesname"), SensorTypesName);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("CapablityDropdownbutton"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.scrollToExact("//div[text()='"+CapablityName+"']");
		functionalcomponents.WaitTillTime(500);
		functionalcomponents.ClickOperation("//div[text()='"+CapablityName+"']");
		functionalcomponents.WaitTillTime(1000);
		//functionalcomponents.ClickOperation(properties.getProperty("SensortypeDropdown"));
		functionalcomponents.ClickOperation(properties.getProperty("SelectMeasure"));
		functionalcomponents.WaitTillTime(500);
		functionalcomponents.ClickOperation(properties.getProperty("CreateButton"));
		functionalcomponents.WaitTillTime(5000);
		WebElement Sensortype_name = driver.findElement(By.xpath("//div[contains(@id,'expand-heading-wrapper')]//child::span[text()='"+SensorTypesName+"']"));
		if(Sensortype_name.getText().equalsIgnoreCase(SensorTypesName)){	
			test.log(Status.PASS, "user is able to Create Sensor Type successfully with Sensor type Name is :"+SensorTypesName);
		 }
		else {
				failedDescription("user is not able to create Sesoretype");

		}
		
		functionalcomponents.ClickOperation(properties.getProperty("DeviceSensortypesLink")); 
        functionalcomponents.WaitTillTime(4000);
        functionalcomponents.scrollToExact(properties.getProperty("txt_SensorTypes_Search"));
        functionalcomponents.ClickAndSetValue(properties.getProperty("txt_SensorTypes_Search"), SensorTypesName);
        functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("btn_SensorTypes_SearchIcon"), 40);
        functionalcomponents.ClickOperation(properties.getProperty("btn_SensorTypes_SearchIcon"));
        functionalcomponents.WaitTillTime(4000);
		//SensortypeID capture
		 String SensorTypeID = driver.findElement(By.xpath(properties.getProperty("lbl_SensorTypes_IDOne")+SensorTypesName+properties.getProperty("lbl_SensorTypes_IDTwo"))).getText();
	     System.out.println(SensorTypeID);
		
		// Create Device
		test.log(Status.INFO, "Creating Device");
		functionalcomponents.ClickOperation(properties.getProperty("DevicesLink"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("AddDeviceButton"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("DeviceName"), DeviceName);
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayDropdown"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.scrollToExact("//div[contains(.,'"+GateWayNo+"') and @class='sapMSLITitleOnly']");
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation("//div[contains(.,'"+GateWayNo+"') and @class='sapMSLITitleOnly']");
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("DeviceAlternateID"), DeviceAlternateID);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("DeviceCreateButton"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ConfirmPopupButton"), 90);
		functionalcomponents.ClickOperation(properties.getProperty("ConfirmPopupButton"));
		functionalcomponents.WaitTillTime(15000);
		functionalcomponents.ClickOperation(properties.getProperty("DevicesLink"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("Device_search"), DeviceName);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("device_searchbtn"));
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation((properties.getProperty("device_link_part1")+DeviceName+properties.getProperty("device_link_part2")));
		functionalcomponents.WaitTillTime(2000); 
		functionalcomponents.waittill_WebElement_getVisible("//div[contains(@id,'expand-heading-wrapper')]//child::span[text()='"+DeviceName+"']", 50);
		WebElement Device_name = driver.findElement(By.xpath("//div[contains(@id,'expand-heading-wrapper')]//child::span[text()='"+DeviceName+"']"));
		if(Device_name.getText().equalsIgnoreCase(DeviceName)){	
			test.log(Status.PASS, "user is able to Create Device with Device Name is :"+DeviceName);
		 }
		else {
				failedDescription("user is not able to create Device");

		}
		
		//Create Sensor
		test.log(Status.INFO, "Creating Sensor");
		functionalcomponents.ClickOperation(properties.getProperty("AddSensorbutton"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("SensorName"), SensorName);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("SensorTypedropdown"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.scrollToExact("//div[text()='"+SensorTypesName+"']");
		functionalcomponents.WaitTillTime(500);
		functionalcomponents.ClickOperation("//div[text()='"+SensorTypesName+"']");
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClearAndSetValue(properties.getProperty("SensorAltID"), SensorAltID);
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("SensorCreatebutton"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("ConfirmPopupButton"));
		functionalcomponents.WaitTillTime(7000);
		WebElement Sensor_ele = driver.findElement(By.xpath("//a[text()='"+SensorName+"']"));
		if(Sensor_ele.getText().equalsIgnoreCase(SensorName)){	
			test.log(Status.PASS, "user is able to Create Sensor with Sensor Name is :"+SensorName);
		 }
		else {
				failedDescription("user is not able to create Sensor");

		}
		//Create Sensor Profile using Edge Deginer
		//Prerequisite- Start the Policyservice  ( Could version ) with new tile EdgeDesigner
		 test.log(Status.INFO, "Login into the Policy service with the valid credentilas ");
		 driver.get(PolicyServiceURL);
//		 functionalcomponents.ClickOperation(properties.getProperty("Authenticate_using_IDP"));
//		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesiger_UserName"), 50);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesiger_UserName"), username);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesigner_PassWord"), password);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_Logon"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 50); 
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Edgedesigner_tile"))).isDisplayed())
		 {
			 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
		 }
		 else 
		 {
			failedDescription("user is able to enter into the HOME page ");
		 }
		 test.log(Status.INFO, "Click on Edge designer tile of the Home Page");
		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edge_designer_version"), 50); 
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Edge_designer_version"));
		 functionalcomponents.WaitTillTime(2000);
		 String Versionvalue1=driver.findElement(By.xpath(properties.getProperty("Edge_Designer_versionvalue"))).getText();
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 20); 			 
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Project_Addbutton"))).isDisplayed())
		 {	
			test.log(Status.PASS, "Edge desinger tile window opens successfully and version of the Edge designer is"+Versionvalue1);
		 }
		 else 
		 {
			failedDescription("Edge designer tile is not opened successfully");
		 }
	 
		
		 //Project creation
		 test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
		 functionalcomponents.WaitTillTime(2000);
		 if (driver.findElement(By.xpath(properties.getProperty("Create_project"))).isDisplayed())
		  {
             test.log(Status.PASS, "user is able to see Add Prject window successfully");
		  } else
		  {
             failedDescription("user is not able to see the Add Project window ");
         } 
		 			 
		  test.log(Status.INFO, "Enter the name of the project with special characters");			 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),Projectpname);	  
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Project_name"))).isDisplayed())
		  {	
				test.log(Status.PASS, "project name as"+":"+Projectpname+" "+" is saved successfully with special characters");
		  }
		  else 
		  {
				failedDescription(" project name is not saved successfully with special characters");
		  }
		  test.log(Status.INFO, "Enter description of the project and click on the create button");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Refresh_button"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Projectpname);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1") +Projectpname+ properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(3000);
		  
		/*
		 * String
		 * ProjectNamevalue=driver.findElement(By.xpath("//span[text()='"+Projectpname+
		 * "']")).getText(); if (ProjectNamevalue.equalsIgnoreCase(Projectpname)) {
		 * test.log(Status.PASS,
		 * "user is able to create Project with name:"+""+Projectpname+
		 * ""+"and Group Description:"+""+projectdesc+""+"successfully"); } else {
		 * failedDescription("user is not able to enter the  Project name and description in the window"
		 * ); }
		 */
		  
		  
		//creation of sensor model
		  test.log(Status.INFO, "click on the Sensor Model tab and click on + button to add sensormodel to the project");	
		  functionalcomponents.WaitTillTime(2000);	
		  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Model"));
		  functionalcomponents.WaitTillTime(2000);				  
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_add"));
		  functionalcomponents.WaitTillTime(4000);
		  if(driver.findElement(By.xpath(properties.getProperty("Sensor_Typedropdown"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to see sensor model window successfullly");
		  } else
		  {
              failedDescription("user is not able to see the sensor model window");
          }
		  test.log(Status.INFO, "select the sensor type,capability in the sensor model window");
		  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Typedropdown"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("SensorType_part1")+SensorTypesName+properties.getProperty("SensorType_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Capability_Namedropdown"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("capability_name_part1")+CapablityName+properties.getProperty("capability_name_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Property_namecheckbox"))).isDisplayed())
		  {	
			  test.log(Status.PASS, "User is able to Select sensor type as"+": "+SensorTypesName+" "+"& capability as"+ ":"+CapablityName+"from dropdown ");
		  }
		  else 
		  {
			  failedDescription("user is not able to select sensor type and capability from dropdown ");
		  }
		  test.log(Status.INFO, "check the property and enter the average reading value < 2147483647 in the sensor model");			  
		  functionalcomponents.ClickOperation(properties.getProperty("Property_namecheckbox"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Create_averagereading_value"), average_value);
		  functionalcomponents.WaitTillTime(2000);
		  if(Integer.parseInt(average_value)<=2147483647)
		  {
			  test.log(Status.PASS, "numeric values of the averaging reading value as"+":"+average_value+":"+"saved and verified Maximum value is not exceed 2147483647.");
		  } else
		  {
              failedDescription("numeric values of the averaging reading value as"+":"+average_value+":"+"saved and verified Maximum value is not exceed 2147483647.");
          }
		  test.log(Status.INFO, "Click create sensor model button and verify sensor model is created successfully");	
		  functionalcomponents.ClickOperation(properties.getProperty("Sensor_modelcreate"));
		  functionalcomponents.WaitTillTime(4000);
		  List<WebElement> Sensormodels=driver.findElements(By.xpath("//a[contains(text(),'"+SensorTypesName+"')]"));
		  System.out.println(Sensormodels);
		  List<String> sensormodallist=new ArrayList<String>();
		  for(int i=0; i<Sensormodels.size();i++) {
		  System.out.println(Sensormodels.get(i).getText());
		  if (Sensormodels.get(i).getText().contains(SensorTypesName))
		  {
			  sensormodallist.add(Sensormodels.get(i).getText());
			  System.out.println(sensormodallist);
			  
		  }
		  }
		  
		  if(functionalcomponents.IsElementPresent(properties.getProperty("Sensor_Model")))
		  {
			  test.log(Status.PASS, "user is able to create the Sensor model in the project with sensor model names:"+sensormodallist);		  }
		  else
		  {
              failedDescription("user is not able to create the sensor model in the project ");
          }	
		   			  
		  test.log(Status.INFO, "click on the sensor model name check box and click on the fedility to add the Local Enterprise plugin");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Model"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_name"));			  
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("feidelty"));
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Enabled_Radio"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to see the Add fedility window successfully");
		  } else
		  {
              failedDescription("user is not able to see the Add fedility window successfully");
          }
		  
		  functionalcomponents.ClickOperation(properties.getProperty("Enabled_Radio"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Enabledbutton"));
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
		  functionalcomponents.WaitTillTime(4000);	 
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
			  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1") +Action_type+ properties.getProperty("Action_Type_part2"));
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
				  if (sensormodallist.get(j).contains(PropertiesName1)) {
					  functionalcomponents.ClickOperation("//div[@class='sapMPopoverScroll']//li[contains(text(),'"+PropertiesName1+"')]");
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
			  functionalcomponents.ClickAndSetValue(properties.getProperty("fedility_freqency"),Edge_Fedilityfreq);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("fedility_Rollback"),Edge_fedility_rollback);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Enterprise_fedility"),enterprise_fedility);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Enterprisefedility_rollback"),enterprise_rollback);
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
		  
		  // Creation Action for Longtitude
		  
		  test.log(Status.INFO, "Click on the Actions tab to in the project");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Actions"));
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
				  if (sensormodallist.get(j).contains(PropertiesName2)) {
					  functionalcomponents.ClickOperation("//div[@class='sapMPopoverScroll']//li[contains(text(),'"+PropertiesName2+"')]");
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
			  functionalcomponents.ClickAndSetValue(properties.getProperty("fedility_freqency"),Edge_Fedilityfreq1);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("fedility_Rollback"),Edge_fedility_rollback1);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Enterprise_fedility"),enterprise_fedility1);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Enterprisefedility_rollback"),enterprise_rollback1);
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
		  functionalcomponents.WaitTillTime(2000);
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
		  
		  String RulenameLatitude=CapablityName+"_"+PropertiesName1+"_"+Rulename;
		  
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
		  functionalcomponents.WaitTillTime(2000);
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
		 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Rulecondition_name"),CapablityName+PropertiesName1+Rulecondition);
		  if(driver.findElement(By.xpath(properties.getProperty("Filter_dropdown"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to enter the rule conditon nmae as"+":"+CapablityName+PropertiesName1+Rulecondition+"successfully");
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
		  functionalcomponents.WaitTillTime(7000);			 
		  
		  if(conditiontype.equalsIgnoreCase("External Custom Rule-CCL"))
		  {
			  test.log(Status.INFO, "select the condition type as External Custom Rule-CCL and select the sensor model name");
			  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+properties.getProperty("conditiontype_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1")+sensor_modelname+properties.getProperty("Sensor_modelname_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Condition_Customhost"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
			  } else
			  {
	              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
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
			  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1") +sensor_modelname+ properties.getProperty("Sensor_modelname_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Interval_withoutsensor"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
			  } else
			  {
	              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
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
			  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1") +sensor_modelname+ properties.getProperty("Sensor_modelname_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Target_State_dropdown"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
			  } else
			  {
	              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
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
				  if (sensormodallist.get(j).contains(PropertiesName1)) {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'"+PropertiesName1+"')])[2]");
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
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to create the rule condition as"+":"+Rulecondition+"successfully");
		  } else
		  {
              failedDescription("user is able to create the rule condion successfully");	              		 
		  }
		// Enable Rule
		  functionalcomponents.ClickOperation(properties.getProperty("EnableRule"));
		  functionalcomponents.WaitTillTime(7000);
		  
		  //Create ouptuts in the Rule 1 for latitude sensor model
		  test.log(Status.INFO, "Click on the Output tab in the Rule and add the action to the rule");
		  functionalcomponents.ClickOperation(properties.getProperty("Outputs"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("output_Add"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("output_Action"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Localaction_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Localaction_part1")+Actionname+properties.getProperty("Localactio_part2"));
		  functionalcomponents.WaitTillTime(2000);	
		  functionalcomponents.ClickOperation(properties.getProperty("Ouput_create"));
		  functionalcomponents.WaitTillTime(2000);	
		  if(driver.findElement(By.xpath(properties.getProperty("Outputs"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to add the action to the rule as"+Actionname);
		  } else
		  {
              failedDescription("user is able to add the action to the rule as"+Actionname);	              		 
		  }
		    
		//creation of rule2 for longitude sensor model
		  test.log(Status.INFO, "click on Rules Tab in the project");
		  functionalcomponents.ClickOperation(properties.getProperty("Project_link_part1")+Projectpname+ properties.getProperty("Project_link_part2"));
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
		  String RulenameLongtitude=CapablityName+"_"+PropertiesName2+"_"+Rulename1;
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
		  functionalcomponents.WaitTillTime(2000);
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
		 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Rulecondition_name"),CapablityName+PropertiesName2+Rulecondition1);
		  if(driver.findElement(By.xpath(properties.getProperty("Filter_dropdown"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to enter the rule conditon nmae as"+":"+CapablityName+PropertiesName2+Rulecondition1+"successfully");
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
		  functionalcomponents.WaitTillTime(2000);			 
		  
		  if(conditiontype.equalsIgnoreCase("External Custom Rule-CCL"))
		  {
			  test.log(Status.INFO, "select the condition type as External Custom Rule-CCL and select the sensor model name");
			  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1") +conditiontype+ properties.getProperty("conditiontype_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1")+sensor_modelname+ properties.getProperty("Sensor_modelname_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Condition_Customhost"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
			  } else
			  {
	              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
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
			  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1") +sensor_modelname+ properties.getProperty("Sensor_modelname_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Interval_withoutsensor"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
			  } else
			  {
	              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
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
			  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1")+sensor_modelname+properties.getProperty("Sensor_modelname_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Target_State_dropdown"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
			  } else
			  {
	              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
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
			  if (sensormodallist.get(j).contains(PropertiesName2)) {
					  functionalcomponents.ClickOperation("(//div[@class='sapMPopoverCont']//li[contains(text(),'"+PropertiesName2+"')])[2]");
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
		  functionalcomponents.WaitTillTime(7000);
		  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to create the rule condition as"+":"+Rulecondition1+"successfully");
		  } else
		  {
              failedDescription("user is able to create the rule condion successfully");	              		 
		  }	 
		  
		// Enable Rule
		  functionalcomponents.ClickOperation(properties.getProperty("EnableRule"));
		  functionalcomponents.WaitTillTime(7000);
		//Create outputs in the Rule2 for longitude
		  test.log(Status.INFO, "Click on the Output tab in the Rule and add the action to the rule");
		  functionalcomponents.ClickOperation(properties.getProperty("Outputs"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("output_Add"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("output_Action"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Localaction_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Localaction_part1")+Actionname1+properties.getProperty("Localactio_part2"));
		  functionalcomponents.WaitTillTime(2000);	
		  functionalcomponents.ClickOperation(properties.getProperty("Ouput_create"));
		  functionalcomponents.WaitTillTime(2000);	
		  if(driver.findElement(By.xpath(properties.getProperty("Outputs"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to add the action to the rule as"+Actionname1);
		  } else
		  {
              failedDescription("user is able to add the action to the rule as"+Actionname1);	              		 
		  }
		  functionalcomponents.ClickOperation(properties.getProperty("Project_link_part1") +Projectpname+ properties.getProperty("Project_link_part2"));
		  functionalcomponents.WaitTillTime(3000);	
		  
		  //validate project & publish
		  test.log(Status.INFO, "Click on the validate button on top right corner of the work center");
		  functionalcomponents.ClickOperation(properties.getProperty("validate"));
		  functionalcomponents.WaitTillTime(1000);
		 if (driver.findElement(By.xpath(properties.getProperty("Publish"))).isDisplayed())
		  {
            test.log(Status.PASS, "user is able to validate the project"+":"+Projectpname+"successfully");
		  } else
		  {
            failedDescription("user is not able to validate the project"+":"+Projectpname+"successfully");
        }
		  //Publish
		  test.log(Status.INFO, "Click on the publish button on top right corner of the work center");
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("Publish"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Edge_configuration_name"), Project_configname);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_publish"));
		  functionalcomponents.WaitTillTime(5000);	  
		  if (driver.findElement(By.xpath(properties.getProperty("SAP_logo"))).isDisplayed())
		  {
            test.log(Status.PASS, "user is able to publish the project with configuration name as"+":"+Project_configname+"successfully");
		  } else
		  {
            failedDescription("user is able to see te message Configuration name must be unique");
        }
		  
		 // deployment of configuration
		  test.log(Status.INFO, "Add the configuration to the gateway and do the deployement");
		  functionalcomponents.WaitTillTime(7000);	
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+Project_configname+properties.getProperty("config_value_part2")));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		  functionalcomponents.WaitTillTime(3000);		
		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+Project_configname+" "+"successfully");
		  } else
		  {
              failedDescription("user should able to add the configuration with name as"+" "+Project_configname+" "+"not successfully");
          }
		  test.log(Status.INFO, "Click on the Refresh button untill status becomes Activated");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),Project_configname);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
		  functionalcomponents.WaitTillTime(5000);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
		  functionalcomponents.WaitTillTime(5000);
		  for(int i=0; i<=10; i++) {
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(15000);
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+Project_configname+properties.getProperty("Activated_msgpart2")));
			  if(ele1.getText().equalsIgnoreCase("Activated"))
				{
				  break;
			  }
		  }		  
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+Project_configname+properties.getProperty("Activated_msgpart2")));
		  String text2= ele1.getText();
		  System.out.println(text2);
		    
			if(text2.equalsIgnoreCase("Activated"))
			{
				 test.log(Status.PASS, "configuration Activated successfully");
			}
			else
			{
				 failedDescription("Activation failed message will be displyed");
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
		  
		  String Streamingusername = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "Stream_username");
		  String Streamingpassword = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "Stream_password");
	     
		
		 //Prerequisite- Start the StreamingService Gateway service ( Could version )
		 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
		 driver.get(properties.getProperty("StreamingService_URL"));
		 functionalcomponents.WaitTillTime(2000);
		 String pagetitle1=driver.getTitle();
		 System.out.println(pagetitle1);
		 functionalcomponents.WaitTillTime(2000);
		 if(pagetitle1.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
		 {	
			test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle1);
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
		 
		 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugin_link"));
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginNewAdd_btn"), 20);
		 if(driver.findElement(By.xpath(properties.getProperty("EnterprisePluginNewAdd_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, " Screen is loaded with Enterprise Plugins Page");
		 }
		 else 
		 {
			failedDescription("Screen is not loaded with Enterprise Plugins Page");
		 }
		 test.log(Status.INFO, "Click on add + Symbol to create New EnterprisePlugins");
		 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePluginNewAdd_btn"));
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginName"), 20);
		 if(driver.findElement(By.xpath(properties.getProperty("EnterprisePluginName"))).isDisplayed())
		 {	
			test.log(Status.PASS, "EnterprisePlugins Name screen is opening successfully.");
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
		 functionalcomponents.ClickOperation(properties.getProperty("Rest_enterpriseplugin"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Description_plugin"), "REST Plugin");
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.PageScrollDown();
		 if(driver.findElement(By.xpath(properties.getProperty("Add_optionslsettings"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to select the Restplugin class");
		 }
		 else 
		 {
			failedDescription("user is not able to select the REST enterprise plugin class");
		 }
		 
		 //1
		 test.log(Status.INFO, "Click on add + Symbol to add the optional settings");
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"0"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("FIDELITY_AUTHENTICATION"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_AUTHENTICATION_input"), FIDELITY_AUTHENTICATION_input);
		//2
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"1"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.scrollToExact(properties.getProperty("FIDELITY_AUTH_TYPE"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("FIDELITY_AUTH_TYPE"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_AUTH_TYPE_input"), FIDELITY_AUTH_TYPE_input);
		 //3
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"2"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("FIDELITY_URI"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_URI_input"), FIDELITY_URI_input);
		 //4
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"3"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("FIDELITY_USERNAME"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_USERNAME_input"), FIDELITY_USERNAME_input);
		 //5
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"4"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_AUTH_TYPE"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ENTERPRISE_EVENT_AUTH_TYPE_input"), ENTERPRISE_EVENT_AUTH_TYPE_input);
		 //6
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"5"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_AUTHENTICATION"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ENTERPRISE_EVENT_AUTHENTICATION_input"), ENTERPRISE_EVENT_AUTHENTICATION_input);
		 //7
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"6"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_URI"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ENTERPRISE_EVENT_URI_input"), ENTERPRISE_EVENT_URI_input);
		 //8
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"7"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_USERNAME"));
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ENTERPRISE_EVENT_USERNAME_input"), ENTERPRISE_EVENT_USERNAME_input);
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
		 
		 String sensorname=CapablityAlternateID+"_"+PropertiesName1;
		 //Adding the enterprise plugin into Rules sensor profile 1
		 test.log(Status.INFO, "Go to sensor Profilr and select Enterprise Plugin and Click Save Rule button and verify Rule is created successfully for Sensore Profile");
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));	
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("sensor_name_part1")+sensorname+properties.getProperty("sensor_name_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink_part1")+sensorname+properties.getProperty("Rule_namelink_part2")));
		 functionalcomponents.WaitTillTime(2000);		 
		 functionalcomponents.ClickOperation(properties.getProperty("enterprise_plugin_cancel"));
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+Plugin_name+properties.getProperty("SelectEnterprisePart2"));
		 functionalcomponents.WaitTillTime(2000);	
		 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
		 functionalcomponents.WaitTillTime(5000);
		 
		 String Rulenamelink=CapablityName+"_"+PropertiesName1+"_"+Rulename;
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
		 String sensorname1=CapablityAlternateID+"_"+PropertiesName2;
		 functionalcomponents.ClickOperation((properties.getProperty("sensor_name_part1")+sensorname1+properties.getProperty("sensor_name_part2")));
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickOperation((properties.getProperty("Rule_namelink_part1")+sensorname1+properties.getProperty("Rule_namelink_part2")));
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
		 
		 String Rulenamelink1=CapablityName+"_"+PropertiesName2+"_"+Rulename1;;
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
		
		//loop 50 times
		
		//count = count + 1
		 for(int i=1; i<=50; i++) {
		String topicName = functionalcomponents.getdatafromsheet("CockPit", "TC01_Cockpit_Flow", "Measure");
		 String message = "{ \"sensorTypeAlternateId\":\""+SensorTypeID+"\","+
		                   "\"capabilityAlternateId\":\""+CapablityAlternateID+"\","+
				           "\"sensorAlternateId\":\""+SensorAltID+"\","+
		                   " \"measures\":[  \r\n" + 
		                   " 23,\r\n" + 
		                   " 24\r\n" + 
		                   " ]\r\n" + 
		                   "}";
		 System.out.println(message);
		 Mqttclass.publishToTopic(topicName, message);

		 }
	 
	
	
}	

}
