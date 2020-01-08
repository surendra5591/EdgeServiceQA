package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class EBFConfigCreation_AddingCustomPropertiestoGW_EBFDeployedtoGW extends BaseTest  {
	 
    Properties properties = functionalcomponents.getObjectProperties();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
    String EBFConfigName="";
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "PolicyServiceURL");
    String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "username");
    String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "password");
    String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "GateWayNo");
    String PlantID_Value = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Plant_ID");
    
  //Creating EBF(FSM) Config by uploading config file and deployment
  	 @Test(priority=1)
  	 public void CreateEBFConfiguration() {
  		 driver.get(PolicyServiceURL);
 		test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
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
 		  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
   	      functionalcomponents.WaitTillTime(40000);
  		  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
  		  functionalcomponents.WaitTillTime(5000);
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70); 
  		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
  		  functionalcomponents.WaitTillTime(7000);
  		  if (driver.findElement(By.xpath(properties.getProperty("Configurations_streaming"))).isDisplayed()) 
  		  {
  	        test.log(Status.PASS, "user is able to see the EBF services window opened in the work center");
  		  } else
  		  {
  	        failedDescription("user is able to see the EBFservices window opened in the work center ");
  	    } 
  		  test.log(Status.INFO, "click on the configuration add the configuration to the group by clicking on the + button");
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Configurations_streaming"), 50);
  		  functionalcomponents.WaitTillTime(2000);
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
  		  test.log(Status.INFO, "Enter the configuration name and upload the json file");
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Name_text"), 50);
  		  functionalcomponents.WaitTillTime(2000);
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("EBF_EdgeServerPort"), "123");
  		  functionalcomponents.WaitTillTime(2000);
  		  EBFConfigName="EBFConfig"+CurrentDateandTime;
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), EBFConfigName);
  		  functionalcomponents.WaitTillTime(2000);
  		  functionalcomponents.ClickOperation(properties.getProperty("uploadEBFconfigfileradiobuttopn"));
  		  functionalcomponents.WaitTillTime(2000);
  		  driver.findElement(By.xpath(properties.getProperty("ConfigFileuploadpath"))).sendKeys(System.getProperty("user.dir")+"\\Documents\\EBF_Config_1909.json");
  		  functionalcomponents.WaitTillTime(5000);
  		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
  		  functionalcomponents.WaitTillTime(10000);
  		  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
  		  {
  			  test.log(Status.PASS, "user is successfully added the configruation as:"+EBFConfigName+" to the EBF service");
  			  
  		  }
  		  else
  		  {
  			  test.log(Status.FAIL, "user is not able to  added the configruation as:"+EBFConfigName+" to the EBF service");
  		  }	
  		  test.log(Status.INFO, "verify EBF configuration can not be created with same name");
  		  functionalcomponents.ClickOperation(properties.getProperty("add_configuration_button"));
  		  functionalcomponents.WaitTillTime(4000);
		  functionalcomponents.ClickOperation(properties.getProperty("Copyfromconfigradiobutton"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), EBFConfigName);
  		  functionalcomponents.WaitTillTime(2000);
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("Copycontentcontentdropdownvalue"), EBFConfigName);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
  		  functionalcomponents.WaitTillTime(3000);
		  if (driver.findElement(By.xpath(properties.getProperty("Add_button"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user can not create config with already exist config name");
			 
	        
		  } else
		  {
			  failedDescription("user is able to create config with already exist config name");
	      }
		  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
  		  functionalcomponents.WaitTillTime(3000);
  		  
  	}
  		
  	    @Test (priority=2, dependsOnMethods = { "CreateEBFConfiguration" })
     	public void CreateUserTypeCustomPropertiesandDeleting() {
        String UserCustomPropertyName="UserProperty"+CurrentDateandTime;
          functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
     	  functionalcomponents.WaitTillTime(10000);
     	  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
     	  functionalcomponents.WaitTillTime(30000);
     	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ConfigProperties"), 90);
         functionalcomponents.ClickOperation(properties.getProperty("ConfigProperties"));
     	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddPropertiesbutton"), 90);
         functionalcomponents.ClickOperation(properties.getProperty("AddPropertiesbutton"));
     	  functionalcomponents.WaitTillTime(4000);
     	  functionalcomponents.ClearAndSetValue(properties.getProperty("PropertyNameinput"), UserCustomPropertyName);
     	  functionalcomponents.WaitTillTime(3000);
          functionalcomponents.ClickOperation(properties.getProperty("CreatePeopertyNamebutton"));
     	  functionalcomponents.WaitTillTime(7000);
     	  WebElement CreatedName=driver.findElement(By.xpath("//span[text()='"+UserCustomPropertyName+"']"));
  	  if(CreatedName.getText().equalsIgnoreCase(UserCustomPropertyName))
  	  {
  		  test.log(Status.PASS, "user is able to Create Global Custom Properties as:"+UserCustomPropertyName);
  	  } else
  	  {
          failedDescription("user is not able to Create Global Custom Properties");
        }
  	  functionalcomponents.WaitTillTime(7000);
  	  functionalcomponents.ClickOperation(properties.getProperty("DeleteCongifProperty"));
     	  functionalcomponents.WaitTillTime(2000);
     	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
   	  functionalcomponents.WaitTillTime(7000);
   	 if (driver.findElement(By.xpath(properties.getProperty("AddPropertiesbutton"))).isDisplayed())
  	  {
   		test.log(Status.PASS, "user is able to Delete Global Custom Properties:"+UserCustomPropertyName);
  	  } else
  	  {
          failedDescription("user is not able to Create Global Custom Properties");
        }
     

      	
    }
  	
  	    //Adding Custom Properties to Gateway and deployment of EBF configuration
  	
  	    @Test (priority=3, dependsOnMethods = { "CreateUserTypeCustomPropertiesandDeleting" })
  		 public void AddingCustomPropertiestoGatewayandDeployEBFConfiguration() {
  		  test.log(Status.INFO, "Adding PlantID property to the Gateway");
  		  functionalcomponents.WaitTillTime(7000);	
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
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddPropertytoGWButton"), 90);
  		  if (!functionalcomponents.IsElementPresent(driver, properties.getProperty("PlantIDPropertyElement") ))
  		  {	  
  		  functionalcomponents.ClickOperation(properties.getProperty("AddPropertytoGWButton"));
  		  functionalcomponents.WaitTillTime(3000);
  		  String Rownum =driver.findElement(By.xpath("//bdi[text()='Plant_ID']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
  		  driver.findElement(By.xpath("//div[@data-sap-ui-rowindex='"+Rownum+"']//div[@title='Click to Select']")).click();
  		  functionalcomponents.WaitTillTime(3000);
  		  functionalcomponents.ClickOperation(properties.getProperty("Inputvalueplantid_dropdown"));
  		  functionalcomponents.WaitTillTime(2000);
  		  functionalcomponents.ClickOperation("//ul[@class='sapMSelectList sapMSltList-CTX']//li[text()='"+PlantID_Value+"']");
		  functionalcomponents.WaitTillTime(3000);
  		  functionalcomponents.ClickOperation(properties.getProperty("AddConfigpropertybutton"));
  		  functionalcomponents.WaitTillTime(15000);
  		  if(functionalcomponents.IsElementPresent(driver, properties.getProperty("PlantIDPropertyElement")))
  		  {
  			  test.log(Status.PASS, "user is able to add the Plan ID configuration Property to Gateway as:"+" "+PlantID_Value+" "+"successfully");
  		  } else
  		  {
  	          failedDescription("user is not able to add the Plan ID configuration Property to Gateway");
  	      }
  		  } 
  		  test.log(Status.INFO, "Add the EBF configuration to the gateway and do the deployement");
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
  		  functionalcomponents.ClickOperation((properties.getProperty("config_value_part1")+EBFConfigName+properties.getProperty("config_value_part2")));
  		  functionalcomponents.WaitTillTime(3000);
  		  functionalcomponents.ClickOperation(properties.getProperty("edge_config_save"));
  		  functionalcomponents.WaitTillTime(100000);		
  		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
  		  {
  			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+EBFConfigName+" "+"successfully");
  		  } else
  		  {
  	          failedDescription("user should able to add the configuration with name as"+" "+EBFConfigName+" "+"not successfully");
  	      }
  		  test.log(Status.INFO, "Click on the Refresh button until status becomes Applied");
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900); 
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("search_configname"),EBFConfigName);
  		  functionalcomponents.WaitTillTime(5000);
  		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
  		  functionalcomponents.WaitTillTime(3000);
  		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
  		  for(int i=0; i<=20; i++) {
  			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
  			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
  			  functionalcomponents.WaitTillTime(10000);
  			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+EBFConfigName+properties.getProperty("Activated_msgpart2")));
  			  if(ele1.getText().equalsIgnoreCase("Applied"))
  				{
  				  break;
  			  }
  			else if(ele1.getText().equalsIgnoreCase("Failed to Apply"))
			{
			  break;
		  }
  		  }	
  		  
  		  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+EBFConfigName+properties.getProperty("Activated_msgpart2")));
  		  String text2= ele1.getText();
  		  System.out.println(text2); 
  			if(text2.equalsIgnoreCase("Applied"))
  			{
  				 test.log(Status.PASS, "configuration Applied successfully");
  			}
  			else
  			{
  				 failedDescription("Applied failed message will be displyed");
  			}
  		  
}
}
