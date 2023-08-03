package sportsportal.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sportsportal.beans.Member;
import sportsportal.dao.MemberDao;

/**
 * Servlet implementation class MemberRegistration
 */
@WebServlet("/MemberRegistration")
public class MemberRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberRegistration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("txtid");
		String pass=request.getParameter("txtpass");
		String name=request.getParameter("txtname");
		String email=request.getParameter("txtemail");
		String phone=request.getParameter("txtphone");
		String gender=request.getParameter("rdgender");
		String city=request.getParameter("cmbcity");
		String plan=request.getParameter("txtplan");
		String address=request.getParameter("txtaddress");
	    
		java.util.Date d=new java.util.Date();
		long dt=d.getTime();
		java.sql.Date sqlDate=new java.sql.Date(dt);
		
		Member m=new Member(id,pass,name,email,phone,gender,city,plan,address, sqlDate);
		
		MemberDao dao=new MemberDao();
		int status=dao.addmemberregistration(m);
		
		if(status>0)
		{
			request.setAttribute("msg", "Thank You For Your Registration ");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/member/member-registration.jsp");
			dispatcher.forward(request, response);
		}
	}

}
