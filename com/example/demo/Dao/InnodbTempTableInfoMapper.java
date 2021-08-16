package com.example.demo.Dao;

import com.example.demo.Model.InnodbTempTableInfo;

public interface InnodbTempTableInfoMapper {
    int insert(InnodbTempTableInfo record);

    int insertSelective(InnodbTempTableInfo record);
}