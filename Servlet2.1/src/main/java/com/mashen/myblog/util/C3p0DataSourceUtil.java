package com.mashen.myblog.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.Statement;

//专门提供数据连接的一个工具类：数据源
public class C3p0DataSourceUtil {
	
	private static ComboPooledDataSource c3p0 = new ComboPooledDataSource();
	
	private static String driver;
	private static String jdbcUrl;
	private static String userName;
	private static String password;
	
	//存储connection集合
	//初始化实行
	
	static {
		Properties properties =new Properties();
		try {
			properties.load(C3p0DataSourceUtil.class.getResourceAsStream("/dataSource.properties"));
			driver = properties.getProperty("driverClass");
			jdbcUrl = properties.getProperty("jdbcUrl");
			userName = properties.getProperty("user");
			password = properties.getProperty("password");
			
			//加了一个集合
			c3p0.setUser(userName);
			c3p0.setDriverClass(driver);
			c3p0.setJdbcUrl(jdbcUrl);
			c3p0.setPassword(password);
			//初始化我这个池的对象数量，为打仗提前准备
			c3p0.setInitialPoolSize(Integer.valueOf(properties.getProperty("initialPoolSize")));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		Connection conn = null;
		try {
			conn =c3p0.getConnection();
			
//			Class.forName(driver);
//			conn = DriverManager.getConnection(jdbcUrl,userName,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void closeResourse(ResultSet rs,Statement stat,Connection conn) {
		try {
			if (rs!=null) {
				rs.close();
			} 
		stat.close();
		conn.close();//回到池里面，同时标注为空闲对象
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		C3p0DataSourceUtil.getConnection();
	}
}
