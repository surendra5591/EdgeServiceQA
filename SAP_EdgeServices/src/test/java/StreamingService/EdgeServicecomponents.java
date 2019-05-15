package StreamingService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.Status;

public class EdgeServicecomponents extends BaseTest {
	
	
	Properties properties = functionalcomponents.getObjectProperties();
	
	public  String SetProtocolandCreateWebSocketPlugin1_StreamingService()
	{
		
		//Set Protocols & Create WebSocketEnterprise Plugin
		 test.log(Status.INFO, "Click on Http Protocol Plugins on the workcenter at left of the screen Settings>>HttpProtocol Plugin");
		 functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ProtocolPlugin_link"));
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Select_httpProtocolPlugin"), 20);
		 if(driver.findElement(By.xpath(properties.getProperty("Select_httpProtocolPlugin"))).isDisplayed())
		 {	
			test.log(Status.PASS, " Screen is loaded with HttpProtocolPlugins Page");
		 }
		 else 
		 {
			failedDescription("Screen is not loaded with HttpProtocolPlugins Page");
		 } 
		 test.log(Status.INFO, "Select HttpProtocolPlugins on the screen");
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Select_httpProtocolPlugin"));
		 if(driver.findElement(By.xpath(properties.getProperty("HttpprotocolSave_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, " Screen is loaded with option add Protocol Plugin Information");
		 }
		 else 
		 {
			failedDescription("Screen is not loaded with option add Protocol Plugin Information");
		 }
		 
		 test.log(Status.INFO, "Set Option Setting 1. AUTHENTICATION_TYPE from Token to None ," + "2. SECURE_ONLY from true to false");
		 List<WebElement> Name=new ArrayList<WebElement>();
		 Name.addAll(driver.findElements(By.xpath(properties.getProperty("OptionalSettingName_List"))));
		 int listsize=Name.size();
		 for(WebElement ele: Name)
		 {
			 
			 if(ele.getText().equalsIgnoreCase("AUTHENTICATION_TYPE"))
			 {
				 functionalcomponents.ClearAndSetValue(properties.getProperty("Authentication_Value"), "None");
				 functionalcomponents.WaitTillTime(2000);
				 break;
			 }
			 
			 else 
			 {
				 functionalcomponents.ClickOperation(properties.getProperty("AddNewConfigSetting_btn"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickOperation(properties.getProperty("ConfigSettingName_Dropdown1")+String.valueOf(listsize)+properties.getProperty("ConfigSettingName_Dropdown2"));
				 functionalcomponents.WaitTillTime(2000);
				 functionalcomponents.ClickOperation(properties.getProperty("Select_AuthentictypeName"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickAndSetValue(properties.getProperty("Setconfigsetting_Value1")+String.valueOf(listsize)+properties.getProperty("Setconfigsetting_Value2"), "None");
				 functionalcomponents.WaitTillTime(3000);
				 listsize=listsize+1;
				 break;
			 }
		 }
			 
		 for(int j=0; j<Name.size(); j++)
		 {
			 WebElement ele1 =Name.get(j);
			  if(ele1.getText().equalsIgnoreCase("SECURE_ONLY"))
			 {
				 functionalcomponents.ClearAndSetValue(properties.getProperty("SecureOnly_Value"), "false");
				 functionalcomponents.WaitTillTime(2000);
				 break;
			 }
			 else if(ele1.getText()!="SECURE_ONLY" & j==Name.size())
			 {
				 functionalcomponents.ClickOperation(properties.getProperty("AddNewConfigSetting_btn"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickOperation(properties.getProperty("ConfigSettingName_Dropdown1")+String.valueOf(listsize)+properties.getProperty("ConfigSettingName_Dropdown2"));
				 functionalcomponents.WaitTillTime(2000);
				 functionalcomponents.ClickOperation(properties.getProperty("Select_SecureOnlyName"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickAndSetValue(properties.getProperty("Setconfigsetting_Value1")+String.valueOf(listsize)+properties.getProperty("Setconfigsetting_Value2"), "false");
				 functionalcomponents.WaitTillTime(3000);
			 }
		 }
		 if(driver.findElement(By.xpath(properties.getProperty("HttpprotocolSave_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to Set Option Setting 1. AUTHENTICATION_TYPE from Token to None" + "2. SECURE_ONLY from true to false");
		 }
		 
		 else 
		  {
			failedDescription("user is not able to Set Option Setting 1. AUTHENTICATION_TYPE from Token to None" + "2. SECURE_ONLY from true to false");
		  }
		 test.log(Status.INFO, "Click Save Http Protocol Plugin button and verify EnterprisePlugins is created successfully");
		 functionalcomponents.ClickOperation(properties.getProperty("HttpprotocolSave_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 driver.navigate().refresh();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("Protocol_List"), "HttpProtocolPlugin");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("HttpProtocol_Name"), 20);
		 String ProtocolPluginNameValue=driver.findElement(By.xpath(properties.getProperty("HttpProtocol_Name"))).getAttribute("value");
		 if(ProtocolPluginNameValue.equalsIgnoreCase("HttpProtocolPlugin"))
		 {	
			test.log(Status.PASS, "Clicked Save HttpProtocol Plugin button and verified Http Protocol Plugins Set Successfully");
		 }
		 
		 else 
		  {
			failedDescription("Clicked Save HttpProtocol Plugin button and verified Http Protocol Plugins does not Set Successfully");
		  }
		 
		 test.log(Status.INFO, "Click on EnterprisePlugins on the workcenter at left of the screen Settings>>EnterprisePlugin");
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
		 
		 test.log(Status.INFO, "Enter a name of the Enterprise Plugin with the different possible options for the name with special characters and numbers");
		// String EnterprisePluginsName=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "EnterprisePluginName");
		 functionalcomponents.ClearAndSetValue(properties.getProperty("EnterprisePluginName"), "WebSocketPlugin1");
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginName"), 20);
		 if(driver.findElement(By.xpath(properties.getProperty("ClassDropdown_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to enter a name of the EnterprisePlugins "+": WebSocketPlugin1");
		 }
		 else 
		 {
			failedDescription("user is not able to enter a name of the EnterprisePlugins with the different possible options for the name with special characters and numbers");
		 }
		  
		 
		 test.log(Status.INFO, "Select Enterprise Plugin Class as websocket.WebSocket from dropdown list");
		 functionalcomponents.ClickOperation(properties.getProperty("ClassDropdown_btn"));
		 functionalcomponents.WaitTillTime(4000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectClassWebSocket"));
		 functionalcomponents.WaitTillTime(4000);
		 if(driver.findElement(By.xpath(properties.getProperty("EnterpriseSave_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to Select Enterprise Plugin Class as websocket.WebSocket from dropdown list");
		 }
		 else 
		 {
			failedDescription("user is not able to Select Enterprise Plugin Class as websocket.WebSocket from dropdown list");
		 }
		 
		 test.log(Status.INFO, "Enter RequiredConfig Value of the EnterprisePlugin");
		 functionalcomponents.WaitTillTime(4000);
		 functionalcomponents.scrollToExact(properties.getProperty("Required_LoggerLevel"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Required_LoggerLevel"), "INFO");
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("EnterpriseSave_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to enter RequiredConfig Value of the EnterprisePlugin");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Message of the Actions Successfully");
		 }
		 
		 test.log(Status.INFO, "Click Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name");
		 functionalcomponents.ClickOperation(properties.getProperty("EnterpriseSave_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 driver.navigate().refresh();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("EnterpriseName_List"), "WebSocketPlugin1");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EnterprisePluginName"), 20);
		 String EnterprisePluginNameValue=driver.findElement(By.xpath(properties.getProperty("EnterprisePluginName"))).getAttribute("value");
		 if(EnterprisePluginNameValue.equalsIgnoreCase("WebSocketPlugin1"))
		 {	
			test.log(Status.PASS, "Clicked Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name"+": "+EnterprisePluginNameValue);
		 }
		 
		 else 
		  {
			failedDescription("Clicked Save  Enterprise button and verified EnterprisePlugins is created successfully with EnterprisePlugins Name"+" "+EnterprisePluginNameValue);
		  }
		 return EnterprisePluginNameValue;
	}
	
	public String SetProtocolandCreateRESTPlugin1_StreamingService()
	{
		
		//Set Protocols & Create REST Enterprise Plugin
		 test.log(Status.INFO, "Click on Http Protocol Plugins on the workcenter at left of the screen Settings>>HttpProtocol Plugin");
		 functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ProtocolPlugin_link"));
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Select_httpProtocolPlugin"), 20);
		 if(driver.findElement(By.xpath(properties.getProperty("Select_httpProtocolPlugin"))).isDisplayed())
		 {	
			test.log(Status.PASS, " Screen is loaded with HttpProtocolPlugins Page");
		 }
		 else 
		 {
			failedDescription("Screen is not loaded with HttpProtocolPlugins Page");
		 } 
		 test.log(Status.INFO, "Select HttpProtocolPlugins on the screen");
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Select_httpProtocolPlugin"));
		 if(driver.findElement(By.xpath(properties.getProperty("HttpprotocolSave_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, " Screen is loaded with option add Protocol Plugin Information");
		 }
		 else 
		 {
			failedDescription("Screen is not loaded with option add Protocol Plugin Information");
		 }
		 
		 test.log(Status.INFO, "Set Option Setting 1. AUTHENTICATION_TYPE from Token to None" + "2. SECURE_ONLY from true to false");
		 List<WebElement> Name=new ArrayList<WebElement>();
		 Name.addAll(driver.findElements(By.xpath(properties.getProperty("OptionalSettingName_List"))));
		 int listsize=Name.size();
		 for(WebElement ele: Name)
		 {
			 
			 if(ele.getText().equalsIgnoreCase("AUTHENTICATION_TYPE"))
			 {
				 functionalcomponents.ClearAndSetValue(properties.getProperty("Authentication_Value"), "None");
				 functionalcomponents.WaitTillTime(2000);
				 break;
			 }
			 
			 else 
			 {
				 functionalcomponents.ClickOperation(properties.getProperty("AddNewConfigSetting_btn"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickOperation(properties.getProperty("ConfigSettingName_Dropdown1")+String.valueOf(listsize)+properties.getProperty("ConfigSettingName_Dropdown2"));
				 functionalcomponents.WaitTillTime(2000);
				 functionalcomponents.ClickOperation(properties.getProperty("Select_AuthentictypeName"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickAndSetValue(properties.getProperty("Setconfigsetting_Value1")+String.valueOf(listsize)+properties.getProperty("Setconfigsetting_Value2"), "None");
				 functionalcomponents.WaitTillTime(3000);
				 listsize=listsize+1;
				 break;
			 }
		 }
			 
		 for(int j=0; j<Name.size(); j++)
		 {
			 WebElement ele1 =Name.get(j);
			  if(ele1.getText().equalsIgnoreCase("SECURE_ONLY"))
			 {
				 functionalcomponents.ClearAndSetValue(properties.getProperty("SecureOnly_Value"), "false");
				 functionalcomponents.WaitTillTime(2000);
				 break;
			 }
			 else if(ele1.getText()!="SECURE_ONLY" & j==Name.size())
			 {
				 functionalcomponents.ClickOperation(properties.getProperty("AddNewConfigSetting_btn"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickOperation(properties.getProperty("ConfigSettingName_Dropdown1")+String.valueOf(listsize)+properties.getProperty("ConfigSettingName_Dropdown2"));
				 functionalcomponents.WaitTillTime(2000);
				 functionalcomponents.ClickOperation(properties.getProperty("Select_SecureOnlyName"));
				 functionalcomponents.WaitTillTime(3000);
				 functionalcomponents.ClickAndSetValue(properties.getProperty("Setconfigsetting_Value1")+String.valueOf(listsize)+properties.getProperty("Setconfigsetting_Value2"), "false");
				 functionalcomponents.WaitTillTime(3000);
			 }
		 }
		 
		 if(driver.findElement(By.xpath(properties.getProperty("HttpprotocolSave_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to Set Option Setting 1. AUTHENTICATION_TYPE from Token to None" + "2. SECURE_ONLY from true to false");
		 }
		 
		 else 
		  {
			failedDescription("user is not able to Set Option Setting 1. AUTHENTICATION_TYPE from Token to None" + "2. SECURE_ONLY from true to false");
		  }
		 
		 test.log(Status.INFO, "Click Save Http Protocol Plugin button and verify EnterprisePlugins is created successfully");
		 functionalcomponents.ClickOperation(properties.getProperty("HttpprotocolSave_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 driver.navigate().refresh();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("Protocol_List"), "HttpProtocolPlugin");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("HttpProtocol_Name"), 20);
		 String ProtocolPluginNameValue=driver.findElement(By.xpath(properties.getProperty("HttpProtocol_Name"))).getAttribute("value");
		 if(ProtocolPluginNameValue.equalsIgnoreCase("HttpProtocolPlugin"))
		 {	
			test.log(Status.PASS, "Clicked Save HttpProtocol Plugin button and verified Http Protocol Plugins Set Successfully");
		 }
		 
		 else 
		  {
			failedDescription("Clicked Save HttpProtocol Plugin button and verified Http Protocol Plugins does not Set Successfully");
		  }
		 
		 test.log(Status.INFO, "Click on EnterprisePlugins on the workcenter at left of the screen Settings>>EnterprisePlugin");
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
		 
		 test.log(Status.INFO, "Enter a name of the Enterprise Plugin with the different possible options for the name with special characters and numbers");
		// String EnterprisePluginsName=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "EnterprisePluginName");
		 functionalcomponents.ClearAndSetValue(properties.getProperty("EnterprisePluginName"), "RESTPlugin1");
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginName"), 20);
		 if(driver.findElement(By.xpath(properties.getProperty("ClassDropdown_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to enter a name of the EnterprisePlugins "+": RESTPlugin1");
		 }
		 else 
		 {
			failedDescription("user is not able to enter a name of the EnterprisePlugins with the different possible options for the name with special characters and numbers");
		 }
		  
		 
		 test.log(Status.INFO, "Select Enterprise Plugin Class as websocket.WebSocket from dropdown list");
		 functionalcomponents.ClickOperation(properties.getProperty("ClassDropdown_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectClassWebSocket"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("EnterpriseSave_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to Select Enterprise Plugin Class as websocket.WebSocket from dropdown list");
		 }
		 else 
		 {
			failedDescription("user is not able to Select Enterprise Plugin Class as websocket.WebSocket from dropdown list");
		 }
		 
		 test.log(Status.INFO, "Enter RequiredConfig Value of the EnterprisePlugin");
		 functionalcomponents.scrollToExact(properties.getProperty("Required_LoggerLevel"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Required_LoggerLevel"), "INFO");
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("EnterpriseSave_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to enter RequiredConfig Value of the EnterprisePlugin");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Message of the Actions Successfully");
		 }
		 
		 test.log(Status.INFO, "Click Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name");
		 functionalcomponents.ClickOperation(properties.getProperty("EnterpriseSave_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 driver.navigate().refresh();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("EnterpriseName_List"), "RESTPlugin1");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EnterprisePluginName"), 20);
		 String EnterprisePluginNameValue=driver.findElement(By.xpath(properties.getProperty("EnterprisePluginName"))).getAttribute("value");
		 if(EnterprisePluginNameValue.equalsIgnoreCase("RESTPlugin1"))
		 {	
			test.log(Status.PASS, "Clicked Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name"+": "+EnterprisePluginNameValue);
		 }
		 
		 else 
		  {
			failedDescription("Clicked Save  Enterprise button and verified EnterprisePlugins is created successfully with EnterprisePlugins Name"+" "+EnterprisePluginNameValue);
		  }	
		 
		 return EnterprisePluginNameValue;
	}

	
public void CreateSensorProfile(String SensorProfileName, String ProductionParameters_Min, String ProductionParameters_Max, String windowParameters_Min, String windowsize_averaging)
{
	
	 test.log(Status.INFO, "Click on Sensor profile on the workcenter at left of the screen and Create a new sensor profile by clicking on the + symbol at the bottom of the screen");
	 functionalcomponents.ClickOperation(properties.getProperty("Add_Symbol_btn"));
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofile_Name"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Sensor Profile page is displaying successfully");
	 }
	 else 
	 {
		failedDescription(" Sensor Profile  page is not displaying successfully");
	 }
	 
	 test.log(Status.INFO, "Enter sensor profile name with special characters ");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Sensorprofile_Name"), SensorProfileName);
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).isDisplayed())
	 {	
		test.log(Status.PASS, "sensor profile name as"+":"+SensorProfileName+" "+" is saved successfully with special characters");
	 }
	 else 
	 {
		failedDescription(" sensor profile name is not saved successfully with special characters");
	 }
	 
	 test.log(Status.INFO, "Enter numeric values for the Testing & Production Parameters with the maximum and minimum values");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ProductionParameters_Minimum"), ProductionParameters_Min);

	 functionalcomponents.ClickAndSetValue(properties.getProperty("ProductionParameters_Maximum"), ProductionParameters_Max);
	 
	 if(Integer.parseInt(ProductionParameters_Max)<2147483647)
	 {	
		test.log(Status.PASS, "Numeric values for the Testing & Production Parameters with the minimum and maximum values are:"+ProductionParameters_Min+","+ProductionParameters_Max+"  saved and verified Maximum value is not exceed 2147483647.");
	 }
	 else 
	 {
		failedDescription("Numeric values for the Testing & Production Parameters for the minimum and maximum values are:"+ProductionParameters_Min+","+ProductionParameters_Max+"  saved and verified Maximum value is not exceed 2147483647.");
	 }
	 
	 test.log(Status.INFO, "Check Enter value is changing to the toggling options between seconds, minutes and hours");
	 functionalcomponents.ClickOperation(properties.getProperty("Minute_toggle"));
	 functionalcomponents.WaitTillTime(3000);	
	 
	 functionalcomponents.ClickOperation(properties.getProperty("Hour_toggle"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickOperation(properties.getProperty("Second_toggle"));
		 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("WindowParameters_Minimum"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Entered value is changing to the toggling options of seconds, minutes and hours properly");
	 }
	 else 
	 {
		failedDescription("Entered value is changing to the toggling options of seconds, minutes and hours properly");
	 }
	 
	 test.log(Status.INFO, "Enter numeric values for the Window Parameters for the minimum and window size averaging values");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("WindowParameters_Minimum"), windowParameters_Min);
	 int windowsizevalue=functionalcomponents.convertHourtoSecond(Integer.parseInt(windowsize_averaging));
	 functionalcomponents.ClickAndSetValue(properties.getProperty("WindowSize_Averaging"), windowsize_averaging);
	 functionalcomponents.WaitTillTime(2000);
	 if(Integer.parseInt(windowsize_averaging)<2147483647)
	 {	
		test.log(Status.PASS, "Numeric values for the Window Parameters for the minimum:"+windowParameters_Min+" "+" and window size averaging value:"+windowsizevalue+" "+" are saved and verified window size averaging values is not exceed 2147483647 ");
	 }
	 else 
	 {
		failedDescription("Enter numeric values for the Window Parameters for the minimum and window size averaging values and verified window size averaging values is exceed 2147483647");
	 }
	 
	
	 	
	 test.log(Status.INFO, "Click Save sensor Profile button and verify sensor profile is created successfully with Profile Name");
	 functionalcomponents.ClickOperation(properties.getProperty("SensorProfile_Save_btn"));
	 functionalcomponents.WaitTillTime(3000);
	 driver.navigate().refresh();
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Sensorprofile_Name"), 20);
	 String SensorProfile_Name=driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).getAttribute("value");
	// String SensorProfileID=driver.findElement(By.xpath(properties.getProperty("SensorProfileIDText"))).getText();
	 if(SensorProfileName.equalsIgnoreCase(SensorProfile_Name))
	 {	
		test.log(Status.PASS, "Click Save sensor Profile button and verified sensor profile is created successfully with Profile Name"+" :"+SensorProfile_Name);
	 }
	 else 
	 {
		failedDescription("Click Save sensor Profile button and sensor profile is not created successfully with Profile Name"+":"+SensorProfile_Name);
	 }	
	
}
	
	
	
	
	
	
public void CreateAction(String ActionName, String ActionDescription, String Actiontypevalue, String Actionmessage, String Actionparameter) {
	
	 test.log(Status.INFO, "Click on Actions on the workcenter at left of the screen Configuration>>Actions");
	 functionalcomponents.ClickOperation(properties.getProperty("Action_link"));
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("ActionNewAdd_btn"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionNewAdd_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, " Screen is loaded with option to add Actions");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with option to add Actions");
	 }
	 
	 test.log(Status.INFO, "Click a new action by + symbol at the bottom of the screen");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionNewAdd_btn"));
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("ActionName"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		test.log(Status.PASS, " Actions Name screen is opening successfully.");
	 }
	 else 
	 {
		failedDescription("Actions Name screen is not opening successfully");
	 }
	 
	 test.log(Status.INFO, "Enter a name of the Actions with the different possible options for the name with special characters and numbers");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionName"), ActionName);
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("ActionName"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter a name of the Actions "+": "+ActionName);
	 }
	 else 
	 {
		failedDescription("user is not able to enter a name of the Actions with the different possible options for the name with special characters and numbers");
	 }
	 
	 test.log(Status.INFO, "Enter Description of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionDescription"), ActionDescription);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Description of the Actions Successfully "+"as:"+ActionDescription);
	 }
	 else 
	 {
		failedDescription("user is not able to enter Description of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionType_Dropdown"));
	 functionalcomponents.WaitTillTime(3000);
	 if(Actiontypevalue.equalsIgnoreCase("Field Message"))
	 {
	 functionalcomponents.ClickOperation(properties.getProperty("ActionTypePart1")+Actiontypevalue+properties.getProperty("ActionTypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ActionPluginID_Dropdown"));
	 functionalcomponents.WaitTillTime(1000);
	 functionalcomponents.ClickOperation(properties.getProperty("ActionPluginID_HttpProtocol"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Message"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "User is able to Select Actiontype as"+": "+Actiontypevalue+" "+"& ActionPlugin as httpprotocol plugin from dropdown button");
	 }
	 else 
	 {
		failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 }
	 
	 test.log(Status.INFO, "Enter Message of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Message"), Actionmessage);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Parameters"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Message of the Actions as:"+Actionmessage+" "+" Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Enter Parameters of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Parameters"), Actionparameter);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionSave_btn"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Parameters of the Actions as:"+Actionparameter+" "+" Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 }
	 
	 test.log(Status.INFO, "Click Save Action button and verify Action is created successfully with Action Name");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionSave_btn"));
	 functionalcomponents.WaitTillTime(2000);
	 driver.navigate().refresh();
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("ActionsName_List"), ActionName);
    
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ActionName"), 20);
	 String ActionNameValue=driver.findElement(By.xpath(properties.getProperty("ActionName"))).getAttribute("value");
	 if(ActionNameValue.equalsIgnoreCase(ActionName))
	 {	
		test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name"+": "+ActionNameValue);
	 }
	 else 
	 {
		failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue);
	 }
}

public void DeleteSensorProfile(String Sensorprofilename) {
	
	 test.log(Status.INFO, "Click on Sensor profile on the workcenter at left of the screen and select profile for deleting");
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), Sensorprofilename);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SensorProfileDelete_Btn"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickOperation(properties.getProperty("DeleteOK_Btn"));
	 functionalcomponents.WaitTillTime(3000);
	 
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to delete Sensor Profile Name as:"+Sensorprofilename+" "+" successfully");
	 }
	 else 
	 {
		failedDescription("user is not able to delete Sensor Profile");
	 }
}

public void DeleteAction(String actionname) {
	
	test.log(Status.INFO, "Click on Action on the workcenter at left of the screen and select Action Name for deleting");
	driver.navigate().refresh();
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_link"), 70);
	 functionalcomponents.ClickOperation(properties.getProperty("Action_link"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("ActionsName_List"), actionname);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ActionDelete_Btn"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickOperation(properties.getProperty("DeleteOK_Btn"));
	 functionalcomponents.WaitTillTime(3000);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionNewAdd_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to delete Action Name as:"+actionname+" "+"successfully");
	 }
	 else 
	 {
		failedDescription("user is not able to delete Action");
	 }
	
}

public void DeleteRuleFromSensorProfile(String Sensorprofilename, String RuleName) {
	 test.log(Status.INFO, "Click on Sensor profile on the workcenter at left of the screen and select Rule for deleting");
	 functionalcomponents.WaitTillTime(5000);
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), Sensorprofilename);
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.scrollToExact(properties.getProperty("RuleDelete_Btn"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.JScriptExecutorClick(properties.getProperty("RuleDelete_Btn"));
	// functionalcomponents.ClickOperation(properties.getProperty("RuleDelete_Btn"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.ClickOperation(properties.getProperty("DeleteOK_Btn"));
	 functionalcomponents.WaitTillTime(4000); 
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to delete Rule Name as:"+RuleName+" "+" successfully");
	 }
	 else 
	 {
		failedDescription("user is not able to delete Rule");
	 }

}






public String GetDatafromDataBase(String DB_USER, String DB_PASSWORD,String query) {
	
	
	// Connection object
	
			Connection conn = null;
			
			// Statement object
			
			Statement stmt=null;
			     
		   // Constant for Database URL
			
			String DB_URL = "jdbc:sqlanywhere:";   
			
			StringBuilder sb = new StringBuilder();
			
			// sql anywhere data base connection
					
			try{
		   // Make the database connection
		   // String dbClass = "sap.jdbc4.sqlanywhere.IDriver";
		   // Class.forName(dbClass).newInstance();
		  // Get connection to DB
		     conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		       System.out.println("DB Connected");
		   // Statement object to send the SQL statement to the Database
		       stmt = conn.createStatement();
						
		// String query = "SELECT ACTION_ID,ACTION_NAME,DESCRIPTION,ACTION_TYPE_ID from ACTION"+" WHERE ACTION_NAME = '303'; ";
						
		  // Get the contents of action table from DB
						
			   ResultSet res = stmt.executeQuery(query);
			   
			   
			   ResultSetMetaData rsmd = res.getMetaData();

			   int columnsNumber = rsmd.getColumnCount();
			   System.out.println(res.toString());
				     
		  // Print the result untill all the records are printed
		  // res.next() returns true if there is any next record else returns false
				while(res.next())	{	
			   for(int i = 1; i <= columnsNumber; i++)
			   {
			       
			      
			       
			       sb.append(rsmd.getColumnName(i)+":"+res.getString(i)+", ");
			       
			       
			   
				 		
			   }
				}
				 

					
		// DB Connection close			

			res.close();
		    stmt.close();
		    conn.close();
		 } 
			catch (SQLException se) {
				 se.printStackTrace();
			}
			catch (Exception e) {
			  e.printStackTrace();
			}
			finally
			{
			    try {
				 if (stmt != null)
				     stmt.close();
				     } catch (SQLException se2) {
				        }// nothing we can do
				        try {
				            if (conn != null)
				                conn.close();
				        } catch (SQLException se) {
				            se.printStackTrace();
				        }
			 }
			
			
		  return sb.toString();
				

}
	
}
