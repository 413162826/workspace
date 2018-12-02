package com.suguowen.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.suguowen.bean.User;
import com.suguowen.tool.OracleJDBC;

public class UserDao {

	/**
	 * 
	 * @description 增加一条数据
	 */
	public boolean addOne(User uu) {
		boolean f = false;

		// 2.定义sql语句
		String sql = "insert into Gwen_User values(?,?,to_date(?,'yyyy-mm-dd'),?,?,?)";
		// 1.获取数据库连接对象
		// 3.获取preparedStatement对象，以发送sql语句到数据库
		try {
			Connection conn = OracleJDBC.getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			// 通过ps对象给sql语句设置参数？
			ps.setInt(1, uu.getId());
			ps.setString(2, uu.getName());
			ps.setString(3, uu.getBirth());
			ps.setString(4, uu.getSex());
			ps.setString(5, uu.getHobby());
			ps.setString(6, uu.getSchool());
			// 4.执行sql语句
			int row = ps.executeUpdate();
			if (row != 0) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	/**
	 * 
	 * @description 根据id删除一条数据
	 */
	public boolean delById(int id) {
		boolean f = false;
		String sql = "delete from Gwen_User where u_id=?";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int row = ps.executeUpdate();
			if (row > 0) {
				f = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return f;
	}

	/**
	 * 
	 * @description 根据id修改一条数据
	 */
	public boolean updateById(User uu) {
		boolean b = false;
		String s = "update gwen_user set u_name=?,u_birth=to_date(?,'yyyy-mm-dd'),sex=?,hobby = ?,school = ? where u_id=? ";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(s);
			ps.setString(1, uu.getName());
			ps.setString(2, uu.getBirth());
			ps.setString(3, uu.getSex());
			ps.setString(4, uu.getHobby());
			ps.setString(5, uu.getSchool());
			ps.setInt(6, uu.getId());
			int row = ps.executeUpdate();
			if (row > 0) {
				b = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return b;
	}

	/**
	 * 
	 * @description 根据id查询一条数据，返回一个User对象
	 */
	public User queryById(int id) {
		User uu = null;
		ResultSet rs = null;
		String sql = "select * from gwen_user where u_id=? order by u_id asc";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			// 执行
			rs = ps.executeQuery();
			// 结果集光标向下移动一行，如果查询到数据，返回true，否则返回false
			boolean b = rs.next();
			if (b) {
				// 查询到了数据,取出数据
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);
				// 将数据封装成对象
				uu = new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return uu;
	}

	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	public ArrayList<User> queryAll(int page) {
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where 1 = 1 and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);

				list.add(new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * id模糊匹配
	 * 
	 * @return
	 */
	public List<User> queryByPattern_Id(String pattern_id,int page) {
		List<User> list = new ArrayList<User>();

		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_id like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + pattern_id + "%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);

				list.add(new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * name模糊匹配
	 * 
	 * @return
	 */
	public List<User> queryByPattern_name(String pattern_name,int page) {
		List<User> list = new ArrayList<User>();

		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_name like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5 order by u_id asc";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + pattern_name + "%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);

				list.add(new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * school模糊匹配
	 * 
	 * @return
	 */
	public List<User> queryByPattern_school(String pattern_school,int page) {
		List<User> list = new ArrayList<User>();

		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where school like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + pattern_school + "%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);

				list.add(new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * id + name模糊匹配
	 * 
	 * @return
	 */
	public List<User> queryByPattern_id_name(String pattern_id,String pattern_name,int page) {
		List<User> list = new ArrayList<User>();
		

		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_id like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5 INTERSECT select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_name like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5 order by u_id asc";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_id+"%");
			ps.setString(2, "%"+pattern_name+"%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);
				
				list.add(new User(u_id, u_name, u_birth.toString(),sex,hobby,school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * id + school模糊匹配
	 * 
	 * @return
	 */
	public List<User> queryByPattern_id_school(String pattern_id,
			String pattern_school,int page) {
		List<User> list = new ArrayList<User>();
		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_id like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5 INTERSECT select t2.* from (select t1.*,rownum as rn from gwen_user t1 where school like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + pattern_id + "%");
			ps.setString(2, "%" + pattern_school + "%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);

				list.add(new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * name + school模糊匹配
	 * 
	 * @return
	 */
	public List<User> queryByPattern_name_school(String pattern_name,
			String pattern_school,int page) {
		List<User> list = new ArrayList<User>();

		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_name like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5 INTERSECT select t2.* from (select t1.*,rownum as rn from gwen_user t1 where school like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + pattern_name + "%");
			ps.setString(2, "%" + pattern_school + "%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);

				list.add(new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * id +name +school模糊匹配
	 * 
	 * @return
	 */
	public List<User> queryByPattern_id_name_school(String pattern_id,
			String pattern_name, String pattern_school,int page) {
		List<User> list = new ArrayList<User>();

		String sql = "select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_id like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5 INTERSECT select t2.* from (select t1.*,rownum as rn from gwen_user t1 where school like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5  INTERSECT select t2.* from (select t1.*,rownum as rn from gwen_user t1 where u_name like ? and rownum <= "+page+" * 5 ) t2 where t2.rn > ("+page+" - 1) * 5";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%" + pattern_id + "%");
			ps.setString(2, "%" + pattern_name + "%");
			ps.setString(3, "%" + pattern_school + "%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				// 取出当前行数据，封装成一个Emp对象，放入list集合
				int u_id = rs.getInt(1);
				String u_name = rs.getString(2);
				Date u_birth = rs.getDate(3);
				String sex = rs.getString(4);
				String hobby = rs.getString(5);
				String school = rs.getString(6);

				list.add(new User(u_id, u_name, u_birth.toString(), sex, hobby,
						school));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	//========================查询记录数方法汇总============================
	
	/**
	 * 查询全部数据
	 * 
	 * @return
	 */
	public int queryAllCount() {
		int count = 0;
		String sql = "select count(*) from gwen_user";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * id模糊匹配
	 * 
	 * @return
	 */
	public int queryByPattern_Id_Count(String pattern_id) {
		int count = 0;
		String sql = "select count(*) from gwen_user where  u_id like ?";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_id+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * name模糊匹配
	 * 
	 * @return
	 */
	public int queryByPattern_name_Count(String pattern_name) {
		int count = 0;
		String sql = "select count(*) from gwen_user where  u_name like ?";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_name+"%");
			ResultSet rs = ps.executeQuery();
			// 只要rs光标所在当前行有数据，rs.next()就返回true
			while (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * school模糊匹配
	 * 
	 * @return
	 */
	public int queryByPattern_school_Count(String pattern_school) {
		int count = 0;
		String sql = "select count(*) from gwen_user where  school like ?";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_school+"%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * id + name模糊匹配
	 * 
	 * @return
	 */
	public int queryByPattern_id_name_Count(String pattern_id,String pattern_name) {
		int count = 0;
		String sql = "select count(*) from (select * from gwen_user where  u_id like ?  INTERSECT  select * from gwen_user where  u_name like ?)";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_id+"%");
			ps.setString(2, "%"+pattern_name+"%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * id + school模糊匹配
	 * 
	 * @return
	 */
	public int queryByPattern_id_school_Count(String pattern_id,String pattern_school) {
		int count = 0;
		String sql = "select count(*) from (select * from gwen_user where  u_id like ?  INTERSECT  select * from gwen_user where  school like ? )";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_id+"%");
			ps.setString(2, "%"+pattern_school+"%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * name + school模糊匹配
	 * 
	 * @return
	 */
	public int queryByPattern_name_school_Count(String pattern_name,String pattern_school) {
		int count = 0;
		String sql = "select count(*) from (select * from gwen_user where  u_name like ?  INTERSECT  select * from gwen_user where  school like ?  order by u_id asc)";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_name+"%");
			ps.setString(2, "%"+pattern_school+"%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/**
	 * id +name +school模糊匹配
	 * 
	 * @return
	 */
	public int queryByPattern_id_name_school_Count(String pattern_id,String pattern_name,String pattern_school) {
		int count = 0;
		String sql = "select count(*) from (select * from gwen_user where  u_id like ?  INTERSECT select * from gwen_user where  u_name like ?  INTERSECT  select * from gwen_user where  school like ?)";
		try {
			Connection con = OracleJDBC.getConn();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, "%"+pattern_id+"%");
			ps.setString(2, "%"+pattern_name+"%");
			ps.setString(3, "%"+pattern_school+"%");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	

	public static void main(String[] args) {
		UserDao ud = new UserDao();
		User uu = new User();
		uu.setId(1003);
		uu.setName("貂蝉");
		uu.setBirth("2018 - 09 - 09");
		// 1.增加测试
		/*
		 * ud.addOne(uu);
		 */
		// 2.删除测试
		/* ud.delById(1111); */
		// 3.修改测试
		/* ud.updateById(uu); */
		// 4.查询单条数据测试
		/*
		 * User uu_1001 = ud.queryById(1001);
		 * System.out.println(uu_1001.getId()+
		 * ","+uu_1001.getName()+","+uu_1001.getBirth());
		 */
		// 5.查询全表测试
		//List<User> allUser = ud.queryAll();
		/*for (User user : allUser) {
			System.out.println(user.getId() + "," + user.getName() + ","
					+ user.getBirth());
		}*/

	}

	/*	*//**
	 * 调用无返回值的存储过程
	 * 
	 * @throws Exception
	 */
	/*
	 * public void callPro110() throws Exception { Connection conn =
	 * DBConnection.getConn(); CallableStatement cs =
	 * conn.prepareCall("{call pro110}"); // 执行 cs.execute(); }
	 */
}