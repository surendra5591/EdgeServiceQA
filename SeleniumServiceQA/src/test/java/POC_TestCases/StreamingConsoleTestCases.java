

package POC_TestCases;
 
import java.io.File;
import java.util.Properties;
 
import org.openqa.selenium.By;
import org.testng.annotations.Test;
 
import com.aventstack.extentreports.Status;
 
import EdgeServiceComponents.StreamingEdgeConsolecomponents;
import UtilityComponent.FunctionalComponents;
 
public class StreamingConsoleTestCases extends StreamingEdgeConsolecomponents {
               
    FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
    Properties properties = FunctionalComponents.getObjectProperties();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
    
                String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
                String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
                String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
                String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
                String EnterprisePluginName="";  
                String edgeConsolePassword= functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password");
    
 @Test
 public void TC01_Custom_Over100() throws Exception
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
				if (driver.findElement(By.xpath(properties.getProperty("Add_Symbol_btn"))).isDisplayed()) {
					test.log(Status.PASS, "Streaming Service Screen is loaded with " + Versionvalue + " "+ " and with option to add sensor profile");
				} else {
					failedDescription("Screen is not loaded with option to add sensor profile");
				}

				// Creating Sensor Profile

				String SensorProfileName = functionalcomponents.getdatafromsheet("StreamingService","TC_Custom_Over100", "SensorProfileName");
				String ProductionParameters_Min = functionalcomponents.getdatafromsheet("StreamingService","TC_Custom_Over100", "ProductionParameters_Min");
				String ProductionParameters_Max = functionalcomponents.getdatafromsheet("StreamingService","TC_Custom_Over100", "ProductionParameters_Max");
				CreateSensorProfile(SensorProfileName, ProductionParameters_Min, ProductionParameters_Max);
				// System.out.println(SensorProfileID);

				// Action Creation
				String ActionName = functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100","ActionName");
				String Actiontypevalue = functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100","ActionType");

				CreateAction(ActionName, ActionName, Actiontypevalue, ActionName, ActionName);                    
                                               
				// Set Protocols & Create Enterprise Plugin
				functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
				functionalcomponents.WaitTillTime(2000);
				EnterprisePluginName = CreateWebSocketoutboundConnector_StreamingService();
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
				} else {
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
				functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_OldPassField"), edgeConsolePassword);
				functionalcomponents.WaitTillTime(3000);
				functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_NewPassField"));
				functionalcomponents.WaitTillTime(3000);
				functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_NewPassField"),
						newEdgeConsolePassword);
				functionalcomponents.WaitTillTime(3000);
				functionalcomponents.ClickOperation(properties.getProperty("PasswordCreation_ConfirmPassField"));
				functionalcomponents.WaitTillTime(3000);
				functionalcomponents.ClearAndSetValue(properties.getProperty("PasswordCreation_ConfirmPassField"),
						newEdgeConsolePassword);
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
//              if( !driver.findElement(By.xpath(properties.getProperty("SettingsTab_ImportExportConfigListItem"))).getAttribute("aria-expanded").equals(true))  {
//                              functionalcomponents.ClickOperation(properties.getProperty("SettingsTab_ImportExportConfigListItem"));
//                              functionalcomponents.WaitTillTime(3000);
//              }
               
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
                	test.log(Status.PASS, "User is not able to export configuration with invalid password");
                functionalcomponents.ClearAndSetValue(properties.getProperty("ExportPopup_PassTextField"),edgeConsolePassword);
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
                } else
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
                if(functionalcomponents.IsElementDisplayed(properties.getProperty("RuleExtensionDetailsHeader"))) {
                                test.log(Status.PASS,"Rule Extension screen is displayed successfully");
                }else {
                                failedDescription("Rule Extension screen is not displayed");
                }              
               

 /*Prerequisite- Run SQL Server in current system          
 
 String DB_UserName=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "DB_UserName");                 
 String DB_Password=functionalcomponents.getdatafromsheet("StreamingService", "TC_Custom_Over100", "DB_Password");  
 
////SensorProfile DATA
// 
//String Sensorquery = "SELECT * from SENSOR_PROFILE"+" WHERE SENSOR_PROFILE_NAME = '"+SensorProfileName+"'; "; 
//test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Sensore Profile as: "+SensorProfileName);
// 
//String SensorDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Sensorquery);
// 
//test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Sensore Profile are: "+SensorDB_Result);
// 
////Action DATA
//String Actionquery = "SELECT ACTION_ID,ACTION_NAME,DESCRIPTION,ACTION_TYPE_ID from ACTION"+" WHERE ACTION_NAME = '"+ActionName+"'; "; 
//test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Action name as: "+ActionName);
// 
//String ActionDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Actionquery);
// 
//test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Action are: "+ActionDB_Result);
// 
////Rule Data
//String Rulequery = "SELECT * from Rule"+" WHERE RULE_NAME = '"+RuleName+"'; "; 
//test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Rule name as: "+RuleName);
// 
//String RuleDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Rulequery);
// 
//test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Rule are: "+RuleDB_Result);
 
 */
//Deleting Sensor Profile and action
                
     DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
     DeleteSensorProfile(SensorProfileName);
     DeleteAction(ActionName);           
}


private void importConfigurationMethod()
{
	// Importing a configuration Validate button
	test.log(Status.INFO, "Importing a Configuration from Import/Export Configurations screen");
	if (functionalcomponents.IsElementDisplayed(properties.getProperty("ImportExport_CurrentConfigValidate"))) {
		functionalcomponents.PerformDoubleClick(properties.getProperty("ImportConfig_FileField"));
		functionalcomponents.WaitTillTime(2000);
		driver.findElement(By.xpath(properties.getProperty("ImportConfig_FileField"))).sendKeys(
				System.getProperty("user.dir") + File.separator + "Documents" + File.separator + "export.zip");

		if (driver.findElement(By.xpath(properties.getProperty("ImportConfig_FileField"))).getText()
				.equalsIgnoreCase("export.zip")
				|| functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_FilePassPopup"))) {
			functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_FilePassField"));
			functionalcomponents.ClearAndSetValue(properties.getProperty("ImportConfig_FilePassField"),
					edgeConsolePassword);
			functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));
			functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_ValidateButton"));

			if (functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidatePassPopup"))) {
				test.log(Status.PASS, "Import configuration validation is successful");
			} else if (functionalcomponents
					.IsElementDisplayed(properties.getProperty("ImportConfig_ValidateFailPopup"))) {
				failedDescription("Import configuration validation failed due to incorrect password");
			}

			// Invalid password for Import button
			functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_ImportButton"));
			functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_FilePassField"));
			functionalcomponents.ClearAndSetValue(properties.getProperty("ImportConfig_FilePassField"), "Test12345");
			functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));

			if (functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidateFailPopup"))) {
				System.out.println("User entered invalid file password for importing configuration");
				test.log(Status.INFO, "User is unable to import configuration by porviding invalid file password");
			} else if (functionalcomponents
					.IsElementDisplayed(properties.getProperty("ImportConfig_ValidatePassPopup"))) {
				failedDescription("User is able to import configuration by porviding invalid file password");
			}
			functionalcomponents.ClickOperation(properties.getProperty("OkButton"));

			// Valid password for Import button

			functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_ImportButton"));
			functionalcomponents.ClickOperation(properties.getProperty("ImportConfig_FilePassField"));
			functionalcomponents.ClearAndSetValue(properties.getProperty("ImportConfig_FilePassField"),
					edgeConsolePassword);
			functionalcomponents.ClickOperation(properties.getProperty("SubmitButton"));

			if (functionalcomponents.IsElementDisplayed(properties.getProperty("ImportConfig_ValidatePassPopup"))) {
				System.out.println("User entered valid file password for importing configuration");
				test.log(Status.INFO, "User is able to import configuration by providing valid file password");

			} else if (functionalcomponents
					.IsElementDisplayed(properties.getProperty("ImportConfig_ValidateFailPopup"))) {
				failedDescription("User is unable to import configuration by porviding valid file password");
			}
			functionalcomponents.ClickOperation(properties.getProperty("OkButton"));
		} else {
			failedDescription("Configuration File not uploaded to import");
		}

	}

 }
 
}