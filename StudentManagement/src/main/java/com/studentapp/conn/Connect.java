package com.studentapp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
   public static Connection getConn() {
	   String url="jdbc:mysql://localhost:3306/studentapp";
	   String user="root";
	   String pass = "tiger";
	   Connection con=null;
	   
	   try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		 con=DriverManager.getConnection(url, user, pass);
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	   
	   return con;
   }
}
