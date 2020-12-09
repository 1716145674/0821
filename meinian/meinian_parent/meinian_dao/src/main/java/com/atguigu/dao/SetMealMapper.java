package com.atguigu.dao;

import com.atguigu.pojo.SetMeal;
import com.atguigu.pojo.SetMealExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SetMealMapper {
    long countByExample(SetMealExample example);

    int deleteByExample(SetMealExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SetMeal record);

    int insertSelective(SetMeal record);

    List<SetMeal> selectByExample(SetMealExample example);

    SetMeal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SetMeal record, @Param("example") SetMealExample example);

    int updateByExample(@Param("record") SetMeal record, @Param("example") SetMealExample example);

    int updateByPrimaryKeySelective(SetMeal record);

    int updateByPrimaryKey(SetMeal record);

    SetMeal querySetMealDetailsById(Integer id);

    List<Map<String,Object>> getSetmealReport();
}