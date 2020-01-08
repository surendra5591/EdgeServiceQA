package functionalComponent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


/**
 * Functional Components class
 * @author SAP Labs
 */

public class FunctionalComponents
{

           WebDriver driver;
	static boolean elementPresent;
	static Alert alert;
	static WebDriverWait wait;
	static Properties properties;
	
public FunctionalComponents(WebDriver driver)
{
	this.driver=driver;
}
	
	
	
	
public Properties getObjectProperties()
{
	File file = new File("EdgeProperties//Connfiguration.properties");
	FileInputStream fileInput = null;
	try {
		     fileInput = new FileInputStream(file);
		     } catch (FileNotFoundException e) {
		     e.printStackTrace();
	 }
	 properties = new Properties(); 
	 try {
		     properties.load(fileInput);
	 	     } catch (IOException e) {
		     e.printStackTrace();
	 } 
	 return properties;   
}

	
	public String getScreenshot(WebDriver driver)
	{
		TakesScreenshot ts=(TakesScreenshot) driver;		
		File src=ts.getScreenshotAs(OutputType.FILE);		
		String path=System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";		
		File destination=new File(path);		
		try 
		{
			FileUtils.copyFile(src, destination);
		} catch (IOException e) 
		{
			System.out.println("Capture Failed "+e.getMessage());
		}		
		return path;
	} 



public String getdatafromsheet(String sheetName,String rowvalue,String colnumvalue){
		File file =new File(System.getProperty("user.dir")+properties.getProperty("testdatafile"));
		String ReturnCellvalue = "";
	    try {
	    	
			FileInputStream inputStream = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = workbook.getSheet(sheetName);
			HSSFFormulaEvaluator objFormulaEvaluator = new HSSFFormulaEvaluator((HSSFWorkbook) workbook);
			DataFormatter objDefaultFormat = new DataFormatter();
			for(int i=0; i<=sheet.getLastRowNum(); i++)
			{
				//System.out.println("Rowvalue---"+sheet.getRow(i).getCell(0).getStringCellValue());
				if (rowvalue.equals(sheet.getRow(i).getCell(0).getStringCellValue()))
				{
					for(int j=0; j<sheet.getRow(i).getLastCellNum(); j++)
					{
						//System.out.println("colomnvalue---"+sheet.getRow(0).getCell(j).getStringCellValue());
						if (colnumvalue.equals(sheet.getRow(0).getCell(j).getStringCellValue()))
						{
							Cell cellvalue=sheet.getRow(i).getCell(j);
							objFormulaEvaluator.evaluate(cellvalue); // This will evaluate the cell, And any type of cell will return string value
						    ReturnCellvalue = objDefaultFormat.formatCellValue(cellvalue,objFormulaEvaluator);
						    //System.out.println("datavalue----"+ReturnCellvalue);
						 break;
						}
						
					}
					break;
				}
				
			}
			//System.out.println("datavalue----"+ReturnCellvalue);
		} 
	    catch (Exception e) {
			
			e.printStackTrace();
		}
	    return ReturnCellvalue;
	}
	
	
	
	// Selenium required methods
	
	public void PerformRightClick(WebElement ElementXpath)
    {
        Actions action = new Actions(driver);
        action.contextClick(ElementXpath).build().perform();
        WaitTillTime(3000);
    }
	
	
	
	public String GetValueFromDropDown(String Xpath_WebList)
	{
		WebElement Dropdown;
		//properties = factory.getObjectProperties();
		
		Dropdown = driver.findElement(By.xpath(Xpath_WebList));
		
		Select selectList = new Select(Dropdown);
		
		return 	selectList.getFirstSelectedOption().getText();
		
	}
	
	
	public void Stale_element_handler(WebElement element) throws Exception {
		properties = getObjectProperties();

		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				// write your code here
				element.click();
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}

	}
	
	
	public void Select_DropdownbyName(String Select_value, String Xpath) throws Exception {
		WebElement mySelectElement = driver.findElement(By.xpath(Xpath));
		Thread.sleep(2000);
		Select dropdown = new Select(mySelectElement);
		dropdown.selectByValue(Select_value);
	}
	
      public String getTextfromfield(String Xpath_WebList)
		{
			WebElement textfield;

			textfield = driver.findElement(By.xpath(Xpath_WebList));
			
			WaitTillTime(3000);
			
			return textfield.getText().toString();

		}
      
      public String Getvaluefromfield(String Xpath_WebList)
		{
			WebElement textfield;

			textfield = driver.findElement(By.xpath(Xpath_WebList));
			
			WaitTillTime(3000);
			
			return textfield.getAttribute("value").toString();

		}
		 
     public void PageScrollDown()
	{
		Robot robot = null;
		try {
				robot = new Robot();
				} catch (AWTException e) {
				e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
		WaitTillTime(2000);
	}
public void HandleRunTimeExceptions(String ElementXpath)
    {
                new WebDriverWait(driver,60).ignoring(StaleElementReferenceException.class).
                                                                                                                                                                                                                                                                            until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementXpath)));
                new WebDriverWait(driver,60).ignoring(ElementNotVisibleException.class).
                                                                                                                                                                                                                                                                            until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementXpath)));
                new WebDriverWait(driver,60).ignoring(NoSuchElementException.class).
                                                                                                                                                                                                                                                                            until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ElementXpath)));
    }

public void PageScrollEnd()
	{
		Robot robot = null;
		try {
				robot = new Robot();
				} catch (AWTException e) {
				e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_END);
		robot.keyRelease(KeyEvent.VK_END);
		WaitTillTime(2000);
	}
	
public void mouseHover(WebElement element){
	
	Actions action = new Actions(driver);
    action.moveToElement(element).build().perform();
}


public void moveToElement(String xpath) throws InterruptedException {
WebElement element=driver.findElement(By.xpath(xpath));
Actions actions = new Actions(driver);
actions.moveToElement(element);
Thread.sleep(2000);
actions.perform();

}

            
public void JScriptExecutorClick(String ElementToClick)
{
       WebElement element=driver.findElement(By.xpath(ElementToClick));
       JavascriptExecutor js = (JavascriptExecutor)driver;
       js.executeScript("arguments[0].click();", element);
}
	
//Explicitly wait for element visibility & Element is click able

	public WebElement  waittill_WebElement_getVisible(String element_xpath, int timeout) {
	    WebElement element = null;
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element_xpath)));
	    return element;   
	}
	
	public void waittillElementReadytoclickable(String ele_xpath, int timeout) {
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(ele_xpath)));
	    //element.click();
	}	
	
	
	
	public void PageScrollUp()
	{
		Robot robot = null;
		try {
				robot = new Robot();
				} catch (AWTException e) {
				e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_PAGE_UP);
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
		WaitTillTime(2000);
	}
	
	public void scrollToExact(String Element) {
		
		 WebElement element=driver.findElement(By.xpath(Element));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);", element);

	}
	
	public boolean IsElementPresent(String Xpath) {
		if (driver.findElements(By.xpath(Xpath)).size() == 1) {
			elementPresent = true;
		} else {
			elementPresent = false;
		}
		return elementPresent;
	}
	
	public void Drag_Drop(WebElement Source, WebElement Destination)throws Exception {

		Actions act = new Actions(driver);
		act.dragAndDrop(Source, Destination).build().perform();

	}

	public boolean verifyElementAbsent(String locator) throws Exception {

		boolean visible = driver.findElement(By.xpath(locator)).isDisplayed();
		boolean result = !visible;
		System.out.println(result);
		return result;
	}
	
	public void PageScrollHome()
	{
		Robot robot = null;
		try {
				robot = new Robot();
				} catch (AWTException e) {
				e.printStackTrace();
		}
		robot.keyPress(KeyEvent.VK_HOME);
		robot.keyRelease(KeyEvent.VK_HOME);
		WaitTillTime(2000);
	}
	
	
	public void Switchtab(int i)  
	{
		ArrayList<String> SwitchTo = new ArrayList<String> (driver.getWindowHandles());	
		driver.switchTo().window(SwitchTo.get(i)); 
		try {
				Thread.sleep(2000);
			    } catch (InterruptedException e) {  
				e.printStackTrace(); 
		}
	}
	
	
	public void WaitTillTime(int time)
	{
		try {
			Thread.sleep(time);
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
	public boolean IsElementPresent(WebDriver driver ,String Xpath)
	{
			if(driver.findElements(By.xpath(Xpath)).size()!=0) 
            {
            	elementPresent=true; 
            }
			else 
			{
                elementPresent=false;
            }
            return elementPresent;
	}
	
	public void PerformRightClick(String ElementXpath)
    {
        WebElement Element = driver.findElement(By.xpath(ElementXpath));
        Actions action = new Actions(driver);
        action.contextClick(Element).build().perform();
        WaitTillTime(500);
    }
    
    public void PerformDoubleClick(String ElementXpath)
    {
        WebElement Element = driver.findElement(By.xpath(ElementXpath));
        Actions action = new Actions(driver);
        action.doubleClick(Element).build().perform();
        WaitTillTime(500);
    }
    
    public void ClearAndSetValue(String ElementXpath,String value)
    {
        WebElement Element = driver.findElement(By.xpath(ElementXpath));
        Element.click();
        Element.clear();
        Element.sendKeys(value);
        //Element.click();
    }	
    
    public void ClickAndSetValue(String ElementXpath,String Value)
    {
    	if (IsElementPresent(driver, ElementXpath)) {
        WebElement Element = driver.findElement(By.xpath(ElementXpath));
        Element.sendKeys(Value);
    	}
    }
    
    public static boolean isSorted(ArrayList<Double> list) {
		boolean sorted = true;
		for (int i = 1; i < list.size(); i++) {
			System.out.println(list.get(i));
			if (list.get(i - 1).compareTo(list.get(i)) > 0)
				sorted = false;
		}
		return sorted;
	}

	/**_________________________________________________________________________________________________________________________*/
	public void SwitchToFrame(String Xpath)
	{
	//	properties = factory.getObjectProperties();
		List<WebElement> ifr = driver.findElements(By.xpath("//iframe"));
		for(WebElement ifram:ifr) 
		{
			driver.switchTo().frame(ifram);
			WaitTillTime(1000);
			if (IsElementPresent(driver, Xpath))
			{
				return;
			}
		}
	}
	
	/**_________________________________________________________________________________________________________________________*/
	
	public void SelectDropDownValue(String Xpath,String Value)
	{
		//properties= factory.getObjectProperties();
		WebElement RequestDropDown = driver.findElement(By.xpath(Xpath));
		Select select = new Select(RequestDropDown);
		select.selectByValue(Value);
	}
	
	
	public void ClickOperation(String Xpath)
	{
		//properties= factory.getObjectProperties();
		if (IsElementPresent(driver, Xpath)) 
		{
			driver.findElement(By.xpath(Xpath)).click();
			return;
			} else {
		}
	}
	
	
	public void setAttributeValue(WebElement elem, String attribute, String value){
		JavascriptExecutor jse = (JavascriptExecutor)driver; 

	    String scriptSetAttrValue = "arguments[0].setAttribute(arguments[1],arguments[2])";

	    jse.executeScript(scriptSetAttrValue, elem, attribute, value);

	}	
	
	public String getTextFromDropDownVal( String Xpath_WebList)
	{
        WebElement Dropdown;
       // properties = factory.getObjectProperties();
        Dropdown = driver.findElement(By.xpath(Xpath_WebList));
        Select selectList = new Select(Dropdown);
        return selectList.getFirstSelectedOption().getText().toString();
	}
	
	
	/**_________________________________________________________________________________________________________________________*/
	
	public void SwitchToWindow(String Xpath)
	{
		  //  properties = getObjectProperties();
			Set<String> windows = driver.getWindowHandles();
			WaitTillTime(2000);
			Iterator<String> itr = windows.iterator();
			//String patName = itr.next();
			String chldName = itr.next();
			driver.switchTo().window(chldName);
			driver.manage().window().maximize();
			if (IsElementPresent(driver,Xpath))
			{
				return;
			}
	
	}
	
	
	
	public String GetDatafromStreamingDataBase(String DB_USER, String DB_PASSWORD,String query) {
		
		
		// Connection object
		
				Connection conn = null;
				
				// Statement object
				
				Statement stmt=null;
				     
			   // Constant for Database URL
				
				String DB_URL = "jdbc:sqlanywhere:";   
				
				StringBuilder sb = new StringBuilder();
				
				// sql anywhere data base connection
						
				try{
			   // Make the database connection
			   // String dbClass = "sap.jdbc4.sqlanywhere.IDriver";
			   // Class.forName(dbClass).newInstance();
			  // Get connection to DB
			     conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			     //  System.out.println("DB Connected");
			   // Statement object to send the SQL statement to the Database
			       stmt = conn.createStatement();
							
			// String query = "SELECT ACTION_ID,ACTION_NAME,DESCRIPTION,ACTION_TYPE_ID from ACTION"+" WHERE ACTION_NAME = '303'; ";
							
			  // Get the contents of action table from DB
							
				   ResultSet res = stmt.executeQuery(query);
				   
				   
				   ResultSetMetaData rsmd = res.getMetaData();

				   int columnsNumber = rsmd.getColumnCount();
				  // System.out.println(res.toString());
					     
			  // Print the result until all the records are printed
			  // res.next() returns true if there is any next record else returns false
while(res.next())	
{	
 for(int i = 1; i <= columnsNumber; i++)
{
				       				       
 sb.append(rsmd.getColumnName(i)+":"+res.getString(i)+", ");
				       
 }
  }
					 
// DB Connection close			
res.close();
stmt.close();
conn.close();
 } 
catch (SQLException se) {
	se.printStackTrace();
 }
catch (Exception e) {
	 e.printStackTrace();
 }
finally
{
 try {
 if (stmt != null)
  stmt.close();
	 }
 catch (SQLException se2) {
	 }// nothing we can do
try {
	 if (conn != null)
	  conn.close();
	} catch (SQLException se) {
	 se.printStackTrace();
	 }
}
				
				
 return sb.toString();
}
			
	public String GetDatafromPersistenceDataBasefromothersystem(String sqlquery) {
		
		// Connection object
		
		Connection conn = null;
		
		// Statement object
		
		Statement stmt=null;
		     
	   // Constant for Database URL
		String PersistanceDB_URL="jdbc:sqlanywhere:UserID=saap;Password=sql123;Host=inln34409309a.apj.global.corp.sap:5667;ServerName=DEP_QKD_INLN34409309A_1710;DatabaseName=DEP_rem_QKD_1710";
	    StringBuilder sb = new StringBuilder();

	// sql anywhere data base connection
			
	try{
	// Make the database connection
	// String dbClass = "sap.jdbc4.sqlanywhere.IDriver";
	// Class.forName(dbClass).newInstance();
	// Get connection to DB
	  conn=DriverManager.getConnection(PersistanceDB_URL);
	 //  System.out.println("DB Connected");
	// Statement object to send the SQL statement to the Database
	  // stmt = conn.createStatement();
	   stmt = conn.createStatement();
				
	// Get the contents of action table from DB
				
	   ResultSet res = stmt.executeQuery(sqlquery);
	   
	   
	   ResultSetMetaData rsmd = res.getMetaData();

	   int columnsNumber = rsmd.getColumnCount();
	  // System.out.println(res.toString());
		     
	// Print the result untill all the records are printed
	// res.next() returns true if there is any next record else returns false
		while(res.next())	{	
	   for(int i = 1; i <= columnsNumber; i++)
	   {    
	       sb.append(rsmd.getColumnName(i)+":"+res.getString(i)+", ");
	       		
	   }
		}
		 			
	//DB Connection close			
	res.close();
	stmt.close();
	conn.close();
	} 
	catch (SQLException se) {
		 se.printStackTrace();
	}
	catch (Exception e) {
	  e.printStackTrace();
	}
	finally
	{
	    try {
		 if (stmt != null)
		     stmt.close();
		     } catch (SQLException se2) {
		        }// nothing we can do
		        try {
		            if (conn != null)
		                conn.close();
		        } catch (SQLException se) {
		            se.printStackTrace();
		        }
	 }

	//System.out.println(sb.toString());
	 return sb.toString();
	}
	
public String GetDatafromPersistenceDataBase(String sqlquery, String username, String password, String Servername) {
		
		// Connection object
		
		Connection conn = null;
		
		// Statement object
		
		Statement stmt=null;
		     
	   // Constant for Database URL
		String PersistanceDB_URL="jdbc:sqlanywhere:UserID="+username+";Password="+password+";ServerName="+Servername+"";
		                        
	    StringBuilder sb = new StringBuilder();

	// sql anywhere data base connection
			
	try{
	// Make the database connection
	// String dbClass = "sap.jdbc4.sqlanywhere.IDriver";
	// Class.forName(dbClass).newInstance();
	// Get connection to DB
	  conn=DriverManager.getConnection(PersistanceDB_URL);
	 //  System.out.println("DB Connected");
	// Statement object to send the SQL statement to the Database
	  // stmt = conn.createStatement();
	   stmt = conn.createStatement();
				
	// Get the contents of action table from DB
				
	   ResultSet res = stmt.executeQuery(sqlquery);
	   
	   
	   ResultSetMetaData rsmd = res.getMetaData();

	   int columnsNumber = rsmd.getColumnCount();
	  // System.out.println(res.toString());
		     
	// Print the result untill all the records are printed
	// res.next() returns true if there is any next record else returns false
		while(res.next())	{	
	   for(int i = 1; i <= columnsNumber; i++)
	   {    
	       sb.append(rsmd.getColumnName(i)+":"+res.getString(i)+", ");
	       		
	   }
		}
		 			
	//DB Connection close			
	res.close();
	stmt.close();
	conn.close();
	} 
	catch (SQLException se) {
		 se.printStackTrace();
	}
	catch (Exception e) {
	  e.printStackTrace();
	}
	finally
	{
	    try {
		 if (stmt != null)
		     stmt.close();
		     } catch (SQLException se2) {
		        }// nothing we can do
		        try {
		            if (conn != null)
		                conn.close();
		        } catch (SQLException se) {
		            se.printStackTrace();
		        }
	 }
	//System.out.println(sb.toString());
	 return sb.toString();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public boolean isAlertPresent()
	{
	    boolean foundAlert = false;
	    WebDriverWait wait = new WebDriverWait(driver,3);
	    try {
	    	
	        wait.until(ExpectedConditions.alertIsPresent());
	        foundAlert = true;
	    	} catch (TimeoutException eTO) 
	    	{
	        foundAlert = false;
	    }
	    return foundAlert;
	}
	
	public void IsElementPresentinTable(String TD_Xpath,String RecordDetails){
        
		  WebElement Table = driver.findElement(By.xpath(TD_Xpath));
        List<WebElement> Rows = Table.findElements(By.tagName("tr"));
        int rowcount = Rows.size();
        loop:
        for (int row = 0; row < rowcount; row++) 
        {
               List<WebElement> Columns_row = Rows.get(row).findElements(By.tagName("td"));
              // int colcount = Columns_row.size();
               for (WebElement webElement : Columns_row)
               {
						if (webElement.getText().toString().equalsIgnoreCase(RecordDetails)) 
                      {                    
                             WaitTillTime(2000);
                             elementPresent= true;
                             break loop;
                      }
               }
        }
  }
	
	public void ClickElementfromSectionlist(String Section_Xpath, String clickName) {
		List<WebElement> Elements =driver.findElements(By.xpath(Section_Xpath));
		for (WebElement webElement : Elements) 
        {
            if(webElement.getText().toString().equalsIgnoreCase(clickName))
            {
            	webElement.click();
            	WaitTillTime(3000);
            	webElement.click();
            	WaitTillTime(2000);
            	break;
            }
					
        }
		
	}
	
	public void SwitchToWindowANDFrame(String Xpath)
	{
		//properties = factory.getObjectProperties();
		for(String winHandle1 : driver.getWindowHandles())
		{
			driver.switchTo().window(winHandle1);
			WaitTillTime(1000);
			List<WebElement> ifr1 = driver.findElements(By.xpath("//iframe"));
			for(WebElement ifram1:ifr1) 
			{
				driver.switchTo().frame(ifram1);
				WaitTillTime(2000);
				if (IsElementPresent(driver,Xpath))
				{
					WaitTillTime(1000);
					break;
				}
			}
		}
	}
	
	public String isBlank(String Value)
	{
		String BlankValue;
		if (Value.isEmpty()) 
		{
			BlankValue="blank";
			} else {
			BlankValue=Value;	
		}
		return BlankValue;
	}
	
	public String GetRandomString()
	{
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 8) 
        {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        String salStr1 = "Random"+saltStr;
        return salStr1;
	}
	
	public String GetRandomnumber()
	{
        int size = 10000;
        Random rand = new Random();
        int number = rand.nextInt(size) + 1;
        return String.valueOf(number);
	}
	
	
	public void UploadDocumentfile(String filepath) throws Exception{
		StringSelection sPath1=new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sPath1, null);
		Robot robot=new Robot();
		robot.delay(4000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.delay(500);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		WaitTillTime(2000);
	}
	
	
	
	public String Add7DaysFromCurrentDate() {
		Date Todaydate = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(Todaydate); 
		cal.add(Calendar.DATE, 7);
		Date yourDate = cal.getTime();
		return new SimpleDateFormat("dd MMM yyyy").format(yourDate);
		}
	public Date GetTodaysDate() {
		Date Todaydate = Calendar.getInstance().getTime();
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(Todaydate); 
		Date yourDate = cal.getTime();
		//return new SimpleDateFormat("dd MMM yyyy").format(yourDate);
		return yourDate;
		}
	
	public String GetTodaysDateandTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH;mm;ss");  
		LocalDateTime now = LocalDateTime.now();    
		return dtf.format(now); 
		}
	
	public String GetCurrentDateandTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMM_HHmm");  
		LocalDateTime now = LocalDateTime.now();    
		return dtf.format(now); 
		}
		
	public Integer convertHourtoSecond(int Hoursvalue) {
		int Second =Hoursvalue*60*60;
		return Second;
		
	}
	
	/**_End selenium required methods________________________________________________________________________________________________________________________*/
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
