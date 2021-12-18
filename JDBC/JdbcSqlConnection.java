package JDBC;

import java.sql.*;

public class JdbcSqlConnection {
	public static void main(String[] args) {
		java.sql.Connection cn=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","3294");
			Statement stmt=cn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT * FROM student");
			
			while(rs.next())
				System.out.println("Roll no:"+rs.getInt(1)+" Name:"+rs.getString(2)+" City:"+rs.getString(3));
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				cn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
