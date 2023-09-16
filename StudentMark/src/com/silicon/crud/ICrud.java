package com.silicon.crud;

import java.sql.SQLException;

/*Created Interface and declared method for CRUD operation*/
public interface ICrud {
	
	public void enrollmark() throws SQLException; 
	public void viewmark() throws SQLException;
	public void updatemark() throws SQLException; 
	public void deletemark() throws SQLException;
}
