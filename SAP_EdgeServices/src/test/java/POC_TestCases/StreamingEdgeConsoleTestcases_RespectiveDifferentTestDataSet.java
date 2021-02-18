package POC_TestCases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import EdgeServiceComponents.StreamingEdgeConsolecomponents;
import UtilityComponent.FunctionalComponents;

public class StreamingEdgeConsoleTestcases_RespectiveDifferentTestDataSet extends StreamingEdgeConsolecomponents {
	
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
    Properties properties = FunctionalComponents.getObjectProperties();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
    
    //Prerequisites 1. Streaming Configuration should be applied to gateway then user will get access to edge console local host env. 
    // 2. Streaming user name and password (edge console password ) should be updated in global test data sheet.
    
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
	String EnterprisePluginName="";  
    
    
 @Test
 public void TC01_Custom_Over100()
 {
	 
	 String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
	 String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");	
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(3000);
	 String pagetitle=driver.getTitle();
	 System.out.println(pagetitle);
	 functionalcomponents.WaitTillTime(2000);
	 if(pagetitle.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
	 {	
		test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
	 }
	 else 
	 {
		failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
	 }
	 
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), username);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), password);
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofilerule_Link"), 20);
	 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Version"))).getText();
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Streaming Service Screen is loaded with "+Versionvalue+" "+" and with option to add sensor profile");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with option to add sensor profile");
	 }
	 
	//Creating Sensor Profile
	 
			String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "SensorProfileName");
			String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "ProductionParameters_Min");
			String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "ProductionParameters_Max");
			
	    	CreateSensorProfile(SensorProfileName, ProductionParameters_Min, ProductionParameters_Max);
			//System.out.println(SensorProfileID);
	
           //Action Creation
			
			String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "ActionName");
			String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "ActionType");

			CreateAction(ActionName, ActionName, Actiontypevalue, ActionName,  ActionName);			
			
			
           //Set Protocols & Create Enterprise Plugin
			 functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
			 functionalcomponents.WaitTillTime(2000);
			 EnterprisePluginName = CreateWebSocketoutboundConnector_StreamingService();	
			 System.out.println(EnterprisePluginName);
			
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
	// String sensorprofileid=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
	 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
	 {	
		test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" +" i) Sensor Profile Name "+": "+SensorProfileName);
	 }
	 else 
	 {
		failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
	 }
	 test.log(Status.INFO, "Enter Rule name  & Rule Description to add the Rules for the sensor profile.");

	 String RuleName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "RuleName");

	 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), RuleName);
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
	if(!functionalcomponents.IsElementDisplayed(properties.getProperty("EventsTab_link"))) {
		functionalcomponents.ClickOperation(properties.getProperty("Monitoring_Link"));
		functionalcomponents.WaitTillTime(3000);
    	functionalcomponents.ClickOperation(properties.getProperty("EventsTab_link"));
   }	
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
	if(!functionalcomponents.IsElementDisplayed(properties.getProperty("LogsTab_link"))) {
		functionalcomponents.ClickOperation(properties.getProperty("Monitoring_Link"));
		functionalcomponents.WaitTillTime(3000);
    	functionalcomponents.ClickOperation(properties.getProperty("LogsTab_link"));
    }	
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
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("Tokens_AddButton")))    					
	{	
		test.log(Status.PASS, "Streaming Service Screen is loaded with Tokens screen inside Security Tab");
	}
	else 
	{
		failedDescription("Screen is not loaded with Tokens screen inside Security Tab");
	}	
	
	//Creating new token
	test.log(Status.INFO, "Creating new token inside Tokens");
	functionalcomponents.ClickOperation(properties.getProperty("Tokens_AddButton"));
	functionalcomponents.WaitTillTime(5000);
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("Tokens_AddNewTokenText")))   
	{	
		test.log(Status.PASS, "Create new token page is loaded");
	}
	else 
	{
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
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("TokenCreated_Validation")))    					
	{	
		test.log(Status.PASS, "User is able to create a new token");
	}
	else 
	{
		failedDescription("User is not able to create a new token");
	}	
	
	//Deleting the created token  
	test.log(Status.INFO, "Deleting the toekn created");	
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClickOperation(properties.getProperty("TokenCreated_Validation"));
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClickOperation(properties.getProperty("TokenDeleteButton"));
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClickOperation(properties.getProperty("OkButton"));
	functionalcomponents.WaitTillTime(3000);
	if(!functionalcomponents.IsElementDisplayed(properties.getProperty("TokenCreated_Validation")))    					
	{	
		test.log(Status.PASS, "User is able to delete token");
	}
	else 
	{
		failedDescription("User is not able to delete token");
	}	
	
	
	//Validating if Security Tab is opening and Passwords visible inside it.
	test.log(Status.INFO, "Click on Security on the workcenter at left of the screen and open Passwords");								
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClickOperation(properties.getProperty("PasswordsTab_link"));
	functionalcomponents.WaitTillTime(5000);	
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("Passwords_AdminPassSettings_HeaderText")))    					
	{	
		test.log(Status.PASS, "Streaming Service Screen is loaded with Passwords screen inside Security Tab");
	}
	else 
	{
		failedDescription("Screen is not loaded with Passwords screen inside Security Tab");
	}	

	//Changing password
	test.log(Status.INFO, "Changing password");		
	functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_OldPassField"));
	functionalcomponents.WaitTillTime(3000);
	String edgeConsolePassword= functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");
	String newEdgeConsolePassword = "Test12345678";
	functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_OldPassField"),edgeConsolePassword);
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_NewPassField"));
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_NewPassField"),newEdgeConsolePassword);
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_ConfirmPassField"));
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_ConfirmPassField"),newEdgeConsolePassword);
	functionalcomponents.WaitTillTime(3000);
	functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_SaveButton"));
	String ToastMsgText=driver.findElement(By.xpath(properties.getProperty("PasswordCreation_Toast"))).getText();
	
	if (ToastMsgText.contains("Changed Password Successfully")) {
	  	test.log(Status.PASS, "Edge Console Password changed successfully with a toast: "+ToastMsgText);
	    System.out.println("Toast Message: " + ToastMsgText);
	} else {
	  	failedDescription("Edge Console Password changed failed with toast saying: "+ToastMsgText);
	    System.out.println("Toast Message: " + ToastMsgText);
	}
	
	//Validating if Security Tab is opening and Import Export configurations visible inside it.
	test.log(Status.INFO, "Click on Settings Tab on the workcenter at left of the screen and open Import/Export Configurations");
	if( !driver.findElement(By.xpath(properties.getProperty("SettingsTab_ImportExportConfigListItem"))).getAttribute("aria-expanded").equals(true) )  {
		functionalcomponents.ClickOperation(properties.getProperty("SettingsTab_ImportExportConfigListItem"));
	  	functionalcomponents.WaitTillTime(3000);
	}
	functionalcomponents.PerformDoubleClick(properties.getProperty("ImportExport_ListItem"));
	functionalcomponents.WaitTillTime(3000);	
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportExport_CurrentConfigValidate"))) {	
	test.log(Status.PASS, "Import/Export configuration screen is loaded successfully");	    	
	}else {
			failedDescription("Import/Export configuration screen is not loaded successfully");
	}
	    
	//Exporting a Configuration
	test.log(Status.INFO, "Exporting a Configuration from Import/Export Configurations screen");	  
	functionalcomponents.ClickOperation(properties.getProperty("ImportExport_ExportButton"));
	functionalcomponents.WaitTillTime(3000);
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("ExportPopup_PasswordField"))) {
	functionalcomponents.ClickOperation(properties.getProperty("ExportPopup_PassTextField"));	
	functionalcomponents.WaitTillTime(3000);   	
	//Invalid and valid password
	functionalcomponents.ClearAndSetValue(properties.getProperty("ExportPopup_PassTextField"),"test@@@");
	functionalcomponents.WaitTillTime(2000);
	functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));
	functionalcomponents.WaitTillTime(3000);    	
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("ExportPopup_PasswordField"))){
	functionalcomponents.ClearAndSetValue(properties.getProperty("ExportPopup_PassTextField"),edgeConsolePassword);
	functionalcomponents.WaitTillTime(5000);
	functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));
	functionalcomponents.WaitTillTime(3000);   	
	test.log(Status.PASS, "User is able to export a configuration successfully with valid password");
	}	    	
	}else {
	   		failedDescription("Export popup not loaded on screen");
	}
	  
//	 //Importing a configuration Validate button
//	  test.log(Status.INFO, "Importing a Configuration from Import/Export Configurations screen");
//	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportExport_CurrentConfigValidate"))) {
//	 	
//	functionalcomponents.PerformDoubleClick(properties.getProperty("ImportConfig_FileField"));
//	
//	functionalcomponents.WaitTillTime(2000);
//	driver.findElement(By.xpath(properties.getProperty("ImportConfig_FileField"))).sendKeys(System.getProperty("user.dir")+File.separator+"Documents"+File.separator+"export.zip");
//		
//	if(driver.findElement(By.xpath(properties.getProperty("ImportConfig_FileField"))).getText().equalsIgnoreCase("export.zip")|| functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_FilePassPopup"))) {
//		    	
//		    	
//	functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_FilePassField"));
//	functionalcomponents.ClearAndSetValue(properties.getProperty("ImportConfig_FilePassField"), edgeConsolePassword);
//	functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));
//			
//	 functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_ValidateButton"));
//	    
//	if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidatePassPopup"))) {
//	   	test.log(Status.PASS, "Import configuration validation is successful");		    	
//	}else if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidateFailPopup"))) {
//	  	failedDescription("Import configuration validation failed due to incorrect password");
//	}
//		    
//	//Invalid password for Import  button
//		    
//	functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_ImportButton"));			
//	functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_FilePassField"));			
//	functionalcomponents.ClearAndSetValue(properties.getProperty("ImportConfig_FilePassField"), "Test12345");		    
//	functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));		
//			
//	if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidateFailPopup"))) {
//	System.out.println("User entered invalid file password for importing configuration");
//	test.log(Status.INFO,"User is unable to import configuration by porviding invalid file password");
//	}else if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidatePassPopup"))) {
//	  	failedDescription("User is able to import configuration by porviding invalid file password");
//	 }
//	 functionalcomponents.ClickOperation(properties.getProperty("OkButton"));
//		 
//	 //Valid password for Import button 
//			 
//	 functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_ImportButton"));			
//	 functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_FilePassField"));			
//	 functionalcomponents.ClearAndSetValue(properties.getProperty("ImportConfig_FilePassField"), edgeConsolePassword);		    
//	 functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));
//				
//	 if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidatePassPopup"))) {
//	 System.out.println("User entered valid file password for importing configuration");
//	 test.log(Status.INFO,"User is able to import configuration by providing valid file password");
//				    	
//	 }else if(functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidateFailPopup"))) {
//	   	failedDescription("User is unable to import configuration by porviding valid file password");
//	 }
//	functionalcomponents.ClickOperation(properties.getProperty("OkButton"));
//	}else {
//	failedDescription("Configuration File not uploaded to import");
//	}
	 
	 		
	//Runtime Settings validation 
	test.log(Status.INFO, "Click on Runtime Settings on the workcenter at left of the screen inside Settings");
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
	if(functionalcomponents.IsElementDisplayed(properties.getProperty("RuntimeSettings_Node_ID"))) {
	 	test.log(Status.PASS,"Rule Extension screen is displayed successfully");
	}else {
	   	failedDescription("Rule Extension screen is not displayed");
	}
	    
		
		
/*
//Prerequisite- Run SQL Server in current system	 
//Getting Data from DATA Base
String DB_UserName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "DB_UserName");	 
String DB_Password=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "DB_Password");	  

//SensorProfile DATA

String Sensorquery = "SELECT * from SENSOR_PROFILE"+" WHERE SENSOR_PROFILE_NAME = '"+SensorProfileName+"'; "; 
test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Sensore Profile as: "+SensorProfileName);

String SensorDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Sensorquery);

test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Sensore Profile are: "+SensorDB_Result);

//Action DATA
String Actionquery = "SELECT ACTION_ID,ACTION_NAME,DESCRIPTION,ACTION_TYPE_ID from ACTION"+" WHERE ACTION_NAME = '"+ActionName+"'; "; 
test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Action name as: "+ActionName);

String ActionDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Actionquery);

test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Action are: "+ActionDB_Result);

//Rule Data
String Rulequery = "SELECT * from Rule"+" WHERE RULE_NAME = '"+RuleName+"'; "; 
test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Rule name as: "+RuleName);

String RuleDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Rulequery);

test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Rule are: "+RuleDB_Result);
*/

//Deleting Sensor Profile and action	 
     DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
     DeleteSensorProfile(SensorProfileName);
     DeleteAction(ActionName);	 
}

 @Test
 public void TC02_Test_VM_tiered_warning_Flow()
 {
		String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
		String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");
		
	
	 //Prerequisite- Start the StreamingService Gateway service ( Could version )
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(2000);
	 String pagetitle=driver.getTitle();
	 System.out.println(pagetitle);
	 functionalcomponents.WaitTillTime(2000);
	 if(pagetitle.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
	 {	
		test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
	 }
	 else 
	 {
		failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
	 }
	 
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), username);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), password);
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofilerule_Link"), 20);
	 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Version"))).getText();
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Streaming Service Screen is loaded with "+Versionvalue+" "+" and with option to add sensor profile");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with option to add sensor profile");
	 }
	 
	//Create Sensor Profile
	 
	    String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "SensorProfileName");
		String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ProductionParameters_Min");
		String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ProductionParameters_Max");

		CreateSensorProfile(SensorProfileName, ProductionParameters_Min, ProductionParameters_Max);
			 
	  //Action Creation
		String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ActionName");
		String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ActionType");

		CreateAction(ActionName, "Send Gas Level Event to field", Actiontypevalue, "Gas Level Event",  "a=b");
		 		
	  
     //Set Protocols & Create Enterprise Plugin
	  String EnterprisePluginName1=CreateRESTOutboundConnector_StreamingService();
	 
	 //Add Rule for Sensor Profile
	 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 functionalcomponents.WaitTillTime(2000);
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
	// String sensorprofileid=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
	 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
	 {	
		test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule"+" ii) Sensor Profile Name "+": "+SensorProfileName);
	 }
	 else 
	 {
		failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
	 }
	 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

	 String RuleName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "RuleName");

	 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "Gas levels are abnormally higher");

	 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName+" and Rule Description as"+": "+"Gas levels are abnormally highersuccessfully to add the Rules for the sensor profile.");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
	 }
	 
	 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String Ruletypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "RuleType");
	 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String ScopLevelvalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ScopLevel");
	 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue+properties.getProperty("ScopLevelPart2"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to select StreamingServicetype as"+":"+Ruletypevalue+" "+" & scope level as"+":"+ScopLevelvalue+" "+" from dropdown button");
	 }
	 else 
	 {
		failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 }
	     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
	    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
		 String ThresholdingValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ThresholdingValue");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue);
		 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ThersholdoperatorValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ThresholdingOperator");
		 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue+properties.getProperty("Thresholdoperatorpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "5000");
		 functionalcomponents.WaitTillTime(1000);
		 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
		 }
		 else 
		 {
			failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
		 }
	    test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
	    functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
	    functionalcomponents.WaitTillTime(2000);
	    functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
	    functionalcomponents.WaitTillTime(2000);
	    functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	    functionalcomponents.WaitTillTime(2000);
	    functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
	    functionalcomponents.WaitTillTime(2000);
	 
	    functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	    functionalcomponents.WaitTillTime(2000);
	    functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName1+properties.getProperty("SelectEnterprisePart2"));
	    functionalcomponents.WaitTillTime(2000);
	 
	 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
	 {	
			test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+EnterprisePluginName+" "+ "from List");
	 }
	 else 
	 {
		failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
	 }
	 
	 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.PageScrollDown();
	 functionalcomponents.WaitTillTime(3000);
	 String SavedRuleNameValue=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName+properties.getProperty("Saved_RuleName2"))).getText();	
	 if(RuleName.equalsIgnoreCase(SavedRuleNameValue))
	 {	
		 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName+" "+"for Sensore Profile");
	 }
	 else 
	 {
		failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionName);
	 }
	 
	 
	//Add New Rule for Sensor Profile
	 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 functionalcomponents.WaitTillTime(2000);
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
	// String sensorprofileid1=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
	 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
	 {	
		test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" +" i) Sensor Profile Name "+": "+SensorProfileName);
	 }
	 else 
	 {
		failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
	 }
	 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

	 String RuleName1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "RuleName1");

	 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName1);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), RuleName1);

	 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName1+" and Rule Description as"+": "+RuleName1+" "+"successfully to add the Rules for the sensor profile");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
	 }
	 
	 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String Ruletypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "RuleType1");
	 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue1+properties.getProperty("RuletypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String ScopLevelvalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ScopLevel1");
	 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue1+properties.getProperty("ScopLevelPart2"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to select Ruletype as"+": "+Ruletypevalue1+" "+" & scope level as"+": "+ScopLevelvalue1+" "+" from dropdown button");
	 }
	 else 
	 {
		failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 }
	 test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
  
	 String ThresholdingValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ThresholdingValue1");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue1);
	 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String ThersholdoperatorValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_tiered_warning_Flow", "ThresholdingOperator1");
	 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue1+properties.getProperty("Thresholdoperatorpart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "5000");
	 functionalcomponents.WaitTillTime(1000);
	
	 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
	 {	
			test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue1+" "+" as well as Maximum Event Frequency value is 5000");
	 }
	 else 
	 {
		failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue1+" "+" as well as Maximum Event Frequency value is 5000");
	 }
	 
	 test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
	 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
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
	 functionalcomponents.WaitTillTime(3000);
	 String SavedRuleNameValue1=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName1+properties.getProperty("Saved_RuleName2"))).getText();
	 if(RuleName1.equalsIgnoreCase(SavedRuleNameValue1))
	 {	
		 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName1+" "+"for Sensore Profile");
	 }
	 else 
	 {
		failedDescription("Clicked Save Rule button and verified Rule is created successfully with RuleName\"+\":\"+RuleName1+\" \"+\"for Sensore Profile");
	 }
	 
//Deleting Sensor Profile and action
	 
     DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
     DeleteRuleFromSensorProfile(SensorProfileName, RuleName1);
     DeleteSensorProfile(SensorProfileName);
     DeleteAction(ActionName);
    
	 
}	
 
 @Test
 public void TC03_Test_VM_Tiered_Critical_SensorTag_Flow()
 {
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");
	
	
	 //Prerequisite- Start the StreamingService Gateway service ( Could version )
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(2000);
	 String pagetitle=driver.getTitle();
	 System.out.println(pagetitle);
	 functionalcomponents.WaitTillTime(2000);
	 if(pagetitle.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
	 {	
		test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
	 }
	 else 
	 {
		failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
	 }
	 
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), username);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), password);
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofilerule_Link"), 20);
	 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Version"))).getText();
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Streaming Service Screen is loaded with "+Versionvalue+" "+" and with option to add sensor profile");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with option to add sensor profile");
	 }
	 
	//Creating Sensor Profile
	 
	String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "SensorProfileName");
	String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ProductionParameters_Min");
	String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ProductionParameters_Max");
	
	CreateSensorProfile(SensorProfileName, ProductionParameters_Min, ProductionParameters_Max);
	
	 
	 
	//Action Creation
	 
	String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ActionName");
	String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ActionType");

	CreateAction(ActionName, " ", Actiontypevalue, ActionName,  " ");
	 
	
	 //New Action creation
	
	 String ActionName1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ActionName1");
	 String Actiontypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ActionType1");

	
	 CreateAction(ActionName1, "Send Gas Level Event to field", Actiontypevalue1, ActionName1,  " ");
	 
	 //Add Rule for Sensor Profile
	 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 functionalcomponents.WaitTillTime(2000);
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
	// String sensorprofileid=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
	 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
	 {	
		test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" +" i) Sensor Profile Name "+": "+SensorProfileName);
	 }
	 else 
	 {
		failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
	 }
	 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

	 String RuleName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "RuleName");

	 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "");

	 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName+" and Rule Description as"+": "+"Gas levels are abnormally higher "+"successfully to add the Rules for the sensor profile.");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
	 }
	 
	 test.log(Status.INFO, "Select Ruletype  & Scope level from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String Ruletypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "RuleType");
	 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String ScopLevelvalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ScopLevel");
	 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue+properties.getProperty("ScopLevelPart2"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to select Ruletype as"+":"+Ruletypevalue+" "+" & scope level as"+":"+ScopLevelvalue+" "+" from dropdown button");
	 }
	 else 
	 {
		failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 }
	     functionalcomponents.ClickAndSetValue(properties.getProperty("ScopLeel_Value"), "tag");
	     functionalcomponents.WaitTillTime(2000);
	     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
	    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
		 String ThresholdingValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ThresholdingValue");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue);
		 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ThersholdoperatorValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ThresholdingOperator");
		 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue+properties.getProperty("Thresholdoperatorpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "2000");
		 functionalcomponents.WaitTillTime(1000);
		 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
		 }
		 else 
		 {
			failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
		 }
	 test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
	 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
	 {	
			test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+EnterprisePluginName+" "+ "from List");
	 }
	 else 
	 {
		failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
	 }
	 
	 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.PageScrollDown();
	 functionalcomponents.WaitTillTime(3000);
	 String SavedRuleNameValue=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName+properties.getProperty("Saved_RuleName2"))).getText();	
	 if(RuleName.equalsIgnoreCase(SavedRuleNameValue))
	 {	
		 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName+" "+"for Sensore Profile");
	 }
	 else 
	 {
		failedDescription("Clicked Save Rule button and verified Rule is created successfully with RuleName\"+\":\"+RuleName+\" \"+\"for Sensore Profile");
	 }
	 
	 
	//Add New Rule for Sensor Profile
	 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 functionalcomponents.WaitTillTime(2000);
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
	// String sensorprofileid1=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
	 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
	 {	
		test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" +" ii) Sensor Profile Name "+": "+SensorProfileName);
	 }
	 else 
	 {
		failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
	 }
	 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

	 String RuleName1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "RuleName1");

	 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName1);
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "");

	 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName1+" and Rule Description as"+": "+"Gas levels are abnormally highersuccessfully to add the Rules for the sensor profile.");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
	 }
	 
	 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String Ruletypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "RuleType1");
	 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue1+properties.getProperty("RuletypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String ScopLevelvalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ScopLevel1");
	 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue1+properties.getProperty("ScopLevelPart2"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
	 {	
		test.log(Status.PASS, "user is able to select Ruletype as"+":"+Ruletypevalue1+" "+" & scope level as"+":"+ScopLevelvalue1+" "+" from dropdown button");
	 }
	 else 
	 {
		failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 }
	     functionalcomponents.ClickAndSetValue(properties.getProperty("ScopLeel_Value"), "tag");
	     functionalcomponents.WaitTillTime(2000);
	     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
	    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
		 String ThresholdingValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ThresholdingValue1");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue1);
		 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ThersholdoperatorValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorTag_Flow", "ThresholdingOperator1");
		 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue1+properties.getProperty("Thresholdoperatorpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "2000");
		 functionalcomponents.WaitTillTime(1000);
		 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
		 }
		 else 
		 {
			failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
		 }
	 test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
	 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName1.trim()+properties.getProperty("SelectActionpart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
	 {	
			test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName1+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+ "from List");
	 }
	 else 
	 {
		failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
	 }
	 
	 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
	 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
	 functionalcomponents.WaitTillTime(3000);
	 functionalcomponents.PageScrollDown();
	 functionalcomponents.WaitTillTime(3000);
	 String SavedRuleNameValue1=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName1+properties.getProperty("Saved_RuleName2"))).getText();	
	 if(RuleName1.equalsIgnoreCase(SavedRuleNameValue1))
	 {	
		 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName1+" "+"for Sensore Profile");
	 }
	 else 
	 {
		failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionName1);
	 }
	 
	 // Deleting Sensor Profile 
	 DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
     DeleteRuleFromSensorProfile(SensorProfileName, RuleName1);
     DeleteSensorProfile(SensorProfileName);
     DeleteAction(ActionName);
     DeleteAction(ActionName1);
}	

 @Test
 public void TC04_Test_VM_Tiered_Critical_SensorID_Flow()
 {
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");
		 
	 //Prerequisite- Start the StreamingService Gateway service ( Could version )
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(2000);
	 String pagetitle=driver.getTitle();
	 System.out.println(pagetitle);
	 functionalcomponents.WaitTillTime(2000);
	 if(pagetitle.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
	 {	
		test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
	 }
	 else 
	 {
		failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
	 }
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), username);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), password);
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofilerule_Link"), 20);
	 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Version"))).getText();
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Streaming Service Screen is loaded with "+Versionvalue+" "+" and with option to add sensor profile");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with option to add sensor profile");
	 }
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
	 String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "SensorProfileName");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Sensorprofile_Name"), SensorProfileName);
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).isDisplayed())
	 {	
		test.log(Status.PASS, "sensor profile name as"+":"+SensorProfileName+" "+" is saved successfully with special characters");
	 }
	 else 
	 {
		failedDescription(" sensor profile name is not saved successfully with special characters");
	 }
	 functionalcomponents.ClickOperation(properties.getProperty("Stream_Reading_Monitor"));
	 test.log(Status.INFO, "Enter numeric values for the Testing & Production Parameters with the maximum and minimum values");
	 String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ProductionParameters_Min");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ProductionParameters_Minimum"), ProductionParameters_Min);
	 String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ProductionParameters_Max");

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
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Sensorprofile_Name"), 20);
	 String SensorProfile_Name=driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).getAttribute("value");
	 
	 if(SensorProfileName.equalsIgnoreCase(SensorProfile_Name))
	 {	
		test.log(Status.PASS, "Click Save sensor Profile button and verified sensor profile is created successfully with Profile Name"+" :"+SensorProfile_Name);
	 }
	 else 
	 {
		failedDescription("Click Save sensor Profile button and sensor profile is not created successfully with Profile Name"+":"+SensorProfile_Name);
	 }
	//Action Creation
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
	 String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ActionName");
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
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionDescription"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Description of the Actions Successfully "+": ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Description of the Actions Successfully");
	 }
	 test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionType_Dropdown"));
	 functionalcomponents.WaitTillTime(3000);
	 String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ActionType");
	 
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
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Message"), ActionName);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Parameters"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Message of the Actions as: Greater Than 20 Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Enter Parameters of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Parameters"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionSave_btn"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Parameters of the Actions as:  Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Click Save Action button and verify Action is created successfully with Action Name");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionSave_btn"));
	 functionalcomponents.WaitTillTime(2000);
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
	 String ActionName1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ActionName1");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionName"), ActionName1);
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("ActionName"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter a name of the Actions "+": "+ActionName1);
	 }
	 else 
	 {
		failedDescription("user is not able to enter a name of the Actions with the different possible options for the name with special characters and numbers");
	 }
	 test.log(Status.INFO, "Enter Description of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionDescription"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Description of the Actions Successfully "+": ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Description of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionType_Dropdown"));
	 functionalcomponents.WaitTillTime(1000);
	 String Actiontypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ActionType1");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionTypePart1")+Actiontypevalue1+properties.getProperty("ActionTypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ActionPluginID_Dropdown"));
	 functionalcomponents.WaitTillTime(1000);
	 functionalcomponents.ClickOperation(properties.getProperty("ActionPluginID_HttpProtocol"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Message"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "User is able to Select Actiontype as"+": "+Actiontypevalue1+" "+"& ActionPlugin as httpprotocol plugin from dropdown button");
	 }
	 else 
	 {
		failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 }
	 
	 test.log(Status.INFO, "Enter Message of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Message"), ActionName1);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Parameters"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Message of the Actions as: Greater Than 50 Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Enter Parameters of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Parameters"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionSave_btn"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Parameters of the Actions as: Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Click Save Action button and verify Action is created successfully with Action Name");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionSave_btn"));
	 functionalcomponents.WaitTillTime(2000);
	 driver.navigate().refresh();
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("ActionsName_List"), ActionName1);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ActionName"), 20);
	 String ActionNameValue1=driver.findElement(By.xpath(properties.getProperty("ActionName"))).getAttribute("value");
	 if(ActionNameValue1.equalsIgnoreCase(ActionName1))
	 {	
		test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name"+": "+ActionNameValue1);
	 }
	 else 
	 {
		failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue1);
	 }
	 //Rule creation 
	     test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
		 functionalcomponents.WaitTillTime(2000);
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
		// String sensorprofileid=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
		 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
		 {	
			test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule"+" i) Sensor Profile Name "+": "+SensorProfile_Name);
		 }
		 else 
		 {
			failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
		 }
		 
		 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

		 String RuleName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "RuleName");

		 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "");

		 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName+" and Rule Description as"+": "+"Gas levels are abnormally highersuccessfully to add the Rules for the sensor profile.");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
		 }
		 
		 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String Ruletypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "RuleType");
		 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ScopLevelvalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ScopLevel");
		 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue+properties.getProperty("ScopLevelPart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to select Ruletype as"+":"+Ruletypevalue+" "+" & scope level as"+":"+ScopLevelvalue+" "+" from dropdown button");
		 }
		 else 
		 {
			failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 }
		     functionalcomponents.ClickAndSetValue(properties.getProperty("ScopLeel_Value"), "id");
		     functionalcomponents.WaitTillTime(2000);
		     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
		    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
			 String ThresholdingValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ThresholdingValue");
			 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue);
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
			 functionalcomponents.WaitTillTime(2000);
			 String ThersholdoperatorValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ThresholdingOperator");
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue+properties.getProperty("Thresholdoperatorpart2"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "2000");
			 functionalcomponents.WaitTillTime(1000);
			 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
			 {	
					test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
			 else 
			 {
				failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
		 test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
		 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+EnterprisePluginName+" "+ "from List");
		 }
		 else 
		 {
			failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
		 }
		 
		 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
		 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
		 functionalcomponents.WaitTillTime(3000);
		 driver.navigate().refresh();
		 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
		 functionalcomponents.WaitTillTime(3000);
		 String SavedRuleNameValue=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName+properties.getProperty("Saved_RuleName2"))).getText();	
		 if(RuleName.equalsIgnoreCase(SavedRuleNameValue))
		 {	
			 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName+" "+"for Sensore Profile");
		 }
		 else 
		 {
			failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue);
		 }
		 
		 
		//Add New Rule for Sensor Profile
		 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
		 functionalcomponents.WaitTillTime(2000);
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
		// String sensorprofileid1=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
		 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
		 {	
			test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" +" i) Sensor Profile Name "+": "+SensorProfile_Name);
		 }
		 else 
		 {
			failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
		 }
		 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

		 String RuleName1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "RuleName1");

		 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName1);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "");

		 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName1+" and Rule Description as"+": "+"Gas levels are abnormally highersuccessfully to add the Rules for the sensor profile.");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
		 }
		 
		 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String Ruletypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "RuleType1");
		 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue1+properties.getProperty("RuletypePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ScopLevelvalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ScopLevel1");
		 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue1+properties.getProperty("ScopLevelPart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to select StreamingServicetype as"+":"+Ruletypevalue1+" "+" & scope level as"+":"+ScopLevelvalue1+" "+" from dropdown button");
		 }
		 else 
		 {
			failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 }
		     functionalcomponents.ClickAndSetValue(properties.getProperty("ScopLeel_Value"), "id");
		     functionalcomponents.WaitTillTime(2000);
		     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
		    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
			 String ThresholdingValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ThresholdingValue1");
			 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue1);
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
			 functionalcomponents.WaitTillTime(2000);
			 String ThersholdoperatorValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_SensorID_Flow", "ThresholdingOperator1");
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue1+properties.getProperty("Thresholdoperatorpart2"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "2000");
			 functionalcomponents.WaitTillTime(1000);
			 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
			 {	
					test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
			 else 
			 {
				failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
		 test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
		 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName1.trim()+properties.getProperty("SelectActionpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName1+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+ "from List");
		 }
		 else 
		 {
			failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
		 }
		 
		 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
		 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.PageScrollDown();
		 functionalcomponents.WaitTillTime(3000);
		 String SavedRuleNameValue1=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName1+properties.getProperty("Saved_RuleName2"))).getText();	
		 if(RuleName1.equalsIgnoreCase(SavedRuleNameValue1))
		 {	
			 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName1+" "+"for Sensore Profile");
		 }
		 else 
		 {
			failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue1);
		 }
		 
		 // Deleting Sensor Profile
		 DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
		 DeleteRuleFromSensorProfile(SensorProfileName, RuleName1);
	     DeleteSensorProfile(SensorProfileName);
	     DeleteAction(ActionName);
	     DeleteAction(ActionName1);
		 
 }

 
 @Test
 public void TC05_Test_VM_Tiered_Critical_Devicetag_Flow()
 {
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");
	
	 //Prerequisite- Start the StreamingService Gateway service ( Could version )
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(2000);
	 String pagetitle=driver.getTitle();
	 System.out.println(pagetitle);
	 functionalcomponents.WaitTillTime(2000);
	 if(pagetitle.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
	 {	
		test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
	 }
	 else 
	 {
		failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
	 }
	 
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), username);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), password);
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofilerule_Link"), 20);
	 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Version"))).getText();
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Streaming Service Screen is loaded with "+Versionvalue+" "+" and with option to add sensor profile");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with option to add sensor profile");
	 }		
	 
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
	 String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "SensorProfileName");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Sensorprofile_Name"), SensorProfileName);
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).isDisplayed())
	 {	
		test.log(Status.PASS, "sensor profile name as"+":"+SensorProfileName+" "+" is saved successfully with special characters");
	 }
	 else 
	 {
		failedDescription(" sensor profile name is not saved successfully with special characters");
	 }
	 
	 functionalcomponents.ClickOperation(properties.getProperty("Stream_Reading_Monitor"));		 
	 test.log(Status.INFO, "Enter numeric values for the Testing & Production Parameters with the maximum and minimum values");
	 String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ProductionParameters_Min");

	 functionalcomponents.ClickAndSetValue(properties.getProperty("ProductionParameters_Minimum"), ProductionParameters_Min);
	 String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ProductionParameters_Max");

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
	 functionalcomponents.WaitTillTime(7000);
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Sensorprofile_Name"), 20);
	 String SensorProfile_Name=driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).getAttribute("value");
	// System.out.println("Profile"+SensorProfile_Name);
	 if(SensorProfileName.equalsIgnoreCase(SensorProfile_Name))
	 {	
		test.log(Status.PASS, "Click Save sensor Profile button and verified sensor profile is created successfully with Profile Name"+" :"+SensorProfile_Name);
	 }
	 else 
	 {
		failedDescription("Click Save sensor Profile button and sensor profile is not created successfully with Profile Name"+":"+SensorProfile_Name);
	 }
	 
	//Action Creation
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
	 String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionName");
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
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionDescription"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Description of the Actions Successfully "+": ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Description of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionType_Dropdown"));
	 functionalcomponents.WaitTillTime(3000);
	 String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionType");
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
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Message"), ActionName);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Parameters"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Message of the Actions as: Gas Level Event Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Enter Parameters of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Parameters"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionSave_btn"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Parameters of the Actions as:  Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Click Save Action button and verify Action is created successfully with Action Name");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionSave_btn"));
	 functionalcomponents.WaitTillTime(2000);
	// driver.navigate().refresh();
	// functionalcomponents.WaitTillTime(7000);
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
	 
	 //New Action creation
	 
	 test.log(Status.INFO, "Click on Actions on the workcenter at left of the screen Configuration>>Actions Click a new action by + symbol at the bottom of the screen");
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
	 String ActionName1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionName1");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionName"), ActionName1);
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("ActionName"), 20);
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter a name of the Actions "+": "+ActionName1);
	 }
	 else 
	 {
		failedDescription("user is not able to enter a name of the Actions with the different possible options for the name with special characters and numbers");
	 }
	 
	 test.log(Status.INFO, "Enter Description of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionDescription"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Description of the Actions Successfully "+": ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Description of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionType_Dropdown"));
	 functionalcomponents.WaitTillTime(1000);
	 String Actiontypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionType1");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionTypePart1")+Actiontypevalue1+properties.getProperty("ActionTypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ActionPluginID_Dropdown"));
	 functionalcomponents.WaitTillTime(1000);
	 functionalcomponents.ClickOperation(properties.getProperty("ActionPluginID_HttpProtocol"));
	 functionalcomponents.WaitTillTime(2000);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Message"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "User is able to Select Actiontype as"+": "+Actiontypevalue1+" "+"& ActionPlugin as httpprotocol plugin from dropdown button");
	 }
	 else 
	 {
		failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
	 }
	 
	 test.log(Status.INFO, "Enter Message of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Message"), ActionName1);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Parameters"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Message of the Actions as: Gas Level Event Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Enter Parameters of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Parameters"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionSave_btn"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Parameters of the Actions as: Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Click Save Action button and verify Action is created successfully with Action Name");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionSave_btn"));
	 functionalcomponents.WaitTillTime(2000);
	 driver.navigate().refresh();
	 functionalcomponents.WaitTillTime(7000);
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("ActionsName_List"), ActionName1);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ActionName"), 20);
	 String ActionNameValue1=driver.findElement(By.xpath(properties.getProperty("ActionName"))).getAttribute("value");
	 if(ActionNameValue1.equalsIgnoreCase(ActionName1))
	 {	
		test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name"+": "+ActionNameValue1);
	 }
	 else 
	 {
		failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue1);
	 }
	
	  //Add Rule for Sensor Profile
		 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
		 functionalcomponents.WaitTillTime(7000);
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
		 //String sensorprofileid=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
		 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
		 {	
			test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" + "Sensor Profile Name "+": "+SensorProfile_Name);
		 }
		 else 
		 {
			failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
		 }
		 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

		 String RuleName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleName");

		 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "");

		 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName+" and Rule Description as"+": "+"");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
		 }
		 
		 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String Ruletypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleType");
		 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ScopLevelvalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ScopLevel");
		 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue+properties.getProperty("ScopLevelPart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to select Ruletype as"+":"+Ruletypevalue+" "+" & scope level as"+":"+ScopLevelvalue+" "+" from dropdown button");
		 }
		 else 
		 {
			failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 }
		     functionalcomponents.ClickAndSetValue(properties.getProperty("ScopLeel_Value"), "CO GAS");
		     functionalcomponents.WaitTillTime(2000);
		     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
		    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
			 String ThresholdingValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingValue");
			 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue);
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
			 functionalcomponents.WaitTillTime(2000);
			 String ThersholdoperatorValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingOperator");
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue+properties.getProperty("Thresholdoperatorpart2"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "2000");
			 functionalcomponents.WaitTillTime(1000);
			 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
			 {	
					test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
			 else 
			 {
				failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
		 test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
		 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+EnterprisePluginName+" "+ "from List");
		 }
		 else 
		 {
			failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
		 }
		 
		 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
		 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.PageScrollDown();
		 functionalcomponents.WaitTillTime(3000);
		 String SavedRuleNameValue=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName+properties.getProperty("Saved_RuleName2"))).getText();	
		 if(RuleName.equalsIgnoreCase(SavedRuleNameValue))
		 {	
			 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName+" "+"for Sensore Profile");
		 }
		 else 
		 {
			failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue);
		 }
		 
		//Add New Rule for Sensor Profile
		 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
		 functionalcomponents.WaitTillTime(6000);
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
		 //String sensorprofileid1=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
		 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
		 {	
			test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" +" i) Sensor Profile Name "+": "+SensorProfile_Name);
		 }
		 else 
		 {
			failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
		 }
		 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

		 String RuleName1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleName1");

		 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName1);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "");

		 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName1+" and Rule Description as"+": "+"");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
		 }
		 
		 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String Ruletypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleType1");
		 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue1+properties.getProperty("RuletypePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ScopLevelvalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ScopLevel1");
		 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue1+properties.getProperty("ScopLevelPart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to select Ruletype as"+":"+Ruletypevalue1+" "+" & scope level as"+":"+ScopLevelvalue1+" "+" from dropdown button");
		 }
		 else 
		 {
			failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 }
		     functionalcomponents.ClickAndSetValue(properties.getProperty("ScopLeel_Value"), "CO GAS");
		     functionalcomponents.WaitTillTime(2000);
		     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
		    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
			 String ThresholdingValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingValue1");
			 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue1);
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
			 functionalcomponents.WaitTillTime(2000);
			 String ThersholdoperatorValue1=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingOperator1");
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue1+properties.getProperty("Thresholdoperatorpart2"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "2000");
			 functionalcomponents.WaitTillTime(1000);
			 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
			 {	
					test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
			 else 
			 {
				failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue1+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 5000");
			 }
		 test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
		 functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName1.trim()+properties.getProperty("SelectActionpart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName1+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+ "from List");
		 }
		 else 
		 {
			failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
		 }
		 
		 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
		 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.PageScrollDown();
		 functionalcomponents.WaitTillTime(3000);
		 String SavedRuleNameValue1=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName1+properties.getProperty("Saved_RuleName2"))).getText();	
		 if(RuleName1.equalsIgnoreCase(SavedRuleNameValue1))
		 {	
			 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName1+" "+"for Sensore Profile");
		 }
		 else 
		 {
			failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue1);
		 }
		 
		 // Deleting Sensor Profile
		 DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
		 DeleteRuleFromSensorProfile(SensorProfileName, RuleName1);
	     DeleteSensorProfile(SensorProfileName);
	     DeleteAction(ActionName);
	     DeleteAction(ActionName1);
	 
} 
 
 @Test
 public void TC06_Test_VM_equality_deviceid()
 {
	 String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
	 String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");
		
	//Prerequisite- Start the StreamingService Gateway service ( Could version )
	 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
	 driver.get(properties.getProperty("StreamingService_URL"));
	 functionalcomponents.WaitTillTime(2000);
	 String pagetitle=driver.getTitle();
	 System.out.println(pagetitle);
	 functionalcomponents.WaitTillTime(2000);
	 if(pagetitle.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
	 {	
		test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
	 }
	 else 
	 {
		failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
	 }
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), username);
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), password);
	 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
	 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 test.log(Status.INFO, "Login Streaming service and Click on Sensor profile on the workcenter at left of the screen");
	 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("Sensorprofilerule_Link"), 20);
	 String Versionvalue=driver.findElement(By.xpath(properties.getProperty("Version"))).getText();
	 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
	 if(driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed())
	 {	
		test.log(Status.PASS, "Streaming Service Screen is loaded with "+Versionvalue+" "+" and with option to add sensor profile");
	 }
	 else 
	 {
		failedDescription("Screen is not loaded with option to add sensor profile");
	 }
	  
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
	 String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "SensorProfileName");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Sensorprofile_Name"), SensorProfileName);
	 if(driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).isDisplayed())
	 {	
		test.log(Status.PASS, "sensor profile name as"+":"+SensorProfileName+" "+" is saved successfully with special characters");
	 }
	 else 
	 {
		failedDescription(" sensor profile name is not saved successfully with special characters");
	 }
	 functionalcomponents.ClickOperation(properties.getProperty("Stream_Reading_Monitor"));
	 test.log(Status.INFO, "Enter numeric values for the Testing & Production Parameters with the maximum and minimum values");
	 String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "ProductionParameters_Min");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ProductionParameters_Minimum"), ProductionParameters_Min);
	 String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "ProductionParameters_Max");

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
	 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Sensorprofile_Name"), 20);
	 String SensorProfile_Name=driver.findElement(By.xpath(properties.getProperty("Sensorprofile_Name"))).getAttribute("value");
	 
	 if(SensorProfileName.equalsIgnoreCase(SensorProfile_Name))
	 {	
		test.log(Status.PASS, "Click Save sensor Profile button and verified sensor profile is created successfully with Profile Name"+" :"+SensorProfile_Name);
	 }
	 else 
	 {
		failedDescription("Click Save sensor Profile button and sensor profile is not created successfully with Profile Name"+":"+SensorProfile_Name);
	 }
	 
	//Action Creation
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
	 String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "ActionName");
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
	 functionalcomponents.ClickAndSetValue(properties.getProperty("ActionDescription"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionName"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Description of the Actions Successfully "+": ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Description of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
	 functionalcomponents.ClickOperation(properties.getProperty("ActionType_Dropdown"));
	 functionalcomponents.WaitTillTime(3000);
	 String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "ActionType");
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
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Message"), ActionName);
	 if(driver.findElement(By.xpath(properties.getProperty("Action_Parameters"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Message of the Actions as: Gas Level Event Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
	 }
	 
	 test.log(Status.INFO, "Enter Parameters of the Actions");
	 functionalcomponents.ClickAndSetValue(properties.getProperty("Action_Parameters"), "");
	 if(driver.findElement(By.xpath(properties.getProperty("ActionSave_btn"))).isDisplayed())
	 {	
		 test.log(Status.PASS, "user is able to enter Parameters of the Actions as:  Successfully ");
	 }
	 else 
	 {
		failedDescription("user is not able to enter Message of the Actions Successfully");
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
	 
	  //Add Rule for Sensor Profile
		 test.log(Status.INFO, "Navigate to Sesore Profile and Add rule for sensorprofile by clicking on the + symbol on the screen");
		 functionalcomponents.ClickOperation(properties.getProperty("Sensorprofilerule_Link"));
		 functionalcomponents.WaitTillTime(2000);
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
		// String sensorprofileid=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
		 if( driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
		 {	
			test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" + " Sensor Profile Name "+": "+SensorProfile_Name);
		 }
		 else 
		 {
			failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
		 }
		 test.log(Status.INFO, "Enter Rule name  to add the Rules for the sensor profile.");

		 String RuleName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "RuleName");

		 functionalcomponents.ClickAndSetValue(properties.getProperty("SensorProfile_Rulename"), RuleName);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"), "");
		 functionalcomponents.WaitTillTime(4000);
		 if(driver.findElement(By.xpath(properties.getProperty("Ruletype_Dropdown"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to enter Rule name as"+": "+RuleName+" and Rule Description as"+": "+"");
		 }
		 else 
		 {
			failedDescription("user is not able to enter Rule name to add the Rules for the sensor profile.");
		 }	 
		 test.log(Status.INFO, "select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 functionalcomponents.ClickOperation(properties.getProperty("Ruletype_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String Ruletypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "RuleType");
		 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
		 functionalcomponents.WaitTillTime(3000);
		 String ScopLevelvalue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "ScopLevel");
		 functionalcomponents.ClickOperation(properties.getProperty("ScopLevelPart1")+ScopLevelvalue+properties.getProperty("ScopLevelPart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.scrollToExact(properties.getProperty("Thresholding_Value"));
		 if(driver.findElement(By.xpath(properties.getProperty("Thresholding_Value"))).isDisplayed())
		 {	
			test.log(Status.PASS, "user is able to select Ruletype as"+":"+Ruletypevalue+" "+" & scope level as"+":"+ScopLevelvalue+" "+" from dropdown button");
		 }
		 else 
		 {
			failedDescription("user is not able to select Ruletype as Value Monitoring & scope level as Sensorprofile from dropdown button");
		 }
		 
		 functionalcomponents.ClickAndSetValue(properties.getProperty("ScopLeel_Value"), "VM1");
	     functionalcomponents.WaitTillTime(2000);
		     test.log(Status.INFO, "verify user is able to select thresholding operator and Thresholding value as well as Maximum Event Frequency value");
		    // String ThresholdingValue=String.valueOf(functionalcomponents.GetRandomnumber());
			 String ThresholdingValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "ThresholdingValue");
			 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue);
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
			 functionalcomponents.WaitTillTime(2000);
			 String ThersholdoperatorValue=functionalcomponents.getdatafromsheet("StreamingService", "TC_Test_VM_equality_deviceid", "ThresholdingOperator");
			 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperatorpart1")+ThersholdoperatorValue+properties.getProperty("Thresholdoperatorpart2"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClearAndSetValue(properties.getProperty("Max_EventFrequency"), "2000");
			 functionalcomponents.WaitTillTime(1000);
			 if(driver.findElement(By.xpath(properties.getProperty("EventActions"))).isDisplayed())
			 {	
					test.log(Status.PASS, "verified user is able to select thresholding operator as: "+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 2000");
			 }
			 else 
			 {
				failedDescription("verified user is able to select thresholding operator as:"+ThersholdoperatorValue+" "+"and Thresholding value is"+":"+ThresholdingValue+" "+" as well as Maximum Event Frequency value is 2000");
			 }
		    test.log(Status.INFO, "verify user is able to enter Edgekeep Interval and selecting Event actions from Action List as well as selecting Enterprise Plugins from List");
		    functionalcomponents.ClickOperation(properties.getProperty("EventActions"));
		    functionalcomponents.WaitTillTime(2000);
		    functionalcomponents.ClickOperation(properties.getProperty("SelectActionpart1")+ActionName.trim()+properties.getProperty("SelectActionpart2"));
		    functionalcomponents.WaitTillTime(2000);
		    functionalcomponents.ClickOperation(properties.getProperty("EnterprisePlugins"));
		    functionalcomponents.WaitTillTime(2000);
		    functionalcomponents.ClickOperation(properties.getProperty("SelectEnterprisePart1")+EnterprisePluginName+properties.getProperty("SelectEnterprisePart2"));
		    functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Rule_Save_btn"))).isDisplayed())
		 {	
				test.log(Status.PASS, "verified user is able to enter Edgekeep Interval as: '7' and selecting Event actions as:"+ActionName+" "+ "from Action List as well as selecting Enterprise Plugins :"+EnterprisePluginName+", "+EnterprisePluginName+" "+ "from List");
		 }
		 else 
		 {
			failedDescription("verified user is not able to enter Edgekeep Interval as: '7' and selecting Event actions as:\"+ActionName+\" \"+ \"from Action List as well as selecting Enterprise Plugins :\"+EnterprisePluginsName+\" \"+ \"from List");
		 }
		 
		 test.log(Status.INFO, "Click Save Rule button and verify Rule is created successfully for Sensore Profile");
		 functionalcomponents.ClickOperation(properties.getProperty("Rule_Save_btn"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.PageScrollDown();
		 functionalcomponents.WaitTillTime(3000);
		 String SavedRuleNameValue=driver.findElement(By.xpath(properties.getProperty("Saved_RuleName1")+RuleName+properties.getProperty("Saved_RuleName2"))).getText();
		 functionalcomponents.WaitTillTime(3000);
		 if(RuleName.equalsIgnoreCase(SavedRuleNameValue))
		 {	
			 test.log(Status.PASS, "Clicked Save Rule button and verified Rule is created successfully with RuleName"+":"+RuleName+" "+"for Sensore Profile");
		 }
		 else 
		 {
			failedDescription("Clicked Save Action button and verified Action is created successfully with Action Name"+" "+ActionNameValue);
		 }
		 
		//Deleting Sensor Profile and action
		 
	     DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
	     DeleteSensorProfile(SensorProfileName);
	     DeleteAction(ActionName);
 } 
 
 
}
