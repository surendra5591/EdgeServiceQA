package PolicyService;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.nio.file.Paths;
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

public class Securitycheck extends PolicyEdgedesignercomponent {
	
	  static  String BasicAuthpassword="Basic Auth Password";
	  static  String Keymanagerpassoword="Key Manager Password";
	  static  String Keystorepassword ="Key Store Password";
	  static  String Truststorepassword ="Trust Store Password";
	
	Properties properties = functionalcomponents.getObjectProperties();
	String PolicyServiceURL = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "PolicyServiceURL");
	String username = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "username");
	String password = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "password");
	String Gatewayno=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Gatewayno");
	String Projectpname = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "project_name");
	String projectdesc=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Description");
	String sensortype1  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Sensortype");
	String capablity1  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "capabilityname");
	String Property=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Property");
	String Min_reading_value=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Min_reading_value");
	String average_value  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "AverageReading_value"); 
	String Action_name1  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Actionname");
    String Action_desc  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "ActionDescription");
    String Action_Type1  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Action_type");
    String protocol_plugin=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "ProtocolPlugin");
    String Actionmsg=  functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Action_Message");
    String Receipient_param= functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Receipient_parameters");
    String Rulename  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "RuleName");
	String Ruledesc  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Rule_Desc");
	String Rulecondition  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Rule_condition");
	String filteropt  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Filter");
	String filter_scopevavlue  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Filtervalue");
	String conditiontype  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Condtiontype");
	String sensor_modelname  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Sensormodelname");
	String Plugin_Name  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Plugin_name");
	String Class  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Class");
	
	String Plugin_Name1  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Plugin_name1");
	String Class1  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Class1");
	String Plugin_Name2  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Plugin_name2");
	String Class2  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Class2");
	String Plugin_Name3 = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Plugin_name3");
	String Class3  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Class3");
	
	String Name  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Name");
	String Value  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Value");
	String Configname=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Configname");
	String DB_UserName=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "DB_userid");	 
	String DB_Password=functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "DB_pwd");	  
	@Test
	 public void Securitycheck_Testcase() throws InterruptedException  {
		 driver.get(PolicyServiceURL);
		 functionalcomponents.WaitTillTime(2000);			 
		 test.log(Status.INFO, "Login into the Policy service with the valid credentilas ");
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesiger_UserName"), 70);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesiger_UserName"), username);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesigner_PassWord"), password);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_Logon"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 70); 
		 functionalcomponents.WaitTillTime(3000);
		 if(driver.findElement(By.xpath(properties.getProperty("Edgedesigner_tile"))).isDisplayed())
		 {
			 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
		 }
		 else 
		 {
			failedDescription("user is able to enter into the HOME page ");
		 }
		 //Click on the Edgedesigner tile
		 test.log(Status.INFO, "Click on Edge designer tile of the Home Page and capture the version of the Edge Designer");
		 //functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90); 
		 functionalcomponents.WaitTillTime(5000);		 
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 20); 			 
		 functionalcomponents.WaitTillTime(2000);
		 if(driver.findElement(By.xpath(properties.getProperty("Project_Addbutton"))).isDisplayed())
		 {	
			test.log(Status.PASS, "Edge desinger tile window opens successfully");
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
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Projectpname);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectpname+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(3000);	
		  String ProjectNameCreated=driver.findElement(By.xpath("//h1[contains(@id,'__header1-title')]//span[contains(text(),'"+Projectpname+"')]")).getText();
		  System.out.println(ProjectNameCreated);
		  if (ProjectNameCreated.equalsIgnoreCase("Project:"+" "+Projectpname))
		  {
              test.log(Status.PASS, "user is able to create Project with name:"+""+ProjectNameCreated+""+"and Group Description:"+""+projectdesc+""+"successfully");
		  } else
		  {
              failedDescription("user is not able to enter the  Project name and description in the window");
          }
		    
		  //creation of  sensor model
		  test.log(Status.INFO, "click on the Sensor Model tab and click on + button to add sensormodel to the project");		 
		  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Model"));
		  functionalcomponents.WaitTillTime(2000);				  
		  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_add"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Typedropdown"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.scrollToExact(properties.getProperty("SensorType_part1")+sensortype1+properties.getProperty("SensorType_part2"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("SensorType_part1")+sensortype1+properties.getProperty("SensorType_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Capability_Namedropdown"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation((properties.getProperty("capability_name_part1")+capablity1+properties.getProperty("capability_name_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Property_namecheckbox"));
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Create_averagereading_value"), average_value);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Sensor_modelcreate"));
		  functionalcomponents.WaitTillTime(2000);
		  String Sensor_msg=driver.findElement(By.xpath("//div[text()='Sensor Model creation successful.']")).getText();
		  System.out.println(Sensor_msg);
		  if (Sensor_msg.equalsIgnoreCase("Sensor Model creation successful."))
		  {
			  test.log(Status.PASS, "user is able to create the Sensor model in the project successfully");
		  }else
		  {
              failedDescription("user is not able to create the sensor model in the project ");
          }
		//Action
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
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_name"),Action_name1);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_description"),Action_desc);
		  if(driver.findElement(By.xpath(properties.getProperty("Action_Type_Dropdown"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to add the Action name"+":"+Action_name1+"Action description as"+":"+Action_desc+"With special characters successfully");
		  } else
		  {
              failedDescription("user is not able to add the Action name and Action Description");	              		 
		  }		
		 
		  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_Dropdown"));
		  functionalcomponents.WaitTillTime(2000);
			  test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1") +Action_Type1+ properties.getProperty("Action_Type_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Plugin_id_dropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Plugin_id_part1") +protocol_plugin+ properties.getProperty("Plugin_id_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Message"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_Type1+"protocol plugin as"+":"+protocol_plugin);
			  } else
			  {
	              failedDescription("user is not able to select the Action type as"+":"+Action_Type1+"protocol plugin as "+":"+protocol_plugin);	              		 
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
			  functionalcomponents.ClickOperation(properties.getProperty("Action_create"));
			  functionalcomponents.WaitTillTime(2000);
			  
			  //creation of rule
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
			  
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_name"),Rulename);
			 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Rule_Description"),Ruledesc);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Rule_enabled_button"));
			  
			  if(driver.findElement(By.xpath(properties.getProperty("Rule_name"))).isDisplayed())
			  {	
				  test.log(Status.PASS, "Rule name as"+Rulename+":"+ "saved successfully with special characters");
			  }
			  else 
			  {
				  failedDescription(" Rule name as"+Rulename+":"+ "is not saved successfully with special characters");
		  	  }
			  test.log(Status.INFO, "Click on the create button to create the rule");
			  
			  functionalcomponents.ClickOperation(properties.getProperty("Rule_Create"));
			  functionalcomponents.WaitTillTime(3000);
			  if(driver.findElement(By.xpath(properties.getProperty("Rules"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to add the rulename"+Rulename+""+"description"+""+Ruledesc);
			  } else
			  {
	              failedDescription("user is not able to add the rulename and description");
		 
			  }
			  //Add Rest plugins
			  test.log(Status.INFO, "click on the Plugin tab to add the Rest plugins");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Plugin_Addimg"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugin_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Pluginname"), 70);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_Pluginname"), Plugin_Name); 
			  functionalcomponents.WaitTillTime(2000);			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1") +Class+ properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MaximumQueueSize"), "1"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("WebSocketURI"), "http"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(2000);
			  String Pluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name+"')]")).getText();
			  if(Pluginname.equalsIgnoreCase(Plugin_Name))
			  {
				  test.log(Status.PASS, "user is able to create the Rest Plugin name in the project with:"+Pluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the plugin in the project ");
	          }	
			  test.log(Status.INFO, "click on the Plugin and add the optional parameters");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1") +Plugin_Name+ properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			  functionalcomponents.WaitTillTime(4000); 
			  // Add Basic AuthPassword
			  test.log(Status.INFO, "click on the Rest Plugin and add the optional parameter Basic Auth Password");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
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
			  test.log(Status.INFO, "click on add the optional parameter KeyManager Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1") +Keymanagerpassoword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1") +Keymanagerpassoword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  test.log(Status.INFO, "click on the Plugin and add the optional parameter KeyStore Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  test.log(Status.INFO, "click on the Plugin and add the optional parameter Truststore Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  driver.navigate().refresh();			
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_search_input"), 70);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Projectpname);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectpname+properties.getProperty("Project_title_part2")));
			  functionalcomponents.WaitTillTime(3000);	
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			 // Add MQTTEnterprise Plugin 
			  test.log(Status.INFO, "click on the Plugin tab to add the MQTT Enterprise plugins");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Plugin_Addimg"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugin_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Pluginname"), 70);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_Pluginname"), Plugin_Name1); 
			  functionalcomponents.WaitTillTime(2000);			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class1+ properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), "1"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTHost"), "MQTTHOST"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTPort"), "4040"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTPublishing"), "Anyvalue"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name1);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(5000);
			  String MQTTPluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name1+"')]")).getText();
			  if(MQTTPluginname.equalsIgnoreCase(Plugin_Name1))
			  {
				  test.log(Status.PASS, "user is able to create the MQTT Plugin name in the project with:"+MQTTPluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the plugin in the project ");
	          }	
			  test.log(Status.INFO, "click on the Plugin and add the optional parameters");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1") +Plugin_Name1+ properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			  functionalcomponents.WaitTillTime(4000);
			  //Basic MQTT Keyword
			  String ClientPassword="Client Password";
			  // Add Basic AuthPassword
			  test.log(Status.INFO, "click on the Rest Plugin and add the optional parameter Basic Auth Password");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1") +ClientPassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1") +ClientPassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
	              failedDescription("password is not masked ");
	          }	
			  // Add KeyStore password
			  test.log(Status.INFO, "click on the Plugin and add the optional parameter KeyStore Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  test.log(Status.INFO, "click on the Plugin and add the optional parameter Truststore Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  
			  driver.navigate().refresh();			
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_search_input"), 70);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Projectpname);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectpname+properties.getProperty("Project_title_part2")));
			  functionalcomponents.WaitTillTime(3000);	
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
		      // Add WebSocket Enterprise Plugin
			  
			  test.log(Status.INFO, "click on the Plugin tab to add the WebSocket Enterprise plugins");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Projectname_link_part1") +Projectpname+ properties.getProperty("Security_Projectname_link_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Plugin_Addimg"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugin_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Pluginname"), 70);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_Pluginname"), Plugin_Name2); 
			  functionalcomponents.WaitTillTime(2000);			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class2+ properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), "1"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("WebSocketURI"), "http"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name2);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(2000);
			  String WebsocketPluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name2+"')]")).getText();
			  if(WebsocketPluginname.equalsIgnoreCase(Plugin_Name2))
			  {
				  test.log(Status.PASS, "user is able to create the Websocket Enterprise Plugin name in the project with:"+WebsocketPluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the plugin in the project ");
	          }	
			  test.log(Status.INFO, "click on the Plugin and add the optional parameters");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1") +Plugin_Name2+ properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			  functionalcomponents.WaitTillTime(4000);
			  
			  // Add Basic AuthPassword
			  test.log(Status.INFO, "click on the Rest Plugin and add the optional parameter Basic Auth Password");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+BasicAuthpassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  test.log(Status.INFO, "click on add the optional parameter KeyManager Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keymanagerpassoword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keymanagerpassoword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  test.log(Status.INFO, "click on the Plugin and add the optional parameter KeyStore Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Keystorepassword+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			  test.log(Status.INFO, "click on the Plugin and add the optional parameter Truststore Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+Truststorepassword+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
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
			 
			  driver.navigate().refresh();			
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("edge_search_input"), 70);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Projectpname);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Projectpname+properties.getProperty("Project_title_part2")));
			  functionalcomponents.WaitTillTime(3000);	
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			//Add HDFSEnterprisePlugins
  
			  test.log(Status.INFO, "click on the Plugin tab to add the WebSocket Enterprise plugins");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Projectname_link_part1") +Projectpname+ properties.getProperty("Security_Projectname_link_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Plugin_Addimg"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugin_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Pluginname"), 70);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_Pluginname"), Plugin_Name3); 
			  functionalcomponents.WaitTillTime(2000);			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class3+ properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), "1"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTHost"), "HDFSHost"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("MQTTPort"), "8080"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("HDFSUsername"), "Anyvalue"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("HDFSFilepath"), "Anyvalue"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("HDFSColumnValues"), "Anyvalue"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), Plugin_Name3);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(4000);
			  String HDFSPluginname=driver.findElement(By.xpath("//a[contains(text(),'"+Plugin_Name3+"')]")).getText();
			  if(HDFSPluginname.equalsIgnoreCase(Plugin_Name3))
			  {
				  test.log(Status.PASS, "user is able to create the HDFS Enterprise Plugin name in the project with:"+HDFSPluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the plugin in the project ");
	          }	
			  test.log(Status.INFO, "click on the Plugin and add the optional parameters");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Pluginlink_part1")+Plugin_Name3+ properties.getProperty("Security_Pluginlink_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters"));
			  functionalcomponents.WaitTillTime(4000);
			  //Basic HDFS Keyword
			  String DelegationToken="Delegation Token";
			  String OAuth2Token="OAuth2 Token";
			 
			  // Add Delegation Token
			  test.log(Status.INFO, "click on the Rest Plugin and add the optional parameter Basic Auth Password");
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+DelegationToken+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+DelegationToken+ properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String HDFSDelegationvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+DelegationToken+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(BasicAuthpwd);
			  if(HDFSDelegationvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Basic Auth password is masked as"+HDFSDelegationvalue);		
				  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	
			  //Add Oauth2Token
			  test.log(Status.INFO, "click on add the optional parameter KeyManager Password");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Add_optioanlparam"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_optionalparameters"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_Arrow"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.scrollToExact(properties.getProperty("Security_optionalparameters_name_part1")+OAuth2Token+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_name_part1")+OAuth2Token+properties.getProperty("Security_optionalparameters_name_part2"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_optionalparameters_Value"), Value); 
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_optionalparameters_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  String HDFSOauth2Tokenvalue=driver.findElement((By.xpath(properties.getProperty("Security_valuepart1")+OAuth2Token+properties.getProperty("Security_valuepart2")))).getText();
			  System.out.println(Keymanagerpwd);
			  if(HDFSOauth2Tokenvalue.contains("**"))
			  {
				  test.log(Status.PASS, "Key Manager password is masked as"+HDFSOauth2Tokenvalue);		
				  }
			  else
			  {
	              failedDescription("password is not masked ");
	          }	 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Projectname_link_part1") +Projectpname+ properties.getProperty("Security_Projectname_link_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			  //Project ValidateandPublish
			  
			  ProjectValidateandPublish(Configname, Projectpname);
			  
			 //DOWNLOAD THE CONFIGURATION
			  test.log(Status.INFO, "Click on the SAP logo>>Gageway management to add the configuration");
			  functionalcomponents.WaitTillTime(7000);
			  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateway_management"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
			  functionalcomponents.WaitTillTime(5000);		 
			  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streaming_service_services"), 70); 
			  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service_services"));
			  functionalcomponents.WaitTillTime(4000);
			  if (driver.findElement(By.xpath(properties.getProperty("Configurations_streaming"))).isDisplayed()) 
			  {
	              test.log(Status.PASS, "user is able to see the Steaming services window opened in the work center");
			  } else
			  {
	              failedDescription("user is able to see the Steaming services window opened in the work center ");
	          } 
			  test.log(Status.INFO, "Downloaded json file is successfully store in th foloder");
			  functionalcomponents.ClickOperation(properties.getProperty("Configurations_streaming"));
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Streamingsearch"), Configname);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Steamingsearchbtn"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation((properties.getProperty("Security_configlink1")+Configname+properties.getProperty("Security_configlink2")));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_config_download"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_config_download"));
			  functionalcomponents.WaitTillTime(3000);
			  if (driver.findElement(By.xpath(properties.getProperty("Security_config_download"))).isDisplayed()) 
			  {
	              test.log(Status.PASS, "user is able to see the json file as well as able to download successfully in the UI");
			  } else
			  {
	              failedDescription("user is not able to see the json file as well as able to download successfully in the UI");
	          } 
			  
			  // Validate the json file 
			  test.log(Status.INFO, "Validate json file with Stored value password for all enterprise plugins");
			  //String Passwordvalue  = functionalcomponents.getdatafromsheet("1905", "SecurtiyTest_Case", "Value");
			  String[] values = Securitycheck.GetDatafromDownlodedJeson(Configname);
			  for(String i:values)
		      {
				  System.out.println(i);
				//  if(i.contains(Passwordvalue))
				  test.log(Status.PASS, "user should able to see the password value as mask in downloaded json file"+i);
		      }
			  
			  
			  //Deployment Configuration
			  ConfigDeployment(Configname, Projectpname, Gatewayno);
			  
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
}
	
	public static String[] GetDatafromDownlodedJeson(String JsonConfigFileName)
	   {
		String[] values = new String[13];
   		String JsonPath=System.getProperty("user.dir")+"/ExportImportFolder/"+JsonConfigFileName+"-1.0.json";
   		System.out.println(JsonPath);
      try
      {
    	 JSONParser parser = new JSONParser();
    	 FileReader reader = new FileReader(JsonPath);
     	JSONObject jo = (JSONObject) parser.parse(reader);
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





