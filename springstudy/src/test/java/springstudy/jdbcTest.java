package springstudy;

import java.util.List;

import javax.swing.Spring;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.mashen.spring.model.Account;
import com.mashen.spring.util.SpringUtil;

public class jdbcTest {
	JdbcTemplate jdbcTemplate = (JdbcTemplate) SpringUtil.getBean("jdbcTemplate");

//	@Test
//	public void selectUserInfo() {
//		System.out.println("输出结果为："+jdbcTemplate);
//		String sql = "select * from account";
//		List<Account> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Account.class));
//		for (Account account : list) {
//			System.out.println("id:"+account.getId());
//			System.out.println("name:"+account.getName());
//			System.out.println("course"+account.getCourse());
//	}
//	}
	
	//增删改都可以哟经update
	@Test
	public void upodateAccount() {
		String sql = "update account set course='英语' where id = 1003";
		int line = jdbcTemplate.update(sql);
		SpringUtil.closeContext();
		System.out.println("已关闭");
		System.out.println(line);
	}
	
	
}
