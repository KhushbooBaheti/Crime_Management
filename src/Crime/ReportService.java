package Crime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReportService {
public int addReport(Report r,Evidence e,Profile p )
{
	int status=0,statusa=0;
	
	try{
			MysqlCon my=new MysqlCon();
		  Connection con=my.getCon();
		  PreparedStatement ps=con.prepareStatement("insert into Report values(?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);  
		PreparedStatement psa=con.prepareStatement("insert into Evidence values(?,?,?,?)");
			
			
			ps.setInt(1,r.getReportId());
			ps.setInt(2,p.getId());
			ps.setString(3,r.getCrimeType());
			ps.setString(4,r.getLocality());
			ps.setString(5,r.getDate());
			ps.setString(6,r.getTime());
			ps.setString(7,r.getDescription());
		ps.setString(8,r.getStatus());
			
			status=ps.executeUpdate();
			
			ResultSet keys = ps.getGeneratedKeys();    
			keys.next();  
			int key = keys.getInt(1);
			p.setId(key);
			
			psa.setInt(1,e.getEvidenceNo());
			psa.setInt(2, key);
			psa.setString(3,e.getEvidenceType());
			psa.setString(4,e.getEvidenceType());
			
			
			statusa=psa.executeUpdate();
			con.close();
			
			
			

	}
	catch(Exception exp)
	{
		System.out.println(exp);
	}
	return status;
}
}