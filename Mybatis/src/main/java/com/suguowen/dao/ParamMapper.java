package com.suguowen.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.suguowen.model.User;

public interface ParamMapper {
	/*
	 * 一个参数
	 * 多个参数
	 * 一个对象
	 */
	
	//一个参数
	public String getUserByOneParam(@Param("object")Object object);
	
	//多个参数
	public String getUserByMulParam(Map map);
	
	//一个对象
	public String getUserByObject(User u);
			
}
