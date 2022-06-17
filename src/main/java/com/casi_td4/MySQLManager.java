package com.casi_td4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLManager {
	private Connection conn = null;
	private static MySQLManager instance;

	private MySQLManager() {
		connexion();
	}

	public static synchronized MySQLManager getInstance() {
		if (instance == null) {
			instance = new MySQLManager();
		}
		return instance;
	}

	private void connexion() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/casi_banque?serverTimezone=UTC", "root",
					"p@ssw0rd");
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}

	public ResultSet getData(String req) {
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(req);
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		return rs;
	}

	public int setData(String req) {
		int res = 0;
		Statement stmt = null;
		ResultSet rs;

		try {
			stmt = conn.createStatement();
			res = stmt.executeUpdate(req, Statement.RETURN_GENERATED_KEYS);
			rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				}
				stmt = null;
			}
		}
		return res;
	}
}
