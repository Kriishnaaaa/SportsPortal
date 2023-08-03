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
 * Servlet implementation class MemberViewProfile
 */
@WebServlet("/MemberViewProfile")
public class MemberViewProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberViewProfile() {
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
		/*
		 * String id=request.getParameter("txtid");
		 * 
		 * String name=request.getParameter("txtname"); String
		 * email=request.getParameter("txtemail"); String
		 * phone=request.getParameter("txtphone"); String
		 * gender=request.getParameter("rdgender"); String
		 * city=request.getParameter("cmbcity"); String
		 * plan=request.getParameter("txtplan"); String
		 * address=request.getParameter("txtaddress");
		 * 
		 * HttpSession hs=request.getSession(false); String
		 * nm=(String)hs.getAttribute("memberSessionKey"); Member m=new Member(id, name,
		 * email, phone, gender, city, plan, address, null); MemberDao dao=new
		 * MemberDao();
		 * 
		 * Member member=dao.viewProfile(m); if(member!=null) {
		 * hs.setAttribute("mem_details", m);
		 * response.sendRedirect("/SportsPortal/member/viewProfile.jsp"); } else {
		 * dao.viewProfile(member); }
		 */
		
	}

}
