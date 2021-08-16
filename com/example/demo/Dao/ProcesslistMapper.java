package com.example.demo.Dao;

import com.example.demo.Model.ProcesslistWithBLOBs;

public interface ProcesslistMapper {
    int insert(ProcesslistWithBLOBs record);

    int insertSelective(ProcesslistWithBLOBs record);
}