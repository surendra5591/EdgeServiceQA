package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CreateCustomoutboundConnectortype extends BaseTest  {
	 
    Properties properties = functionalcomponents.getObjectProperties();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
    String OutboundConnectorTypeName="";
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "PolicyServiceURL");
    String username = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "username");
    String password = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "password");
    String Parameterdatatype= functionalcomponents.getdatafromsheet("CockPit", "E2E_Edge_TestCases", "ParameterDatatype");
	
    @Test
     public void CreateCustomoutboundConnectortypeandDeleting() throws Exception {
   	  
   	     OutboundConnectorTypeName="ConnectortypeName"+CurrentDateandTime;
   	     String OutboundConnectorClassName="OutboundClassName"+functionalcomponents.GetRandomString();
   	     System.out.println(OutboundConnectorClassName);
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
   		 functionalcomponents.WaitTillTime(20000);
   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Edge_designer_version"), 200); 
   		 functionalcomponents.ClickOperation(properties.getProperty("Edge_designer_version"));
   		 functionalcomponents.WaitTillTime(5000);
   		 String Versionvalue1=driver.findElement(By.xpath(properties.getProperty("Edge_Designer_versionvalue"))).getText();
   		 functionalcomponents.WaitTillTime(5000);
   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90); 			 
   		 functionalcomponents.WaitTillTime(2000);
   		 if(driver.findElement(By.xpath(properties.getProperty("Project_Addbutton"))).isDisplayed())
   		 {	
   			test.log(Status.PASS, "Edge desinger tile window opens successfully and version of the Edge designer is"+Versionvalue1);
   		 }
   		 else 
   		 {
   			failedDescription("Edge designer tile is not opened successfully");
   		 }
   		 test.log(Status.INFO, "Click on custom setting on left side and add custom outbound connector type");
   		 functionalcomponents.ClickOperation(properties.getProperty("customsetting"));
   		 functionalcomponents.WaitTillTime(10000);
   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("outboundconnectortypes"), 200); 
   		 functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypes"));
   		 functionalcomponents.WaitTillTime(4000);
   		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Addoutboundconnectortypessymbol"),90); 
   		 functionalcomponents.ClickOperation(properties.getProperty("Addoutboundconnectortypessymbol"));
   		 functionalcomponents.WaitTillTime(4000);
   		 functionalcomponents.ClickAndSetValue(properties.getProperty("outboundconnectortypeName"), OutboundConnectorTypeName);
   		 functionalcomponents.WaitTillTime(2000);
   		 functionalcomponents.ClickAndSetValue(properties.getProperty("outboundconnectorclassname"), OutboundConnectorClassName);
   		 functionalcomponents.WaitTillTime(2000);
   		 driver.findElement(By.xpath("//input[@type='file']")).sendKeys(System.getProperty("user.dir")+"\\\\Documents\\\\CSVEnterprisePlugin-3.1909.0-SNAPSHOT.jar");
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
		  functionalcomponents.WaitTillTime(5000);
		  WebElement ele1=driver.findElement(By.xpath("//span[@title='DispalyparameterName']//bdi"));
 		  if(ele1.getText().equalsIgnoreCase("DispalyparameterName"))
 		  {
 			test.log(Status.PASS, "user is able to add parameter for custom outboundconnector type successfully as: DispalyparameterName");
 		  }
 		  else {
 			test.log(Status.FAIL, "user is not able to add parameter for custom outboundconnector type successfully");
 		  }

 		 functionalcomponents.ClickOperation(properties.getProperty("outboundconnectortypes"));
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("outboundtypesearchinput"), OutboundConnectorTypeName);
	     functionalcomponents.WaitTillTime(10000);
	     functionalcomponents.ClickOperation(properties.getProperty("outboundconnectorsearchbutton"));
		 functionalcomponents.WaitTillTime(5000);
		 driver.findElement(By.xpath("//a[@class='sapMLnk sapMLnkMaxWidth' and @title='"+OutboundConnectorTypeName+"']")).click();
		 functionalcomponents.WaitTillTime(5000);
		 functionalcomponents.ClickOperation(properties.getProperty("DeleteOutboundconnectortypes"));
		 functionalcomponents.WaitTillTime(4000);
		 functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		 functionalcomponents.WaitTillTime(5000);
		 if (driver.findElement(By.xpath(properties.getProperty("outboundtypesearchinput"))).isDisplayed())
		  {
	         test.log(Status.PASS, "user is able to Delete outbound connector types successfully :"+OutboundConnectorTypeName);
		  } else
		  {
	         failedDescription("user is not able to Delete outbound connector types successfully ");
	     } 
     }
     
     

}
