package com.suguowen.avg.dao;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;

import com.suguowen.avg.model.Person;

public interface IPersonDao {
	public List<Person> selectUser();
	public int selectUserCount();
}
