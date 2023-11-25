package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class SDSOutBoundConnectorAddingtoProject_PublishedProjectandVerifiedOutboundConnectortoStreamingLocalHost extends PolicyEdgedesignercomponent {
	
	Properties properties = functionalcomponents.getObjectProperties();
	
	String EdgeURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	String Streamingusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_username");
	String Streamingpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password"); 
    String Gatewayno=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
	
    String ProjectName="";
	String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	String projectdesc=functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Description");
	String pluginName  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Plugin_name");
	String Class  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Class");
	String LoggerLevel  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "LoggerLevel");
	String URI  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "URI");
	String BasicAuthUsername  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "BasicAuthUsername");
	String BasicAuthPassword  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "BasicAuthPassword");
	String Workspace  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Workspace");
	String Project  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "Project");
	String InputStream  = functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "InputStream");
   
    String configname="";
    String MaximumQueueSize=functionalcomponents.getdatafromsheet("EdgeServices", "SDSEnterprisePluginFlow", "MaximumQueueSize");
	
    @Test
	 public void SDSEnterprisePluginFlow() throws InterruptedException  {
		    driver.get(EdgeURL);
	 		test.log(Status.INFO, "open URL: "+EdgeURL+" Login successfully into the policyservice and click on the  GatewayManagement");
			functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
			functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
			functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
			functionalcomponents.WaitTillTime(7000);
	 		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesigner_tile"), 200); 
	 		 functionalcomponents.WaitTillTime(2000);
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
		  ProjectName="SDSProject"+CurrentDateandTime;
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),ProjectName);	  
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Project_name"))).isDisplayed())
		  {	
				test.log(Status.PASS, "project name as"+":"+ProjectName+" "+" is saved successfully with special characters");
		  }
		  else 
		  {
				failedDescription(" project name is not saved successfully with special characters");
		  }
		  test.log(Status.INFO, "Enter description of the project and click on the create button");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
		  functionalcomponents.WaitTillTime(30000);
		  String ProjectNameCreated=driver.findElement(By.xpath("//bdi[contains(text(),'"+ProjectName+"')]")).getText();
		  System.out.println(ProjectNameCreated);
		  if (ProjectNameCreated.equalsIgnoreCase(ProjectName))
		  {
              test.log(Status.PASS, "user is able to create Project with name:"+""+ProjectNameCreated+""+"and Group Description:"+""+projectdesc+""+"successfully");
		  } else
		  {
              failedDescription("user is not able to create Project");
          }
		  
		//create project with duplicate name
		  test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
		  functionalcomponents.WaitTillTime(2000);
		  test.log(Status.INFO, "Enter the name of the project with special characters");			 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),ProjectName);	  				 
		  test.log(Status.INFO, "Enter description of the project and click on the create button");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
		  functionalcomponents.WaitTillTime(200);
		  String Project_failed_msg=driver.findElement(By.xpath(properties.getProperty("Project_failed_msg"))).getText();
		  System.out.println(Project_failed_msg);
		  if (Project_failed_msg.equalsIgnoreCase("Project is successfully added"))
          {
			  failedDescription("user is able to create Project with name:"+""+ProjectName+""+"and Description:"+""+projectdesc+""+"successfully");
		  }
		  else if(Project_failed_msg.equalsIgnoreCase("Project name must be unique"))
		  {
			  test.log(Status.PASS,"user is able to see the msg as Project name must be unique");
	       }
		  else
		  {
	             failedDescription("Project is not successfully added");
	       }
		  
		  functionalcomponents.ClickOperation(properties.getProperty("Project_cancel"));
		  functionalcomponents.WaitTillTime(5000);	
		  functionalcomponents.ClickOperation(properties.getProperty("Refresh_button"));
		  functionalcomponents.WaitTillTime(9000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("ProjectSearchinput"),ProjectName);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1") +ProjectName+ properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(7000);
		 
			  // Add SDS Enterprise Plugin and validate Reliable message error
			  test.log(Status.INFO, "click on the Plugin tab to add the SDS Enterprise plugins and Edit Maximum Queue and try to enter any value, save the Enterprise plugin created");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ProjectOutbound"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("ProjectOutbound"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Addimg"), 70);
			  functionalcomponents.ClickOperation(properties.getProperty("Outboundconnector_Addimg"));
			  functionalcomponents.WaitTillTime(7000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Outboundconnector_Pluginname"), 70);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Outboundconnector_Pluginname"), pluginName); 
			  functionalcomponents.WaitTillTime(2000);			  		  
			  functionalcomponents.ClickOperation(properties.getProperty("Security_plugin_arrow"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Plugindropdownname_part1")+Class+properties.getProperty("Security_Plugindropdownname_part2"));
			  functionalcomponents.WaitTillTime(5000);
			  int MaximumQueueSizevalue=Integer.parseInt(MaximumQueueSize);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("MaximumQueueSize"), MaximumQueueSize); 
			  functionalcomponents.WaitTillTime(2000); 
			//validate Reliable messaging: Enterprise plugins creation
			  if(MaximumQueueSizevalue<128) {
				  
				 failedDescription("user is able to edit Maximum Queue size but appropriate error message is displayed like enter a number greater than or equal to 128 and user can not create SDS Enterprise Plugin");  
			  }
			  else if(MaximumQueueSizevalue>=128)
			  {
				  test.log(Status.PASS, "user is able to edit Maximum Queue size and enter new vlue"+MaximumQueueSizevalue+" By default it should be in MB");
			  } else
			  {
	              failedDescription("user is not able to edit Maximum Queue size");
		 
			  }
			  test.log(Status.INFO, "Enter all SDS Enterprise plugin parameters field save the Enterprise plugin created");
			  functionalcomponents.ClearAndSetValue(properties.getProperty("WebSocketURI"), URI); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthUsername"), BasicAuthUsername); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSBasicAuthPassword"), BasicAuthPassword); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("SDSWorkSpace"), Workspace); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSProject"), Project); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("SDSInputStream"), InputStream); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Security_Create"));
			  functionalcomponents.WaitTillTime(15000);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Security_plugin_searchinput"), pluginName);
			  functionalcomponents.WaitTillTime(2000); 
			  functionalcomponents.ClickOperation(properties.getProperty("PluginSearch"));
			  functionalcomponents.WaitTillTime(2000);
			  String Pluginname=driver.findElement(By.xpath("//a[contains(text(),'"+pluginName+"')]")).getText();
			  if(Pluginname.equalsIgnoreCase(pluginName))
			  {
				  test.log(Status.PASS, "user is able to create the SDS Enterprise Plugin name in the project with:"+Pluginname);		  }
			  else
			  {
	              failedDescription("user is not able to create the SDS Enterprise plugin in the project ");
	          }	
			  
			     //validate project & publish and config deployment
			      configname="Config"+CurrentDateandTime;
			      ProjectValidatePublish_ConfigDeployment(configname,ProjectName, Gatewayno);
			     // DeleteProject(ProjectName);
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
				 functionalcomponents.WaitTillTime(2000); 
				 functionalcomponents.ClickOperation(properties.getProperty("Streaming_Login_Btn"));
				 functionalcomponents.WaitTillTime(5000);
				 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Settings_link"), 90);
				 functionalcomponents.ClickOperation(properties.getProperty("Settings_link"));
				 functionalcomponents.WaitTillTime(3000);
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
				 functionalcomponents.ClickElementfromSectionlist(properties.getProperty("EnterpriseName_List"), Pluginname);
				 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EnterprisePluginName"), 20);
				 String EnterprisePluginNameValue=driver.findElement(By.xpath(properties.getProperty("EnterprisePluginName"))).getAttribute("value");
				 if(EnterprisePluginNameValue.equalsIgnoreCase(Pluginname))
				 {	
					test.log(Status.PASS, "verified EnterprisePlugins is with EnterprisePlugin Name"+": "+EnterprisePluginNameValue);
				 }
				 
				 else 
				  {
					failedDescription("verified EnterprisePlugins is not created successfully with EnterprisePlugins Name"+" "+EnterprisePluginNameValue);
				  }
	
	}
}
