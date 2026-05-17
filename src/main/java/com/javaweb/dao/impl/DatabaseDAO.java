package com.javaweb.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseDAO {
	
	public static Connection getConnection(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Đã load JDBC driver.");
			String url = "jdbc:mysql://127.0.0.1:3306/dacs2";			
			String user = "root";
			String pass = "";
			return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException e) {
	        e.printStackTrace(); 
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }
		 return null; 
	}
}
