package com.suguowen.avg.model;

import java.io.Serializable;

public class Person implements Serializable{
	/*
	 * 角色基本信息
	 */
	
	private String name;
	private int attack;
	private int defense;
	private int blood;
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
	 * @return the attack
	 */
	public int getAttack() {
		return attack;
	}
	/**
	 * @param attack the attack to set
	 */
	public void setAttack(int attack) {
		this.attack = attack;
	}
	
	/**
	 * @return the defense
	 */
	public int getDefense() {
		return defense;
	}
	/**
	 * @param defense the defense to set
	 */
	public void setDefense(int defense) {
		this.defense = defense;
	}
	/**
	 * @return the blood
	 */
	public int getBlood() {
		return blood;
	}
	/**
	 * @param blood the blood to set
	 */
	public void setBlood(int blood) {
		this.blood = blood;
	}
	
	
}
