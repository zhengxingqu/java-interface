package com.example.demo.Dao;

import com.example.demo.Model.Student;

public interface StudentMapper {
    int insert(Student record);

    int insertSelective(Student record);
}