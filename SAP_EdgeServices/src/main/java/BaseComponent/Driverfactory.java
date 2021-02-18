package BaseComponent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Driverfactory {
	
	/**
	 * Driver Factory class
	 * @author SURENDRA SINGH
	 */

	public static WebDriver driver;
	public static Properties properties;
	public static String testMachineOS;
	public static String testMachineSystemType;

	public static void getBrowser(String browserName) {
		
		testMachineOS=System.getProperty("os.name");
		testMachineSystemType=System.getProperty("os.arch");
		//System.out.println(testMachineOS);
		//System.out.println(testMachineSystemType);
	if (browserName.equalsIgnoreCase("chrome"))
	{
			ChromeDriverService service = null;
			if(testMachineOS.contains("Windows"))
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver.exe");
			else if(testMachineSystemType.contains("32"))
			{
				File chromeDriver = new File(System.getProperty("user.dir")+"/driver/chromedriver_linux32");
				chromeDriver.setExecutable(true);
				System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
			}
			else if(testMachineSystemType.contains("64"))
			 {
				File chromeDriver = new File("/driver/chromedriver");
				System.out.println(chromeDriver);
				chromeDriver.setExecutable(true);
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/driver/chromedriver");
				service = new ChromeDriverService.Builder().usingDriverExecutable(chromeDriver).usingAnyFreePort().build(); 
				try { 
			     	  service.start();
				    } 
				   catch (IOException e)
				   {
				   e.printStackTrace(); 
				   }
				 
			  }
			
	         try 
	         { 
		   		String strDirectoy = "ExportImportFolder";

				boolean success = (new File(strDirectoy)).mkdir();
				if (success)
				 {
					System.out.println("Directory: "+ strDirectoy+ "created");
				  }

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("download.default_directory", System.getProperty("user.dir")+File.separator+ "ExportImportFolder");

				ChromeOptions options = new ChromeOptions();
			    // options.addArguments("headless");
				options.addArguments("--no-sandbox");
				options.addArguments("--disable-dev-shm-usage"); 
				options.addArguments("--disable-extensions"); 
				options.addArguments("start-maximized");
				options.addArguments("--ignore-ssl-errors=yes");
				options.addArguments("--ignore-certificate-errors");
				options.addArguments("--allow-insecure-localhost");
				options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				options.setExperimentalOption("prefs", prefs);
				driver = new ChromeDriver(options);
				driver.manage().deleteAllCookies();
				
				//driver.manage().window().maximize();
				Thread.sleep(1000);
			 } 
	         catch (Exception e) {

				e.printStackTrace();
			  }
	}
		
	else if (browserName.equalsIgnoreCase("Firefox"))
	{
			try {
				System.setProperty("webdriver.gecko.driver", "path");
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				Thread.sleep(1000);
			} catch (Exception e) {

				e.printStackTrace();
			}
	}
		
	else if (browserName.equalsIgnoreCase("InternetExplorer"))
	{
			try {
				 
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+"/driver/IEDriverServer.exe");
				DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
				caps.setCapability("ignoreZoomSetting", true);
				caps.setCapability("nativeEvents",false);
				driver = new InternetExplorerDriver();
				driver.manage().window().maximize();
				Thread.sleep(1000);
			    } catch (Exception e) {

				e.printStackTrace();
			}
	}
		

 }
	
   public static WebDriver getDriver()
   {
	return driver;
   }

	
}
	


