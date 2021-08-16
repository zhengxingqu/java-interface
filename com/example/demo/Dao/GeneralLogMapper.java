package com.example.demo.Dao;

import com.example.demo.Model.GeneralLogWithBLOBs;

public interface GeneralLogMapper {
    int insert(GeneralLogWithBLOBs record);

    int insertSelective(GeneralLogWithBLOBs record);
}