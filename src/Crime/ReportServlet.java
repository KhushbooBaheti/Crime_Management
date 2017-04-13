package Crime;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.sql.*;

/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Report r=new Report();
		Evidence evd=new Evidence();
		
		r.setCrimeType(request.getParameter("crimetype"));
		r.setLocality(request.getParameter("crimelocation"));
		 String startDate=request.getParameter("crimedate");
		 String starttime=request.getParameter("crimetime");
		 try{
		   SimpleDateFormat sdf1 = new SimpleDateFormat("MM-dd-yyyy");
		   java.util.Date date = sdf1.parse(startDate);
		   java.sql.Date sqlCdate = (java.sql.Date) new Date(date.getTime());
		   r.setDate(sqlCdate);
		
		}
		 catch(Exception e)
		 {
			 System.out.println(e);
		 }
		 
		 try {

			    SimpleDateFormat format = new SimpleDateFormat("hh:mm a"); 
			   

			    java.util.Date d1 =(java.util.Date)format.parse(starttime);

			    java.sql.Time  ppstime = new java.sql.Time(d1.getTime());
			    r.setTime(ppstime);


			} catch(Exception e) {

			   System.out.println(e);
			}
	r.setDescription(request.getParameter("crimedescription"));
	
	
	evd.setEvidenceType(request.getParameter("description"));
	evd.setEvidenceType(request.getParameter("evidencetype"));
	
	
	
	Profile p=(Profile)request.getSession(false).getAttribute("Profile");
	
	
}
}
		
	
	



