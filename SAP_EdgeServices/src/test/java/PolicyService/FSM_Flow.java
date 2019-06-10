package PolicyService;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class FSM_Flow extends BaseTest {
	Properties properties = functionalcomponents.getObjectProperties();
	@Test
	public void FSM_TestCase_flow() {
		
		String URL = functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "URL"); 
		String username = functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "username");
		String password = functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "password");
		String gatewayno=functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "Gatewayno");		
		String configName=functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "Name_config");	
		String BEFconfigName=functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "Name_config2");
		String streamingusername = functionalcomponents.getdatafromsheet("StreamingService", "FSM_TestCase_flow", "UserName");
		String streamingpassword = functionalcomponents.getdatafromsheet("StreamingService", "FSM_TestCase_flow", "Password");
	
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
		String PortNumber=functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "PortNumber");
		String RuntimesettingPWD=functionalcomponents.getdatafromsheet("Policyservice", "FSM_TestCase_flow", "Runtimeseeting_PWD");

		
		
		//Prerequisite- Start the Policyservice  ( Cloud version )
		 driver.get(URL);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policyservice_name"), 70);
		 functionalcomponents.WaitTillTime(2000);
		test.log(Status.INFO, "Login successfully into the policyservice and click on the  GatewayManagement");
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 70);
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 70);
		functionalcomponents.WaitTillTime(7000);
		if (driver.findElement(By.xpath(properties.getProperty("Search_Gateway"))).isDisplayed()) {
			test.log(Status.PASS, "Gateway manaagement window is opened successfully");
		} else {
			failedDescription("gatewaymanagement is not opened");
		}
		
		//search for the particular gateway
		test.log(Status.INFO, "Search for the particular gateway and add the configuration");				
		functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),gatewayno);
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
	//Creating Streaming configuration to the gateway
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
	  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+configName+ properties.getProperty("config_value_part2")));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);
	  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
	  {
			 test.log(Status.PASS, "user is able to select Streaming service "+configName+"as configuration successfully");
	  }
	  else
		{
			 failedDescription("user is not able to select Streaming service "+configName+"as configuration successfully");
		}
	  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90);
	  functionalcomponents.WaitTillTime(15000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("config_Searchtext"), configName);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90); 
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(30000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 90);
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
	  functionalcomponents.WaitTillTime(40000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
	  for(int i=0; i<=20; i++) {
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
		  functionalcomponents.WaitTillTime(15000);
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+configName+properties.getProperty("Activated_msgpart2")));
		  if(ele1.getText().equalsIgnoreCase("Activated"))
			{
			  break;
		  }
	  }
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
	
		
		// add BEF config to gateway
		
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
		  functionalcomponents.ClickOperation(properties.getProperty("EssentialBusinessService"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		  functionalcomponents.WaitTillTime(5000);
		 // String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+BEFconfigName+properties.getProperty("config_value_part2")));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
		  functionalcomponents.WaitTillTime(15000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90); 
		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
		  {
				 test.log(Status.PASS, "user is able to select Streaming service "+BEFconfigName+"as configuration successfully");
		  }
		  else
			{
				 failedDescription("user is not able to select Streaming service "+BEFconfigName+"as configuration successfully");
			}
		 
		  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_Searchtext"), 90);
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("config_Searchtext"), BEFconfigName);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("congig_searchbutton"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90); 
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
		  functionalcomponents.WaitTillTime(20000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
		  for(int i=0; i<=20; i++) {
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(15000);
			  WebElement ele2=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+BEFconfigName+properties.getProperty("Activated_msgpart2")));
			  if(ele2.getText().equalsIgnoreCase("Activated"))
				{
				  break;
			  }
		  } 
		  WebElement ele2=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+BEFconfigName+properties.getProperty("Activated_msgpart2")));
		  String text2= ele2.getText();   
			if(text2.equalsIgnoreCase("Activated"))
			{
				 test.log(Status.PASS, "configuration activated successfully");
			}
			else
			{
				 failedDescription("configuration is not activated");
			}	
		
			
		 //Prerequisite- Start the StreamingService Gateway service ( Could version )
		 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
		 driver.get(properties.getProperty("StreamingService_URL"));
		 functionalcomponents.WaitTillTime(3000);
		 String pagetitle2=driver.getTitle();
		// System.out.println(pagetitle2);
		 functionalcomponents.WaitTillTime(2000);
		 if(pagetitle2.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
		 {	
			test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle2);
		 }
		 else 
		 {
			failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
		 }
		 
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), streamingusername);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), streamingpassword);
		 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
		 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofilerule_Link"), 20);
		 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Version"))).getText();
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, "Streaming Service Screen is loaded with "+Versionvalue+" "+" and with option to add sensor profile");
		 }
		 else 
		 {
			failedDescription("Screen is not loaded with option to add sensor profile");
		 }		
	
		 test.log(Status.INFO, "Click on Sensor profile on the workcenter at left of the screen and select Sensor profile");
		 functionalcomponents.ClickOperation(properties.getProperty("SelectSensorProfile"));
		 functionalcomponents.WaitTillTime(2000);
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
		 
		 //setting enterpsise plugin
		 
		 test.log(Status.INFO, "Set Runtime Setting");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Settings_link"), 90);
		 functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("RuntimeSettinglink"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.scrollToExact(properties.getProperty("RuntimeHostName"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("RuntimeHostName"), "https://localhost");
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("RuntimePortNumber"), PortNumber);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("RuntimeAuthenticationPWD"), RuntimesettingPWD);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("RuntimeConfigSaveBtn"));
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("EnterprisePlugin_link"), 70);
		//Set Enterprise Setting
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
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_AUTHENTICATION_input"), FIDELITY_AUTHENTICATION_input);
		//2
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"1"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.scrollToExact(properties.getProperty("FIDELITY_AUTH_TYPE"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("FIDELITY_AUTH_TYPE"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_AUTH_TYPE_input"), FIDELITY_AUTH_TYPE_input);
		 //3
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"2"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("FIDELITY_URI"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_URI_input"), FIDELITY_URI_input);
		 //4
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"3"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("FIDELITY_USERNAME"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("FIDELITY_USERNAME_input"), FIDELITY_USERNAME_input);
		 //5
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"4"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_AUTH_TYPE"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ENTERPRISE_EVENT_AUTH_TYPE_input"), ENTERPRISE_EVENT_AUTH_TYPE_input);
		 //6
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"5"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_AUTHENTICATION"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ENTERPRISE_EVENT_AUTHENTICATION_input"), ENTERPRISE_EVENT_AUTHENTICATION_input);
		 //7
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"6"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_URI"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ENTERPRISE_EVENT_URI_input"), ENTERPRISE_EVENT_URI_input);
		 //8
		 functionalcomponents.ClickOperation(properties.getProperty("Add_optionslsettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation((properties.getProperty("optionalsettings_dropdown_part1")+"7"+properties.getProperty("optionalsettings_dropdown_part2")));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ENTERPRISE_EVENT_USERNAME"));
		 functionalcomponents.WaitTillTime(2000);
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
		 functionalcomponents.WaitTillTime(5000);
		 
	// Action Creation
		 
		    String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "FSM_TestCase_flow", "ActionName");
			String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "FSM_TestCase_flow", "ActionType");
			String actionsubject=functionalcomponents.getdatafromsheet("StreamingService", "FSM_TestCase_flow", "Subject");
		 
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
		 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionDescription"), "Action to  create Service call");
		 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to enter Description of the Actions Successfully "+"as:"+"Action to  create Service call");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Description of the Actions Successfully");
		 }
		 
		 test.log(Status.INFO, "Select Actiontype as Create Service Call ");
		 functionalcomponents.ClickOperation(properties.getProperty("ActionType_Dropdown"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickOperation(properties.getProperty("ActionTypePart1")+Actiontypevalue+properties.getProperty("ActionTypePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.scrollToExact(properties.getProperty("ActionType_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ActionSubject"), actionsubject);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("ActionPrioritylevel"), "${PRIORITY_HIGH}");
		 functionalcomponents.WaitTillTime(3000);
		 if(driver.findElement(By.xpath(properties.getProperty("ActionSave_btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "User is able to Select Actiontype as"+": "+Actiontypevalue);
		 }
		 else 
		 {
			failedDescription("user is not able to select Actiontype");
		 }
		 test.log(Status.INFO, "Click Save Action button and verify Action is created successfully with Action Name");
		 functionalcomponents.ClickOperation(properties.getProperty("ActionSave_btn"));
		 functionalcomponents.WaitTillTime(2000);
		 driver.navigate().refresh();
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
	   
		 test.log(Status.INFO, "Select Rule and add action and verify Action is add successfully with Action Name");
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectSensorProfile"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.scrollToExact(properties.getProperty("SelectRule"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectRule"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("DeselectActionintoRule"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 test.log(Status.INFO, "Click Save Rule button and Rule is saved successfully for Sensore Profile");
		 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
		 functionalcomponents.WaitTillTime(3000);
		 if(driver.findElement(By.xpath(properties.getProperty("Monitoring_Link"))).isDisplayed())
		 {	
		 	test.log(Status.PASS, "User is able to Action is added successfully with Action Name:"+ActionName);
		 }
		 else 
		 {
		 	failedDescription("User is not able to Action is added successfully with Action Name");
		 }
		 test.log(Status.INFO, "Click on Monitoring, Live Sensor on the workcenter at left of the screen");
		 functionalcomponents.ClickOperation(properties.getProperty("Monitoring_Link"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("LiveSensor"));
		 if(driver.findElement(By.xpath(properties.getProperty("LiveSensor"))).isDisplayed())
		 {	
		 	test.log(Status.PASS, "Live Sensor Screen is loaded Successfully");
		 }
		 else 
		 {
		 	failedDescription("Screen is not loaded with option to add sensor profile");
		 }
		 test.log(Status.INFO, "Go to settings and select Latitude device for sensor profile reading");
		 functionalcomponents.ClickOperation(properties.getProperty("SensorReadingSettings"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectAllCheckbox"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("DeviceLatitude"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("CloseReading"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SensorEmulatorControl"));
		 functionalcomponents.WaitTillTime(3000);
		 	 
		/*
		 * functionalcomponents.scrollToExact(properties.getProperty("Livesensor"));
		 * functionalcomponents.WaitTillTime(3000); WebElement Element
		 * =driver.findElement(By.xpath(properties.getProperty("SensorEmulatorControl"))
		 * ); functionalcomponents.WaitTillTime(2000); //
		 * functionalcomponents.setAttributeValue(Element, attribute, "80");
		 */		 
		
		 
	
	
	}

}
