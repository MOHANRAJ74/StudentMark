package com.silicon.crud;

import java.sql.SQLException;

public interface ICrud {
	
	public void enrollmark() throws ClassNotFoundException, SQLException; //Declared enrollmark() and implemented in CRUDImplementation Class
	public void viewmark() throws ClassNotFoundException, SQLException; //Declared viewmark() and implemented in CRUDImplementation Class
	public void updatemark() throws ClassNotFoundException, SQLException; //Declared updatemark() and implemented in CRUDImplementation Class
	public void deletemark() throws ClassNotFoundException, SQLException; //Declared deletemark() and implemented in CRUDImplementation Class
}
