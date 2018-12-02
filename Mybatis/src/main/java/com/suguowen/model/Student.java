package com.suguowen.model;

import java.util.List;

public class Student {
	private String id;
	private String name;
	private String school;
	private School mySchool;
	/**
	 * @return the mySchool
	 */
	public School getMySchool() {
		return mySchool;
	}
	/**
	 * @param mySchool the mySchool to set
	 */
	public void setMySchool(School mySchool) {
		this.mySchool = mySchool;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the school
	 */
	public String getSchool() {
		return school;
	}
	/**
	 * @param school the school to set
	 */
	public void setSchool(String school) {
		this.school = school;
	}
	
	
}
