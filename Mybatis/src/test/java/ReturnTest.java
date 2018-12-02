import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.suguowen.dao.ReturnMapper;
import com.suguowen.model.User;
import com.suguowen.servlet.GetSQLSessionFactory;

public class ReturnTest {
//	1、基本类型  ：resultType=基本类型
//			2、List类型：   resultType=List中元素的类型
//			3、Map类型    单条记录：resultType =map
//			                          多条记录：resultType =Map中value的类型
	SqlSession sqlSession = GetSQLSessionFactory.getSession();
	ReturnMapper mapper = sqlSession.getMapper(ReturnMapper.class);
//	//一个记录
//	@Test
//	public void test() {
//		String a = mapper.selectUserSingleReturn();
//		System.out.println(a);
//	}
//	//一列记录
//	@Test
//	public void test1() {
//		List list = mapper.selectUserMulReturn();
//		System.out.println(list);
//		for (Object object : list) {
//			System.out.println(object);
//		}
//	}
//	//一行记录
//	@Test
//	public void test2() {
//		User user = mapper.selectUserMulReturn1();
//		System.out.println(user);
//		System.out.println(user.getId());
//		System.out.println(user.getCommend());
//		System.out.println(user.getDescription());
//		System.out.println(user.getContent());
//	}
	

}
