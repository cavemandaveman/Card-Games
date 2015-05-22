package com.david.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDB {
	
	public void writeUser(String name, String password, String email) {
		
		Statement stmnt = null;
		try {
			Connection connection = null;
			try {
				Class.forName("org.mariadb.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mariadb://localhost:3306", "root", "root");
			} catch (SQLException e) {
				e.printStackTrace();
				return;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			stmnt = (Statement)connection.createStatement();
			String sql;
			sql = "INSERT into cardgames.USER (name, password, email) values ("+"'"+name+"'"+","+"'"+password+"'"+","+"'"+email+"'"+")";
			stmnt.execute(sql);
			
			stmnt.close();
			connection.close();
		}
		catch(SQLException e) {
			//Handle errors for JDBC
			e.printStackTrace();
		}
	}
}
