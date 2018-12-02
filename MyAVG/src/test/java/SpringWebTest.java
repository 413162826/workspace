import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

public class SpringWebTest {

	String suffix = "hello";
	@Test
	public void test1() {
		String suffixParm = "wu";
		this.suffix = (suffixParm != null ? suffix : "1111");
		System.out.println(suffix);
	}
}
