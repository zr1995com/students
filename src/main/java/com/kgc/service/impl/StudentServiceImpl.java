package com.kgc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.entity.Class;
import com.kgc.entity.Student;
import com.kgc.entity.StudentExample;
import com.kgc.mapper.ClassMapper;
import com.kgc.mapper.StudentMapper;
import com.kgc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassMapper classMapper;
    @Override
    public PageInfo<Student> getStudentByPage(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);
        StudentExample example=new StudentExample();
        List<Student> list = studentMapper.selectByExample(example);
        for (int i=0;i<list.size();i++){
            Student student = list.get(i);
            Integer classid = student.getClassid();
            Class aClass =classMapper.selectByPrimaryKey(classid);
            student.setaClass(aClass);
        }
        PageInfo<Student> info=new PageInfo<>(list);
        return info;
    }
}
