package POC_Test;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetdataUsingAPI extends BaseTest{
	
	 String Baseurl = "https://dep-dev-spring.canary.cp.iot.sap/iot/core/api/v1/devices";
	 //jeson Payload for post API.
	 String Payload="JSON Format";	 
@Test
public String GetDataMethod(String BaseURL, String username, String password) throws Exception {
				
		Response response=RestAssured.given().auth().basic(username, password).when().get(BaseURL);
	    System.out.println(response);
	   int code =response.getStatusCode();
	   System.out.println("status code is"+code);
	   //Assert.assertEquals(code, 200);
	    String  APIData =response.asString();
	   System.out.println("body data is"+APIData);
	   JSONParser parse = new JSONParser(); 
	   JSONArray jsonarr = (JSONArray)parse.parse(APIData);
	   for(int i=0;i<jsonarr.size();i++)
	   {
	   JSONObject jsondeviceobj = (JSONObject)jsonarr.get(i);	 
	   System.out.println("gatewayId:"+jsondeviceobj.get("Key"));
	  
	   }
	   if(code==200)
	   {
		   test.log(Status.PASS, "Status Code :"+code+" User successfully GET an entity corresponding to the requested");
	   }
	   else if (code==505)
	   {
		   test.log(Status.FAIL, "Status Code :"+code+" Service Unavailable");
	   }
	   else if (code==404)
	   {
		   test.log(Status.FAIL, "Status Code :"+code+" requested resource has not been found.Please check the requested URL.");
	   }
	   
	   else if (code==504)
	   {
		   test.log(Status.FAIL, "Status Code :"+code+" The server didn't respond in time due to timeout requests.Please try again later");
	   } 
	   else {
		   test.log(Status.FAIL, "API URL is incorrect Unknow host Error Please check url");
	   }
	    return APIData;
	 
 }
	
	
	@Test
	public String postdata(String BaseURL, String username, String password, String Payload) {
		
		 RequestSpecification request = RestAssured.given().auth().basic(username, password);
		 request.header("Content-Type", "application/json");
		 request.body(Payload);
		 Response response = request.post(BaseURL);
		 int statusCode = response.getStatusCode();
		 System.out.println(statusCode);
		 String Responsedata =response.asString();
		 String statusdescription= response.getStatusLine();
		 if(statusCode==200 & statusdescription.contains("OK") ) 
		 {
		 test.log(Status.PASS, "User is able to post Successfully in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode+" response for successful HTTP requests"+Responsedata);
		 }
		 else if (statusCode==504)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+"Bad Request"+Responsedata);
		   } 
		 else if (statusCode==400)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+" The server didn't respond in time due to requests time.Please check jeson payload format"+Responsedata);
		   } 	 
		 else {
			 test.log(Status.FAIL, "User is not able to post in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode);
		 }
		// System.out.println(Responsedata);
		 return Responsedata;
	}

}
