package com.example.demo.Dao;

import com.example.demo.Model.SysConfig;

public interface SysConfigMapper {
    int insert(SysConfig record);

    int insertSelective(SysConfig record);
}