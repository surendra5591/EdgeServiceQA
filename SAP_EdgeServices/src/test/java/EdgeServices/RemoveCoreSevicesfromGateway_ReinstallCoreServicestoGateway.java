package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class RemoveCoreSevicesfromGateway_ReinstallCoreServicestoGateway extends BaseTest {
	    
	    //Prerequisites 1. Gateway should up and online status.
	   //   2. Core Services should be installed to gateway 
	
	    FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	    Properties properties = FunctionalComponents.getObjectProperties();
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	    String GateWayNo = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "Gatewayno");
	    String Servicestatus="";
	    String Rownumber ="";
	
	    @Test
	   public void Services_Reinstall_Functionailty_Testcase() 
	    {
	    	EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
	    	edgeservicefunctions.LoginPolicyservice_MovetoEdgeServicemanagmentTile(PolicyServiceURL,username,password);
		    test.log(Status.INFO, "Search for the Gageway number to Remove already installed services");
		    functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Search_Gateway"), 90); 
		    functionalcomponents.ClearAndSetValue(properties.getProperty("Search_Gateway"),GateWayNo);
		    functionalcomponents.ClickOperation(properties.getProperty("searchbutton"));
		    functionalcomponents.WaitTillTime(2000);
		    functionalcomponents.ClickOperation((properties.getProperty("IOT_gateway_Restpart1")+GateWayNo+properties.getProperty("IOT_gateway_Restpart2")));
		    functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Gateway_Services_tab"), 50);
		    functionalcomponents.ClickOperation(properties.getProperty("Gateway_Services_tab"));	
		    functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
		    functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Service_refresh_btn"), 50);
		  // Removing Added Services from gateway
			  test.log(Status.PASS, "Click to remove services from gateway");
			  for(int i=1; i<=4; i++) {
			  if (functionalcomponents.IsElementPresent(properties.getProperty("Remove") ))
	  		  {	 
			  functionalcomponents.ClickOperation(properties.getProperty("Remove"));	  
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
			  functionalcomponents.WaitTillTime(40000);
			  functionalcomponents.ClickOperation(properties.getProperty("Service_refresh_btn"));
			  functionalcomponents.WaitTillTime(20000);
	  		  }
			  }
			  if (!functionalcomponents.IsElementPresent(properties.getProperty("EBFServiceinstaledRow") ))
	  		  {	 
				  test.log(Status.PASS, "EBF service is uninstalled successfully from gateway:"+GateWayNo);
				  
			  }
			  else
			  {
				  failedDescription("EBF services is not uninstalled successfully");
			  }
			  if (!functionalcomponents.IsElementPresent(properties.getProperty("PersistenceServiceinstalledRow")))
	  		  {	 
				  test.log(Status.PASS, "Persistence service is uninstalled successfully from gateway:"+GateWayNo);
				  
			  }
			  else
			  {
				  failedDescription("Persistence services is not uninstalled successfully");
			  }
			  if (!functionalcomponents.IsElementPresent(properties.getProperty("StreamingServiceinstalledRow")))
	  		  {	 
				  test.log(Status.PASS, "Streaming service is uninstalled successfully from gateway:"+GateWayNo);
				  
			  }
			  else
			  {
				  failedDescription("Streaming services is not uninstalled successfully");
			  }
			  // Reinstall Streaming service to gateway
			  test.log(Status.INFO, "reinstall the Core services to the gateway by clicking the + button");
			  edgeservicefunctions.InstalledAllCoreServicestoGateway(GateWayNo);
			  
			  

    }

}
