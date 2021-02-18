package POC_Test;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class CreateCustomPropertiesandaddtoGW extends BaseTest {
	
    Properties properties = functionalcomponents.getObjectProperties();
    String CurrentDateandTime =functionalcomponents.GetCurrentDateandTime(); 

    @Test
   	public void CreateUserTypeCustomPropertiesandDeleting() {
      String UserCustomPropertyName="UserProperty"+CurrentDateandTime;
      functionalcomponents.ClickOperation(properties.getProperty("SAP_logo"));			  
   	  functionalcomponents.WaitTillTime(10000);
   	  functionalcomponents.ClickOperation(properties.getProperty("Gateway_management"));
   	  functionalcomponents.WaitTillTime(30000);
   	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("ConfigProperties"), 90);
      functionalcomponents.ClickOperation(properties.getProperty("ConfigProperties"));
   	  functionalcomponents.waittill_WebElement_getVisible(properties.getProperty("AddPropertiesbutton"), 90);
      functionalcomponents.ClickOperation(properties.getProperty("AddPropertiesbutton"));
   	  functionalcomponents.WaitTillTime(4000);
   	  functionalcomponents.ClearAndSetValue(properties.getProperty("PropertyNameinput"), UserCustomPropertyName);
   	  functionalcomponents.WaitTillTime(3000);
      functionalcomponents.ClickOperation(properties.getProperty("CreatePeopertyNamebutton"));
   	  functionalcomponents.WaitTillTime(7000);
   	  WebElement CreatedName=driver.findElement(By.xpath("//span[text()='"+UserCustomPropertyName+"']"));
	  if(CreatedName.getText().equalsIgnoreCase("UserCustomPropertyName"))
	  {
		  test.log(Status.PASS, "user is able to Create Global Custom Properties as:"+UserCustomPropertyName);
	  } else
	  {
        failedDescription("user is not able to Create Global Custom Properties");
      }
	  functionalcomponents.WaitTillTime(7000);
	  functionalcomponents.ClickOperation(properties.getProperty("DeleteCongifProperty"));
   	  functionalcomponents.WaitTillTime(2000);
   	  functionalcomponents.ClickOperation(properties.getProperty("DeleteConfirm"));
 	  functionalcomponents.WaitTillTime(7000);
 	 if (driver.findElement(By.xpath(properties.getProperty("AddPropertiesbutton"))).isDisplayed())
	  {
 		test.log(Status.PASS, "user is able to Delete Global Custom Properties:"+UserCustomPropertyName);
	  } else
	  {
        failedDescription("user is not able to Delete Global Custom Properties");
      }
   

    	
    }
}
