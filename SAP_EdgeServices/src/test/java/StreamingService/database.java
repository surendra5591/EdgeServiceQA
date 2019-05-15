package StreamingService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.testng.annotations.Test;

public class database extends EdgeServicecomponents {
	
	Properties properties = functionalcomponents.getObjectProperties();
	
	
	
	
	@Test
public String sampletestcase() {
	
	
	// Connection object
	
		Connection conn = null;
		
		// Statement object
		
		Statement stmt=null;
		     
	   // Constant for Database URL
		
		String DB_URL = "jdbc:sqlanywhere:";   
		
		// Constant for Database Username
		
		 String DB_USER = "DEP_admin";
		
		 // Constant for Database Password
		
		 String DB_PASSWORD = "1e727811f8f4e4ea38bb";
	StringBuilder sb = new StringBuilder();
	
	// sql anywhere data base connection
			
	try{
   // Make the database connection
   // String dbClass = "sap.jdbc4.sqlanywhere.IDriver";
   // Class.forName(dbClass).newInstance();
  // Get connection to DB
     conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
       System.out.println("DB Connected");
   // Statement object to send the SQL statement to the Database
       stmt = conn.createStatement();
				
       String Sensorquery = "SELECT * from SENSOR_PROFILE"+" WHERE SENSOR_PROFILE_NAME != 'COMPOSITE' "; 
				
  // Get the contents of action table from DB
				
	   ResultSet res = stmt.executeQuery(Sensorquery);
	   
	   
	   ResultSetMetaData rsmd = res.getMetaData();

	   int columnsNumber = rsmd.getColumnCount();
	   System.out.println(res.toString());
		     
  // Print the result untill all the records are printed
  // res.next() returns true if there is any next record else returns false
		while(res.next())	{	
	   for(int i = 1; i <= columnsNumber; i++)
	   {
	       
	      
	       
	       sb.append(rsmd.getColumnName(i)+":"+res.getString(i)+", ");
	       
	       
	   
		 		
	   }
	   System.out.println(sb);
		}
		 

			
// DB Connection close			

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
	
	
  return sb.toString();
  

 }	

}
