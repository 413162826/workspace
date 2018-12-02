package com.suguowen.dao;

import java.util.List;

import com.suguowen.model.User;

public interface ReturnMapper {
	/*
	 * 1.返回一个信息 
	 * 2.返回一行信息
	 * 3.返回多行信息
	 */
	
	//一个数据
	public String selectUserSingleReturn();
	
	//一列数据
	public List selectUserMulReturn();
	
	//一行数据 
	public User selectUserMulReturn1();
	
	//多行数据
	public List<User> selectUserMulReturn2();
}
