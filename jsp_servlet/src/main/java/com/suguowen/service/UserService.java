package com.suguowen.service;

import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.suguowen.bean.User;
import com.suguowen.dao.UserDao;

public class UserService {
	
	private UserDao userDao = new UserDao();
	
	//增加用户
	public String add(User uu){
		boolean flag = userDao.addOne(uu);
		if(flag){
			return "恭喜！！成功新增一条记录";
		}else{
			return "抱歉，新增失败...";
		}
	}
	
	//删除用户
	public String del(int id){
		boolean flag  = userDao.delById(id);
		if(flag){
			return "恭喜！！成功删除一条记录";
		}else{
			return "抱歉，删除失败...";
		}
	}
	
	//更新用户
	public String update(User uu){
		boolean flag = userDao.updateById(uu);
		if(flag){
			return "恭喜！！成功更新一条记录";
		}else{
			return "抱歉，更新失败...";
		}
	}
	
	//查询1(id查询)用户
	public String selectUserById(int id){
		User uu = userDao.queryById(id);
		String userJson = JSON.toJSONString(uu);
		return userJson;
	}
	//查询2(all查询)用户(返回list，不是json哦)
	public ArrayList<User> selectAllUser(){
		ArrayList<User> uuList = userDao.queryAll(1);
		return uuList;
	}

	/**
	 * 
	 * @description 校验前端传来的数据
	 * 
	 */
	public void check() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * 
	 * @description 通过id name school 模糊匹配User，用AND查询
	 */
	public String selectUserByPattern(String id, String name, String school,int page) {
		if(id.equals("") && name.equals("") && school.equals("")){
			//all
			List<User> uuList = userDao.queryAll(page);
			int count = userDao.queryAllCount();
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}else if((!id.equals("")) && name .equals("") && school.equals("")){
			//id
			List<User> uuList = userDao.queryByPattern_Id(id,page);
			int count = userDao.queryByPattern_Id_Count(id);
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}else if((!id .equals("")) && (!name.equals("")) && school.equals("")){
			//id + name
			List<User> uuList = userDao.queryByPattern_id_name(id,name,page);
			int count = userDao.queryByPattern_id_name_Count(id, name);
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}else if((!id.equals("")) && (!name.equals("")) && (!school.equals(""))){
			//id + name + school
			List<User> uuList = userDao.queryByPattern_id_name_school(id,name,school,page);
			int count = userDao.queryByPattern_id_name_school_Count(id, name, school);
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}else if((!id.equals("")) && name.equals("") && (!school.equals(""))){
			//id + school
			List<User> uuList = userDao.queryByPattern_id_school(id,school,page);
			int count = userDao.queryByPattern_id_school_Count(id, school);
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}else if(id.equals("") && (!name.equals("")) && (!school.equals(""))){
			//name + school
			List<User> uuList = userDao.queryByPattern_name_school(name,school,page);
			int count = userDao.queryByPattern_name_school_Count(name, school);
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}else if(id.equals("") && (!name .equals("")) && school.equals("")){
			//name
			List<User> uuList = userDao.queryByPattern_name(name,page);
			int count = userDao.queryByPattern_name_Count(name);
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}else if(id.equals("") && name.equals("") && (!school.equals(""))){
			//school
			List<User> uuList = userDao.queryByPattern_school(school,page);
			int count = userDao.queryByPattern_school_Count(school);
			String userJson = JSON.toJSONString(uuList)+","+count;
			return userJson;
		}
		return null;
	}

	/**
	 * 
	 * @description 检查新增用户
	 * 	id：4位纯数字
	 * name：4-30个以字母开头的字串
	 * birth：yyyy MM dd格式
	 * 
	 */
	public void addCheck(String id, String name, String birth, String sex,
			String hobby, String school) {
		// TODO Auto-generated method stub
		
	}

}
