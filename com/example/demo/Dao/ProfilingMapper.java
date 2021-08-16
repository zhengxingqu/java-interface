package com.example.demo.Dao;

import com.example.demo.Model.Profiling;

public interface ProfilingMapper {
    int insert(Profiling record);

    int insertSelective(Profiling record);
}