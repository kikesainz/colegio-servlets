package com.kike.colegio.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBUtils {
	public static Connection DBConnection() {
		
		Context ctx = null;
		Connection con = null;
		
		try {
			/*Class.forName("com.mysql.cj.jdbc.Driver");
			String dbURL = "jdbc:mysql://localhost:3306/colegio";
			String username = "root";
			String password = "root";
			connection = DriverManager.getConnection(dbURL, username, password);*/
			
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/ColegioDB");
			
			con = ds.getConnection();
			
		} catch (SQLException | NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
}
