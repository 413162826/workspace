import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.suguowen.dao.DynamicSQLMapper;
import com.suguowen.servlet.GetSQLSessionFactory;

public class DynamicTest {
	
	SqlSession sqlSession = GetSQLSessionFactory.getSession();
	DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);

//	//动态SQL
//	@Test
//	public void test3() {
//		
//		Map map = mapper.selectUserByDynamicSQL(1);
//		System.out.println("map:"+map);
//	}
	
//	//动态SQL两个参数
//	@Test
//	public void test3() {
//		
//		Map map = mapper.selectUserByDynamicSQLTwoParam(0, 1);
//		System.out.println("map:"+map);
//	}
	
//	//动态SQL更新
//	@Test
//	public void test3() {
//		
//		mapper.updateUserByDynamicSQL("吕布888", null, "gai世无双，一马平川888");
//		sqlSession.commit(true);
//		sqlSession.close();
//	}
	
	//动态SQL更新
	@Test
	public void test4() {
		Set set = new HashSet<>();
		set.add(1);
		set.add(2);
		set.add(3);
		mapper.selectByUserForEach(set);
		sqlSession.close();
	}

}
