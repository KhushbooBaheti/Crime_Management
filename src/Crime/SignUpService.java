package Crime;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SignUpService {
	   
	public int Register(Profile p)
	{		int status=0;
	
			try{
					MysqlCon my=new MysqlCon();
				  Connection con=my.getCon();
			System.out.println(p.getName());
			System.out.println(p.getId());
			System.out.println(p.getContact());
			System.out.println(p.getAid());
			System.out.println(p.getAge());
			System.out.println(p.getEmail());
			System.out.println(p.getGender());
			System.out.println(p.getCategory());
		
			PreparedStatement ps=con.prepareStatement("insert into Profile values(?,?,?,?,?,?,?,?)");  
			
	
			
			ps.setString(1,p.getName());
			ps.setInt(2,p.getId());
			ps.setString(3,p.getContact());
			ps.setInt(4,p.getAid());
			ps.setInt(5,p.getAge());
			ps.setString(6, p.getEmail());
			ps.setString(7, p.getGender());
			ps.setString(8, p.getCategory());
			System.out.println(p.getGender());
			System.out.println(p.getCategory());
		
		status=ps.executeUpdate();
			con.close();
		
			}
			catch(Exception e)
			{
				System.out.println(e);
	}
			return status;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}