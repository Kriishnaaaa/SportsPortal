package sportsportal.admin.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("userid");//fetch value from console
		String pass=request.getParameter("userpass");
		System.out.println("id is "+id+"and password is "+pass);
		  
		if(id.equalsIgnoreCase("Harshita")&&pass.equals("admin"))
		{
		HttpSession hs=request.getSession();//a new session has been created
		System.out.println("session id is "+hs.getId());
//setting the value in session scope
		hs.setAttribute("session_adminId", id);
		hs.setAttribute("role", "admin");
			response.sendRedirect("/SportsPortal/admin/admin_home.jsp");
	    }
		else 
		{
			request.setAttribute("msg", "Invalid Credentials");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/login.jsp");
			dispatcher.forward(request, response);
		}
}
}
