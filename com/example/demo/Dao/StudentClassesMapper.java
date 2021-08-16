package com.example.demo.Dao;

import com.example.demo.Model.StudentClasses;

public interface StudentClassesMapper {
    int insert(StudentClasses record);

    int insertSelective(StudentClasses record);
}