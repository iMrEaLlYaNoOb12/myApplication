package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class ServiceDao {
	
	String sqlSaveUser = "INSERT INTO customer (UserName, Password, Flag) VALUES (?,?,?)";
	
	String sqlGetUser = "SELECT * FROM customer WHERE UserName = ? AND Password = ?";

	
	public boolean saveUser(HttpServletRequest request, String uname, String upass, int flag) {
		try {
			
			ServletContext application=request.getServletContext();
			Connection conn = (Connection) application.getAttribute("conn");
	        PreparedStatement ps = conn.prepareStatement(sqlSaveUser);
	        ps.setString(1, uname);
	        ps.setString(2, upass);
	        ps.setInt(3, 0);
	        int row = ps.executeUpdate();
	        System.out.println(row);
	        if (row != 0) {
	        	return true;
	        }   
	        
		} catch (SQLException e) {
		    System.out.println("SQL Exception during register for username: " + uname);		
		}
		
		return false;
	}
	
	
	public String getUser(HttpServletRequest request, String uname, String upass) {
		
		ServletContext application=request.getServletContext();
		
		Connection conn = (Connection) application.getAttribute("conn");
	    PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sqlGetUser);
			 ps.setString(1, uname);
			 ps.setString(2, upass);
			 
			 ResultSet rs = ps.executeQuery();
			 
			 while (rs.next()) {
				 	String username = rs.getString("UserName");
		            String userpass = rs.getString("Password");
		            int flag = rs.getInt("Flag");

		            if (flag == 0) {
		            	saveUser(request, uname, upass, flag);
		            	//save the same user with updated flag to 1.
		            	return "login.success";
		            } else {
		            	return "login.alreadyloggedin";
		            }
		        }
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "login.register";
	}
	
	
	
	
	
	
}
