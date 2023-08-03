package sportsportal.admin.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sportsportal.beans.EventBean;
import sportsportal.dao.AdminDao;

/**
 * Servlet implementation class Event
 */
@WebServlet("/Event")
public class Event extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event() {
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
		String name=request.getParameter("eventname");
		String venue=request.getParameter("venue");
		String date=request.getParameter("date");
		String on=request.getParameter("oname");
		String desc=request.getParameter("desc");
		//object creation of bean class
		EventBean event=new EventBean( name ,venue, desc, on, date);
		AdminDao dao=new AdminDao();
		int status=dao.addEvent(event);
		
		if(status>0)
		{
		request.setAttribute("event","Event added Succesfully");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/event.jsp");
		dispatcher.forward(request, response);
		}
		
	    
	}

}
