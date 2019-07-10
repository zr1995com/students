package com.kgc.service;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Student;

public interface StudentService {
    public PageInfo<Student> getStudentByPage(Integer page,Integer rows);
}
