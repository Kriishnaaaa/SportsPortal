package sportsportal.dbutils;
import java.sql.*;
import java.util.ResourceBundle;
public class DBConnection 
{
private static Connection con;
private static ResourceBundle rb;
	
public static Connection openConnection() {	
	
	try {
		rb=ResourceBundle.getBundle("sportsportal/dbutils/dbinfo");
		String url=rb.getString("db.url");
		/* System.out.println(url); */
		String id=rb.getString("db.userid");
		String pass=rb.getString("db.userpass");
		
		Class.forName("com.mysql.cj.jdbc.Driver");//forName method is known as factory method
		con=DriverManager.getConnection(url,id,pass);//it is connection string
		
		//con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sportsdb","root","root");
	}
	catch(SQLException|ClassNotFoundException se) {
		
		System.out.println(se);
		
		
	}
	return con;
}


public static void closeConnection()
{
	if(con!=null)
	{
		try {
			con.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	

}

/*
 * public static void main(String[] args) { Connection
 * c=DBConnection.openConnection(); System.out.println(c); }
 */
}
	

