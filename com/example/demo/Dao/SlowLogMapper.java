package com.example.demo.Dao;

import com.example.demo.Model.SlowLogWithBLOBs;

public interface SlowLogMapper {
    int insert(SlowLogWithBLOBs record);

    int insertSelective(SlowLogWithBLOBs record);
}