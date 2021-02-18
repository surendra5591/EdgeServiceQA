package POC_TestCases;

import java.io.*;
import org.json.simple.JSONArray; 
import org.json.simple.JSONObject; 
import org.json.simple.parser.*;
import net.lingala.zip4j.ZipFile;
public class ReadjsonFromprotectedZIP {
	static String JsonPath;
	
	 public static String[] getBasicAuthPassword(String Jsonconfigfilename) throws Exception
	   {    
		    String[] values = new String[13];
		    String password = "Suri@5591";
		    File file = new File(System.getProperty("user.dir")+"/ExportImportFolder/config.json");
	        if(file.delete()){
	            System.out.println("old config json File deleted");
	        }else System.out.println("old config file doesn't exist");
		    String ZipfilePath=System.getProperty("user.dir")+"/ExportImportFolder/"+Jsonconfigfilename+".zip";
		    ZipFile zipfile = new ZipFile(ZipfilePath, password.toCharArray());
		    zipfile.extractFile("config.json", System.getProperty("user.dir")+"/ExportImportFolder/");
		   JsonPath=System.getProperty("user.dir")+"/ExportImportFolder/config.json";
	      try
	      {
	    	 JSONParser parser = new JSONParser();
	    	 FileReader reader = new FileReader(JsonPath);
	     	JSONObject jo = (JSONObject) parser.parse(reader);
	     	System.out.println(jo);
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
	   public static void main(String args[]) throws Exception
	   {
	      String[] values = getBasicAuthPassword("RestricpasswordConfig3107_1543");
	      for(String i:values)
	      {
	      	System.out.println(i);
	      }
	   }
}




