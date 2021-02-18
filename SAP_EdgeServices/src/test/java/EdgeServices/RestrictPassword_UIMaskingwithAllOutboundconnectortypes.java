package EdgeServices;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class RestrictPassword_UIMaskingwithAllOutboundconnectortypes extends EdgeServiceFunctions {
	
	 FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	 EdgeServiceFunctions edgeservicefunctions = new EdgeServiceFunctions();
	
	  static  String BasicAuthpassword="Basic Auth Password";
	  static  String Keymanagerpassoword="Key Manager Password";
	  static  String Keystorepassword ="Key Store Password";
	  static  String Truststorepassword ="Trust Store Password";
	  static  String ProjectName="";
	Properties properties = FunctionalComponents.getObjectProperties();
	String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	String InvalidName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "InvalidName");
	
	String projectdesc=functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Description");
	String Plugin_Name=functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Plugin_name");
	String Class  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Class");
	String Plugin_Name1  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Plugin_name1");
	String Class1  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Class1");
	String Plugin_Name2  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Plugin_name2");
	String Class2  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Class2");
	String Plugin_Name3 = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Plugin_name3");
	String Class3  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Class3");
	String EncryptPassword=functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "EncryptPassword");
	String Name  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Name");
	String Value  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Value");
	String Configname="";
	
	String pluginName4=functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Plugin_name4");
	String Class4=functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Class4");
	String LoggerLevel  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "LoggerLevel");
	String URI  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "URI");
	String BasicAuthUsername  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "BasicAuthUsername");
	String BasicAuthPassword  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "BasicAuthPassword");
	String Workspace  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Workspace");
	String Project  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Project");
	String InputStream  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "InputStream");
	String MaximumQueueSize=functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "MaximumQueueSize");
	String Local_enterpriseplugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Local_enterprise_plugin");

	
	@Test
	 public void RestrictPassword_UIMasking_Testcase() throws InterruptedException, ZipException  {			 
		edgeservicefunctions.LoginPolicyservice_MovetoEdgeDesignerTile(PolicyServiceURL,username,password);
		 //Project creation
		 test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 50);
		 functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_name"), 20);
		 if (functionalcomponents.IsElementDisplayed(properties.getProperty("Project_name")))
	      {
              test.log(Status.PASS, "user is able to see Add Prject pop up successfully");
		  } else
		  {
              failedDescription("user is not able to see the Add Project pop up ");
          } 
		 			 
		  test.log(Status.INFO, "Enter the name of the project and Enter description of the project and click on the create button");
		  ProjectName="RestrictPasswordProject"+CurrentDateandTime;
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),ProjectName);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Refresh_button"), 20);
		  functionalcomponents.ClickOperation(properties.getProperty("Refresh_button"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 50);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("ProjectSearchinput"),ProjectName);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectRuntimesettingtab"), 20);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("ProjectRuntimesettingtab")))
		  {
              test.log(Status.PASS, "user is able to create Project with name:"+""+ProjectName+""+"and Group Description:"+""+projectdesc+""+"successfully");
		  } else
		  {
              failedDescription("user is not able to enter the  Project name and description in the window");
          } 
		  //Validate Rule Extension 
		  /*
		  test.log(Status.INFO, "click on more option then select Rule Extensions tab to add the Rule extension to project");
		  functionalcomponents.ClickOperation(properties.getProperty("MoreOption"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectRuleExtensionTab"), 70);
		  functionalcomponents.ClickOperation(properties.getProperty("ProjectRuleExtensionTab"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("ImportRuleExtensionbutton"));
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation(properties.getProperty("ImportRuleExtensionClassArrow"));
		  functionalcomponents.WaitTillTime(1000);
	      if(functionalcomponents.IsElementPresent(properties.getProperty("SelectFirstRuleetensionClass")))
	      {
		  functionalcomponents.ClickOperation(properties.getProperty("SelectFirstRuleetensionClass"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("importinboundconnectorinput"),Local_enterpriseplugin);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.PresskeybordkeyandPassValue(properties.getProperty("importinboundconnectorinput"), Keys.ENTER);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleextensionLoggerlevelinput"), "AnyValue"); 
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
		  functionalcomponents.WaitTillTime(7000);
		  if (driver.findElement(By.xpath(properties.getProperty("ImportRuleExtensionbutton"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to import rule extension to project successfully");
		  } else
		  {
              failedDescription("user is not able to import rule extension to project successfully ");
          } 
		  
	 }
	 else
	 {
		  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
		  functionalcomponents.WaitTillTime(7000);
	 }
	 */     
	         //Validate Project Runtime setting
	          test.log(Status.INFO, "click on the Rune time setting tab to project and click to save after editing");  
              functionalcomponents.ClickOperation(properties.getProperty("ProjectRuntimesettingtab"));
			  functionalcomponents.ClickOperation(properties.getProperty("EditRuntimeSetting"));
			  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
			  String ToastMsgText=driver.findElement(By.xpath(properties.getProperty("ToastValidate_EditRuntimeSettings"))).getText();
				if (ToastMsgText.contains("Runtime Settings updated successfully")) {
				  	test.log(Status.PASS, "Runtime Settings updated successfully with a toast: "+ToastMsgText);
				    System.out.println("Toast Message: " + ToastMsgText);
				} else {
				  	failedDescription("Runtime Settings updated failed with toast saying: "+ToastMsgText);
				    System.out.println("Toast Message: " + ToastMsgText);
				}
			  
	         //Add Rest Out bound connector 
			  test.log(Status.INFO, "click on the Connector tab to add the Rest Outbound connector");		  	  
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectOutboundtablink"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("ProjectOutboundtablink"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Addimg"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("Outboundconnector_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 90);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"), Plugin_Name); 			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class+properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("WebSocketURI"), "http"); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin_searchinput"), 20);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  String Pluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name+"')]")).getText();
			  if(Pluginname.equalsIgnoreCase(Plugin_Name))
			  {
				  test.log(Status.PASS, "user is able to create the Rest Plugin name in the project with:"+Pluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the plugin in the project ");
	          }	
			  // Add Basic AuthPassword optional parameter to Rest out bound connector
			  test.log(Status.INFO, "click on the Rest Plugin and add the optional parameter Basic Auth Password");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1") +Plugin_Name+ properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 50);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(5000);
			  String BasicAuthpwd=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+BasicAuthpassword+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(BasicAuthpwd);
			  if(BasicAuthpwd.contains("**"))
			  {
				  test.log(Status.PASS, "Basic Auth password is masked as"+BasicAuthpwd);		
			  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	
			  //Add KeyManager Password
			  test.log(Status.INFO, "click on + add to the optional parameter KeyManager Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keymanagerpassoword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keymanagerpassoword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String Keymanagerpwd=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Keymanagerpassoword+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(Keymanagerpwd);
			  if(Keymanagerpwd.contains("**"))
			   {
				  test.log(Status.PASS, "Key Manager password is masked as"+Keymanagerpwd);		
			  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	
			  test.log(Status.INFO, "click on the +add to the optional parameter KeyStore Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.HandleRunTimeExceptions(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String keystorepwd=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Keystorepassword+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(keystorepwd);
			  if(keystorepwd.contains("**"))
			  {
				  test.log(Status.PASS, "Key store password is masked as"+keystorepwd);		
			  }
			  else
			  {
	              failedDescription("Key Store password is not masked ");
	          }	
			  test.log(Status.INFO, "click on the + add to the optional parameter Truststore Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String Truststorepwd=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Truststorepassword+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(Truststorepwd);
			  if(Truststorepwd.contains("**"))
			  {
				  test.log(Status.PASS, "Truststore password is masked as"+Truststorepwd);		
				  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	

			  // Add MQTT outbound connector
			  test.log(Status.INFO, "click on the connector tab to add the MQTT Outbound Connector");
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectOutbound"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("ProjectOutbound"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Addimg"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("Outboundconnector_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 50);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"), Plugin_Name1); 		  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class1+ properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTHost"), "MQTTHOST"); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTPort"), "4040"); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTPublishing"), "Anyvalue"); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name1);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(2000);
			  String MQTTPluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name1+"')]")).getText();
			  if(MQTTPluginname.equalsIgnoreCase(Plugin_Name1))
			  {
				  test.log(Status.PASS, "user is able to create the MQTT outbound connector name in the project with:"+MQTTPluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the MQTT outbound connector in the project ");
	          }	
			// Add Basic Client Password optional password for MQTT
			  test.log(Status.INFO, "click on the MQTT outbound connector and add the Basic Client Password optional parameters");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1")+Plugin_Name1+properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 50);
			  //Basic MQTT Keyword
			  String ClientPassword="Client Password";
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+ClientPassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+ClientPassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String ClientPasswordValue=driver.findElement(By.xpath(properties.getProperty("Security_valuepart1")+ClientPassword+properties.getProperty("Security_valuepart2"))).getText();
			  System.out.println(BasicAuthpwd);
			  if(ClientPasswordValue.contains("**"))
			  {
				  test.log(Status.PASS, "Client Password is masked as"+ClientPasswordValue);		
				  }
			  else
			  {
	              failedDescription("Client password is not masked ");
	          }	
			  // Add KeyStore password optional parameter
			  test.log(Status.INFO, "click on the MQTT outbound connector and add the optional parameter KeyStore Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String keystorepwdvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Keystorepassword+properties.getProperty("Security_valuepart2")))).getText();
			  if(keystorepwdvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Key store password is masked as"+keystorepwdvalue);		
				  }
			  else
			  {
	              failedDescription("Key Store password is not masked ");
	          }
			  // Add Trust store password optional parameter
			  test.log(Status.INFO, "click on the MQTT outbound connector and add the optional parameter Truststore Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String Truststorepwdvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Truststorepassword+properties.getProperty("Security_valuepart2")))).getText();
			  if(Truststorepwdvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Truststore password is masked as"+Truststorepwdvalue);		
				  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	 
			  //edgeservicefunctions.FreshPageandselectProject(ProjectName);
			  // Add WebSocket out bound connector
			  test.log(Status.INFO, "click on the connector tab and add the WebSocket outbound connector");
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectOutbound"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("ProjectOutbound"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Addimg"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("Outboundconnector_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 90);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"), Plugin_Name2); 				  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class2+properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("WebSocketURI"), "http"); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin_searchinput"), 50);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name2);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(2000);
			  String WebsocketPluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name2+"')]")).getText();
			  if(WebsocketPluginname.equalsIgnoreCase(Plugin_Name2))
			  {
				  test.log(Status.PASS, "user is able to create the Websocket outbound connector name in the project with:"+WebsocketPluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the Websocket outbound connector in the project ");
	          }
			  // Add Basic AuthPassword optional parameter
			  test.log(Status.INFO, "click on the Websocket outbound connector and add the optional parameter Basic Auth Password");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1")+Plugin_Name2+properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String WebBasicAuthpasswordvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+BasicAuthpassword+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(BasicAuthpwd);
			  if(WebBasicAuthpasswordvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Basic Auth password is masked as"+WebBasicAuthpasswordvalue);		
				  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	
			  //Add KeyManager Password
			  test.log(Status.INFO, "click on Websocket outbound connector and add the optional parameter KeyManager Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keymanagerpassoword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keymanagerpassoword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String WebKeymanagerpwdvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Keymanagerpassoword+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(Keymanagerpwd);
			  if(WebKeymanagerpwdvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Key Manager password is masked as"+WebKeymanagerpwdvalue);		
				  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }
			  //add the optional parameter KeyStore Password
			  test.log(Status.INFO, "click on the Websocket outbound connector and add the optional parameter KeyStore Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String Webkeystorepwdvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Keystorepassword+properties.getProperty("Security_valuepart2")))).getText();
			  if(Webkeystorepwdvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Key store password is masked as"+Webkeystorepwdvalue);		
				  }
			  else
			  {
	              failedDescription("Key Store password is not masked ");
	          }	
			  //add the optional parameter Trust store Password
			  test.log(Status.INFO, "click on the Websocket outbound connector and add the optional parameter Truststore Password");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 20);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters_name_Arrow"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String WebTruststorepwdvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+Truststorepassword+properties.getProperty("Security_valuepart2")))).getText();
			  if(WebTruststorepwdvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Truststore password is masked as"+WebTruststorepwdvalue);		
				  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	    
			  	
			  //Add HDFS Outbound Connector
			  test.log(Status.INFO, "click on the connector tab to add the HDFS Outbound Connector");
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectOutbound"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("ProjectOutbound"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Addimg"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("Outboundconnector_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 90);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"), Plugin_Name3); 				  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class3+properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTHost"), "HDFSHost"); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTPort"), "8080"); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("HDFSUsername"), "Anyvalue"); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("HDFSFilepath"), "Anyvalue"); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("HDFSColumnValues"), "Anyvalue"); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin_searchinput"), 50);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name3);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(4000);
			  String HDFSPluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name3+"')]")).getText();
			  if(HDFSPluginname.equalsIgnoreCase(Plugin_Name3))
			  {
				  test.log(Status.PASS, "user is able to create the HDFS Outbound Connector name in the project with:"+HDFSPluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the HDFS Outbound Connector in the project ");
	          }
			  // Add Delegation Token
			  test.log(Status.INFO, "click on the HDFS Outbound Connector and add the optional parameter Delegation Token");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1")+Plugin_Name3+ properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			 
			  //Basic HDFS Keyword
			  String DelegationToken="Delegation Token";
			  String OAuth2Token="OAuth2 Token"; 
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 50);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+DelegationToken+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+DelegationToken+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String HDFSDelegationvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+DelegationToken+properties.getProperty("Security_valuepart2")))).getText();
			  if(HDFSDelegationvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Delegation Token is masked as"+HDFSDelegationvalue);		
				  }
			  else
			  {
	              failedDescription("Delegation Token is not masked ");
	          }	
			  //Add Oauth2Token
			  test.log(Status.INFO, "click the HDFS Outbound Connector and add the optional parameter Oauth2Token");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Add_optioanlparam"), 50);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+OAuth2Token+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+OAuth2Token+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String HDFSOauth2Tokenvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+OAuth2Token+properties.getProperty("Security_valuepart2")))).getText();
			  if(HDFSOauth2Tokenvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Oauth2Token password is masked as"+HDFSOauth2Tokenvalue);		
				  }
			  else
			  {
	              failedDescription(" Oauth2Token password is not masked ");
	          }	
			  //Delete Optional Parameter 
			  test.log(Status.INFO, "Delete optional paramenter from outbound connector validation");
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteOptionalparameter1")+OAuth2Token+properties.getProperty("DeleteOptionalparameter2"));
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 50);
			  if (functionalcomponents.IsElementDisplayed(properties.getProperty("ProjectSearchinput")))
		      {
				  test.log(Status.PASS, "user is able to Delete optional parameter succeffully");		  }
			  else
			  {
	              failedDescription("user is not able to Delete optional Parameter successfully");
	          }	
			  // Add SDS outbound connector
			  test.log(Status.INFO, "click on the connector tab to add the SDS outbound connector and Edit Maximum Queue and try to enter any value, save the outbound connector created");
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));	
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectOutbound"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("ProjectOutbound"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Addimg"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("Outboundconnector_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 90);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"),pluginName4); 			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class4+properties.getProperty("Security_Plugindropdownname_part2"));
			  int MaximumQueueSizevalue=Integer.parseInt(MaximumQueueSize);
			  functionalcomponents.scrollToExact(properties.getProperty("MaximumQueueSize"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), MaximumQueueSize); 
			  functionalcomponents.WaitTillTime(2000); 
			  if(MaximumQueueSizevalue<128) {
				  
				 failedDescription("user is able to edit Maximum Queue size but appropriate error message is displayed like enter a number greater than or equal to 128 and user can not create SDS outbound connector");  
			  }
			  else if(MaximumQueueSizevalue>=128)
			  {
				  test.log(Status.PASS, "user is able to edit Maximum Queue size and enter new vlue"+MaximumQueueSizevalue+" By default it should be in MB");
			  } else
			  {
	              failedDescription("user is not able to edit Maximum Queue size");
		 
			  }
			  test.log(Status.INFO, "Enter all SDS outbound connector parameters field save the outbound connector created");
			  functionalcomponents.ClearAndSetValue(properties.getProperty("WebSocketURI"), URI); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthUsername"), BasicAuthUsername); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthPassword"), BasicAuthPassword); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSWorkSpace"), Workspace); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSProject"), Project); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSInputStream"), InputStream); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin_searchinput"), 70);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), pluginName4);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(3000);
			  String Pluginnamecreated=driver.findElement(By.xpath("//a[contains(text(),'"+pluginName4+"')]")).getText();
			  if(Pluginnamecreated.equalsIgnoreCase(pluginName4))
			  {
				  test.log(Status.PASS, "user is able to create the SDS outbound connector name in the project with:"+pluginName4);		  }
			  else
			  {
	              failedDescription("user is not able to create the SDS outbound connector in the project ");
	          }
			  //Export outbound connector to Global
			  String ExportoutboundName= "Exportoutbound"+CurrentDateandTime;
			  test.log(Status.INFO, "Export Project outbound connetor to Global validation");
			  functionalcomponents.ClickOperation(properties.getProperty("ExportOutboundconnector"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("ExportOutboundNameInput"), ExportoutboundName); 
			  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 70);
			  if (driver.findElement(By.xpath(properties.getProperty("ProjectSearchinput"))).isDisplayed()) 
			  {
				  test.log(Status.PASS, "user is able to export the SDS outbound connector as global");		  }
			  else
			  {
	              failedDescription("user is not able to export the SDS outbound connector as global");
	          }	
			  //click on outbound connector link and move to general setting tab and edit outbound connector
			  test.log(Status.INFO, "click on the outbound connector link and update field validation");
			  functionalcomponents.ClickOperation("//a[contains(text(),'"+pluginName4+"')]");
			  functionalcomponents.ClickOperation(properties.getProperty("EditOutBoundConnectorbutton"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("WebSocketURI"), "Updated"); 
			  functionalcomponents.ClickOperation(properties.getProperty("save_button"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectSearchinput"), 70);
			  if (driver.findElement(By.xpath(properties.getProperty("ProjectSearchinput"))).isDisplayed()) 
			  {
				  test.log(Status.PASS, "user is able to update the SDS outbound connector name in the projet");		  }
			  else
			  {
	              failedDescription("user is not able to update the SDS outbound connector in the project ");
	          }	
			  //edgeservicefunctions.FreshPageandselectProject(ProjectName);
			  //validate to add outbound connector with invalid name
			  test.log(Status.INFO, "click on the Plugin tab to add the SDS outbound connector with dupicate name validation");
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectOutbound"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("ProjectOutbound"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Addimg"), 90);
			  functionalcomponents.ClickOperation(properties.getProperty("Outboundconnector_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 90);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"), InvalidName); 
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 70);
		  	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Outboundconnector_Pluginname")))
		  	  {
				  test.log(Status.PASS, "user can not create the outbound connector in the project with invalid name as: "+InvalidName);
				  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
			  }
		  	  else
			  {
				  failedDescription("user is able to create the outbound connector in the project with invalid name");
	          }
			  // validate to add outbound connector with duplicate name
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Outboundconnector_Pluginname"),pluginName4); 			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class4+properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.scrollToExact(properties.getProperty("MaximumQueueSize"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), MaximumQueueSize); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("WebSocketURI"), URI); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthUsername"), BasicAuthUsername); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthPassword"), BasicAuthPassword); 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSWorkSpace"), Workspace); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSProject"), Project); 
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSInputStream"), InputStream); 
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Close_Button"), 70);
			  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Close_Button")))
		  	  {
				  test.log(Status.PASS, "user can not create the outbound connector with duplicate name in the project with:"+InputStream);	
				  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
		  	  }
			  else
			  {
				  failedDescription("user is not able to create the outbound connector in the project with duplicate name");
	          }	
			  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
			  functionalcomponents.WaitTillTime(7000);
			  Configname="RestricpasswordConfig"+CurrentDateandTime;
			  //Project ValidateandPublish
			  edgeservicefunctions.ProjectValidateandPublish(Configname, ProjectName);
			  edgeservicefunctions.DeleteProject(ProjectName);  
			 //DOWNLOAD THE CONFIGURATION
			  edgeservicefunctions.MovetoServicepage();
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streaming_service_services"), 70); 
			  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service_services"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration_Tab"), 70);
			  if (functionalcomponents.IsElementDisplayed(properties.getProperty("ServiceConfiguration_Tab")))
		  	  {
	              test.log(Status.PASS, "user is able to see the Steaming services window opened in the work center");
			  } else
			  {
	              failedDescription("user is able to see the Steaming services window opened in the work center ");
	          } 
			  test.log(Status.INFO, "Downloaded json file is successfully store in th foloder");
			  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("ConfigurationsearchInput"),Configname);
			  functionalcomponents.ClickOperation(properties.getProperty("ConfigurationSearchbtn"));
			  functionalcomponents.ClickOperation((properties.getProperty("Security_configlink1")+Configname+properties.getProperty("Security_configlink2")));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_config_download"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_config_download"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("fileinputName"), Configname);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("EncryptPassword"), EncryptPassword);
			  functionalcomponents.ClickOperation(properties.getProperty("Downloadbutton"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_config_download"), 70);
			  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Security_config_download")))
		  	  {
	              test.log(Status.PASS, "user is able to see the json file as well as able to download successfully in the UI");
			  } else
			  {
	              failedDescription("user is not able to see the json file as well as able to download successfully in the UI");
	          } 
			  
			  // Validate the json file 
			  test.log(Status.INFO, "Validate json file with Stored value password for all enterprise plugins");
			  String Passwordvalue  = functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Value");
			  String[] values = GetDatafromDownlodedJeson(Configname,EncryptPassword);
			  for(String i:values)
		      {
				  System.out.println(i);
				  if(i.contains(Passwordvalue))
				  test.log(Status.PASS, "user is able to see the password value as unmasked in downloaded json file"+i);
		      }
			  
			  
			  
			  
			  
			  
			  
			  
			  
			  /*
			  //Validate the Password Value in DB
			  String RestEnterprise_plugin =  "SELECT * FROM ENTERPRISE_PLUGIN_CONFIGURATION where ENTERPRISE_PLUGIN_ID = '"+Plugin_Name+"'"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for RESTENTERPRISEPLUGIN name as: "+Plugin_Name);

			  String RESTEnterpriseplugin_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, RestEnterprise_plugin);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for RESTENTERPRISEPLUGINS are: "+RESTEnterpriseplugin_Result);
			  
			  
			  String MQTTEnterprise_plugin =  "SELECT * FROM ENTERPRISE_PLUGIN_CONFIGURATION where ENTERPRISE_PLUGIN_ID = '"+Plugin_Name+"'"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for MQTT ENTERPRISEPLUGIN name as: "+Plugin_Name);

			  String MQTTEnterpriseplugin_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, MQTTEnterprise_plugin);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for MQTT ENTERPRISEPLUGINS are: "+MQTTEnterpriseplugin_Result);
			  
			  
			  
			  String WEbSocketEnterprise_plugin =  "SELECT * FROM ENTERPRISE_PLUGIN_CONFIGURATION where ENTERPRISE_PLUGIN_ID = '"+Plugin_Name+"'"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for WEB SOCKET ENTERPRISEPLUGIN name as: "+Plugin_Name);

			  String WEBEnterpriseplugin_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, WEbSocketEnterprise_plugin);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for WEB SOCKET ENTERPRISEPLUGINS are: "+WEBEnterpriseplugin_Result);
			  
			  
			  String HDFSEnterprise_plugin =  "SELECT * FROM ENTERPRISE_PLUGIN_CONFIGURATION where ENTERPRISE_PLUGIN_ID = '"+Plugin_Name+"'"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for HDFS ENTERPRISEPLUGIN name as: "+Plugin_Name);

			  String HDFSEnterpriseplugin_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, HDFSEnterprise_plugin);


			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for HDFS ENTERPRISEPLUGINS are: "+HDFSEnterpriseplugin_Result);

*/

}
	
	
	public static String[] GetDatafromDownlodedJeson(String JsonConfigFileName, String Encryptpassword) throws ZipException
	   {
		String[] values = new String[13];    
		File file = new File(System.getProperty("user.dir")+"/ExportImportFolder/config.json");
		if(file.delete()){
            System.out.println("old config json File deleted");
        }else System.out.println("old config file doesn't exist");
	    String ZipfilePath=System.getProperty("user.dir")+"/ExportImportFolder/"+JsonConfigFileName+".zip";
	    ZipFile zipfile = new ZipFile(ZipfilePath, Encryptpassword.toCharArray());
	    zipfile.extractFile("config.json", System.getProperty("user.dir")+"/ExportImportFolder/");
	   String JsonPath=System.getProperty("user.dir")+"/ExportImportFolder/config.json";
      try
      {
    	 JSONParser parser = new JSONParser();
    	 FileReader reader = new FileReader(JsonPath);
     	JSONObject jo = (JSONObject) parser.parse(reader);
     	System.out.println(jo);
	    String PluginName1="RESTEnterprisePlugins2";
	    String PluginName2="WebsocketEnterprisePlugins2";
	    String PluginName3="MQTTEnterprisePlugins2";
	    String PluginName4="HDFSEnterprisePlugins2";
     	while((PluginName1.contentEquals("RESTEnterprisePlugins2")))
     	{	
     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
	      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
	      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
	      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("RESTEnterprisePlugins2");
	      JSONObject restInfo = (JSONObject) restEP2.get(0);
	      values[0] = "BasicAuthPassword :"+(String)restInfo.get("BasicAuthPassword");
	      values[1] = "KeyManagerPassword :"+(String)restInfo.get("KeyManagerPassword");
	      values[2] = "KeyStorePassword :"+(String)restInfo.get("KeyStorePassword");
	      values[3] = "TrustStorePassword :"+(String)restInfo.get("TrustStorePassword");
	      break;
     	}
     	while((PluginName2.contentEquals("WebsocketEnterprisePlugins2")))
     	{	
	     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
		      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
		      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
		      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("WebsocketEnterprisePlugins2");
		      JSONObject restInfo = (JSONObject) restEP2.get(0);
		      values[4] = "BasicAuthPassword :"+(String)restInfo.get("BasicAuthPassword");
		      values[5] = "KeyManagerPassword :"+(String)restInfo.get("KeyManagerPassword");
		      values[6] = "KeyStorePassword :"+(String)restInfo.get("KeyStorePassword");
		      values[7] = "TrustStorePassword :"+(String)restInfo.get("TrustStorePassword");
		      break;
	     	}
     	while((PluginName3.contentEquals("MQTTEnterprisePlugins2")))
     	{	
	     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
		      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
		      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
		      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("MQTTEnterprisePlugins2");
		      JSONObject restInfo = (JSONObject) restEP2.get(0);
		      values[8] = "ClientPassword :"+(String)restInfo.get("ClientPassword");
		      values[9] = "KeyStorePassword :"+(String)restInfo.get("KeyStorePassword");
		      values[10] = "TrustStorePassword :"+(String)restInfo.get("TrustStorePassword");
		      break;
	     	}
     	while((PluginName4.contentEquals("HDFSEnterprisePlugins2")))
     	{	
	     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
		      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
		      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
		      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("HDFSEnterprisePlugins");
		      JSONObject restInfo = (JSONObject) restEP2.get(0);
		      values[11] = "DelegationToken :"+(String)restInfo.get("DelegationToken");
		      values[12] = "OAuth2Token :"+(String)restInfo.get("OAuth2Token");
		      break;
		      
	     	}
	     	
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return values;
	      }
}


