package com.suguowen.model;

import java.util.List;

public class School {
	private String name;
	private String address;
	private Student student;
	private List studentList;
	//加list，不然接收不了更多数据
	
	/**
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @return the studentList
	 */
	public List getStudentList() {
		return studentList;
	}
	/**
	 * @param studentList the studentList to set
	 */
	public void setStudentList(List studentList) {
		this.studentList = studentList;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
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
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
