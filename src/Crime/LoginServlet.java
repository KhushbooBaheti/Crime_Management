package Crime;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			Profile p=new Profile();
			HttpSession session=request.getSession();
			
			PreparedStatement ps=con.prepareStatement("select * from Profile p where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				p.setId(rs.getInt("id"));
				p.setAge(rs.getInt("age"));
				p.setCategory(category);
				p.setContact(rs.getString("contactno"));
				p.setEmail(rs.getString("email"));
				p.setGender(rs.getString("gender"));
				
				PreparedStatement psa=con.prepareStatement("select * from Address where addid = ?");
				
				psa.setInt(1, id);
				ResultSet rsa=psa.executeQuery();
				Address a=new Address();
				while(rsa.next()){
					a.setAddressId(rsa.getInt("addid"));
					a.setCity(rsa.getString("city"));
					a.setplot(rsa.getString("plotno"));
					a.setLandmark(rsa.getString("landmark"));
					a.setState(rsa.getString("state"));
					
				}
				rsa.close();
				p.setA(a);
				p.setName(rs.getString("name"));
			}
			rs.close();
			session.setAttribute("Profile",p);
			
			//RequestDispatcher rd;
			if(category.equals("Victim")){
				/* rd=request.getRequestDispatcher("Victim.jsp");
				rd.forward(request, response);*/
				response.sendRedirect("Victim.jsp");
			}
			else if(category.equals("Police")){
				/*rd=request.getRequestDispatcher("Police.jsp");
				rd.forward(request, response);*/
				response.sendRedirect("Victim.jsp");
				
				}
			else if(category.equals("Commissioner")){
				/*rd=request.getRequestDispatcher("Commissioner.jsp");
				rd.forward(request, response);*/
				response.sendRedirect("Victim.jsp");
				}
			
		}
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)  
            throws ServletException, IOException {  
        doPost(req, resp);  
    }  
}  



