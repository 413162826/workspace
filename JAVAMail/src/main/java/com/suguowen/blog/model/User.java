package com.suguowen.blog.model;

/*
 * 项目目的：当用户注册成功的时候，给用户发送一封邮件
 * 注册JSP，注册Servlet，用户Bean，发送邮件Service，
 */
public class User {
	private String userName;
	private String password;
	private String mail;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	
	
}
