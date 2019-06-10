package PolicyService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class Policyservicetestcase extends BaseTest {
	Properties properties = functionalcomponents.getObjectProperties();
	
	
	 @Test
	 public void PolicyserviceTestcase1() throws InterruptedException {
		 
		String URL = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "URL"); 
	 	String username = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "username");
		String password = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "password");
		String gatewayno=functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "Gatewayno");		
		//Prerequisite- Start the Policyservice  ( Could version )
		 test.log(Status.INFO, "open url in chrome browser & Login successfully into the policyservice and click on the  Settings options/");
		 driver.get(URL);
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policyservice_name"), 50); 
		 //test.log(Status.INFO, "Login successfully into the policyservice and click on the  Settings options");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		 functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("settings"), 50); 
		 functionalcomponents.ClickOperation(properties.getProperty("settings"));
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("iot_serviceurl"), 30); 
		 String IotServiceUrl=driver.findElement(By.xpath(properties.getProperty("iot_serviceurl"))).getAttribute("value");
		
		 if(driver.findElement(By.xpath(properties.getProperty("cancel_button"))).isDisplayed())
		 {
			test.log(Status.PASS, IotServiceUrl +"is displayed in the setting feild");
		 }
		 
		 else
		 {
			failedDescription("iot_Serviceurl is not displayed in the setting feild");
		 }
		
		functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
		functionalcomponents.WaitTillTime(5000);
		test.log(Status.INFO, "click on the gateway management window");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("labelhome"), 90); 
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 50);
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		functionalcomponents.WaitTillTime(30000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
		
		if (driver.findElement(By.xpath(properties.getProperty("Search_Gateway"))).isDisplayed())
		{
            test.log(Status.PASS, "Gateway manaagement window is opened successfully");
		} 
		else 
		{
            failedDescription("gatewaymanagement is not opened");
		} 
		
       //search for the particular gateway
		test.log(Status.INFO, "Search for the particular gateway and add the configuration");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 70); 
		functionalcomponents.WaitTillTime(5000);	
		functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),gatewayno );
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		functionalcomponents.WaitTillTime(7000);
		functionalcomponents.ClickOperation(properties.getProperty("IOT_gateway_Restpart1")+gatewayno+properties.getProperty("IOT_gateway_Restpart2"));
		functionalcomponents.WaitTillTime(7000);
		if (driver.findElement(By.xpath(properties.getProperty("GatewayConfiguration"))).isDisplayed())
		{
              test.log(Status.PASS, "concerned gateway screen is opened successfully");
		} else 
		{
              failedDescription("concerned gateway screen not opend");
        } 
		String operatingsytemtext = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "operatingsystem"); 
      
		String OperatingSystemvalue = driver.findElement(By.xpath("(//span[@class='sapMText sapMTextMaxWidth sapUiSelectable'])[2]")).getText();
		System.out.println(OperatingSystemvalue);
		if(OperatingSystemvalue.equalsIgnoreCase(operatingsytemtext))
		{
			test.log(Status.PASS, "operationg system is displaying  as :"+OperatingSystemvalue);
			functionalcomponents.ClickOperation(properties.getProperty("GatewayConfiguration"));
			functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayConfiguration"), 50); 
		}
		//change the operating system
		else {
		test.log(Status.INFO, "click on the edit button to change the operating system");
		functionalcomponents.ClickOperation(properties.getProperty("Editbutton"));
		functionalcomponents.WaitTillTime(2000);		
		functionalcomponents.ClickOperation(properties.getProperty("operatinfsysem_dropdown"));
		
		functionalcomponents.ClickOperation(properties.getProperty("Widnows_os_part1")+operatingsytemtext+properties.getProperty("Windows_os_part2"));
		functionalcomponents.WaitTillTime(500);
		if (driver.findElement(By.xpath(properties.getProperty("operting_system"))).isDisplayed())
		{
          test.log(Status.PASS, " user is able to change the operationg system as Window x64");
		} else
		{
          failedDescription("user cannot change the operating system as windows x64");
        } 
		functionalcomponents.ClickOperation(properties.getProperty("Edit_gateway_savebutton"));
		functionalcomponents.WaitTillTime(5000);
		}
		
//Adding services to the gateway
		/*test.log(Status.INFO, "click on the services to add the services");
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
		//System.out.println(text3);*/
		
	  
 //Creating configuration to the gateway
	  test.log(Status.INFO, "click on the Add configuration button i.e, + button in the work center");
	  functionalcomponents.WaitTillTime(5000);
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
	  Thread.sleep(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service"));
	  Thread.sleep(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
	  Thread.sleep(5000);
	  String config_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "config_value");
	  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+config_value1+properties.getProperty("config_value_part2")));
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_savebtn"));	  
	  functionalcomponents.WaitTillTime(30000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 50); 
	  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
	  {
			 test.log(Status.PASS, "user is able to select Streaming service "+config_value1+"as configuration successfully");
	  }
	  else
		{
			 failedDescription("user is not able to select Streaming service "+config_value1+"as configuration successfully");
		}
	  test.log(Status.INFO, "click on the refresh button untill configuration gets Activated");
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90); 
	  functionalcomponents.WaitTillTime(8000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(30000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),config_value1);
	  functionalcomponents.WaitTillTime(3000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(10000);
	  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));
	  functionalcomponents.WaitTillTime(15000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Activate_link"), 50);
	  functionalcomponents.WaitTillTime(5000);
	  functionalcomponents.ClickOperation(properties.getProperty("Activate_link"));	
	  functionalcomponents.WaitTillTime(20000);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 90); 
	  functionalcomponents.WaitTillTime(20000);
	  for(int i=0; i<=20; i++) {
		  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
		  functionalcomponents.WaitTillTime(15000);
		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+config_value1+properties.getProperty("Activated_msgpart2")));
		  if(ele1.getText().equalsIgnoreCase("Activated"))
			{
			  break;
		  }
	  }
	  	  
	  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+config_value1+properties.getProperty("Activated_msgpart2")));
	  String text2= ele1.getText();
	  System.out.println(text2);
	    
		if(text2.equalsIgnoreCase("Activated"))
		{
			 test.log(Status.PASS, "configuration activated successfully");
		}
		else
		{
			 failedDescription("configuration is not activated");
		}
	  
	 
	  
//Creation of group
		
		  test.log(Status.INFO, "click on the + button of the bottom right corner to add the group");
		 // functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Group_Add_button"), 50); 
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
		  
		  test.log(Status.INFO, "Enter the name and description of the group");
		  String Groupname = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "Group_name");
		  String Groupdesc=functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "Description");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Group_name"),Groupname);	  
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Group_description"),Groupdesc);
		  functionalcomponents.ClickOperation(properties.getProperty("Group_status"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_Group"));
		  functionalcomponents.WaitTillTime(3000);
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
		  functionalcomponents.WaitTillTime(3000);
		  if (driver.findElement(By.xpath(properties.getProperty("Add_service"))).isDisplayed()) 
		  {
              test.log(Status.PASS, "user is able to add the streaming and persistence services to the group successfully");
		  }
		  else
		  {
              failedDescription("user is not able to add the Steaming and persistence services to the group");
          } 
		  
		  test.log(Status.INFO, "Add the Streaming service  to the group ");
		 // functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  //functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
		  functionalcomponents.WaitTillTime(2000);			  
		  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		  functionalcomponents.WaitTillTime(3000);
		  String Status1=driver.findElement(By.xpath("//td[@id='gps_bundletable-rows-row0-col2']")).getText();
		  if(Status1.equalsIgnoreCase("0"))
			  {
				  test.log(Status.PASS, "Streaming service added successfully");
				  
			  }
			  else
			  {
				  failedDescription("Streaming service not added to the group");
			  }
		  
		  test.log(Status.INFO, "Add Gateway to the group ");
		  functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_gateway_button"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("search_gateway_textbox"), 50); 
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_gateway_textbox"),gatewayno );
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("search_button"));		  
		  functionalcomponents.WaitTillTime(3000);
		 //functionalcomponents.ClickOperation((properties.getProperty("checkbox_gateway_part1") +gatewayno+ properties.getProperty("checkbox_gateway_part2")));
		  for(int i=1; i<10; i++) {
		  List<WebElement> Gatwayslist=driver.findElements(By.xpath("//tbody//tr["+i+"]//td[contains(@id,'gps_addgatewaytable-rows-row')]//bdi"));
		  for(int j=1; j<Gatwayslist.size(); j++) {
			  if(Gatwayslist.get(j).getText().equalsIgnoreCase(gatewayno)) {
				  driver.findElement(By.xpath("(//div[@class='sapUiTableRowHdrScr']//div)["+i+"]")).click();
				  break;
			  }
		  }
		  }
		  functionalcomponents.ClickOperation(properties.getProperty("checkbox_gateway"));	
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Addbutton_gateway"));
		  functionalcomponents.WaitTillTime(2000);
		  String number=driver.findElement(By.xpath("//table[@id='gps_listtable-table']//tr[1]//td[3]//bdi")).getText();
		  if(number.equalsIgnoreCase(gatewayno))
			  {
				  test.log(Status.PASS, "user is able to add the gateway of"+""+gatewayno+"to the group and status of the gateway is OK");
				  
			  }
			  else if(driver.findElement(By.xpath("//span[@title='Error']//parent::div[@class='sapUiTableCell']")).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to add the gateway of"+" "+gatewayno+"to the group and status of the gateway is Error");
			  }
		  test.log(Status.INFO, "Click on the update all core service link if it is enabled ");
		  functionalcomponents.ClickOperation(properties.getProperty("Service_group"));
		  if (driver.findElement(By.xpath(properties.getProperty("Update_coreservices"))).isEnabled()) 
		  {
			  functionalcomponents.ClickOperation(properties.getProperty("Update_coreservices")); 
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickOperation(properties.getProperty("confirmation_msg"));	
			  functionalcomponents.WaitTillTime(2000);
			  test.log(Status.PASS, "Clicked on update core services successfully");
			  
		  }
		  else
		  {
              failedDescription("Upgrade core services are not enabled");
          } 
		 
					  
//Remove the service
		 test.log(Status.PASS, "check the remove of the service is working or not");
		  functionalcomponents.ClickOperation(properties.getProperty("Remove"));
		  functionalcomponents.WaitTillTime(2000);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Remove_alert"));
		  functionalcomponents.WaitTillTime(5000);
		  if(driver.findElement(By.xpath(properties.getProperty("Add_service"))).isDisplayed())
		  {
			  test.log(Status.PASS, "Streaming services is deleted successdully");
			  
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
		  functionalcomponents.WaitTillTime(3000);
		  
				  
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
		  functionalcomponents.WaitTillTime(5000);
		  if(Status1.equalsIgnoreCase("0"))
		  {
			  test.log(Status.PASS, "persistence service added successfully");
			  
		  }
		  else
		  {
			  failedDescription("persistence service not added successfully");
		  }
		  
		  
		//Adding EBF service to the group
		  test.log(Status.INFO, "Add the Persistence service  to the group");
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EssentialBusinessService"), 50);
		  functionalcomponents.ClickOperation(properties.getProperty("EssentialBusinessService"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		  functionalcomponents.WaitTillTime(5000);
		  if(Status1.equalsIgnoreCase("0"))
		  {
			  test.log(Status.PASS, "EBF service added successfully");
			  
		  }
		  else
		  {
			  failedDescription("EBF service not added successfully");
		  }	  
		  
		  
//validations for services
		  test.log(Status.INFO, "check whether the services are available in the list");
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_service"));
		  functionalcomponents.WaitTillTime(4000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  functionalcomponents.WaitTillTime(3000);
		 List<WebElement> lt= driver.findElements(By.xpath("//ul[@class='sapMSelectList sapMSltList-CTX']//li[@role='option']"));
		// System.out.println(lt);
		 boolean flag=true;
		  for(int i=1;i<lt.size();i++)
		  {
			//System.out.println(lt.get(i).getText());  
			  if(lt.get(i).getText().equalsIgnoreCase("Streaming Service (CORE)"))
			  {
				  flag =false;
				  break;
			  }
			  			  
		  }
		  if(flag) {
			  test.log(Status.PASS, "streaming service is not present in the service dropdown");	

		  }
		  else {
			  
			  failedDescription(" Streaming service are present in the service dropdown ");
		  }
		  //functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("addservice_cancelbutton"));
		  functionalcomponents.WaitTillTime(5000);
	
	  
//upload config file to Steaming service 
		  test.log(Status.INFO, "click on the services icon in the left side of the workcenter");
		  functionalcomponents.WaitTillTime(2000);
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
		  functionalcomponents.ClickOperation(properties.getProperty("Name_text"));
		  //  String ConfigName=functionalcomponents.GetRandomString();
		  String name1 = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "Name_config");
		//  System.out.println(ConfigName);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Name_text"), name1);
		  functionalcomponents.WaitTillTime(2000);
		  driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\Documents\\Enterpsie PluginWorkingConfig.json");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		  functionalcomponents.WaitTillTime(3000);
		  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is successfully added the configruation to the steaming service");
			  
		  }
		  else
		  {
			  test.log(Status.PASS, "user is not able to  added the configruation to the steaming service");
		  }
		  
		  
	//checking the sorting ascending order			  
		 functionalcomponents.PerformRightClick(properties.getProperty("configuration_name"));
		 functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("sort_ascending"));
		  functionalcomponents.WaitTillTime(2000);
		  List<WebElement> configname=driver.findElements(By.xpath("//tbody//tr[contains(@class,'sapUiTableTr')]//td[1]"));  
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
		  List<WebElement> confignamedesc=driver.findElements(By.xpath("//tbody//tr[contains(@class,'sapUiTableTr')]//td[1]"));
		  List<String> ConfignameListdesc = new ArrayList<String>();
		  List<String> sortdescconfigname= new ArrayList<String>(); 
		  for(int i=0; i<confignamedesc.size(); i++) {
			  ConfignameListdesc.add(confignamedesc.get(i).getText());
			  sortdescconfigname.add(confignamedesc.get(i).getText());  
		  }
		 
		  Collections.sort(sortdescconfigname, String.CASE_INSENSITIVE_ORDER);
		  Collections.reverse(sortdescconfigname);
		 // System.out.println(sortdescconfigname);
		 // System.out.println(ConfignameListdesc);
		  if (sortdescconfigname.equals(ConfignameListdesc))
		  {
			  
			  test.log(Status.PASS, "configname list is sorted in descending order");
			  
		  }
		 else
		  {
			 failedDescription("configname list is not sorted in descending order");
		  }
		  
//check for the filter option
		  /*
		  functionalcomponents.PerformRightClick(properties.getProperty("configuration_name"));
		  functionalcomponents.WaitTillTime(1000);
		   WebElement textbox = driver.findElement(By.xpath(properties.getProperty("filter_option")));
		   Actions action = new Actions(driver);
		   action.moveToElement(textbox);
		   action.click();
		   action.sendKeys("sunkara");
		   functionalcomponents.WaitTillTime(3000);
		   action.sendKeys(Keys.ENTER);
		   action.build().perform();
		   functionalcomponents.WaitTillTime(4000);
		   List<WebElement>configfilter=driver.findElements(By.xpath("//tbody//tr[contains(@class,'sapUiTableTr')]//td[1]"));
		   List<String> Confignamefiltertext = new ArrayList<String>();
		   
		   int count = 0;
		   for(int i=0; i<configfilter.size(); i++) 
		   {
			   Confignamefiltertext.add(configfilter.get(i).getText());
			 
		   }
		   System.out.println(Confignamefiltertext);
		   for(int i=0; i<Confignamefiltertext.size(); i++) 
		   {
			   if(Confignamefiltertext.get(i).contains("sunkara"))
				   count++;
				    
		   }
		   System.out.println(count);
		   if(count==Confignamefiltertext.size()) 
		   {
			   
		    test.log(Status.PASS, "configuration filter is working and searched result successfully");
		   }
		   else
		   {
		      failedDescription("configuration filter is not working and not filltering result as per searched text");
		   }
		   
		   */
		   test.log(Status.INFO, "check whether the search button is working or not");
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Streamingsearch"), name1);
			  functionalcomponents.WaitTillTime(3000);
			  functionalcomponents.ClickOperation(properties.getProperty("Steamingsearchbtn"));
			  functionalcomponents.WaitTillTime(2000);
			  String str12=driver.findElement(By.xpath("(//tbody//tr[contains(@class,'sapUiTableFirstRow')]//td)[1]//a")).getAttribute("title");
			  System.out.println(str12);
			  if(str12.equalsIgnoreCase(name1))
			  {
				test.log(Status.PASS, "search option in the streaming service is  working");
				  
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
		  //Thread.sleep(8000);
		// functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("configuration_group"), 80); 
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
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streaming_service2"), 50); 
		  functionalcomponents.ClickOperation(properties.getProperty("Streaming_service2"));
		  functionalcomponents.WaitTillTime(2000);
		 
		 // String configname_value1  = functionalcomponents.getdatafromsheet("Policyservice", "PolicyserviceTestcase1", "Name_config");
		 // System.out.println(configname_value1);
		  functionalcomponents.ClickOperation(properties.getProperty("config_group"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation((properties.getProperty("Configname_part1")+name1+properties.getProperty("configname_part2")));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("save_button4"));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Add_configurationgroup"), 90);
		  functionalcomponents.ClickOperation((properties.getProperty("concerned_config_link1")+name1.trim()+properties.getProperty("concerned_config_link2")));
		  functionalcomponents.WaitTillTime(10000);
		 
		  for(int i=0; i<=10; i++) {
			  functionalcomponents.ClickOperation(properties.getProperty("Config_group_refresh"));		  
			  functionalcomponents.WaitTillTime(15000);
			  WebElement ele2=driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]"));
			  if(ele2.getText().equalsIgnoreCase("Activated"))
				{
				  break;
			  }
		  }
		  
		  String text3=driver.findElement(By.xpath("//table[contains(@id,'gps_listtable_group_config-table')]//tr[1]//td[3]")).getText();
		  System.out.println(text3);
			if(text3.equalsIgnoreCase("Activated"))
			{
				 test.log(Status.PASS, "configuration Activated in the group successfully");
			}
			else if(driver.findElement(By.xpath("//span[@title='Activation Failed' and (contains(@class,'statuslabel'))]")).isDisplayed())
			{
				 failedDescription("configuration is not activated");
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
		  
//Removing the gateway and group

	    test.log(Status.INFO, "First Remove the Gateway  from  the group");
		functionalcomponents.ClickOperation(properties.getProperty("Gateways"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("checkbox_gateway"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("Remove_button"));
		functionalcomponents.WaitTillTime(3000);
		functionalcomponents.ClickOperation(properties.getProperty("Remove_ok"));
		if (driver.findElement(By.xpath("//span[@id='gps_listtable-add-img']")).isDisplayed()) {
			test.log(Status.PASS, "Gateway:" + "" + gatewayno + "" + "is deleted sucessfully from the group");

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
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"),30);
		functionalcomponents.WaitTillTime(5000); 
		if (functionalcomponents.IsElementPresent(properties.getProperty("Search_Gateway"))) {
			test.log(Status.PASS,"user is able to delete the group" + "" + Groupname + "is deleted sucessfully from the group");

		} else {
			failedDescription("user is not able to delete the group");
		}
		 	  		
}
}
