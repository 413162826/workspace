package com.suguowen.blog.model;

/*
 * 1.客户从网页输入这五项数据，通过Servlet获取后存进Bean
 * 2.返回Board到jsp
 * 3.现在有board和map传到了html，但如何迭代数据呢
 */
public class BoardBean {
	/*
	 * Board属性
	 * size,tr,tc,dr,dc,
	 * color,L板块
	 */
	private int size;
	private int tr;
	private int tc;
	private int dr;
	private int dc;
	
	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}
	/**
	 * @return the tr
	 */
	public int getTr() {
		return tr;
	}
	/**
	 * @param tr the tr to set
	 */
	public void setTr(int tr) {
		this.tr = tr;
	}
	/**
	 * @return the tc
	 */
	public int getTc() {
		return tc;
	}
	/**
	 * @param tc the tc to set
	 */
	public void setTc(int tc) {
		this.tc = tc;
	}
	/**
	 * @return the dr
	 */
	public int getDr() {
		return dr;
	}
	/**
	 * @param dr the dr to set
	 */
	public void setDr(int dr) {
		this.dr = dr;
	}
	/**
	 * @return the dc
	 */
	public int getDc() {
		return dc;
	}
	/**
	 * @param dc the dc to set
	 */
	public void setDc(int dc) {
		this.dc = dc;
	}
	
	
}
