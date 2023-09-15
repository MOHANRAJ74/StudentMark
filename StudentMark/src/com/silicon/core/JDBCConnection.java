package com.silicon.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Implemented IJdbc interface
public class JDBCConnection implements IJdbc {
	
	 private Connection con;
	 private String url="jdbc:mysql://localhost:3306/student";
	 private String user="root";
	 private String password="mohanraj";
	 
	 	//Override the Connection from IJdbc interface
	    public Connection getConnection() {
	    
	        try {
	        	con = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return con;// Connection return
	    }
}
	
