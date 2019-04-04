package com.mybatis.dao;

import com.mybatis.bean.Student;

public interface StudentDao {
    void insertStudent(Student student);
    void deleteStudent(int id);
}
