package com.vastpro.jdbc.conutil;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionUtility {
	private ConnectionUtility() {

	}

	private static ThreadLocal<Connection> tlocal = new ThreadLocal<Connection>();
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	synchronized public static Connection getConnection() throws Exception {
		Connection con = tlocal.get();
		if (con == null) {
			String url = "jdbc:mysql://localhost:3306/vastpro";
			String username = "root";
			String password = "root";
			con = DriverManager.getConnection(url, username, password);
			tlocal.set(con);
			return con;
		} else {
			return con;
		}
	}

	synchronized public static void closeConnection() {
		Connection con = tlocal.get();
		if (con == null) {
			System.out.println("no connection available for closing...");
		} else {
			try {
				con.close();
				tlocal.remove();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
