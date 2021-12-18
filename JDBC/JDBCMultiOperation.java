package JDBC;

import java.sql.*;
import java.util.Scanner;

public class JDBCMultiOperation {
  public static void main(String[] args) {
	   int n;
	   Scanner sc=new Scanner(System.in);
	   try(Connection cn=doConnect())
	   {System.out.println("Please Selection the Option to perform \n 1.Add\n 2.Update\n 3.Read \n 4.Delete");
		n=sc.nextInt();
		if(n==1)
		     add(cn);
		else if(n==2)
			 update(cn);
		else if(n==3)
			read(cn);
		else if(n==4)
			delete(cn);
		else
			System.out.println("Invalid Option");
	   }catch(ClassNotFoundException | SQLException e)
	   {
		 e.printStackTrace();  
	   } 
    }
  public static Connection doConnect()throws SQLException,ClassNotFoundException
  { 
	  Class.forName("com.mysql.cj.jdbc.Driver");
	  Connection cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","3294");
	  return cn; 	
  }
  public static void add(Connection cn)throws SQLException
    {
	  if(cn!=null)
	  {
		String s="INSERT INTO student VALUES('85','ABC','Kolkata')" ; 
	    Statement st=cn.createStatement();
	    st.executeUpdate(s);
	    System.out.println("New Data added Successfully..");
	  }
	  else
		  System.out.println("Connection Failed..");
    }
 
  public static void update(Connection cn)throws SQLException
    {
	  if(cn!=null)
	  {
		String s="UPDATE student SET Name='Parth' WHERE Name='Arjun'" ; 
	    Statement st=cn.createStatement();
	    st.executeUpdate(s);
	    System.out.println("Data Updated Successfully..");
	  }
	  else
		  System.out.println("Connection Failed..");
    }
  
  public static void read(Connection cn)throws SQLException
    {
	  if(cn!=null)
	  {
	    Statement st=cn.createStatement();
	    ResultSet rs=st.executeQuery("SELECT * FROM student WHERE Roll='80'");
	    System.out.println("Required Data :");
	    rs.next();
	    System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3)); 
	  }
	  else
		  System.out.println("Connection Failed..");
    }
  
  public static void delete(Connection cn)throws SQLException
    {
	  if(cn!=null)
	  {
		String s="DELETE FROM student WHERE roll=30" ; 
	    Statement st=cn.createStatement();
	    st.executeUpdate(s);
	    System.out.println("Data Deleted Successfully..");
	  }
	  else
		  System.out.println("Connection Failed..");
    }
}
