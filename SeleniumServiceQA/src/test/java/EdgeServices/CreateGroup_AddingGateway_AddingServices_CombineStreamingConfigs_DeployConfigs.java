package EdgeServices;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class CreateGroup_AddingGateway_AddingServices_CombineStreamingConfigs_DeployConfigs extends BaseTest {

	// Prerequisite- 1. Test data changed to Global sheet for IoT and Edge URL
	// 2. Gateway should be up and online status and All 3 services shoud be installed to gateway
	// 3. Edge Console password property and backend time Zone offset minutes property should be added to gateway
	// 4. Gateway should not be associated to any group

	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	Properties properties = FunctionalComponents.getObjectProperties();
	String CurrentDateandTime = functionalcomponents.GetCurrentDateandTime();
	String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData","EdgeURL");
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData","Gatewayno");

	String Groupname = "";
	String StreamConfig = "";
	String EBFConfigName = "";
	String CombineConfigName = "";

	@Test
	public void PolicyServiceGroupandGatewayfunctionality() throws InterruptedException {
		EdgeServiceFunctions edgeservicefunctions = new EdgeServiceFunctions();
		edgeservicefunctions.LoginPolicyservice_MovetoEdgeServicemanagmentTile(PolicyServiceURL, username, password);
		// Creation of group with invalid value
		test.log(Status.INFO, "Click on the + button of the bottom right corner to add the group");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Group_Add_button"), 90);
		functionalcomponents.ClickOperation(properties.getProperty("Group_Add_button"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Group_name")))
		{
			test.log(Status.PASS, "User is able to see the Group window successfully");
		} 
		else
		{
			failedDescription("User is not able to see the Group window successfully");
		}
		functionalcomponents.ClearAndSetValue(properties.getProperty("Group_name"), "Groupname)#@%()");
		functionalcomponents.ClickAndSetValue(properties.getProperty("Group_description"), "Groupdescription@!$%^");
		functionalcomponents.ClickOperation(properties.getProperty("Group_status"));
		functionalcomponents.ClickOperation(properties.getProperty("Create_Group"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Groupcancelbutton")))
		{
			test.log(Status.PASS, "User can not create Group with invalid value of name");
		} 
		else
		{
			failedDescription("User is able to create group name with invalid value");
		}

		// Creation of group with valid value
		test.log(Status.INFO, "Enter the name and description of the group with valid value");
		Groupname = "Group" + CurrentDateandTime;
		functionalcomponents.ClearAndSetValue(properties.getProperty("Group_name"), Groupname);
		functionalcomponents.ClearAndSetValue(properties.getProperty("Group_description"), "Groupdescription");
		functionalcomponents.ClickOperation(properties.getProperty("Create_Group"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Group_Add_button")))
		{
			test.log(Status.PASS, "user is able to create Group with name:" + "" + Groupname + ""+ "and Group Description successfully");
		} 
		else
		{
			failedDescription("user is not able to enter the  group name and description in the window");
		}

		// Adding Streaming services to the group
		test.log(Status.INFO, "Add the services to the group by clicking the + button");
		functionalcomponents.ClickOperation(properties.getProperty("Service_groupTab"));
		functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);
		functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
		functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		functionalcomponents.WaitTillTime(3000);
		String Streamingname = driver.findElement(By.xpath("//a[text()='Streaming Service']")).getText();
		if (Streamingname.equalsIgnoreCase("Streaming Service"))
		{
			test.log(Status.PASS, "Streaming service added successfully");

		} else {
			failedDescription("Streaming service not added to the group");
		}

		// Remove the service
		test.log(Status.PASS, "Check the remove of the service is working or not");
		functionalcomponents.ClickOperation(properties.getProperty("Remove"));
		functionalcomponents.ClickOperation(properties.getProperty("Remove_alert"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Add_service")))
		{
			test.log(Status.PASS, "Streaming services is deleted successfully");

		} else {
			failedDescription("Streaming service is not deleted");
		}
		// validations for without selecting service from drop down
		test.log(Status.INFO, "check whether the services are available in the list");
		functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("addservice_cancelbutton")))
		{
			test.log(Status.PASS, "Service name is required to add");
		} else {

			failedDescription("User is able save without selecting in the service dropdown ");
		}
		functionalcomponents.ClickOperation(properties.getProperty("addservice_cancelbutton"));
		// Again add the streaming service
		functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);
		functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
		functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		functionalcomponents.WaitTillTime(9000);
		 String Streamingname1=driver.findElement(By.xpath("//a[text()='Streaming Service']")).getText();
		  if(Streamingname1.equalsIgnoreCase("Streaming Service"))
			  {
				  test.log(Status.PASS, "Streaming service again added successfully");
				  
			  }
			  else
			  {
				  failedDescription("Streaming service not added to the group");
			  }

		// Adding persistence service to the group
		test.log(Status.INFO, "Add the Persistence service  to the group");
		functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
		functionalcomponents.ClickOperation(properties.getProperty("Persistance_service"));
		functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		functionalcomponents.WaitTillTime(9000);
		String Persistancename = driver.findElement(By.xpath("//a[text()='Persistence Service']")).getText();
		if (Persistancename.equalsIgnoreCase("Persistence Service")) {
			test.log(Status.PASS, "persistence service added successfully");

		} else {
			failedDescription("persistence service not added successfully");
		}

		// Adding EBF service to the group
		test.log(Status.INFO, "Add the EBF service  to the group");
		functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service"), 50);
		functionalcomponents.ClickOperation(properties.getProperty("EBF_Service"));
		functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		functionalcomponents.WaitTillTime(9000);
		String EBFename = driver.findElement(By.xpath("//a[text()='Essential Business Functions']")).getText();
		if (EBFename.equalsIgnoreCase("Essential Business Functions"))
		{
			test.log(Status.PASS, "EBF service added successfully");

		} else {
			failedDescription("EBF service not added successfully");
		}

		// add gateway to group
		test.log(Status.INFO, "Add Gateway to the group");
		functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		functionalcomponents.ClickOperation(properties.getProperty("Add_gateway_button"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("search_gateway_textbox"), 50);
		functionalcomponents.ClickAndSetValue(properties.getProperty("search_gateway_textbox"), GateWayNo);
		functionalcomponents.ClickOperation(properties.getProperty("search_button"));
		functionalcomponents.WaitTillTime(3000);
		for (int i = 1; i < 10; i++) {
			List<WebElement> Gatwayslist = driver.findElements(
					By.xpath("//tbody//tr[" + i + "]//td[contains(@id,'gps_addgatewaytable-rows-row')]//bdi"));
			for (int j = 1; j < Gatwayslist.size(); j++) {
				if (Gatwayslist.get(j).getText().equalsIgnoreCase(GateWayNo)) {
					driver.findElement(By.xpath("(//div[@class='sapUiTableRowHdrScr']//div)[" + i + "]")).click();
					break;
				}
			}
			break;
		}
		functionalcomponents.ClickOperation(properties.getProperty("Addbutton_gateway"));
		functionalcomponents.WaitTillTime(7000);
		String number = driver.findElement(By.xpath("//table[@id='gps_listtable-table']//tr[1]//td[2]//bdi")).getText();
		if (number.equalsIgnoreCase(GateWayNo)) 
		{
			test.log(Status.PASS, "user is able to add the gateway of" + "" + GateWayNo+ "to the group and status of the gateway is OK");

		} else if (driver.findElement(By.xpath("//span[@title='Error']//parent::div[@class='sapUiTableCell']")).isDisplayed())
		{
			test.log(Status.PASS, "user is able to add the gateway of" + " " + GateWayNo+ "to the group and status of the gateway is Error");
		}
		// upload configuration file to Create EBF Configuration
		test.log(Status.INFO, "Click on the services icon in the left side of the workcenter");
		functionalcomponents.ClickOperation(properties.getProperty("services_button"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streaming_service_services"), 70);
		functionalcomponents.ClickOperation(properties.getProperty("Streaming_service_services"));
		if (driver.findElement(By.xpath(properties.getProperty("ServiceConfiguration_Tab"))).isDisplayed())
		{
			test.log(Status.PASS, "User is able to see the Steaming services window opened in the work center");
		} else {
			failedDescription("User is able to see the Steaming services window opened in the work center ");
		}
		test.log(Status.INFO,"Click on the configuration add the configuration to the group by clicking on the + button");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration_Tab"), 50);
		functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
		functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Name_text")))
		{
			test.log(Status.PASS,"User is able to see the window opened with the options of name and content file from content file");
		} else {
			failedDescription("User is not able to see the configuration window");
		}
		// Creating a new configuration using json file upload method
		test.log(Status.INFO, "Enter the configuration name and upload the json file");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
		// functionalcomponents.ClickOperation(properties.getProperty("Name_text"));
		StreamConfig = "GroupStreamConfig" + CurrentDateandTime;
		functionalcomponents.ClickAndSetValue(properties.getProperty("Name_text"), StreamConfig);
		driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir") + File.separator + "Documents" + File.separator+ "StreamingConfig.json");
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Groups_gateways"), 90);
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Groups_gateways")))
		{
			test.log(Status.PASS,"User is successfully added the configruation as:" + StreamConfig + " to the steaming service");

		} else {
			failedDescription("User is not able to  added the configruation as:" + StreamConfig + " to the steaming service");
		}
		functionalcomponents.PerformRightClick(properties.getProperty("configuration_name"));
		functionalcomponents.ClickOperation(properties.getProperty("sort_ascending"));
		List<WebElement> configname = driver.findElements(
				By.xpath("//tbody//tr[contains(@class,'sapUiTableTr')]//td//div[@class='sapUiTableCellInner']//a"));
		List<String> ConfignameList = new ArrayList<String>();
		List<String> ascedningconfigname = new ArrayList<String>();
		for (int i = 0; i < configname.size(); i++) {
			System.out.println(configname.get(i).getText());
			ConfignameList.add(configname.get(i).getText());
			ascedningconfigname.add(configname.get(i).getText());
		}
		Collections.sort(ascedningconfigname, String.CASE_INSENSITIVE_ORDER);
		System.out.println(ascedningconfigname);
		// System.out.println(ConfignameList);
		if (ascedningconfigname.equals(ConfignameList)) {
			test.log(Status.PASS, "Configname list is sorted as acending");
		} else {
			failedDescription("Configname list is not sorted as acending");
		}

		// Check the sorting descending order
		functionalcomponents.PerformRightClick(properties.getProperty("configuration_name"));
		functionalcomponents.ClickOperation(properties.getProperty("sort_descending"));
		List<WebElement> confignamedesc = driver.findElements(
				By.xpath("//tbody//tr[contains(@class,'sapUiTableTr')]//td//div[@class='sapUiTableCellInner']//a"));
		List<String> ConfignameListdesc = new ArrayList<String>();
		List<String> sortdescconfigname = new ArrayList<String>();
		for (int i = 0; i < confignamedesc.size(); i++) {
			ConfignameListdesc.add(confignamedesc.get(i).getText());
			sortdescconfigname.add(confignamedesc.get(i).getText());
		}
		System.out.println(sortdescconfigname);
		System.out.println(ConfignameListdesc);
		if (sortdescconfigname.equals(ConfignameListdesc)) {
			test.log(Status.PASS, "configname list is sorted in descending order");
		} else {
			failedDescription("configname list is not sorted in descending order");
		}

		// Combine two configuration and create final configuration
		test.log(Status.INFO, "Combine two Streaming Configurations without entering new configuration name");
		functionalcomponents.ClickOperation(properties.getProperty("Selectfirstcheckboxofconfiglist"));
		if (functionalcomponents.IsElementPresent(properties.getProperty("Selectsecondcheckboxofconfiglist"))) 
		{
			functionalcomponents.ClickOperation(properties.getProperty("Selectsecondcheckboxofconfiglist"));
			functionalcomponents.ClickOperation(properties.getProperty("CombineStreamingConfig"));
			functionalcomponents.ClickOperation(properties.getProperty("save_button"));
			if (functionalcomponents.IsElementDisplayed(properties.getProperty("save_button")))
			{
				test.log(Status.PASS,
						"User can not Combine two Streaming Configurations without entering new configuration name");
			} else {
				failedDescription("User is able to  Combine two Streaming Configurations without entering new configuration name");
			}
			test.log(Status.INFO, "Combine two Streaming Configurations with entering new configuration name");
			CombineConfigName = "CombineConfigName" + CurrentDateandTime;
			functionalcomponents.ClearAndSetValue(properties.getProperty("CombineConfigNameinput"), CombineConfigName);
			functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
			if (functionalcomponents.IsElementDisplayed(properties.getProperty("ConfigurationsearchInput")))
			{
				test.log(Status.PASS,
						"User is able to Combine two Streaming Configurations with entering new configuration name"
								+ CombineConfigName);

			} else {
				failedDescription("User is not able to Combine two Streaming Configurations with entering new configuration name");
			}
		}
		
		//Checking whether the search functionality on configurations tab is working or not
		test.log(Status.INFO, "Check whether the configuration search  is working or not");
		functionalcomponents.ClickAndSetValue(properties.getProperty("ConfigurationsearchInput"), StreamConfig);
		functionalcomponents.ClickOperation(properties.getProperty("ConfigurationSearchbtn"));
		String str12 = driver.findElement(By.xpath("//tbody//tr[contains(@id,'ps_services_details_configtable-rows-row0')]//td[1]//a")).getText();
		System.out.println(str12);
		if (str12.equalsIgnoreCase(StreamConfig))
		{
			test.log(Status.PASS, "Search option in the streaming service is working");

		} else {
			failedDescription("Search option in the streaming service is not working ");
		}

		// Adding the configuration to the group
		test.log(Status.INFO, "Click on the groups and gateways and Adding the cofiguration to the group");
		functionalcomponents.ClickOperation(properties.getProperty("Groups_gateways"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("configuration_group"), 80);
		functionalcomponents.ClickOperation(properties.getProperty("configuration_group"));
		functionalcomponents.ClickOperation(properties.getProperty("Add_configurationgroup"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Add_configurationgroup")))
		{
			test.log(Status.PASS, "User is able to see the group:" + Groupname + "sucessfully");
		} else {
			failedDescription("User is able to see the group:" + Groupname + "sucessfully");
		}

		//Adding services and configurations to the group
		test.log(Status.INFO, "Add the service and configuration to the group");
		functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streaming_service"), 50);
		functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
		functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		functionalcomponents.ClickOperation((properties.getProperty("Configname_part1")+StreamConfig+properties.getProperty("configname_part2")));
		functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_configurationgroup"), 90);
		functionalcomponents.ClickOperation((properties.getProperty("concerned_config_link1")+StreamConfig.trim()+properties.getProperty("concerned_config_link2")));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Config_group_refresh"), 90);
		for (int i = 0; i <= 20; i++)
		{
			functionalcomponents.ClickOperation(properties.getProperty("Config_group_refresh"));
			functionalcomponents.WaitTillTime(10000);
			WebElement ele2 = driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span"));
			System.out.println(ele2.getAttribute("title"));
			if (ele2.getAttribute("title").equalsIgnoreCase("Applied")) {
				break;
			} else if (ele2.getText().equalsIgnoreCase("Failed to Apply")) {
				break;
			}
		}

		String text3 = driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span")).getAttribute("title");
		System.out.println(text3);
		if (text3.equalsIgnoreCase("Applied")) {
			test.log(Status.PASS, "Configuration Applied in the group successfully");
		} else {
			failedDescription("Configuration is not applied");
		}

		// check the navigation from gateway to service and configuration
		test.log(Status.INFO, "Check for the navigation from gateways to service to configuration");
		functionalcomponents.ClickOperation(properties.getProperty("Groupname_link"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateways"), 90);
		functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		// String gatewaynumber1=driver.findElement(By.xpath("//td[@id='gps_listtable-rows-row0-col1']")).getText();
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Add_gateway_button"))) {
			test.log(Status.PASS, "User is able to navigate the gateway window successfully");
		} else {
			failedDescription("User is not able to navigate the gateway");
		}
		//Move from the gateways to services successfully
		functionalcomponents.ClickOperation(properties.getProperty("Service_groupTab"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Add_service"))) 
		{
			test.log(Status.PASS, "User is able to move from the gateways to services successfully");
		} else {
			failedDescription("User is not able to move from the gateways to services");
		}
		functionalcomponents.ClickOperation(properties.getProperty("configuration_group"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Add_configurationgroup"))) 
		{
			test.log(Status.PASS, "User is able to move from services to the configurarion successfully");
		} else {
			failedDescription(" User is not able to move from services to the configuration");
		}

		// Creating EBF Config by uploading config file
		test.log(Status.INFO, "Click on the EBF services in the left side of the workcenter");
		functionalcomponents.ClickOperation(properties.getProperty("services_button"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70);
		functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("ServiceConfiguration_Tab")))
		{
			test.log(Status.PASS, "User is able to see the EBF services window opened in the work center");
		} else {
			failedDescription("User is able to see the EBFservices window opened in the work center ");
		}
		test.log(Status.INFO,"Click on the configuration add the configuration to the group by clicking on the + button");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ServiceConfiguration_Tab"), 50);
		functionalcomponents.ClickOperation(properties.getProperty("ServiceConfiguration_Tab"));
		functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
		if (driver.findElement(By.xpath(properties.getProperty("Name_text"))).isDisplayed())
		{
			test.log(Status.PASS,"User is able to see the window opened with the options of name and content file from content file");
		} else
		{
			failedDescription("User is not able to see the configuration window");
		}
		test.log(Status.INFO, "Enter the configuration name and upload the json file");
		functionalcomponents.ClickOperation(properties.getProperty("uploadEBFconfigfileradiobuttopn"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
		EBFConfigName = "GroupEBFConfig" + CurrentDateandTime;
		functionalcomponents.ClickAndSetValue(properties.getProperty("Name_text"), EBFConfigName);
		driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir") + File.separator + "Documents" + File.separator + "FSMconfig.json");
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Groups_gateways"), 90);
		if (driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
		{
			test.log(Status.PASS,"user is successfully added the configruation as:" + EBFConfigName + " to the EBF service");

		} 
		else {
			failedDescription("user is not able to  added the configruation as:" + EBFConfigName + " to the EBF service");
		}

		// Adding the EBF configuration to the group
		test.log(Status.INFO, "click on the groups and gateways and Adding the cofiguration to the group");
		functionalcomponents.ClickOperation(properties.getProperty("Groups_gateways"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("configuration_group"), 80);
		functionalcomponents.ClickOperation(properties.getProperty("configuration_group"));
		functionalcomponents.ClickOperation(properties.getProperty("Add_configurationgroup"));
		if (driver.findElement(By.xpath(properties.getProperty("Service_groupTab"))).isDisplayed())
		{
			test.log(Status.PASS, "User is able to see the group:" + Groupname + "sucessfully");
		} else {
			failedDescription("User is not able to see the group" + Groupname + " in the drop down list");
		}

		test.log(Status.INFO, "Add the EBF configuration to the group");
		functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_servicesvalue"), 50);
		functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_servicesvalue"));
		functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
		functionalcomponents.ClickOperation((properties.getProperty("Configname_part1") + EBFConfigName+ properties.getProperty("configname_part2")));
		functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_configurationgroup"), 90);
		functionalcomponents.WaitTillTime(10000);
		functionalcomponents.ClickOperation((properties.getProperty("concerned_config_link1")+EBFConfigName.trim()+properties.getProperty("concerned_config_link2")));
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Config_group_refresh"), 90);
		for (int i = 0; i <= 20; i++) {
			functionalcomponents.ClickOperation(properties.getProperty("Config_group_refresh"));
			functionalcomponents.WaitTillTime(10000);
			WebElement ele2 = driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span"));
			System.out.println(ele2.getAttribute("title"));
			if (ele2.getAttribute("title").equalsIgnoreCase("Applied")) {
				break;
			} else if (ele2.getText().equalsIgnoreCase("Failed to Apply")) {
				break;
			}
		}

		String text4 = driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]//span")).getAttribute("title");
		System.out.println(text4);
		if (text4.equalsIgnoreCase("Applied"))
		{
			test.log(Status.PASS, "EBF configuration Applied in the group successfully");
		} 
		else
		{
			failedDescription("EBF configuration is not applied");
		}

		// Creating Persistence Config and adding to gateway
		// Removing the gateway and group
		test.log(Status.INFO, "First Remove the Gateway  from  the group");
		functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"), Groupname);
		functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		functionalcomponents.ClickOperation("//span[contains(@class,'groupName')]//bdi[contains(text(),'" + Groupname + "')]");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateways"), 90);
		functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		functionalcomponents.ClickOperation(properties.getProperty("checkbox_gateway"));
		functionalcomponents.ClickOperation(properties.getProperty("GroupActionbutton"));
		functionalcomponents.ClickOperation(properties.getProperty("Remove_button"));
		functionalcomponents.ClickOperation(properties.getProperty("Remove_ok"));
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Gateways"))) 
		{
			test.log(Status.PASS, "Gateway:" + "" + GateWayNo + "" + "is deleted sucessfully from the group");

		} else {
			failedDescription("Gateway is not deleted from the group");
		}
		test.log(Status.INFO, "Remove the group from policyservice");
		functionalcomponents.ClickOperation(properties.getProperty("Delete_group"));
		functionalcomponents.ClickOperation(properties.getProperty("Delete_button"));
		functionalcomponents.WaitTillTime(7000);
		driver.navigate().refresh();
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 30);
		if (functionalcomponents.IsElementDisplayed(properties.getProperty("Search_Gateway"))) {
			test.log(Status.PASS,
					"User is able to delete the group" + Groupname + "is deleted sucessfully from the group");
		} else {
			failedDescription("User is not able to delete the group");
		}

	}
}