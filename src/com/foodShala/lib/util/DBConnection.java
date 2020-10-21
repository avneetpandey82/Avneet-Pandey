package com.foodShala.lib.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection connect;
	public DBConnection(){};
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/PD8HsYYemO", "PD8HsYYemO", "B239kLKiHT");
			//connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/foodshala", "root", "root@21");
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connect;
	}

}
