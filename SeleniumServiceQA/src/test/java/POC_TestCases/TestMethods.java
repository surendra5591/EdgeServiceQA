package POC_TestCases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import EdgeServiceComponents.EdgeServiceFunctions;
import UtilityComponent.FunctionalComponents;
import net.lingala.zip4j.exception.ZipException;

public class TestMethods extends BaseTest {
	
	//Prerequisite:- Gateway should be up and online status
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	 EdgeServiceFunctions edgeservicefunction = new EdgeServiceFunctions();
	 
	Properties properties = FunctionalComponents.getObjectProperties();
	String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	String URL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");
	String username = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "username");
	String password = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "password");
	String projectdesc=functionalcomponents.getdatafromsheet("EdgeServices", "RestrictPassword_UIMaskingwithAllOutboundconnectortypes", "Description");

	 static  String ProjectName="";
	@Test
	 public void Testcase() throws InterruptedException, ZipException  {			 
		   test.log(Status.INFO, "Open URL: "+URL+" Login into the Policy service with the valid credentilas ");
		   driver.get(URL);
		    functionalcomponents.WaitTillTime(2000);
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
		 //Click on the Edgedesigner tile
		 test.log(Status.INFO, "Click on Edge designer tile of the Home Page and capture the version of the Edge Designer");
		 //functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickOperation(properties.getProperty("Edgedesigner_tile"));
		 functionalcomponents.WaitTillTime(20000);	
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Project_Addbutton"), 90); 
		 functionalcomponents.WaitTillTime(5000);		 
		 if(driver.findElement(By.xpath(properties.getProperty("Project_Addbutton"))).isDisplayed())
		 {	
			test.log(Status.PASS, "Edge desinger tile window opens successfully");
		 }
		 else 
		 {
			failedDescription("Edge designer tile is not opened successfully");
		 }
		 //Project creation
		 test.log(Status.INFO, "Click on the + Symbol in the bottom of the work center to add the project");
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Project_Addbutton"));
		 functionalcomponents.WaitTillTime(2000);
		 if (driver.findElement(By.xpath(properties.getProperty("Create_project"))).isDisplayed())
		  {
             test.log(Status.PASS, "user is able to see Add Prject window successfully");
		  } else
		  {
             failedDescription("user is not able to see the Add Project window ");
         } 
		 			 
		  test.log(Status.INFO, "Enter the name of the project with special characters");
		  ProjectName="PasswordProject"+CurrentDateandTime;
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_name"),ProjectName);	  
		  functionalcomponents.WaitTillTime(5000);
		  if(driver.findElement(By.xpath(properties.getProperty("Project_name"))).isDisplayed())
		  {	
				test.log(Status.PASS, "project name as"+":"+ProjectName+" "+" is saved successfully with special characters");
		  }
		  else 
		  {
				failedDescription(" project name is not saved successfully with special characters");
		  }
		  test.log(Status.INFO, "Enter description of the project and click on the create button");
		  functionalcomponents.ClickAndSetValue(properties.getProperty("Project_description"),projectdesc);
		  functionalcomponents.WaitTillTime(1000);
		  functionalcomponents.ClickOperation(properties.getProperty("Create_project"));
		  functionalcomponents.WaitTillTime(15000);
		  functionalcomponents.ClickOperation(properties.getProperty("Refresh_button"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClearAndSetValue(properties.getProperty("ProjectSearchinput"),ProjectName);
		  functionalcomponents.WaitTillTime(3000);
		  functionalcomponents.ClickOperation(properties.getProperty("Project_search_button"));
		  functionalcomponents.WaitTillTime(5000);
		  functionalcomponents.ClickOperation((properties.getProperty("Project_title_part1")+ProjectName+properties.getProperty("Project_title_part2")));
		  functionalcomponents.WaitTillTime(10000);	
		  if (driver.findElement(By.xpath(properties.getProperty("Project_Addbutton"))).isDisplayed())
		  {
             test.log(Status.PASS, "user is able to create Project with name:"+""+ProjectName+""+"and Group Description:"+""+projectdesc+""+"successfully");
		  } else
		  {
             failedDescription("user is not able to enter the  Project name and description in the window");
          } 
		  edgeservicefunction.DeleteProject(ProjectName);
		  edgeservicefunction.MovetoServicepage();
		  System.out.println("methods validation done");

   }
	
}
