package POC_TestCases;

import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import UtilityComponent.FunctionalComponents;
import UtilityComponent.RestAssuredComponents;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GeneratToken extends BaseTest {
	
	FunctionalComponents functionalcomponents = new FunctionalComponents(driver);
    Properties properties = FunctionalComponents.getObjectProperties();
    RestAssuredComponents restassuredcomponents= new RestAssuredComponents();
    String PolicyServiceURL = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "EdgeURL");  
    String CockpitURL= functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "CockpitURL");
   	String Cockpitusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "CockpitUserName");
   	String Cockpitpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "CockpitPassword");
    
    @Test
	 public void GeneratBearerToken() throws ParseException
		{
    	    String Baseurl=PolicyServiceURL+"/oauth/token?grant_type=client_credentials";
			String tokenresp = restassuredcomponents.PostAPIdatawithBasicAuth(Baseurl, Cockpitusername, Cockpitpassword, "");
			System.out.println(tokenresp);
			 JSONParser parse = new JSONParser(); 
			 JSONObject jsonobj = (JSONObject)parse.parse(tokenresp);
			 System.out.println(jsonobj);
			 String Accesstoken=(String) jsonobj.get("access_token");
			 System.out.println(Accesstoken);
			 String Getrespo = restassuredcomponents.GetAPIDatawithBearertokenAuth(CockpitURL, Accesstoken);
			 System.out.println(Getrespo);
			        
		}
	 
	 

}
