package POC_TestCases;

import java.util.Properties;

import org.openqa.selenium.By;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import UtilityComponent.FunctionalComponents;

public class ChangeEdgetoAzureandviceversawithAuthorizedcredentials extends BaseTest{
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
    Properties properties = functionalcomponents.getObjectProperties();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();	
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
    
    //Change to Azure Inputs
    String AzureClientID=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "AzureClientID");
    String AzureClientSecret=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "AzureClientSecret");
    String AzureResource=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "AzureResource");
    String AzureSubcriptionID=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "AzureSubcriptionID");
    String AzureTenantID=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "AzureTenantID");
    
    
    public void ChangeEdgeIOTtoAzureplatform()
    {
    	    test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
		    driver.get(PolicyServiceURL);
		    functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		    functionalcomponents.WaitTillTime(1000);
		    functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
			functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
			functionalcomponents.WaitTillTime(9000);
			if(driver.findElement(By.xpath(properties.getProperty("Settings_new"))).isDisplayed())
	   		 {
	   			 test.log(Status.PASS, "user is able to enter into the HOME page successfully");
	   		 }
	   		 else 
	   		 {
	   			failedDescription("user is able to enter into the HOME page ");
	   		 }
			  test.log(Status.INFO, "Click on the Setting tile from home page");
	   		 functionalcomponents.ClickOperation(properties.getProperty("settingstile"));
	   		 functionalcomponents.WaitTillTime(20000);
	   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("iot_serviceurl"), 300); 
	   		 String IotServiceUrl=driver.findElement(By.xpath(properties.getProperty("iot_serviceurl"))).getAttribute("value");
	   		 if(driver.findElement(By.xpath(properties.getProperty("iot_serviceurl"))).isDisplayed())
	   		 {
	   			test.log(Status.PASS, IotServiceUrl +"is displayed in the Edge IOT platform settings feild");
	   		 }
	   		 else
	   		 {
	   			failedDescription("iot_Service url is not displayed in the settings feild");
	   		 }
	   		 test.log(Status.INFO, "Click on change platform link and select AzureKubernetsService platform from dropdown");
	   		functionalcomponents.ClickOperation(properties.getProperty("ChangePlatformLink"));
	   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgePlatformsDropdown"), 300); 
	   		functionalcomponents.WaitTillTime(2000);
	   		functionalcomponents.ClickOperation(properties.getProperty("EdgePlatformsDropdown"));
	   		functionalcomponents.WaitTillTime(2000);
	   		functionalcomponents.ClickOperation(properties.getProperty("AzureKuberenetsServicePlatform"));
	   		functionalcomponents.WaitTillTime(3000);
	   		functionalcomponents.ClickOperation(properties.getProperty("ProceedButton"));
	   		functionalcomponents.WaitTillTime(3000);
	   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("YesButtonforConfirmation"), 300); 
	   		functionalcomponents.WaitTillTime(2000);
	   		functionalcomponents.ClickOperation(properties.getProperty("YesButtonforConfirmation"));
	   		functionalcomponents.WaitTillTime(3000);
	   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AzureKubernetsClientID"), 300); 
	   	 if(driver.findElement(By.xpath(properties.getProperty("AzureKubernetsClientID"))).isDisplayed())
   		 {
   			test.log(Status.PASS, "User is able to proceed to set Azure kubernets platform settings feild");
   		 }
   		 else
   		 {
   			failedDescription("User is not able to proceed to set Azure kubernets platform settings feild");
   		 }
	   	 test.log(Status.INFO, "Enter all valid values for AzureKubernetsService Setting Fileds and click on save button");
	   	 functionalcomponents.ClickAndSetValue(properties.getProperty("AzureKubernetsClientID"), AzureClientID);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("AzureKubernetsClientSecret"), AzureClientSecret);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("AzureKubernetsResource"), AzureResource);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("AzureKubernetsSubscriptionID"), AzureSubcriptionID);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("AzureKubernetsTenantID"), AzureTenantID);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
	   	 functionalcomponents.WaitTillTime(3000);
	   	 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AzureKubernetsClientID"), 300); 
	   	 if(driver.findElement(By.xpath(properties.getProperty("AzureKubernetsClientID"))).isDisplayed())
		 {
			test.log(Status.PASS, "User is able to proceed to set Azure kubernets platform settings feild");
		 }
		 else
		 {
			failedDescription("User is not able to proceed to set Azure kubernets platform settings feild");
		 }
    
    
    
    }
	

}
