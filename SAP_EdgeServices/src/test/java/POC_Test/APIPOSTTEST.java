package POC_Test;

import java.util.Properties;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APIPOSTTEST extends BaseTest {
	
	 Properties properties = functionalcomponents.getObjectProperties();
	 String CockpitURL= functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "CockpitURL");
		String Cockpitusername = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "UserName");
		String Cockpitpassword = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "Password");
	 
	String CapablityName = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "CapablityName");
	String CapablityAlternateID = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "CapablityAlternateID");
	String  PropertiesName1 = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "PropertiesName1");
	String  PropertiesName2 = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "PropertiesName2");
	String SensorTypesName = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "SensorTypesName");
	String DeviceName = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "DeviceName");
	String GateWayNo = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "GateWayNo");
	String DeviceAlternateID = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "DeviceAlternateID");
	String SensorName = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "SensorName");
	String SensorAltID = functionalcomponents.getdatafromsheet("CockPit", "E2E_Cockpit_Testcase_Flow", "SensorAltID");
	
	 String DeviceBaseurl = CockpitURL+"/iot/core/api/v1/devices";
	 String SesorTypeBaseURL=CockpitURL+"/iot/core/api/v1/sensorTypes";
	 String CapabiltyBaseURL=CockpitURL+"/iot/core/api/v1/capabilities";
	 String SensorBaseURL=CockpitURL+"/iot/core/api/v1/sensors";
	 static String SensornameAPI="";
	 static String SensorTypeIDAPI="";
	 static String SensorTypeNameAPI="";
	 static String DevicenameAPI= "";
	 static String DeviceIDAPI= "";
	 static String CapablityIDAPI="";
	 static String CapablitynameAPI="";
	 static String  APIData;
	 static String PropertiesName1API="";
	 static String PropertiesName2API="";
	 
	 
	@Test
	 public void Create_Capablity_Device_Sensor_SensorType() throws Exception {
			
		 String Cap_Payload2="{\r\n"+
		            "\"alternateId\":\""+CapablityAlternateID+"\","+
			 		"\"name\":\""+CapablityName+"\","+ 
			 		"  \"properties\": [\r\n" + 
			 		"    {\r\n" + 
			 		"      \"dataType\": \"float\",\r\n" + 
			 		"      \"formatter\": {\r\n" + 
			 		"        \"dataType\": \"float\",\r\n" + 
			 		"        \"scale\": 0,\r\n" + 
			 		"        \"shift\": 0,\r\n" + 
			 		"        \"swap\": true\r\n" + 
			 		"      },\r\n" + 
			 		"      \"name\":\""+PropertiesName1+"\"," + 
			 		"      \"unitOfMeasure\": \"Degree\"\r\n" + 
			 		"    },\r\n" +
			 		" {\r\n" + 
			 		"			\"dataType\": \"float\",\r\n" + 
			 		"			\"formatter\": {\r\n" + 
			 		"				\"dataType\": \"float\",\r\n" + 
			 		"				\"scale\": 0,\r\n" + 
			 		"				\"shift\": 0,\r\n" + 
			 		"				\"swap\": true\r\n" + 
			 		"			},\r\n" + 
			 		"			\"name\":\""+PropertiesName2+"\",\r\n" + 
			 		"			\"unitOfMeasure\": \"Degree\"\r\n" + 
			 		"		} ]\r\n" + 
			 		"}";
		
		
		CapablityIDAPI=CreateCapablityIDandCapablityName(Cap_Payload2);
		System.out.println(CapablityIDAPI);
		String Sensortypepayload="{\r\n" + 
				"  \"alternateId\":\"\",\r\n" + 
				"  \"capabilities\": [\r\n" + 
				"    {\r\n" + 
				"      \"id\":\""+CapablityIDAPI+"\",\r\n" + 
				"      \"type\": \"measure\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"name\": \""+SensorTypesName+"\"\r\n" + 
				"}";
		System.out.println(Sensortypepayload);
		SensorTypeIDAPI=CreateSensortypeIDandSensortypename(Sensortypepayload);
		System.out.println(SensorTypeIDAPI);
		String DevicePayload="{\r\n" + 
				"  \"customProperties\": [\r\n" + 
				"    {\r\n" + 
				"      \"key\": \"string\",\r\n" + 
				"      \"value\": \"string\"\r\n" + 
				"    }\r\n" + 
				"  ],\r\n" + 
				"  \"gatewayId\": \""+GateWayNo+"\",\r\n" + 
				"  \"name\": \""+DeviceName+"\"\r\n" + 
				"}";
		 
		DeviceIDAPI=CreateDeviceIdandDevicename(DevicePayload);
		System.out.println(DeviceIDAPI);
		String SensorPayload="{\r\n" + 
				"  \"alternateId\": \""+SensorAltID+"\",\r\n" + 
				"  \"deviceId\": \""+DeviceIDAPI+"\",\r\n" + 
				"  \"name\": \""+SensorName+"\",\r\n" + 
				"  \"sensorTypeId\": \""+SensorTypeIDAPI+"\"\r\n" + 
				"}";
		System.out.println(SensorPayload);
		SensornameAPI=CreateSensor(SensorPayload);
		System.out.println(SensornameAPI);
		
		SensorTypeNameAPI=SensorTypesName;
		DevicenameAPI=DeviceName;
	}
	
		
	
public String postdata(String BaseURL, String username, String password, String Payload) {
		 RequestSpecification request = RestAssured.given().auth().basic(username, password);
		 request.header("Content-Type", "application/json");
		 request.body(Payload);
		 Response response =request.post(BaseURL);
		 int statusCode = response.getStatusCode();
		 System.out.println(statusCode);
		 String Responsedata =response.asString();
		  System.out.println("body data is"+Responsedata);
		 String statusdescription= response.getStatusLine();
		 System.out.println(statusdescription);
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
		 
		 
 public String CreateCapablityIDandCapablityName(String Capablitypayload) throws Exception {	 
	
	 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
	    		 CapabiltyBaseURL = CockpitURL+"/iot/core/api/v1/capabilities";
		 }
	 else
		 {
				 CapabiltyBaseURL = CockpitURL+"/iot/core/api/v1/capabilities"; 
		 }	
	      String capablityid=""; 
		   APIData =postdata(CapabiltyBaseURL, Cockpitusername, Cockpitpassword, Capablitypayload);
		   JSONParser parse = new JSONParser(); 
		   JSONObject jsoncapobj = (JSONObject) parse.parse(APIData);
		   capablityid=(String) jsoncapobj.get("id");
		   CapablitynameAPI=(String) jsoncapobj.get("name");
		   JSONArray jsoncaparr = (JSONArray)jsoncapobj.get("properties");
		   for(int i=0;i<jsoncaparr.size();i++)
		   {
		   JSONObject jsonproparr = (JSONObject)jsoncaparr.get(i);
		   if(i==0)
		   PropertiesName1API=(String) jsonproparr.get("name");
		   if(i>0)
		   PropertiesName2API=(String) jsonproparr.get("name");
	      }
		return capablityid;
		   
}
 
 public String CreateSensortypeIDandSensortypename(String sensortypepayload) throws Exception {
	 if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
		 SesorTypeBaseURL = CockpitURL+"/iot/core/api/v1/sensorTypes";
	 }
	 else
	 {
		 SesorTypeBaseURL = CockpitURL+"/iot/core/api/v1/tenant/sensorTypes"; 
	 }
	 String SensortypeId="";
	 APIData =postdata(SesorTypeBaseURL, Cockpitusername, Cockpitpassword, sensortypepayload);
	 JSONParser parse = new JSONParser(); 
	 JSONObject jsonSentypobj = (JSONObject) parse.parse(APIData);
	 SensortypeId=(String) jsonSentypobj.get("id");
       
	return SensortypeId;
 }
 
 public String CreateDeviceIdandDevicename(String Devicepayload) throws Exception {
	 
		if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
			DeviceBaseurl = CockpitURL+"/iot/core/api/v1/devices";
			 }
		 else
			 {
			 DeviceBaseurl = CockpitURL+"/iot/core/api/v1/devices"; 
			 }	
		      String Deviceid=""; 
			   APIData =postdata(DeviceBaseurl, Cockpitusername, Cockpitpassword, Devicepayload);
			   JSONParser parse = new JSONParser(); 
			   JSONObject jsondevobj = (JSONObject) parse.parse(APIData);
			   Deviceid=(String) jsondevobj.get("id");
			  return Deviceid;	   
	}
 
 public String CreateSensor(String Sansorpayload) throws Exception {
	 
		if(CockpitURL.equalsIgnoreCase("https://dep.canary.cp.iot.sap")) {
			SensorBaseURL = CockpitURL+"/iot/core/api/v1/sensors";
			 }
		 else
			 {
			 SensorBaseURL = CockpitURL+"/iot/core/api/v1/devices"; 
			 }	
		      String Sensorname=""; 
			   APIData =postdata(SensorBaseURL, Cockpitusername, Cockpitpassword, Sansorpayload);
			   JSONParser parse = new JSONParser(); 
			   JSONObject jsonsenobj = (JSONObject) parse.parse(APIData);
			   Sensorname=(String) jsonsenobj.get("name");
			return Sensorname;
 }
 
 
}



