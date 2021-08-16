package com.example.demo.Dao;

import com.example.demo.Model.OptimizerTraceWithBLOBs;

public interface OptimizerTraceMapper {
    int insert(OptimizerTraceWithBLOBs record);

    int insertSelective(OptimizerTraceWithBLOBs record);
}