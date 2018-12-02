package com.suguowen.avg.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.suguowen.avg.model.Person;

public class PersonRowmapper implements RowMapper<Person>{

	@Override
	public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
		Person user = new Person();
        user.setName(rs.getString("name"));
        user.setAttack(rs.getInt("attack"));
        user.setDefense(rs.getInt("defense"));
        user.setBlood(rs.getInt("blood"));
        
        return user;
	}
	
}
