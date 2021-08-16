package com.example.demo.Dao;

import com.example.demo.Model.Func;

public interface FuncMapper {
    int insert(Func record);

    int insertSelective(Func record);
}