package com.example.demo.Dao;

import com.example.demo.Model.Parameters;

public interface ParametersMapper {
    int insert(Parameters record);

    int insertSelective(Parameters record);
}