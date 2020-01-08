package StreamingService;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Test_Custom_Over_100 extends EdgeServicecomponents {
	
	Properties properties = functionalcomponents.getObjectProperties();
	   
	@Test
 public void TC02_Custom_Over100()
 {
	 String username = functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "UserName");
	 String password = functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "Password");
     
	
	 //Prerequisite- Start the StreamingService Gateway service ( Could version )
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
	 
			String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "SensorProfileName");
			String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "ProductionParameters_Min");
			String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "ProductionParameters_Max");
			
	    	CreateSensorProfile(SensorProfileName, ProductionParameters_Min, ProductionParameters_Max);
			//System.out.println(SensorProfileID);
	
 //Action Creation
			
			String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "ActionName");
			String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "ActionType");

			CreateAction(ActionName, ActionName, Actiontypevalue, ActionName,  ActionName);			
			
			
 //Set Protocols & Create Enterprise Plugin
			
			 String EnterprisePluginName = CreateWebSocketoutboundConnector_StreamingService();	
			 System.out.println(EnterprisePluginName);
			
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
	 test.log(Status.INFO, "Enter Rule name  & Rule Description to add the Rules for the sensor profile.");

	 String RuleName=functionalcomponents.getdatafromsheet("Rule", "TC02_Custom_Over100", "RuleName");

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
	 String Ruletypevalue=functionalcomponents.getdatafromsheet("Rule", "TC02_Custom_Over100", "RuleType");
	 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
	 functionalcomponents.WaitTillTime(2000);
	 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
	 functionalcomponents.WaitTillTime(2000);
	 String ScopLevelTypevalue=functionalcomponents.getdatafromsheet("Rule", "TC02_Custom_Over100", "ScopLevel");
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
	 driver.navigate().refresh();
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

//Prerequisite- Run SQL Server in current system	 
//Getting Data from DATA Base
String DB_UserName=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "DB_UserName");	 
String DB_Password=functionalcomponents.getdatafromsheet("StreamingService", "TC02_Custom_Over100", "DB_Password");	  

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




//Deleting Sensor Profile and action
	 
     DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
     DeleteSensorProfile(SensorProfileName);
     DeleteAction(ActionName);
     
	
	
	 
}
}

