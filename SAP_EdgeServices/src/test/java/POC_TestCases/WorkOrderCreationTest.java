package POC_TestCases;

import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import UtilityComponent.FunctionalComponents;


public class WorkOrderCreationTest extends BaseTest{
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
	Properties properties = functionalcomponents.getObjectProperties();
	//input data from sheet
	 String username = functionalcomponents.getdatafromsheet("EdgeServices", "TC01_WorkOrderCreation_Flow", "username");
	 String password = functionalcomponents.getdatafromsheet("EdgeServices", "TC01_WorkOrderCreation_Flow", "password");
	 String Description=functionalcomponents.getdatafromsheet("EdgeServices", "TC01_WorkOrderCreation_Flow", "Description");
	 String MaintanceActivityType=functionalcomponents.getdatafromsheet("EdgeServices", "TC01_WorkOrderCreation_Flow", "MaintanceActivityType");
	 String EquipmentNumber=functionalcomponents.getdatafromsheet("EdgeServices", "TC01_WorkOrderCreation_Flow", "EquipmentNumber");
	 String WorkCenter=functionalcomponents.getdatafromsheet("EdgeServices", "TC01_WorkOrderCreation_Flow", "WorkCenter");
	 String BEFURL = functionalcomponents.getdatafromsheet("EdgeServices", "TC01_WorkOrderCreation_Flow", "EdgeURL");
	 String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime();
	
	@Test
	public void TC01_WorkOrderCreation_Flow() {
		
		 //Prerequisite-BEF Application working & user has Persistence DB Access
		 test.log(Status.INFO, "Open  BEF URL in Chrome browser");
		 driver.get(BEFURL);
		 functionalcomponents.WaitTillTime(3000);
		 if(driver.findElement(By.xpath(properties.getProperty("BEF_username"))).isDisplayed())
		 {	
			test.log(Status.PASS, "URL" +" "+properties.getProperty("BEF_URL")+" "+" is loaded in Chrome browser and Login page is displaying");
		 }
		 else 
		 {
			failedDescription("URL" +" "+properties.getProperty("BEF_URL")+" "+" is not loaded in Chrome browser");
		 }
		 test.log(Status.INFO, "Enter username, Password & Login BEF service & Navigate to the RESTful UI");
		 functionalcomponents.ClickAndSetValue(properties.getProperty("BEF_username"), username);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickAndSetValue(properties.getProperty("BEF_Password"), password);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("BEF_Login_btn"));
		 functionalcomponents.WaitTillTime(3000);
		 String pagetitle=driver.getTitle();
		 functionalcomponents.WaitTillTime(2000);
		 if(pagetitle.equalsIgnoreCase("Home"))
		 {	
			 test.log(Status.PASS, "User is able to Enter username, Password & Login BEF service and Tiles for various PM/MM/IM functionality is displayed with page title as"+":"+pagetitle);
		 }
		 else 
		 {
			failedDescription("User is able to Enter username, Password & Login BEF service and Tiles for various PM/MM/IM functionality is not displayed with page title as"+":"+pagetitle);
		 }
		 Description=Description+CurrentDateandTime;
		 test.log(Status.INFO, "Click on Create Work Order & Enter Work order Description as well as select MaintenanceActivityType");
		 functionalcomponents.JScriptExecutorClick(properties.getProperty("CreateWorkorders_Tile"));
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Workorder_Description"), 30);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Workorder_Description"), Description);
		 functionalcomponents.WaitTillTime(1000);
		 functionalcomponents.ClickOperation(properties.getProperty("MaintenanceActivity_TypeDropdown"));
		 functionalcomponents.WaitTillTime(4000);
		 functionalcomponents.ClickOperation(properties.getProperty("SelectMaintanceActivity_Part1")+MaintanceActivityType+properties.getProperty("SelectMaintanceActivity_Part2"));
		 functionalcomponents.WaitTillTime(2000);
		 
		 if(driver.findElement(By.xpath(properties.getProperty("EquipmentListDropdown"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "Clicked on Create Work Order, Work order details page is displaying & Entered Work order Description :"+Description+" as well as selected MaintenanceActivityType as:"+MaintanceActivityType);
		 }
		 else 
		 {
			failedDescription("Clicked on Create Work Order, Work order details page is not displaying");
		 }
		 test.log(Status.INFO, "Select Equipment Number and Work center from web Table List");
		 functionalcomponents.ClickOperation(properties.getProperty("EquipmentListDropdown"));
		 functionalcomponents.WaitTillTime(5000);
		// functionalcomponents.ClearAndSetValue(properties.getProperty("Filterinput_Equipmentnumber"), EquipmentNumber);
		// functionalcomponents.WaitTillTime(2000);
		// functionalcomponents.ClickOperation(properties.getProperty("Go_Button"));
		// functionalcomponents.WaitTillTime(6000);
		// functionalcomponents.ClickOperation(properties.getProperty("Select_EquipmentNumberPart1")+EquipmentNumber+properties.getProperty("Select_EquipmentNumberPart2"));
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickOperation(properties.getProperty("MainWorkcenterListDropdown"));
		 functionalcomponents.WaitTillTime(6000);
		 functionalcomponents.ClearAndSetValue(properties.getProperty("Filterinput_workcenter"), WorkCenter);
		 functionalcomponents.WaitTillTime(2000);
		 functionalcomponents.ClickOperation(properties.getProperty("Go_Button"));
		 functionalcomponents.WaitTillTime(6000);
		 functionalcomponents.ClickOperation(properties.getProperty("Select_WorkCenterPart1")+WorkCenter+properties.getProperty("Select_WorkCenterPart2"));
		 functionalcomponents.waittillElementReadytoclickable(properties.getProperty("WorkOrderSave_Btn"), 50);
		 if(driver.findElement(By.xpath(properties.getProperty("WorkOrderSave_Btn"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "user is able to Select Equipment Number as:"+EquipmentNumber+" and Work center as: "+WorkCenter+" from web Table List");
		 }
		 else 
		 {
			failedDescription("user is not able to Select Equipment Number and Work center from web Table List");
		 }
		 test.log(Status.INFO, "Click Save button and verify workorder is created successfully");
		 functionalcomponents.WaitTillTime(3000);
		 functionalcomponents.ClickOperation(properties.getProperty("WorkOrderSave_Btn"));
		 functionalcomponents.WaitTillTime(7000);
		 if(functionalcomponents.IsElementPresent(properties.getProperty("Duplicateworkorder_Dialog"))) {
			 failedDescription("Duplicate Work Order is Exist with this description & Equipment number");

		 }
		 functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("Saved_WorkOrderNumber"), 20);
		 String Workordertext=driver.findElement(By.xpath(properties.getProperty("Saved_WorkOrderNumber"))).getText();
		 String[] splitvalues=Workordertext.split("\\s+");
		 String WorkorderNumber =splitvalues[2].toString();
		 if(driver.findElement(By.xpath(properties.getProperty("User_Status"))).isDisplayed())
		 {	
			 test.log(Status.PASS, "Clicked Save button and workorder order created succeffully with work order Number as:"+WorkorderNumber);
		 }
		 else 
		 {
			failedDescription("clicked Save button and workorder order is not created succeffully");
		 }
		 
		 test.log(Status.INFO, "Access to DB and Verify work order is present with transaction ID in T_WORKORD Table");
		 functionalcomponents.WaitTillTime(1000);
		 String T_WORKORD_query = "SELECT TRANSID from T_WORKORD where AUFNR = '"+WorkorderNumber+"' ";
		 String T_WORKORD_Result=functionalcomponents.GetDatafromPersistenceDataBasefromothersystem(T_WORKORD_query);
		 System.out.println(T_WORKORD_Result);
		 if(T_WORKORD_Result !=null) {
			 test.log(Status.PASS, "TransactionID are "+T_WORKORD_Result+"available for workorder :"+WorkorderNumber);
		 }
		 else 
		 {
			failedDescription("TransactionID is"+T_WORKORD_Result+"available for workorder :"+WorkorderNumber);
		 }
		 
		 
		 test.log(Status.INFO, "Access to DB and Verify work order is present with transaction ID in T_TRN Table");
		 functionalcomponents.WaitTillTime(100000);
		 String T_TRN_query = "SELECT TRANSID from T_TRN where OBJID = '"+WorkorderNumber+"' ";
		 String T_TRN_Result=functionalcomponents.GetDatafromPersistenceDataBasefromothersystem(T_TRN_query);
		 System.out.println(T_TRN_Result);
		 if(T_TRN_Result !=null) {
			 test.log(Status.PASS, "TransactionID are "+T_TRN_Result+"available for workorder :"+WorkorderNumber);
		 }
		 else 
		 {
			failedDescription("TransactionID is"+T_TRN_Result+"available for workorder :"+WorkorderNumber);
		 }
		 
		 /*
		 test.log(Status.INFO, "Access to DB and Verify work order is inProcess with transaction ID in T_TRNSTAT Table");
		 functionalcomponents.WaitTillTime(100000);
		 String T_TRNSTAT_query = "SELECT TRANSID from T_TRNSTAT where OBJID ='"+WorkorderNumber+"'";
		 String T_TRNSTAT_Result=functionalcomponents.GetDatafromPersistenceDataBasefromothersystem(T_TRNSTAT_query);
		 System.out.println(T_TRNSTAT_Result);
		 if(T_TRNSTAT_Result !=null && !T_TRNSTAT_Result.isEmpty()) {
			 test.log(Status.PASS, "TransactionID are "+T_TRNSTAT_Result+"available for workorder :"+WorkorderNumber);
		 }
		 else 
		 {
			failedDescription("TransactionID is"+T_TRNSTAT_Result+"available for workorder :"+WorkorderNumber);
		 }
		 
		 test.log(Status.INFO, "Access to DB and Verify work order is moved to O_WORKORD table from T_WORKORD Table after process completing");
		 functionalcomponents.WaitTillTime(2000);
		 String O_WORKORD_query = "SELECT AUFNR from O_WORKORD where AUFNR = '"+WorkorderNumber+"' ";
		 String O_WORKORD_Result=functionalcomponents.GetDatafromPersistenceDataBasefromothersystem(O_WORKORD_query);
		 System.out.println(O_WORKORD_Result);
		 if(O_WORKORD_Result !=null && !O_WORKORD_Result.isEmpty() ) {
			 
			 test.log(Status.PASS, "Work Order :"+O_WORKORD_Result+"is moved to O_WORKORD table from T_WORKORD Table after process completing");
		 }
		 else 
		 {
			failedDescription("Work Order :"+O_WORKORD_Result+"is not moved to O_WORKORD table from T_WORKORD Table after process completing");
		 }
	   */
		
	}
	
	

}
