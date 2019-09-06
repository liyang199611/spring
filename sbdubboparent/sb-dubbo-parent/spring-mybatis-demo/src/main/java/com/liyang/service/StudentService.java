package com.liyang.service;

import com.liyang.dao.StudentDao;
import com.liyang.pojo.Club;
import com.liyang.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService{
    public void addStu(Student student);
}
