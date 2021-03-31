package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class GlobalRDSCreationAndDelete extends BaseTest{
	
	    FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	    Properties properties = FunctionalComponents.getObjectProperties();
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
	   
	   
  @Test
  public void CreateRDSwithGetMethod()
  {	
	  RDSGetName=Ruledatasourcename+"GET"+CurrentDateandTime;
	  EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
 	  edgeservicefunctions.LoginPolicyservice_MovetoEdgeDesignerTile(PolicyServiceURL,username,password); 
	  //Rule Data source
	  functionalcomponents.ClickOperation(properties.getProperty("GlobalRDSLink"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddRDSButton"), 20);
	  functionalcomponents.ClickOperation(properties.getProperty("AddRDSButton"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("RDSNameInput"), 20);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("RDSNameInput")))
	  {
		  test.log(Status.PASS, "user is move to add the Rule data source page successfully");
	  } else
	  {
         failedDescription("user is not able to add the Rule data source");	              		 
	  }
	  test.log(Status.INFO, "Enter the Rule name and description with special characters");			
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSNameInput"),RDSGetName);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"),Ruledsdesc);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("RDSEndpointulrinput")))
	  {
		  test.log(Status.PASS, "user is able to enter the Rule name as"+":"+RDSGetName+" successfully");
	  } else
	  {
         failedDescription("user is not able to enter the Rule name and descrition in the rule datasource window");	              		 
	  }	
	  test.log(Status.INFO, "Enter the HTTP_Endpoint url and select the Request method from dropdown");
	  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSEndpointulrinput"),"https://sdsss.com:818");		
	  functionalcomponents.ClickOperation(properties.getProperty("RDSRequestMethoddropdown"));
	  functionalcomponents.ClickOperation(properties.getProperty("RDSGETRequestMethod"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Authentication_type_dropdown"), 20);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Authentication_type_dropdown")))
	  {
			  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as GET");
	   }
	  else
		  {
             failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as GET");	              		 
		  }
		 
	  test.log(Status.INFO, "Select the Authentication type and enter the value for update freqency");	
	  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_dropdown"));
	  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_part1")+Authenticaion_type+properties.getProperty("Authentication_type_part2"));			 			 		 
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Update_frequency"),updatefrequency);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Custom_Headers"), 20);
	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Custom_Headers")))
	  {
		  test.log(Status.PASS, "user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);
	  } else
	  {
         failedDescription("user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);	              		 
	  }
	  test.log(Status.INFO, "Enter the value for Custom Headers and Date format in the Rule datasoruce window");	
	  functionalcomponents.ClickAndSetValue(properties.getProperty("Custom_Headers"),Custom_headers);
	  functionalcomponents.ClickAndSetValue(properties.getProperty("date_format"),Date_format);
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Rue_Datasource_Create"), 20);
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
	  functionalcomponents.ClickOperation(properties.getProperty("Rue_Datasource_Create"));
	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddRDSButton"), 20);
	  if(driver.findElement(By.xpath(properties.getProperty("AddRDSButton"))).isDisplayed())
	  {
		  test.log(Status.PASS, "user is able to select the Respnse type as"+":"+Response_type+"and successfully saved the Rule data source as"+":"+Response_type);
	  } else
	  {
         failedDescription("user is not able to create the Rule Datasource");	              		 
	  }
	 
	}
	  
	    @Test (dependsOnMethods = {"CreateRDSwithGetMethod"})
	    public void Copy_Edit_Update_Save_DeleteGetMethodRDS() {
	    	  test.log(Status.INFO, "Copy RDS and Edit Created RDS Description field and click save button");
	    	  functionalcomponents.ClickOperation(properties.getProperty("CopyRuleDataSource"));
	    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("cancel_button"), 20);
			  if(driver.findElement(By.xpath(properties.getProperty("cancel_button"))).isDisplayed())
			  {
				  test.log(Status.PASS, "Clicked Copy RDS button and verified user is able to copay RDS");
			  } else
			  {
		          failedDescription("Clicked Copy RDS button and verified user is not able to copay RDS");
		      }
			  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
	    	  functionalcomponents.ClickOperation(properties.getProperty("EditRDSiconbutton"));
	    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("RuleDatasource_description"), 20);
	    	  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"), "Updated"); 
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
		   	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		   	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddRDSButton"), 20);
		 	  if (functionalcomponents.IsElementDisplayed(properties.getProperty("AddRDSButton")))
			  {
		 		test.log(Status.PASS, "user is able to Delete Global RDS:"+RDSGetName);
			  } else
			  {
		        failedDescription("user is not able to Delete Global Outbound Connector");
		      }
			  
	    	
	    }
	    
	    
	    @Test (dependsOnMethods = {"Copy_Edit_Update_Save_DeleteGetMethodRDS"})
	      public void CreateRDSwithPostMethod() {
		  test.log(Status.INFO, "Create RDS with post method request and Enter the name and description");
		  RDSPOSTName=Ruledatasourcename+"POST"+CurrentDateandTime;
		  functionalcomponents.ClickOperation(properties.getProperty("AddRDSButton"));		
		  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSNameInput"),RDSPOSTName);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"),"Ruledsdesc");
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("RDSNameInput"), 20);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("RDSNameInput")))
		  {
			  test.log(Status.PASS, "user is able to enter the Rule data source name as"+":"+RDSPOSTName+" successfully");
		  } else
		  {
	         failedDescription("user is not able to enter the Rule name and descrition in the rule datasource window");	              		 
		  }	
		  test.log(Status.INFO, "Enter the HTTP_Endpoint url and select the Request method from dropdown");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("RDSEndpointulrinput"),"https://sdsss.com:818");		
		  functionalcomponents.ClickOperation(properties.getProperty("RDSRequestMethoddropdown"));
		  functionalcomponents.ClickOperation(properties.getProperty("RDSPostRequestMethod"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("content_type_Header"), 20);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("content_type_Header")))
		  {				
			  test.log( Status.PASS, "user is able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as POST");
		   } 
		  else
			  {
	             failedDescription("user is not able to enter the HTTP_EndPoint url as https://sdsss.com:818"+":"+" and select the request medhtod as POST");	              		 
			  }
			  test.log(Status.INFO, "Enter the values for content_type header and Request body Template");
			  functionalcomponents.ClickAndSetValue(properties.getProperty("content_type_Header"),contentype_headervalue);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Request_BodyTemplate"),Request_body_template);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Authentication_type_dropdown"), 20);
			  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Authentication_type_dropdown")))
			  {
				  test.log( Status.PASS, "user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);
			  } else
			  {
	             failedDescription("user is able to enter the content type Header value as"+":"+contentype_headervalue+" and Enter the Request body Template as"+Request_body_template);	              		 
			  }  
		
		  test.log(Status.INFO, "Select the Authentication type and enter the value for update freqency");	
		  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_dropdown"));
		  functionalcomponents.ClickOperation(properties.getProperty("Authentication_type_part1")+Authenticaion_type+ properties.getProperty("Authentication_type_part2"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Update_frequency"), 20);		 			 		 
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Update_frequency"),updatefrequency);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Custom_Headers"), 20);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Custom_Headers")))
		  {
			  test.log(Status.PASS, "user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);
		  } else
		  {
	         failedDescription("user is able to select the Authentication type as"+":"+Authenticaion_type+":"+"and entered the update frequency as"+":"+updatefrequency);	              		 
		  }
		  test.log(Status.INFO, "Enter the value for Custom Headers and Date format in the Rule datasoruce window");	
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Custom_Headers"),Custom_headers);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("date_format"),Date_format);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Rue_Datasource_Create"), 20);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("Rue_Datasource_Create")))
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
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Rue_Datasource_Create"), 20);
		  functionalcomponents.ClickOperation(properties.getProperty("Rue_Datasource_Create"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddRDSButton"), 20);
		  if (functionalcomponents.IsElementDisplayed(properties.getProperty("AddRDSButton")))
		  {
			  test.log(Status.PASS, "user is able to select the Respnse type as"+":"+Response_type+"and successfully saved the Rule data source as"+":"+Response_type);
		  }
		  else
		  {
	         failedDescription("user is not able to create the Rule Datasource");	              		 
		  }
		
	}

	    @Test (dependsOnMethods = {"CreateRDSwithPostMethod"})
	    public void Edit_Update_Save_DeletePostMethodRDS()
	    {
	    	  test.log(Status.INFO, "Edit Created RDS Description field and click save button");
	    	  functionalcomponents.ClickOperation(properties.getProperty("EditRDSiconbutton"));
	    	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("RuleDatasource_description"), 20);
	    	  functionalcomponents.ClickAndSetValue(properties.getProperty("RuleDatasource_description"), "Updated"); 	
			  functionalcomponents.ClickOperation(properties.getProperty("savebutton"));
			  functionalcomponents.WaitTillTime(7000);
			  String RDSupdatedname=driver.findElement(By.xpath("//span[text()='"+RDSPOSTName+"']")).getText();
			  if(RDSupdatedname.equalsIgnoreCase(RDSPOSTName))
			  {
				  test.log(Status.PASS, "user is able to Update the Global RDS name as:"+RDSPOSTName);		  }
			  else
			  {
	              failedDescription("user is not able to Update the Global RDS ");
	          }	
			  test.log(Status.INFO, "Select Created RDS and click delete button");
			  functionalcomponents.ClickOperation(properties.getProperty("DeleteRuleDataSource"));
		   	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		   	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddRDSButton"), 20);
		 	 if (functionalcomponents.IsElementDisplayed(properties.getProperty("AddRDSButton")))
			  {
		 		test.log(Status.PASS, "user is able to Delete Global RDS:"+RDSPOSTName);
			  } else
			  {
		        failedDescription("user is not able to Delete Global Outbound Connector");
		      }
			  
	    	
	    }

}
