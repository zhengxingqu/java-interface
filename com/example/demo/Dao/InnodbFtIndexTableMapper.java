package com.example.demo.Dao;

import com.example.demo.Model.InnodbFtIndexTable;

public interface InnodbFtIndexTableMapper {
    int insert(InnodbFtIndexTable record);

    int insertSelective(InnodbFtIndexTable record);
}