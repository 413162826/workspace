import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.suguowen.dao.MulTableMapper;
import com.suguowen.model.School;
import com.suguowen.model.Student;
import com.suguowen.servlet.GetSQLSessionFactory;

public class MulTableTest {
	/*
	 * 1.一对一
	 * 2.一对多
	 * 3.多对多
	 */
	
	SqlSession sqlSession = GetSQLSessionFactory.getSession();
	MulTableMapper mapper = sqlSession.getMapper(MulTableMapper.class);
	
//	//oneToOne
//	@Test
//	public void test() {
//		Student student = mapper.selectMessageByOneToOne();
//		System.out.println("1."+student.getId());
//		System.out.println("2."+student.getName());
//		System.out.println("3."+student.getSchool());
//		
//		System.out.println("4."+student.getMySchool().getName());
//		System.out.println("5."+student.getMySchool().getAddress());
//	}
	
	//oneToMore
	@Test
	public void test1() {
		System.out.println("test1表演");
		List<School> schoolList = mapper.selectMessageByOneToMore();
		System.out.println("schoolList长度:"+schoolList.size());//长度为1
		for (School school : schoolList) {
			List<Student> studentList = school.getStudentList();
			System.out.println("studentList长度:"+studentList.size());
			for (Student student : studentList) {
				System.out.println("1."+student.getId());
				System.out.println("2."+student.getName());
				System.out.println("3."+student.getSchool());
				
				System.out.println("4."+student.getMySchool().getName());
				System.out.println("5."+student.getMySchool().getAddress());
			}
		}
		
//		System.out.println(school.getName());
//		System.out.println(school.getAddress());
//		System.out.println(school.getStudent().getId());
//		System.out.println(school.getStudent().getSchool());
		
	}
	
//	//moreToOne
//	@Test
//	public void test2() {
//		System.out.println("test2表演");
//		List<Student> listStudent = mapper.selectMessageByMoreToOne();
//		System.out.println("studentList长度:"+listStudent.size());
//		for (Student student : listStudent) {
//			System.out.println(student.getId());
//			System.out.println(student.getName());
//			System.out.println(student.getSchool());
//			System.out.println(student.getMySchool().getName());
//			System.out.println(student.getMySchool().getAddress());
//		}
//		
//	}
	
	

}
