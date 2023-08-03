package sportsportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sportsportal.beans.ContactBean;
import sportsportal.beans.EventBean;
import sportsportal.beans.FeedBackBean;
import sportsportal.beans.Plan_Bean;
import sportsportal.dbutils.DBConnection;
import java.util.*;
public class UserDao 
{
	public int addfeedback(FeedBackBean fb)
	{
		int status=0;
		Connection con=DBConnection.openConnection();
		PreparedStatement ps=null;
		try
		{
			String insertQuery="insert into feedback( name, email, rating, status, date,feedback) values(?,?,?,?,?,?)";
			ps=con.prepareStatement(insertQuery);
			ps.setString(1, fb.getName());
			ps.setString(2, fb.getEmail());
			
			ps.setInt(3, fb.getRating());
			ps.setString(4, fb.getStatus());
			ps.setDate(5, fb.getDate());
			ps.setString(6, fb.getFeedback());
			status=ps.executeUpdate();
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return status;
	}
	
	public int addcontactus(ContactBean cb)
	{
		int status=0;
		Connection con=DBConnection.openConnection();
		PreparedStatement ps=null;
		try
		{
			String insertQuery="insert into contact(name, email,question, phone, date) values(?,?,?,?,?)";
			ps=con.prepareStatement(insertQuery);
			ps.setString(1, cb.getName());
			ps.setString(2, cb.getEmail());
			ps.setString(3, cb.getQuestion());
			ps.setString(4, cb.getPhone());
			ps.setDate(5, cb.getDate());
		    
			status=ps.executeUpdate();
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return status;
	}
	
	public  ArrayList<Plan_Bean> viewPlans()//type safe collection (now only array collect the plan bean elements)
	{
		ArrayList<Plan_Bean>planList=new ArrayList<>();
		Connection con=DBConnection.openConnection();
		
		String select_query="select * from plans";
		PreparedStatement ps=null;
		ResultSet rs=null;//it is used to hold the reference of resultant dataset returned by select query
		try {
			ps=con.prepareStatement(select_query);
			rs=ps.executeQuery();//10 row->has the address of that 10 rows
			
			while(rs.next())//it put the cursor on the row and check the data available
			{
				String nm=rs.getString("planName");//read the data from given column
				int ch=rs.getInt("planCharge");
				String ser=rs.getString("planServices");
				Plan_Bean pb=new Plan_Bean(nm,ser,ch);
				planList.add(pb);//adding object of bean class in ArrayList
			}
		}
		catch(SQLException se)
		{
		se.printStackTrace();
		}
		return planList;
		
	}
	
	public ArrayList<EventBean>viewEvents()
	{
		ArrayList<EventBean>eventList=new ArrayList<>();
		Connection con=DBConnection.openConnection();
		String selectQuery="select * from events order by date desc limit 5";//used to select specific dates
		PreparedStatement ps=null;
		ResultSet rs=null;
		try {
			ps=con.prepareStatement(selectQuery);
			rs=ps.executeQuery();
			while(rs.next())
			{
				String name=rs.getString("name");
				String venueName=rs.getString("venue");
				String organizerName=rs.getString("organizer");
				String desc=rs.getString("description");
				String date=rs.getString("date");
				EventBean event=new EventBean(name,venueName,desc,organizerName,date);
				eventList.add(event);
			}
			
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		return eventList;
		
	}
	
	
}
