import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.w3c.dom.ls.LSInput;

import com.suguowen.avg.dao.IPersonDao;
import com.suguowen.avg.dao.IPersonMapper;
import com.suguowen.avg.dao.PersonDao;
import com.suguowen.avg.model.Person;
import com.suguowen.avg.service.PersonService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/application.xml")
public class DaotTest {
	@Resource(name="personDao1")
	PersonDao personDao;
	@Resource
	IPersonMapper iPersonMapper;
	@Resource(name="personService")
	PersonService personService;
	
	//spring操作数据库
	@Test
	public void test() {
		personService.selectUser();
	}
	
	//mybatis操作数据库
	@Test
	public void test1() {
		List<Person> listPserson = iPersonMapper.selectUser();
		for (Person person : listPserson) {
			System.out.println("--角色--");
			System.out.println("name:"+person.getName());
			System.out.println("attack:"+person.getAttack());
			System.out.println("defense:"+person.getDefense());
			System.out.println("blood:"+person.getBlood());
		}
	}
	
	//spring缓存测试
	@Test
	public void test2() {
		int a = personService.selectPersonCount();
		System.out.println("第一次查询:"+ a);
		int b = personService.selectPersonCount();
		System.out.println("第二次查询:"+ b);
	}

	//测试mybatis一级缓存、二级缓存
	//mybatis操作数据库
	@Test
	public void test3() {
		int a = personService.selectPersonCountByMapper();
		System.out.println("第一次查询:"+ a);
		int b = personService.selectPersonCountByMapper();
		System.out.println("第二次查询:"+ b);
	}
	
	//测试事务AOP回调
	@Test
	public void test4() {
		int a = personService.insertPerson();
		System.out.println("a"+ a);

	}
	
}
