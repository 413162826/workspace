package com.suguowen.dao;

import java.util.List;

import com.suguowen.model.School;
import com.suguowen.model.Student;

public interface MulTableMapper {
	/*
	 * 1.一对一
	 * 2.一对多
	 * 3.多对多
	 */
	
	//一对一
	public Student selectMessageByOneToOne();
	//一对多
	public List<School> selectMessageByOneToMore();
	//多对一
	public List<Student> selectMessageByMoreToOne();
	
	
	//多对多
	public void selectMessageByMoreToMore();
}
