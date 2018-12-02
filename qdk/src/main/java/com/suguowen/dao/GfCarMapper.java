package com.suguowen.dao;

import com.suguowen.model.GfCar;
import com.suguowen.model.GfCarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GfCarMapper {
    long countByExample(GfCarExample example);

    int deleteByExample(GfCarExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(GfCar record);

    int insertSelective(GfCar record);

    List<GfCar> selectByExampleWithBLOBs(GfCarExample example);

    List<GfCar> selectByExample(GfCarExample example);

    GfCar selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") GfCar record, @Param("example") GfCarExample example);

    int updateByExampleWithBLOBs(@Param("record") GfCar record, @Param("example") GfCarExample example);

    int updateByExample(@Param("record") GfCar record, @Param("example") GfCarExample example);

    int updateByPrimaryKeySelective(GfCar record);

    int updateByPrimaryKeyWithBLOBs(GfCar record);

    int updateByPrimaryKey(GfCar record);
    
    /*
     * 更新车辆信息
     */
	public void updateCarMsg(int id, String varifyStatus, String varifyTime, String varifyRemark);
	
	/*
	 * 查看用户所有信息
	 */
	public List<GfCar> selectAll();
	/*
	 * 根据status查询用户所有信息
	 */
	public List<GfCar> selectByStatus(@Param("status")Integer status);

}