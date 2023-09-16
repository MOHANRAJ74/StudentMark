package com.silicon.ui;

import java.sql.SQLException;
import java.util.Scanner;
import com.silicon.crud.CRUDImplementation;

/*This Class is Main class and UI for the Project
 * Here we used Scanner method for UI */
public class MainStudentApplication {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		CRUDImplementation ob=new CRUDImplementation();		
		Scanner sc=new Scanner(System.in);
		System.out.println("1. Enroll Student Mark");
		System.out.println("2. View Student Mark");
		System.out.println("3. Update Student Mark");
		System.out.println("4. Delete Student Mark");
		
		int select=sc.nextInt();
		switch (select) {
		case 1: 
			ob.enrollmark();
			break;
		case 2: 
			ob.viewmark();
			break;
		case 3: 
			ob.updatemark();
			break;
		case 4: 
			ob.deletemark();
			break;
			
		default:
			System.out.println("Invalid Selection");
			break;
		}		
	}
}
