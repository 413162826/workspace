import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.mashen.mybatis.dao.UserMapper;
import com.mashen.mybatis.util.MybatisUtil;

public class ParamTest {
	SqlSession session = MybatisUtil.getConn();
	UserMapper userMapper =session.getMapper(UserMapper.class);
	
	//一个参数
	@Test
	public void test() {
		String a = userMapper.selectUserById(1);
		System.out.println("a:"+a);
	}
	
	//两个参数
//	@Test
//	public void test2() {
//		int id = 1;
//		String commend = "张飞";
//		
//		String a = userMapper.selectUserDoubleParam(id, commend);
//		System.out.println("a:"+a);
//	}

	//对象
//	@Test
//	public void test3() {
//		User user = new User();
//		user.setId(1);
//		user.setCommend("张飞");
//		
//		String a = userMapper.selectUserByObject(user);
//		System.out.println("a:"+a);
//	}
	
	//对象
//	@Test
//	public void test4() {
//		Map map = new HashMap();
//		map.put("1", 2);
//		map.put("key2", "赵云");
//		
//		String a = userMapper.selectUserByMap(map);
//		System.out.println("a:"+a);
//	}
	
	//list
//	@Test
//	public void test4() {
//		List lists = new ArrayList();
//		lists.add(1);
//		lists.add(2);
//		lists.add(3);
//		lists.add(4);
//		lists.add(5);
//		
//		List a = userMapper.selectUserByList(lists);
//		for (Object object : a) {
//			System.out.println(object);
//		}
//		System.out.println("a:"+a.size());
//	}
}
