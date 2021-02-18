package EdgeServices;

import java.io.File;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class InboundConnectorTypeslistandOutBoundConnectortypeCreateUpdateandDelete extends BaseTest  {
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
    Properties properties = FunctionalComponents.getObjectProperties();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
    String OutboundConnectorTypeName="";
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
    String Parameterdatatype= functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "ParameterDatatype");
	
   
    @Test
    public void TC01_ViewList_InboundConnectorstypes()
    {
    	 EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
  	     edgeservicefunctions.LoginPolicyservice_MovetoEdgeDesignerTile(PolicyServiceURL,username,password);
		 test.log(Status.INFO, "Click on custom setting on left side and Click on Inbound connectors types link and verify the view list of default connectors");
   		 functionalcomponents.ClickOperation(properties.getProperty("customsetting"));
   		 functionalcomponents.WaitTillTime(15000);
 		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("InbounconnectorTypes"), 90); 
 		 functionalcomponents.WaitTillTime(2000);
 		 functionalcomponents.ClickOperation(properties.getProperty("InbounconnectorTypes"));
 		 if(functionalcomponents.IsElementPresent(properties.getProperty("DefaultHTTPInboundConnector"))&&functionalcomponents.IsElementPresent(properties.getProperty("DefaultIoTServiceEdgeConnector")))
 		 {
 			 test.log(Status.PASS, "User is able to see the view list of default connectors with HTTPInboundConnector and IoTServiceEdgeConnector");
 		 }
 		else 
		 {
			failedDescription("User is not able to see the view list of default connectors with HTTPInboundConnector and IoTServiceEdgeConnector");
		 }
    
    }
       
     @Test (dependsOnMethods = {"TC01_ViewList_InboundConnectorstypes"})
     public void TC02_GlobaloutboundConnectortypeandDeleting() {
    	 test.log(Status.INFO, "Click on Outbound connectors types link and Add Custom Outbound connector types");
   	     OutboundConnectorTypeName="ConnectortypeName"+CurrentDateandTime;
   	     String OutboundConnectorClassName="OutboundClassName"+functionalcomponents.GetRandomString();
   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("outboundconnectortypes"), 200); 
   		 functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypes"));
   		 functionalcomponents.WaitTillTime(8000);
   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Addoutboundconnectortypessymbol"),90); 
   		 functionalcomponents.ClickOperation(properties.getProperty("Addoutboundconnectortypessymbol"));
   		 functionalcomponents.WaitTillTime(4000);
   		 functionalcomponents.ClickAndSetValue(properties.getProperty("outboundconnectortypeName"), OutboundConnectorTypeName);
   		 functionalcomponents.WaitTillTime(2000);
   		 functionalcomponents.ClickAndSetValue(properties.getProperty("outboundconnectorclassname"), OutboundConnectorClassName);
   		 functionalcomponents.WaitTillTime(2000);
   		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir") + File.separator + "Documents" + File.separator + "CSVEnterprisePlugin-3.1909.0-SNAPSHOT.jar");
		functionalcomponents.WaitTillTime(2000);
		functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypecreatebutton"));
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickAndSetValue(properties.getProperty("outboundtypesearchinput"),OutboundConnectorTypeName);
		functionalcomponents.WaitTillTime(10000);
		functionalcomponents.ClickOperation(properties.getProperty("outboundconnectorsearchbutton"));
		functionalcomponents.WaitTillTime(5000);
		WebElement ele = driver.findElement(By.xpath("//a[@class='sapMLnk sapMLnkMaxWidth' and @title='" + OutboundConnectorTypeName + "']"));
  		  if(ele.getText().equalsIgnoreCase(OutboundConnectorTypeName))
  		  {
  			test.log(Status.PASS, "user is able to add custom outboundconnector type successfully as:"+OutboundConnectorTypeName);
  		  }
  		  else {
  			test.log(Status.FAIL, "user is not able to add custom outboundconnector type successfully");
  		  }
  		  test.log(Status.INFO, "user is adding parameters for custom outboundconnector type"); 
  		  functionalcomponents.ClickOperation("//a[@class='sapMLnk sapMLnkMaxWidth']");
  		  functionalcomponents.WaitTillTime(5000);
  		  functionalcomponents.ClickOperation(properties.getProperty("outboundparameter"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Addparameterbutton"));
		  functionalcomponents.WaitTillTime(4000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("outboundparametername"), "Parametername");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("parameterdatatypedropdown"));
		  functionalcomponents.WaitTillTime(1000);
  		  functionalcomponents.ClickOperation("//div[@class='sapMLIBContent']//div[text()='"+Parameterdatatype+"']");
  		  functionalcomponents.WaitTillTime(2000);
  		  functionalcomponents.ClearAndSetValue(properties.getProperty("parameterdisplayname"), "DispalyparameterName");
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("RequiredCheckbox"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("ParameterCreateButton"));
		  functionalcomponents.WaitTillTime(7000);
		  WebElement ele1=driver.findElement(By.xpath("//span[@title='DispalyparameterName']//bdi"));
 		  if(ele1.getText().equalsIgnoreCase("DispalyparameterName"))
 		  {
 			test.log(Status.PASS, "user is able to add parameter for custom outboundconnector type successfully as: DispalyparameterName");
 		  }
 		  else {
 			test.log(Status.FAIL, "user is not able to add parameter for custom outboundconnector type successfully");
 		  }
 		 test.log(Status.INFO, "Check wheather user is able click on outbound connector type link and able  to Delete outbound connector types successfully");
 		 functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypes"));
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("outboundtypesearchinput"), OutboundConnectorTypeName);
	     functionalcomponents.WaitTillTime(10000);
	     functionalcomponents.ClickOperation(properties.getProperty("outboundconnectorsearchbutton"));
		 functionalcomponents.WaitTillTime(5000);
		 driver.findElement(By.xpath("//a[@title='"+OutboundConnectorTypeName+"']")).click();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickOperation(properties.getProperty("DeleteOutboundconnectortypes"));
		 functionalcomponents.WaitTillTime(4000);
		 functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		 functionalcomponents.WaitTillTime(5000);
		 if (functionalcomponents.IsElementDisplayed(properties.getProperty("outboundtypesearchinput")))
		  {
	         test.log(Status.PASS, "user is able to Delete outbound connector types successfully :"+OutboundConnectorTypeName);
		  } else
		  {
	         failedDescription("user is not able to Delete outbound connector types successfully ");
	     } 
    }
     
     

}
