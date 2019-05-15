package PolicyService;

import java.util.Properties;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class JenkinsTestAmazon extends BaseTest {
	
	 Properties properties = functionalcomponents.getObjectProperties();	
	
	 @Test
	public void AmazonTest_flow() {
		 
		 String UserName=functionalcomponents.getdatafromsheet("CockPit", "AmazonTest_flow", "username");
		 String password=functionalcomponents.getdatafromsheet("CockPit", "AmazonTest_flow", "password");
		 String Amazonurl=functionalcomponents.getdatafromsheet("CockPit", "AmazonTest_flow", "CockpitURL");
		 
		 test.log(Status.INFO, "Lunch the amazon url");
		 driver.get(Amazonurl);
		 functionalcomponents.WaitTillTime(2000);
		 String pagetitle=driver.getTitle();		 
		 if(driver.getTitle().contains("Log On"))
		 {	
			test.log(Status.PASS,"URL: is loaded successfully, page title- "+pagetitle);
		 }
		 else {
			failedDescription("invalid URL");
		 }
	 }
		
	}


