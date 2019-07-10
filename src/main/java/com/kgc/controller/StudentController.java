package com.kgc.controller;

import com.github.pagehelper.PageInfo;
import com.kgc.entity.Student;
import com.kgc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/ccc")
    @ResponseBody
    public Map<String,Object> ccc(Integer page,Integer rows){
        PageInfo<Student> info = studentService.getStudentByPage(page, rows);
        Map<String,Object> map=new HashMap<>();
        map.put("total",info.getTotal());
        map.put("rows",info.getList());
        return map;
    }
}
