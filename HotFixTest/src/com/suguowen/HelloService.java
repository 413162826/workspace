package com.suguowen;

public class HelloService {
	private static String value = init();
	static {
		System.out.println(System.currentTimeMillis());
	}
	public static String init() {
		return "default - 30";
	}
	public String getValue() {
		return HelloService.value;
	}
	public void setValue(String value) {
		System.out.println("设置成功:"+value);
		HelloService.value = value;
	}
	
}
