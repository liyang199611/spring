package com.liyang.pojo;

/**
 * 创建班级的实体类
 */
public class Club {
    private String classes; // 班级
    private String teacher; // 老师
    public String getTeacher() {
        return teacher;
    }

    public String getClasses() {
        return classes;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

}
