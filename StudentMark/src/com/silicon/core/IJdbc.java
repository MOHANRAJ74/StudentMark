package com.silicon.core;

import java.sql.Connection;
import java.sql.SQLException;


	/* Here Created Interface for JDBC CONNECTION URL, USERNAME, PASSWORD and Connection
	 *  method it all implemented in JDBCConnection class.*/
public interface IJdbc {
	
	 public static final String URL="jdbc:mysql://localhost:3306/student";
	 public static final String USERNAME="root";
	 public static final String PASSWORD="mohanraj";
	
	 public Connection getConnection();

}


