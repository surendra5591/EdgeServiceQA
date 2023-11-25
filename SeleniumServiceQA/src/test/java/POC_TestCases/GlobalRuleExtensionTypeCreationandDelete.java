package POC_TestCases;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class GlobalRuleExtensionTypeCreationandDelete extends BaseTest  {
	    FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	    Properties properties = FunctionalComponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String RuleExtensionTypeName="";
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	    String InvalidName=functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "InvalidName");

	        @Test
	        public void TC01_RuleExtensionTypeCreationUpdateDelete() throws Exception {
	   	    RuleExtensionTypeName="RuleExtensiontypeName"+CurrentDateandTime;
	   	    String RuleExtensionClassName="RueExtensionClassName"+functionalcomponents.GetRandomString();
	   	     EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
  	         edgeservicefunctions.LoginPolicyservice_MovetoEdgeDesignerTile(PolicyServiceURL,username,password);
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
	   		functionalcomponents.ClearAndSetValue(properties.getProperty("RuleExtensionTypeName"), InvalidName);
	   		functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypecreatebutton"));
			functionalcomponents.WaitTillTime(3000);
	   	 if(driver.findElement(By.xpath(properties.getProperty("outboundconnectortypecreatebutton"))).isDisplayed())
		 {
	   		test.log(Status.PASS, "user can not add custom Rule extension type with invalid Name");
		  }
		  else
		  {
			test.log(Status.FAIL, "user is able to add custom Rule extension type with invalid Name successfully");
		  }
	   		functionalcomponents.ClearAndSetValue(properties.getProperty("RuleExtensionTypeName"), RuleExtensionTypeName);
	   		 functionalcomponents.WaitTillTime(2000);
	   		 functionalcomponents.ClickAndSetValue(properties.getProperty("RuleExtensionTpeClassName"), RuleExtensionClassName);
	   		 functionalcomponents.WaitTillTime(2000);
	   		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+File.separator+"Documents"+File.separator+"CSVEnterprisePlugin-3.1909.0-SNAPSHOT.jar");
			functionalcomponents.WaitTillTime(2000);
			functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypecreatebutton"));
			functionalcomponents.WaitTillTime(5000);
			functionalcomponents.ClickAndSetValue(properties.getProperty("outboundtypesearchinput"),RuleExtensionTypeName);
			functionalcomponents.WaitTillTime(10000);
			functionalcomponents.ClickOperation(properties.getProperty("outboundconnectorsearchbutton"));
			functionalcomponents.WaitTillTime(5000);
			WebElement ele = driver.findElement(By.xpath("//a[@title='"+RuleExtensionTypeName+"']"));
	  		  if(ele.getText().equalsIgnoreCase(RuleExtensionTypeName))
	  		  {
	  			test.log(Status.PASS, "user is able to add custom Rule extension type successfully as:"+RuleExtensionTypeName);
	  		  }
	  		  else
	  		  {
	  			test.log(Status.FAIL, "user is not able to add custom rule extension type successfully");
	  		  }
	  		  
	         test.log(Status.INFO, "Check Wheather user is able to click rule extention type link and edit custom Rule extension type and saved successfully");
	  		 functionalcomponents.ClickOperation("//a[@title='"+RuleExtensionTypeName+"']");
			 functionalcomponents.WaitTillTime(5000);
			 functionalcomponents.ClickOperation(properties.getProperty("EditOutBoundConnectorType"));
			 functionalcomponents.WaitTillTime(3000);
			 functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
			 functionalcomponents.WaitTillTime(5000);
			 if(driver.findElement(By.xpath(properties.getProperty("EditOutBoundConnectorType"))).isDisplayed())
			 {
		   		test.log(Status.PASS, "user is able to edit custom Rule extension type and saved successfully");
			  }
			  else
			  {
				test.log(Status.FAIL, "user is not able to edit custom Rule extension type and saved successfully");
			  }
			 test.log(Status.INFO, "check wheather user is able to Delete custom Rule extension type successfully");
			 functionalcomponents.ClickOperation(properties.getProperty("DeleteRuleExtensionsTypeButton"));
			 functionalcomponents.WaitTillTime(2000);
			 functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
			 functionalcomponents.WaitTillTime(7000);
			 if(driver.findElement(By.xpath(properties.getProperty("AddRuleExtensionType"))).isDisplayed())
			 {
		   		test.log(Status.PASS, "user is able to Delete custom Rule extension type successfully");
			  }
			  else
			  {
				test.log(Status.FAIL, "user is not able to Delete custom Rule extension type successfully");
			  }
	   		
	     }
	     	     

	}
