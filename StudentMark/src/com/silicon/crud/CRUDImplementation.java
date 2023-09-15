package com.silicon.crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.silicon.core.JDBCConnection;
import com.silicon.model.Student;

public class CRUDImplementation implements ICrud{
	
	//enrollmark() method is used for Register the Student mark
	public void enrollmark() throws ClassNotFoundException, SQLException{		
		Student st=new Student();//Object created for Student class(Bean class)	
		JDBCConnection jdbc=new JDBCConnection();//Object created for JDBCConnection Class to call and reuse connection method
		String sql="insert into studentmark(rollno, name, tam, eng, maths, sci, social, total, avg) values(?,?,?,?,?,?,?,?,?)";
		Connection con=jdbc.getConnection();// Call Connection method in JDBCConnection class using object
		PreparedStatement ps=con.prepareStatement(sql);		
		//Scanner to Getting input from User
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Enter Rollno: ");
		int rno=sc.nextInt();
		st.setRollno(rno);		
		System.out.println("Enter Name: ");
		String name=sc.next();
		st.setName(name);		
		System.out.println("Tamil: ");
		int tam=sc.nextInt();
		st.setTam(tam);
		System.out.println("English: ");
		int eng=sc.nextInt();
		st.setEng(eng);
		System.out.println("Maths: ");
		int mat=sc.nextInt();
		st.setMaths(mat);
		System.out.println("Science: ");
		int sci=sc.nextInt();
		st.setSci(sci);
		System.out.println("Social: ");
		int soc=sc.nextInt();
		st.setSoc(soc);
		int tot=tam+eng+mat+sci+soc;
		st.setTot(tot);
		int avg=tot/5;
		st.setAvg(avg);
		
		//Store the data in database
		ps.setInt(1, st.getRollno());
		ps.setString(2, st.getName());
		ps.setInt(3, st.getTam());
		ps.setInt(4, st.getEng());
		ps.setInt(5, st.getMaths());
		ps.setInt(6, st.getSci());
		ps.setInt(7, st.getSoc());
		ps.setInt(8, st.getTot());
		ps.setInt(9, st.getAvg());	
		int update=ps.executeUpdate();
		if(update>0) {
			System.out.println("Mark Submitted Succesfully");
		}else {
			System.out.println("Not Success");
		}
	}

	//viewmark() method is used for View the Student mark from database table
	public void viewmark() throws ClassNotFoundException {
		JDBCConnection jdbc=new JDBCConnection();//Object created for JDBCConnection Class to call and reuse connection method
		
		try {
			Connection con=jdbc.getConnection();// Call Connection method in JDBCConnection class using object
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from studentmark");
			System.out.println("View mark");
			while(rs.next()) {
			int rno=rs.getInt(1);
			String name=rs.getString(2);
			int tam=rs.getInt(3);
			int eng=rs.getInt(4);
			int mat=rs.getInt(5);
			int sci=rs.getInt(6);
			int soc=rs.getInt(7);
			int tot=rs.getInt(8);
			int avg=rs.getInt(9);
			
			//Print the data from database
			System.out.println(rno+"|"+name+"|"+tam+"|"+eng+"|"+mat+"|"+sci+"|"+soc+"|"+tot+"|"+avg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	//updatemark() method is used Update the Student mark.
	public void updatemark() throws SQLException {
		System.out.println("Student Mark Updation");
		Student st=new Student();//Object created for Student class(Bean class)	
		JDBCConnection jdbc=new JDBCConnection();//Object created for JDBCConnection Class to call and reuse connection method
		String sql="update studentmark set name=?, tam=?, eng=?, maths=?, sci=?, social=?, total=?, avg=? where rollno=? ";
		Connection con=jdbc.getConnection();// Call Connection method in JDBCConnection class using object
		PreparedStatement ps=con.prepareStatement(sql);
		//Scanner to Getting input from User
		Scanner sc=new Scanner(System.in);		
		System.out.println("Enter Rollno: ");
		int rno=sc.nextInt();
		st.setRollno(rno);
		System.out.println("Enter Name: ");
		String name=sc.next();
		st.setName(name);
		System.out.println("Tamil: ");
		int tam=sc.nextInt();
		st.setTam(tam);
		System.out.println("English: ");
		int eng=sc.nextInt();
		st.setEng(eng);
		System.out.println("Maths: ");
		int mat=sc.nextInt();
		st.setMaths(mat);
		System.out.println("Science: ");
		int sci=sc.nextInt();
		st.setSci(sci);
		System.out.println("Social: ");
		int soc=sc.nextInt();
		st.setSoc(soc);
		int tot=tam+eng+mat+sci+soc;
		st.setTot(tot);
		int avg=tot/5;
		st.setAvg(avg);
		
		//Store the data in database
		ps.setInt(9, st.getRollno());
		ps.setString(1, st.getName());
		ps.setInt(2, st.getTam());
		ps.setInt(3, st.getEng());
		ps.setInt(4, st.getMaths());
		ps.setInt(5, st.getSci());
		ps.setInt(6, st.getSoc());
		ps.setInt(7, st.getTot());
		ps.setInt(8, st.getAvg());	
		int update=ps.executeUpdate();
		if(update>0) {
			System.out.println("Mark Updated Succesfully");
		}else {
			System.out.println("Not Success");
		}
	}
	
	//deletemark() methos is used to Delete mark from database
	public void deletemark() throws SQLException {
		System.out.println("Select Mark to Delete");
		Student st=new Student();//Object created for Student class(Bean class)	
		JDBCConnection jdbc=new JDBCConnection();//Object created for JDBCConnection Class to call and reuse connection method
		String sql="delete from studentmark where rollno=?";
		Connection con=jdbc.getConnection();// Call Connection method in JDBCConnection class using object
		PreparedStatement ps=con.prepareStatement(sql);
		//Scanner to Getting user for which data to be deleted.
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Rollno to Delete: ");
		int rno=sc.nextInt();
		st.setRollno(rno);
		
		ps.setInt(1, st.getRollno());
		int rowdelete=ps.executeUpdate();
		if(rowdelete>0) {
			System.out.println("Mark Deleted");
		}else {
			System.out.println("Can't Deleted");
		}		
	}	
}
