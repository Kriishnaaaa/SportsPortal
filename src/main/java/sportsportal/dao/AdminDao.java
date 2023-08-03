package sportsportal.dao;

import sportsportal.beans.ContactBean;
import sportsportal.beans.EventBean;
import sportsportal.beans.FeedBackBean;
import sportsportal.beans.Plan_Bean;
import sportsportal.dbutils.DBConnection;

import java.sql.*;
import java.util.ArrayList;

public class AdminDao {
	public int addPlan(Plan_Bean p) {
		int status = 0;
		Connection con = DBConnection.openConnection();// connection established
		PreparedStatement ps = null;// it will communicate with the database tables
		try {
			String insertQuery = "insert into plans(planName, planCharge, planServices) values(?,?,?)";// place holder
			ps = con.prepareStatement(insertQuery);// prepareStatement complied the query and reference is being
													// assigned to ps
			ps.setString(1, p.getName());
			ps.setInt(2, p.getCharge());
			ps.setString(3, p.getService());
			System.out.println(ps);
			status = ps.executeUpdate();// to execute the query
		}

		catch (SQLException se) {
			System.out.println(se);
		}
		finally {
			if(ps!=null)
			{
				try {
					ps.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				DBConnection.closeConnection();
			}
			
		}
		
		
		return status;
	}

	public int addEvent(EventBean e) {
		int status = 0;
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		try {
			String insertQuery = "insert into events (name, venue, organizer, description, date)value(?,?,?,?,?)";
			ps = con.prepareStatement(insertQuery);// prepareStatement passes the query to RDBMS and RDBMS compiler
													// compiles the query
			ps.setString(1, e.getEventName());
			ps.setString(2, e.getVenue());
			ps.setString(3, e.getOrganizer());
			ps.setString(4, e.getDescription());
			ps.setString(5, e.getDate());
			System.out.println(ps);
			status = ps.executeUpdate();
		} catch (SQLException se) {
			System.out.println(se);
		}
		return status;
	}

	public ArrayList<FeedBackBean> viewfeedback()// type safe collection (now only array collect the plan bean elements)
	{
		ArrayList<FeedBackBean> feedbackList = new ArrayList<>();
		Connection con = DBConnection.openConnection();

		String select_query = "select * from feedback";
		PreparedStatement ps = null;
		ResultSet rs = null;// it is used to hold the reference of resultant dataset returned by select
							// query
		try {
			ps = con.prepareStatement(select_query);
			rs = ps.executeQuery();// 10 row->has the address of that 10 rows

			while (rs.next())// it put the cursor on the row and check the data available
			{
				int rating = rs.getInt("rating");
				String name = rs.getString("Name");// read the data from given column
				String email = rs.getString("email");

				String feedback = rs.getString("feedback");
				Date date = rs.getDate("date");
				FeedBackBean fb = new FeedBackBean(rating, name, email, feedback, date);
				fb.setId(rs.getInt("id"));
				feedbackList.add(fb);// adding object of bean class in ArrayList
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return feedbackList;

	}

	public ArrayList<ContactBean> viewcontact()// type safe collection (now only array collect the plan bean elements)
	{
		ArrayList<ContactBean> contactList = new ArrayList<>();
		Connection con = DBConnection.openConnection();

		String select_query = "select * from contact";
		PreparedStatement ps = null;
		ResultSet rs = null;// it is used to hold the reference of resultant dataset returned by select
							// query
		try {
			ps = con.prepareStatement(select_query);
			rs = ps.executeQuery();// 10 row->has the address of that 10 rows

			while (rs.next())// it put the cursor on the row and check the data available
			{

				String name = rs.getString("Name");// read the data from given column
				String email = rs.getString("email");
				String question = rs.getString("question");
				String phone = rs.getString("phone");
				Date date = rs.getDate("date");
				ContactBean cb = new ContactBean(name, email, question, phone, date);
				contactList.add(cb);// adding object of bean class in ArrayList
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}
		return contactList;

	}

	public int deleteFeedBack(String[] idArray) {
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		String deleteQuery = "delete from feedback where id=?";
		 int flag=0;
		try {
			ps = con.prepareStatement(deleteQuery);

			/*
			 * for(int i=0;i<idArray.length;i++) { int id=Integer.parseInt(idArray[i]);
			 * ps.setInt(1, id); ps.executeUpdate(); }
			 * 
			 */
			// batch processing
			 for(int i=0;i<idArray.length;i++)
			 { 
				 int id=Integer.parseInt(idArray[i]);
			     ps.setInt(1, id); 
			     ps.addBatch(); 
			 }
			 
			 int[]arr=ps.executeBatch();//sending the whole batch to RDBMS or execution
			
			 for(int i=0;i<arr.length;i++)
			 {
				 if(arr[i]>0) {
					 flag=1;
				 }
					 
				 else {
					 flag=0;
				 break;
				 }
			 }

		} catch (SQLException se) {

			se.printStackTrace();
			try {
				con.rollback();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
		return flag;
	}
}
