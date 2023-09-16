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
	/*Here CRUDImplementation class is created and implemented method from ICrud interface.
	 *  Created Globally used objected*/
	Student stu=new Student();
	JDBCConnection jdbc=new JDBCConnection();
	Connection con=jdbc.getConnection();
	Scanner sc=new Scanner(System.in);
	
	/* enrollmark() for insert data in database using Bean class and Scanner */
	public void enrollmark() throws SQLException{			
		String sql="insert into studentmark(rollno, name, tam, eng, maths, sci, social, total, avg) values(?,?,?,?,?,?,?,?,?)";		
		PreparedStatement ps=con.prepareStatement(sql);			
		System.out.println("Enter Rollno: ");
		int rno=sc.nextInt();
		stu.setRollno(rno);		
		System.out.println("Enter Name: ");
		String name=sc.next();
		stu.setName(name);		
		System.out.println("Tamil: ");
		int tam=sc.nextInt();
		stu.setTam(tam);
		System.out.println("English: ");
		int eng=sc.nextInt();
		stu.setEng(eng);
		System.out.println("Maths: ");
		int mat=sc.nextInt();
		stu.setMaths(mat);
		System.out.println("Science: ");
		int sci=sc.nextInt();
		stu.setSci(sci);
		System.out.println("Social: ");
		int soc=sc.nextInt();
		stu.setSoc(soc);
		int tot=tam+eng+mat+sci+soc;
		stu.setTot(tot);
		System.out.println("Total: "+tot);
		int avg=tot/5;
		System.out.println("Average: "+avg);
		stu.setAvg(avg);
		
		ps.setInt(1,stu.getRollno());
		ps.setString(2, stu.getName());
		ps.setInt(3, stu.getTam());
		ps.setInt(4, stu.getEng());
		ps.setInt(5, stu.getMaths());
		ps.setInt(6, stu.getSci());
		ps.setInt(7, stu.getSoc());
		ps.setInt(8, stu.getTot());
		ps.setInt(9, stu.getAvg());	
		int update=ps.executeUpdate();
		
		if(update>0) {
			viewmark();
		}else {
			System.out.println("Not Success");
		}
		con.close();
	}
	/* viewmark() for view select data from database using beanclass*/
	public void viewmark()  {	
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from studentmark");
			
			while(rs.next()) {
			stu.setRollno(rs.getInt(1));
			stu.setName(rs.getString(2));
			stu.setTam(rs.getInt(3));
			stu.setEng(rs.getInt(4));
			stu.setMaths(rs.getInt(5));
			stu.setSci(rs.getInt(6));
			stu.setSoc(rs.getInt(7));
			stu.setTot(rs.getInt(8));
			stu.setAvg(rs.getInt(9));
			
			int rno=stu.getRollno();
			String name=stu.getName();
			int tam=stu.getTam();
			int eng=stu.getEng();
			int mat=stu.getMaths();
			int sci=stu.getSci();
			int soc=stu.getSoc();
			int tot=stu.getTot();
			int avg=stu.getAvg();
				
			System.out.println(rno+"|"+name+"|"+tam+"|"+eng+"|"+mat+"|"+sci+"|"+soc+"|"+tot+"|"+avg);
			}
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	/* updatemark() for update data in database using Beanclass and Scanner*/
	public void updatemark() throws SQLException {
		String sql="update studentmark set name=?, tam=?, eng=?, maths=?, sci=?, social=?, total=?, avg=? where rollno=? ";
		PreparedStatement ps=con.prepareStatement(sql);
		
		System.out.println("Enter Rollno to Update: ");
		int rno=sc.nextInt();
		stu.setRollno(rno);
		System.out.println("Enter Name: ");
		String name=sc.next();
		stu.setName(name);
		System.out.println("Tamil: ");
		int tam=sc.nextInt();
		stu.setTam(tam);
		System.out.println("English: ");
		int eng=sc.nextInt();
		stu.setEng(eng);
		System.out.println("Maths: ");
		int mat=sc.nextInt();
		stu.setMaths(mat);
		System.out.println("Science: ");
		int sci=sc.nextInt();
		stu.setSci(sci);
		System.out.println("Social: ");
		int soc=sc.nextInt();
		stu.setSoc(soc);
		int tot=tam+eng+mat+sci+soc;
		stu.setTot(tot);
		System.out.println("Total: "+tot);
		int avg=tot/5;
		System.out.println("Average: "+avg);
		stu.setAvg(avg);
		
		
		ps.setInt(9, stu.getRollno());
		ps.setString(1, stu.getName());
		ps.setInt(2, stu.getTam());
		ps.setInt(3, stu.getEng());
		ps.setInt(4, stu.getMaths());
		ps.setInt(5, stu.getSci());
		ps.setInt(6, stu.getSoc());
		ps.setInt(7, stu.getTot());
		ps.setInt(8, stu.getAvg());	
		int update=ps.executeUpdate();		
		if(update>0) {
			viewmark();
		}else {
			System.out.println("Not Success");
		}
		con.close();
	}
	
	/* deletemark() for delete data in database using Beanclass and Scanner*/
	public void deletemark() throws SQLException {
		viewmark();
		String sql="delete from studentmark where rollno=?";
		PreparedStatement ps=con.prepareStatement(sql);
		System.out.println("Enter Rollno to Delete: ");
		int rno=sc.nextInt();
		stu.setRollno(rno);
		
		ps.setInt(1, stu.getRollno());
		int rowdelete=ps.executeUpdate();
		if(rowdelete>0) {
			viewmark();
		}else {
			System.out.println("Can't Deleted");
		}	
		con.close();
	}	
}
