import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.suguowen.MyAop;
import com.suguowen.aop.HelloAop;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/applicationContext.xml")
public class AopTest {

	@Resource
	MyAop myAop;

	@Test
	public void test() {
		myAop.hello();
	}

}
