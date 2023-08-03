
package sportsportal.user.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sportsportal.beans.ContactBean;
import sportsportal.dao.UserDao;

/**
 * Servlet implementation class ContactUs
 */
@WebServlet("/ContactUs")
public class ContactUs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactUs() {
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
		String 	phone=request.getParameter("txtphone");
		String question=request.getParameter("txtquestion");
		
		System.out.println("name is "+name+" and email is "+email+" and phone number is "+phone+" and question is "+question);
		
		java.util.Date d=new java.util.Date();
		long dt=d.getTime();
		java.sql.Date sqlDate=new java.sql.Date(dt);
		
		ContactBean cb=new ContactBean(name, email, question,phone,sqlDate);
		
		UserDao dao=new UserDao();
		int status=dao.addcontactus(cb);
		
		if(status>0)
		{
		request.setAttribute("msg", "Thank You For Contacting Us ");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/jsp/contactus.jsp");
		dispatcher.forward(request, response);
		}
	}

}
