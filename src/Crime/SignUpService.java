package Crime;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class SignUpService {
	   
	public int Register(Profile p,Address add)
	{		int status=0,statusa=0;
	
			try{
					MysqlCon my=new MysqlCon();
				  Connection con=my.getCon();
			System.out.println(p.getName());
			System.out.println(p.getId());
			System.out.println(p.getContact());
			
			System.out.println(p.getAge());
			System.out.println(p.getEmail());
			System.out.println(p.getGender());
			System.out.println(p.getCategory());
		
			PreparedStatement ps=con.prepareStatement("insert into Profile values(?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);  
			PreparedStatement psa=con.prepareStatement("insert into Address values(?,?,?,?,?)");  
	
			
			ps.setString(1,p.getName());
			ps.setInt(2,p.getId());
			ps.setString(3,p.getContact());
				ps.setInt(4,p.getAge());
			ps.setString(5, p.getEmail());
			ps.setString(6, p.getGender());
			ps.setString(7, p.getCategory());
			status=ps.executeUpdate();
			/*ResultSet rs = ps.executeQuery("select last_insert_id() as last_id from Profile");
			int lastid = rs.getInt("last_id");*/


			ResultSet keys = ps.getGeneratedKeys();    
			keys.next();  
			int key = keys.getInt(1);
			
			psa.setInt(1,key);
			psa.setString(2,add.getplot());
			psa.setString(3,add.getLandmark());
			psa.setString(4,add.getCity());
			psa.setString(5,add.getState());
			System.out.println(add.getState());
		
		statusa=psa.executeUpdate();
			con.close();
		
			}
			catch(Exception e)
			{
				System.out.println(e);
	}
			return status;
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}