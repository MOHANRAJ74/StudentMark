package com.silicon.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*Created Connection class and implemented variable and methods which 
 * is declared in IJdbc Interface.Connected with Database using JDBC and return connection*/
public class JDBCConnection implements IJdbc {
	
		Connection con;
	
	    public Connection getConnection() {    
	        try {
	        	con = DriverManager.getConnection(IJdbc.URL,IJdbc.USERNAME, IJdbc.PASSWORD);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return con;
	    }
	}

