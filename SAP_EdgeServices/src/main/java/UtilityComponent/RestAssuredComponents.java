package UtilityComponent;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.aventstack.extentreports.Status;

import BaseComponent.BaseTest;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredComponents extends BaseTest {
	
	//Author SURENDRA SINGH
	
	String APIData="";
	
	
	public String GetAPIDatawithBaiscAuth(String BaseURL, String username, String password) {
		 
		Response response=RestAssured.given().auth().basic(username, password).when().get(BaseURL);
	    System.out.println(response);
	   int code =response.getStatusCode();
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
	    APIData =response.asString();
	    System.out.println(APIData);
	    return APIData;
	 
 }
	public String PostAPIdatawithBasicAuth(String BaseURL, String username, String password, String Payload) {
		 RequestSpecification request = RestAssured.given().auth().basic(username, password);
		 request.header("Content-Type", "application/json");
		 request.body(Payload);
		 request.log().all();
		 Response response =request.post(BaseURL);
		 int statusCode = response.getStatusCode();
		 System.out.println(statusCode);
		 String Responsedata =response.asString();
		  System.out.println("body data is"+Responsedata);
		 String statusdescription= response.getStatusLine();
		 System.out.println(statusdescription);
		 if(statusCode==200 || statusdescription.contains("OK") ) 
		 {
		 test.log(Status.PASS, "User is able to post Successfully in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode+" response for successful HTTP requests");
		 }
		 else if (statusCode==504)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+"Bad Request"+Responsedata);
		   } 
		 else if (statusCode==400)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+" The server didn't respond in time due to requests time.Please check jeson payload format"+Responsedata);
		   } 
		 
		 else if (statusCode==409)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+" Response :"+Responsedata);
		   } 
		else if (statusCode==500)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+"Internal Server Error and Response :"+Responsedata);
		   } 	 
		 
		 else {
			 test.log(Status.FAIL, "User is not able to post in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode);
		 }
		 return Responsedata;
	}
	
	public String GetAPIDatawithBearertokenAuth(String BaseURL, String BearerToken) {
		 
		Response response=RestAssured.given().auth().oauth2(BearerToken).when().get(BaseURL);
	    System.out.println(response);
	   int code =response.getStatusCode();
	   APIData =response.asString();
	   System.out.println(code);
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
	public String PostAPIdatawithBearertokenAuth(String BaseURL, String BearerToken, String Payload) {
		 RequestSpecification request = RestAssured.given().auth().oauth2(BearerToken);
		 request.header("Content-Type", "application/json");
		 request.body(Payload);
		 Response response =request.post(BaseURL);
		 int statusCode = response.getStatusCode();
		 System.out.println(statusCode);
		 String Responsedata =response.asString();
		  System.out.println("body data is"+Responsedata);
		 String statusdescription= response.getStatusLine();
		 System.out.println(statusdescription);
		 if(statusCode==200 || statusdescription.contains("OK") ) 
		 {
		 test.log(Status.PASS, "User is able to post Successfully in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode+" response for successful HTTP requests");
		 }
		 else if (statusCode==504)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+"Bad Request"+Responsedata);
		   } 
		 else if (statusCode==400)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+" The server didn't respond in time due to requests time.Please check jeson payload format"+Responsedata);
		   } 
		 
		 else if (statusCode==409)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+" Response :"+Responsedata);
		   } 
		else if (statusCode==500)
		   {
			   test.log(Status.FAIL, "Status Code :"+statusCode+"Internal Server Error and Response :"+Responsedata);
		   } 	 
		 
		 else {
			 test.log(Status.FAIL, "User is not able to post in IOT Cokpit using API EndPOint URL :"+BaseURL+";"+"Status code is"+statusCode);
		 }
		 return Responsedata;
	}
	 public String GeneratBearerToken(String Requesturl, String ClientID, String ClientSecret)
		{
			String tokenresp = PostAPIdatawithBasicAuth(Requesturl, ClientID, ClientSecret, "");
			//System.out.println(tokenresp);
			 JSONParser parse = new JSONParser(); 
			 JSONObject jsonobj = null;
			try {
				jsonobj = (JSONObject)parse.parse(tokenresp);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 String Accesstoken=(String)jsonobj.get("access_token");
			 System.out.println(Accesstoken);
			return Accesstoken;
		}
}
