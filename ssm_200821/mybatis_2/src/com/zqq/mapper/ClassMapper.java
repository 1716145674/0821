package com.zqq.mapper;

import com.zqq.pojo.Class;
import org.apache.ibatis.annotations.Param;

public interface ClassMapper {
    /**
     * 根据班级id 一次性的查找此班级及其班级中的所有的学生
     */
    Class queryClassAndStudentsByClassId(Integer classId);

    /**
     *  根据班级id 分步查询 并使用懒加载机制延迟加载
     */
    Class queryClassAndStudentsByClassIdWithTwoStep(Integer classId);
    /**
     *  根据班级id 模糊name 模糊查询 分步查询 并使用懒加载机制延迟加载
     */
    Class queryClassAndStudentsByClassIdAndLikeNameWithTwoStep(Integer classId);
}
