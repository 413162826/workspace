package com.suguowen.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.suguowen.model.GfCar;
import com.suguowen.model.Msg;
import com.suguowen.service.CarService;

@Controller
@RequestMapping("/check")
public class CarController{
	
	private static final HttpMessage req = null;
	@Autowired
	CarService CarService;
	
	//根据id获取 car的所有信息
	@RequestMapping("/detailMsg/{id}")
	@ResponseBody
	public Msg getDetailMsg(@PathVariable("id")int id) {
		System.out.println("=========进入controller==========");
		GfCar gfCar = CarService.getCarDetailMsg(id);
		
		return Msg.success().add("pageInfo", gfCar);
	}
	/*
	 * radio:审核情况,1审核成功,2审核失败,空值为审核中
	 * remark:修改建议
	 * 修改时间
	 */
	/*
	 * 修改数据
	 */
	@RequestMapping("/check")
	@ResponseBody
	public String check(/*String radio,String remark*/ HttpServletRequest request) {
		System.out.println("=========进入controller==========");	
		
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		String date = df.format(new Date());
		
		String idstr = request.getParameter("id");
		int id = Integer.parseInt(idstr);
		String varifyStatus = request.getParameter("radio");
		String varifyTime = date;
		String varifyRemark = request.getParameter("remark");
		
		System.out.println("varifyStatus:"+varifyStatus+";varifyTime:"+varifyTime+";varifyRemark:"+varifyRemark);
		//调用service
		CarService.modifyData(id,varifyStatus,varifyTime,varifyRemark);
		return "check successful！！";
	}
	
	@RequestMapping("/showCarMsg")
	@ResponseBody
	public Msg showUnCheckCarMsg() {
		System.out.println("=========进入controller==========");
		List<GfCar> list = CarService.getUnCheckCarMsg();
		
		PageInfo<GfCar> pageInfo = new PageInfo<>(list);
		
		return Msg.success().add("pageInfo", pageInfo);
	}
}
