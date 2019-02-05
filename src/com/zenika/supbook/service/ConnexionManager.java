package com.zenika.supbook.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnexionManager {
	private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>();
	
	private ConnexionManager() {
	}
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getCurrentConnection() {
		try {
			if (connectionHolder.get() == null || connectionHolder.get().isClosed()) {
				connectionHolder.set(openConnection());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connectionHolder.get();
	}
	
	private static Connection openConnection() {
		try {
			Connection connection = DriverManager
					.getConnection("jdbc:mysql://localhost:8889/supbook", "root", "root");
			connection.setAutoCommit(false);
			return connection;
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
	}
	
	public static void closeProperly(PreparedStatement ps, Connection cx) {
		try {
			if (ps != null) {
				ps.close();
			}
			cx.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
