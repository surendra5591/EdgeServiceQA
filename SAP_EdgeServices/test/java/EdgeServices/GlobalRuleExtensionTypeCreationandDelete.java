package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GlobalRuleExtensionTypeCreationandDelete extends BaseTest  {
		 
	    Properties properties = functionalcomponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String RuleExtensionTypeName="";
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
		
	    @Test
	     public void CreateRuleExtensionTypeandDeleting() throws Exception {
	
	   	    RuleExtensionTypeName="RuleExtensiontypeName"+CurrentDateandTime;
	   	    String RuleExtensionClassName="RueExtensionClassName"+functionalcomponents.GetRandomString();
	   	    test.log(Status.INFO, "Login into the Policy service:"+PolicyServiceURL+" with the valid credentilas ");
	   	    driver.get(PolicyServiceURL);
			test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
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
	   		 test.log(Status.INFO, "Click on Edge designer tile of the Home Page");
	   		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
	   		 functionalcomponents.WaitTillTime(30000);
	   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edge_designer_version"), 200); 
	   		 functionalcomponents.ClickOperation(properties.getProperty("Edge_designer_version"));
	   		 functionalcomponents.WaitTillTime(5000);
	   		 String Versionvalue1=driver.findElement(By.xpath(properties.getProperty("Edge_Designer_versionvalue"))).getText();
	   		 functionalcomponents.WaitTillTime(5000);
	   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("customsetting"), 90); 			 
	   		 functionalcomponents.WaitTillTime(2000);
	   		 if(driver.findElement(By.xpath(properties.getProperty("customsetting"))).isDisplayed())
	   		 {	
	   			test.log(Status.PASS, "Edge desinger tile window opens successfully and version of the Edge designer is"+Versionvalue1);
	   		 }
	   		 else 
	   		 {
	   			failedDescription("Edge designer tile is not opened successfully");
	   		 }
	   		 test.log(Status.INFO, "Click on custom setting on left side and add RuleExtension type");
	   		 functionalcomponents.ClickOperation(properties.getProperty("customsetting"));
	   		 functionalcomponents.WaitTillTime(7000);
	   		functionalcomponents.ClickOperation(properties.getProperty("RuleExtensionTypeLink"));
	   		functionalcomponents.WaitTillTime(500);
	   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddRuleExtensionType"), 90); 			 
	   		 functionalcomponents.WaitTillTime(2000);
	   		functionalcomponents.ClickOperation(properties.getProperty("AddRuleExtensionType"));
	   		functionalcomponents.WaitTillTime(500);
	   		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("RuleExtensionTypeName"), 90); 			 
	   		functionalcomponents.ClickAndSetValue(properties.getProperty("RuleExtensionTypeName"), RuleExtensionTypeName);
	   		 functionalcomponents.WaitTillTime(2000);
	   		 functionalcomponents.ClickAndSetValue(properties.getProperty("RuleExtensionTpeClassName"), RuleExtensionClassName);
	   		 functionalcomponents.WaitTillTime(2000);
	   		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\Documents\\CSVEnterprisePlugin-3.1909.0-SNAPSHOT.jar");
			functionalcomponents.WaitTillTime(2000);
			functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypecreatebutton"));
			functionalcomponents.WaitTillTime(5000);
			functionalcomponents.ClickAndSetValue(properties.getProperty("outboundtypesearchinput"),RuleExtensionTypeName);
			functionalcomponents.WaitTillTime(10000);
			functionalcomponents.ClickOperation(properties.getProperty("outboundconnectorsearchbutton"));
			functionalcomponents.WaitTillTime(5000);
			WebElement ele = driver.findElement(By.xpath("//a[@class='sapMLnk sapMLnkMaxWidth' and @title='" + RuleExtensionTypeName + "']"));
	  		  if(ele.getText().equalsIgnoreCase(RuleExtensionTypeName))
	  		  {
	  			test.log(Status.PASS, "user is able to add custom Rule extension type successfully as:"+RuleExtensionTypeName);
	  		  }
	  		  else
	  		  {
	  			test.log(Status.FAIL, "user is not able to add custom rule extension type successfully");
	  		  }
	   		
	     }
	     
	     

	}
