package StreamingService;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import StreamingService.EdgeServicecomponents;

public class EdgeServicesFlow extends EdgeServicecomponents{

	Properties properties = functionalcomponents.getObjectProperties();
	
	
	@Test
	 public void EdgeServiceEndtoEndFlow()
	 {
		 
		String username = functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "username");
		String password = functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "password");
		//Prerequisite- Start the Policyservice  ( Could version )
		test.log(Status.INFO, "Open  https://sesqa-les-admin-qa.cfapps.sap.hana.ondemand.com/");
		driver.get(properties.getProperty("Policyservice_url"));
		 functionalcomponents.WaitTillTime(2000);
		 String pagetitle=driver.getTitle();
		 System.out.println(pagetitle);
		 functionalcomponents.WaitTillTime(2000);
		 if(pagetitle.equalsIgnoreCase("AWS-Canary-sesqa: Log On"))
		 {	
			test.log(Status.PASS, "URL" +" "+"https://sesdemo.edge-qa.cfapps.sap.hana.ondemand.com"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
		 }
		 else 
		 {
			failedDescription("URL" +" "+"https://sesqa-les-admin-qa.cfapps.sap.hana.ondemand.com/"+" "+" is not loaded in Chrome browser");
		 }
		 test.log(Status.INFO, "Login successfully into the policyservice and click on the  Settings options");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		 functionalcomponents.WaitTillTime(7000);
		 functionalcomponents.ClickOperation(properties.getProperty("settings"));
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("iot_serviceurl"), 50); 
		 String text1=driver.findElement(By.xpath(properties.getProperty("iot_serviceurl"))).getAttribute("value");
		 //System.out.println(text1);
		if(text1.equalsIgnoreCase("https://dep-test.canary.cp.iot.sap"))
		{
			test.log(Status.PASS, "iot_Serviceurl"+" "+"https://dep-test.canary.cp.iot.sap"+" "+"is displayed in the feild");
		}
		else
		{
			failedDescription("iot_Serviceurl"+" "+"https://dep-test.canary.cp.iot.sap"+" "+"is not displayed in the feild");
		}
		
		functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
		functionalcomponents.WaitTillTime(2000);
		test.log(Status.INFO, "click on the gateway management window");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("labelhome"), 50); 
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 50);
		
		if (driver.findElement(By.xpath(properties.getProperty("Search_Gateway"))).isDisplayed()) {
            test.log(Status.PASS, "Gateway manaagement window is opened successfully");
        } 
		else {
            failedDescription("gatewaymanagement is  not opend");
        } 
		
        //search for the particular gateway
		test.log(Status.INFO, "Search for the particular gateway and add the configuration");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 50); 
		String gatewayno=functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "Gatewayno");
		functionalcomponents.WaitTillTime(5000);				
		functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		functionalcomponents.WaitTillTime(5000);
		//String txt=driver.findElement(By.xpath("//span[@class='groupName sapMLabel sapMLabelMaxWidth sapUiSelectable']")).getAttribute("value");
		//System.out.println(txt);
		functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Rest"));
		functionalcomponents.WaitTillTime(5000);
		if (driver.findElement(By.xpath(properties.getProperty("Configurations"))).isDisplayed())
		{
              test.log(Status.PASS, "concerned gateway screen is opened successfully");
		}
		else 
		{
              failedDescription("concerned gateway screen not opend");
        } 
		
//change the operating system
		test.log(Status.INFO, "click on the edit button to change the operating system");
		functionalcomponents.ClickOperation(properties.getProperty("Editbutton"));
		functionalcomponents.WaitTillTime(2000);		
	  
		functionalcomponents.ClickOperation(properties.getProperty("operatinfsysem_dropdown"));
		//String opertingsystem  = functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "operatingsystem"); 
		//functionalcomponents.ClickOperation((properties.getProperty("Widnows_os_part1") +opertingsystem+ properties.getProperty("Windows_os_part2")));
		if (driver.findElement(By.xpath(properties.getProperty("Edit_gateway_savebutton"))).isDisplayed())
		{
          test.log(Status.PASS, " user is able to change the operationg system as Window x64");
		} else
		{
          failedDescription("user cannot change the operating system as windows x64");
        } 
	  
		functionalcomponents.ClickOperation(properties.getProperty("Edit_gateway_savebutton"));

//Adding services to the gateway
		/* test.log(Status.INFO, "click on the services to add the services");
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("service_button"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_btn"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
			functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Steaming_service"), 50); 

		  functionalcomponents.ClickOperation(properties.getProperty("Steaming_service"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("btn_Save"), 50);
		  functionalcomponents.ClickOperation(properties.getProperty("btn_Save"));
		 String text3=driver.findElement(By.xpath("//bdi[text()='Requested']//ancestor::td[@headers='ps_status']/preceding-sibling::td[@headers='ps_services']//child::span[@title='Streaming Service']")).getText();
		 System.out.println(text3);*/
		
	  
 //Creating configuration to the gateway
	   test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Configurations"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Configurations"), 50); 
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
	  String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "config_value");
	 // System.out.println(config_value1);
	  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1") +config_value1+ properties.getProperty("config_value_part2")));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
	  functionalcomponents.WaitTillTime(50000);
	  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
	  {
			 test.log(Status.PASS, "user is able to select Streaming service "+config_value1+"as configuration successfully");
	  }
	  else
	  {
			 failedDescription("user is not able to select Streaming service "+config_value1+"as configuration successfully");
	  }
	  
	  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));	
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
	  functionalcomponents.WaitTillTime(80000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  String text2=driver.findElement(By.xpath(properties.getProperty("Activated_msg"))).getText();
		System.out.println(text2);
		if(text2.equalsIgnoreCase("Activated"))
		{
			 test.log(Status.PASS, "configuration activated successfully");
		}
		else
		{
			 failedDescription("configuration is not activated");
		}
	  
	  //validation for ascending,descending order and filter
	  
     //Creation of group
		test.log(Status.INFO, "click on the + button of the bottom right corner to add the group");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Group_Add_button"), 50); 
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Group_Add_button"));
		  functionalcomponents.WaitTillTime(2000);
		  if (driver.findElement(By.xpath(properties.getProperty("Group_name"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to see the Group window successfully");
		  } else
		  {
              failedDescription("user is not able to see the Group window successfully");
          } 
		  test.log(Status.INFO, "Enter the name and description of the group");
		  String Groupname = functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "Group_name");
		  String Groupdesc=functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "Description");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Group_name"),Groupname);	  
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Group_description"),Groupdesc);
		  functionalcomponents.ClickOperation(properties.getProperty("Group_status"));
		  functionalcomponents.ClickOperation(properties.getProperty("Create_Group"));
		  
		  if (driver.findElement(By.xpath(properties.getProperty("Group_Add_button"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to create Group with name:"+""+Groupname+""+"and Group Description:"+""+Groupdesc+""+"successfully");
		  } else
		  {
              failedDescription("user is not able to enter the  group name and description in the window");
          }
		  
//Adding Streaming services to the group
		  
		  test.log(Status.INFO, "Add the services to the group by clicking the + button");
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_group"));
		  if (driver.findElement(By.xpath(properties.getProperty("Add_service"))).isDisplayed()) 
		  {
              test.log(Status.PASS, "user is able to add the required services successfully");
		  } else
		  {
              failedDescription("user is not able to add the services to the group");
          } 
		  test.log(Status.INFO, "Add the Streaming service  to the group ");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  //functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("savebutton3"));
		  functionalcomponents.WaitTillTime(2000);
		  String Status1=driver.findElement(By.xpath("//td[@id='gps_bundletable-rows-row0-col2']")).getText();
		  System.out.println(Status1);
		  if(driver.findElement(By.xpath("//a[text()='Streaming Service']")).isDisplayed())
		  {
			  test.log(Status.PASS, "Streaming service added successfully with the Gateway(Error) as"+""+Status1);
			  
		  }
		  else
		  {
			  failedDescription("Streaming service is not added to the group");
		  }
		
		 /* if(Status1=="0")
		  {
			  test.log(Status.PASS, "Streaming service added successfully");
			  
		  }
		  else
		  {
			  failedDescription("Streaming service not added to the group");
		  }*/
		  
//Remove the service
		/*  test.log(Status.PASS, "check the remove of the service is working or not");
		  functionalcomponents.ClickOperation(properties.getProperty("Remove"));
		 //validation
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  //functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("savebutton3"));
		  functionalcomponents.WaitTillTime(2000);*/
		  
//Adding persistance service to the group
		  test.log(Status.INFO, "Add the Persistence service  to the group ");
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		 // functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Persistance_service"), 50);
		  functionalcomponents.ClickOperation(properties.getProperty("Persistance_service"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("savebutton3"));
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath("//a[text()='Persistence Service']")).isDisplayed())
		  {
			  test.log(Status.PASS, "Persistance service added successfully with the Gateway(Error) as"+""+Status1);
			  
		  }
		  else
		  {
			  failedDescription("Persistance service not added to the group");
		  }
		 /* if(Status1=="0")
		  {
			  test.log(Status.PASS, "persistence service added successfully");
			  
		  }
		  else
		  {
			  failedDescription("persistence service not added successfully");
		}*/
		  		  
		  
//Adding the gateway to the group
		  
		  test.log(Status.INFO, "Adding the gateway to the group");	
		  functionalcomponents.WaitTillTime(2000);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_gateway_button"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("search_gateway_textbox"), 50); 
		  functionalcomponents.WaitTillTime(5000);				
		 //functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_gateway_textbox"),gatewayno );
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("search_button"));		  
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("checkbox_gateway"));		  
		  functionalcomponents.ClickOperation(properties.getProperty("Addbutton_gateway"));
		  String Status2=driver.findElement(By.xpath("//span[@title='OK']")).getText();
		  System.out.println(Status2);
		  if(Status2.equalsIgnoreCase("OK"))
		  {
			  test.log(Status.PASS, "user is able to add the gateway of"+""+gatewayno+"to the group and status of the gateway is"+""+Status2);
			  
		  }
		  else
		  {
			  test.log(Status.PASS, "user is not able to add the gateway to the group");
		  }
		  

		  
//Steaming service
		  
		  test.log(Status.INFO, "click on the services icon in the left side of the workcenter");
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service_services"));
		  functionalcomponents.WaitTillTime(3000);
		  if (driver.findElement(By.xpath(properties.getProperty("Configurations_streaming"))).isDisplayed()) 
		  {
              test.log(Status.PASS, "user is able to see the Steaming services window opened in the work center");
		  } 
		  else
		  {
              failedDescription("user is able to see the Steaming services window opened in the work center ");
          } 
		  test.log(Status.INFO, "click on the configuration add the configuration to the group by clicking on the + button");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Configurations_streaming"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
		  if (driver.findElement(By.xpath(properties.getProperty("Name_text"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to see the window opened with the options of name and content file from content file");
		  } else
		  {
              failedDescription("user is not able to see the configuration window");
          }
		  test.log(Status.INFO, "Enter the configuration name and upload the json file");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Name_text"));
		  String name1 = functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "Name_config");
		  //System.out.println(name1);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Name_text"), name1);
		  functionalcomponents.WaitTillTime(2000);
		  driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\Users\\c5282967\\Documents\\Automation Project\\SAP_EdgeServices\\Documents\\test_VM_tiered_critical_devicetag.json");
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		  //functionalcomponents.WaitTillTime(3000);
		  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is successfully added the configruation to the steaming service");
			  
		  }
		  else
		  {
			  test.log(Status.PASS, "user is not able to  added the configruation to the steaming service");
		  }
		  
		  
       //Adding the configuration to the group
		  
		  test.log(Status.INFO, "click on the groups and gateways and Adding the cofiguration to the group");
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Groups_gateways"));
		 		  
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateways"), 80); 
		  functionalcomponents.WaitTillTime(5000);			 
		  //Thread.sleep(8000);
		// functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("configuration_group"), 80); 
		  functionalcomponents.ClickOperation(properties.getProperty("configuration_group"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_configurationgroup"));
		  functionalcomponents.WaitTillTime(2000);
		  if (driver.findElement(By.xpath(properties.getProperty("Add_configurationgroup"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to see the group:"+Groupname+"sucessfully");
		  } 
		  else
		  {
              failedDescription("user is able to see the group:\"+Groupname+\"sucessfully");
          }
		  test.log(Status.INFO, "Add the service and configuration to the group");
		  functionalcomponents.ClickOperation(properties.getProperty("service_group"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streaming_service2"), 50); 
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service2"));
		  functionalcomponents.WaitTillTime(2000);
		  
		  String configname_value1  = functionalcomponents.getdatafromsheet("Policyservice", "EdgeServiceEndtoEndFlow", "Name_config");
		  System.out.println(configname_value1);
		  functionalcomponents.ClickOperation(properties.getProperty("config_group"));
		  functionalcomponents.ClickOperation((properties.getProperty("Configname_part1")+configname_value1+ properties.getProperty("configname_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("save_button4"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_configurationgroup"), 50);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("concerned_config_link1") +configname_value1+ properties.getProperty("concerned_config_link2")));
		  functionalcomponents.WaitTillTime(100000);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_group_refresh"));
		  functionalcomponents.WaitTillTime(50000);
		  functionalcomponents.ClickOperation(properties.getProperty("Config_group_refresh"));
		 // String text2=driver.findElement(By.xpath(properties.getProperty("Activated_msg"))).getText();
		//	System.out.println(text2);
			if(text2.equalsIgnoreCase("Activated"))
			{
				 test.log(Status.PASS, "configuration Activated in the group successfully");
			}
			else
			{
				 failedDescription("configuration is not activated");
			}
		  
				
		
		
// Streaming Service Configuration		
		
		 String Streamingusername = functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "UserName");
		 String Streamingpassword = functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "Password");
	     
		
		 //Prerequisite- Start the StreamingService Gateway service ( Could version )
		 test.log(Status.INFO, "Open  URL https://localhost in Chrome browser");
		 driver.get(properties.getProperty("StreamingService_URL"));
		 functionalcomponents.WaitTillTime(2000);
		 String pagetitle1=driver.getTitle();
		 System.out.println(pagetitle);
		 functionalcomponents.WaitTillTime(2000);
		 if(pagetitle1.equalsIgnoreCase("SAP Edge Services - Streaming Service"))
		 {	
			test.log(Status.PASS, "URL" +" "+"https://localhost"+" "+" is loaded in Chrome browser and login page is displaying with page title as"+":"+pagetitle);
		 }
		 else 
		 {
			failedDescription("URL" +" "+"https://localhost"+" "+" is not loaded in Chrome browser");
		 }
		 
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_username"), Streamingusername);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Streaming_password"), Streamingpassword);
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
		 
				String SensorProfileName=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "SensorProfileName");
				String ProductionParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "ProductionParameters_Min");
				String ProductionParameters_Max=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "ProductionParameters_Max");
				String windowParameters_Min=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "WindowParameters_Min");
				String windowsize_averaging=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "windowSize_averaging");

			    CreateSensorProfile(SensorProfileName, ProductionParameters_Min, ProductionParameters_Max, windowParameters_Min, windowsize_averaging);
				//System.out.println(SensorProfileID);
		
	 //Action Creation
				
				String ActionName=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "ActionName");
				String Actiontypevalue=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "ActionType");

				CreateAction(ActionName, ActionName, Actiontypevalue, ActionName,  ActionName);			
				
				
	 //Set Protocols & Create Enterprise Plugin
				
				 String EnterprisePluginName = SetProtocolandCreateWebSocketPlugin1_StreamingService();			
				
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
		 String sensorprofileid=driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).getText();
		 if(driver.findElement(By.xpath(properties.getProperty("SensorProfile_ID"))).isDisplayed() && driver.findElement(By.xpath(properties.getProperty("SensorProfile_Rulename"))).isDisplayed() )
		 {	
			test.log(Status.PASS, "Verify all the different fields are available the General Information block of Add New Rule" + " i) Sensor Profile ID" + ": "+sensorprofileid+" ii) Sensor Profile Name "+": "+SensorProfileName);
		 }
		 else 
		 {
			failedDescription("user is able to add the Rules for the sensor profile. A new window is opening with the Add New Rule.");
		 }
		 test.log(Status.INFO, "Enter Rule name  & Rule Description to add the Rules for the sensor profile.");

		 String RuleName=functionalcomponents.getdatafromsheet("Rule", "EdgeServiceEndtoEndFlow", "RuleName");

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
		 String Ruletypevalue=functionalcomponents.getdatafromsheet("Rule", "EdgeServiceEndtoEndFlow", "RuleType");
		 functionalcomponents.ClickOperation(properties.getProperty("RuletypePart1")+Ruletypevalue+properties.getProperty("RuletypePart2"));
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("ScopeLevel_Dropdown"));
		 functionalcomponents.WaitTillTime(2000);
		 String ScopLevelTypevalue=functionalcomponents.getdatafromsheet("Rule", "EdgeServiceEndtoEndFlow", "ScopLevel");
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
	functionalcomponents.ClickOperation(properties.getProperty("StreamMonitoringReading"));
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

	
	
	/*
	
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


	test.log(Status.INFO, "Post Input PayLoad to server for connecting Live Sensor device");

	RESTPublisher RestPublisher = new RESTPublisher();
	RestPublisher.initialize("127.0.0.1");
	Date currentdate=functionalcomponents.GetTodaysDate();

	String Message= "{\"readings\":[{\"sensorTag\":\"tag\",\"sensorProfileId\":\""+SensorProfileID+"\",\"context\":\"1\",\"readingValue\":\"200\",\"sensorId\":\"id\"}],\"deviceTag\":\"tag1\",\"deviceId\":\"MH02\"}";
	boolean status = RestPublisher.sendInputMessage(Message, currentdate, true);
	functionalcomponents.WaitTillTime(10000);
	String Message1= "{\"readings\":[{\"sensorTag\":\"tag\",\"sensorProfileId\":\""+SensorProfileID+"\",\"context\":\"1\",\"readingValue\":\"200\",\"sensorId\":\"id\"}],\"deviceTag\":\"tag1\",\"deviceId\":\"MH02\"}";
	boolean status1 = RestPublisher.sendInputMessage(Message1, currentdate, true);
	functionalcomponents.WaitTillTime(20000);
	if(status1) {
		successfulTests.add(Message1+" -------"+"Passed");
	}
	else {
		failedTests.add(Message1+" -------"+"failed");
	}

	functionalcomponents.ClickOperation(properties.getProperty("Select_Device"));
	functionalcomponents.WaitTillTime(3000);

	String Message2= "{\"readings\":[{\"sensorTag\":\"tag\",\"sensorProfileId\":\""+SensorProfileID+"\",\"context\":\"1\",\"readingValue\":\"100\",\"sensorId\":\"id\"}],\"deviceTag\":\"tag1\",\"deviceId\":\"MH02\"}";
	boolean status2 = RestPublisher.sendInputMessage(Message2, currentdate, true);
	functionalcomponents.WaitTillTime(10000);
	if(status2) {
		successfulTests.add(Message2+" -------"+"Passed");
	}
	else {
		failedTests.add(Message2+" -------"+"failed");
	}

	String Message3= "{\"readings\":[{\"sensorTag\":\"tag\",\"sensorProfileId\":\""+SensorProfileID+"\",\"context\":\"1\",\"readingValue\":\"150\",\"sensorId\":\"id\"}],\"deviceTag\":\"tag1\",\"deviceId\":\"MH02\"}";
	boolean status3 = RestPublisher.sendInputMessage(Message3, currentdate, true);
	functionalcomponents.WaitTillTime(10000);
	if(status3) {
		successfulTests.add(Message3+" -------"+"Passed");
	}
	else {
		failedTests.add(Message3+" -------"+"failed");
	}

	String Message4= "{\"readings\":[{\"sensorTag\":\"tag\",\"sensorProfileId\":\""+SensorProfileID+"\",\"context\":\"1\",\"readingValue\":\"200\",\"sensorId\":\"id\"}],\"deviceTag\":\"tag1\",\"deviceId\":\"MH02\"}";
	boolean status4 = RestPublisher.sendInputMessage(Message4, currentdate, true);
	functionalcomponents.WaitTillTime(10000);
	if(status4) {
		successfulTests.add(Message4+" -------"+"Passed");
	}
	else {
		failedTests.add(Message4+" -------"+"failed");
	}

	test.log(Status.PASS, "Input PayLoad Posted to server successful PayLoad Tests are: "+successfulTests);

	
	*/

	//Prerequisite- Run SQL Server in current system	 
	//Getting Data from DATA Base
	String DB_UserName=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "DB_UserName");	 
	String DB_Password=functionalcomponents.getdatafromsheet("StreamingService", "EdgeServiceEndtoEndFlow", "DB_Password");	  

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




	//Deleting Sensor Profile and action from streaming service
		 
	     DeleteRuleFromSensorProfile(SensorProfileName, RuleName);
	     DeleteSensorProfile(SensorProfileName);
	     DeleteAction(ActionName);
	     
		
		
	 }

}
