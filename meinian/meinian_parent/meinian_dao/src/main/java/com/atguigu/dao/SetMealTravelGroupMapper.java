package com.atguigu.dao;

import com.atguigu.pojo.SetMealTravelGroupExample;
import com.atguigu.pojo.SetMealTravelGroupKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SetMealTravelGroupMapper {
    long countByExample(SetMealTravelGroupExample example);

    int deleteByExample(SetMealTravelGroupExample example);

    int deleteByPrimaryKey(SetMealTravelGroupKey key);

    int insert(SetMealTravelGroupKey record);

    int insertSelective(SetMealTravelGroupKey record);

    List<SetMealTravelGroupKey> selectByExample(SetMealTravelGroupExample example);

    int updateByExampleSelective(@Param("record") SetMealTravelGroupKey record, @Param("example") SetMealTravelGroupExample example);

    int updateByExample(@Param("record") SetMealTravelGroupKey record, @Param("example") SetMealTravelGroupExample example);

    void batchInsert(@Param("travelGroupIds") Integer[] ids, @Param("setMealId") Integer id);

    Integer[] findCheckedTravelGroups(Integer id);

    void deleteItemsByTravelGroupId(Integer id);
}