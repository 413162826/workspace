package service;

import java.util.HashMap;
import java.util.Map;

import dao.UserDao;
import model.User;
 

public class UserService {
	
	private UserService() {}
	private static UserService userService = new UserService();
	public static UserService getInstancestance() {
		return userService;
	}
	UserDao dao = UserDao.getInstancestance();
	
	public Map doLogin(String account,String password) {
		Map map = new HashMap<>();
		User u = dao.getUserByName(account);//把账号传到dao获取数据库账号信息
		if (u==null) {
			//账户名错误
			map.put("flag", "-1");
		}else if (u.getPassword().equals(password)) {
			//登陆成功
			map.put("flag", "1");
		}else {
			//登陆失败
			map.put("flag","-2");
		}
		return map;
	}
	
	 public static void add(StringBuffer s) {  
		  
	        s.append("_add");  
	        System.out.println("2."+s.toString());
	  
	    }  
	 public static void main(String[] args) {
		StringBuffer s = new StringBuffer("hello");
		System.out.println("1."+s.toString());
		add(s);
		System.out.println("3."+s.toString());
		
	}
}
