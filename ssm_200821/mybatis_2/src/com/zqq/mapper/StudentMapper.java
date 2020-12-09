package com.zqq.mapper;

import com.zqq.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     * 根据班级号 查询此班级的所有的学生的list集合
     */
    List<Student> queryStudentsByClassId(Integer classId);
    /**
     * 根据班级号,姓名模糊查询 查询此班级的所有的学生的list集合
     */
    List<Student> queryStudentsByClassIdAndLikeName( @Param("classId") Integer classId,
                                                     @Param("studentName") String studentName);
}
