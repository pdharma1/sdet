package com.fnmae.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetMySQLConnection {

	public Connection getMySQlConnection() {
		Connection connection = null;
		try {
			String url = "jdbc:mysql://Deema-XPS-PC:3306/test";
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(url, "macuser", "macuser");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
