package com.mashen.mybatis.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.mashen.mybatis.model.User;

/*
 * 功能：定义功能性接口
 * 关联：接口与同名xml关联
 */
public interface UserMapper {
	public int select();
	public int insert(); 
	public int update();
	public int delect();
	
	//一个参数
	public String selectUserById(int id);
	//两个参数
	public String selectUserDoubleParam(@Param("iid")int id,@Param("ccommend")String commend);
	//对象
	public String selectUserByObject(User user);
	
	//map
	public String selectUserByMap(Map<String, String> map) ;
	
	//数组
	public List<String> selectUserByList(@Param("lists")List lists);
	
}
