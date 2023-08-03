package sportsportal.member.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.Member;
import sportsportal.dao.MemberDao;

/**
 * Servlet implementation class MemberLogin
 */
@WebServlet("/MemberLogin")
public class MemberLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberLogin() {
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
		String id=request.getParameter("userid").trim();
		String pass=request.getParameter("userpass");
		String value=request.getParameter("chkcookie");
		
		MemberDao dao=new MemberDao();
		Member member=dao.login(id,pass);
		
		 String userinfo=id+"#"+pass;
		
		if(member!=null) 
		{
			if(value!=null)
			 {

					Cookie c=new Cookie("userdetails",userinfo);
					c.setMaxAge(60*60*2);//seconds 
					
					response.addCookie(c);//it will send the cookie on client machine
			 }
			
			HttpSession hs=request.getSession();//it will create new session
			hs.setAttribute("memberSessionKey",id);
			hs.setAttribute("mem_details", member);
			
			response.sendRedirect("/SportsPortal/member/member_home.jsp");
			
		}
		
		
		else {
			request.setAttribute("msg", "Invalid Credentials");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/member/userlogin.jsp");
			dispatcher.forward(request, response);
		}
		
		System.out.println(id+pass);
		
		
	}

}
