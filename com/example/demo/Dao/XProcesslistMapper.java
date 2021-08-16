package com.example.demo.Dao;

import com.example.demo.Model.XProcesslistWithBLOBs;

public interface XProcesslistMapper {
    int insert(XProcesslistWithBLOBs record);

    int insertSelective(XProcesslistWithBLOBs record);
}