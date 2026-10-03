package com.studentapp.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
   public static Connection getConn() {
	   String url="db_url";
	   String user="db_user";
	   String pass = "db_pw";
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
