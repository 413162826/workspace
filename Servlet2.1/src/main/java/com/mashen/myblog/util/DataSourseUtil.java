package com.mashen.myblog.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Statement;

//专门提供数据连接的一个工具类：数据源
public class DataSourseUtil {
	private static String driver;
	private static String jdbcUrl;
	private static String userName;
	private static String password;

	static {
		Properties properties = new Properties();
		try {
			properties.load(DataSourseUtil.class.getResourceAsStream("/dataSource.properties"));
			driver = properties.getProperty("driverClass");
			jdbcUrl = properties.getProperty("jdbcUrl");
			userName = properties.getProperty("user");
			password = properties.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(jdbcUrl, userName, password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	public static void closeResourse(ResultSet rs, Statement stat, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			stat.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		DataSourseUtil.getConnection();
	}
	}



