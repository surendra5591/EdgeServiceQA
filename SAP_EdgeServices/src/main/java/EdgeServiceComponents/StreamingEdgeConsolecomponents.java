package EdgeServiceComponents;

import java.util.Properties;


import org.openqa.selenium.By;
import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import UtilityComponent.FunctionalComponents;

public class StreamingEdgeConsolecomponents extends BaseTest {
	
	   FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	   Properties properties = FunctionalComponents.getObjectProperties();
	   String Basic_AUTH_Password_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Basic_AUTH_Password_input");
	    String AUTH_TYPE_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "AUTH_TYPE_input");
	    String Rest_URI_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "URI_input");
		String BASIC_AUTH_USERNAME_input=functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "BASIC_AUTH_USERNAME_input");
		
	
	public  String CreateWebSocketoutboundConnector_StreamingService()
	{
		
		 test.log(Status.INFO, "Click on OutboundConnector on the workcenter at left of the screen Settings");
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("OutboundConnectors_link"));
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("OutboundConnectorsNewAdd_btn"), 200);
		 if(driver.findElement(By.xpath(properties.getProperty("OutboundConnectorsNewAdd_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, " Screen is loaded with outbound conectors Page");
		 }
		 else 
		 {
			failedDescription("Screen is not loaded with Enterprise Plugins Page");
		 }
		 test.log(Status.INFO, "Click on add + Symbol to create New outbound connector");
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
		 functionalcomponents.ClearAndSetValue(properties.getProperty("EnterprisePluginName"), "WebSocket Outbound Connector");
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePluginName"), 20);
		 if(driver.findElement(By.xpath(properties.getProperty("ClassDropdown_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to enter a name of the outbound connectors as: ");
		 }
		 else 
		 {
			failedDescription("user is not able to enter a name of the EnterprisePlugins with the different possible options for the name with special characters and numbers");
		 }
		 test.log(Status.INFO, "Select Enterprise Plugin Class as REST plugin from dropdown list");
		 functionalcomponents.ClickOperation(properties.getProperty("ClassDropdown_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("WebSocket_OutboundConnector"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Description_plugin"), "WebSocket OutboundConnectors");
		 functionalcomponents.WaitTillTime(2000);
		 
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Restoutbound_URI"), "http://localhost:9001/user" );
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
		 
		 test.log(Status.INFO, "Click Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name");
		 functionalcomponents.ClickOperation(properties.getProperty("EnterpriseSave_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 driver.navigate().refresh();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("EnterpriseName_List"), "WebSocket Outbound Connector");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EnterprisePluginName"), 20);
		 String EnterprisePluginNameValue=driver.findElement(By.xpath(properties.getProperty("EnterprisePluginName"))).getAttribute("value");
		 if(EnterprisePluginNameValue.equalsIgnoreCase("WebSocket Outbound Connector"))
		 {	
			test.log(Status.PASS, "Clicked Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name"+": "+EnterprisePluginNameValue);
		 }
		 
		 else 
		  {
			failedDescription("Clicked Save  Enterprise button and verified EnterprisePlugins is created successfully with EnterprisePlugins Name"+" "+EnterprisePluginNameValue);
		  }
		 return EnterprisePluginNameValue;
	}
	
	
	public String CreateRESTOutboundConnector_StreamingService()
	{
		
		//Set Protocols & Create REST Enterprise Plugin
		 test.log(Status.INFO, "Click on EnterprisePlugins on the workcenter at left of the screen Settings>>EnterprisePlugin");
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
		 functionalcomponents.ClearAndSetValue(properties.getProperty("EnterprisePluginName"), "REST Outbound Connector");
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
		 test.log(Status.INFO, "Click Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name");
		 functionalcomponents.ClickOperation(properties.getProperty("EnterpriseSave_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 driver.navigate().refresh();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("EnterpriseName_List"), "REST Outbound Connector");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EnterprisePluginName"), 20);
		 String EnterprisePluginNameValue=driver.findElement(By.xpath(properties.getProperty("EnterprisePluginName"))).getAttribute("value");
		 if(EnterprisePluginNameValue.equalsIgnoreCase("REST Outbound Connector"))
		 {	
			test.log(Status.PASS, "Clicked Save Enterprise Plugin button and verify EnterprisePlugins is created successfully with EnterprisePlugin Name"+": "+EnterprisePluginNameValue);
		 }
		 
		 else 
		  {
			failedDescription("Clicked Save  Enterprise button and verified EnterprisePlugins is created successfully with EnterprisePlugins Name"+" "+EnterprisePluginNameValue);
		  }	
		 
		 return EnterprisePluginNameValue;
	}

	
public void CreateSensorProfile(String SensorProfileName, String ProductionParameters_Min, String ProductionParameters_Max)
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
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("ActionNewAdd_btn"), 200);
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
	// driver.navigate().refresh();
	// functionalcomponents.WaitTillTime(5000);
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
	 FunctionalComponents.JScriptExecutorClick(properties.getProperty("RuleDelete_Btn"));
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

}
