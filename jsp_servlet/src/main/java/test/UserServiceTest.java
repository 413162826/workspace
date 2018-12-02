package test;

import java.sql.Date;
import java.util.List;

import com.suguowen.bean.User;
import com.suguowen.service.UserService;

public class UserServiceTest {
	private UserService userService = new UserService();
	
	//删除测试
	public void testDel(){
		String str = userService.del(1025);
		System.out.println(str);
	}
	
	//新增测试
	public void testAdd(){
		User uu = new User(1025, "测试人物", "2222 - 12 - 22","女","篮球","广东工业大学");
		String str = userService.add(uu);
		System.out.println(str);
	}
	
	//更新测试
	public void testUpdate(){
		User uu = new User(1025, "测试333", "2222 - 12 - 22","女","篮球","广东工业大学");
		String str = userService.update(uu);
		System.out.println(str);
	}
	
	//查询一个
	public void testQueryOne(){
		String result = userService.selectUserById(1025);
		if (result == null) {
			System.out.println("没有此id");
		}else {
			System.out.println(result);
		}
	}
	
	//查询全部测试
	public void testQueryAll(){
		List ulist = userService.selectAllUser();
		if (ulist == null) {
			System.out.println("没有此id");
		}else {
			System.out.println(ulist);
		}
	}
	
	//测试模糊匹配
	public void testPatternQuery(){
		String ulist = userService.selectUserByPattern("", "", "",3);
		System.out.println(ulist);
	}
	
	public static void main(String[] args) {
		UserServiceTest ust = new UserServiceTest();
		ust.testPatternQuery();
	}
}
