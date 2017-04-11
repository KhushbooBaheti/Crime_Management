package Crime;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Admin {
	private int adminId=1;
	private String adminPass="1";
	private String password;
	int statusa;
	

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
	
	
}
