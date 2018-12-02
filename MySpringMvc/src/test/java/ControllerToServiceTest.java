import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suguowen.springmvc.controller.UserController;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring-mvc.xml")
public class ControllerToServiceTest {
	@Resource(name="userController")
	UserController userController;
	@Test
	public void test() {
		userController.test1();
	}

}
