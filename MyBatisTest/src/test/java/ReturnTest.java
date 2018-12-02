import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.mashen.mybatis.dao.UserMapper2;
import com.mashen.mybatis.model.User;
import com.mashen.mybatis.util.MybatisUtil;

public class ReturnTest {

//	@Test
//	public void test1() {
//		SqlSession sqlSession = MybatisUtil.getConn();
//		UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
//		
//		User user = mapper.selectUserByObjectReturnTest();
//		System.out.println("1"+user.getId());
//		System.out.println("2"+user.getCommend());
//		System.out.println("3"+user.getDescription());
//	}
	
//	//返回Map
//	@Test
//	public void test2() {
//		SqlSession sqlSession = MybatisUtil.getConn();
//		UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
//		
//		Map map = mapper.selectUserByMapReturnTest();
//		String jsonMap = JSON.toJSONString(map);
//		System.out.println("map:"+map);
//		System.out.println("jsonMap"+jsonMap);
//	}
	
//	//动态SQL
//	@Test
//	public void test3() {
//		SqlSession sqlSession = MybatisUtil.getConn();
//		UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
//		
//		Map map = mapper.selectUserByDynamicSQL(1);
//		System.out.println("map:"+map);
//	}
	
//	//动态SQL两个参数
//	@Test
//	public void test3() {
//		SqlSession sqlSession = MybatisUtil.getConn();
//		UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
//		
//		Map map = mapper.selectUserByDynamicSQLTwoParam(0, 1);
//		System.out.println("map:"+map);
//	}
	
//	//动态SQL更新
//	@Test
//	public void test3() {
//		SqlSession sqlSession = MybatisUtil.getConn();
//		UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
//		
//		mapper.updateUserByDynamicSQL("吕布888", null, "gai世无双，一马平川888");
//		sqlSession.commit(true);
//		sqlSession.close();
//	}
	
	//动态SQL更新
	@Test
	public void test4() {
		SqlSession sqlSession = MybatisUtil.getConn();
		UserMapper2 mapper = sqlSession.getMapper(UserMapper2.class);
		
		Set set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		mapper.selectByUserForEach(set);
		sqlSession.close();
	}
}
