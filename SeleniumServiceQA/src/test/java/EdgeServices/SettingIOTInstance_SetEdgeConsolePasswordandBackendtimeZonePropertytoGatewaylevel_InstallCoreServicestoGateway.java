package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class SettingIOTInstance_SetEdgeConsolePasswordandBackendtimeZonePropertytoGatewaylevel_InstallCoreServicestoGateway extends BaseTest {
	
	 //prerequisite- Gateway should be up and online status.
	
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
    Properties properties = FunctionalComponents.getObjectProperties();
   
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
    String StreamingEdgeConsolepassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Stream_password"); 
    String InvalidName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "InvalidName");
    String Settingusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "SettingsIOTuser");
    String Settingpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "SettingsIOTPassword");
    String SettingIOTURL= functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "SettingsIOTURL");
    String Servicestatus="";
    String Rownumber ="";
	
	
    @Test
    public void SetEdgeIOTServicePlatform_SetEdgeConsolePasswordandAddCoreServicestoGateway()
    {
    	 test.log(Status.INFO, "open URL: " + PolicyServiceURL+ " Login successfully into the policyservice and click on the Settings tile");
 		driver.get(PolicyServiceURL);
 		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
 		//functionalcomponents.WaitTillTime(2000);
 		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("policyservice_pwd"), 90);
 		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
 		//functionalcomponents.WaitTillTime(2000);
 		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Policyservice_login"), 90);
 		functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
 		//functionalcomponents.WaitTillTime(9000);
 		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("settingstile"), 90);
 		if (functionalcomponents.IsElementDisplayed(properties.getProperty("settingstile")))
        {
 			test.log(Status.PASS, "user is able to enter into the HOME page successfully");
 		} else {
 			failedDescription("user is able to enter into the HOME page ");
 		}
 		test.log(Status.INFO, "click on the Settings tile");
 		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("settingstile"), 90);
 		//functionalcomponents.WaitTillTime(5000);
		 if(PolicyServiceURL.contains("qa6-aws"))
    	 {
			 test.log(Status.PASS, "user is not required to settings for one product policy service URL-"+PolicyServiceURL);
    	 }
		 else
	     {
		 functionalcomponents.ClickOperation(properties.getProperty("settingstile"));
		 functionalcomponents.WaitTillTime(15000);
   		 if(functionalcomponents.IsElementPresent(properties.getProperty("SAPIOT_Platform")))
   		 {
   			
   			 /*
   			 test.log(Status.INFO, "click on the Settings tile and Set IOT instance to policy service with invalid/Blank credentials");
   			functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_username"), " ");
   		    functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Settingstile_password"), 50);
   			functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_password"), Settingpassword);
   			functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("iot_serviceurl"), 50);
   		    functionalcomponents.ClearAndSetValue(properties.getProperty("iot_serviceurl"),SettingIOTURL);
   		    functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("savebutton"), 50);
   			functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
   	   	    functionalcomponents.WaitTillTime(5000);
   	     	functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_username"),InvalidName);
			functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	   	    functionalcomponents.WaitTillTime(5000);
	   	    if(driver.findElement(By.xpath(properties.getProperty("cancel_button"))).isDisplayed())
   		    {
   			test.log(Status.PASS, "user can not Set IOT instance to policy service with invalid/Blank credentials");
   		    }
   		    else
   		    {
   			failedDescription("User is able Set IOT instance to policy service with invalid/Blank credentials");
   		    } 
	   	      */
	   	    test.log(Status.INFO, "click on the Settings tile and Set IOT instance to policy service with valid credentials"); 
	   	    functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_username"),Settingusername);
  			functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_password"), Settingpassword);
		    functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
		    functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("cancel_button"), 90);
  	        //functionalcomponents.WaitTillTime(25000);
  	       if(driver.findElement(By.xpath(properties.getProperty("cancel_button"))).isDisplayed())
	        {
		    test.log(Status.PASS, " user is able to Set IOT instance to policy service with valid credentials");
	        }
	        else
	       {
		    failedDescription("User is not able Set IOT instance to policy service with valid credentials");
	       }
  	       functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
    	   //functionalcomponents.WaitTillTime(10000);
   	   }
   		 
   	  else
   	  {
   		test.log(Status.INFO, "Click on change platform link and select SAP IOT platform from dropdown");
   		functionalcomponents.ClickOperation(properties.getProperty("ChangePlatformLink"));
   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgePlatformsDropdown"), 300); 
   		functionalcomponents.WaitTillTime(2000);
   		functionalcomponents.ClickOperation(properties.getProperty("EdgePlatformsDropdown"));
   		functionalcomponents.WaitTillTime(2000);
   		functionalcomponents.ClickOperation(properties.getProperty("SAPIOTServicePlatform"));
   		functionalcomponents.WaitTillTime(3000);
   		functionalcomponents.ClickOperation(properties.getProperty("ProceedButton"));
   		functionalcomponents.WaitTillTime(3000);
   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("YesButtonforConfirmation"), 300); 
   		functionalcomponents.WaitTillTime(2000);
   		functionalcomponents.ClickOperation(properties.getProperty("YesButtonforConfirmation"));
   		functionalcomponents.WaitTillTime(3000);
   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Settingstile_username"), 300); 
   	    if(driver.findElement(By.xpath(properties.getProperty("Settingstile_username"))).isDisplayed())
	    {
		test.log(Status.PASS, "user is able to select SAP IOT platform from dropdown");
	    }
	    else
	    {
		failedDescription("user is not able to select SAP IOT platform from dropdown");
	    } 
   		test.log(Status.INFO, "Set IOT instance to policy service with invalid/Blank credentials");
   		functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_username"), " ");
   		functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_password"), Settingpassword);
	    functionalcomponents.ClearAndSetValue(properties.getProperty("iot_serviceurl"),SettingIOTURL);
		functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	   	functionalcomponents.WaitTillTime(5000);
	    functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_username"),InvalidName);
		functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
   	    functionalcomponents.WaitTillTime(5000);
   	    if(driver.findElement(By.xpath(properties.getProperty("cancel_button"))).isDisplayed())
		    {
			test.log(Status.PASS, "user can not Set IOT instance to policy service with invalid/Blank credentials");
		    }
		    else
		    {
			failedDescription("User is able Set IOT instance to policy service with invalid/Blank credentials");
		    } 
   	    test.log(Status.INFO, " Set IOT instance to policy service with valid credentials"); 
   		functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_username"),Settingusername);
		functionalcomponents.ClearAndSetValue(properties.getProperty("Settingstile_password"), Settingpassword);
	    functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	    functionalcomponents.WaitTillTime(15000);
	    if(driver.findElement(By.xpath(properties.getProperty("cancel_button"))).isDisplayed())
        {
	    test.log(Status.PASS,"user is able to Set IOT instance to policy service with correct credentials");
        }
        else
        {
	    failedDescription("User is not able Set IOT instance to policy service with correct credentials");
        }
	    functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
   	    functionalcomponents.WaitTillTime(10000);
   	 }
   		
  }
		  EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
		  edgeservicefunctions.VerifyGatewayStatus_SetEdgeConsolePasswordtoGateway(StreamingEdgeConsolepassword, GateWayNo);
		  edgeservicefunctions.Adding_BackendtimezonepropertytoGateway(GateWayNo);
		  edgeservicefunctions.StreamingServiceInstallationtoGateway(GateWayNo);
		  edgeservicefunctions.EBFServiceInstallationtoGateway(GateWayNo);
		  edgeservicefunctions.PersistenceServiceInstallationtoGateway(GateWayNo);
    }

}
