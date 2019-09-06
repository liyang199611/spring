package com.liyang.service.impl;

import com.liyang.dao.ClubDao;
import com.liyang.dao.StudentDao;
import com.liyang.pojo.Club;
import com.liyang.pojo.Student;
import com.liyang.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component(value = "studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;
    @Autowired
    private ClubDao clubDao;
    @Transactional(propagation = Propagation.REQUIRED)
    public void addStu(Student student) {
        studentDao.addStu(student);
    }
}
