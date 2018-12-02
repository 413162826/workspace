import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.suguowen.dao.ParamMapper;
import com.suguowen.model.User;
import com.suguowen.servlet.GetSQLSessionFactory;

public class ParamTest {
/*
 * 1.传一个参数
 * 2.传多个参数(x<5)
 * 3.传一个对象所有属性为参数(x>=5)
 */
	
	SqlSession sqlSession = GetSQLSessionFactory.getSession();
	ParamMapper mapper = sqlSession.getMapper(ParamMapper.class);
//	//一个参数
//	@Test
//	public void test() {
//		String a = mapper.getUserByOneParam(1);
//		System.out.println(a);
//	}
	
//	//多个参数
//	@Test
//	public void test1() {
//		Map map = new HashMap<>();
//		map.put("id", 5);
//		map.put("commend", "1001");
//		
//		String a = mapper.getUserByMulParam(map);
//		System.out.println(a);
//	}
	
//	//对象
//	@Test
//	public void test2() {
//		User u = new User();
//		u.setId(6);
//		u.setCommend("1001");
//		String a = mapper.getUserByObject(u);
//		System.out.println(a);
//	}
	
	
}
