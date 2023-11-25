package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class CustomPropertyCreation_AddingUserCustomPropertytoGateWay_EditUpdateDeleteProperty extends BaseTest {
	  
	   //Prerequisite:- Gateway should be up with online status
	    
	    FunctionalComponents functionalcomponents = new FunctionalComponents(driver);    
	    Properties properties = FunctionalComponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
	    String UserCustomPropertyName="UserProperty"+CurrentDateandTime;
	
	 @Test
  	 public void UserTypeCustomPropertiesCreateUpdateandDeleting()
	 {
	  
	  EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
	  edgeservicefunctions.LoginPolicyservice_MovetoEdgeServicemanagmentTile(PolicyServiceURL,username,password);
	  test.log(Status.INFO, "Check Default System Configuration properties is displayed");
  	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ConfigProperties"), 90);
      functionalcomponents.ClickOperation(properties.getProperty("ConfigProperties"));
      if (functionalcomponents.IsElementPresent("//span[@title='Plant_ID']")&&functionalcomponents.IsElementPresent("//span[@title='Business_Partner_ID']"))
	  {
		test.log(Status.PASS, "user can see Two System Custom Properties namely 'Business Partner ID' and 'Plant ID' present by default");
	  } else
	  {
        failedDescription("user can not find Two System Custom Properties namely 'Business Partner ID' and 'Plant ID' present by default");
      }
  	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddPropertiesbutton"), 90);
      functionalcomponents.ClickOperation(properties.getProperty("AddPropertiesbutton"));
      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("PropertyNameinput"), 50);
  	  //validate to enter invalid/Blank value to property name
  	  test.log(Status.INFO, "Creating Global Custom property with invalid Name");
  	  functionalcomponents.ClearAndSetValue(properties.getProperty("PropertyNameinput"), "Cus@#$&*@");
	  functionalcomponents.ClickOperation(properties.getProperty("CreatePeopertyNamebutton"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Close_Button"), 50);
      if (functionalcomponents.IsElementDisplayed(properties.getProperty("Close_Button")))
	  {
		test.log(Status.PASS, "user can not Create Global Custom Properties with invalid name please enter valid value");
	  } else
	  {
      failedDescription("user can Create Global Custom Properties with invalid name");
      }
  	  test.log(Status.INFO, "Creating Global Custom property without entering Name");
  	  functionalcomponents.ClickOperation(properties.getProperty("Close_Button"));
  	  functionalcomponents.ClearAndSetValue(properties.getProperty("PropertyNameinput"), "");
	  functionalcomponents.ClickOperation(properties.getProperty("CreatePeopertyNamebutton"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("PropertyNameinput"), 50);
	 if (functionalcomponents.IsElementDisplayed(properties.getProperty("PropertyNameinput")))
	  {
		test.log(Status.PASS, "user can not Create Global Custom Properties without entering name please enter valid value");
	  } else
	  {
        failedDescription("user can Create Global Custom Properties without entering name");
      }
	  test.log(Status.INFO, "Creating Global Custom property with Valid Name");
  	  functionalcomponents.ClearAndSetValue(properties.getProperty("PropertyNameinput"), UserCustomPropertyName);
      functionalcomponents.ClickOperation(properties.getProperty("CreatePeopertyNamebutton"));
  	  WebElement CreatedName=driver.findElement(By.xpath("//span[text()='"+UserCustomPropertyName+"']"));
	  if(CreatedName.getText().equalsIgnoreCase(UserCustomPropertyName))
	  {
		  test.log(Status.PASS, "user is able to Create Global Custom Properties as:"+UserCustomPropertyName);
	  } else
	  {
       failedDescription("user is not able to Create Global Custom Properties");
     }  
   	
 }
	 
	     @Test(dependsOnMethods={"UserTypeCustomPropertiesCreateUpdateandDeleting"})
		 public void AddingCustomPropertiestoGateway() 
		 {
		  test.log(Status.INFO, "Adding User Custom property to the Gateway");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(7000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddPropertytoGWButton"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("AddPropertytoGWButton"));
		  String CustomPropertyRownum =driver.findElement(By.xpath("//bdi[text()='"+UserCustomPropertyName+"']//ancestor::tr")).getAttribute("data-sap-ui-rowindex");
		  driver.findElement(By.xpath("//div[@data-sap-ui-rowindex='"+CustomPropertyRownum+"']//div[@title='Click to Select']")).click();
		  functionalcomponents.ClearAndSetValue("//td[@id='gps_addpropertytable-rows-row"+CustomPropertyRownum+"-col1']//input", "AnyValue1234");
		  functionalcomponents.ClickOperation(properties.getProperty("AddConfigpropertybutton"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddPropertytoGWButton"), 90);
		  if(functionalcomponents.IsElementPresent(properties.getProperty("AddPropertytoGWButton")))
		  {
			  test.log(Status.PASS, "user is able to add the Custom configuration Property to Gateway as:"+" "+UserCustomPropertyName+" "+"successfully");
		  } else
		  {
	          failedDescription("user is not able to add the Custom configuration Property to Gateway");
	      }
	 }
	 
	 @Test (dependsOnMethods={"AddingCustomPropertiestoGateway"})
	 public void RemovepropertyfromgatewayandDeleteUserConfigProperty()
	 {
		  test.log(Status.INFO, "Verify to delete Custom property when property already added to Gateway");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ConfigProperties"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("ConfigProperties"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SearchGlobalConfigProperty_input"), 90);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("SearchGlobalConfigProperty_input"),UserCustomPropertyName);
		  functionalcomponents.ClickOperation(properties.getProperty("Globalconfigsearchbutton"));
		  functionalcomponents.ClickOperation((properties.getProperty("GlobalConfigPropertylink1")+UserCustomPropertyName+properties.getProperty("GlobalConfigPropertylink2")));
		  functionalcomponents.WaitTillTime(1000);
		  if (!functionalcomponents.IsElementPresent(properties.getProperty("DeleteCongifProperty")))
		  {	 
			  test.log(Status.PASS, "when property added to gateway, user can not Delete Global Custom Properties:"+UserCustomPropertyName);
		  }
		  else
		  {
	       failedDescription("when property added to gateway, user is able to Delete Global Custom Properties:"+UserCustomPropertyName);
	     }
		  test.log(Status.INFO, "Remove Custom property already added to Gateway");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddPropertytoGWButton"), 90);
		  functionalcomponents.scrollToExact(properties.getProperty("EditPropertytoGateway"));
		  functionalcomponents.ClickOperation(properties.getProperty("EditPropertytoGateway"));
		  functionalcomponents.ClickOperation("//span[@title='"+UserCustomPropertyName+"']//ancestor::tr//button");
		  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
		  functionalcomponents.WaitTillTime(1000);
		  if (!functionalcomponents.IsElementPresent("//span[@title='"+UserCustomPropertyName+"']"))
		  {
				test.log(Status.PASS, "user is able to Delete Global Custom Properties from gateway:"+UserCustomPropertyName);
		  } else
			  
		  {
		       failedDescription("user is not able to Delete Global Custom Properties from gateway");
		  }
		  test.log(Status.INFO, "Verify to delete Custom property when property is not added to Gateway");
		  functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EdgeServiceManagementTile"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("EdgeServiceManagementTile"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ConfigProperties"), 90);
		  functionalcomponents.ClickOperation(properties.getProperty("ConfigProperties"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SearchGlobalConfigProperty_input"), 90);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("SearchGlobalConfigProperty_input"),UserCustomPropertyName);
		  functionalcomponents.ClickOperation(properties.getProperty("Globalconfigsearchbutton"));
		  functionalcomponents.ClickOperation((properties.getProperty("GlobalConfigPropertylink1")+UserCustomPropertyName+properties.getProperty("GlobalConfigPropertylink2")));
		  functionalcomponents.ClickOperation(properties.getProperty("DeleteCongifProperty"));
	  	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
	  	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("SearchGlobalConfigProperty_input"), 90);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("SearchGlobalConfigProperty_input"),UserCustomPropertyName);
		  functionalcomponents.ClickOperation(properties.getProperty("Globalconfigsearchbutton"));
		  if (!functionalcomponents.IsElementPresent("//bdi[text()='"+UserCustomPropertyName+"']"))
		  {
			test.log(Status.PASS, "user is able to Delete Global Custom Properties:"+UserCustomPropertyName);
		  } else
		  {
	       failedDescription("user is not able to Delete Global Custom Properties");
	      }
	 }
	 
}