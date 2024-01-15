package com.sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
  static String URL = "jdbc:mysql://localhost:3306/JDBC";
  static String USERNAME = "root";
 static String PASSWORD = "Savita@123";
 public static Connection getConnection() throws SQLException {
	    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
}