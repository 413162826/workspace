package com.mashen.blog.model;

import java.security.KeyStore.PrivateKeyEntry;
import java.util.List;

public class PageBean {
	private int currentPage;//当前页面
	private int totalPage;//总页面、
	private int pageSize;//页面显示记录数
	private int totalRecord;//总记录数
	private List<User> ulist;//用户列表
	
	public PageBean(int currentPage,int pageSize,int totalRecord) { 
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalRecord = totalRecord;
		if (totalRecord%pageSize == 0) {
			this.totalPage = totalRecord/pageSize;
		}else {
			this.totalPage = totalRecord/pageSize + 1;
		}
	}

	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the totalRecord
	 */
	public int getTotalRecord() {
		return totalRecord;
	}

	/**
	 * @param totalRecord the totalRecord to set
	 */
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	/**
	 * @return the ulist
	 */
	public List<User> getUlist() {
		return ulist;
	}

	/**
	 * @param ulist the ulist to set
	 */
	public void setUlist(List<User> ulist) {
		this.ulist = ulist;
	}
	
}
