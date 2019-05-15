package PolicyService;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SDSEnterprisePlugin extends PolicyEdgedesignercomponent {
	
	Properties properties = functionalcomponents.getObjectProperties();
	String Streamingusername = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Stream_username");
	String Streamingpassword = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Stream_password");
   
	String PolicyServiceURL = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "PolicyServiceURL");
	String username = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "username");
	String password = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "password");
	String Projectpname = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "project_name");
	String projectdesc=functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Description");
	String sensortype1  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Sensortype");
	String capablity1  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "capabilityname");
	String Property=functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Property");
	String Min_reading_value=functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Min_reading_value");
	String average_value  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "AverageReading_value"); 
	String Action_name1  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Actionname");
    String Action_desc  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "ActionDescription");
    String Action_Type1  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Action_type");
    String protocol_plugin=functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "ProtocolPlugin");
    String Actionmsg=  functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Action_Message");
    String Receipient_param= functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Receipient_parameters");
    String Rulename  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "RuleName");
	String Ruledesc  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Rule_Desc");
	String Rulecondition  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Rule_condition");
	String filteropt  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Filter");
	String filter_scopevavlue  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Filtervalue");
	String conditiontype  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Condtiontype");
	String sensor_modelname  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Sensormodelname");
	
	String pluginName  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Plugin_name");
	String Class  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Class");
	String LoggerLevel  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "LoggerLevel");
	String URI  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "URI");
	String BasicAuthUsername  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "BasicAuthUsername");
	String BasicAuthPassword  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "BasicAuthPassword");
	String Workspace  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Workspace");
	String Project  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Project");
	String InputStream  = functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "InputStream");
    String Gatewayno=functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Gatewayno");
    String configname=functionalcomponents.getdatafromsheet("1905", "SDSEnterprisePluginFlow", "Configname");
	@Test
	 public void SDSEnterprisePluginFlow() throws InterruptedException  {
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
		  String ProjectNameCreated=driver.findElement(By.xpath("//span[contains(text(),'"+Projectpname+"')]")).getText();
		  System.out.println(ProjectNameCreated);
		  if (ProjectNameCreated.equalsIgnoreCase(Projectpname))
		  {
              test.log(Status.PASS, "user is able to create Project with name:"+""+ProjectNameCreated+""+"and Group Description:"+""+projectdesc+""+"successfully");
		  } else
		  {
              failedDescription("user is not able to enter the  Project name and description in the window");
          }
		  functionalcomponents.ClickOperation(properties.getProperty("Refresh_button"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Projectpname);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1") +Projectpname+ properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(3000);
		  
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
			  // Add SDS Enterprise Plugin
			  test.log(Status.INFO, "click on the Plugin tab to add the Rest plugins");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_plugin"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Plugin_Addimg"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugin_Addimg"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Security_Pluginname"), 70);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_Pluginname"), pluginName); 
			  functionalcomponents.WaitTillTime(2000);			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1") +Class+ properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), "1"); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("LogerLevel_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("LogerLevel_part1")+LoggerLevel+ properties.getProperty("LogerLevel_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("WebSocketURI"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSBasicAuthUsername"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSBasicAuthPassword"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSWorkSpace"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSProject"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSInputStream"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Security_plugin_searchinput"), pluginName);
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(2000);
			  String Pluginname=driver.findElement(By.xpath("//a[contains(text(),'"+pluginName+"')]")).getText();
			  if(Pluginname.equalsIgnoreCase(pluginName))
			  {
				  test.log(Status.PASS, "user is able to create the Rest Plugin name in the project with:"+Pluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the plugin in the project ");
	          }	
			  
			  
			  //validate project & publish
			  ProjectValidatePublish_ConfigDeployment(configname,Projectpname, Gatewayno);
			  
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
			  
	
	}
}
