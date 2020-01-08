package EdgeServices;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


public class CreateGroup_AddingGateway_AddingServices_DeployConfigs extends BaseTest {
	Properties properties = functionalcomponents.getObjectProperties();
	String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	String Groupname="";
	String StreamConfig="";
    String EBFConfigName="";
	 @Test
	 public void PolicyserviceTestcase1() throws InterruptedException {
		 
		    String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "PolicyServiceURL");
		    String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "username");
		    String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "password");
		    String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "GateWayNo");
		    
		 //Prerequisite- Start the Policyservice  ( Could version )
		    
	 		
		    test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
		    driver.get(PolicyServiceURL);
		    functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
			functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
			functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
			functionalcomponents.WaitTillTime(7000);
	   		 functionalcomponents.ClickOperation(properties.getProperty("Settings_new"));
	   		 functionalcomponents.WaitTillTime(20000);
	   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("iot_serviceurl"), 300); 
	   		 String IotServiceUrl=driver.findElement(By.xpath(properties.getProperty("iot_serviceurl"))).getAttribute("value");
	   		
	   		 if(driver.findElement(By.xpath(properties.getProperty("cancel_button"))).isDisplayed())
	   		 {
	   			test.log(Status.PASS, IotServiceUrl +"is displayed in the settings feild");
	   		 }
	   		 else
	   		 {
	   			failedDescription("iot_Service url is not displayed in the settings feild");
	   		 }
	   		functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	   		functionalcomponents.WaitTillTime(7000);
	   		 if(driver.findElement(By.xpath(properties.getProperty("GatewayManagement"))).isDisplayed())
	   		 {
	   			 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
	   		 }
	   		 else 
	   		 {
	   			failedDescription("user is able to enter into the HOME page ");
	   		 }
		test.log(Status.INFO, "click on the gateway management window");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 90);
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		functionalcomponents.WaitTillTime(10000);
		if(functionalcomponents.IsElementPresent(properties.getProperty("headernotification")))
		{
			functionalcomponents.ClickOperation(properties.getProperty("notification_dontshowagaincheckbox"));
			functionalcomponents.WaitTillTime(3000);
			functionalcomponents.ClickOperation(properties.getProperty("Notification_Accept"));
			functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
		}
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 190);
		if (driver.findElement(By.xpath(properties.getProperty("Search_Gateway"))).isDisplayed())
		{
            test.log(Status.PASS, "Gateway manaagement window is opened successfully");
		} 
		else 
		{
            failedDescription("gatewaymanagement is not opened");
		} 
			
		
         //Creation of group with invalid value
		  test.log(Status.INFO, "click on the + button of the bottom right corner to add the group");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Group_Add_button"), 90); 
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Group_Add_button"));
		  functionalcomponents.WaitTillTime(2000);
		  if (driver.findElement(By.xpath(properties.getProperty("Group_name"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to see the Group window successfully");
		  } else
		  {
              failedDescription("user is not able to see the Group window successfully");
          } 
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Group_name"),"Groupname)#@%()");	  
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Group_description"),"Groupdescription@!$%^");
		  functionalcomponents.ClickOperation(properties.getProperty("Group_status"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_Group"));
		  functionalcomponents.WaitTillTime(3000);
		  if (driver.findElement(By.xpath(properties.getProperty("Groupcancelbutton"))).isDisplayed())
		  {
              test.log(Status.PASS, "user can not create Group with invalid value of name");
		  } else
		  {
              failedDescription("user is able to create group name with invalid value");
          }
		  
		
		  //Creation of group with valid value
		  test.log(Status.INFO, "Enter the name and description of the group with valid value");
		  Groupname="Group"+CurrentDateandTime;
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Group_name"),Groupname);	  
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Group_description"),"Groupdescription");
		  functionalcomponents.ClickOperation(properties.getProperty("Create_Group"));
		  functionalcomponents.WaitTillTime(5000);
		  if (driver.findElement(By.xpath(properties.getProperty("Group_Add_button"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to create Group with name:"+""+Groupname+""+"and Group Description successfully");
		  } else
		  {
              failedDescription("user is not able to enter the  group name and description in the window");
          }
	
          //Adding Streaming services to the group 
		  test.log(Status.INFO, "Add the services to the group by clicking the + button");
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_group"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  //functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
		  functionalcomponents.WaitTillTime(2000);			  
		  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		  functionalcomponents.WaitTillTime(3000);
		  String Streamingname=driver.findElement(By.xpath("//a[text()='Streaming Service']")).getText();
		  if(Streamingname.equalsIgnoreCase("Streaming Service"))
			  {
				  test.log(Status.PASS, "Streaming service added successfully");
				  
			  }
			  else
			  {
				  failedDescription("Streaming service not added to the group");
			  }
		  
		    //Remove the service
			 test.log(Status.PASS, "check the remove of the service is working or not");
			  functionalcomponents.ClickOperation(properties.getProperty("Remove"));
			  functionalcomponents.WaitTillTime(2000);		  
			  functionalcomponents.ClickOperation(properties.getProperty("Remove_alert"));
			  functionalcomponents.WaitTillTime(5000);
			  if(driver.findElement(By.xpath(properties.getProperty("Add_service"))).isDisplayed())
			  {
				  test.log(Status.PASS, "Streaming services is deleted successfully");
				  
			  }
			  else
			  {
				  failedDescription("Streaming service is not deleted");
			  }
	   //Again add the streaming service
			  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);		  
			  functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
			  functionalcomponents.WaitTillTime(9000);			  
					  
	   //Adding persistance service to the group
			  test.log(Status.INFO, "Add the Persistence service  to the group");
			  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Persistance_service"), 50);
			  functionalcomponents.ClickOperation(properties.getProperty("Persistance_service"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
			  functionalcomponents.WaitTillTime(9000);
			  String Persistancename=driver.findElement(By.xpath("//a[text()='Persistence Service']")).getText();
			  if(Persistancename.equalsIgnoreCase("Persistence Service"))
			  {
				  test.log(Status.PASS, "persistence service added successfully");
				  
			  }
			  else
			  {
				  failedDescription("persistence service not added successfully");
			  }
			  
			  
	  //Adding EBF service to the group
			  test.log(Status.INFO, "Add the EBF service  to the group");
			  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service"), 50);
			  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service"));
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
			  functionalcomponents.WaitTillTime(9000);
			  String EBFename=driver.findElement(By.xpath("//a[text()='Essential Business Functions']")).getText();
			  if(EBFename.equalsIgnoreCase("Essential Business Functions"))
			  {
				  test.log(Status.PASS, "EBF service added successfully");
				  
			  }
			  else
			  {
				  failedDescription("EBF service not added successfully");
			  }	  
			  
	         //validations for without selecting service from dropdown
			  test.log(Status.INFO, "check whether the services are available in the list");
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
			  functionalcomponents.WaitTillTime(5000);
			  if(driver.findElement(By.xpath(properties.getProperty("addservice_cancelbutton"))).isDisplayed()) {
				  test.log(Status.PASS, "service name is required to add");	
			  }
			  else {
				  
				  failedDescription("user is able save without selecting in the service dropdown ");
			  }
			  functionalcomponents.ClickOperation(properties.getProperty("addservice_cancelbutton"));
			  functionalcomponents.WaitTillTime(5000);
			    
		  // add gateway to group
		  test.log(Status.INFO, "Add Gateway to the group ");
		  functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_gateway_button"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("search_gateway_textbox"), 50); 
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_gateway_textbox"),GateWayNo );
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("search_button"));		  
		  functionalcomponents.WaitTillTime(3000);
		 //functionalcomponents.ClickOperation((properties.getProperty("checkbox_gateway_part1") +gatewayno+ properties.getProperty("checkbox_gateway_part2")));
		  for(int i=1; i<10; i++) {
		  List<WebElement> Gatwayslist=driver.findElements(By.xpath("//tbody//tr["+i+"]//td[contains(@id,'gps_addgatewaytable-rows-row')]//bdi"));
		  for(int j=1; j<Gatwayslist.size(); j++) {
			  if(Gatwayslist.get(j).getText().equalsIgnoreCase(GateWayNo)) {
				  driver.findElement(By.xpath("(//div[@class='sapUiTableRowHdrScr']//div)["+i+"]")).click();
				  break;
			  }
			  
		  }
		  break;
		  }
		 // functionalcomponents.ClickOperation(properties.getProperty("checkbox_gateway"));	
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Addbutton_gateway"));
		  functionalcomponents.WaitTillTime(7000);
		  String number=driver.findElement(By.xpath("//table[@id='gps_listtable-table']//tr[1]//td[2]//bdi")).getText();
		  if(number.equalsIgnoreCase(GateWayNo))
			  {
				  test.log(Status.PASS, "user is able to add the gateway of"+""+GateWayNo+"to the group and status of the gateway is OK");
				  
			  }
			  else if(driver.findElement(By.xpath("//span[@title='Error']//parent::div[@class='sapUiTableCell']")).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to add the gateway of"+" "+GateWayNo+"to the group and status of the gateway is Error");
			  }
		  test.log(Status.INFO, "Click on the update all core service link if it is enabled ");
		  functionalcomponents.ClickOperation(properties.getProperty("Service_group"));
		  functionalcomponents.WaitTillTime(3000);
		  if (driver.findElement(By.xpath(properties.getProperty("Update_coreservices"))).isEnabled()) 
		  {
			  functionalcomponents.ClickOperation(properties.getProperty("Update_coreservices")); 
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("confirmation_msg"));	
			  functionalcomponents.WaitTillTime(2000);
			  test.log(Status.PASS, "Clicked on update core services successfully");
			  functionalcomponents.WaitTillTime(20000);
			  
		  }
		  else
		  {
              failedDescription("Upgrade core services are not enabled");
          } 
		 		  
          //upload config file to Create Steaming Config 
		  test.log(Status.INFO, "click on the services icon in the left side of the workcenter");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
		  functionalcomponents.WaitTillTime(7000);
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
		  test.log(Status.INFO, "click on the configuration add the configuration to the group by clicking on the + button");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Configurations_streaming"), 50);
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
		 // functionalcomponents.ClickOperation(properties.getProperty("Name_text"));
		  StreamConfig="GroupStreamConfig"+CurrentDateandTime;
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Name_text"), StreamConfig);
		  functionalcomponents.WaitTillTime(2000);
		  driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\Documents\\StreamingConfig.json");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		  functionalcomponents.WaitTillTime(3000);
		  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is successfully added the configruation as:"+StreamConfig+" to the steaming service");
			  
		  }
		  else
		  {
			  test.log(Status.PASS, "user is not able to  added the configruation as:"+StreamConfig+" to the steaming service");
		  }
		  
		  
	//checking the sorting ascending order			  
		 functionalcomponents.PerformRightClick(properties.getProperty("configuration_name"));
		 functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("sort_ascending"));
		  functionalcomponents.WaitTillTime(2000);
		  List<WebElement> configname=driver.findElements(By.xpath("//tbody//tr[contains(@class,'sapUiTableTr')]//td//div[@class='sapUiTableCell']//a"));  
		  List<String> ConfignameList = new ArrayList<String>();
		  List<String> ascedningconfigname= new ArrayList<String>(); 
		  for(int i=0; i<configname.size(); i++) {
			 // System.out.println(configname.get(i).getText());
			  ConfignameList.add(configname.get(i).getText());
			  ascedningconfigname.add(configname.get(i).getText());
		  }
		  Collections.sort(ascedningconfigname, String.CASE_INSENSITIVE_ORDER);
		  System.out.println(ascedningconfigname);
		  System.out.println(ConfignameList);
		  if (ascedningconfigname.equals(ConfignameList))
		  {
			  
			  test.log(Status.PASS, "configname list is sorted as acending");
			  
		  }
		 else
		  {
			 failedDescription("configname list is not sorted as acending");
		  }
	
		  //Check the sorting descending order
		  functionalcomponents.PerformRightClick(properties.getProperty("configuration_name"));
		  functionalcomponents.ClickOperation(properties.getProperty("sort_descending"));
		  List<WebElement> confignamedesc=driver.findElements(By.xpath("//tbody//tr[contains(@class,'sapUiTableTr')]//td//div[@class='sapUiTableCell']//a"));
		  List<String> ConfignameListdesc = new ArrayList<String>();
		  List<String> sortdescconfigname= new ArrayList<String>(); 
		  for(int i=0; i<confignamedesc.size(); i++) {
			  ConfignameListdesc.add(confignamedesc.get(i).getText());
			  sortdescconfigname.add(confignamedesc.get(i).getText());  
		  }
		  System.out.println(sortdescconfigname);
		  System.out.println(ConfignameListdesc);
		  if (sortdescconfigname.equals(ConfignameListdesc))
		  {
			  
			  test.log(Status.PASS, "configname list is sorted in descending order");
			  
		  }
		 else
		  {
			 failedDescription("configname list is not sorted in descending order");
		  }
		     test.log(Status.INFO, "check whether the search button is working or not");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Streamingsearch"), StreamConfig);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Steamingsearchbtn"));
			  functionalcomponents.WaitTillTime(2000);
			  String str12=driver.findElement(By.xpath("//tbody//tr[contains(@id,'ps_services_details_configtable-rows-row0')]//td[1]//a")).getText();
			  System.out.println(str12);
			  if(str12.equalsIgnoreCase(StreamConfig))
			  {
				test.log(Status.PASS, "search option in the streaming service is working");
				  
			  }
			 else
			  {
				 failedDescription("Search option in the streaming service is not working ");
			  }
			  		  	  
         //Adding the configuration to the group
		  test.log(Status.INFO, "click on the groups and gateways and Adding the cofiguration to the group");
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Groups_gateways"));
		  functionalcomponents.WaitTillTime(5000);	  
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateways"), 80); 
		  functionalcomponents.WaitTillTime(5000);			 
		  functionalcomponents.ClickOperation(properties.getProperty("configuration_group"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_configurationgroup"));
		  functionalcomponents.WaitTillTime(2000);
		  if (driver.findElement(By.xpath(properties.getProperty("Add_configurationgroup"))).isDisplayed())
		  {
              test.log(Status.PASS, "user is able to see the group:"+Groupname+"sucessfully");
		  } else
		  {
              failedDescription("user is able to see the group:\"+Groupname+\"sucessfully");
          }
		    	  
		  test.log(Status.INFO, "Add the service and configuration to the group");
		  functionalcomponents.ClickOperation(properties.getProperty("service_group"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streaming_service"), 50); 
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_group"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("Configname_part1")+StreamConfig+properties.getProperty("configname_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_configurationgroup"), 90);
		  functionalcomponents.ClickOperation((properties.getProperty("concerned_config_link1")+StreamConfig.trim()+properties.getProperty("concerned_config_link2")));
		  functionalcomponents.WaitTillTime(10000);
		  for(int i=0; i<=20; i++) {
			  functionalcomponents.ClickOperation(properties.getProperty("Config_group_refresh"));		  
			  functionalcomponents.WaitTillTime(10000);
			  WebElement ele2=driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span"));
			 System.out.println(ele2.getAttribute("title"));
			  if(ele2.getAttribute("title").equalsIgnoreCase("Applied"))
				{
				  break;
			  }
			  else if(ele2.getText().equalsIgnoreCase("Failed to Apply"))
				{
				  break;
			  }
		  }
		  
		  String text3=driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span")).getAttribute("title");
		  System.out.println(text3);
			if(text3.equalsIgnoreCase("Applied"))
			{
				 test.log(Status.PASS, "configuration Applied in the group successfully");
			}
			else
			{
				 failedDescription("configuration is not applied");
			}
					
      //check the navigation from gateway to service and configuration
			test.log(Status.INFO, "check for the navigation from gateways to service to configuration");
			functionalcomponents.ClickOperation(properties.getProperty("Groupname_link"));
			functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateways"),90);
			functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
			functionalcomponents.WaitTillTime(2000);
			//String gatewaynumber1=driver.findElement(By.xpath("//td[@id='gps_listtable-rows-row0-col1']")).getText();
			if(driver.findElement(By.xpath(properties.getProperty("Add_gateway_button"))).isDisplayed())
			{
				test.log(Status.PASS, "user is able to navigate the gateway window successfully");
			}
			else
			{
				failedDescription("user is not able to navigate the gateway");
			}
			 functionalcomponents.ClickOperation(properties.getProperty("Service_group"));
			 functionalcomponents.WaitTillTime(2000);			
			 if(driver.findElement(By.xpath(properties.getProperty("Add_service"))).isDisplayed())				 
			 {
				 test.log(Status.PASS, "user is able to move from the gateways to services successfully");
			 }
			 else
			 {
				 failedDescription("user is not able to move from the gateways to services");
			 }
			 functionalcomponents.ClickOperation(properties.getProperty("configuration_group"));
			 functionalcomponents.WaitTillTime(2000);			 
			 if(driver.findElement(By.xpath(properties.getProperty("Add_configurationgroup"))).isDisplayed())
			 {
				 test.log(Status.PASS, "user is able to move from services to the configurarion successfully");
				}
				else
				{
					failedDescription(" user is not able to move from services to the configuration");
				}
		  
			 
			//Creating EBF Config by uploading config file
			  test.log(Status.INFO, "click on the EBF services  in the left side of the workcenter");
			  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
			  functionalcomponents.WaitTillTime(5000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70); 
			  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
			  functionalcomponents.WaitTillTime(4000);
			  if (driver.findElement(By.xpath(properties.getProperty("ServiceConfiguration"))).isDisplayed()) 
			  {
		        test.log(Status.PASS, "user is able to see the EBF services window opened in the work center");
			  } else
			  {
		        failedDescription("user is able to see the EBFservices window opened in the work center ");
		    } 
			  test.log(Status.INFO, "click on the configuration add the configuration to the group by clicking on the + button");
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration"), 50);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration"));
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
			  functionalcomponents.ClickOperation(properties.getProperty("uploadEBFconfigfileradiobuttopn"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
			  functionalcomponents.WaitTillTime(2000);
			  
			  EBFConfigName="GroupEBFConfig"+CurrentDateandTime;
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Name_text"), EBFConfigName);
			  functionalcomponents.WaitTillTime(2000);
	  		  driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\Documents\\EBF_Config_1909.json");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
			  functionalcomponents.WaitTillTime(9000);
			  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is successfully added the configruation as:"+EBFConfigName+" to the EBF service");
				  
			  }
			  else
			  {
				  test.log(Status.PASS, "user is not able to  added the configruation as:"+EBFConfigName+" to the EBF service");
			  }
				   
			 
			//Adding the EBF configuration to the group
			  test.log(Status.INFO, "click on the groups and gateways and Adding the cofiguration to the group");
			  functionalcomponents.WaitTillTime(1000);
			  functionalcomponents.ClickOperation(properties.getProperty("Groups_gateways"));
			  functionalcomponents.WaitTillTime(5000);	  
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateways"), 80); 
			  functionalcomponents.WaitTillTime(5000);			 
			  functionalcomponents.ClickOperation(properties.getProperty("configuration_group"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("Add_configurationgroup"));
			  functionalcomponents.WaitTillTime(2000);
			  if (driver.findElement(By.xpath(properties.getProperty("service_group"))).isDisplayed())
			  {
	              test.log(Status.PASS, "user is able to see the group:"+Groupname+"sucessfully");
			  } else
			  {
	              failedDescription("user is not able to see the group"+Groupname+" in the drop down list");
	          }
			  	  	  
			  test.log(Status.INFO, "Add the EBF configuration to the group");
			  functionalcomponents.ClickOperation(properties.getProperty("service_group"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_servicesvalue"), 50); 
			  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_servicesvalue"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("config_group"));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation((properties.getProperty("Configname_part1")+EBFConfigName+properties.getProperty("configname_part2")));
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
			  functionalcomponents.WaitTillTime(20000);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_configurationgroup"), 90);
			  functionalcomponents.ClickOperation((properties.getProperty("concerned_config_link1")+EBFConfigName.trim()+properties.getProperty("concerned_config_link2")));
			  functionalcomponents.WaitTillTime(10000);
			 
			  for(int i=0; i<=20; i++) {
				  functionalcomponents.ClickOperation(properties.getProperty("Config_group_refresh"));		  
				  functionalcomponents.WaitTillTime(10000);
				  WebElement ele2=driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span"));
				 System.out.println(ele2.getAttribute("title"));
				  if(ele2.getAttribute("title").equalsIgnoreCase("Applied"))
					{
					  break;
				  }
				  else if(ele2.getText().equalsIgnoreCase("Failed to Apply"))
					{
					  break;
				  }
			  }
			  
			  String text4=driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span")).getAttribute("title");
			  System.out.println(text4);
				if(text4.equalsIgnoreCase("Applied"))
				{
					 test.log(Status.PASS, "EBF configuration Applied in the group successfully");
				}
				else 
				{
					 failedDescription("EBF configuration is not applied");
				}
					 				 
			 
       //Removing the gateway and group
	    test.log(Status.INFO, "First Remove the Gateway  from  the group");
	    functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),Groupname);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation("//span[contains(@class,'groupName')]//bdi[contains(text(),'"+Groupname+"')]");
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("checkbox_gateway"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("Remove_button"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("Remove_ok"));
		functionalcomponents.WaitTillTime(3000);
		if (driver.findElement(By.xpath(properties.getProperty("Gateways"))).isDisplayed()) {
			test.log(Status.PASS, "Gateway:" + "" + GateWayNo + "" + "is deleted sucessfully from the group");

		}
		else {
			failedDescription("Gateway is not deleted from the group");
		}
		test.log(Status.INFO, "Remove the group from policyservice");
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("Delete_group"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("Delete_button"));
		functionalcomponents.WaitTillTime(7000);
		driver.navigate().refresh();
		functionalcomponents.WaitTillTime(9000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"),30);
		functionalcomponents.WaitTillTime(5000); 
		if (functionalcomponents.IsElementPresent(properties.getProperty("Search_Gateway"))) {
			test.log(Status.PASS,"user is able to delete the group" + "" + Groupname + "is deleted sucessfully from the group");

		} else {
			failedDescription("user is not able to delete the group");
		}
		 	  		
}
}
