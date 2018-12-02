package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;


public class UserDao {
	//单例模式
	private UserDao(){}
	private static UserDao userDao = new UserDao();
	public static UserDao getInstancestance() {
		return userDao;
	}
	
	public User getUserByName(String account) {
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null;
		User u = null;
		// 加载驱动
		try {
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/myblog", "root", "root");
			// sql语句
			String sql = "select * from tb_user where user_name=?";
			stat = conn.prepareStatement(sql);
			stat.setString(1, account);
			// 存入ResultSet
			rs = stat.executeQuery();
			if (rs.next()) {
				// 匹配数据库成功取出用户信息
				u = new User();
				// rs获取变量值
				u.setAccount(rs.getString("user_name"));
				u.setPassword(rs.getString("password"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}if (stat!=null) {
					stat.close();
				}if (conn!=null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return u;
	}
	
/*	public static void main(String[] args) {
		UserDao ud = new UserDao();
		User u = ud.getUserByName("admin");
		System.out.println(u.getAccount()+""+u.getPassword());
	}*/
}
