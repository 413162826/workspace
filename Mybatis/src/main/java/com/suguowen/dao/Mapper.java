package com.suguowen.dao;

public interface Mapper {
	public String select();
	
	//使用数组更新数据
	public String updateUserByArrays(String[] str); 
}
