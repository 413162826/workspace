package com.suguowen.blog.reflect;

public class TestReflect {
	static private String name = "default name";
	private String password;
	
	public TestReflect() {
		
	}
	
	private TestReflect(String name) {
		this.name = name;
	}
	
	
	private void printMyName(String name) {
		System.out.println("我的名字:"+name);
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
}
