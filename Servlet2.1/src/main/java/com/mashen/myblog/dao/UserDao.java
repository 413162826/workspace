package com.mashen.myblog.dao;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mashen.myblog.model.User;
import com.mashen.myblog.util.C3p0DataSourceUtil;
import com.mashen.myblog.util.C3p0DataSourceUtil2;

public class UserDao {
	
	private UserDao() {}
	private static UserDao dao = new UserDao();
	public static UserDao getInstance() {
		return dao;
	}
	
//	public static void main(String[] args) {
//		UserDao user= new UserDao();
//		User u = user.getUserByName("admin");
//		System.out.println(u.getPassword());
//	}
	
	//专门提供数据连接的一个工具类：数据源
	//jdbc 增 删 改 查 一个工具类
	
	public User getUserByName(String userName) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		User u = null;
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myblog", "root", "root");
			conn = C3p0DataSourceUtil2.getConnection();
			String sql = "select * from tb_user where user_name = ?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, userName);
			rs = stat.executeQuery();

			if (rs.next()) {
				u = new User();
				u.setUserName(rs.getString("user_name"));
				u.setPassword(rs.getString("password"));
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stat.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		return u;
	}
}
