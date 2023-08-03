package sportsportal.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sportsportal.beans.FeedBackBean;
import sportsportal.dao.AdminDao;
import sportsportal.dao.UserDao;

/**
 * Servlet implementation class FeedBack
 */
@WebServlet("/FeedBack")
public class FeedBack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FeedBack() {
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
		String name=request.getParameter("txtname");
		String email=request.getParameter("txtemail");
		String rating=request.getParameter("cmbrating");
		
		String agree=request.getParameter("chkagree");
		String feedback=request.getParameter("txtfeedback");
		System.out.println("name is "+name+" and email is "+email+" and rating is "+rating+" and feedback is "+feedback);
		
		
		java.util.Date d=new java.util.Date();
		long dt=d.getTime();//converts todays's date into long value
		java.sql.Date sqlDate=new java.sql.Date(dt);
		
		FeedBackBean fb=new FeedBackBean(Integer.parseInt(rating),name,email,feedback,sqlDate);
		fb.setStatus(agree);
		
		UserDao dao=new UserDao();
		int status=dao.addfeedback(fb);
		
		if(status>0)
		{
		
			request.setAttribute("msg", "Thank You For Your FeedBack ");
			RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/feedback.jsp");
			dispatcher.forward(request, response);
		}	
		

		
		
	}

}
