package com.suguowen.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

public interface DynamicSQLMapper {
		//测试动态sql
		public Map selectUserByDynamicSQL(@Param("object")Object object);
		
		//测试动态sql两个参数
		public Map selectUserByDynamicSQLTwoParam(@Param("object1")Object object1,@Param("object2")Object object2);
		
		//测试动态sql多参数修改
		public void updateUserByDynamicSQL(@Param("object1")Object object1
				,@Param("object2")Object object2,@Param("object3")Object object3
				);
		
		//动态sql，foreach测试
		public List selectByUserForEach(@Param("set")Set set);

}
