package sportsportal.admin.servlet;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sportsportal.beans.Plan_Bean;
import sportsportal.dao.AdminDao;

/**
 * Servlet implementation class Plan
 */
@WebServlet("/Plan")
public class Plan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Plan() {
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
		String name=request.getParameter("planname");
		String charge=request.getParameter("charge");
		String service=request.getParameter("services");
		//object creation of bean class
		Plan_Bean plan=new Plan_Bean(name, service ,Integer.parseInt(charge));
		
		AdminDao dao=new AdminDao();
		int status=dao.addPlan(plan);
		
		
		if(status>0)
		{
		request.setAttribute("msg", "Plan Added Succesfully");
		RequestDispatcher dispatcher=request.getRequestDispatcher("/admin/plan.jsp");
		dispatcher.forward(request, response);
		}
	}

}
