package com.suguowen.avg.dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.suguowen.avg.model.Person;

@Repository(value="personDao1")
public class PersonDao implements IPersonDao{
	@Resource(name="jdbcTemplate")
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Person> selectUser() {
		System.out.println("---进入da层---");
		String sql = "SELECT * FROM `person`";
		PersonRowmapper rowMapper = new PersonRowmapper();
		List<Person> listPerson = jdbcTemplate.query(sql, rowMapper);
		return listPerson;
	}

	@Override
	public int selectUserCount() {
		System.out.println("---进入da层---");
		String sql = "SELECT count(1) FROM `person`";
		int a = jdbcTemplate.queryForObject(sql, Integer.class);
		return a;
	}


}
