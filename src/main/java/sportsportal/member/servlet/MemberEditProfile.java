package sportsportal.member.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.Member;
import sportsportal.dao.MemberDao;

/**
 * Servlet implementation class MemberEditProfile
 */
@WebServlet("/MemberEditProfile")
public class MemberEditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberEditProfile() {
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
		String city=request.getParameter("city");
		String phoneNumber=request.getParameter("phone");
		String emailId=request.getParameter("email");
		String address=request.getParameter("address");
		
		HttpSession hs=request.getSession(false);
		String id=(String)hs.getAttribute("memberSessionKey");
		Member m=new Member(id, emailId, phoneNumber, city, address);
		MemberDao dao=new MemberDao();
		
		Member member=dao.editProfile(m);
		if(member!=null)
		{
			hs.setAttribute("mem_details", m); 
			response.sendRedirect("/SportsPortal/member/member_editprofile.jsp");
		}
	}

}
