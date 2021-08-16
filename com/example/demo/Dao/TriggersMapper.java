package com.example.demo.Dao;

import com.example.demo.Model.TriggersWithBLOBs;

public interface TriggersMapper {
    int insert(TriggersWithBLOBs record);

    int insertSelective(TriggersWithBLOBs record);
}