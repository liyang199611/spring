package com.liyang.service;

import com.liyang.dao.StudentDao;
import com.liyang.pojo.Club;
import com.liyang.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService{
    public void addStu(Student student);
    // 查询所有学生的详细信息
    public List<Student> getStudentsInfo();
}
