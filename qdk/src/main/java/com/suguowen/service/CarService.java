package com.suguowen.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suguowen.dao.GfCarMapper;
import com.suguowen.model.GfCar;

@Service
public class CarService {
	
	@Autowired
	GfCarMapper gfCarMapper;

	public void modifyData(int id, String varifyStatus, String varifyTime, String varifyRemark) {
		System.out.println("======进入service层=====");
		gfCarMapper.updateCarMsg(id,varifyStatus,varifyTime,varifyRemark);
	}
	/*
	 * 根据status查询用户所有信息
	 * 返回0状态
	 */
	public List<GfCar> getUnCheckCarMsg() {
		System.out.println("======进入service层=====");
		List<GfCar> list = gfCarMapper.selectByStatus(0);
		return list;
	}

	public GfCar getCarDetailMsg(Integer id) {
		System.out.println("======进入service层=====");
		GfCar gfCar = gfCarMapper.selectByPrimaryKey(id);
		return gfCar;
	}
	
}
