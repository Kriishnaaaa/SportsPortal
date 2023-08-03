package sportsportal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import sportsportal.beans.Member;
import sportsportal.dbutils.DBConnection;

public class MemberDao 
{
	public int addmemberregistration(Member m)
	{
		int status =0;
		Connection con=DBConnection.openConnection();
		PreparedStatement ps=null;
		try 
		{ 
			String insertQuery="insert into member(member_id, password, name, email, phone, gender, city, plan_name, address, date) values(?,?,?,?,?,?,?,?,?,?)";
			ps=con.prepareStatement(insertQuery);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getName());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getPhone());
			ps.setString(6, m.getGender());
			ps.setString(7, m.getCity());
			ps.setString(8, m.getPlan_name());
			ps.setString(9, m.getAddress());
			ps.setDate(10, m.getDate());
			
			status=ps.executeUpdate();
			
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return status;
	}

	public Member login(String id, String pass) 
	{
		Connection con=DBConnection.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Member m=null;
		String strsql="select * from member where member_id=? and password=?";
		try {
			ps=con.prepareStatement(strsql);
			ps.setString(1, id);
			ps.setString(2, pass);
			System.out.println(ps);//this is only for testing 
			rs=ps.executeQuery();
			if(rs.next()==true) 
			{  /* member_id, password, name, email, phone, gender, city, plan_name, address, date*/
				
				 m=new Member();
				String name=rs.getString("name");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String city=rs.getString("city");
				String planname=rs.getString("plan_name");
				String address=rs.getString("address");
				m.setAddress(address);//we can do this with constructor and it reduce the number of line
				m.setCity(city);
				m.setEmail(email);
				
				m.setPhone(phone);
				m.setName(name);
				m.setPlan_name(planname);
				
				
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
		return m;//returning member class object
	}

	public Member editProfile(Member m) 
	{ /* member_id, password, name, email, phone, gender, city, plan_name, address, date*/
		Connection con=DBConnection.openConnection();
		PreparedStatement ps=null;
		int status=0;
		Member m1=null;
		String updateQuery="update member set email=?,phone=?,city=?,address=? where member_id=?";
		try {
			ps=con.prepareStatement(updateQuery);
			ps.setString(1, m.getEmail());
			ps.setString(2, m.getPhone());
			ps.setString(3, m.getCity());
			ps.setString(4, m.getAddress());
			ps.setString(5, m.getId());
			System.out.println(ps);
			status=ps.executeUpdate();
			
			if(status>0)
			{
				String strsql="select * from member where member_id=?";
				PreparedStatement ps1=null;
				ResultSet rs=null;
				ps1=con.prepareStatement(strsql);
				ps1.setString(1, m.getId());
				rs=ps1.executeQuery();
				rs.next();
				String id=rs.getString("member_id");
				String name=rs.getString("name");
				String email=rs.getString("email");
				String phone=rs.getString("phone");
				String city=rs.getString("city");
				String planname=rs.getString("plan_name");
				String address=rs.getString("address");
				String password=rs.getString("password");
				String gender=rs.getString("gender");
				 m1=new Member(id, password, planname, email, phone, gender, city, name, address, null);
				
			}
		}
		catch(SQLException se) {
			se.printStackTrace();
		
			
			
		}
		return m1;
	}

	public Member viewProfile(String id)
	{
		Connection con = DBConnection.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String strsql = "select * from member where member_id=?";
		Member m1 = null;
		
		try
		{
			ps = con.prepareStatement(strsql);
			ps.setString(1 , id);
			System.out.println(ps);
			rs = ps.executeQuery();
			rs.next();
			String memid = rs.getString("member_id");
			String name= rs.getString("name");     
			String email = rs.getString("email");
			String phone = rs.getString("phone");
			String city = rs.getString("city");
			String planName = rs.getString("plan_name");
			String address = rs.getString("address");
			String password = rs.getString("password");
			String gender = rs.getString("gender");
			
			m1 = new Member(memid , password , name , email , phone , gender , city , planName , address , null);
		}
		
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		
		return m1;		
	}

}
