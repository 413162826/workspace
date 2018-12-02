package com.suguowen.bean;

import java.sql.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class User {
	private int id;
	private String name;
	@JSONField(format="yyyy-MM-dd")
	private String birth;
	private String sex;
	private String hobby;
	private String school;
	
	public User(int id,String name,String birth,String sex,String hobby,String school){
		super();
		this.id = id;
		this.name = name;
		this.birth = birth;
		this.sex = sex;
		this.hobby = hobby;
		this.school = school;
	}
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
	
	
}
