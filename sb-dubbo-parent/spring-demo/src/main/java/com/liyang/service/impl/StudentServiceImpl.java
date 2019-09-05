package com.liyang.service.impl;

import com.liyang.pojo.Student;
import com.liyang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component(value = "studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private Student student;
    @Override
    public void printStuInfo() {
        System.out.println(student.getName()+"++++"+student.getId());
    }
}
