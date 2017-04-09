package Crime;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Statement;

import javax.servlet.RequestDispatcher;  
import javax.servlet.ServletException;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
/**
 * Servlet implementation class SignUpServlet
 */
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Profile p=new Profile();
		Address add=new Address();
		
		p.setName(request.getParameter("name"));
		p.setGender(request.getParameter("gender"));
		p.setCategory(request.getParameter("category"));
		p.setAge(Integer.parseInt(request.getParameter("age")));
		p.setEmail(request.getParameter("email"));
		add.setCity(request.getParameter("city"));
		add.setLandmark(request.getParameter("landmark"));
		add.setplot(request.getParameter("plot"));
		add.setState(request.getParameter("state"));
		p.setContact(request.getParameter("contactno"));
		
		
		
		p.setA(add);
		
		
		
		
		
		
		SignUpService reg=new SignUpService();
		int stat=reg.Register(p,add);
		if(stat==1)
		{
		RequestDispatcher rd=request.getRequestDispatcher("Success.jsp");
		rd.forward(request, response);
		
	}
		else
		{
				RequestDispatcher rd=request.getRequestDispatcher("SignIn.jsp");
			rd.forward(request, response);
				
				
		}
	}
	
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
	            throws ServletException, IOException {  
	        doPost(req, resp);  
	    }  
	}  

