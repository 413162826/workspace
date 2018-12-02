package com.mashen.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mashen.blog.model.User;
import com.mashen.blog.util.DataSourceUtil;

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
			conn = DataSourceUtil.getConnection();
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
	
	/*
	 * 从数据库读取所有数据
	 * 数据存在User，User存在List返回
	 */
	public  List<User> findAllUser() {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		List<User> ulist = new ArrayList<>();
		try {
			conn = DataSourceUtil.getConnection();//连接数据库
			stat = conn.prepareStatement("select * from user ");//查找用户数据
			rs = stat.executeQuery();//存进缓存
			while (rs.next()) {
//				System.out.println("name:"+rs.getString("username")+"     id:"+rs.getString("id"));
				User user = new User();
				user.setUserName(rs.getString("username"));//用户储存数据库信息
				user.setId(rs.getString("id"));
				ulist.add(user);//表格储存用户
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		for (int i = 0; i < ulist.size(); i++) {
//			System.out.println("name:"+ulist.get(i).getUserName());
//		}
		
		return ulist;//返回用户列表
	}

}
