package com.example.demo.Dao;

import com.example.demo.Model.StatementsWithRuntimesIn95thPercentileWithBLOBs;

public interface StatementsWithRuntimesIn95thPercentileMapper {
    int insert(StatementsWithRuntimesIn95thPercentileWithBLOBs record);

    int insertSelective(StatementsWithRuntimesIn95thPercentileWithBLOBs record);
}