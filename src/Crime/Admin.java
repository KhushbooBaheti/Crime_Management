package Crime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Admin {
	private int adminId=1;
	private String adminPass="1";
	private String password;
	int statusa;
	boolean authenticate;
	String category;

	public void generatepass(Profile p){
		try{
			MysqlCon my=new MysqlCon();
			Connection con=my.getCon();
			PreparedStatement psa=con.prepareStatement("insert into password values(?,?)");  
		
		
		if(p.getCategory().equals("Victim")){
			password="v"+p.getName();
	
		}
		else if(p.getCategory().equals("Police")){
			password="p"+p.getName();
		}
		else if(p.getCategory().equals("Commissioner")){
			password="c"+p.getName();
		}
		else{
			password="-1";
		}
			p.setPassword(password);
			System.out.println(p.getPassword());
			psa.setInt(1,p.getId());
			psa.setString(2,password);
			statusa=psa.executeUpdate();
			con.close();
			
		}
		catch(Exception e){
				System.out.println(e);
				
			}
		
	}
	
	public boolean authenticate(int id,String password){
		try{
			MysqlCon my=new MysqlCon();
			Connection con=my.getCon();
			PreparedStatement ps=con.prepareStatement(  
					"select * from password where id=? and password=?");  
					ps.setInt(1,id);  
					ps.setString(2,password); 
					
					ResultSet rs=ps.executeQuery();  
					authenticate=rs.next(); 
					con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		
		return authenticate;
	}
		
	public String findCategory(int id,String password){
		char[] a=password.toCharArray();
		if(a[0]=='v'){
			category="Victim";
		}
		else if(a[0]=='p'){
			category="Police";
		}
		else if(a[0]=='c'){
			category="Commissioner";
		}
		return category;
	}
	
}
