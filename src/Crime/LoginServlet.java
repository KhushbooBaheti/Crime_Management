package Crime;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
       
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		int id=Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		
		MysqlCon my=new MysqlCon();
		Connection con=my.getCon();
		
		
		Admin admin= new Admin();
		String category=admin.findCategory(id, password);
		
		boolean authenticate=admin.authenticate(id, password);
		if(authenticate){
			
			PreparedStatement ps=con.prepareStatement("select * from Profile where id=id");
			if(category.equals("Police")){
				RequestDispatcher rd=request.getRequestDispatcher("Police.jsp");
				rd.forward(request, response);
			}
			if(category.equals("Victim")){
				RequestDispatcher rd=request.getRequestDispatcher("Victim.jsp");
				rd.forward(request, response);
				}
			if(category.equals("Commissioner")){
				RequestDispatcher rd=request.getRequestDispatcher("Commissioner.jsp");
				rd.forward(request, response);
				}
		}
		else{
			RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}  



