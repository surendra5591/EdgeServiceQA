package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class GlobalRDSCreationAndDelete extends BaseTest{
	
	    Properties properties = functionalcomponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();	
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	   
	    String Ruledatasourcename  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleDsname");
	    String Ruledsdesc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "RuleDs_description");
	    String Authenticaion_type=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "AuthenticationType");
	    String Custom_headers  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Custom Headers");
	    String Date_format  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Date Format");
	    String updatefrequency  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Updatefrequency");
	    String Response_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Response_Type");
	    String Global_RuleDatasource=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Global_RuleDatasource");
	    String contentype_headervalue  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "contenttype_Header_value");
	    String Request_body_template  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Request_body_Template");
	    String RDSGetName="";
	    String RDSPOSTName="";
	    @Test (priority =1)
	    public void CreateRDSwithGetMethod()
	   {
		
		RDSGetName=Ruledatasourcename+"GET"+CurrentDateandTime;
		test.log(Status.INFO, "open URL: "+PolicyServiceURL+" Login successfully into the policyservice and click on the  GatewayManagement");
 		driver.get(PolicyServiceURL);
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
	 test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
	 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
	 functionalcomponents.WaitTillTime(30000); 
	//Rule Data source
	  test.log(Status.INFO, "Click on the Rule Data source link from left side navigation");
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("GlobalRDSLink"));
	  functionalcomponents.WaitTillTime(9000);
	  functionalcomponents.ClickOperation(properties.getProperty("AddRDSButton"));
	  functionalcomponents.WaitTillTime(4000);
	  if(driver.findElement(By.xpath(properties.getProperty("RDSNameInput"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to add the Rule data source successfully");
	  } else
	  {
         failedDescription("user is not able to add the Rule data source");	              		 
	  }
	  test.log(Status.INFO, "Enter the Rule name and description with special characters");			
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSNameInput"),RDSGetName);
	  functionalcomponents.WaitTillTime(1000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"),Ruledsdesc);
	  functionalcomponents.WaitTillTime(2000);
	  if(driver.findElement(By.xpath(properties.getProperty("RDSEndpointulrinput"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to enter the Rule name as"+":"+RDSGetName+" successfully");
	  } else
	  {
         failedDescription("user is not able to enter the Rule name and descrition in the rule datasource window");	              		 
	  }	
	  test.log(Status.INFO, "Enter the HTTP_Endpoint url and select the Request method from dropdown");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSEndpointulrinput"),"https://sdsss.com:818");
	  functionalcomponents.WaitTillTime(2000);			
	  functionalcomponents.ClickOperation(properties.getProperty("RDSRequestMethoddropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("RDSGETRequestMethod"));
	  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("Authentication_type_dropdown"))).isDisplayed())
		  {
			  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as GET");
		  } else
		  {
             failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as GET");	              		 
		  }
		 
	  test.log(Status.INFO, "Select the Authentication type and enter the value for update freqency");	
	  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_dropdown"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_part1")+Authenticaion_type+properties.getProperty("Authentication_type_part2"));
	  functionalcomponents.WaitTillTime(2000);			 			 		 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Update_frequency"),updatefrequency);
	  functionalcomponents.WaitTillTime(1000);
	  if(driver.findElement(By.xpath(properties.getProperty("Custom_Headers"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);
	  } else
	  {
         failedDescription("user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);	              		 
	  }
	  test.log(Status.INFO, "Enter the value for Custom Headers and Date format in the Rule datasoruce window");	
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Custom_Headers"),Custom_headers);
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("date_format"),Date_format);
	  functionalcomponents.WaitTillTime(1000);
	  if(driver.findElement(By.xpath(properties.getProperty("Rue_Datasource_Create"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);
	  } else
	  {
         failedDescription("user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);	              		 
	  }
	  test.log(Status.INFO, "Select the Resonse type and click on the Create button to save the Rule data source successfully");			  
	  functionalcomponents.PageScrollDown();
	  functionalcomponents.ClickOperation(properties.getProperty("Respnse_type_dropdown"));
	  functionalcomponents.ClickOperation(properties.getProperty("Response_type_part1")+Response_type+properties.getProperty("Response_type_part2"));
	  functionalcomponents.WaitTillTime(2000);
	  functionalcomponents.ClickOperation(properties.getProperty("Rue_Datasource_Create"));
	  functionalcomponents.WaitTillTime(7000);
	  if(driver.findElement(By.xpath(properties.getProperty("AddRDSButton"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to select the Respnse type as"+":"+Response_type+"and successfully saved the Rule data source as"+":"+Response_type);
	  } else
	  {
         failedDescription("user is not able to create the Rule Datasource");	              		 
	  }
	 
	}
	  
	    @Test (priority=2, dependsOnMethods = {"CreateRDSwithGetMethod"})
	    public void Edit_Update_Save_DeleteGetMethodRDS() {
	    	  test.log(Status.INFO, "Edit Created RDS Description field and click save button");
	    	  functionalcomponents.ClickOperation(properties.getProperty("EditRDSiconbutton"));
			  functionalcomponents.WaitTillTime(6000);
	    	  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"), "Updated"); 
			  functionalcomponents.WaitTillTime(2000);	
			  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
			  functionalcomponents.WaitTillTime(7000);
			  String RDSupdatedname=driver.findElement(By.xpath("//span[text()='"+RDSGetName+"']")).getText();
			  if(RDSupdatedname.equalsIgnoreCase(RDSGetName))
			  {
				  test.log(Status.PASS, "user is able to Update the Global RDS name as:"+RDSGetName);		  }
			  else
			  {
	              failedDescription("user is not able to Update the Global RDS ");
	          }	
			  test.log(Status.INFO, "Select Created RDS and click delete button");
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteRuleDataSource"));
			  functionalcomponents.WaitTillTime(3000);
		   	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		 	  functionalcomponents.WaitTillTime(7000);
		 	 if (driver.findElement(By.xpath(properties.getProperty("AddRDSButton"))).isDisplayed())
			  {
		 		test.log(Status.PASS, "user is able to Delete Global RDS:"+RDSGetName);
			  } else
			  {
		        failedDescription("user is not able to Delete Global Outbound Connector");
		      }
			  
	    	
	    }
	    
	    
	    @Test (priority=3)
	   public void CreateRDSwithPostMethod() {
		   test.log(Status.INFO, "Create RDS with post method request and Enter the name and description");
		  RDSPOSTName=Ruledatasourcename+"POST"+CurrentDateandTime;
		  functionalcomponents.ClickOperation(properties.getProperty("AddRDSButton"));
		  functionalcomponents.WaitTillTime(2000);		
		  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSNameInput"),RDSPOSTName);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"),"Ruledsdesc");
		  functionalcomponents.WaitTillTime(2000);
		  if(driver.findElement(By.xpath(properties.getProperty("RDSEndpointulrinput"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to enter the Rule data source name as"+":"+RDSPOSTName+" successfully");
		  } else
		  {
	         failedDescription("user is not able to enter the Rule name and descrition in the rule datasource window");	              		 
		  }	
		  test.log(Status.INFO, "Enter the HTTP_Endpoint url and select the Request method from dropdown");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSEndpointulrinput"),"https://sdsss.com:818");
		  functionalcomponents.WaitTillTime(2000);			
		  functionalcomponents.ClickOperation(properties.getProperty("RDSRequestMethoddropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("RDSPostRequestMethod"));
		  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Authentication_type_dropdown"))).isDisplayed())
			  {
				  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as POST");
			  } else
			  {
	             failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as POST");	              		 
			  }
			  test.log(Status.INFO, "Enter the values for content_type header and Request body Template");
			  functionalcomponents.ClickAndSetValue(properties.getProperty("content_type_Header"),contentype_headervalue);
			  functionalcomponents.WaitTillTime(2000);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Request_BodyTemplate"),Request_body_template);
			  functionalcomponents.WaitTillTime(2000);
			  if(driver.findElement(By.xpath(properties.getProperty("Authentication_type_dropdown"))).isDisplayed())
			  {
				  test.log( Status.PASS, "user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);
			  } else
			  {
	             failedDescription("user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);	              		 
			  }  
		
		  test.log(Status.INFO, "Select the Authentication type and enter the value for update freqency");	
		  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_dropdown"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_part1")+Authenticaion_type+ properties.getProperty("Authentication_type_part2"));
		  functionalcomponents.WaitTillTime(2000);			 			 		 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Update_frequency"),updatefrequency);
		  functionalcomponents.WaitTillTime(1000);
		  if(driver.findElement(By.xpath(properties.getProperty("Custom_Headers"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);
		  } else
		  {
	         failedDescription("user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);	              		 
		  }
		  test.log(Status.INFO, "Enter the value for Custom Headers and Date format in the Rule datasoruce window");	
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Custom_Headers"),Custom_headers);
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("date_format"),Date_format);
		  functionalcomponents.WaitTillTime(1000);
		  if(driver.findElement(By.xpath(properties.getProperty("Rue_Datasource_Create"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);
		  } else
		  {
	         failedDescription("user is able to enter the custom_Headers as"+":"+Custom_headers+":"+"and date format as"+":"+Date_format);	              		 
		  }
		  test.log(Status.INFO, "Select the Resonse type and click on the Create button to save the Rule data source successfully");			  
		  functionalcomponents.PageScrollDown();
		  functionalcomponents.ClickOperation(properties.getProperty("Respnse_type_dropdown"));
		  functionalcomponents.ClickOperation(properties.getProperty("Response_type_part1")+Response_type+properties.getProperty("Response_type_part2"));
		  functionalcomponents.WaitTillTime(2000);
		  functionalcomponents.ClickOperation(properties.getProperty("Rue_Datasource_Create"));
		  functionalcomponents.WaitTillTime(7000);
		  if(driver.findElement(By.xpath(properties.getProperty("AddRDSButton"))).isDisplayed())
		  {
			  test.log(Status.PASS, "user is able to select the Respnse type as"+":"+Response_type+"and successfully saved the Rule data source as"+":"+Response_type);
		  } else
		  {
	         failedDescription("user is not able to create the Rule Datasource");	              		 
		  }
		
	}

	    @Test (priority=4, dependsOnMethods = {"CreateRDSwithPostMethod"})
	    public void Edit_Update_Save_DeletePostMethodRDS() {
	    	  test.log(Status.INFO, "Edit Created RDS Description field and click save button");
	    	  functionalcomponents.ClickOperation(properties.getProperty("EditRDSiconbutton"));
			  functionalcomponents.WaitTillTime(6000);
	    	  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"), "Updated"); 
			  functionalcomponents.WaitTillTime(2000);	
			  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
			  functionalcomponents.WaitTillTime(7000);
			  String RDSupdatedname=driver.findElement(By.xpath("//span[text()='"+RDSPOSTName+"']")).getText();
			  if(RDSupdatedname.equalsIgnoreCase(RDSGetName))
			  {
				  test.log(Status.PASS, "user is able to Update the Global RDS name as:"+RDSPOSTName);		  }
			  else
			  {
	              failedDescription("user is not able to Update the Global RDS ");
	          }	
			  test.log(Status.INFO, "Select Created RDS and click delete button");
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteRuleDataSource"));
			  functionalcomponents.WaitTillTime(3000);
		   	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		 	  functionalcomponents.WaitTillTime(7000);
		 	 if (driver.findElement(By.xpath(properties.getProperty("AddRDSButton"))).isDisplayed())
			  {
		 		test.log(Status.PASS, "user is able to Delete Global RDS:"+RDSPOSTName);
			  } else
			  {
		        failedDescription("user is not able to Delete Global Outbound Connector");
		      }
			  
	    	
	    }

}
