package StreamingService;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Test_VM_Tiered_critical_devicetag extends EdgeServicecomponents {
	
	
Properties properties = functionalcomponents.getObjectProperties();
	

	@Test
	 public void TC07_Test_VM_Tiered_Critical_Devicetag_Flow()
	 {
		 String username = functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "UserName");
		 String password = functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "Password");
	
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
		 String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "SensorProfileName");
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
		 String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ProductionParameters_Min");

		 functionalcomponents.ClickAndSetValue(properties.getProperty("ProductionParameters_Minimum"), ProductionParameters_Min);
		 String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ProductionParameters_Max");

		 functionalcomponents.ClickAndSetValue(properties.getProperty("ProductionParameters_Maximum"), ProductionParameters_Max);
		 
		 if(Integer.parseInt(ProductionParameters_Max)<2147483647)
		 {	
			test.log(Status.PASS, "Numeric values for the Testing & Production Parameters with the minimum and maximum values are:"+ProductionParameters_Min+","+ProductionParameters_Max+"  saved and verified Maximum value is not exceed 2147483647.");
		 }
		 else 
		 {
			failedDescription("Numeric values for the Testing & Production Parameters for the minimum and maximum values are:"+ProductionParameters_Min+","+ProductionParameters_Max+"  saved and verified Maximum value is not exceed 2147483647.");
		 }
		 
		 test.log(Status.INFO, "Enter numeric values for the Window Parameters for the minimum and window size averaging values");
		 String windowParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "WindowParameters_Min");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("WindowParameters_Minimum"), windowParameters_Min);
		 String windowsize_averaging=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "windowSize_averaging");
		 int windowsizevalue=functionalcomponents.convertHourtoSecond(Integer.parseInt(windowsize_averaging));
		 functionalcomponents.ClickOperation(properties.getProperty("Hour_toggle"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("WindowSize_Averaging"), windowsize_averaging);

		 if(Integer.parseInt(windowsize_averaging)<2147483647)
		 {	
			test.log(Status.PASS, "Numeric values for the Window Parameters for the minimum:"+windowParameters_Min+" "+" and window size averaging value:"+windowsizevalue+" "+"Second are saved and verified window size averaging values is not exceed 2147483647 ");
		 }
		 else 
		 {
			failedDescription("Enter numeric values for the Window Parameters for the minimum and window size averaging values and verified window size averaging values is exceed 2147483647");
		 }
		 
		 test.log(Status.INFO, "Check Enter value is changing to the toggling options between seconds, minutes and hours");
		 functionalcomponents.ClickOperation(properties.getProperty("Minute_toggle"));
		 functionalcomponents.WaitTillTime(3000);
		
		 functionalcomponents.ClickOperation(properties.getProperty("Second_toggle"));
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_Save_btn"))).isDisplayed())
		 {	
			test.log(Status.PASS, "Entered value is changing to the toggling options of seconds, minutes and hours properly");
		 }
		 else 
		 {
			failedDescription("Entered value is changing to the toggling options of seconds, minutes and hours properly");
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
		 String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionName");
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
		 String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionType");
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
		 functionalcomponents.WaitTillTime(7000);
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
		 String ActionName1=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionName1");
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
		 String Actiontypevalue1=functionalcomponents.getdatafromsheet("StreamingService", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ActionType1");
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
		 
		 //Set Protocols & Create Enterprise Plugin
		 
		  String EnterprisePluginName = SetProtocolandCreateWebSocketPlugin1_StreamingService();
		 
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

			 String RuleName=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleName");

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
			 String Ruletypevalue=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleType");
			 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
			 functionalcomponents.WaitTillTime(2000);
			 String ScopLevelvalue=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ScopLevel");
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
				 String ThresholdingValue=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingValue");
				 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue);
				 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
				 functionalcomponents.WaitTillTime(2000);
				 String ThersholdoperatorValue=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingOperator");
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
			 functionalcomponents.WaitTillTime(7000);
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

			 String RuleName1=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleName1");

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
			 String Ruletypevalue1=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "RuleType1");
			 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue1+properties.getProperty("RuletypePart2"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
			 functionalcomponents.WaitTillTime(2000);
			 String ScopLevelvalue1=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ScopLevel1");
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
				 String ThresholdingValue1=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingValue1");
				 functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_Value"), ThresholdingValue1);
				 functionalcomponents.ClickOperation(properties.getProperty("Thresholdoperator_dropdown"));
				 functionalcomponents.WaitTillTime(2000);
				 String ThersholdoperatorValue1=functionalcomponents.getdatafromsheet("Rule", "TC07_Test_VM_Tiered_Critical_Devicetag_Flow", "ThresholdingOperator1");
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
			 driver.navigate().refresh();
			 functionalcomponents.WaitTillTime(6000);
			 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("SensorProfile_List"), SensorProfileName);
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
}
