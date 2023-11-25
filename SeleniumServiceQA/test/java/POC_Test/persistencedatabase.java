package POC_Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;


public class persistencedatabase extends BaseTest {
	
	Properties properties = functionalcomponents.getObjectProperties();
	
@Test
public void GetDatafromPersistenceDataBase (){
	
	 String DBusername = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "PersistenceDB_Username");
	  String DBpassword = functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "PersistenceDB_Password");
	  String Servername= functionalcomponents.getdatafromsheet("GlobalTestData", "GlobalEdgeServiceTestData", "ServerName");

		
	// Connection object
	
			Connection conn = null;
			
			// Statement object
			
			Statement stmt=null;
			     
		   // Constant for Database URL
			
			String PersistanceDB_URL="jdbc:sqlanywhere:UserID="+DBusername+";Password="+DBpassword+";ServerName="+Servername+"";
		       
			// Constant for Database Username
			
			 String DB_USER = "DBA"; 

			
			 // Constant for Database Password
			
			 String DB_PASSWORD = "e68ee62acc149d099d96";

		StringBuilder sb = new StringBuilder();

	// sql anywhere data base connection
			
	try{
	// Make the database connection
	// String dbClass = "sap.jdbc4.sqlanywhere.IDriver";
	// Class.forName(dbClass).newInstance();
	// Get connection to DB
	  conn=DriverManager.getConnection(PersistanceDB_URL);
	   System.out.println("DB Connected");
	// Statement object to send the SQL statement to the Database
	  // stmt = conn.createStatement();
	   stmt = conn.createStatement();
				
	// Get the contents of action table from DB
		String sqlquery ="SELECT PROP_VALUE FROM EFPS.CONFIG_MEASURE";	
	   ResultSet res = stmt.executeQuery(sqlquery);
	   
	   
	   ResultSetMetaData rsmd = res.getMetaData();

	   int columnsNumber = rsmd.getColumnCount();
	  // System.out.println(res.toString());
		     
	// Print the result untill all the records are printed
	// res.next() returns true if there is any next record else returns false
		while(res.next())	{	
	   for(int i = 1; i <= columnsNumber; i++)
	   {    
	       sb.append(rsmd.getColumnName(i)+":"+res.getString(i)+", ");
	       		
	   }
		}
		 			
	//DB Connection close			
	res.close();
	stmt.close();
	conn.close();
	} 
	catch (SQLException se) {
		 se.printStackTrace();
	}
	catch (Exception e) {
	  e.printStackTrace();
	}
	finally
	{
	    try {
		 if (stmt != null)
		     stmt.close();
		     } catch (SQLException se2) {
		        }// nothing we can do
		        try {
		            if (conn != null)
		                conn.close();
		        } catch (SQLException se) {
		            se.printStackTrace();
		        }
	 }

	System.out.println(sb.toString());
	// return sb.toString();
	}
	
}
