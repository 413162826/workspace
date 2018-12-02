import static org.junit.Assert.fail;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mashen.mybatis.dao.UserMapper;
import com.mashen.mybatis.util.MybatisUtil;

public class CacheTest {
	
//	@Test
//	public void test() {
//		SqlSession session = MybatisUtil.getConn();
//		UserMapper userMapper = session.getMapper(UserMapper.class);	
//
//		System.out.println("第一次查询"+a);
//		int b = userMapper.select();
//		System.out.println("第二次查询"+b);
//		session.close();
//	}

	/*
	 * 注释掉二重缓存照样执行一次
	 */
//	@Test
//	public void test2() {
//		SqlSession session1 = MybatisUtil.getConn();
//		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
//		SqlSession session2 = MybatisUtil.getConn();
//		UserMapper userMapper2 = session2.getMapper(UserMapper.class);	
//		System.out.println("session1"+session1);
//		System.out.println("session2"+session2);
//		
//		int a = userMapper1.select();
//		session1.close();
//		System.out.println("第一次查询"+a);
//		int b = userMapper2.select();
//		session2.close();
//		System.out.println("第二次查询"+b);
//		
//	}
	/*
	 * 一个session查询后关闭，再查询
	 * 结果：报错，为什么呢，不是说factory才是二级缓存的对象吗，只关闭了session应该还可以拿到值
	 */
	@Test
	public void test2() {
		SqlSession session1 = MybatisUtil.getConn();
		UserMapper userMapper1 = session1.getMapper(UserMapper.class);
		
		SqlSession session2 = MybatisUtil.getConn();
		UserMapper userMapper2 = session2.getMapper(UserMapper.class);

		System.out.println("session1"+session1);		
		int a = userMapper1.select();
//		session1.close();//如果你不close的话，session2照样不会使用缓存而查询，必须close才能使用二级缓存
		System.out.println("第一次查询"+a);
		int b = userMapper2.select();
		session2.close();
		System.out.println("第二次查询"+b);
	}
}
