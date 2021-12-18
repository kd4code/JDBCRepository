package JDBC;

import java.awt.List;
import java.sql.*;
import java.util.*;

public class ObjectConnection {
  public static void main(String[] args) {
	try (Connection c=doConnect()){
	    Student s1=new Student(80,"Karna","Chennai");
	   // addStudent(s1,c);
	    ArrayList al=getStudent(c);
	    System.out.println("Fetched Students "+al);
		
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 
 public static Connection doConnect()throws SQLException,ClassNotFoundException
 {
	 Connection c=null;
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 c=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","3294");
	 return c;
	 
 }
 
 public static void addStudent(Student s1,Connection c)throws SQLException
 {
	String q="INSERT INTO student VALUES(?,?,?)";
	PreparedStatement pst=c.prepareStatement(q);
	pst.setInt(1,s1.getRoll());
	pst.setString(2,s1.getName());
	pst.setString(3,s1.getCity());
    pst.executeUpdate();
    System.out.println("New Student Data is Added");
    
 }
 public static ArrayList getStudent(Connection c ) throws SQLException
 {
	    Statement st=c.createStatement();
	    ResultSet rs= st.executeQuery("SELECT * FROM student WHERE City='Pune'");
	    ArrayList al=new ArrayList();
	    while(rs.next())
	    {Student s=new Student(rs.getInt(1),rs.getString(2),rs.getString(3));
	      al.add(s);
	    }
	    return al;
	    
 }
}

