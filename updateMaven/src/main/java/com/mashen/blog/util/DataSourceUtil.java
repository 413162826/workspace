package com.mashen.blog.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

//专门提供数据连接的一个工具类：数据源
public class DataSourceUtil {

    private static String driver;
    private static String jdbcUrl;
    private static String userName;
    private static String password;
	
    
    //存储connection集合--c3p0额外增加
    //初始化属性--c3p0额外增加
    
    static {
    	Properties pro = new Properties();
    	try {
			pro.load(DataSourceUtil.class.getResourceAsStream("/dataSource.properties"));
			driver = pro.getProperty("driverClass");
			jdbcUrl = pro.getProperty("jdbcUrl");
			userName = pro.getProperty("user");
			password = pro.getProperty("password");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbcUrl,userName,password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void closeResource(ResultSet rs,Statement stat,Connection con) {
		try {
			if(rs!=null) {
				rs.close();
			}
			stat.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
