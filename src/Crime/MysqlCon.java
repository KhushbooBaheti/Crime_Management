package Crime;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MysqlCon {

			// TODO Auto-generated method stub
		
	    
	    
		
		public  Connection getCon()
		{	
			Connection con=null;
			try{  
			    Class.forName("com.mysql.jdbc.Driver");  
			     con=DriverManager.getConnection(  
			    "jdbc:mysql://localhost:3306/CrimeManagement","root","@mysql5");  
			    //here MovieRating is database name, root is username and password  
			    }catch(Exception e){
			    	
			    	System.out.println("Connection not established");
			    	System.out.println(e);}  
			return con;
		}
	     public static void closeCon(Connection con)
	     {
	    	try
	    	{con.close();
	     }
	    	catch(Exception e)
	    	{
	    		System.out.println(e);
	    	}
	}
}


