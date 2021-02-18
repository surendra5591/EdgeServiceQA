package POC_Test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CreateEBFConfigandDeployment extends BaseTest {
	
	    Properties properties = functionalcomponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String EBFConfigName="";
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "PolicyServiceURL");
	    String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "username");
	    String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "password");
	    String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "GateWayNo");
	    String DB_UserName=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "DB_userid");	 
	    String DB_Password=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "DB_pwd");
	
	
	    
	    
	    
	    	    @Test
	public void CreateEBFConfigandDeployment() {
		test.log(Status.INFO, "Login into the Policy service:"+PolicyServiceURL+" with the valid credentilas ");
		 driver.get(PolicyServiceURL);
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edgedesiger_UserName"), 50);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesiger_UserName"), username);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("Edgedesigner_PassWord"), password);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_Logon"));
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
		 functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
		  functionalcomponents.WaitTillTime(30000);
		 
		 
		  test.log(Status.INFO, "click on the EBF services  in the left side of the workcenter");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("services_button"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service_services"), 70); 
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service_services"));
		  functionalcomponents.WaitTillTime(4000);
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
		  EBFConfigName="EBFConfig"+CurrentDateandTime;
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Name_text"), EBFConfigName);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("EBFFileuploadradiobutton"));
		  functionalcomponents.WaitTillTime(2000);
		  driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"/Documents/EBF_Config_1909.json");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.scrollToExact(properties.getProperty("Add_button"));
		  functionalcomponents.ClickOperation(properties.getProperty("Add_button"));
		  functionalcomponents.WaitTillTime(4000);
		  if(driver.findElement(By.xpath(properties.getProperty("Groups_gateways"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is successfully added the configruation as:"+EBFConfigName+" to the EBF service");
			  
		  }
		  else
		  {
			  test.log(Status.PASS, "user is not able to  added the configruation as:"+EBFConfigName+" to the EBF service");
		  }	
		  
		
		  // deployment of EBF configuration
		  test.log(Status.INFO, "Add the EBF configuration to the gateway and do the deployement");
		  functionalcomponents.WaitTillTime(7000);	
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Edge_configurations"));	
		  functionalcomponents.WaitTillTime(5000);
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
		  functionalcomponents.WaitTillTime(50000);		
		  if(driver.findElement(By.xpath(properties.getProperty("config_refresh_btn"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user should able to add the configuration with name as"+" "+EBFConfigName+" "+"successfully");
		  } else
		  {
	          failedDescription("user should able to add the configuration with name as"+" "+EBFConfigName+" "+"not successfully");
	      }
		  test.log(Status.INFO, "Click on the Refresh button until status becomes Applied");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 300); 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("search_configname"),EBFConfigName);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("config_search_button"));
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 900);
		  for(int i=0; i<=40; i++) {
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("config_refresh_btn"), 500);
			  functionalcomponents.ClickOperation(properties.getProperty("config_refresh_btn"));		  
			  functionalcomponents.WaitTillTime(10000);
			  WebElement ele1=driver.findElement(By.xpath(properties.getProperty("Activated_msgpart1")+EBFConfigName+properties.getProperty("Activated_msgpart2")));
			  if(ele1.getText().equalsIgnoreCase("Applied"))
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
		  
			 // Accessing sensor model data from db
			  
			  String Sensorquery = "SELECT * from SENSOR_PROFILE"+" WHERE SENSOR_PROFILE_NAME != 'COMPOSITE'"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Sensore Profile as: ");

			  String SensorDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Sensorquery);
			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Sensore Profile are: "+SensorDB_Result);
			  
			  //Accessing Action
			  
			  String Actionquery =  "SELECT * FROM ACTION"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Actions");

			  String ActionDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Actionquery);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Action are: "+ActionDB_Result);
			  
			  //Accessing Rule Data
			  
			  String Rulequery = "SELECT * FROM RULE"; 
			  test.log(Status.INFO, "Retrieve Data from SQL Data Base table for Rules");

			  String RuleDB_Result=functionalcomponents.GetDatafromStreamingDataBase(DB_UserName, DB_Password, Rulequery);

			  test.log(Status.PASS, "Retrieved Data from SQL Data Base table for Rule are: "+RuleDB_Result);
	
			
	 }
	 

}
