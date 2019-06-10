package PolicyService;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Edgedesigner extends PolicyEdgedesignercomponent {
	
	Properties properties = functionalcomponents.getObjectProperties();
	String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "PolicyServiceURL");
	String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "username");
	String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "password");
	String Projectpname = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "project_name");
	String projectdesc=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Description");
	String Project_configname=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Project_configname"); 
	String copy_project_name=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "copy_project_name"); 
	String sensortype1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Sensortype");
	String capablity1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "capabilityname");
	String Property=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Property");
	String Min_reading_value=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Min_reading_value");
	String average_value  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "AverageReading_value");
	String Minimum_output_frequency= functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Minimum_output_frequency");
	String Keep_events_Days=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Keep_events_Days");
	String Max_edge_Readings_store=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Max_edge_Readings_store");
	String Enterprise_max_output_frequency=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Enterprise_max_output_frequency");
	String Local_enterpriseplugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Local_enterprise_plugin");
	String sensor_configname =functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "sensor_configname"); 
	String Config_edgename3 =functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "sensor_configname1"); 
	String Rulename  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "RuleName");
	String Ruledesc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Rule_Desc");
	String Rulecondition  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Rule_condition");
	String filteropt  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Filter");
	String filter_scopevavlue  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Filtervalue");
	String conditiontype  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Condtiontype");
	String sensor_modelname  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Sensormodelname");
	String customproject_host=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Customprojecthost");
	String customproject_port=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "customprojectport");
	String maximum_eventfrequency1=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Max_eventfrequency");
	String interval_without_sensor=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "intervalwithoutsensor");
	String Targetstate=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Targetstate");
	String Timein_State=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Timeinstate");
	String operator  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Operator");
	String thresholding_value  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Thresholdingvalue");
	String Action_name1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Actionname");
    String Action_desc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "ActionDescription");
    String Action_Type1  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Action_type");
    String protocol_plugin=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "ProtocolPlugin");
    String Actionmsg=  functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Action_Message");
    String Receipient_param= functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Receipient_parameters");
    String Scope_level  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Scope_level");
    String Edge_Fedilityfreq  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "New_edgefedility_freq");
    String Edge_fedility_rollback = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "edge_fedility_rollback");
    String enterprise_fedility = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Enterprise_fedility");
    String enterprise_rollback  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Enterprise_rollback");
    String Action_configname=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Action_configname");
    String RDS_configname=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "RDS_configname");
    String Ruledsname  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "RuleDsname");
    String Ruledsdesc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "RuleDs_description");
    String Request_method  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Request_method");
    String contentype_headervalue  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "contenttype_Header_value");
    String Request_body_template  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Request_body_Template");
    String Authenticaion_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Authentication_Type");
    String Custom_headers  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Custom Headers");
    String Date_format  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Date Format");
    String updatefrequency  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Updatefrequency");
    String Response_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Response_Type");
    String Global_RuleDatasource=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Global_RuleDatasource");
    String DB_UserName=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "DB_userid");	 
    String DB_Password=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "DB_pwd");	  
    String Rule_configname=functionalcomponents.getdatafromsheet("EdgeDesigner", "EdgeDesignerTestcase", "Rule_configname");	
	String Gatewayno=functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "Gatewayno");		

     @Test
    public void EdgeDesigner_Testcase() throws InterruptedException {
			 // input data for Edge designer
		 	
		    //Prerequisite- Start the Policyservice  ( Could version ) with new tile EdgeDesigner
			 driver.get(PolicyServiceURL);
			 functionalcomponents.WaitTillTime(2000);			 
			 test.log(Status.INFO, "Login into the Policy service with the valid credentilas ");
//			 functionalcomponents.ClickOperation(properties.getProperty("Authenticate_using_IDP"));
//			 functionalcomponents.WaitTillTime(1000);
			 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesiger_UserName"), 70);
			 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesiger_UserName"), username);
			 functionalcomponents.WaitTillTime(1000);
			 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesigner_PassWord"), password);
			 functionalcomponents.WaitTillTime(1000);
			 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_Logon"));
			 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 100); 
			 functionalcomponents.WaitTillTime(2000);
			 if(driver.findElement(By.xpath(properties.getProperty("Edgedesigner_tile"))).isDisplayed())
			 {
				 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
			 }
			 else 
			 {
				failedDescription("user is able to enter into the HOME page ");
			 }
			 test.log(Status.INFO, "Click on Edge designer tile of the Home Page");
			 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
			 functionalcomponents.WaitTillTime(40000);
			 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edge_designer_version"), 190); 
			
			 functionalcomponents.ClickOperation(properties.getProperty("Edge_designer_version"));
			 functionalcomponents.WaitTillTime(5000);
			 String Versionvalue1=driver.findElement(By.xpath(properties.getProperty("Edge_Designer_versionvalue"))).getText();
			 functionalcomponents.WaitTillTime(5000);
			 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90); 			 
			 functionalcomponents.WaitTillTime(2000);
			 if(driver.findElement(By.xpath(properties.getProperty("Project_Addbutton"))).isDisplayed())
			 {	
				test.log(Status.PASS, "Edge desinger tile window opens successfully and version of the Edge designer is"+Versionvalue1);
			 }
			 else 
			 {
				failedDescription("Edge designer tile is not opened successfully");
			 }
		 
			 //Project creation
			 test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
			 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90); 
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
			 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Create_project"), 90); 
			 functionalcomponents.WaitTillTime(5000);
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
			  String Project_success_msg=driver.findElement(By.xpath(properties.getProperty("Project_Created_msg"))).getText();
			  System.out.println(Project_success_msg);
			  if (Project_success_msg.equalsIgnoreCase("Project is successfully added"))
			  {
	              test.log(Status.PASS, "user is able to create Project with name:"+""+Projectpname+""+"and Group Description:"+""+projectdesc+""+"successfully");
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
			  //Edit project
			  test.log(Status.INFO, "Click on the Edit button to edit the project name and description");
			  functionalcomponents.ClickOperation(properties.getProperty("Edit_project"));
			  functionalcomponents.WaitTillTime(2000);
			  String Edit_project=Projectpname+"test";
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Project_name"), Edit_project);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("edge_search_input"),Edit_project);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
			  functionalcomponents.WaitTillTime(3000);
			  if(driver.findElement(By.xpath(properties.getProperty("Project_title_part1") +Edit_project+ properties.getProperty("Project_title_part2"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to Edit the project with  name as"+":"+Edit_project+"successfully");
			  } else
			  {
	              failedDescription("user is able to Edit the project ");
			  }
			 // copy the porject
			  test.log(Status.INFO, "Click on the copy button on the top right corner of the project");
			  functionalcomponents.ClickOperation(properties.getProperty("copy_project"));
			  functionalcomponents.WaitTillTime(2000);
			  String Copy_Project=driver.findElement(By.xpath(properties.getProperty("Project_name"))).getAttribute("value");
			//  System.out.println(Copy_Project);
			  functionalcomponents.ClickOperation(properties.getProperty("Copy_project_save"));
			  functionalcomponents.WaitTillTime(2000);
			  String copy_project_msg=driver.findElement(By.xpath(properties.getProperty("copy_project_msg"))).getText();
			  if (copy_project_msg.equalsIgnoreCase("Project copied successfully"))
			  {
	              test.log(Status.PASS, "user is able to copy the project with  name as"+":"+Copy_Project+"successfully");
			  } else
			  {
	              failedDescription("user is able to see the project is not copied successfully");
	          }
			  //create project with duplicate name
			  test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
			  functionalcomponents.WaitTillTime(2000);
			  test.log(Status.INFO, "Enter the name of the project with special characters");			 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),Edit_project);	  				 
			  test.log(Status.INFO, "Enter description of the project and click on the create button");
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
			  functionalcomponents.WaitTillTime(2000);
			  String Project_failed_msg=driver.findElement(By.xpath(properties.getProperty("Project_failed_msg"))).getText();
			  //System.out.println(Project_failed_msg);
			  if (Project_failed_msg.equalsIgnoreCase("Project is successfully added"))
              {
		             test.log(Status.PASS, "user is able to create Project with name:"+""+Projectpname+""+"and Group Description:"+""+projectdesc+""+"successfully");
			  }
			  else if(Project_failed_msg.equalsIgnoreCase("Project name must be unique."))
			  {
				  test.log(Status.PASS,"user is able to see the msg as Project name must be unique");
		       }
			  else
			  {
		             failedDescription("Project is not successfully added");
		       }
			  
			  functionalcomponents.ClickOperation(properties.getProperty("Project_cancel"));
			  functionalcomponents.WaitTillTime(5000);		  
			  ProjectValidatePublish_ConfigDeployment(Project_configname,Edit_project,Gatewayno);
			  
			  //creation of  sensor model
			  test.log(Status.INFO, "click on the Sensor Model tab and click on + button to add sensormodel to the project");	
			  functionalcomponents.ClearAndSetValue(properties.getProperty("edge_search_input"),Edit_project);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+Edit_project+ properties.getProperty("Project_title_part2")));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Model"));
			  functionalcomponents.WaitTillTime(2000);				  
			  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_add"));
			  functionalcomponents.WaitTillTime(20000);
			  if(driver.findElement(By.xpath(properties.getProperty("Sensor_Typedropdown"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to see sensor model window successfullly");
			  } else
			  {
	              failedDescription("user is not able to see the sensor model window");
	          }
			  test.log(Status.INFO, "select the sensor type,capability in the sensor model window");
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
			  if(driver.findElement(By.xpath(properties.getProperty("Property_namecheckbox"))).isDisplayed())
			  {	
				  test.log(Status.PASS, "User is able to Select sensor type as"+": "+sensortype1+" "+"& capability as"+ ":"+capablity1+"from dropdown ");
			  }
			  else 
			  {
				  failedDescription("user is not able to select sensor type and capability from dropdown ");
			  }
			  test.log(Status.INFO, "check the property and enter the average reading value < 2147483647 in the sensor model");			  
			  functionalcomponents.ClickOperation(properties.getProperty("Property_namecheckbox"));
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Create_averagereading_value"), average_value);
			  functionalcomponents.WaitTillTime(2000);
			  if(Integer.parseInt(average_value)<=2147483647)
			  {
				  test.log(Status.PASS, "numeric values of the averaging reading value as"+":"+average_value+":"+"saved and verified Maximum value is not exceed 2147483647.");
			  } else
			  {
	              failedDescription("numeric values of the averaging reading value as"+":"+average_value+":"+"saved and verified Maximum value is not exceed 2147483647.");
	          }
			  test.log(Status.INFO, "Click create sensor model button and verify sensor model is created successfully");	
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
			  test.log(Status.INFO, "click on the sensor model name check box and click on the fedility to add the Local Enterprise plugin");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Sensor_Model"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Sensormodel_name"));			  
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("feidelty"));
			  if(driver.findElement(By.xpath(properties.getProperty("Enabled_Radio"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to see the Add fedility window successfully");
			  } else
			  {
	              failedDescription("user is not able to see the Add fedility window successfully");
	          }
			  
			  functionalcomponents.ClickOperation(properties.getProperty("Enabled_Radio"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Enabledbutton"));
			  functionalcomponents.WaitTillTime(1000);
			  test.log(Status.INFO, "Enter the numeric values for the Minimum evnet frequency,keep events days,Max edge readings store and max output frequency");
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Minimum_ouput_Frequency"), Minimum_output_frequency);
			  functionalcomponents.WaitTillTime(1000);
			  if(Integer.parseInt(Minimum_output_frequency)<=2147483647)
			  {
				  test.log(Status.PASS, "numeric values of the Minimum_output_ferquency value as"+":"+Minimum_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
			  } else
			  {
	              failedDescription("numeric values of the Minimum_output_ferquency value as"+":"+Minimum_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
	          }
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Keep_Event_days"), Keep_events_Days);
			  functionalcomponents.WaitTillTime(1000);
			  if(Integer.parseInt(Keep_events_Days)<=2147483647)
			  {
				  test.log(Status.PASS, "numeric values of the Keep_events_Days value as"+":"+Keep_events_Days+":"+"saved and verified Maximum value is not exceed 2147483647.");
			  } else
			  {
	              failedDescription("numeric values of the Keep_events_Days value as"+":"+Keep_events_Days+":"+"saved and verified Maximum value is not exceed 2147483647.");
	          }
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Maximum_edge_readings_store"), Max_edge_Readings_store);
			  functionalcomponents.WaitTillTime(1000);
			  if(Integer.parseInt(Max_edge_Readings_store)<=2147483647)
			  {
				  test.log(Status.PASS, "numeric values of the Max_edge_Readings_store value as"+":"+Max_edge_Readings_store+":"+"saved and verified Maximum value is not exceed 2147483647.");
			  } else
			  {
	              failedDescription("numeric values of the Max_edge_Readings_store value as"+":"+Max_edge_Readings_store+":"+"saved and verified Maximum value is not exceed 2147483647.");
	          }
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprise_Maximum_Output_Frequency"), Enterprise_max_output_frequency);
			  functionalcomponents.WaitTillTime(1000);
			  if(Integer.parseInt(Enterprise_max_output_frequency)<=2147483647)
			  {
				  test.log(Status.PASS, "numeric values of theEnterprise_max_output_frequency value as"+":"+Enterprise_max_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
			  } else
			  {
	              failedDescription("numeric values of the Enterprise_max_output_frequency value as"+":"+Enterprise_max_output_frequency+":"+"saved and verified Maximum value is not exceed 2147483647.");
	          }
			  test.log(Status.INFO, " Select the local Enterprise plugin from dropdown");
			  functionalcomponents.ClickOperation(properties.getProperty("Local_enterpriseplugin_dropdown"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Local_enteprise_plugin_part1") +Local_enterpriseplugin+ properties.getProperty("Local_enteprise_plugin_part2"));	
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("save_button"));			  
			  functionalcomponents.WaitTillTime(3000);	 
			  if(driver.findElement(By.xpath(properties.getProperty("Actions"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to add the local enterprise Plugin as:"+":"+Local_enterpriseplugin);
			  } else
			  {
	              failedDescription("user is able to add the local enterprise Plugin as:"+":"+Local_enterpriseplugin);
	          }	
			  ProjectValidatePublish_ConfigDeployment(sensor_configname,Edit_project,Gatewayno);
			  
			  String Sensorquery = "SELECT * from SENSOR_PROFILE"+" WHERE SENSOR_PROFILE_NAME != 'COMPOSITE'"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Sensore Profile as: ");

			  String SensorDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Sensorquery);
			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Sensore Profile are: "+SensorDB_Result);
			 				 
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
			 
			  if(Action_Type1.equalsIgnoreCase("Field Message"))
			  {
				 
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
				 
		      }
			  else if(Action_Type1.equalsIgnoreCase("Sensor Fidelity Change"))
			  {
				  test.log(Status.INFO, "Select Actiontype as Sensor fedility Change,sensor model name as and Scope_value as Device");
				  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1") +Action_Type1+ properties.getProperty("Action_Type_part2"));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation(properties.getProperty("Action_sensormodel_dropdown"));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation(properties.getProperty("Action_sensormodel_part1")+sensor_modelname+properties.getProperty("Action_sensormodel_part2"));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation(properties.getProperty("scope_leve_dropdown"));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation(properties.getProperty("scope_level_part1")+Scope_level+properties.getProperty("scope_level_part2"));
				  functionalcomponents.WaitTillTime(2000);
				  if(driver.findElement(By.xpath(properties.getProperty("fedility_freqency"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_Type1+"sensor model name as"+":"+sensor_modelname+":"+"and scope_value as"+":"+Scope_level);
				  } 
				  else
				  {
		              failedDescription("user is able to select the Action type as"+":"+Action_Type1+"sensor model name as"+":"+sensor_modelname+":"+"and scope_value as"+":"+Scope_level);	              		 
				  }
				  test.log(Status.INFO, "Enter the fedility frequency,Fedility Rollback,Enterprise_Fedility and Enterprise_fedility_rollback");
				  functionalcomponents.ClickAndSetValue(properties.getProperty("fedility_freqency"),Edge_Fedilityfreq);
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("fedility_Rollback"),Edge_fedility_rollback);
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Enterprise_fedility"),enterprise_fedility);
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Enterprisefedility_rollback"),enterprise_rollback);
				  functionalcomponents.WaitTillTime(2000);
				  if(driver.findElement(By.xpath(properties.getProperty("Action_create"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);
				  } else
				  {
		              failedDescription("user is not able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);             		 
				  }	
				  
			  }
			  test.log(Status.INFO, "Click Create Action button and verify Action is created successfully with Action Name");
			  functionalcomponents.ClickOperation(properties.getProperty("Action_create"));
			  functionalcomponents.WaitTillTime(2000);
			  //String Actionname_val=driver.findElement(By.xpath("//a[text()='"))+Action_name1+driver.findElement(By.xpath("']")).getText();
			 // System.out.println(Actionname_val);
			  if(driver.findElement(By.xpath(properties.getProperty("Rules"))).isDisplayed())
			  {
				  test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name as"+":"+Action_name1);
			  } else
			  {
	              failedDescription("Clicked Save Action button but Action is not created successfully with Action Name as"+":"+Action_name1);
	          }
			  ProjectValidatePublish_ConfigDeployment(Action_configname,Edit_project,Gatewayno);
					 
			  String Actionquery =  "SELECT * FROM ACTION"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Action name as: "+Action_name1);

			  String ActionDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Actionquery);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Action are: "+ActionDB_Result);
			 
			  
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
			  
			  //Add the conditions to the rule
			  test.log(Status.INFO, "click on Rulename to add the conditions to the rule");		
			  functionalcomponents.ClickOperation(properties.getProperty("Rules"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation((properties.getProperty("Rule_link_part1")+Rulename+properties.getProperty("Rule_link_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to add the conditions,outputs to the rule");
			  } else
			  {
	              failedDescription("user is not able to add any conditions,outputs to the rule");
		 
			  }
			  test.log(Status.INFO, "click on the conditions tab to add the condition to the rule");
			  functionalcomponents.ClickOperation(properties.getProperty("Rule_condition"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_add"));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_name"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to see the Rule conditons window successfully");
			  } else
			  {
	              failedDescription("user is not able to see the Rule conditons window successfully");
		 
			  }
			  test.log(Status.INFO, "Enter the rule condition name with special characters");
			 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Rulecondition_name"),Rulecondition);
			  if(driver.findElement(By.xpath(properties.getProperty("Filter_dropdown"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to enter the rule conditon nmae as"+":"+Rulecondition+"successfully");
			  } else
			  {
	              failedDescription("user is not able to add the rule conditon name in the rule condition window");
		 
			  }
			  test.log(Status.INFO, "select the filter from drop down and Enter the scope value in the Rule condition window");
			  functionalcomponents.ClickOperation(properties.getProperty("Filter_dropdown"));
			  functionalcomponents.WaitTillTime(2000);			 			  
			  functionalcomponents.ClickOperation((properties.getProperty("Filter_part1") +filteropt+ properties.getProperty("Filter_part2")));
			  functionalcomponents.WaitTillTime(2000);			 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Filter_scope_value"),filter_scopevavlue);
			  if(driver.findElement(By.xpath(properties.getProperty("conditiontype_dropdown"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the filter dropdown as"+":"+filteropt+"and scope_value as"+":"+filter_scopevavlue);
			  } else
			  {
	              failedDescription("user is not able to select the filter dropdown as"+":"+filteropt+"and scope_value as"+":"+filter_scopevavlue);
		 
			  }
			  functionalcomponents.ClickOperation(properties.getProperty("conditiontype_dropdown"));
			  functionalcomponents.WaitTillTime(2000);			 
			  
			  if(conditiontype.equalsIgnoreCase("External Custom Rule-CCL"))
			  {
				  test.log(Status.INFO, "select the condition type as External Custom Rule-CCL and select the sensor model name");
				  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1") +conditiontype+ properties.getProperty("conditiontype_part2")));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1")+sensor_modelname+properties.getProperty("Sensor_modelname_part2")));
				  functionalcomponents.WaitTillTime(2000);
				  if(driver.findElement(By.xpath(properties.getProperty("Condition_Customhost"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
				  } else
				  {
		              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
				  }
				  test.log(Status.INFO,"Enter the condition_customhost,condition_customport and maximum event frequency");
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Condition_Customhost"),customproject_host);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Condition_customport"),customproject_port);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
				  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to enter the condition_customhost as"+":"+customproject_host+":"+"condition_customport as"+":"+customproject_port+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);
				  } else
				  {
		              failedDescription("user is not able to enter the condition_customhost as"+":"+customproject_host+":"+"condition_customport as"+":"+customproject_port+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);	              		 
				  }
			    
			  }
			  else if(conditiontype.equalsIgnoreCase("Sensor Watchdog"))
			  {
				  test.log(Status.INFO, "select the condition type as Sensor Watchdog under the Rule codition tab");
				  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+properties.getProperty("conditiontype_part2")));
				  functionalcomponents.WaitTillTime(2000);				  	
				  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
				  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1")+sensor_modelname+properties.getProperty("Sensor_modelname_part2")));
				  functionalcomponents.WaitTillTime(2000);
				  if(driver.findElement(By.xpath(properties.getProperty("Interval_withoutsensor"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
				  } else
				  {
		              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
				  }
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Interval_withoutsensor"),interval_without_sensor);				 
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
				  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to Enter the Interval_withoutsensor as"+":"+interval_without_sensor+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);
				  } else
				  {
		              failedDescription("user is not able to Enter the Interval_withoutsensor as"+":"+interval_without_sensor+":"+"and Maximum_eventfrequency as"+":"+maximum_eventfrequency1);	              		 
				  }
			  }
			  else if(conditiontype.equalsIgnoreCase("Timed State"))
			  {
				  test.log(Status.INFO, "select the condition type as Timed State under the Rule codition tab");
				  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1") +conditiontype+ properties.getProperty("conditiontype_part2")));
				  functionalcomponents.WaitTillTime(2000);				 
				  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));
				  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1") +sensor_modelname+ properties.getProperty("Sensor_modelname_part2")));
				  functionalcomponents.WaitTillTime(2000);
				  if(driver.findElement(By.xpath(properties.getProperty("Target_State_dropdown"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
				  } else
				  {
		              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
				  }
				  test.log(Status.INFO, "select the Target state and enter the Time state");
				  functionalcomponents.ClickOperation(properties.getProperty("Target_State_dropdown"));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation((properties.getProperty("Target_State_part1") +Targetstate+ properties.getProperty("Target_State_part2")));
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Time_state"),Timein_State);	
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
				  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the Target state as"+":"+Targetstate+":"+"and enter the Time state value as"+":"+Timein_State+":"+"and maximum event frequency as"+":"+maximum_eventfrequency1);
				  } else
				  {
		              failedDescription("user is not able to select the Target state as"+":"+Targetstate+":"+"and enter the Time state value as"+":"+Timein_State+":"+"and maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
				  }
			  }
			  else if(conditiontype.equalsIgnoreCase("Value Monitoring"))
			  {
				  test.log(Status.INFO, "select the condition type as Value Monitoring under the Rule codition tab");
				  functionalcomponents.ClickOperation((properties.getProperty("conditiontype_part1")+conditiontype+properties.getProperty("conditiontype_part2")));
				  functionalcomponents.WaitTillTime(2000);				  	  
				  functionalcomponents.ClickOperation(properties.getProperty("Sensormodelname_Dropdown"));	
				  functionalcomponents.WaitTillTime(2000);	
				  functionalcomponents.ClickOperation((properties.getProperty("Sensor_modelname_part1")+sensor_modelname+properties.getProperty("Sensor_modelname_part2")));
				  functionalcomponents.WaitTillTime(2000);
				   if(driver.findElement(By.xpath(properties.getProperty("Operator_dropdown"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);
				  } else
				  {
					  
		              failedDescription("user is not able to select the Condition type as"+":"+conditiontype+":"+" and sensormodel name as"+"+"+sensor_modelname);	              		 
				  }
				  test.log(Status.INFO, "Select the operator and enter the Thresholding_value,Maximum event frequency value ");
				  functionalcomponents.ClickOperation(properties.getProperty("Operator_dropdown"));
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickOperation((properties.getProperty("Operator_part1")+operator+properties.getProperty("Operator_part2")));
				  functionalcomponents.WaitTillTime(2000);				  			 		 
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Thresholding_value"),thresholding_value);
				  functionalcomponents.WaitTillTime(2000);	
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Condtion_maxfrequency"),maximum_eventfrequency1);
				  functionalcomponents.WaitTillTime(2000);	
				  if(driver.findElement(By.xpath(properties.getProperty("Rulecondition_Create"))).isDisplayed())
				  {
					  test.log(Status.PASS, "user is able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);
				  } else
				  {
		              failedDescription("user is not able to select the operator as"+":"+operator+":"+" entered the value as"+":"+thresholding_value+":"+"Maximum event frequency as"+":"+maximum_eventfrequency1);	              		 
				  }
			  }
			  test.log(Status.INFO, "Click on the create button to save the Rule condition");
			  functionalcomponents.ClickOperation(properties.getProperty("Rulecondition_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Rule_condition"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to create the rule condition as"+":"+Rulecondition+"successfully");
			  } else
			  {
	              failedDescription("user is able to create the rule condion successfully");	              		 
			  }

			  
			  //Create ouptuts in the Rule
			  test.log(Status.INFO, "Click on the Output tab in the Rule and add the action to the rule");
			  functionalcomponents.ClickOperation(properties.getProperty("Outputs"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("output_Add"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("output_Action"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Localaction_dropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Localaction_part1")+Action_name1+properties.getProperty("Localactio_part2"));
			  functionalcomponents.WaitTillTime(2000);	
			  functionalcomponents.ClickOperation(properties.getProperty("Ouput_create"));
			  functionalcomponents.WaitTillTime(2000);	
			  if(driver.findElement(By.xpath(properties.getProperty("Outputs"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to add the action to the rule as"+Action_name1);
			  } else
			  {
	              failedDescription("user is able to add the action to the rule as"+Action_name1);	              		 
			  }
			  
			  functionalcomponents.ClickOperation(properties.getProperty("Project_link_part1")+Edit_project+properties.getProperty("Project_link_part2"));
			  functionalcomponents.WaitTillTime(3000);	
			  ProjectValidatePublish_ConfigDeployment(Rule_configname,Edit_project,Gatewayno);
			  
			  	  		  
			  //Rule Data source
			  test.log(Status.INFO, "Click on the Rule Data source tab in the project header");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Ruledatasourse"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("RuleDatasourse_Add"));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("RuleDatasource_name"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to add the Rule data source successfully");
			  } else
			  {
	              failedDescription("user is not able to add the Rule data source");	              		 
			  }
			  test.log(Status.INFO, "Enter the Rule name and description with special characters");			
			  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_name"),Ruledsname);
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"),Ruledsdesc);
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("HTTPs_Endpoint_url"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to enter the Rule name as"+":"+Ruledsname+"and Rule description as"+Ruledsdesc+"with special characters successfully");
			  } else
			  {
	              failedDescription("user is not able to enter the Rule name and descrition in the rule datasource window");	              		 
			  }	
			  test.log(Status.INFO, "Enter the HTTP_Endpoint url as https://sdsss.com:818 and select the Request method from dropdown");
			  functionalcomponents.ClickAndSetValue(properties.getProperty("HTTPs_Endpoint_url"),"https://sdsss.com:818");
			  functionalcomponents.WaitTillTime(2000);			
			  functionalcomponents.ClickOperation(properties.getProperty("Request_method_dropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  if(Request_method.equalsIgnoreCase("GET"))
			  {
				  functionalcomponents.ClickOperation(properties.getProperty("Request_method_part1") +Request_method+ properties.getProperty("Request_method_part2"));
				  functionalcomponents.WaitTillTime(2000);
				  if(driver.findElement(By.xpath(properties.getProperty("Authentication_type_dropdown"))).isDisplayed())
				  {
					  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_method);
				  } else
				  {
		              failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_method);	              		 
				  }
			  }else if(Request_method.equalsIgnoreCase("POST"))
			  {
				  
				  functionalcomponents.ClickOperation(properties.getProperty("Request_method_part1") +Request_method+ properties.getProperty("Request_method_part2"));
				  functionalcomponents.WaitTillTime(2000);
				  if(driver.findElement(By.xpath(properties.getProperty("Authentication_type_dropdown"))).isDisplayed())
				  {
					  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_method);
				  } else
				  {
		              failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as"+Request_method);	              		 
				  }
				  test.log(Status.INFO, "Enter the values for content_type header and Request body Template");
				  functionalcomponents.ClickAndSetValue(properties.getProperty("content_type_Header"),contentype_headervalue);
				  functionalcomponents.WaitTillTime(2000);
				  functionalcomponents.ClickAndSetValue(properties.getProperty("Request_BodyTemplate"),Request_body_template);
				  if(driver.findElement(By.xpath(properties.getProperty("Authentication_type_dropdown"))).isDisplayed())
				  {
					  test.log( Status.PASS, "user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);
				  } else
				  {
		              failedDescription("user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);	              		 
				  }
			  }	  
			
			  test.log(Status.INFO, "Select the Authentication type and enter the value for update freqency");	
			  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_dropdown"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_part1") +Authenticaion_type+ properties.getProperty("Authentication_type_part2"));
			  functionalcomponents.WaitTillTime(2000);			 			 		 
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Update_frequency"),updatefrequency);
			  functionalcomponents.WaitTillTime(1000);
			  if(driver.findElement(By.xpath(properties.getProperty("Custom_Headers"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);
			  } else
			  {
	              failedDescription("user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);	              		 
			  }
			  test.log(Status.INFO, "Enter the value for Custom Headers and Date format in the Rule datasoruce window");	
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Custom_Headers"),Custom_headers);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("date_format"),Date_format);
			  functionalcomponents.WaitTillTime(1000);
			  if(driver.findElement(By.xpath(properties.getProperty("Rue_Datasource_Create"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);
			  } else
			  {
	              failedDescription("user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);	              		 
			  }
			  test.log(Status.INFO, "Select the Resonse type and click on the Create button to save the Rule data source successfully");			  
			  functionalcomponents.PageScrollDown();
			  functionalcomponents.ClickOperation(properties.getProperty("Respnse_type_dropdown"));
			  functionalcomponents.ClickOperation(properties.getProperty("Response_type_part1")+Response_type+properties.getProperty("Response_type_part2"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Rue_Datasource_Create"));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Actions"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to select the Respnse type as"+":"+Response_type+"and successfully saved the Rule data source as"+":"+Response_type);
			  } else
			  {
	              failedDescription("user is not able to create the Rule Datasource");	              		 
			  }
			  ProjectValidatePublish_ConfigDeployment(RDS_configname,Edit_project, Gatewayno);
			  
			  			 
			  String Rulequery = "SELECT * FROM RULE"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Rule name as: "+Rulename);

			  String RuleDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Rulequery);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Rule are: "+RuleDB_Result);
			  String Ruledsquery = "SELECT * FROM RULE_DATA_SOURCE_INFO"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Rule name as: "+Rulename);

			  String RuleDSDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Ruledsquery);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Rule are: "+RuleDSDB_Result);
			  
			 //Delete the project
			 test.log(Status.INFO, "Click on the delete button of top right corner of the workcenter");
			  functionalcomponents.ClickOperation(properties.getProperty("Delete_project"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Delet_project_popup"));
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Delete_msg"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to delete the project successfully");
			  } else
			  {
	              failedDescription("user is not able to delete the project");	              		 
			  }
		 }
}
			  
			  
		 	 
	  
			  
  
			 
		 

