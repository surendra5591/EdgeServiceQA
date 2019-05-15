package PolicyService;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;
public class Readjson {
	
	
	 public static String[] getBasicAuthPassword(String Jsonconfigfilename)
	   {
	   		String[] values = new String[13];
	   		String JsonPath=System.getProperty("user.dir")+"/ExportImportFolder/"+Jsonconfigfilename+"-1.0.json";
	   		System.out.println(JsonPath);
	      try
	      {
	    	 JSONParser parser = new JSONParser();
	    	 FileReader reader = new FileReader(JsonPath);
	     	JSONObject jo = (JSONObject) parser.parse(reader);
		    String PluginName1="RESTEnterprisePlugins2";
		    String PluginName2="WebsocketEnterprisePlugins2";
		    String PluginName3="MQTTEnterprisePlugins2";
		    String PluginName4="HDFSEnterprisePlugins2";
	     	while((PluginName1.contentEquals("RESTEnterprisePlugins2")))
	     	{	
	     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
		      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
		      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
		      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("RESTEnterprisePlugins2");
		      JSONObject restInfo = (JSONObject) restEP2.get(0);
		      values[0] = "BasicAuthPassword :"+(String)restInfo.get("BasicAuthPassword");
		      values[1] = "KeyManagerPassword :"+(String)restInfo.get("KeyManagerPassword");
		      values[2] = "KeyStorePassword :"+(String)restInfo.get("KeyStorePassword");
		      values[3] = "TrustStorePassword :"+(String)restInfo.get("TrustStorePassword");
		      break;
	     	}
	     	while((PluginName2.contentEquals("WebsocketEnterprisePlugins2")))
	     	{	
		     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
			      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
			      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
			      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("WebsocketEnterprisePlugins2");
			      JSONObject restInfo = (JSONObject) restEP2.get(0);
			      values[4] = "BasicAuthPassword :"+(String)restInfo.get("BasicAuthPassword");
			      values[5] = "KeyManagerPassword :"+(String)restInfo.get("KeyManagerPassword");
			      values[6] = "KeyStorePassword :"+(String)restInfo.get("KeyStorePassword");
			      values[7] = "TrustStorePassword :"+(String)restInfo.get("TrustStorePassword");
			      break;
		     	}
	     	while((PluginName3.contentEquals("MQTTEnterprisePlugins2")))
	     	{	
		     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
			      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
			      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
			      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("MQTTEnterprisePlugins2");
			      JSONObject restInfo = (JSONObject) restEP2.get(0);
			      values[8] = "ClientPassword :"+(String)restInfo.get("ClientPassword");
			      values[9] = "KeyStorePassword :"+(String)restInfo.get("KeyStorePassword");
			      values[10] = "TrustStorePassword :"+(String)restInfo.get("TrustStorePassword");
			      break;
		     	}
	     	while((PluginName4.contentEquals("HDFSEnterprisePlugins2")))
	     	{	
		     	  JSONObject sysConfig = (JSONObject) jo.get("SystemConfig");
			      JSONObject plugins = (JSONObject) sysConfig.get("Plugins");
			      JSONObject enterprisePlugins = (JSONObject) plugins.get("EnterprisePlugins");
			      JSONArray restEP2 = (JSONArray) enterprisePlugins.get("HDFSEnterprisePlugins");
			      JSONObject restInfo = (JSONObject) restEP2.get(0);
			      values[11] = "DelegationToken :"+(String)restInfo.get("DelegationToken");
			      values[12] = "OAuth2Token :"+(String)restInfo.get("OAuth2Token");
			      break;
			      
		     	}
	     	
	      }
	      catch(Exception e)
	      {
	         e.printStackTrace();
	      }
	      return values;
	   }
	   public static void main(String args[])
	   {
	      String[] values = Readjson.getBasicAuthPassword("Lat_SecurityCheck23");
	      for(String i:values)
	      {
	      	System.out.println(i);
	      }
	   }
}




