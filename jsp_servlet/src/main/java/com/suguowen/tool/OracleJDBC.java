package com.suguowen.tool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.suguowen.bean.User;

public class OracleJDBC {

	// 设置数据库基本配置信息
	private static String URL = "jdbc:oracle:thin:@syjmw-db1.hnisi.com.cn:1521:orcl"; // 链接字符串
	private static String USER = "dev2_framework_test"; // 数据库的用户名
	private static String PASSWORD = "11111111"; // 数据库的密码

	static {
		try {
			// 加载驱动类
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @description 获取Connection
	 */
	public static Connection getConn() {
		// 获取连接对象
		Connection con = null;
		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	/**
	 * 
	 * @description 关闭资源
	 */
	public static void close(Connection conn,PreparedStatement ps, ResultSet rs){    
        if(rs!= null){    
                 try{    
                          rs.close();    
                 }catch (SQLException e) {    
                          e.printStackTrace();    
                 }    
        }    
        if(ps!= null){    
                 try{    
                          ps.close();    
                 }catch (SQLException e) {    
                          e.printStackTrace();    
                 }    
        }    
        if(conn!= null){    
                 try{    
                          conn.close();    
                 }catch (SQLException e) {    
                          e.printStackTrace();    
                 }    
        }    
}

}
