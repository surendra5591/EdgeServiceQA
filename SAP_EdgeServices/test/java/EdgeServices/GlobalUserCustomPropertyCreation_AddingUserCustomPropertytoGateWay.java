package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GlobalUserCustomPropertyCreation_AddingUserCustomPropertytoGateWay extends BaseTest {
	
	   Properties properties = functionalcomponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
	    
	    String PlantID_Value = functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "Plant_ID");
	    String UserCustomPropertyName="UserProperty"+CurrentDateandTime;
	
	 @Test (priority=1)
  	public void CreateUserTypeCustomPropertiesandDeleting()
	 {
      
		test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
		driver.get(PolicyServiceURL);
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
	  
   	
 }
	 
	 @Test (priority=2, dependsOnMethods = { "CreateUserTypeCustomPropertiesandDeleting" })
		 public void AddingCustomPropertiestoGatewayandDeployEBFConfiguration() 
	 {
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
	 }
	 
	 @Test (priority=3, dependsOnMethods = { "AddingCustomPropertiestoGatewayandDeployEBFConfiguration" })
	 public void DeleteUserConfigProperty()
	 {
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		  functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SearchGlobalConfigProperty_input"), 90);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("SearchGlobalConfigProperty_input"),UserCustomPropertyName);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Globalconfigsearchbutton"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("GlobalConfigPropertylink1")+UserCustomPropertyName+properties.getProperty("GlobalConfigPropertylink1")));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ConfigProperties"), 90);
	     // functionalcomponents.ClickOperation(properties.getProperty("ConfigProperties"));
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
	 
}