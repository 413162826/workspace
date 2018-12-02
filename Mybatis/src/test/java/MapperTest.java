import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.suguowen.dao.Mapper;
import com.suguowen.servlet.GetSQLSessionFactory;

public class MapperTest {
	SqlSession sqlSession = GetSQLSessionFactory.getSession();

	@Test
	public void test1() {	
		Mapper mapper = sqlSession.getMapper(Mapper.class);
		

		
		String a = mapper.select();
		System.out.println("a"+a);
	}
	
//	@Test
//	public void test2() {	
//		Mapper mapper = sqlSession.getMapper(Mapper.class);
//		
//		String[] str = {"a","b","c","d"};
//		
//		String a = mapper.updateUserByArrays(str);
//		System.out.println("a"+a);
//	}

}
