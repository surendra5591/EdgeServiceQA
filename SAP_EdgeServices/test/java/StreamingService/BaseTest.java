package StreamingService;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import functionalComponent.Driverfactory;
import functionalComponent.FunctionalComponents;

public class BaseTest {
	

	public WebDriver driver;
	  public static ExtentReports extent;
	  public static ExtentTest test;
	  SoftAssert softAssertion;
	  String stepScreenShot;
	  String failedScreenshot;
	  Properties properties;
	  
	 FunctionalComponents functionalcomponents= new FunctionalComponents(driver);
	  
	  Driverfactory factory = new Driverfactory();
	  	
	
	 @BeforeSuite
	 public void beforeSuite() {
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./ExtentReports/StreamingServiceEdgeReport"+" "+functionalcomponents.GetTodaysDateandTime()+".html");
			htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setDocumentTitle("./Reports/Edgereport.html");
			htmlReporter.config().setEncoding("utf-8");
			htmlReporter.config().setReportName("Automation Report");
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);	
		

		} 
	 	 
	@BeforeClass
	public void beforeClass() {

		test = extent.createTest(getClass().getName());
		properties =functionalcomponents.getObjectProperties();
        this.driver= factory.getBrowser(properties.getProperty("BrowserName"));
        functionalcomponents = new FunctionalComponents(driver);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		softAssertion= new SoftAssert();
		test.log(Status.INFO,"*******"+ method.getName()+" "+"started**********");	
		
}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{	
		if(result.getStatus()==ITestResult.FAILURE)
		{
			//test.log(Status.FAIL, result.getThrowable());
			failedScreenshot=functionalcomponents.getScreenshot(driver);
			test.fail(result.getThrowable(), MediaEntityBuilder.createScreenCaptureFromPath(failedScreenshot).build());
			test.log(Status.FAIL, result.getName()+" is Failed");
		}	
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS, result.getName()+" is passed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP, result.getThrowable());
		}
		
	}
	
	@org.testng.annotations.AfterClass
	public void AfterClass() {
		softAssertion= new SoftAssert();
		extent.flush();
	    driver.close();
		
}
	@org.testng.annotations.AfterSuite
	public void AfterSuite() {
		driver.quit();
	}
 
//failed	
	public void failedDescription(String failedMessage)
	{
		softAssertion= new SoftAssert();
		stepScreenShot=functionalcomponents.getScreenshot(driver);
		 try {
			 softAssertion.fail(failedMessage);
			 test.fail(failedMessage, MediaEntityBuilder.createScreenCaptureFromPath(stepScreenShot).build());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
	
	
