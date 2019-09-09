package com.liyang.dao;

import com.liyang.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {
    public void addStu(@Param("stu") Student student);

    // 获取学生详细信息
    public List<Student> getStudentsInfo();
}
