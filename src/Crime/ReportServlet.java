package Crime;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.http.Part;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;
import java.sql.*;

/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int status=0,statusa=0;
		//String message=null;
			Report r=new Report();
			Evidence evd=new Evidence();
		//HttpSession session=request.getSession();
			
				
				r.setCrimeType(request.getParameter("crimetype"));
				r.setLocality(request.getParameter("crimelocation"));
				r.setDate(request.getParameter("crimedate"));
				r.setTime(request.getParameter("crimetime"));
				r.setDescription(request.getParameter("crimedescription"));
				r.setStatus("registered");
				
				evd.setDescription(request.getParameter("description"));
				evd.setEvidenceType(request.getParameter("evidencetype"));

				Profile p=(Profile)request.getSession(false).getAttribute("Profile");
				//session.setAttribute("Profile",p);
				System.out.println(p.getName());
		
				
				
				
				ReportService reg=new ReportService();
				int stat= reg.addReport(r, evd, p);
				if(stat==1)
				{	
					response.sendRedirect("Victim.jsp");
			
				
			}
				else
				{
					response.sendRedirect("Report.jsp");
						
						
				}
			}
		
		 
			
			
			
			
				
			
    	// request.getRequestDispatcher("Victim.jsp").forward(request,response);
				//	response.sendRedirect("Victim.jsp");
				
		 
    }
		 
		 

    
	
		// request.setAttribute("Message", message);
			// if(status>0)
			 //{
				//response.sendRedirect("Victim.jsp");
			// }
			// else
			// {
				 //response.sendRedirect("Police.jsp");
	    
			
			
//SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
//java.util.Date date = sdf1.parse(startDate);
//java.sql.Date sqlCdate = (java.sql.Date) new Date(date.getTime());
	 //String bufDt =  startDate;  //data from form
  /*DateFormat dF = new SimpleDateFormat("dd-MM-yyyy"); //data in form is in this format
  Date bbdt = (Date)dF.parse(bufDt);  // string data is converted into java util date
  DateFormat dsF = new SimpleDateFormat("yyyy-MM-dd"); //converted date is reformatted for conversion to sql.date
  String ndt = dsF.format(bbdt); // java util date is converted to compatible java sql date
  java.sql.Date sqlDate=  java.sql.Date.valueOf(ndt);  // finally data from the form is convered to java sql. date for placing in database
  r.setDate(sqlDate);




	    SimpleDateFormat format = new SimpleDateFormat("hh:mm"); 
	   

	    java.util.Date d1 =(java.util.Date)format.parse(starttime);

	    java.sql.Time  ppstime = new java.sql.Time(d1.getTime());
	    r.setTime(ppstime);
*/
		 
		 
		 
		//InputStream inputStream = null; input stream of the upload file
		    
		    /* obtains the upload file part in this multipart request
		    Part filePart = request.getPart("photo");
		    if (filePart != null) {
		        // prints out some information for debugging
		        System.out.println(filePart.getName());
		        System.out.println(filePart.getSize());
		        System.out.println(filePart.getContentType());
		         
		        // obtains input stream of the upload file
		        inputStream = filePart.getInputStream();
	
	
	
	
				//if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	              //  psa.setBlob(5, inputStream);
	                //psa.setBlob(6, inputStream);
	                
	           // }
	            
	            
	             int row = psa.executeUpdate();
	            //if (row > 0 ) {
	              //  message = "File uploaded and saved into database";
	            
	            
	            */
	
	



		
	
	



