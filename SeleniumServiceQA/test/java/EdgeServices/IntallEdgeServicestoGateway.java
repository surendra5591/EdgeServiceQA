package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class IntallEdgeServicestoGateway extends BaseTest {
	
    Properties properties = functionalcomponents.getObjectProperties();
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
    String Servicestatus="";
    String Rownumber ="";
	
	@Test
	public void AddServicestoGateway() {
		test.log(Status.INFO, "open URL: " + PolicyServiceURL+ " Login successfully into the policyservice and click on the  GatewayManagement");
		driver.get(PolicyServiceURL);
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_name"), username);
		functionalcomponents.ClickAndSetValue(properties.getProperty("policyservice_pwd"), password);
		functionalcomponents.ClickOperation(properties.getProperty("Policyservice_login"));
		functionalcomponents.WaitTillTime(9000);
		if (driver.findElement(By.xpath(properties.getProperty("GatewayManagement"))).isDisplayed()) {
			test.log(Status.PASS, "user is able to enter into the HOME page successfully");
		} else {
			failedDescription("user is able to enter into the HOME page ");
		}
		test.log(Status.INFO, "click on the gateway management window");
		functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GatewayManagement"), 90);
		functionalcomponents.WaitTillTime(5000);
		functionalcomponents.ClickOperation(properties.getProperty("GatewayManagement"));
		functionalcomponents.WaitTillTime(30000);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("searchbutton"), 70);
		  if(driver.findElement(By.xpath(properties.getProperty("searchbutton"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user should able to click on the Gateway management successully");
		  } else
		  {
          failedDescription("user is not able to click on the Gateway Management successully");
          }
		  test.log(Status.INFO, "Search for the Gageway number  to add Streaming Service and Configuration");
		  functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
		  functionalcomponents.WaitTillTime(70000);
		  
		  //Adding Streaming service
		  if (!functionalcomponents.IsElementPresent(driver, properties.getProperty("StreamingServiceinstalledRow") ))
  		  {	 
		  test.log(Status.INFO, "Add the services to the group by clicking the + button");
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Streamingservice1"), 50);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Streamingservice1"));
		  functionalcomponents.WaitTillTime(2000);			  
		  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		  functionalcomponents.WaitTillTime(25000);
		  for(int i=1; i<40; i++)
		  {
		  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
		  functionalcomponents.WaitTillTime(30000);  
		  Rownumber=driver.findElement(By.xpath(properties.getProperty("StreamingServiceinstalledRow"))).getAttribute("data-sap-ui-rowindex");
		  Servicestatus=driver.findElement(By.xpath("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col2']//span[@class='sapMLabelTextWrapper']//bdi")).getText();
		  if(Servicestatus.equalsIgnoreCase("Installed"))
			  break;
		  }
		   if(Servicestatus.equalsIgnoreCase("Installed"))
			  {
				  test.log(Status.PASS, "Streaming service installed successfully to gateway:"+GateWayNo);
				  
			  }
		   else if(Servicestatus.equalsIgnoreCase("Error")){
			     failedDescription("Streaming service status is Error");
			   }
			  else
			  {
				  failedDescription("Streaming service is not installled");
			  }
  		  }
		  
		  //Adding Persistence service to gateway
		  if (!functionalcomponents.IsElementPresent(driver, properties.getProperty("PersistenceServiceinstalledRow") ))
  		  {	 
		  test.log(Status.INFO, "Add the services to the group by clicking the + button");
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Persistance_service"), 50);		  
		  functionalcomponents.ClickOperation(properties.getProperty("Persistance_service"));
		  functionalcomponents.WaitTillTime(2000);			  
		  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		  functionalcomponents.WaitTillTime(25000);
		  for(int i=1; i<40; i++)
		  {
		  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
		  functionalcomponents.WaitTillTime(30000);  
		  Rownumber=driver.findElement(By.xpath(properties.getProperty("PersistenceServiceinstalledRow"))).getAttribute("data-sap-ui-rowindex");
		  Servicestatus=driver.findElement(By.xpath("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col2']//span[@class='sapMLabelTextWrapper']//bdi")).getText();
		  if(Servicestatus.equalsIgnoreCase("Installed"))
			  break;
		  }
		   if(Servicestatus.equalsIgnoreCase("Installed"))
			  {
				  test.log(Status.PASS, "Persistence service installed successfully to gateway:"+GateWayNo);
				  
			  }
		   else if(Servicestatus.equalsIgnoreCase("Error")){
			     failedDescription("Persistence service status is Error");
			   }
			  else
			  {
				  failedDescription("Persistence service is not installled");
			  }
  		  }
		   
		  
		  //Adding EBF service to gateway
		  if (!functionalcomponents.IsElementPresent(driver, properties.getProperty("EBFServiceinstaledRow") ))
  		  {	 
		  test.log(Status.INFO, "Add the services to the group by clicking the + button");
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Add_ServicetoGW"));
		  functionalcomponents.WaitTillTime(10000);
		  functionalcomponents.ClickOperation(properties.getProperty("Service_dropdown1"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("EBF_Service"), 50);		  
		  functionalcomponents.ClickOperation(properties.getProperty("EBF_Service"));
		  functionalcomponents.WaitTillTime(2000);			  
		  functionalcomponents.ClickOperation(properties.getProperty("Addservicegroup_savebutton"));
		  functionalcomponents.WaitTillTime(25000);
		  for(int i=1; i<40; i++)
		  {
		  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
		  functionalcomponents.WaitTillTime(30000);  
		  Rownumber=driver.findElement(By.xpath(properties.getProperty("EBFServiceinstaledRow"))).getAttribute("data-sap-ui-rowindex");
		  Servicestatus=driver.findElement(By.xpath("//td[@id='ps_bundletable-rows-row"+Rownumber+"-col2']//span[@class='sapMLabelTextWrapper']//bdi")).getText();
		  if(Servicestatus.equalsIgnoreCase("Installed"))
			  break;
		  }
		   if(Servicestatus.equalsIgnoreCase("Installed"))
			  {
				  test.log(Status.PASS, "EBF service installed successfully to gateway:"+GateWayNo);
				  
			  }
		   else if(Servicestatus.equalsIgnoreCase("Error")){
			     failedDescription("EBF service status is Error");
			   }
			  else
			  {
				  failedDescription("EBF service is not installled");
			  }
  		  }
	}

}
