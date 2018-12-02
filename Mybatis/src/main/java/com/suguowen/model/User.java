package com.suguowen.model;

import java.io.Serializable;

public class User implements Serializable{
	private int id;
	private String commend;
	private String description;
	private String content;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the commend
	 */
	public String getCommend() {
		return commend;
	}
	/**
	 * @param commend the commend to set
	 */
	public void setCommend(String commend) {
		this.commend = commend;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	
}
