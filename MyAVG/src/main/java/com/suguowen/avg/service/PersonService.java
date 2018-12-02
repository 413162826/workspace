package com.suguowen.avg.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.suguowen.avg.dao.IPersonDao;
import com.suguowen.avg.dao.IPersonMapper;
import com.suguowen.avg.model.Person;
@Service(value="personService")
public class PersonService {
	@Resource(name="personDao1")
	IPersonDao personDao;
	@Resource
	IPersonMapper personMapper;
	
	public void selectUser() {
		System.out.println("---进入service层---");
		List<Person> listPserson = personDao.selectUser();
		for (Person person : listPserson) {
			System.out.println("--角色--");
			System.out.println("name:"+person.getName());
			System.out.println("attack:"+person.getAttack());
			System.out.println("defense:"+person.getDefense());
			System.out.println("blood:"+person.getBlood());
		}
	}
	
	@Cacheable(cacheNames="selectUserByCount")
	public int selectPersonCount() {
		System.out.println("---进入service层---");
		int a = personDao.selectUserCount();
		return a;
	}
	
	public int selectPersonCountByMapper() {
		System.out.println("---进入service层---");
		int a = personMapper.selectPersonCount();
		return a;
	}
	
	public int insertPerson() {
		System.out.println("---进入service层---");
		int a = personMapper.insertPerson();
		int bugTest = 1/0;
		return a;
		
	}
}
