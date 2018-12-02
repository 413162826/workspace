package com.suguowen.avg.dao;

import java.util.List;

import com.suguowen.avg.model.Person;

/*
 * mybatis一个接口只能给xml实现，不能自己再写实现，不然注解找不到类
 */
public interface IPersonMapper {
	public List<Person> selectUser();
	public Person selectPersonToObject();
	public int selectPersonCount();
	public int insertPerson();
}
