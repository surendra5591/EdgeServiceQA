package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class CreateCustomService_CreatestreamingEBFconfig_DeployConfigstoGW extends BaseTest {
	
	    Properties properties = functionalcomponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String CustomServiceName="";
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "PolicyServiceURL");
	    String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "username");
	    String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "password");
	    String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "GateWayNo");
	    
	    public void CreateCustomServicewithConfigsandDeployed()
	    {
	    	driver.get(PolicyServiceURL);
	 		test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
			functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
			functionalcomponents.WaitTillTime(2000);
			functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
			functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
			functionalcomponents.WaitTillTime(7000);
	 		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 200); 
	 		 functionalcomponents.WaitTillTime(2000);
	 		 if(driver.findElement(By.xpath(properties.getProperty("GatewayManagement"))).isDisplayed())
			 {
				 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
			 }
			 else 
			 {
				failedDescription("user is able to enter into the HOME page ");
			 }
	 		  test.log(Status.INFO, "Click on the  Services from left side bar and Add Cutoma service");
	 		  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
	   	      functionalcomponents.WaitTillTime(40000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
	  		  functionalcomponents.WaitTillTime(5000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("AddCutomServicebutton"));
	  		  functionalcomponents.WaitTillTime(3000);
	  		CustomServiceName=CustomServiceName+CurrentDateandTime;
	  		functionalcomponents.ClearAndSetValue(properties.getProperty("CustomServiceNameInput"), CustomServiceName);
			functionalcomponents.WaitTillTime(2000);
			functionalcomponents.ClearAndSetValue(properties.getProperty("CustomServiceConfigtopicinput"), "CustomConfigtopic");
			functionalcomponents.WaitTillTime(2000);
			functionalcomponents.WaitTillTime(2000);
	  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+"\\Documents\\EBF_Config_1909.json");
	  		  functionalcomponents.WaitTillTime(5000);
	  		 functionalcomponents.ClickOperation(properties.getProperty("CustomServiceCreateButton"));
	  		  functionalcomponents.WaitTillTime(7000);
	  		 if(driver.findElement(By.xpath(properties.getProperty("services_button"))).isDisplayed())
			 {
				 test.log(Status.PASS, "user is able to Create CustomService successfully with Name:-"+CustomServiceName);
			 }
			 else 
			 {
				failedDescription("user is not able to create custom service");
			 }
	  		test.log(Status.INFO, "Click on the  Service Configuration tab and Create Streaming Custom Config for custom service");
	  		functionalcomponents.ClickOperation(properties.getProperty("Configurations_streaming"));
	  		  functionalcomponents.WaitTillTime(2000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
	  		  functionalcomponents.WaitTillTime(2000);
	  		  if (driver.findElement(By.xpath(properties.getProperty("Name_text"))).isDisplayed())
	  		  {
	  	        test.log(Status.PASS, "user is able to see the window opened with the options of name and content file from content file");
	  		  } else
	  		  {
	  	        failedDescription("user is not able to see the configuration window");
	  	    }
	  		  test.log(Status.INFO, "Enter the Streaming Custom configuration name and upload the json file");
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
	  		  functionalcomponents.WaitTillTime(2000);
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("EBF_EdgeServerPort"), "123");
	  		  functionalcomponents.WaitTillTime(2000);
	  		  String StreamingCustomConfig="StreamingCustomConfig"+CurrentDateandTime;
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), StreamingCustomConfig);
	  		  functionalcomponents.WaitTillTime(2000);
	  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+"\\Documents\\EBF_Config_1909.json");
	  		  functionalcomponents.WaitTillTime(5000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		  functionalcomponents.WaitTillTime(10000);
	  		  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
	  		  {
	  			  test.log(Status.PASS, "user is successfully added the configruation as:"+StreamingCustomConfig+" to the Custom service");
	  			  
	  		  }
	  		  else
	  		  {
	  			  test.log(Status.FAIL, "user is not able to  added the configruation as:"+StreamingCustomConfig+" to the Custom service");
	  		  }	 
	  		  test.log(Status.INFO, "click on the configuration add the configuration to the Custom Service by clicking on the + button");
	  		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
	  		  functionalcomponents.WaitTillTime(2000);
	  		  if (driver.findElement(By.xpath(properties.getProperty("Name_text"))).isDisplayed())
	  		  {
	  	        test.log(Status.PASS, "user is able to see the window opened with the options of name and content file from content file");
	  		  } else
	  		  {
	  	        failedDescription("user is not able to see the configuration window");
	  	    }
	  		  test.log(Status.INFO, "Enter the EBF Custom configuration name and upload the json file");
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
	  		  functionalcomponents.WaitTillTime(2000);
	  		  String CustomEBFConfig="CustomEBFConfig"+CurrentDateandTime;
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), CustomEBFConfig);
	  		  functionalcomponents.WaitTillTime(2000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("uploadEBFconfigfileradiobuttopn"));
	  		  functionalcomponents.WaitTillTime(2000);
	  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+"\\Documents\\EBF_Config_1909.json");
	  		  functionalcomponents.WaitTillTime(5000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
	  		  functionalcomponents.WaitTillTime(10000);
	  		  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
	  		  {
	  			  test.log(Status.PASS, "user is successfully added the configruation as:"+CustomEBFConfig+" to the Custom service");
	  			  
	  		  }
	  		  else
	  		  {
	  			  test.log(Status.FAIL, "user is not able to  added the configruation as:"+CustomEBFConfig+" to the Custom service");
	  		  }	
	  		  
	  		  test.log(Status.INFO, "Install the Custom Service to the gateway and do the deployement");
	  		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
	  		  functionalcomponents.WaitTillTime(10000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
	  		  functionalcomponents.WaitTillTime(30000);
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
	  		  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
	  		  functionalcomponents.WaitTillTime(5000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
	  		  functionalcomponents.WaitTillTime(5000);
	  		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
	  		  functionalcomponents.WaitTillTime(5000);
	  		  
	  		  
	  		  test.log(Status.INFO, "Add the Streaming Custom configuration to the gateway and do the deployement");
	  		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
	  		  functionalcomponents.WaitTillTime(4000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
	  		  functionalcomponents.WaitTillTime(2000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
	  		  functionalcomponents.WaitTillTime(5000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_servicesvalue"));
	  		  functionalcomponents.WaitTillTime(3000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
	  		  functionalcomponents.WaitTillTime(3000);
	  		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+StreamingCustomConfig+properties.getProperty("config_value_part2")));
	  		  functionalcomponents.WaitTillTime(3000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
	  		  functionalcomponents.WaitTillTime(100000);		
	  		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
	  		  {
	  			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+StreamingCustomConfig+" "+"successfully");
	  		  } else
	  		  {
	  	          failedDescription("user should able to add the configuration with name as"+" "+StreamingCustomConfig+" "+"not successfully");
	  	      }
	  		  test.log(Status.INFO, "Click on the Refresh button until status becomes Applied");
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900); 
	  		  functionalcomponents.ClearAndSetValue(properties.getProperty("search_configname"),StreamingCustomConfig);
	  		  functionalcomponents.WaitTillTime(5000);
	  		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
	  		  functionalcomponents.WaitTillTime(3000);
	  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
	  		  for(int i=0; i<=20; i++) {
	  			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
	  			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
	  			  functionalcomponents.WaitTillTime(10000);
	  			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+StreamingCustomConfig+properties.getProperty("Activated_msgpart2")));
	  			  if(ele1.getText().equalsIgnoreCase("Applied"))
	  				{
	  				  break;
	  			  }
	  			else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
				{
				  break;
			  }
	  		  }	
	  		  
	  		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+StreamingCustomConfig+properties.getProperty("Activated_msgpart2")));
	  		  String text1= ele1.getText();
	  		  System.out.println(text1); 
	  			if(text1.equalsIgnoreCase("Applied"))
	  			{
	  				 test.log(Status.PASS, StreamingCustomConfig+" configuration Applied successfully");
	  			}
	  			else
	  			{
	  				 failedDescription("Applied failed message will be displyed");
	  			}
	  			  			
	  			test.log(Status.INFO, "Add the Custom EBF configuration to the gateway and do the deployement");
	    		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
	    		  functionalcomponents.WaitTillTime(4000);
	    		  functionalcomponents.ClickOperation(properties.getProperty("Config_Addbutton"));		
	    		  functionalcomponents.WaitTillTime(2000);
	    		  functionalcomponents.ClickOperation(properties.getProperty("services_dropdown"));	
	    		  functionalcomponents.WaitTillTime(5000);
	    		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_servicesvalue"));
	    		  functionalcomponents.WaitTillTime(3000);
	    		  functionalcomponents.ClickOperation(properties.getProperty("config_dropdonwn"));
	    		  functionalcomponents.WaitTillTime(3000);
	    		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+CustomEBFConfig+properties.getProperty("config_value_part2")));
	    		  functionalcomponents.WaitTillTime(3000);
	    		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
	    		  functionalcomponents.WaitTillTime(100000);		
	    		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
	    		  {
	    			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+CustomEBFConfig+" "+"successfully");
	    		  } else
	    		  {
	    	          failedDescription("user should able to add the configuration with name as"+" "+CustomEBFConfig+" "+"not successfully");
	    	      }
	    		  test.log(Status.INFO, "Click on the Refresh button until status becomes Applied");
	    		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900); 
	    		  functionalcomponents.ClearAndSetValue(properties.getProperty("search_configname"),CustomEBFConfig);
	    		  functionalcomponents.WaitTillTime(5000);
	    		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
	    		  functionalcomponents.WaitTillTime(3000);
	    		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
	    		  for(int i=0; i<=20; i++) {
	    			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
	    			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
	    			  functionalcomponents.WaitTillTime(10000);
	    			  WebElement ele2=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+CustomEBFConfig+properties.getProperty("Activated_msgpart2")));
	    			  if(ele1.getText().equalsIgnoreCase("Applied"))
	    				{
	    				  break;
	    			  }
	    			else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
	  			{
	  			  break;
	  		  }
	    		  }	
	    		  
	    		  WebElement ele2=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+CustomEBFConfig+properties.getProperty("Activated_msgpart2")));
	    		  String text2= ele2.getText();
	    		  System.out.println(text2); 
	    			if(text2.equalsIgnoreCase("Applied"))
	    			{
	    				 test.log(Status.PASS, CustomEBFConfig+" Configuration Applied successfully");
	    			}
	    			else
	    			{
	    				 failedDescription("Applied failed message will be displyed");
	    			}
	    }
	    
	   

}
