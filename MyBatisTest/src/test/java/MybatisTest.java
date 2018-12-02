import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mashen.mybatis.dao.UserMapper;
import com.mashen.mybatis.util.MybatisUtil;

public class MybatisTest {
/*
 * 功能：JUnit测试
 * 技巧：类名调用方法
 */
	
	
	//select
	@Test
	public void test1() {
		SqlSession session = MybatisUtil.getConn();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		int a = userMapper.select();
		session.commit();
		session.close();
		
		System.out.println("session:"+session);
		System.out.println("a:"+a);
	}
	
//	//insert
//	@Test
//	public void test2() {
//		SqlSession session = MybatisUtil.getConn();
//		UserMapper userMapper = session.getMapper(UserMapper.class);
//		
//		int a = userMapper.insert();
//		session.commit();
//		session.close();
//		System.out.println("a:"+a);
//	}
	
	//update
	@Test
	public void test3() {
		SqlSession session = MybatisUtil.getConn();
		UserMapper userMapper = session.getMapper(UserMapper.class);
		
		int a = userMapper.delect();
		session.commit();
		session.close();
		System.out.println("a:"+a);
	}
}
