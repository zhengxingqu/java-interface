package com.example.demo.Dao;

import com.example.demo.Model.InnodbSysTables;

public interface InnodbSysTablesMapper {
    int insert(InnodbSysTables record);

    int insertSelective(InnodbSysTables record);
}