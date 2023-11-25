package EdgeServices;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;

public class GLobalActionCreationandDelete extends BaseTest{
	    FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	    Properties properties = FunctionalComponents.getObjectProperties();
	    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();	
	    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	    String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	    String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	    String GlobalActionName=functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Actionname");
	    String Action_desc  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "ActionDescription");
	    String Action_type  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Action_type");
	    String Actionmsg=  functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Action_Message");
	    String Receipient_param= functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Receipient_parameters");
	    String Scope_level  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Scope_level");
	    String Edge_Fedilityfreq  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "New_edgefedility_freq");
	    String Edge_fedility_rollback = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "edge_fedility_rollback");
	    String enterprise_fedility = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Enterprise_fedility");
	    String enterprise_rollback  = functionalcomponents.getdatafromsheet("EdgeDesigner", "E2E_Edge_TestCases", "Enterprise_rollback");
	 
	    
	 @Test 
	public void CreateGlobalActionupdateDelete()
	{
		  EdgeServiceFunctions edgeservicefunctions = new  EdgeServiceFunctions();
		  edgeservicefunctions.LoginPolicyservice_MovetoEdgeDesignerTile(PolicyServiceURL,username,password);
		  GlobalActionName=GlobalActionName+CurrentDateandTime;
	      test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the Global Action");
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("GlobalActionslink"), 90);
	      functionalcomponents.ClickOperation(properties.getProperty("GlobalActionslink"));
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_Add"), 90);
	      functionalcomponents.ClickOperation(properties.getProperty("Action_Add"));
	      functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_name"), 90); 
	      if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_name")))
		  {
			  test.log(Status.PASS, "user is able to see the Add Action window successfully");
		  } else
		  {
	          failedDescription("user is not able to see the Add Action window");	              		 
		  }				  
		  test.log(Status.INFO, "Enter the Action name and description with special characters");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_name"),GlobalActionName);
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Action_description"),Action_desc);
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_Type_Dropdown"), 50);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_Type_Dropdown")))
		  {
			  test.log(Status.PASS, "user is able to add the Global Action name"+":"+GlobalActionName+" successfully");
		  } else
		  {
	          failedDescription("user is not able to add the Action name and Action Description");	              		 
		  }		
		  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_Dropdown"));
		  functionalcomponents.WaitTillTime(3000);
		  if(Action_type.equalsIgnoreCase("Field Message"))
		  {
			 
			  test.log(Status.INFO, "Select Actiontype as Field Message & ActionPlugin as httpprotocol plugin from dropdown button");
			  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1")+Action_type+properties.getProperty("Action_Type_part2"));
			  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Message")))
			  {
				  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_type);
			  } else
			  {
	              failedDescription("user is not able to select the Action type as"+":"+Action_type);	              		 
			  }	
			  test.log(Status.INFO,"Enter the message and Recipient parameters of the Action");			  
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Message"),Actionmsg);
			  functionalcomponents.ClickAndSetValue(properties.getProperty("Recipient_Parameters"),Receipient_param);	
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_create"), 50);
			  if(driver.findElement(By.xpath(properties.getProperty("Action_create"))).isDisplayed())
			  {
				  test.log(Status.PASS, "user is able to Enter the Message as"+":"+Actionmsg+"and Recipient parameters as"+":"+Receipient_param);
			  } else
			  {
	              failedDescription("user is not able to Enter the Message as"+":"+Actionmsg+"and Recipient parameters as"+":"+Receipient_param);	              		 
			  }	
			 
	      }
		  else if(Action_type.equalsIgnoreCase("Sensor Fidelity Change"))
		  {
			  test.log(Status.INFO, "Select Actiontype as Sensor fedility Change,sensor model name as MuthuStyp_CAT987_Cap_Battery and Scope_value as Device");
			  functionalcomponents.ClickOperation(properties.getProperty("Action_Type_part1")+Action_type+properties.getProperty("Action_Type_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("scope_leve_dropdown"), 50);
			  functionalcomponents.ClickOperation(properties.getProperty("scope_leve_dropdown"));
			  functionalcomponents.ClickOperation(properties.getProperty("scope_level_part1")+Scope_level+properties.getProperty("scope_level_part2"));
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("fedility_freqency"), 50);
			  if(functionalcomponents.IsElementDisplayed(properties.getProperty("fedility_freqency")))
			  {
				  test.log(Status.PASS, "user is able to select the Action type as"+":"+Action_type+"sensor model name and scope_value as"+":"+Scope_level);
			  } else
			  {
	              failedDescription("user is able to select the Action type as"+":"+Action_type+"sensor model name and scope_value as"+":"+Scope_level);	              		 
			  }
			  test.log(Status.INFO, "Enter the fedility frequency,Fedility Rollback,Enterprise_Fedility and Enterprise_fedility_rollback");
			  functionalcomponents.ClearAndSetValue(properties.getProperty("fedility_freqency"),Edge_Fedilityfreq);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("fedility_Rollback"),Edge_fedility_rollback);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprise_fedility"),enterprise_fedility);
			  functionalcomponents.ClearAndSetValue(properties.getProperty("Enterprisefedility_rollback"),enterprise_rollback);
			  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_create"), 50);
			  if(functionalcomponents.IsElementDisplayed(properties.getProperty("Action_create")))
			  {
				  test.log(Status.PASS, "user is able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);
			  } else
			  {
	              failedDescription("user is not able to Enter the fedility frequency as"+Edge_Fedilityfreq+"Fedility Rollback as"+Edge_fedility_rollback+"Enterprise fedility as"+enterprise_fedility+"Enterprise fedility rollback as"+enterprise_rollback);             		 
			  }	
			  
		  }
		  test.log(Status.INFO, "Click Create Action button and verify Action is created successfully with Action Name");
		  functionalcomponents.ClickOperation(properties.getProperty("Action_create"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_Add"), 50);
		  if(driver.findElement(By.xpath(properties.getProperty("Action_Add"))).isDisplayed())
		  {
			  test.log(Status.PASS, "Clicked Save Action button and verified Action is created successfully with Action Name as"+":"+GlobalActionName);
		  } else
		  {
	          failedDescription("Clicked Save Action button but Action is not created successfully with Action Name as"+":"+GlobalActionName);
	      }
		  test.log(Status.INFO, "Click Copy Action button and verify user is able to copay action");
		  functionalcomponents.ClickOperation(properties.getProperty("ActionCopyButton"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("cancel_button"), 50);
		  if(functionalcomponents.IsElementDisplayed(properties.getProperty("cancel_button")))
		  {
			  test.log(Status.PASS, "Clicked Copy Action button and verified user is able to copay action");
		  } else
		  {
	          failedDescription("Clicked Copy Action button and verified user is able to copay action");
	      }
		  test.log(Status.INFO, "Click on Delete Action button and verify user is not able to Delete Global action");
		  functionalcomponents.ClickOperation(properties.getProperty("cancel_button"));
		  functionalcomponents.ClickOperation(properties.getProperty("DeleteActionButton"));
		  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
		  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Action_Add"), 50);
		  if(driver.findElement(By.xpath(properties.getProperty("Action_Add"))).isDisplayed())
		  {
			  test.log(Status.PASS, "Clicked on Delete Action button and verified user is able to Delete Global action");
		  } else
		  {
	          failedDescription("Clicked on Delete Action button and verified user is not able to Delete Global action");
	      }
	}

}
