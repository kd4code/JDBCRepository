package JDBC;

import java.sql.*;

public class jdbcInsertDemo {
  public static void main(String[] args)throws SQLException,ClassNotFoundException {
	Connection cn=null;
	Class.forName("com.mysql.cj.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","3294");
	Statement st=cn.createStatement();
	//String s="DELETE FROM student WHERE Name=Karna";
    st.executeUpdate("INSERT INTO student VALUES('80','Karna','Chennai')");
	System.out.println("Database is updated please Check");
	cn.close();
	
}
} 
